package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    CarRepo carRepo;

    @RequestMapping("/")
    public String listCars(Model model){
        model.addAttribute("cars", carRepo.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String carForm(Model model) {
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Car car, BindingResult result){
        if(result.hasErrors()){
            return "carfrom";
        }
        carRepo.save(car);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String updateTodo(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepo.findById(id));
        return "carform";
    }

    @RequestMapping("/delete/{id}")
    public String delTodo(@PathVariable("id") long id){
        carRepo.deleteById(id);
        return "redirect:/";
    }

}
