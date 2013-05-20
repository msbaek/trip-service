package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.craftedsw.tripservicekata.trip.UserBuilder.aUser;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceTest {
    private User loggedInUser;
    private User GUEST = null;
    private User REGISTERED_USER = new User();
    private User ANOTHER_USER = new User();
    private Trip TO_BRAZIL = new Trip();
    private Trip TO_LONDON = new Trip();

    @Mock private TripDAO tripDAO;
    @InjectMocks @Spy private TripService realTripService = new TripService();

    @Before
    public void setUp() throws Exception {
        loggedInUser = REGISTERED_USER;
    }

    @Test(expected = UserNotLoggedInException.class) public void
    should_throw_an_exception_when_user_is_not_logged_in() throws Exception {
        loggedInUser = GUEST;

        realTripService.getTripsByUser(null, null);
    }

    @Test public void
    should_not_return_any_trips_when_users_are_not_friends() throws Exception {
        User friend = aUser()
                .friendsWith(ANOTHER_USER)
                .withTrips(TO_BRAZIL)
                .build();

        List<Trip> friendTrips = realTripService.getTripsByUser(friend, loggedInUser);

        assertThat(friendTrips.size(), is(0));
    }

    @Test public void
    should_return_friend_trips_when_users_are_friends() throws Exception {
        User friend = aUser()
                .friendsWith(ANOTHER_USER, loggedInUser)
                .withTrips(TO_BRAZIL, TO_LONDON)
                .build();
        given(tripDAO.tripsBy(friend)).willReturn(friend.trips());

        List<Trip> friendTrips = realTripService.getTripsByUser(friend, loggedInUser);

        assertThat(friendTrips.size(), is(2));
    }
}
