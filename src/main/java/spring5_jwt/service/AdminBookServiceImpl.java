package spring5_jwt.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring5_jwt.domain.Book;
import spring5_jwt.domain.BookRepository;
import spring5_jwt.dto.BookRequestDto;
import spring5_jwt.dto.BookResponseDto;
import spring5_jwt.dto.BorrowRequestDto;
import spring5_jwt.dto.UserRequestDto;
import spring5_jwt.exception.BookAlreadyAvailableException;
import spring5_jwt.exception.BookNotAvailableException;
import spring5_jwt.exception.BookNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service("adminBookService")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminBookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BookResponseDto> findAll() {
        return bookRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDto findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return convertToDto(book);
    }

    @Override
    @Transactional
    public BookResponseDto save(BookRequestDto requestDto) {
        Book book = modelMapper.map(requestDto, Book.class);
        book.setAvailable(true);
        return convertToDto(bookRepository.save(book));
    }

    @Override
    @Transactional
    public BookResponseDto update(Long id, BookRequestDto requestDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        modelMapper.map(requestDto, book);
        return convertToDto(bookRepository.save(book));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public BookResponseDto borrowBook(BorrowRequestDto requestDto) {
        Book book = bookRepository.findById(requestDto.getBookId())
                .orElseThrow(() -> new BookNotFoundException(requestDto.getBookId()));

        if (!book.isAvailable()) {
            throw new BookNotAvailableException(requestDto.getBookId());
        }

        book.setAvailable(false);
        book.setDueDate(requestDto.getDueDate());

        return convertToDto(bookRepository.save(book));
    }

    @Override
    @Transactional
    public BookResponseDto returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        if (book.isAvailable()) {
            throw new BookAlreadyAvailableException(bookId);
        }

        book.setAvailable(true);
        book.setBorrower(null);
        book.setDueDate(null);

        return convertToDto(bookRepository.save(book));
    }

    @Override
    public void addUser(UserRequestDto userDto) {
        throw new RuntimeException("Not implemented yet");
    }

    private BookResponseDto convertToDto(Book book) {
        BookResponseDto dto = modelMapper.map(book, BookResponseDto.class);
        if (book.getBorrower() != null) {
            dto.setBorrowerUsername(book.getBorrower().getUsername());
        }
        return dto;
    }
}
