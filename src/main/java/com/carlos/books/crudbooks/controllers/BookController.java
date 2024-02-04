package com.carlos.books.crudbooks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.carlos.books.crudbooks.dataclass.Book;
import com.carlos.books.crudbooks.dataclass.BookRepository;
import com.carlos.books.crudbooks.dataclass.DataDatails;
import com.carlos.books.crudbooks.dataclass.DataList;
import com.carlos.books.crudbooks.dataclass.DataRegister;
import com.carlos.books.crudbooks.dataclass.DataUpdate;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;


   @PostMapping
   public ResponseEntity<DataDatails> register(@RequestBody @Valid DataRegister data, UriComponentsBuilder uriBuilder){
    var book = new Book(data);
    bookRepository.save(book);
    var uri = uriBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri();
    return ResponseEntity.created(uri).body(new DataDatails(book));

   }

   @GetMapping
   public ResponseEntity <List<DataList>>list(){
    var list = bookRepository.findAll().stream().map(DataList::new).toList();
    return ResponseEntity.ok(list);

   }

   @GetMapping("/{id}")
   public ResponseEntity<DataDatails>listid(@PathVariable Long id){
    var listbyid = bookRepository.getReferenceById(id);
    return ResponseEntity.ok(new DataDatails(listbyid));

   }

   @PutMapping
   @Transactional
   public ResponseEntity<DataDatails> update(@RequestBody @Valid DataUpdate data){
   var update = bookRepository.getReferenceById(data.id());
    update.updateData(data);
   return ResponseEntity.ok(new DataDatails(update));

   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id){
    bookRepository.deleteById(id);
    
    return ResponseEntity.noContent().build();
    
   }

    
    
}
