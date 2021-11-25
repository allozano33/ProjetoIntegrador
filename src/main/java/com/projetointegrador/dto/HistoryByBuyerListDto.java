package com.projetointegrador.dto;

import com.projetointegrador.entity.*;
import com.projetointegrador.service.BuyerService;
import com.projetointegrador.service.OrderStatusService;
import com.projetointegrador.service.ProductService;
import com.projetointegrador.service.PurchaseItemService;
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

    private HistoryList historyList = new HistoryList();

    private static Object HistoryByBuyerListDto;
    private Long purchaseItemId;
    private String productId;
    private Integer quantity;

    @NotNull
    private List<HistoryByBuyerListDto> products;

    public HistoryByBuyerListDto ( ) {

    }

//    public static List<ProductItemDto> convert (List<HistoryByBuyerListDto> historyByBuyerListDto) {
//        List<ProductItemDto> productItemDto = new ArrayList<>();
//
//        for (HistoryByBuyerListDto item : historyByBuyerListDto) {
//            HistoryByBuyerListDto p = new HistoryByBuyerListDto();
//            p.setProductId(item.getProductId());
//            p.setQuantity(item.getQuantity());
//            historyByBuyerListDto.add(p);
//        }
//
//        return productItemDto;
//    }
//
//    public void getProductId (List<ProductItemListDto> products) {
//    }

    public static HistoryResponseDto convert(HistoryList historyList, BuyerService buyerService, ProductService productService, OrderStatusService orderStatusService) {

        HistoryResponseDto historyResponseDto = new HistoryResponseDto();

        historyResponseDto.setDate(historyList.getDate());

        Buyer buyer = buyerService.getByIdBuyer(historyList.getBuyer().getBuyerId());
        historyResponseDto.setBuyerId(buyer.getBuyerId());

        OrderStatus orderStatus = orderStatusService.getByOrderStatus(historyList.getOrderStatus().getStatusCode());
        historyResponseDto.setOrderStatus(orderStatus);

        List<HistoryItemDto> historyItemDto = convertHistoryItem(historyList.getHistoryItems(), productService);
        historyResponseDto.setProducts(historyItemDto);

        return historyResponseDto;
    }

    private static List<HistoryItemDto> convertHistoryItem (List<HistoryItem> historyItems, ProductService productService){
        List<HistoryItemDto> historyItems1 = new ArrayList<>();

        for (HistoryItem item : historyItems) {
            HistoryItemDto his = new HistoryItemDto();

            Product product = productService.getByIdProduct(item.getProduct().getProductId());
            his.setProductId(product.getProductId());
            his.setQuantity(item.getQuantity());
            historyItems1.add(his);
        }
        return historyItems1;
    }

}


