package com.projetointegrador.dto;

import com.projetointegrador.entity.*;
import com.projetointegrador.service.BuyerService;
import com.projetointegrador.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryListDto {

    private Long historyListId;
    private LocalDate date;
    private Long buyerId;
    private OrderStatus orderStatus;
    private List<HistoryItemDto> historyItemDto;

    public static HistoryList convert(HistoryListDto historyListDto, BuyerService buyerService, ProductService productService){
        HistoryList historyList = new HistoryList();
        historyList.setDate(historyListDto.getDate());
        historyList.setOrderStatus(historyListDto.getOrderStatus());
        historyList.setHistoryItems(convertList(historyListDto.getHistoryItemDto(),productService));

        Buyer buyer = buyerService.getByIdBuyer(historyListDto.getBuyerId());

        historyList.setBuyer(buyer);

        return historyList;
    }

    private static List<HistoryItem> convertList (List<HistoryItemDto> historyItemDto, ProductService productService) {
        List<HistoryItem> historyItem = new ArrayList<>();
        for (HistoryItemDto item: historyItemDto) {
            HistoryItem historyItem1 = new HistoryItem();

            Product product = productService.getByIdProduct(item.getProductId());
            historyItem1.setProduct(product);

            historyItem1.setQuantity(item.getQuantity());

            historyItem.add(historyItem1);
        }

        return historyItem;
    }

}
