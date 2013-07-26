package functional.com.trailblazers.freewheelers.helpers;

import org.openqa.selenium.By;

public class OrderTable {

    public static By selectFor(String item) {
        return By.xpath("//tbody/tr/td[2][text() = '" + item + "']/parent::*/td[4]/select");
    }

    public static By saveButtonFor(String item) {
        return By.xpath("//tbody/tr/td[2][text() = '" + item + "']/parent::*/td[6]/button");
    }
}
