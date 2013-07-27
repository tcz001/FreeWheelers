package functional.com.trailblazers.freewheelers.apis;

import com.trailblazers.freewheelers.model.Account;
import com.trailblazers.freewheelers.model.Address;
import com.trailblazers.freewheelers.model.Item;
import com.trailblazers.freewheelers.model.ItemType;
import com.trailblazers.freewheelers.service.AccountService;
import com.trailblazers.freewheelers.service.ItemService;
import com.trailblazers.freewheelers.service.impl.AccountServiceImpl;
import com.trailblazers.freewheelers.service.impl.ItemServiceImpl;

import static functional.com.trailblazers.freewheelers.helpers.SyntaxSugar.*;


public class AdminApi {

    private AccountService accountService;
    private ItemService itemService;

    public AdminApi() {
        this.accountService = new AccountServiceImpl();
        this.itemService = new ItemServiceImpl();
    }

    public AdminApi there_is_no_account_for(String accountName) {
        Account account = accountService.getAccountIdByName(accountName);
        if (account != null) {
            accountService.delete(account);
        }

        return this;
    }

    public AdminApi there_is_a_user(String userName, String password, String city, String country) {
        there_is_no_account_for(userName);
        Account account = account_for(userName,password);
        accountService.createAccount(account,address_for(account, city, country) );

        return this;
    }

    public AdminApi there_is_an_admin(String userName, String password) {
        there_is_no_account_for(userName);
        accountService.createAdmin(account_for(userName, password));

        return this;
    }

    public AdminApi there_is_no_item(String itemName) {
        Item toBeDeleted = itemService.getByName(itemName);

        while (toBeDeleted != null) {
            itemService.delete(toBeDeleted);
            toBeDeleted = itemService.getByName(itemName);
        }

        return this;
    }

    public AdminApi there_is_a_frame(String itemName, Long quantity) {
        there_is_no_item(itemName);
        itemService.saveItem(itemFor(itemName, quantity));

        return this;
    }

    private Item itemFor(String itemName, Long quantity) {
        return new Item()
                    .setName(itemName)
                    .setQuantity(quantity)
                    .setDescription("A very nice item.")
                    .setPrice(SOME_PRICE)
                    .setType(ItemType.FRAME);
    }

    private Account account_for(String userName, String password) {
        return new Account()
                    .setAccount_name(userName)
                    .setPassword(password)
                    .setEmail_address(emailFor(userName))
                    .setPhoneNumber(SOME_PHONE_NUMBER)
                    .setEnabled(true);
    }

    private Address address_for(Account account ,String city, String country) {
        return new Address()
                .setAccount_id(account.getAccount_id())
                .setStreet1(SOME_STREET1)
                .setStreet2(SOME_STREET2)
                .setCity(city)
                .setState(SOME_STATE)
                .setCountry(country)
                .setZipCode(SOME_ZIPCODE);
    }
}
