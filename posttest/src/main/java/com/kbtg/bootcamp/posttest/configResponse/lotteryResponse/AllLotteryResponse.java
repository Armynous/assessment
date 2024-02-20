package com.kbtg.bootcamp.posttest.configResponse.lotteryResponse;

import java.util.List;

public class AllLotteryResponse {
    private List<String> tickets;

    public AllLotteryResponse(List<String> tickets) {
        this.tickets = tickets;
    }

    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(List<String> tickets) {
        this.tickets = tickets;
    }
}
