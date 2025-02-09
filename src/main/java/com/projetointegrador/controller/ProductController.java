package com.projetointegrador.controller;

import com.projetointegrador.dto.*;
import com.projetointegrador.entity.Product;
import com.projetointegrador.entity.PurchaseOrder;
import com.projetointegrador.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    private BatchStockService batchStockService;

    @Autowired
    private ProductSellerService productSellerService;

    @Autowired
    private PurchaseItemService purchaseItemService;

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private OrderStatusService orderStatusService;

    @PostMapping(value = "/insert")
    public ResponseEntity<Product> insert(@RequestBody @Valid ProductDto productDto, UriComponentsBuilder uriBuilder) {
        Product productCadastrado = productService.insert(productDto);

        URI uri = uriBuilder.path("/product/search/{id}").buildAndExpand(productCadastrado.getProductId()).toUri();
        return ResponseEntity.created(uri).body(productCadastrado);
    }

    @PostMapping(value = "/orders")
    public ResponseEntity<TotalPrice> insert(@RequestBody @Valid PurchaseOrderDto purchaseOrderDto, UriComponentsBuilder uriBuilder) {
        batchStockService.verifyProductInBatchStock(purchaseOrderDto.getProducts());
        TotalPrice totalPrice = purchaseOrderService.getTotalprice(purchaseOrderDto.getProducts());


        PurchaseOrder purchaseOrder = purchaseOrderService.insert(purchaseOrderDto.convert(purchaseOrderDto, purchaseItemService, buyerService, productService, orderStatusService));

        URI uri = uriBuilder.path("/product/search/{id}").buildAndExpand(purchaseOrder.getPurchaseOrderId()).toUri();
        return ResponseEntity.created(uri).body(totalPrice);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<ProductResponseDto>> getProductSellerId() {
        List<ProductResponseDto> productResponseDto = productSellerService.listProduct();

        if (productResponseDto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(productResponseDto);
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<PurchaseOrderResponseDto> listOrdersByOrderId(@PathVariable("id") Long id) {
        PurchaseOrderResponseDto purchaseOrderResponseDto = purchaseOrderService.listOrdersByOrderId(id);

        if (purchaseOrderResponseDto.getBuyerId() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(purchaseOrderResponseDto);
    }

    @PutMapping(value = "/orders/update")
    public ResponseEntity<TotalPrice> update(@RequestBody @Valid PurchaseOrderListDto purchaseOrderListDto){
        batchStockService.verifyProductInBatchStock(PurchaseOrderListDto.convert(purchaseOrderListDto.getProducts()));
        TotalPrice totalPrice = purchaseOrderService.getTotalprice(PurchaseOrderListDto.convert(purchaseOrderListDto.getProducts()));

        purchaseItemService.update(purchaseOrderListDto.getProducts());

        return ResponseEntity.ok().body(totalPrice);
    }
}
