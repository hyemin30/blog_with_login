package hanghae.homework_posting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hanghae.homework_posting.dto.PostingRequestDto;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Posting extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "posting_id")
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false, updatable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;



    public Posting(PostingRequestDto requestDto, Member member) {
        this.member = member;
        title = requestDto.getTitle();
        content = requestDto.getContent();
        password = requestDto.getPassword();
    }

    public void update(PostingRequestDto requestDto) {
        title = requestDto.getTitle();
        content = requestDto.getContent();
    }

    // 생성 메서드
    public static Posting createPosting(Member member) {
        Posting posting = new Posting();
        posting.setMember(member);
        return posting;
    }
}
