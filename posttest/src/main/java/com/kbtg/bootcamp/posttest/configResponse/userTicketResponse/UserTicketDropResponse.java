package com.kbtg.bootcamp.posttest.configResponse.userTicketResponse;

public class UserTicketDropResponse {
    String ticket;

    public UserTicketDropResponse(String ticket) {
        this.ticket = ticket;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
