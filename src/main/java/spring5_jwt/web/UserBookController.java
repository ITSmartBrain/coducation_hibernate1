package spring5_jwt.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring5_jwt.dto.BookResponseDto;
import spring5_jwt.dto.BorrowRequestDto;
import spring5_jwt.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/user/books")
@RequiredArgsConstructor
public class UserBookController {

    private final BookService userBookService;


    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAvailableBooks() {
        return ResponseEntity.ok(userBookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(userBookService.findById(id));
    }

    @PostMapping("/borrow")
    public ResponseEntity<BookResponseDto> borrowBook(@RequestBody BorrowRequestDto requestDto) {
        return ResponseEntity.ok(userBookService.borrowBook(requestDto));
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<BookResponseDto> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(userBookService.returnBook(id));
    }
}

