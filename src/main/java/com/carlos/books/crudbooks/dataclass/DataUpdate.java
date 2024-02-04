package com.carlos.books.crudbooks.dataclass;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataUpdate( 
@NotBlank
String author, 
String genres, 
String publication, 
@NotNull
Long id,
Long pages) {


}