package hanghae.homework_posting.service;

import hanghae.homework_posting.dto.PostingRequestDto;
import hanghae.homework_posting.dto.PostingResponseDto;
import hanghae.homework_posting.entity.Member;
import hanghae.homework_posting.entity.Posting;
import hanghae.homework_posting.jwt.JwtUtil;
import hanghae.homework_posting.repository.MemberRepository;
import hanghae.homework_posting.repository.PostingRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;
    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;


    @Transactional
    public Long createPosting(PostingRequestDto requestDto, HttpServletRequest request) {
        Claims claims = getClaims(request);
        Member member = new Member();
        try {
            member = memberRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다")
            );
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        Posting posting = new Posting(requestDto, member);
        posting.createPosting(member);
        postingRepository.save(posting);
        return posting.getId();
    }

    @Transactional
    public List<PostingResponseDto> getPostings() {
        List<Posting> postings = postingRepository.findAllByOrderByCreatedAtDesc();
        List<PostingResponseDto> responses = new ArrayList<>();
        for (Posting posting : postings) {
            responses.add(new PostingResponseDto(posting.getId(),posting));
        }
        return responses;
    }

    @Transactional
    public PostingResponseDto update(Long id, PostingRequestDto requestDto, HttpServletRequest request) {
        Claims claims = getClaims(request);
        String username = claims.getSubject();

        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시글입니다")
        );
        if (username.equals(posting.getMember().getUsername())) {
            posting.update(requestDto);
            return new PostingResponseDto(id, posting);
        }
        throw new IllegalArgumentException("본인의 글만 수정 가능합니다");
    }

    @Transactional
    public PostingResponseDto getPosting(Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        return new PostingResponseDto(id, posting);
    }

    @Transactional
    public boolean deletePosting(Long id, PostingRequestDto requestDto, HttpServletRequest request) {
        Claims claims = getClaims(request);
        String username = claims.getSubject();

        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시글입니다")
        );

        if (username.equals(posting.getMember().getUsername())) {
            postingRepository.delete(posting);
            return true;
        }
        return false;
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

    @Transactional
    public void deleteAll() {
        postingRepository.deleteAll();
    }


}
