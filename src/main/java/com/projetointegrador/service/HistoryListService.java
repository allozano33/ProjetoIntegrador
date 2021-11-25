package com.projetointegrador.service;

import com.projetointegrador.entity.HistoryList;
import com.projetointegrador.repository.HistoryListPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HistoryListService {

    @Autowired
    HistoryListPersistence historyListPersistence;

    public HistoryList insert (HistoryList historyList) {
        return historyListPersistence.save(historyList);
    }

    public void delete (Long purchaseOrderId) {
        Optional<HistoryList> historyList1 = historyListPersistence.findById(purchaseOrderId);
        if (historyList1.isPresent()) {
            historyListPersistence.delete(historyList1.get());
        }
    }
}
