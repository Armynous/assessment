package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.configResponse.lotteryResponse.AllLotteryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lotteries")
public class LotteryController {
    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }
    @GetMapping("")
    public AllLotteryResponse lotteryList() {
        return lotteryService.findAllLottery();
    }
}
