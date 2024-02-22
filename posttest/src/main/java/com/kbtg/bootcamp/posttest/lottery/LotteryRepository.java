package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, String> {

    boolean existsByTicket(String ticket);

    @Query("SELECT l FROM Lottery l WHERE l.ticket LIKE %:ticketId%")
    Optional<Lottery> findByTicket(@Param("ticketId") String ticketId);

}
