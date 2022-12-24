package hanghae.homework_posting.controller;

import hanghae.homework_posting.dto.PostingRequestDto;
import hanghae.homework_posting.entity.Posting;
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
    public Posting createPosting(@RequestBody PostingRequestDto requestDto) {
        return postingService.createPosting(requestDto);
    }

    @GetMapping("/postings")
    public List<Posting> getPostings() {
        return postingService.getPostings();
    }

    @PutMapping("/postings/{id}")
    public Posting updatePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        return postingService.update(id, requestDto);
    }

    @GetMapping("/postings/{id}")
    public Posting getPosting(@PathVariable Long id) {
        return postingService.getPosting(id);
    }

    @DeleteMapping("/postings/{id}")
    public String deletePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        return postingService.deletePosting(id, requestDto);
    }
}
