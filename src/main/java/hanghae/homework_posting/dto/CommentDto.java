package hanghae.homework_posting.dto;

import hanghae.homework_posting.entity.Comment;
import hanghae.homework_posting.entity.Posting;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {

    private Long id;
    private String content;
    private Posting posting;

    public CommentDto(Comment comment) {
        content = comment.getContent();
    }
}
