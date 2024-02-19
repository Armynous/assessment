package com.kbtg.bootcamp.posttest.user;

import com.kbtg.bootcamp.posttest.userTicket.UserTicket;
import com.kbtg.bootcamp.posttest.userTicket.UserTicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserTicketRepository userTicketRepository;

    public UserService(UserTicketRepository userTicketRepository) {
        this.userTicketRepository = userTicketRepository;
    }

    public List<UserTicket> getAllTicketByUser(Integer userId) {
        return userTicketRepository.findByUserId(userId);
    }
}
