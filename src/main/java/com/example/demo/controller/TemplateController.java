package com.example.demo.controller;

import com.example.demo.model.earhtquake.EarthquakeEntity;
import com.example.demo.service.earthquake.EarthquakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private EarthquakeService earthquakeService;

    @GetMapping("/index/{id}")
    public String index(@PathVariable int id, Model model) {
        EarthquakeEntity e = earthquakeService.findById(id);
        model.addAttribute("e", e);

        return "test";
    }
}
