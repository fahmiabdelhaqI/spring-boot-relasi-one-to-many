package com.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.example.model.Page;
import com.crud.example.repositoy.BookRepository;
import com.crud.example.repositoy.PageRepository;

@Service
public class PageService {

	@Autowired
	private PageRepository pageRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Page> getAllPage() {
		return pageRepository.findAll();
	}
}
