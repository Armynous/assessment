package com.kbtg.bootcamp.posttest.userTicket;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTicket, String> {
    @Query("SELECT ut FROM UserTicket ut WHERE ut.user.id = :userId")
    List<UserTicket> findByUserId(String userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserTicket ut WHERE ut.user.id = :userId AND ut.lottery.ticket = :ticketId")
    void dropLottery(@Param("userId") String userId, @Param("ticketId") String ticketId);

    @Query("SELECT ut FROM UserTicket ut WHERE ut.user.id = :userId AND ut.lottery.ticket = :ticketId")
    Optional<UserTicket> findAllById(@Param("userId") String userId, @Param("ticketId") String ticketId);
}
