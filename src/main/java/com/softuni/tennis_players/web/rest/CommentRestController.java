package com.softuni.tennis_players.web.rest;

import com.softuni.tennis_players.domain.dtos.binding.CommentCreationDTO;
import com.softuni.tennis_players.domain.dtos.binding.CommentMessageDTO;
import com.softuni.tennis_players.domain.dtos.view.CommentViewDTO;
import com.softuni.tennis_players.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentRestController {
    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{playerId}/comments")
    public ResponseEntity<List<CommentViewDTO>> getComments(@PathVariable("playerId")Long playerId){
        return ResponseEntity.ok(commentService.getAllCommentsForPlayer(playerId));
    }

//    @PostMapping(value = "/{playerId}/comments",consumes = "application/json",produces = "application/json")
//    public ResponseEntity<CommentViewDTO> createComment(@PathVariable("playerId")Long playerId,
//                                                        @AuthenticationPrincipal UserDetails userDetails,
//                                                        @RequestBody CommentMessageDTO commentMessageDTO){
//        CommentCreationDTO commentCreationDTO = new CommentCreationDTO (
//          userDetails.getUsername(),
//          playerId,
//                commentMessageDTO.getMessage()
//        );
//        CommentViewDTO comment = commentService.createComment(commentCreationDTO);
//        return ResponseEntity
//                .created(URI.create(String.format("/api/%d/comments/%d",playerId,comment.getId())))
//                .body(comment);
//    }
}
