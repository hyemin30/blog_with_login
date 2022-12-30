package hanghae.homework_posting.dto;

import hanghae.homework_posting.entity.Member;
import hanghae.homework_posting.entity.Posting;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostingResponseDto {
    private String username;
    private String title;
    private String content;

    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostingResponseDto(Long id, Posting posting) {
        this.id = id;
        title = posting.getTitle();
        username = posting.getMember().getUsername();
        content = posting.getContent();
        createdAt = posting.getCreatedAt();
        modifiedAt = posting.getModifiedAt();
    }
}
