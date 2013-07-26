package functional.com.trailblazers.freewheelers.helpers;

public class URLs {

    public static final String BASE = "http://localhost:8080";

    public static String home() {
        return BASE + "/";
    }

    public static String login() {
        return BASE + "/login";
    }

    public static String logout() {
        return BASE + "/logout";
    }

    public static String admin() {
        return BASE + "/admin";
    }

    public static String userProfile() {
        return BASE + "/userProfile";
    }
}
