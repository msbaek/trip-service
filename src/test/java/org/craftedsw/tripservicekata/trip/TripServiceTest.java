package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.junit.Test;

public class TripServiceTest {
    @Test(expected = UserNotLoggedInException.class)
    public void
    should_throw_an_exception_when_user_is_not_logged_in() throws Exception {
        TripService tripService = new TripService();
        tripService.getTripsByUser(null);
    }
}
