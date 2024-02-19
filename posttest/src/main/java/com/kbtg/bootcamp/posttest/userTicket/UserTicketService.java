package com.kbtg.bootcamp.posttest.userTicket;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryRepository;
import com.kbtg.bootcamp.posttest.user.User;
import com.kbtg.bootcamp.posttest.user.UserRepository;
import com.kbtg.bootcamp.posttest.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserTicketService {

    private final LotteryRepository lotteryRepository;
    private final UserRepository userRepository;
    private final UserTicketRepository userTicketRepository;
    private final UserService userService;

    public UserTicketService(UserRepository userRepository, UserTicketRepository userTicketRepository,
                             LotteryRepository lotteryRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userTicketRepository = userTicketRepository;
        this.lotteryRepository = lotteryRepository;
        this.userService = userService;
    }

    public UserTicketResponseId createLottery(Integer userId, Integer ticketId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Lottery> optionalTicket = lotteryRepository.findById(ticketId);

        if (optionalUser.isEmpty()) {
            return null;
        }

        if (optionalTicket.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();
        Lottery lottery = optionalTicket.get();

        UserTicket userTicket = new UserTicket(user, lottery, new Date());

        userTicketRepository.save(userTicket);

        return new UserTicketResponseId(String.valueOf(userTicket.getUserLotteryId()));
    }

    public ResponseEntity<UserTicketSummaryResponse> getLotterySummary(Integer userId) {
        List<UserTicket> userTickets = userService.getAllTicketByUser(userId);

        int totalCount = userTickets.size();
        int totalCost = userTickets.stream().mapToInt(ticket -> ticket.getLottery().getPrice()).sum();

        List<String> uniqueTickets = userTickets.stream()
                .map(ticket -> ticket.getLottery().getTicket())
                .distinct()
                .toList();

        UserTicketSummaryResponse summaryResponse = new UserTicketSummaryResponse(uniqueTickets, totalCount, totalCost);

        return ResponseEntity.ok(summaryResponse);
    }

    public String dropLottery(Integer userId, Integer ticketId) {

    }
}
