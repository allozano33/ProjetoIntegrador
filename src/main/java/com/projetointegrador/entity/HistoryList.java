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
    private Long historyListId;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "buyerId")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "orderStatusId")
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "historyList", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<HistoryItem> historyItems;
}



