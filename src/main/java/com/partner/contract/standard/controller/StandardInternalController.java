package com.partner.contract.standard.controller;

import com.partner.contract.standard.service.StandardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/standards/internal")
public class StandardInternalController {
    private final StandardService standardService;

    @GetMapping("/categories/check/{categoryId}")
    public Map<String, Boolean> existsByCategory(@PathVariable Long categoryId) {
        return Map.of("standardExists", standardService.existsByCategory(categoryId));
    }
}
