package com.owasplab.owsp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotEmpty(message = "Author cannot be empty")
    @Size(min = 2, max = 50, message = "Author must be between 2 and 50 characters")
    private String author;

    @Min(value = 1450, message = "PublishedYear must be between 1450 and 2024")
    @Max(value = 2024, message = "PublishedYear must be between 1450 and 2024")
    private int publishedYear;
}
