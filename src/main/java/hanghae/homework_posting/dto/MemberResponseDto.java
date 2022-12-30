package hanghae.homework_posting.dto;


import hanghae.homework_posting.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private String username;
    private String password;


    public MemberResponseDto(Member member) {
        username = member.getUsername();
        password = member.getPassword();
    }
}
