package com.kd.serwisAukcyjny.bought;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoughtController {
    @Autowired
    private BoughtService boughtService;

//    @RequestMapping(value="/placeBought")
//    public String makeBought (Model model){
//        model.addAttribute("bought", boughtService.placeBought());
//        return "shoppingFinished";
//    }
}
