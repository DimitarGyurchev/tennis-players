package com.softuni.tennis_players.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.softuni.tennis_players.domain.dtos.binding.CreateCommentDTO;
import com.softuni.tennis_players.domain.dtos.view.CommentViewDTO;
import com.softuni.tennis_players.domain.enitities.CommentEntity;
import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.repositories.CommentRepository;
import com.softuni.tennis_players.repositories.TennisPlayerRepository;
import com.softuni.tennis_players.repositories.UserRepository;

public class CommentServiceTest {
    @Mock
    private TennisPlayerRepository tennisPlayerRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentService commentService;

    private static final long PLAYER_ID = 1L;

    private static final long COMMENT_ID = 1L;

    private static final String USERNAME = "username";

    private static final String FULL_NAME = "full name";

    private static final String MESSAGE = "message";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCommentsForPlayer() {
        TennisPlayerEntity player = new TennisPlayerEntity();
        player.setId(PLAYER_ID);
        List<CommentEntity> comments = new ArrayList<>();
        CommentEntity comment = new CommentEntity();
        comment.setId(COMMENT_ID);
        UserEntity author = new UserEntity();
        author.setFullName(FULL_NAME);
        comment.setAuthor(author);
        comment.setText(MESSAGE);
        comments.add(comment);
        when(tennisPlayerRepository.findById(anyLong())).thenReturn(Optional.of(player));
        when(commentRepository.findAllByTennisPlayer(any(TennisPlayerEntity.class))).thenReturn(Optional.of(comments));

        List<CommentViewDTO> result = commentService.getAllCommentsForPlayer(PLAYER_ID);

        assertEquals(1, result.size());
        assertEquals(COMMENT_ID, result.get(0).getId());
        assertEquals(FULL_NAME, result.get(0).getCoachName());
    }

    @Test
    public void testCreateComment() {
        CreateCommentDTO commentDTO = new CreateCommentDTO();
        commentDTO.setUsername(USERNAME);
        commentDTO.setPlayerId(PLAYER_ID);
        commentDTO.setMessage(MESSAGE);
        UserEntity author = new UserEntity();
        author.setFullName(FULL_NAME);
        when(userRepository.findUserEntityByUsername(any(String.class))).thenReturn(Optional.of(author));
        when(tennisPlayerRepository.getById(anyLong())).thenReturn(new TennisPlayerEntity());
        CommentEntity savedComment = new CommentEntity();
        savedComment.setId(COMMENT_ID);
        savedComment.setAuthor(author);
        savedComment.setCreated(LocalDateTime.now());
        savedComment.setApproved(true);
        savedComment.setText(MESSAGE);
        when(commentRepository.save(any(CommentEntity.class))).thenReturn(savedComment);

        CommentViewDTO result = commentService.createComment(commentDTO);

        assertNotEquals(COMMENT_ID, result.getId());
        assertEquals(FULL_NAME, result.getCoachName());
    }
}

