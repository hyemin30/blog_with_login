package hanghae.homework_posting.dto;

import hanghae.homework_posting.entity.Posting;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class PostingRequestDto {

    private String username;
    private String title;
    private String content;
    private String password;

    @Builder
    @Data
    public static class MyPosting {
        private String username;
        private String title;
        private String content;


    }

}
