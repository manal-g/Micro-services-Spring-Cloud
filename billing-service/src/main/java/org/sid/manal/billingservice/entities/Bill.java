package org.sid.manal.billingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.manal.billingservice.model.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billDate;

    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    //Attribut dans la classe mais non pas dans la base de donnée à ignorer
    @Transient
    private Customer customer;

}
