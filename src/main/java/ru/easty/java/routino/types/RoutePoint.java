package ru.easty.java.routino.types;

import ru.easty.java.routino.structs.RoutinoOutput;

/**
 * Created by belyakovcev_em on 02.02.2018.
 */
public class RoutePoint
{
	public double lon;          /*+ The longitude of the point (radians). +*/
	public double lat;          /*+ The latitude of the point (radians). +*/

	public double dist;         /*+ The total distance travelled (kilometres) up to the point. +*/
	public double time;         /*+ The total journey time (seconds) up to the point. +*/

	public double speed;        /*+ The speed (km/hr) for this section of the route (ROUTINO_ROUTE_LIST_TEXT_ALL format only). +*/

	public int type;         /*+ The type of point (one of the ROUTINO_POINT_* values). +*/

	public int turn;         /*+ The amount to turn (degrees) for the next section of the route (ROUTINO_ROUTE_LIST_TEXT or ROUTINO_ROUTE_LIST_HTML or ROUTINO_ROUTE_LIST_HTML_ALL format). +*/
	public int bearing;      /*+ The compass direction (degrees) for the next section of the route. +*/

	public String name;

	public RoutePoint()
	{

	}

	public RoutePoint( RoutinoOutput data )
	{
		lon = radiansToDegrees( data.lon );
		lat = radiansToDegrees( data.lat );
		dist = data.dist;
		time = data.time;
		speed = data.speed;
		name = data.name;
		type = data.type;
		bearing = data.bearing;
		turn = data.turn;
	}

	public static double radiansToDegrees( double radian )
	{
		return radian * ( 180.0f / Math.PI );
	}

	public static double degreesToRadians( double radian )
	{
		return radian * ( Math.PI / 180.0f );
	}

}
