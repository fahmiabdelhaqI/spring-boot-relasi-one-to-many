package com.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.crud.example.exception.notFoundException;
import com.crud.example.model.Page;
import com.crud.example.repositoy.BookRepository;
import com.crud.example.repositoy.PageRepository;
import com.crud.example.service.PageService;

import javassist.NotFoundException;

@RestController

@RequestMapping("/api/v2")
public class PageController {
	
	@Autowired
	private PageRepository pageRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/getAll/{book_id}/Page")
	public List<Page> getPageByBook_id(@PathVariable Long book_id) throws NotFoundException {
		
		if(!bookRepository.existsById(book_id)) {
			throw new NotFoundException("Book Not Found::" + book_id);
		}
		return pageRepository.findByBookId(book_id);
	}
	
	@GetMapping("/getAll")
	public List<Page> getPageAll() {
		return pageRepository.findAll();
	}
	
	@PostMapping("/postPage/{book_id}/Page")
	public Page createPage(@PathVariable Long book_id,
			@Validated @RequestBody Page page) throws NotFoundException {
		return bookRepository.findById(book_id)
				.map(book ->{
					page.setBook(book);
					return pageRepository.save(page);
				}).orElseThrow(() -> new NotFoundException("Book not found"));
	}
	
	@PutMapping("/puPage/Book/{book_id}/Page/{page_id}")
	public Page updatePage(@PathVariable Long book_id,
			@PathVariable Long page_id,
			@Validated @RequestBody Page PageUpdate) throws NotFoundException {
		if(!bookRepository.existsById(book_id)) {
			throw new NotFoundException("book not found!");
		}
		
		return pageRepository.findById(page_id)
				.map(page -> {
					page.setChapter(PageUpdate.getChapter());
					page.setContent(PageUpdate.getContent());
					page.setNumber(PageUpdate.getNumber());
					return pageRepository.save(page);
				}).orElseThrow(() -> new NotFoundException("Page Not Found"));
	}
	
	@DeleteMapping("/deletePage/Book/{book_id}/Page/{page_id}")
	public String deletePage(@PathVariable Long book_id,
			@PathVariable Long page_id) throws NotFoundException {
		if(!bookRepository.existsById(book_id)) {
			throw new NotFoundException("book not found");
		}
		
		return pageRepository.findById(page_id)
				.map(page -> {
					pageRepository.delete(page);
				 return "delete successfully";
				}).orElseThrow(()-> new NotFoundException("Page Not Found"));
	}
}
