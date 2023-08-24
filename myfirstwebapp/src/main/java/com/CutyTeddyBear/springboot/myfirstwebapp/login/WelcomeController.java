package com.CutyTeddyBear.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    /*
    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    */

    // http://localhost:8080/login?name=Ranga
    // Model
    // GET, POST
    // RequestMethod.GET -> GET 메소드만 지원하게 해줌
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }
}
    /*
    @RequestMapping(value = "login", method = RequestMethod.POST)
    // login?name=Ranga RequestParam
    public String gotoWelcomePage(@RequestParam String name,
            @RequestParam String password, ModelMap model) {

        if(authenticationService.authenticate(name, password)) {

            model.put("name", name);

            //Authentication
            //name - geolyun
            //password - dummy

            return "welcome";
        }

        model.put("errorMessage", "Invalid Credentials! Please try again");
        return "login";
    }
}
*/