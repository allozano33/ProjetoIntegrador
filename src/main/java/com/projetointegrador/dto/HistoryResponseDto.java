package com.projetointegrador.dto;

import com.projetointegrador.entity.OrderStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class HistoryResponseDto {

    private LocalDate date;
    private Long buyerId;
    private OrderStatus orderStatus;
    private List<HistoryItemDto> products;

}
