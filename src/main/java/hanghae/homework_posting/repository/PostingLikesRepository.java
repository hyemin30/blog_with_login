package hanghae.homework_posting.repository;

import hanghae.homework_posting.entity.PostingLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostingLikesRepository extends JpaRepository<PostingLikes, Long> {

    List<PostingLikes> findByMemberIdAndPostingId(Long memberId, Long postingId);
}