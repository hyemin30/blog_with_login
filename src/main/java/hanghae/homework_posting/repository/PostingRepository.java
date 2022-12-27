package hanghae.homework_posting.repository;

import hanghae.homework_posting.dto.PostingResponse;
import hanghae.homework_posting.dto.PostingResponseDto;
import hanghae.homework_posting.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {

    List<Posting> findAllByOrderByModifiedAtDesc();

}
