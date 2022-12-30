package hanghae.homework_posting.controller;

import hanghae.homework_posting.dto.MemberRequestDto;
import hanghae.homework_posting.dto.ResponseDto;
import hanghae.homework_posting.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json; charset=utf8")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/singup")
    public ResponseEntity<String> createPosting(@Valid @RequestBody MemberRequestDto requestDto, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            log.info(bindingResult.toString());
            return new ResponseEntity<>("아이디는 영문소문자, 숫자 4~10자리, 비밀번호는 영문대소문자, 숫자 8~15자리로 입력하세요" , HttpStatus.BAD_REQUEST);
        }

        memberService.createMember(requestDto);

        return new ResponseEntity<>("회원가입 성공", HttpStatus.BAD_REQUEST);

    }

}
