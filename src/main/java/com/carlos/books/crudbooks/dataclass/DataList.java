package com.carlos.books.crudbooks.dataclass;


public record DataList(Long id, String author, String genres, String pages, Long publication) {

    public DataList(Book book){
        this(book.getId(),book.getAuthor(), book.getGenres(), book.getPublication(), book.getPages());
    }
    
}
