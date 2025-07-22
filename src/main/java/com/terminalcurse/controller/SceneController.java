package com.terminalcurse.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/api/scene")
public class SceneController {

    private static final Map<String, Map<String, Object>> scenes = new HashMap<>();

    static {
        Map<String, Object> start = new HashMap<>();
        start.put("text", "You wake up in a dark terminal...");
        start.put("options", List.of(
                Map.of("text", "Explore left path", "nextId", "left"),
                Map.of("text", "Explore right path", "nextId", "right")
        ));
        scenes.put("start", start);

        Map<String, Object> left = new HashMap<>();
        left.put("text", "The left path leads to an eerie silence...");
        left.put("options", List.of(
                Map.of("text", "Return", "nextId", "start")
        ));
        scenes.put("left", left);

        Map<String, Object> right = new HashMap<>();
        right.put("text", "You hear whispers in the right path...");
        right.put("options", List.of(
                Map.of("text", "Return", "nextId", "start")
        ));
        scenes.put("right", right);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getScene(@PathVariable String id) {
        return scenes.getOrDefault(id, Map.of("text", "Scene not found", "options", List.of()));
    }
}