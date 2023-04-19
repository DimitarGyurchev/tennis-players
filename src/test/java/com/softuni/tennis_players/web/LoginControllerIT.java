package com.softuni.tennis_players.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


    @SpringBootTest
    @AutoConfigureMockMvc
    public class LoginControllerIT {
        @Autowired
        private MockMvc mockMvc;
        @Test
        void  testLogin() throws Exception {
            mockMvc.perform(get("/login")
                            .param("username", "testtest")
                            .param("password", "test12345")
                            .with (csrf()))
                    .andExpect (status ()
                            .is2xxSuccessful ());
        }
        @Test
        void testLoginFailed() throws Exception {
            mockMvc.perform(post("/login")
                            .param("username", "")
                            .param("password", "")
                            .with (csrf()))
                    .andExpect (status ()
                            .is2xxSuccessful ());
        }
    }


