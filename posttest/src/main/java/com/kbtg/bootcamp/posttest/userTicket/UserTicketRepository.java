package com.kbtg.bootcamp.posttest.userTicket;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTicket, Integer> {
    @Query("SELECT u FROM UserTicket u WHERE u.user.id = :userId")
    List<UserTicket> findByUserId(Integer userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserTicket ut WHERE ut.user.id = :userId AND ut.lottery.id = :ticketId")
    void dropLottery(@Param("userId") Integer userId, @Param("ticketId") Integer ticketId);

    @Query("SELECT ut FROM UserTicket ut WHERE ut.user.id = :userId AND ut.lottery.id = :ticketId")
    Optional<UserTicket> findAllById(@Param("userId") Integer userId, @Param("ticketId") Integer ticketId);

}
