package com.kbtg.bootcamp.posttest.configResponse.userTicketResponse;

import java.util.List;

public class UserTicketSummaryResponse {
    private List<String> tickets;
    private int count;
    private int cost;

    public UserTicketSummaryResponse(List<String> tickets, int count, int cost) {
        this.tickets = tickets;
        this.count = count;
        this.cost = cost;
    }

    public List<String> getTickets() {
        return tickets;
    }

    public int getCount() {
        return count;
    }

    public int getCost() {
        return cost;
    }
}
