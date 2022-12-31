package hanghae.homework_posting.entity;

import hanghae.homework_posting.dto.CommentRequestDto;
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

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Comment(CommentRequestDto commentDto) {
        content = commentDto.getContent();
    }

    // 생성 메서드
    public Comment createComment(Posting posting, Comment comment, Member member) {
        comment.setPosting(posting);
        comment.setMember(member);
        List<Comment> comments = posting.getComments();
        comments.add(comment);
        posting.setComments(comments);
        return comment;
    }

    public void update(CommentRequestDto requestDto) {
        content = requestDto.getContent();
    }
}

