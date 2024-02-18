package com.kbtg.bootcamp.posttest.lottery;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

@Entity
public class Lottery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lottery_id")
    private Long id;
    @NotNull
    @Digits(integer = 6, fraction = 0, message = "Lottery number must be 6 digits.")
    @Column(name = "ticket")
    private String ticket;
    @Column(name = "price")
    private int price;
    private int amount = 1;
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

    public Lottery(Long id, String ticket, int price, int amount) {
        this.id = id;
        this.ticket = ticket;
        this.price = price;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
