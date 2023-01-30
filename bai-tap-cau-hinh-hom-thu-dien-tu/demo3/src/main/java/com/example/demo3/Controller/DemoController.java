package com.example.demo3.Controller;

import com.example.demo3.Model.Demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/home")
public class DemoController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getForm(Model model) {
        List<String> languages = new ArrayList<>();
        List<String> size = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        size.add("5");
        size.add("10");
        Demo demo = new Demo();
        model.addAttribute("languages", languages);
        model.addAttribute("sizes", size);
        model.addAttribute("demo", demo);
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDemo(@ModelAttribute("demo") Demo demo, Model model){
        model.addAttribute("demo", demo);
        return "success";
    }
}
