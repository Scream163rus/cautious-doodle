package com.scream.project.controllers;

import com.scream.project.models.Ad;
import com.scream.project.repositories.AdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class AdController {
    private AdRepo adRepo;
    AdController(AdRepo adRepo){
        this.adRepo = adRepo;
    }
    @GetMapping("/add")
    public String add(){
        return "ad_add";
    }
    @PostMapping("/add")
    public String addAd(@Valid Ad ad, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "ad";
        }
        ad.setDate(LocalDateTime.now());
        adRepo.save(ad);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String adWithId(@PathVariable(value = "id") Long id, Model model){
        Optional<Ad> ad = adRepo.findById(id);
        model.addAttribute("ad", ad);
        return "ad_details";
    }


}
