package com.kbtg.bootcamp.posttest;

import com.kbtg.bootcamp.posttest.exception.DeletionFailedException;
import com.kbtg.bootcamp.posttest.exception.DuplicateException;
import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import com.kbtg.bootcamp.posttest.lottery.LotteryRepository;
import com.kbtg.bootcamp.posttest.lottery.LotteryRequest;
import com.kbtg.bootcamp.posttest.lottery.LotteryService;
import com.kbtg.bootcamp.posttest.user.UserRepository;
import com.kbtg.bootcamp.posttest.userTicket.UserTicketRepository;
import com.kbtg.bootcamp.posttest.userTicket.UserTicketService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PostTestApplicationTest {

    @InjectMocks
    private UserTicketService userTicketService;

    @InjectMocks
    private LotteryService lotteryService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserTicketRepository userTicketRepository;

    @Mock
    private LotteryRepository lotteryRepository;

    @Test
    void testBuyLottery_Exception() {
        // Mock the repositories to return empty optionals
        when(userRepository.findById("invalidUserId")).thenReturn(Optional.empty());
        when(lotteryRepository.findByTicket("invalidTicketId")).thenReturn(Optional.empty());

        // Call the method and assert the thrown exception
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> userTicketService.buyLottery("invalidUserId", "invalidTicketId"));

        assertEquals("Your user id must be a 10-digit", exception.getMessage());
    }

    @Test
    void testCreateLottery_DuplicateException() {
        // Mock the repository to return true for existsByTicket
        when(lotteryRepository.existsByTicket("duplicateTicket")).thenReturn(true);

        // Call the method and assert the thrown exception
        DuplicateException exception = assertThrows(DuplicateException.class,
                () -> lotteryService.createLottery(new LotteryRequest("duplicateTicket", 80, 1)));

        assertEquals("Lottery number already exists: duplicateTicket", exception.getMessage());
    }

    @Test
    void testDropLottery_DeletionFailedException() {
        // Mock the repository to return empty optional
        when(userTicketRepository.findAllById("invalidUserId", "invalidTicketId")).thenReturn(Optional.empty());

        // Call the method and assert the thrown exception
        DeletionFailedException exception = assertThrows(DeletionFailedException.class,
                () -> userTicketService.dropLottery("invalidUserId", "invalidTicketId"));

        assertEquals("Invalid your user id or ticket number", exception.getMessage());
    }


}