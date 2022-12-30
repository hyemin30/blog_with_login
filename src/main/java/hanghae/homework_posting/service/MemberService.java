package hanghae.homework_posting.service;

import hanghae.homework_posting.dto.MemberRequestDto;
import hanghae.homework_posting.dto.MemberResponseDto;
import hanghae.homework_posting.entity.Member;
import hanghae.homework_posting.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto createMember(MemberRequestDto requestDto) {

        Member member = new Member(requestDto);

        Member savedMember = memberRepository.save(member);
        return new MemberResponseDto(savedMember);
    }

    public boolean login(MemberRequestDto requestDto) {
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            if (member.getPassword().equals(requestDto.getPassword()) && member.getUsername().equals(requestDto.getUsername())) {
                return true;
            }
        }
        return false;
    }

}
