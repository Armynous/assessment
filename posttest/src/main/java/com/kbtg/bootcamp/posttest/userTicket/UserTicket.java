package com.kbtg.bootcamp.posttest.userTicket;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.user.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_lottery")
public class UserTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_lottery_id")
    private int userLotteryId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lottery_id")
    private Lottery lottery;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    public UserTicket() {

    }

    public UserTicket(User user, Lottery lottery, Date purchaseDate) {
        this.user = user;
        this.lottery = lottery;
        this.purchaseDate = purchaseDate;
    }

    public int getUserLotteryId() {
        return userLotteryId;
    }

    public void setUserLotteryId(int userLotteryId) {
        this.userLotteryId = userLotteryId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
