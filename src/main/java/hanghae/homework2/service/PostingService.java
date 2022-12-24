package hanghae.homework2.service;

import hanghae.homework2.dto.NoPwdPostingRequestDto;
import hanghae.homework2.dto.PostingRequestDto;
import hanghae.homework2.entity.NoPwdPosting;
import hanghae.homework2.entity.Posting;
import hanghae.homework2.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
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
    public Long update(Long id, PostingRequestDto requestDto) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );

        posting.update(requestDto);
        return posting.getId();
    }

    @Transactional
    public Posting getPosting(Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        return posting;
    }

    @Transactional
    public Long deletePosting(Long id) {
        postingRepository.deleteById(id);
        return id;
    }


}
