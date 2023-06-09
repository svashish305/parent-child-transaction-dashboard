package com.app.api.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "parent")
public class Parent implements Serializable {

    public Parent() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "sender")
    private String sender;

    @NotNull
    @Column(name = "receiver")
    private String receiver;

    @NotNull
    @Column(name = "total_amount")
    private Long totalAmount;

    @Transient
    private Long totalPaidAmount;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private List<Child> children;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getTotalPaidAmount() {
        Long totalPaidAmount = 0L;
        if (children != null) {
            for (Child child : children) {
                if (child.getPaidAmount() != null) {
                    totalPaidAmount += child.getPaidAmount();
                }
            }
        }
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(Long totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }
}
