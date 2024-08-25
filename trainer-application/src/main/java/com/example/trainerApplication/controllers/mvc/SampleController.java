package com.example.trainerApplication.controllers.mvc;


import com.example.trainerApplication.models.viewmodels.SampleModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// Creating a sample of a page rendered to browser, using thymeleaf
// the controller returns the view or really the .html file

// We will need this to produce a MPA which runs on the server side for OAuth this might be best used for another applciation itself
// Maybe used to login with their google account or something
// Like I can make a page dedicated to
@Controller
public class SampleController {

    @GetMapping("/sample")
    public String samplePage(Model model) {
        SampleModel sampleModel = new SampleModel("John Doe", 30);

        model.addAttribute("sampleModel", sampleModel);
        return "sample";
    }
}