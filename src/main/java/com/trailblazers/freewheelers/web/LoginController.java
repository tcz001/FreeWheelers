package com.trailblazers.freewheelers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

        @RequestMapping(value="/login", method = RequestMethod.GET)
        public String login(Model model) {
            return "login";
        }

        @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
        public String loginerror(Model model) {
            model.addAttribute("error", "true");
            return "login";

        }

        @RequestMapping(value="/logout", method = RequestMethod.GET)
        public String logout(Model model) {
            return "logout";

        }

        @RequestMapping(value = "/403")
        public String accessDenied() {
            return "accessDenied";
        }


}