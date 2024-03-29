package com.carlos.books.crudbooks.dataclass;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegister(
    Long id,
    @NotBlank
    String author, 
    String genres,
    String publication,
    @NotNull 
    Long pages) {

}