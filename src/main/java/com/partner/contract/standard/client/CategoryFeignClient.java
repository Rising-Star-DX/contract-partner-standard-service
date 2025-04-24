package com.partner.contract.standard.client;

import com.partner.contract.standard.client.dto.CategoryNameListResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("category-service")
public interface CategoryFeignClient {

    @GetMapping("/categories/internal/all")
    List<CategoryNameListResponseDto> getAllCategoryIdAndName();

    @GetMapping("/categories/internal/{categoryId}")
    CategoryNameListResponseDto getCategoryIdAndName(@RequestParam Long categoryId);
}
