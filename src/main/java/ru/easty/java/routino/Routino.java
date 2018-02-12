package ru.easty.java.routino;

import com.sun.jna.*;
import ru.easty.java.routino.structs.RoutinoOutput;
import ru.easty.java.routino.structs.RoutinoWaypoint;
import ru.easty.java.routino.types.RoutePoint;

import java.util.ArrayList;

/**
 * Created by belyakovcev_em on 30.01.2018.
 */

public class Routino extends RoutinoBase
{
	private Pointer routinoDatabase;

	private Pointer refProfile;
	private Pointer refTranslation;

	private String dbPath;
	private String dbPrefix;

	private String translationFileName;
	private String profilesFileName;

	private boolean metaDataLoaded = false;

	private void initConfig()
	{
		dbPath = "";
		dbPrefix = "";
		if( Platform.isWindows() )
		{
			translationFileName = "C:\\Program Files\\Routino\\xml\\translations.xml";
			profilesFileName = "C:\\Program Files\\Routino\\xml\\profiles.xml";
		}
		else
		{
			translationFileName = "/usr/local/share/routino/translations.xml";
			profilesFileName = "/usr/local/share/routino/profiles.xml";
		}
	}

	/**
	 * Return memory set for JNA *char calling
	 *
	 * @param str
	 * @return
	 */
	private Memory getNullTerminatedString( String str )
	{
		Memory res = new Memory( str.getBytes().length + 1 );
		res.setString( 0, str );
		return res;
	}

	/**
	 *
	 */
	public Routino()
	{
		initConfig();
	}

	/**
	 * @param _dbPath
	 * @param _dbPrefix
	 */
	public Routino( String _dbPath, String _dbPrefix )
	{
		initConfig();
		dbPath = _dbPath;
		dbPrefix = _dbPrefix;
	}

	/**
	 * @param _dbPath
	 * @param _dbPrefix
	 * @return
	 */
	public boolean open( String _dbPath, String _dbPrefix )
	{
		if( !isMetaDataLoaded() )
		{
			loadMetaData();
		}
		if( _dbPath == null || _dbPrefix == null )
		{
			return false;
		}
		if( routinoDatabase != null )
		{
			close();
		}

		dbPath = _dbPath;
		dbPrefix = _dbPrefix;

		routinoDatabase = RoutinoLib.INSTANCE
				.Routino_LoadDatabase( getNullTerminatedString( dbPath ), getNullTerminatedString( dbPrefix ) );

		return routinoDatabase != null;
	}

	/**
	 * @return
	 */
	public boolean open()
	{
		return open( dbPath, dbPrefix );
	}

	/**
	 * @return
	 */
	public boolean close()
	{
		if( routinoDatabase != null )
		{
			RoutinoLib.INSTANCE.Routino_UnloadDatabase( routinoDatabase );
			routinoDatabase = null;
		}
		return true;
	}

	public int loadMetaData( String _translationFileName, String _profilesFileName )
	{
		metaDataLoaded = false;
		int err;

		RoutinoLib.INSTANCE.Routino_FreeXMLTranslations();

		err = RoutinoLib.INSTANCE.Routino_ParseXMLTranslations( getNullTerminatedString( _translationFileName ) );

		if( err != RoutinoConsts.ROUTINO_ERROR_NONE )
		{
			return err;
		}

		RoutinoLib.INSTANCE.Routino_FreeXMLProfiles();

		err = RoutinoLib.INSTANCE.Routino_ParseXMLProfiles( getNullTerminatedString( _profilesFileName ) );

		if( err != RoutinoConsts.ROUTINO_ERROR_NONE )
		{
			return err;
		}

		metaDataLoaded = true;
		return err;
	}

	/**
	 * load metadata for routing handle. translation, profile, etc...
	 *
	 * @return
	 */
	public int loadMetaData()
	{
		return loadMetaData( translationFileName, profilesFileName );
	}

	/**
	 * is meta data loaded?
	 *
	 * @return
	 */
	public boolean isMetaDataLoaded()
	{
		return metaDataLoaded;
	}

	/**
	 * Set profile for route calculating. foot horse car etc. see profiles.xml
	 *
	 * @param _profileName
	 * @return
	 */
	public boolean setProfileByName( String _profileName )
	{
		if( !isMetaDataLoaded() )
		{
			return false;
		}

		refProfile = RoutinoLib.INSTANCE.Routino_GetProfile( getNullTerminatedString( _profileName ) );

		return refProfile != null;
	}

	/**
	 * Set language for result data en ru etc
	 *
	 * @param _translateName
	 * @return
	 */
	public boolean setTranslateByName( String _translateName )
	{
		if( !isMetaDataLoaded() )
		{
			return false;
		}

		refTranslation = RoutinoLib.INSTANCE.Routino_GetTranslation( getNullTerminatedString( _translateName ) );

		return refTranslation != null;
	}

	/**
	 *  Calculate route between two points
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @return
	 */
	public ArrayList<RoutePoint> Calculate( double lat1, double lon1, double lat2, double lon2 )
	{
		Pointer wpStart;
		Pointer wpStop;
		Pointer resultCalc;

		wpStart = RoutinoLib.INSTANCE.Routino_FindWaypoint( routinoDatabase, refProfile, lat1, lon1 );
		wpStop = RoutinoLib.INSTANCE.Routino_FindWaypoint( routinoDatabase, refProfile, lat2, lon2 );

		if( wpStart == null || wpStop == null )
		{
			return null;
		}

		Pointer[] points = new Pointer[2];
		points[0] = wpStart;
		points[1] = wpStop;

		int options = RoutinoConsts.ROUTINO_ROUTE_SHORTEST | RoutinoConsts.ROUTINO_ROUTE_LIST_TEXT_ALL;
		resultCalc = RoutinoLib.INSTANCE
				.Routino_CalculateRoute( routinoDatabase, refProfile, refTranslation, points, 2, options, null );

		if( resultCalc == null )
		{
			// error calculating or route not found
			return null;
		}

		ArrayList<RoutePoint> routePoints = new ArrayList<>();

		try {
			RoutinoOutput fNode = new RoutinoOutput( resultCalc ); // get first node


			while( fNode.next != null )
			{
				RoutePoint rp = new RoutePoint( fNode );
				routePoints.add( rp );
				fNode = new RoutinoOutput( fNode.next );
			}

		} finally
		{
			RoutinoLib.INSTANCE.Routino_DeleteRoute( resultCalc );
		}


		return routePoints;
	}

	public int validateMetaData()
	{
		if( routinoDatabase == null || refProfile == null )
		{
			return RoutinoConsts.ROUTINO_ERROR_PROFILE_DATABASE_ERR;
		}
		return RoutinoLib.INSTANCE.Routino_ValidateProfile( routinoDatabase, refProfile );
	}

}
