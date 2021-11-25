package com.projetointegrador.service;

import com.projetointegrador.entity.Buyer;
import com.projetointegrador.entity.HistoryList;
import com.projetointegrador.repository.HistoryListPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class HistoryListService {

    @Autowired
    HistoryListPersistence historyListPersistence;

    @Autowired
    private BuyerService buyerService;

    public HistoryList insert (@Valid HistoryList historyList) {
        return historyListPersistence.save(historyList);
    }

    public void delete (Long purchaseOrderId) {
        Optional<HistoryList> historyList1 = historyListPersistence.findById(purchaseOrderId);
        if (historyList1.isPresent()) {
            historyListPersistence.delete(historyList1.get());
        }
    }


    public Optional<List<HistoryList>> listHistoryByBuyer(Long id){
        Buyer buyer = buyerService.getByIdBuyer(id);
        Optional<List<HistoryList>> historyListByBuyer = historyListPersistence.findAllByBuyer(buyer);

        if(historyListByBuyer.isPresent()){
            return historyListByBuyer;
        }

        return null;
    }
}
