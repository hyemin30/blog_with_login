package hanghae.homework2.repository;

import hanghae.homework2.dto.NoPwdPostingRequestDto;
import hanghae.homework2.entity.NoPwdPosting;
import hanghae.homework2.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {

    List<Posting> findAllByOrderByModifiedAtDesc();
}
