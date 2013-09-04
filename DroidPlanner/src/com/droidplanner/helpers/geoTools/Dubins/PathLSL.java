package com.droidplanner.helpers.geoTools.Dubins;

import java.util.List;

import com.droidplanner.helpers.geoTools.GeoTools;
import com.droidplanner.helpers.geoTools.LineLatLng;
import com.google.android.gms.maps.model.LatLng;

public class PathLSL extends Path {

	public PathLSL(LineLatLng start, LineLatLng end, double radius) {
		super(start, end, radius);
	}

	@Override
	protected double getPathLength() {
		double interCircleAngle = new LineLatLng(circleStart, circleEnd)
				.getHeading();
		double distance = GeoTools.getAproximatedDistance(circleStart,
				circleEnd);
		distance += radius
				* Math.abs(2 * Math.PI
						+ Math.abs(interCircleAngle + Math.PI / 2)
						- Math.abs(startVector.getHeading() + Math.PI / 2));
		distance += radius
				* Math.abs(2 * Math.PI
						+ Math.abs(endVector.getHeading() + Math.PI / 2)
						- Math.abs(interCircleAngle + Math.PI / 2));
		return distance;
	}

	@Override
	protected List<LatLng> generatePoints() {
		// TODO Auto-generated method stub
		return null;
	}

	protected int getEndCircleAngle() {
		return LEFT_CIRCLE_ANGLE;
	}

	@Override
	protected int getStartCircleAngle() {
		return LEFT_CIRCLE_ANGLE;
	}
}