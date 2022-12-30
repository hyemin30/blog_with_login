package hanghae.homework_posting.service;

import hanghae.homework_posting.dto.MemberRequestDto;
import hanghae.homework_posting.dto.MemberResponseDto;
import hanghae.homework_posting.dto.PostingResponseDto;
import hanghae.homework_posting.entity.Member;
import hanghae.homework_posting.entity.Posting;
import hanghae.homework_posting.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto createMember(MemberRequestDto requestDto) {
        Member member = new Member(requestDto);

        Member savedMember = memberRepository.save(member);
        return new MemberResponseDto(savedMember);
    }
}
