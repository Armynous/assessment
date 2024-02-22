package com.kbtg.bootcamp.posttest.lottery;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "lottery")
public class Lottery {
    @Id
    @Column(name = "ticket", nullable = false)
    @NotNull
    @Size(min = 6, max = 6, message = "Ticket must be a 6-digit string")
    private String ticket;
    @NotNull
    @Column(name = "price")
    private int price;
    @NotNull
    @Column(name = "amount")
    private int amount;
    public Lottery() {}

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Lottery(String ticket, int price, int amount) {
        this.ticket = ticket;
        this.price = price;
        this.amount = amount;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @PrePersist
    @PreUpdate
    private void prePersist() {
        // Ensure that the price is always set to 1
        this.amount = 1;
    }
}
