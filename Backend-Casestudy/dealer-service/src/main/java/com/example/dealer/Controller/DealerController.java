package com.example.dealer.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dealer.model.Dealer;
import com.example.dealer.service.DealerService;



@RestController
@RequestMapping("/api/dealers")
public class DealerController {
   @Autowired
   private DealerService dealerService;



   @GetMapping
   public List<Dealer> getAllDealers() {
       return dealerService.getAllDealers();
   }



   @GetMapping("/{id}")
   public Dealer getDealerById(@PathVariable String id) {
       return dealerService.getDealerById(id);
   }



   @PostMapping
   public Dealer createDealer(@RequestBody Dealer dealer) {
       return dealerService.createDealer(dealer);
   }



   @PutMapping("/{id}")
   public Dealer updateDealer(@PathVariable String id, @RequestBody Dealer dealer) {
       dealer.setId(id);
       return dealerService.updateDealer(dealer);
   }



   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteDealer(@PathVariable String id) {
       dealerService.deleteDealer(id);
       return ResponseEntity.ok("deleted");
   }
}