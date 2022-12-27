package hanghae.homework_posting.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostingRequestDto {

    private String username;
    private String title;
    private String content;
    private String password;

}


