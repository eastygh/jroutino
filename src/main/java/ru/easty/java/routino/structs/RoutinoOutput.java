package ru.easty.java.routino.structs;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * Created by belyakovcev_em on 02.02.2018.
 */
public class RoutinoOutput extends Structure
{
	public Pointer next;         /*+ A pointer to the next route section. +*/

	public float lon;          /*+ The longitude of the point (radians). +*/
	public float lat;          /*+ The latitude of the point (radians). +*/

	public float dist;         /*+ The total distance travelled (kilometres) up to the point. +*/
	public float time;         /*+ The total journey time (seconds) up to the point. +*/

	public float speed;        /*+ The speed (km/hr) for this section of the route (ROUTINO_ROUTE_LIST_TEXT_ALL format only). +*/

	public int type;         /*+ The type of point (one of the ROUTINO_POINT_* values). +*/

	public int turn;         /*+ The amount to turn (degrees) for the next section of the route (ROUTINO_ROUTE_LIST_TEXT or ROUTINO_ROUTE_LIST_HTML or ROUTINO_ROUTE_LIST_HTML_ALL format). +*/
	public int bearing;      /*+ The compass direction (degrees) for the next section of the route. +*/

	public String name;         /*+ The name of the next section of the route (ROUTINO_ROUTE_LIST_TEXT or ROUTINO_ROUTE_LIST_HTML or ROUTINO_ROUTE_LIST_HTML_ALL format) or previous section of the route (ROUTINO_ROUTE_LIST_TEXT_ALL format). +*/

	public String desc1;        /*+ The first part of the description of the next section of route (ROUTINO_ROUTE_LIST_HTML or ROUTINO_ROUTE_LIST_HTML format). +*/
	public String desc2;        /*+ The second part of the description of the next section of route (ROUTINO_ROUTE_LIST_HTML or ROUTINO_ROUTE_LIST_HTML format). +*/
	public String desc3;        /*+ The third part of the description, the total distance and time at the end of the next section of route (ROUTINO_ROUTE_LIST_HTML or ROUTINO_ROUTE_LIST_HTML format). +*/

	public RoutinoOutput( Pointer p )
	{
		super( p );
		read();
	}

	@Override
	protected List<String> getFieldOrder()
	{
		return Arrays
				.asList( "next", "lon", "lat", "dist", "time", "speed", "type", "turn", "bearing", "name", "desc1", "desc2", "desc3" );
	}
}
