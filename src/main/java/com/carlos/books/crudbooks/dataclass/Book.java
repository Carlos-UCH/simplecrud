package com.carlos.books.crudbooks.dataclass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "books")
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String genres; 
    private String publication; 
    private Long pages; 
    
    public Book(DataRegister data){
        this.id = data.id();
        this.author = data.author();
        this.genres = data.genres();
        this.publication = data.publication(); 
        this.pages = data.pages();

    }

    public void updateData(DataUpdate data){
        if (this.author != null) {
            this.author = data.author();

        }if (this.genres != null) {
            this.genres = data.genres();

        }if (this.publication != null) {
            this.publication = data.publication();

        }if (this.pages > 0) {
            this.pages = data.pages();
            
        }

    }


}
