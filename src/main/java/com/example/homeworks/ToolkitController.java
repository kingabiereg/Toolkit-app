package com.example.homeworks;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}



