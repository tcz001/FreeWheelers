package functional.com.trailblazers.freewheelers;

import org.junit.Test;

import static functional.com.trailblazers.freewheelers.helpers.SyntaxSugar.ONLY_ONE_LEFT;
import static functional.com.trailblazers.freewheelers.helpers.SyntaxSugar.SOME_PASSWORD;

public class OrderTest extends UserJourneyBase {

    @Test
    public void testOrderProcess() throws Exception {
        String Arno = "Arno Admin";
        String Bob = "Bob Buyer";
        String Simplon_Frame = "Simplon Pavo 3 Ultra";

        admin
                .there_is_an_admin(Arno, SOME_PASSWORD)
                .there_is_a_user(Bob, SOME_PASSWORD)
                .there_is_a_frame(Simplon_Frame, ONLY_ONE_LEFT);

        user
                .logs_in_with(Bob, SOME_PASSWORD)
                .visits_home_page();

        screen
                .should_list_item(Simplon_Frame);

        user
                .reserves_item(Simplon_Frame)
                .visits_home_page();

        screen
                .should_not_list_item(Simplon_Frame);

        user
                .logs_in_with(Arno, SOME_PASSWORD)
                .visits_admin_profile();

        screen
                .there_should_be_an_order(Simplon_Frame, "NEW");

        user
                .changes_order_status(Simplon_Frame, "IN_PROGRESS");

        screen
                .there_should_be_an_order(Simplon_Frame, "IN_PROGRESS");
    }

}
