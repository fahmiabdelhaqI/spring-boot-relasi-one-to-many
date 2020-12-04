package com.crud.example.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.example.model.Book;
import com.crud.example.model.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long>{

	List<Page>findByBookId(Long book_id);
}
