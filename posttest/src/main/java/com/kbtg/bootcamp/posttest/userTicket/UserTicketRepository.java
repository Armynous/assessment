package com.kbtg.bootcamp.posttest.userTicket;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTicket, Integer> {
    @Query("SELECT u FROM UserTicket u WHERE u.user.id = :userId")
    List<UserTicket> findByUserId(Integer userId);

    void deleteById(Optional<Lottery> optionalTicket);
}
