package io.swagger.model;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import org.springframework.validation.annotation.Validated;
import io.swagger.configuration.NotUndefined;
import org.threeten.bp.LocalDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Book
 */
@Validated
@NotUndefined
@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Book   {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @NotNull
  @Size(min = 1, message = "Book name cannot be empty")
  @Column(unique = true)
  private String bookName;

  @NotNull(message = "Genre cannot be null")  // Field should not be null
  @Size(min = 1, message = "Genre cannot be empty")
  @Column(nullable = false)
  private String genre;

  @NotNull(message = "Author cannot be null")  // Field should not be null
  @Size(min = 1, message = "Author cannot be empty")
  @Column(nullable = false)
  private String authors;

  @NotNull(message = "Skill cannot be null")  // Field should not be null
  @Size(min = 1, message = "Skill cannot be empty")
  @Column(nullable = false)
  private String skill;

  @NotNull(message = "Availability cannot be null")
  @Column(nullable = false,columnDefinition = "boolean default true")
  private boolean available;

  @Column(nullable = false)
  @NotNull(message = "Published date cannot be null")
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Getter(AccessLevel.NONE)
  private LocalDate publishedDate;

}
