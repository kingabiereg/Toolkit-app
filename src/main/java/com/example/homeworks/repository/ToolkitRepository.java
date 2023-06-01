package com.example.homeworks.repository;

import com.example.homeworks.model.Tool;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import java.util.function.Predicate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ToolkitRepository {
    private final List<Tool> tools;

    public ToolkitRepository() {
        tools = readToolkit();
    }

    public List<Tool> getTools() {
        return new ArrayList<>(tools);
    }

    public boolean isEmpty() {
        return tools.isEmpty();
    }

    public boolean add(Tool tool) {
        tools.add(tool);
        return saveToolkit();
    }
    public List<Tool> searchTool (String name ) {

        List<Tool> findToolByName = tools.stream().filter(tool -> tool.getName().contains(name)).collect(Collectors.toList());
//                toolkitRepository.getTools().stream().filter(tool -> tool.getName()
//                .contains(name)).collect(Collectors.toList());
        return findToolByName;
    }

    private static List<Tool> readToolkit() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/toolkit.json");
            return objectMapper.readValue(file, new TypeReference<List<Tool>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }
    private boolean saveToolkit() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/resources/toolkit.json"), tools);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }
}
