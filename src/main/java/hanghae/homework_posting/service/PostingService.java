package hanghae.homework_posting.service;

import hanghae.homework_posting.dto.PostingRequestDto;
import hanghae.homework_posting.dto.PostingResponse;
import hanghae.homework_posting.entity.Posting;
import hanghae.homework_posting.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;


    @Transactional
    public Long createPosting(PostingRequestDto requestDto) {
        Posting posting = new Posting(requestDto);
        postingRepository.save(posting);
        return posting.getId();
    }

    @Transactional
    public List<PostingResponse> getPostings() {
        List<Posting> postings = postingRepository.findAllByOrderByCreatedAtDesc();
        List<PostingResponse> responses = new ArrayList<>();
        for (Posting posting : postings) {
            responses.add(new PostingResponse(posting.getId(),posting));
        }
        return responses;
    }

    @Transactional
    public PostingResponse update(Long id, PostingRequestDto requestDto) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );

        if (posting.getPassword().equals(requestDto.getPassword())) {
            posting.update(requestDto);
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }
        return new PostingResponse(id, posting);
    }

    @Transactional
    public PostingResponse getPosting(Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        return new PostingResponse(id, posting);
    }

    @Transactional
    public String deletePosting(Long id, PostingRequestDto requestDto) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );

        if (posting.getPassword().equals(requestDto.getPassword())) {
            postingRepository.deleteById(id);
            return "성공";
        } else {
            return "비밀번호가 일치하지 않습니다";
        }

    }

    @Transactional
    public void deleteAll() {
        postingRepository.deleteAll();
    }


}
