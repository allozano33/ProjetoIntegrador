package com.projetointegrador.repository;

import com.projetointegrador.entity.Buyer;
import com.projetointegrador.entity.HistoryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoryListPersistence extends JpaRepository<HistoryList, Long> {

    Optional<List<HistoryList>> findAllByBuyer(Buyer buyer);

}
