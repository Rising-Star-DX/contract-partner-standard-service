package com.partner.contract.standard.dto;

import lombok.Data;

@Data
public class StandardCountsResponseDto {
    Long id;
    Long count;

    public StandardCountsResponseDto(Long id, Long count) {
        this.id = id;
        this.count = count;
    }
}
