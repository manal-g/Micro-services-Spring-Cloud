package org.sid.manal.billingservice.web;

import org.sid.manal.billingservice.entities.Bill;
import org.sid.manal.billingservice.repository.BillRepository;
import org.sid.manal.billingservice.repository.ProductItemRepository;
import org.sid.manal.billingservice.service.CustomerRestClient;
import org.sid.manal.billingservice.service.ProductRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import java.util.Optional;

@RestController
public class BillRestController {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;




//    @GetMapping("/fullBill/{id}")
//    public Bill bill(@PathVariable Long id)
//    {
//        Bill bill=billRepository.findById(id).get();
//        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
//        bill.getProductItems().forEach(pi->{
//            pi.setProduct(productRestClient.findProductById(pi.getProductId()));
//        });
//
//        return bill;
//
//    }
@GetMapping("/fullBill/{id}")
public ResponseEntity<Bill> bill(@PathVariable Long id) {
    if (id == null) {
        return ResponseEntity.badRequest().body(null);
    }

    Optional<Bill> optionalBill = billRepository.findById(id);
    if (optionalBill.isPresent()) {
        Bill bill = optionalBill.get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi -> {
            pi.setProduct(productRestClient.findProductById(pi.getProductId()));
        });
        return ResponseEntity.ok(bill);
    } else {
        return ResponseEntity.notFound().build();
    }
}

}
