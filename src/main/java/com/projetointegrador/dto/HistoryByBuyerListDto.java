package com.projetointegrador.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class HistoryByBuyerListDto {


    private static Object HistoryByBuyerListDto;
    private Long purchaseItemId;
    private String productId;
    private Integer quantity;

    @NotNull
    private List<HistoryByBuyerListDto> products;

    public HistoryByBuyerListDto ( ) {

    }

    public static List<ProductItemDto> convert (List<HistoryByBuyerListDto> historyByBuyerListDto) {
        List<ProductItemDto> productItemDto = new ArrayList<>();

        for (HistoryByBuyerListDto item : historyByBuyerListDto) {
            HistoryByBuyerListDto p = new HistoryByBuyerListDto();
            p.setProductId(item.getProductId());
            p.setQuantity(item.getQuantity());
            historyByBuyerListDto.add(p);
        }

        return productItemDto;
    }

    public void getProductId (List<ProductItemListDto> products) {
    }
}


