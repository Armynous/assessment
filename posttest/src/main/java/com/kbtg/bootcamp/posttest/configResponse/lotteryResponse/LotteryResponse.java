package com.kbtg.bootcamp.posttest.configResponse.lotteryResponse;

import java.util.List;

public class LotteryResponse {
    private String ticket;

    private List<String> tickets;

    public LotteryResponse(String ticket) {
        this.ticket = ticket;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
