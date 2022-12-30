package hanghae.homework_posting.service;

import hanghae.homework_posting.controller.EncryptionUtils;
import hanghae.homework_posting.dto.MemberRequestDto;
import hanghae.homework_posting.dto.MemberResponseDto;
import hanghae.homework_posting.entity.Member;
import hanghae.homework_posting.jwt.JwtUtil;
import hanghae.homework_posting.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;

    //    @Transactional
    public boolean createMember(MemberRequestDto requestDto) {

        List<Member> members = memberRepository.findAll();

        for (Member member : members) {
            if (member.getUsername().equals(requestDto.getUsername())) {
                return false;
            }
        }

        requestDto.setPassword(EncryptionUtils.encryptSHA256(requestDto.getPassword()));
        Member member = new Member(requestDto);
        Member findMember = memberRepository.save(member);
        if (findMember.getId() != null) {
            return true;
        }
        return false;
    }

    public boolean login(MemberRequestDto requestDto, HttpServletResponse response) {
        String username = requestDto.getUsername();
        String password = EncryptionUtils.encryptSHA256(requestDto.getPassword());

        Member member = memberRepository.findByUsername(username).orElse(new Member());

        if (!member.getPassword().equals(password) || member.getPassword().equals("0")) {
            return false;
        }

        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(member.getUsername()));
        return true;
    }


}
