package com.carlos.books.crudbooks.dataclass;

public record DataDatails(Long id, 
    String author, 
    String genres, 
    String pages, 
    Long publication) {

        public DataDatails(Book book){
            this(
                book.getId(), 
                book.getAuthor(), 
                book.getGenres(), 
                book.getPublication(), 
                book.getPages());
            }
}
