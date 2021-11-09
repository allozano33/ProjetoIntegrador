package com.projetointegrador.service;

import com.projetointegrador.dto.*;
import com.projetointegrador.entity.*;
import com.projetointegrador.repository.PurchaseOrderPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderPersistence purchaseOrderPersistence;

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private ProductSellerService productSellerService;

    private PurchaseOrder purchaseOrder;

    public PurchaseOrderService() {
    }

    public PurchaseOrderService(PurchaseOrderPersistence purchaseOrderPersistence) {
        this.purchaseOrderPersistence = purchaseOrderPersistence;
    }

    public PurchaseOrderService(PurchaseOrderPersistence purchaseOrderPersistence, BuyerService buyerService, OrderStatusService orderStatusService, ProductService productService, ProductSellerService productSellerService, PurchaseOrder purchaseOrder) {
        this.purchaseOrderPersistence = purchaseOrderPersistence;
        this.buyerService = buyerService;
        this.orderStatusService = orderStatusService;
        this.productService = productService;
        this.productSellerService = productSellerService;
        this.purchaseOrder = purchaseOrder;
    }

    public PurchaseOrder insert(PurchaseOrder purchaseOrder) {
        return purchaseOrderPersistence.save(purchaseOrder);
    }

    public TotalPrice getTotalprice(List<ProductItemDto> productItemDto){
        BigDecimal valorTotal = new BigDecimal(0);

        for (ProductItemDto item : productItemDto) {

            Product product = productService.getByIdProduct(item.getProductId());
            ProductSeller productSeller = productSellerService.getProductSellerByProduto(product);

            productSeller.getPrice();

            BigDecimal newQtd = new BigDecimal(item.getQuantity());
            BigDecimal newQtd2 = newQtd.multiply(productSeller.getPrice());

            valorTotal = valorTotal.add(newQtd2);
        }

        TotalPrice totalPrice = new TotalPrice();
        totalPrice.setTotalprice(valorTotal);

        return totalPrice;
    }

    public PurchaseOrderResponseDto listOrdersByOrderId(Long id) {

        Optional<PurchaseOrder> purchaseOrder = purchaseOrderPersistence.findById(id);
        PurchaseOrderResponseDto purchaseOrderResponseDto = new PurchaseOrderResponseDto();

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderStatusId(purchaseOrder.get().getOrderStatus().getOrderStatusId());
        orderStatus.setStatusCode(purchaseOrder.get().getOrderStatus().getStatusCode());

        purchaseOrderResponseDto.setOrderStatus(orderStatus);

        purchaseOrderResponseDto.setBuyerId(purchaseOrder.get().getPurchaseOrderId());
        purchaseOrderResponseDto.setDate(purchaseOrder.get().getDate());

        List<ProductItemDto> productItemDtoList = new ArrayList<>();

        for (PurchaseItem item: purchaseOrder.get().getPurchaseItems()) {
            ProductItemDto productItemDto = new ProductItemDto();
            productItemDto.setProductId(item.getProduct().getProductId());
            productItemDto.setQuantity(item.getQuantity());
            productItemDtoList.add(productItemDto);
        }

        purchaseOrderResponseDto.setProducts(productItemDtoList);

        return purchaseOrderResponseDto;
    }
}
