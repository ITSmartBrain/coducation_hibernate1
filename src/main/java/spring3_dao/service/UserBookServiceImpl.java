package spring3_dao.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring3_dao.domain.Book;
import spring3_dao.domain.BookRepository;
import spring3_dao.domain.User;
import spring3_dao.domain.UserRepository;
import spring3_dao.dto.BookRequestDto;
import spring3_dao.dto.BookResponseDto;
import spring3_dao.dto.BorrowRequestDto;
import spring3_dao.exception.BookAlreadyAvailableException;
import spring3_dao.exception.BookNotAvailableException;
import spring3_dao.exception.BookNotFoundException;
import spring3_dao.exception.UserNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service("userBookService")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserBookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BookResponseDto> findAll() {
        return bookRepository.findByAvailableTrue().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDto findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        if (!book.isAvailable()) {
            throw new BookNotAvailableException(id);
        }

        return convertToDto(book);
    }

    @Override
    @Transactional
    public BookResponseDto borrowBook(BorrowRequestDto requestDto) {
        Book book = bookRepository.findById(requestDto.getBookId())
                .orElseThrow(() -> new BookNotFoundException(requestDto.getBookId()));

        if (!book.isAvailable()) {
            throw new BookNotAvailableException(requestDto.getBookId());
        }

        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(requestDto.getUserId()));

        book.setAvailable(false);
        book.setBorrower(user);
        book.setDueDate(requestDto.getDueDate());

        return convertToDto(bookRepository.save(book));
    }

    // Остальные методы возвращают UnsupportedOperationException
    @Override
    public BookResponseDto save(BookRequestDto requestDto) {
        throw new UnsupportedOperationException("Users cannot add books");
    }

    @Override
    public BookResponseDto update(Long id, BookRequestDto requestDto) {
        throw new UnsupportedOperationException("Users cannot update books");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Users cannot delete books");
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

    private BookResponseDto convertToDto(Book book) {
        BookResponseDto dto = modelMapper.map(book, BookResponseDto.class);
        if (book.getBorrower() != null) {
            dto.setBorrowerUsername(book.getBorrower().getUsername());
        }
        return dto;
    }
}

