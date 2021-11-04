package com.projetointegrador.repository;

import com.projetointegrador.entity.BatchStock;
import com.projetointegrador.entity.ProductSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BatchStockPersistence extends JpaRepository<BatchStock, Long> {
    List<BatchStock> findByProductSeller(ProductSeller productSeller);
}
