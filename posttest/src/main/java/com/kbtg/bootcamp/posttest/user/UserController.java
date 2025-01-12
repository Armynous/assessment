package com.kbtg.bootcamp.posttest.user;

import com.kbtg.bootcamp.posttest.configResponse.userTicketResponse.UserTicketDropResponse;
import com.kbtg.bootcamp.posttest.configResponse.userTicketResponse.UserTicketResponseId;
import com.kbtg.bootcamp.posttest.configResponse.userTicketResponse.UserTicketSummaryResponse;
import com.kbtg.bootcamp.posttest.userTicket.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserTicketService userTicketService;

    public UserController(UserTicketService userTicketService) {
        this.userTicketService = userTicketService;
    }

    @PostMapping("/{userId}/lotteries/{ticketId}")
    public UserTicketResponseId createLottery(@PathVariable String userId, @PathVariable Integer ticketId) {
        return userTicketService.buyLottery(userId, String.valueOf(ticketId));
    }

    @GetMapping("/{userId}/lotteries")
    public ResponseEntity<UserTicketSummaryResponse> getLotterySummary(@PathVariable String userId) {
        return userTicketService.getLotterySummary(userId);
    }

    @DeleteMapping("/{userId}/lotteries/{ticketId}")
    public UserTicketDropResponse dropLottery(@PathVariable String userId, @PathVariable String ticketId) {
        return userTicketService.dropLottery(userId, ticketId);
    }
}
