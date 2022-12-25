package hanghae.homework_posting.service;

import hanghae.homework_posting.dto.PostingRequestDto;
import hanghae.homework_posting.entity.Posting;
import hanghae.homework_posting.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;

    @Transactional
    public Posting createPosting(PostingRequestDto requestDto) {
        Posting posting = new Posting(requestDto);
        postingRepository.save(posting);
        return posting;
    }

    @Transactional
    public List<Posting> getPostings() {
        return postingRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Posting update(Long id, PostingRequestDto requestDto) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );

        if (posting.getPassword().equals(requestDto.getPassword())) {
            posting.update(requestDto);
        } else {
            new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }
        return posting;
    }

    @Transactional
    public Posting getPosting(Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        return posting;
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
            new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }

        return "실패";
    }



}
