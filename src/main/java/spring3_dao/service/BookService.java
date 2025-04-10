package spring3_dao.service;

import spring3_dao.dto.BookRequestDto;
import spring3_dao.dto.BookResponseDto;
import spring3_dao.dto.BorrowRequestDto;

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