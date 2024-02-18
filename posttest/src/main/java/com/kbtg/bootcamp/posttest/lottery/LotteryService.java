package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LotteryService {
    private final LotteryRepository lotteryRepository;

    public LotteryService(LotteryRepository lotteryRepository) {
        this.lotteryRepository = lotteryRepository;
    }

    public AllLotteryResponse findAllLottery() {
        List<Lottery> lotteryList = lotteryRepository.findAll();

        List<String> allLottery = new ArrayList<>();

        for (Lottery lottery : lotteryList) {
            allLottery.add(lottery.getTicket());
        }

        return new AllLotteryResponse(allLottery);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public LotteryResponse createLottery(LotteryRequest request) throws Exception {
        if (lotteryRepository.existsByTicket(request.getTicket())) {
            throw new Exception("Lottery number already exists");
        }

        Lottery newLottery = new Lottery();
        newLottery.setTicket(request.getTicket());
        newLottery.setPrice(request.getPrice());
        lotteryRepository.save(newLottery);

        return new LotteryResponse(newLottery.getTicket());
    }

    public ResponseEntity<?> createLottery(Integer userId, Integer ticketId) {
        Lottery newLottery = new Lottery();
        Lottery savedLottery = lotteryRepository.save(newLottery);

        return new ResponseEntity<>(savedLottery, HttpStatus.CREATED);
    }
}
