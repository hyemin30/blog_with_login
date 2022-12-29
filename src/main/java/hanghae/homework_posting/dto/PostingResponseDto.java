package hanghae.homework_posting.dto;

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
        this.title = posting.getTitle();
        this.username = posting.getUsername();
        this.content = posting.getContent();
        this.createdAt = posting.getCreatedAt();
        this.modifiedAt = posting.getModifiedAt();
    }
}
