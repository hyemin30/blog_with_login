package hanghae.homework_posting.dto;

import lombok.Data;
import lombok.Getter;

@Getter
public class PostingRequestDto {

    private String username;
    private String title;
    private String content;
    private String password;

}


