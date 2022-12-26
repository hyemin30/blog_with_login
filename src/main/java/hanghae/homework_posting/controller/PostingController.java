package hanghae.homework_posting.controller;

import hanghae.homework_posting.dto.PostingRequestDto;
import hanghae.homework_posting.dto.PostingResponse;
import hanghae.homework_posting.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;

    @GetMapping("/")
    public String home() {
        return "this is home";
    }

    @PostMapping("/postings")
    public PostingResponse createPosting(@RequestBody PostingRequestDto requestDto) {
        Long id = postingService.createPosting(requestDto);
        return postingService.getPosting(id);
    }

    @GetMapping("/postings")
    public List<PostingResponse> getPostings() {
        return postingService.getPostings();
    }

    @PutMapping("/postings/{id}")
    public PostingResponse updatePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        return postingService.update(id, requestDto);
    }

    @GetMapping("/postings/{id}")
    public PostingResponse getPosting(@PathVariable Long id) {
        return postingService.getPosting(id);
    }

    @DeleteMapping("/postings/{id}")
    public String deletePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        return postingService.deletePosting(id, requestDto);
    }
}
