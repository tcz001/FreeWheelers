package functional.com.trailblazers.freewheelers;

import org.junit.Test;

import static functional.com.trailblazers.freewheelers.helpers.SyntaxSugar.*;

public class AccountTest extends UserJourneyBase {

    @Test
    public void testCreateAccount() throws Exception {
        String jan = "Jan Plewka";

        admin
                .there_is_no_account_for(jan);

        user
                .is_logged_out()
                .logs_in_with(jan, SOME_PASSWORD);

        screen
                .shows_error_alert("login attempt was not successful");

        user
                .creates_an_account(jan, SOME_EMAIL, SOME_PASSWORD, EMPTY_PASSWORD);

        screen
                .shows_error_alert("There were errors");

        user
                .creates_an_account(jan, SOME_EMAIL, SOME_PASSWORD, SOME_PHONE_NUMBER);

        screen
                .shows_message("account has been created");

        user
                .is_logged_out()
                .logs_in_with(jan, SOME_PASSWORD);

        screen
                .shows_in_navbar("Welcome " + jan);
    }

    @Test
    public void testAccessRights() throws Exception {
        String Hugo = "Hugo Huser";
        String Arno = "Arno Admin";

        admin
                .there_is_a_user(Hugo, SOME_PASSWORD)
                .there_is_an_admin(Arno, SOME_PASSWORD);

        user
                .is_logged_out()
                .visits_his_profile();
        screen
                .shows_login();

        user
                .logs_in_with(Hugo, SOME_PASSWORD)
                .visits_his_profile();
        screen
                .shows_profile_for(Hugo);

        user
                .visits_admin_profile();
        screen
                .shows_error_alert("access is denied");

        user
                .logs_in_with(Arno, SOME_PASSWORD)
                .visits_admin_profile();
        screen
                .shows_admin_profile();

        user
                .visits_profile_for(Hugo);
        screen
                .shows_profile_for(Hugo);
    }


}
