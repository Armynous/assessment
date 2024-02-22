package com.kbtg.bootcamp.posttest.userTicket;

import com.kbtg.bootcamp.posttest.configResponse.userTicketResponse.UserTicketDropResponse;
import com.kbtg.bootcamp.posttest.configResponse.userTicketResponse.UserTicketResponseId;
import com.kbtg.bootcamp.posttest.configResponse.userTicketResponse.UserTicketSummaryResponse;
import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryRepository;
import com.kbtg.bootcamp.posttest.user.User;
import com.kbtg.bootcamp.posttest.user.UserRepository;
import com.kbtg.bootcamp.posttest.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public UserTicketResponseId createLottery(String userId, String ticketId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Lottery> optionalTicket = lotteryRepository.findByTicket(ticketId);

        if (optionalUser.isPresent() && optionalTicket.isPresent()) {
            User user = optionalUser.get();
            Lottery lottery = optionalTicket.get();

            UserTicket userTicket = new UserTicket(user, lottery, new Date());

            userTicketRepository.save(userTicket);

            return new UserTicketResponseId(String.valueOf(userTicket.getUserLotteryId()));
        } else {
            throw new NotFoundException("Ticket number already out");
        }

    }

    public ResponseEntity<UserTicketSummaryResponse> getLotterySummary(String userId) {
        List<UserTicket> userTickets = userService.getAllTicketByUser(userId);

        int totalCount = userTickets.size();
        int totalCost = userTickets.stream().mapToInt(ticket -> ticket.getLottery().getPrice()).sum();

        List<String> uniqueTickets = userTickets.stream()
                .map(ticket -> ticket.getLottery().getTicket())
//                .distinct()
                .toList();

        UserTicketSummaryResponse summaryResponse = new UserTicketSummaryResponse(uniqueTickets, totalCount, totalCost);

        return ResponseEntity.ok(summaryResponse);
    }

    public UserTicketDropResponse dropLottery(String userId, String ticketId) {

        Optional<UserTicket> deleteTicket = userTicketRepository.findAllById(userId, ticketId);

        userTicketRepository.dropLottery(userId, ticketId);

        return deleteTicket.map(userTicket -> new UserTicketDropResponse(userTicket.getLottery().getTicket()))
                .orElse(new UserTicketDropResponse("error"));

    }
}
