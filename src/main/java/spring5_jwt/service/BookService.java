package spring5_jwt.service;

import spring5_jwt.dto.BookRequestDto;
import spring5_jwt.dto.BookResponseDto;
import spring5_jwt.dto.BorrowRequestDto;
import spring5_jwt.dto.UserRequestDto;

import java.util.List;

public interface BookService {
    List<BookResponseDto> findAll();
    BookResponseDto findById(Long id);
    BookResponseDto save(BookRequestDto requestDto);
    BookResponseDto update(Long id, BookRequestDto requestDto);
    void deleteById(Long id);
    BookResponseDto borrowBook(BorrowRequestDto requestDto);
    BookResponseDto returnBook(Long bookId);
    void addUser(UserRequestDto userDto);
}