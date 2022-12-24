package hanghae.homework2.controller;

import hanghae.homework2.dto.PostingRequestDto;
import hanghae.homework2.entity.Posting;
import hanghae.homework2.service.PostingService;
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
    public Long updatePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        return postingService.update(id, requestDto);
    }

    @GetMapping("/postings/{id}")
    public Posting getPosting(@PathVariable Long id) {
        return postingService.getPosting(id);
    }

    @DeleteMapping("/postings/{id}")
    public Long deletePosting(@PathVariable Long id) {
        return postingService.deletePosting(id);
    }
}
