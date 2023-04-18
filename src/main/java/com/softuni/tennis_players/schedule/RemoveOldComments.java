package com.softuni.tennis_players.schedule;

import com.softuni.tennis_players.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RemoveOldComments {
    private final CommentService commentService;
    @Autowired
    public RemoveOldComments(CommentService commentService) {
        this.commentService = commentService;
    }
    @Scheduled(cron = "0 0 1 ? * MON")
    public void deleteCommentsEveryWeek(){
        this.commentService.deleteCommentsEveryWeek();
    }
}
