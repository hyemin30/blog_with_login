package hanghae.homework_posting.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class PostingResponseDto {

    private String username;
    private String title;
    private String content;

}
