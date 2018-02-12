package ru.easty.java.routino.structs;

import com.sun.jna.Pointer;

/**
 * Created by belyakovcev_em on 02.02.2018.
 */
public class RoutinoWaypoint extends Pointer
{

	public RoutinoWaypoint( long peer )
	{
		super( peer );
	}
}
