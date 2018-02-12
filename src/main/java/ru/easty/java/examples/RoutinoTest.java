package ru.easty.java.examples;

import ru.easty.java.routino.Routino;
import ru.easty.java.routino.RoutinoLib;
import ru.easty.java.routino.structs.RoutinoOutput;
import ru.easty.java.routino.types.RoutePoint;

import java.util.ArrayList;

/**
 * Created by belyakovcev_em on 31.01.2018.
 */
public class RoutinoTest
{
	public static void main( String[] args )
	{
		//System.out.print( RoutinoLib.INSTANCE.Routino_Check_API_Version( 5 ));
		Routino osm = new Routino( "c:/Work/osm/data", "krd" );
		if( osm.open() )
		{
			System.out.println( "success" );
			if( osm.isMetaDataLoaded() && osm.setProfileByName( "motorcar" ) && osm.setTranslateByName( "en" ) )
			{
				System.out.println( "meta data loaded" );
				System.out.println( "Result of validate metadata - " + osm.validateMetaData() );
				ArrayList<RoutePoint> out = osm.Calculate( 45.0685923, 39.0066556, 45.0605749, 39.0159897 );
				if( out != null )
				{
					for( RoutePoint rp : out
							)
					{
						String name = "";
						if( rp.name != null )
						{
							name = rp.name;
						}
						System.out.print( "Point " + "lat: " + rp.lat + " lon: " + rp.lon + " name: " + rp.name);
						System.out.println ( " distance: " + rp.dist);
					}
				}
			}
		}
		else
		{
			System.out.println( "error" );
		}

		osm.close();
	}
}
