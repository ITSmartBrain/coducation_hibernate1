package spring4_security_basic.service;

import spring4_security_basic.dto.BookRequestDto;
import spring4_security_basic.dto.BookResponseDto;
import spring4_security_basic.dto.BorrowRequestDto;

import java.util.List;

public interface BookService {
    List<BookResponseDto> findAll();
    BookResponseDto findById(Long id);
    BookResponseDto save(BookRequestDto requestDto);
    BookResponseDto update(Long id, BookRequestDto requestDto);
    void deleteById(Long id);
    BookResponseDto borrowBook(BorrowRequestDto requestDto);
    BookResponseDto returnBook(Long bookId);
}