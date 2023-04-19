package com.softuni.tennis_players.web;

import com.softuni.tennis_players.services.CoachService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CoachControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @MockBean
    private CoachService coachService;



    @Test
    public void testGetAllCoaches() throws Exception {
        when(coachService.getCoaches()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/allcoaches"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("allcoaches"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("coaches"))
                .andExpect(MockMvcResultMatchers.model().attribute("coaches", Collections.emptyList()));
    }

}
