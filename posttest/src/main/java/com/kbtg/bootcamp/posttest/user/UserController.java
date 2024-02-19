package com.kbtg.bootcamp.posttest.user;

import com.kbtg.bootcamp.posttest.userTicket.UserTicket;
import com.kbtg.bootcamp.posttest.userTicket.UserTicketResponseId;
import com.kbtg.bootcamp.posttest.userTicket.UserTicketService;
import com.kbtg.bootcamp.posttest.userTicket.UserTicketSummaryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserTicketService userTicketService;

    public UserController(UserTicketService userTicketService) {
        this.userTicketService = userTicketService;
    }

    @PostMapping("/{userId}/lotteries/{ticketId}")
    public UserTicketResponseId createLottery(@PathVariable Integer userId, @PathVariable Integer ticketId) {
        return userTicketService.createLottery(userId, ticketId);
    }

    @GetMapping("/{userId}/lotteries")
    public ResponseEntity<UserTicketSummaryResponse> getLotterySummary(@PathVariable Integer userId) {
        return userTicketService.getLotterySummary(userId);
    }

    @DeleteMapping("/{userId}/lotteries/{ticketId}")
    public String dropLottery(@PathVariable Integer userId, @PathVariable Integer ticketId) {
        return userTicketService.dropLottery(userId, ticketId);
    }
}
