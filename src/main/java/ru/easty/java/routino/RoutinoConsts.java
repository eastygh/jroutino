package ru.easty.java.routino;

/**
 * Created by belyakovcev_em on 01.02.2018.
 */
public class RoutinoConsts
{
 /* Routino library API version */

	public static final int ROUTINO_API_VERSION = 8;/*+ A version number for the Routino API. +*/


 /* Routino error constants */

	public static final int ROUTINO_ERROR_NONE = 0;/*+ No error. +*/

	public static final int ROUTINO_ERROR_NO_DATABASE = 1;/*+ A function was called without the database variable set. +*/
	public static final int ROUTINO_ERROR_NO_PROFILE = 2;/*+ A function was called without the profile variable set. +*/
	public static final int ROUTINO_ERROR_NO_TRANSLATION = 3;/*+ A function was called without the translation variable set. +*/

	public static final int ROUTINO_ERROR_NO_DATABASE_FILES = 11;/*+ The specified database to load did not exist. +*/
	public static final int ROUTINO_ERROR_BAD_DATABASE_FILES = 12;/*+ The specified database could not be loaded. +*/
	public static final int ROUTINO_ERROR_NO_PROFILES_XML = 13;/*+ The specified profiles XML file did not exist. +*/
	public static final int ROUTINO_ERROR_BAD_PROFILES_XML = 14;/*+ The specified profiles XML file could not be loaded. +*/
	public static final int ROUTINO_ERROR_NO_TRANSLATIONS_XML = 15;/*+ The specified translations XML file did not exist. +*/
	public static final int ROUTINO_ERROR_BAD_TRANSLATIONS_XML = 16;/*+ The specified translations XML file could not be loaded. +*/

	public static final int ROUTINO_ERROR_NO_SUCH_PROFILE = 21;/*+ The requested profile name does not exist in the loaded XML file. +*/
	public static final int ROUTINO_ERROR_NO_SUCH_TRANSLATION = 22;/*+ The requested translation language does not exist in the loaded XML file. +*/

	public static final int ROUTINO_ERROR_NO_NEARBY_HIGHWAY = 31;/*+ There is no highway near the coordinates to place a waypoint. +*/

	public static final int ROUTINO_ERROR_PROFILE_DATABASE_ERR = 41; /*+ The profile and database do not work together. +*/
	public static final int ROUTINO_ERROR_NOTVALID_PROFILE = 42; /*+ The profile being used has not been validated. +*/
	public static final int ROUTINO_ERROR_BAD_USER_PROFILE = 43; /*+ The user specified profile contained invalid data. +*/

	public static final int ROUTINO_ERROR_BAD_OPTIONS = 51; /*+ The routing options specified are not consistent with each other. +*/

	public static final int ROUTINO_ERROR_WRONG_API_VERSION = 61; /*+ There is a mismatch between the library and caller API version. +*/

	public static final int ROUTINO_ERROR_PROGRESS_ABORTED = 71; /*+ The progress function returned false. +*/

	public static final int ROUTINO_ERROR_NO_ROUTE_1 = 1001; /*+ A route could not be found to waypoint 1. +*/
	public static final int ROUTINO_ERROR_NO_ROUTE_2 = 1002; /*+ A route could not be found to waypoint 2. +*/
	public static final int ROUTINO_ERROR_NO_ROUTE_3 = 1003; /*+ A route could not be found to waypoint 3. +*/
/*  Higher values of the error number refer to later waypoints. */


 /* Routino routing option constants */

	public static final int ROUTINO_ROUTE_SHORTEST = 0; /*+ Calculate the shortest route. +*/
	public static final int ROUTINO_ROUTE_QUICKEST = 1; /*+ Calculate the quickest route. +*/

	public static final int ROUTINO_ROUTE_FILE_HTML = 2; /*+ Output an HTML route file. +*/
	public static final int ROUTINO_ROUTE_FILE_GPX_TRACK = 4; /*+ Output a GPX track file. +*/
	public static final int ROUTINO_ROUTE_FILE_GPX_ROUTE = 8; /*+ Output a GPX route file. +*/
	public static final int ROUTINO_ROUTE_FILE_TEXT = 16; /*+ Output a text file with important junctions. +*/
	public static final int ROUTINO_ROUTE_FILE_TEXT_ALL = 32; /*+ Output a text file with all nodes and segments. +*/

	public static final int ROUTINO_ROUTE_FILE_STDOUT = 64; /*+ Output a single file type to stdout. +*/

	public static final int ROUTINO_ROUTE_LIST_HTML = 128; /*+ Output a linked list of points containing the HTML file information but as plain text. +*/
	public static final int ROUTINO_ROUTE_LIST_HTML_ALL = 256; /*+ Output a linked list of points containing the HTML file information as plain text and with all points. +*/
	public static final int ROUTINO_ROUTE_LIST_TEXT = 512; /*+ Output a linked list of points containing the text file information. +*/
	public static final int ROUTINO_ROUTE_LIST_TEXT_ALL = 1024; /*+ Output a linked list of points containing the text all file information. +*/

	public static final int ROUTINO_ROUTE_LOOP = 2048; /*+ Route between the points in a loop returning to the first point. +*/
	public static final int ROUTINO_ROUTE_REVERSE = 4096; /*+ Route between the points in reverse order. +*/


 /* Routino output point types */

	public static final int ROUTINO_POINT_UNIMPORTANT = 0;      /*+ An unimportant, intermediate, node. +*/
	public static final int ROUTINO_POINT_RB_NOT_EXIT = 1;      /*+ A roundabout exit that is not taken. +*/
	public static final int ROUTINO_POINT_JUNCT_CONT = 2;      /*+ An un-interesting junction where the route continues without comment. +*/
	public static final int ROUTINO_POINT_CHANGE = 3;      /*+ The highway changes type but nothing else happens. +*/
	public static final int ROUTINO_POINT_JUNCT_IMPORT = 4;      /*+ An interesting junction to be described. +*/
	public static final int ROUTINO_POINT_RB_ENTRY = 5;      /*+ The entrance to a roundabout. +*/
	public static final int ROUTINO_POINT_RB_EXIT = 6;      /*+ The exit from a roundabout. +*/
	public static final int ROUTINO_POINT_MINI_RB = 7;      /*+ The location of a mini-roundabout. +*/
	public static final int ROUTINO_POINT_UTURN = 8;      /*+ The location of a U-turn. +*/
	public static final int ROUTINO_POINT_WAYPOINT = 9;      /*+ A waypoint. +*/


 /* Routino user profile array indexes */

	public static final int ROUTINO_HIGHWAY_MOTORWAY = 1; /*+ A Motorway highway. +*/
	public static final int ROUTINO_HIGHWAY_TRUNK = 2; /*+ A Trunk highway. +*/
	public static final int ROUTINO_HIGHWAY_PRIMARY = 3; /*+ A Primary highway. +*/
	public static final int ROUTINO_HIGHWAY_SECONDARY = 4; /*+ A Secondary highway. +*/
	public static final int ROUTINO_HIGHWAY_TERTIARY = 5; /*+ A Tertiary highway. +*/
	public static final int ROUTINO_HIGHWAY_UNCLASSIFIED = 6; /*+ A Unclassified highway. +*/
	public static final int ROUTINO_HIGHWAY_RESIDENTIAL = 7; /*+ A Residential highway. +*/
	public static final int ROUTINO_HIGHWAY_SERVICE = 8; /*+ A Service highway. +*/
	public static final int ROUTINO_HIGHWAY_TRACK = 9; /*+ A Track highway. +*/
	public static final int ROUTINO_HIGHWAY_CYCLEWAY = 10; /*+ A Cycleway highway. +*/
	public static final int ROUTINO_HIGHWAY_PATH = 11; /*+ A Path highway. +*/
	public static final int ROUTINO_HIGHWAY_STEPS = 12; /*+ A Steps highway. +*/
	public static final int ROUTINO_HIGHWAY_FERRY = 13; /*+ A Ferry highway. +*/

	public static final int ROUTINO_PROPERTY_PAVED = 1; /*+ A Paved highway. +*/
	public static final int ROUTINO_PROPERTY_MULTILANE = 2; /*+ A Multilane highway. +*/
	public static final int ROUTINO_PROPERTY_BRIDGE = 3; /*+ A Bridge highway. +*/
	public static final int ROUTINO_PROPERTY_TUNNEL = 4; /*+ A Tunnel highway. +*/
	public static final int ROUTINO_PROPERTY_FOOTROUTE = 5; /*+ A Footroute highway. +*/
	public static final int ROUTINO_PROPERTY_BICYCLEROUTE = 6; /*+ A Bicycleroute highway. +*/

}
