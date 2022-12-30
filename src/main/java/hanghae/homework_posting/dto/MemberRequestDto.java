package hanghae.homework_posting.dto;

import hanghae.homework_posting.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
public class MemberRequestDto {

    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{4,10}")
    private String username;
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{8,15}")
    private String password;

    public MemberRequestDto(Member member) {
        username = member.getUsername();
        password = member.getPassword();
    }
}
