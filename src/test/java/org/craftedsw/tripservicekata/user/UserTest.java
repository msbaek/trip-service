package org.craftedsw.tripservicekata.user;

import org.junit.Test;

import static org.craftedsw.tripservicekata.trip.UserBuilder.aUser;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    private static final User BOB = new User();
    private static final User PAUL = new User();

    @Test
    public void
    should_inform_when_users_are_not_friends() throws Exception {
        User user = aUser()
                .friendsWith(BOB)
                .build();

        assertThat(user.isFriendsWith(PAUL), is(false));
    }
}
