package hanghae.homework_posting.entity;

import hanghae.homework_posting.dto.PostingRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class NoPwdPosting extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    public NoPwdPosting(String username, String title, String content, String password) {
        this.username = username;
        this.title = title;
        this.content = content;
    }

    public NoPwdPosting(PostingRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void update(PostingRequestDto requestDto) {

        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();

    }


}
