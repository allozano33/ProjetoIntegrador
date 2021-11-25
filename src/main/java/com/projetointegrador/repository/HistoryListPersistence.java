package com.projetointegrador.repository;

import com.projetointegrador.entity.HistoryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryListPersistence extends JpaRepository<HistoryList, Long> {
}
