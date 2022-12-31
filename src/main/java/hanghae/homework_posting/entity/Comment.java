package hanghae.homework_posting.entity;

import hanghae.homework_posting.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "posting_id")
    private Posting posting;

    public Comment(CommentDto commentDto) {
        content = commentDto.getContent();
    }

    // 생성 메서드
    public Comment createComment(Posting posting, Comment comment) {
        comment.setPosting(posting);
        List<Comment> comments = posting.getComments();
        comments.add(comment);
        posting.setComments(comments);
        return comment;
    }
}

