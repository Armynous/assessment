package com.kbtg.bootcamp.posttest.admin;

import com.kbtg.bootcamp.posttest.lottery.LotteryRequest;
import com.kbtg.bootcamp.posttest.configResponse.lotteryResponse.LotteryResponse;
import com.kbtg.bootcamp.posttest.lottery.LotteryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/lotteries")
public class AdminController {

    private final LotteryService lotteryService;

    public AdminController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @PostMapping("")
    public LotteryResponse createLottery(@RequestBody LotteryRequest request) throws Exception {
        return lotteryService.createLottery(request);
    }
}
