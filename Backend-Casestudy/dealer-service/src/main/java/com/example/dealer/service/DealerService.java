package com.example.dealer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dealer.model.Dealer;
import com.example.dealer.repository.DealerRepository;
import java.util.List;

@Service
public class DealerService {
    @Autowired
    private DealerRepository dealerRepository;

    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    public Dealer getDealerById(String id) {
        return dealerRepository.findById(id).orElse(null);
    }

    public Dealer createDealer(Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    public Dealer updateDealer(Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    public void deleteDealer(String id) {
        dealerRepository.deleteById(id);
    }
}
