package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;

import java.util.ArrayList;
import java.util.List;

public class TripService {
    public List<Trip> getTripsByUser(User user, User loggedUser) throws UserNotLoggedInException {
        if(loggedUser == null)
            throw new UserNotLoggedInException();

        return user.isFriendsWith(loggedUser)
            ? tripsByUser(user)
            : noTrips();
    }

    private ArrayList<Trip> noTrips() {
        return new ArrayList<Trip>();
    }

    List<Trip> tripsByUser(User user) {
        return TripDAO.findTripsByUser(user);
    }
}
