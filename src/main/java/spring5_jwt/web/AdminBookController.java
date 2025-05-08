package spring5_jwt.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring5_jwt.dto.BookRequestDto;
import spring5_jwt.dto.BookResponseDto;
import spring5_jwt.dto.BorrowRequestDto;
import spring5_jwt.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/books")
@RequiredArgsConstructor
public class AdminBookController {

    private final BookService adminBookService;


    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        return ResponseEntity.ok(adminBookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(adminBookService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> addBook(@RequestBody BookRequestDto requestDto) {
        return ResponseEntity.ok(adminBookService.save(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(
            @PathVariable Long id,
            @RequestBody BookRequestDto requestDto) {
        return ResponseEntity.ok(adminBookService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        adminBookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/borrow")
    public ResponseEntity<BookResponseDto> borrowBook(@RequestBody BorrowRequestDto requestDto) {
        return ResponseEntity.ok(adminBookService.borrowBook(requestDto));
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<BookResponseDto> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(adminBookService.returnBook(id));
    }
}
