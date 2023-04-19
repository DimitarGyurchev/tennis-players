package com.softuni.tennis_players.web;

import com.softuni.tennis_players.domain.dtos.binding.UserProfileDTO;
import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.security.Principal;
import java.util.Collections;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser(username = "testuser", roles = {"ADMIN"})
    public void testProfile() throws Exception {
        UserEntity userEntity = new UserEntity()
                .setUsername("testuser")
                .setPassword("password")
                .setEmail("testuser@example.com")
                .setFullName("Test User")
                .setRoles(Collections.emptyList());
        when(userService.getUser("testuser")).thenReturn(userEntity);

        mockMvc.perform(MockMvcRequestBuilders.get("/profile"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("profile"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"));
    }
}
