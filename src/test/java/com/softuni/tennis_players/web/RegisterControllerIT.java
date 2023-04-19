package com.softuni.tennis_players.web;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testRegistration() throws Exception {
        mockMvc.perform(post("/register")
                        .param("username", "testtest")
                        .param("email", "test@example.com")
                        .param("fullName", "Test Test")
                        .param("password", "test12345")
                        .param("confirmPassword", "test12345")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection());
    }
    @Test
    void testRegistrationFailed() throws Exception {
        mockMvc.perform (post("/register")
                        .param ("username", "1L")
                        .param ("fullName", "Test Test")
                        .param ("email", "test@examle.com")
                        .param ("password", "test12345")
                        .param ("confirmPassword", "test12")
                        .with (csrf())
                ).andExpect (status ()
                        .is3xxRedirection ())
                .andExpect (redirectedUrl ("/register"));
    }
}