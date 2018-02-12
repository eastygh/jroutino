package ru.easty.java.routino;

/**
 * Created by belyakovcev_em on 31.01.2018.
 */

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.*;
import ru.easty.java.routino.structs.RoutinoOutput;
import ru.easty.java.routino.structs.RoutinoWaypoint;

import java.util.List;

public interface RoutinoLib extends Library
{
	RoutinoLib INSTANCE = ( RoutinoLib )
			Native.loadLibrary( ( Platform.isWindows() ? "routino" : "routino" ),
					RoutinoLib.class );

	/**
	 * @param caller_version
	 * @return
	 */
	int Routino_Check_API_Version( int caller_version );

	/**
	 * @param dirname
	 * @param prefix
	 * @return
	 */
	Pointer Routino_LoadDatabase( Memory dirname, Memory prefix );

	/**
	 * @param database
	 */
	void Routino_UnloadDatabase( Pointer database );

	/**
	 * Load and parse xml file with translation
	 *
	 * @param filename
	 * @return
	 */
	int Routino_ParseXMLTranslations( Memory filename );

	/**
	 * Free memory for loaded XML Translations file
	 */
	void Routino_FreeXMLTranslations();

	/**
	 * Get translation pointer reference
	 *
	 * @param language
	 * @return
	 */
	Pointer Routino_GetTranslation( Memory language );

	/**
	 * Load and parse xml file with preset profiles
	 *
	 * @param filename
	 * @return
	 */
	int Routino_ParseXMLProfiles( Memory filename );

	/**
	 * Free memory for loaded XML Profiles file
	 */
	void Routino_FreeXMLProfiles();

	/**
	 * Get profile pointer reference
	 *
	 * @param name
	 * @return
	 */
	Pointer Routino_GetProfile( Memory name );

	/**
	 * Validate routing profile.
	 *
	 * @param database
	 * @param profile
	 * @return
	 */
	int Routino_ValidateProfile( Pointer database, Pointer profile );

	Pointer Routino_FindWaypoint( Pointer database, Pointer profile, double latitude, double longitude );

	Pointer Routino_CalculateRoute( Pointer database, Pointer profile, Pointer translation,
			Pointer[] waypoints, int nwaypoints, int options, Pointer progress );

	/**
	 * Remove memory allocation \
	 * @param output @tag pointer of route set
	 */
	void Routino_DeleteRoute(Pointer output);
}
