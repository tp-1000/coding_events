package org.launchcode.codingevents.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by tom
 */
@Controller
public class HomeController {

    @GetMapping
    public String index() {
        return "index";
    }

}
