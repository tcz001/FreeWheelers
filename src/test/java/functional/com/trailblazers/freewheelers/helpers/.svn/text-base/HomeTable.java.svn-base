package functional.com.trailblazers.freewheelers.helpers;

import org.openqa.selenium.By;

public class HomeTable {
    public static By nameFieldFor(String name) {
        return By.xpath("//tbody/tr/td[1][text()='" + name + "']");
    }

    public static By reserveButtonFor(String name) {
        return By.xpath("//tbody/tr/td[1][text() = '" + name + "']/parent::*/td[6]/form/button");
    }
}
