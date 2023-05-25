package com.example.homeworks;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ToolkitController {

    private final ToolkitRepository toolkitRepository;


    public ToolkitController(ToolkitRepository toolkitRepository) {
        this.toolkitRepository = toolkitRepository;
    }
    @GetMapping("tools")
    public String getTools(Model model) {
        List<Tool> tools = toolkitRepository.getTools();
        model.addAttribute("tools", tools);
        return "tools";
    }

@GetMapping("add")
    public String addTool() {

        return "add";
    }

    @PostMapping("save")
    public String addTool(@RequestParam String name, @RequestParam float size, @RequestParam String unit, Model model) {
        Tool addTool = new Tool(name, new Tool.ToolSize(size, unit));
        toolkitRepository.add(addTool);
        List<Tool> tools = toolkitRepository.getTools();
        model.addAttribute("tools", tools);
        return "save";
    }
}



