package spring.inaction.foundationalspring.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class HomeController {
    @GetMapping("/")
    public String index(){
//        System.out.println("abc");
//        return new ResponseEntity<>("Home", HttpStatus.ACCEPTED);
        return "index";
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
