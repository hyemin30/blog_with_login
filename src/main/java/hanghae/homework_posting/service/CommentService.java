package hanghae.homework_posting.service;

import hanghae.homework_posting.dto.CommentDto;
import hanghae.homework_posting.dto.PostingResponseDto;
import hanghae.homework_posting.entity.Comment;
import hanghae.homework_posting.entity.Posting;
import hanghae.homework_posting.jwt.JwtUtil;
import hanghae.homework_posting.repository.CommentRepostiory;
import hanghae.homework_posting.repository.PostingRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepostiory commentRepostiory;
    private final PostingRepository postingRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public CommentDto createComment(Long id, CommentDto requestDto, HttpServletRequest request) {
        Claims claims = getClaims(request);
        String username = claims.getSubject();

        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시글입니다")
        );

        Comment comment = new Comment(requestDto);
        comment.createComment(posting, comment);
        commentRepostiory.save(comment);
        return new CommentDto(comment);
    }

    private Claims getClaims(HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims = null;

        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token ERROR");
            }
        }
        return claims;
    }
}
