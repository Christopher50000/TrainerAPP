package com.example.trainerApplication.controllers.mvc;


import com.example.trainerApplication.models.viewmodels.SampleModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/sample")
    public String samplePage(Model model) {
        SampleModel sampleModel = new SampleModel("John Doe", 30);

        model.addAttribute("sampleModel", sampleModel);
        return "sample";
    }
}