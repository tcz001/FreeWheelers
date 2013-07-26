package functional.com.trailblazers.freewheelers;

import org.junit.Test;

import static functional.com.trailblazers.freewheelers.helpers.SyntaxSugar.*;

public class ManageItemsTest extends UserJourneyBase {

    @Test
    public void shouldCreateAndUpdateItems() throws Exception {
        String Arno = "Arno Admin";

        String Simplon_Frame = "Simplon Pavo 3 Ultra";
        String Spoke_Reflectors = "Spoke - Reflectors Arrow red";

        String New_Simplon_Name = "NEW - Simplon Pavo 3 Ultra";
        String New_Spoke_Name = "NEW - Spoke - Reflectors Arrow red";

        admin
                .there_is_an_admin(Arno, SOME_PASSWORD)
                .there_is_no_item(Simplon_Frame)
                .there_is_no_item(Spoke_Reflectors)
                .there_is_no_item(New_Simplon_Name)
                .there_is_no_item(New_Spoke_Name);
        user
                .logs_in_with(Arno, SOME_PASSWORD)
                .wants_to_manage_items();

        user
                .creates_an_item(Simplon_Frame, "FRAME", NO_QUANTITY, REALLY_EXPENSIVE, SOME_DESCRIPTION);

        screen
                .shows_error("Please enter Item Quantity");

        user
                .creates_an_item(Simplon_Frame, "FRAME", A_LOT, REALLY_EXPENSIVE, SOME_DESCRIPTION);
        screen
                .shows_in_manage_item_list(Simplon_Frame);

        user
                .creates_an_item(Spoke_Reflectors, "ACCESSORIES", A_LOT, REALLY_EXPENSIVE, SOME_DESCRIPTION);

        screen
                .shows_in_manage_item_list(Simplon_Frame)
                .shows_in_manage_item_list(Spoke_Reflectors);

        user
                .changes_item_name(from(Simplon_Frame), to(New_Simplon_Name))
                .changes_item_name(from(Spoke_Reflectors), to(New_Spoke_Name));

        screen
                .shows_in_manage_item_list(New_Simplon_Name)
                .shows_in_manage_item_list(New_Spoke_Name);

        user
                .delete_item(New_Simplon_Name);

        screen
                .shows_in_manage_item_list(New_Spoke_Name)
                .shows_not_in_manage_item_list(New_Simplon_Name);
    }


}
