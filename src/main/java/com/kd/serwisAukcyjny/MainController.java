package com.kd.serwisAukcyjny;

import com.kd.serwisAukcyjny.user.CustomerRegistrationDto;
import com.kd.serwisAukcyjny.user.UserExistException;
import com.kd.serwisAukcyjny.user.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    private UserRegistrationService userRegistrationService;

//    @Autowired
//    private WeatherService weatherService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "HI";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        model.addAttribute("customerFormData", new CustomerRegistrationDto());
     /* zmienić na województwa w pozniejszym etapie
        model.addAttribute("countries", Countries.values());
*/
        return "registerForm";
    }

    @PostMapping(value = "/register")
    public String registerEffect(@ModelAttribute(name = "customerFormData") @Valid CustomerRegistrationDto customerFormData,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
       //     model.addAttribute("countries", Countries.values());
            return "registerForm";
        }
        try {
            userRegistrationService.registerUser(customerFormData);
        } catch (UserExistException e) {
            model.addAttribute("userExistsException", e.getMessage());
            return "registerForm";
        }
        model.addAttribute("registrationData", customerFormData);
        return "registerEffect";
    }
//
//    @GetMapping("/weather")
//    @ResponseBody
//    public ResponseEntity<String> weather() {
//        try {
//            String weather = weatherService.getWeather();
//            return ResponseEntity.ok(weather);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Błąd");
//        }
//    }
}
