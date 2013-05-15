package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

public class TripServiceTest {
    private User loggedInUser;
    private User GUEST = null;

    @Test(expected = UserNotLoggedInException.class)
    public void
    should_throw_an_exception_when_user_is_not_logged_in() throws Exception {
        TripService tripService = new TestingTripService();

        loggedInUser = GUEST;

        tripService.getTripsByUser(null);
    }

    @Test
    public void
    should_not_return_any_trips_when_users_are_not_friends() throws Exception {
        TripService tripService = new TestingTripService();

        loggedInUser = REGISTERED_USER;

        User friend = new User();
        friend.addFriend(ANOTHER_USER);
        friend.addTrip(TO_BRAZIL);

        List<Trip> friendTrips = tripService.getTripsByUser(friend);

        assertThat(friendTrips.size(), is(0));
    }

    class TestingTripService extends TripService {
        @Override
        User getLoggedUser() {
            return loggedInUser;
        }
    }
}
