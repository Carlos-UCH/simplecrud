package com.carlos.books.crudbooks.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.carlos.books.crudbooks.dataclass.Book;
import com.carlos.books.crudbooks.dataclass.BookRepository;
import com.carlos.books.crudbooks.dataclass.DataRegister;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

   @PostMapping
   public ResponseEntity cadastrar(@RequestBody @Valid DataRegister data){
    var book = new Book(data);
    bookRepository.save(book);
    return ResponseEntity.ok().build();

   }
    
    
}
