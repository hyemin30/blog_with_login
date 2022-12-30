package hanghae.homework_posting.dto;

import hanghae.homework_posting.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class MemberRequestDto {

    private String username;
    private String password;


    public MemberRequestDto(Member member) {
        username = member.getUsername();
        password = member.getPassword();
    }
}
