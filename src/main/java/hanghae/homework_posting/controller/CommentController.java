package hanghae.homework_posting.controller;

import hanghae.homework_posting.dto.CommentDto;
import hanghae.homework_posting.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json; charset=utf8")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments/{id}")
    public CommentDto createComment(@PathVariable Long id, @RequestBody CommentDto requestDto, HttpServletRequest request) {
        return commentService.createComment(id, requestDto, request);
    }
}
