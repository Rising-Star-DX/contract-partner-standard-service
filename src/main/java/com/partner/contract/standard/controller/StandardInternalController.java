package com.partner.contract.standard.controller;

import com.partner.contract.standard.dto.StandardCountsResponseDto;
import com.partner.contract.standard.service.StandardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/standards/internal")
public class StandardInternalController {
    private final StandardService standardService;

    @GetMapping("/categories/{categoryId}/exists")
    public Map<String, Boolean> existsByCategory(@PathVariable Long categoryId) {
        return Map.of("exists", standardService.existsByCategory(categoryId));
    }

    @GetMapping("/count-by-category")
    public List<StandardCountsResponseDto> getStandardCountByCategory() {
        return standardService.findStandardCountByCategoryId();
    }
}
