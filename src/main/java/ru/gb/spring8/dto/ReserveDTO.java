package ru.gb.spring8.dto;

import lombok.Data;

/**
 * DTO for OperationController("/operation") @PostMapping("/reserve")
 */
@Data
public class ReserveDTO {
    private Long customerId;
    private Long productId;

}
