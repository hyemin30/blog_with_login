package hanghae.homework_posting.repository;

import hanghae.homework_posting.dto.PostingResponseDto;
import hanghae.homework_posting.entity.Posting;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostingRepositoryImpl {

    @PersistenceContext
    EntityManager em;




}
