package hanghae.homework_posting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hanghae.homework_posting.dto.PostingRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Posting extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false, updatable = false)
    @JsonIgnore
    private String password;

    public Posting(PostingRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    public void update(PostingRequestDto requestDto) {

        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
