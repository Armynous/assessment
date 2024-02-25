package com.kbtg.bootcamp.posttest.lottery;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kbtg.bootcamp.posttest.configResponse.lotteryResponse.AllLotteryResponse;
import com.kbtg.bootcamp.posttest.configResponse.lotteryResponse.LotteryResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.contains;

@ExtendWith(MockitoExtension.class)
class LotteryControllerTest {

    MockMvc mockMvc;
    @Mock
    LotteryService lotteryService;

    @InjectMocks
    LotteryController lotteryController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(lotteryController)
                .build();
    }

    @Test
    void getLotteryList() throws Exception {
        when(lotteryService.findAllLottery()).thenReturn(new AllLotteryResponse(Arrays.asList(
                "247890",
                "123456"
        )));

        mockMvc.perform(get("/lotteries"))  // Assuming the correct endpoint path is "/lotteries"
                .andExpect(jsonPath("$.tickets", contains("247890", "123456")))
                .andExpect(status().isOk());
    }
}
