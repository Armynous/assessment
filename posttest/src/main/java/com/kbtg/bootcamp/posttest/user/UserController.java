package com.kbtg.bootcamp.posttest.user;

import com.kbtg.bootcamp.posttest.lottery.AllLotteryResponse;
import com.kbtg.bootcamp.posttest.lottery.LotteryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lotteries")
public class UserController {
    private final LotteryService lotteryService;

    public UserController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("")
    public AllLotteryResponse lotteryList() {
        return lotteryService.findAllLottery();
    }

    @PostMapping("/users/:userId/lotteries/:ticketId")
    public ResponseEntity<?> createLottery(@PathVariable Integer userId, @PathVariable Integer ticketId) {
        return lotteryService.createLottery(userId, ticketId);
    }
}
