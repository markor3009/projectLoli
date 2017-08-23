package main;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("/login")
    public String login(
    ) {
       return "login";
    }
    
    @RequestMapping("/homepage")
    public String homepage(
    ) {
       return "index";
    }
    @RequestMapping("/userpage")
    public String userpage(
    ) {
       return "index2";
    }

    @RequestMapping("/aboutus")
    public String aboutus(ModelMap model) {
        List<User> user = DB.query("SELECT u FROM User u");
        model.addAttribute("user", user.get(0));
        return "test";
    }

}
