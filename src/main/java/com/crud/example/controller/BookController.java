package com.crud.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.model.Book;
import com.crud.example.repositoy.BookRepository;


import javassist.NotFoundException;

@RestController
@RequestMapping("/api/v2")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/get")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Book getBookById(@PathVariable Long id) throws NotFoundException {
		Optional<Book> opBook = bookRepository.findById(id);
		if(opBook.isPresent()) {
			return opBook.get();
		}else {
			throw new NotFoundException("Book is not found ::" + id);
		}
	}
	
	@PostMapping("/Post")
	public 	Book createBook(@Validated @RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable (value = "id") Long id,
			@Validated @RequestBody Book bookDetails) throws NotFoundException{
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Book no found ::" + id));
		book.setAuthor(bookDetails.getAuthor());
		book.setIsbn(bookDetails.getIsbn());
		book.setPage(bookDetails.getPage());
		book.setTitle(bookDetails.getTitle());
		final Book updateBook =  bookRepository.save(book);
		return ResponseEntity.ok(updateBook);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id) throws NotFoundException {
		return bookRepository.findById(id)
				.map(book -> {
					bookRepository.delete(book);
					return "Delete successfully";
				}).orElseThrow(() -> new NotFoundException("Book not found" + id));
	}
	

}
