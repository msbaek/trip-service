package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.DependendClassCallDuringUnitTestException;
import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public class TripDAO {

	public static List<Trip> findTripsByUser(User user) {
		throw new DependendClassCallDuringUnitTestException(
				"TripDAO should not be invoked on an unit test.");
	}

    public List<Trip> tripsBy(User user) {
        return TripDAO.findTripsByUser(user);
    }
}