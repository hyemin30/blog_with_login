package hanghae.homework_posting.controller;

import hanghae.homework_posting.dto.PostingRequestDto;
import hanghae.homework_posting.dto.PostingResponseDto;
import hanghae.homework_posting.service.PostingService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;

    @GetMapping("/")
    public String home() {
        return "this is home";
    }

    // Entity의 변수명을 바꾸면 API 스펙 자체가 바뀜 예) username -> name
    // Entity는 굉장히 여러 곳에서 쓰기 때문에.. 문제가 될 수 있음
    // 조회 조건이 다 다를 수 있다(예, 비번 제외 등) 경우의 수마다 JsonIgnore??
    // 결론 -> API 스펙을 위한 별도의 dto가 필요하다
    // -> API 만들 떈 항상 엔티티를 파라미터로 받지 말 것. 엔티티 노출 금지

    @PostMapping("/postings")
    public PostingResponseDto createPosting(@RequestBody PostingRequestDto requestDto) {
        Long id = postingService.createPosting(requestDto);
        return postingService.getPosting(id);
    }

    @GetMapping("/postings")
    public List<PostingResponseDto> getPostings() {
        return postingService.getPostings();
    }

    @GetMapping("/v2/postings")
    public Result membersV2() {
        //List로 바로 반환하는 것이 아니라 Result로 감싸서 반환한다 -> 유연성
        List<PostingResponseDto> postings = postingService.getPostings().stream().collect(Collectors.toList());
        return new Result(postings);
    }

    @PutMapping("/postings/{id}")
    public PostingResponseDto updatePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        return postingService.update(id, requestDto);
    }

    @GetMapping("/postings/{id}")
    public PostingResponseDto getPosting(@PathVariable Long id) {
        return postingService.getPosting(id);
    }

    @DeleteMapping("/postings/{id}")
    public String deletePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        return postingService.deletePosting(id, requestDto);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> { //<T> 이렇게 감싸서 반환하면 배열타입보다 유연성이 생겨서 좋음
        private T data;
    }
}
