package ru.gb.spring8.dto;

import lombok.Data;

/**
 * DTO for OperationController("/operation") @PostMapping("/pay")
 */

@Data
public class PayDTO {
    private Long reserveProductId;
    private Long directorId;
}
