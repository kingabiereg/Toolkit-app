package com.example.homeworks.controller;


import com.example.homeworks.model.Tool;
import com.example.homeworks.repository.ToolkitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToolkitController {

    private final ToolkitRepository toolkitRepository;

    public ToolkitController(ToolkitRepository toolkitRepository) {
        this.toolkitRepository = toolkitRepository;
    }

    @GetMapping("/")
    public String getTools(Model model) {
        List<Tool> tools = toolkitRepository.getTools();
        model.addAttribute("tools", tools);
        return "index";
    }

    @GetMapping("/add")
    public String addTool(Model model) {
        return "add";
    }

    @PostMapping("/add")
    public String addTool(@RequestParam("name") String name,
                          @RequestParam("size") float size,
                          @RequestParam("unit") String unit, Model model) {
        Tool addTool = new Tool(name, new Tool.ToolSize(size, unit));
        toolkitRepository.add(addTool);
        List<Tool> tools = toolkitRepository.getTools();
        model.addAttribute("tools", tools);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchTool(Model model) {
        return "search";
    }

    @PostMapping("/search")
    public String searchTool(@RequestParam("name") String name, Model model) {
        List<Tool> searchTool = toolkitRepository.searchTool(name);
        model.addAttribute("search", searchTool);
        return "list";
    }
}



