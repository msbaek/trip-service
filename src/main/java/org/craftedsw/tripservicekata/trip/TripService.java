package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService {
    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        User loggedUser = getLoggedUser();
        if(loggedUser == null)
            throw new UserNotLoggedInException();

        List<Trip> tripList = new ArrayList<Trip>();
        if (user.isFriendsWith(loggedUser)) {
            tripList = tripsByUser(user);
        }
        return tripList;
    }

    List<Trip> tripsByUser(User user) {
        return TripDAO.findTripsByUser(user);
    }

    User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }
}
