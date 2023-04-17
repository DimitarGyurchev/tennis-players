package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.dtos.binding.CreateCommentDTO;
import com.softuni.tennis_players.domain.dtos.view.CommentViewDTO;
import com.softuni.tennis_players.domain.enitities.CommentEntity;
import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.repositories.CommentRepository;
import com.softuni.tennis_players.repositories.TennisPlayerRepository;
import com.softuni.tennis_players.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final TennisPlayerRepository tennisPlayerRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public CommentService(TennisPlayerRepository tennisPlayerRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.tennisPlayerRepository = tennisPlayerRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public List<CommentViewDTO> getAllCommentsForPlayer(Long playerId){
        TennisPlayerEntity player = tennisPlayerRepository.findById(playerId).orElseThrow(IllegalArgumentException::new);
        List<CommentEntity> comments = commentRepository.findAllByTennisPlayer(player).get();
        return comments.stream().map(comment -> new CommentViewDTO(comment.getId(),comment.getAuthor().getFullName(),
                comment.getText())).collect(Collectors.toList());
    }

    public CommentViewDTO createComment(CreateCommentDTO commentDTO){
        UserEntity author = userRepository.findUserEntityByUsername(commentDTO.getUsername()).get();
        CommentEntity comment = new CommentEntity();
        comment.setCreated(LocalDateTime.now());
        comment.setTennisPlayer(tennisPlayerRepository.getById(commentDTO.getPlayerId()));
        comment.setAuthor(author);
        comment.setApproved(true);
        comment.setText(commentDTO.getMessage());
        commentRepository.save(comment);
        return new CommentViewDTO(comment.getId(), author.getFullName(), comment.getText());
    }
    public void deleteCommentsEveryWeek(){
        commentRepository.deleteAll(commentRepository.findAll());
    }
}
