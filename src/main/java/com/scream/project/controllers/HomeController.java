package com.scream.project.controllers;

import com.scream.project.models.Ad;
import com.scream.project.repositories.AdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    private AdRepo adRepo;
    @Autowired
    HomeController(AdRepo adRepo){
        this.adRepo = adRepo;
    }

    @GetMapping("/")
    public String adMain(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Ad> ad = adRepo.findAll(pageable);
        model.addAttribute("ad", ad);
        return "ad";
  }
  @PostMapping("searchText")
  public String search(Model model, @RequestParam  String searchText, @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable){
      Page<Ad> ad = adRepo.findByTitle(searchText, pageable);
      model.addAttribute("ad", ad);
      return "ad";
  }
  @GetMapping("/login")
    public String login(){
        return "login";
  }

}

