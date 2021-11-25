package com.projetointegrador.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseOrderId;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "buyerId")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "orderStatusId")
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PurchaseItem> purchaseItems;

//    public void update(List<ProductItemListDto> products) {
//        if(!products.isEmpty()){
//            for (ProductItemListDto item: products) {
//                Optional<PurchaseItem> purchaseItem = purchaseItemPersistence.findById(item.getPurchaseItemId());
//                if (purchaseItem.isPresent()) {
//                    Product product = productService.getByIdProduct(item.getProductId());
//                    purchaseItem.get().setProduct(product);
//                    purchaseItem.get().setQuantity(item.getQuantity());
//                    purchaseItemPersistence.save(purchaseItem.get());
//                    atualizaBatchStock(item.getProductId(), purchaseItem.get().getQuantity(), item.getQuantity());
//                } else {
//                    throw new RuntimeException("Não existe purchaseItem com esse id!");
//                }
//            }
//        }else{
//            throw new RuntimeException("A lista de produtos não pode ser vazia!");
        }



