package hanghae.homework_posting.repository;

import hanghae.homework_posting.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {

}
