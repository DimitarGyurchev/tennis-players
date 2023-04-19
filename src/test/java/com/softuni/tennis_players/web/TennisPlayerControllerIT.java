package com.softuni.tennis_players.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softuni.tennis_players.domain.dtos.binding.AddTennisPlayerDTO;
import com.softuni.tennis_players.domain.dtos.view.TennisPlayerViewDTO;
import com.softuni.tennis_players.services.CoachService;
import com.softuni.tennis_players.services.SponsorService;
import com.softuni.tennis_players.services.TennisPlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TennisPlayerControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TennisPlayerService tennisPlayerService;

    @MockBean
    private SponsorService sponsorService;

    @MockBean
    private CoachService coachService;



    @Test
    void testCreatePlayer() throws Exception {
        AddTennisPlayerDTO addTennisPlayerDTO = new AddTennisPlayerDTO();
        addTennisPlayerDTO.setFirstName("Rafael");
        addTennisPlayerDTO.setLastName("Nadal");
        addTennisPlayerDTO.setAge(35);

    }

    @Test
    void testGetAllPlayers() throws Exception {
        TennisPlayerViewDTO player1 = new TennisPlayerViewDTO();
        player1.setId(1L);
        player1.setFirstName("Rafael");
        player1.setLastName("Nadal");
        player1.setAge(35);

        TennisPlayerViewDTO player2 = new TennisPlayerViewDTO();
        player2.setId(2L);
        player2.setFirstName("Roger");
        player2.setLastName("Federer");
        player2.setAge(39);

        List<TennisPlayerViewDTO> players = Arrays.asList(player1, player2);

        when(tennisPlayerService.getAllPlayers()).thenReturn(players);

        mockMvc.perform(get("/alltennisplayers"))
                .andExpect(status().isOk())
                .andExpect(view().name("alltennisplayers"))
                .andExpect(model().attributeExists("players"))
                .andExpect(model().attribute("players", players));
    }


}
