package io.swagger.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Book
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-11-14T18:38:18.191886612Z[GMT]")
@Entity

public class Book   {
//  @JsonProperty("id")
//
//  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
//  @JsonSetter(nulls = Nulls.FAIL)
//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)// FAIL setting if the value is null
//  private Integer id = null;
//
//  @JsonProperty("genre")
//
//  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
//  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
//  private String genre = null;
//
//  @JsonProperty("authors")
//
//  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
//  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
//  private String authors = null;
//
//  @JsonProperty("available")
//
//  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
//  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
//  private Boolean available = null;
//
//  @JsonProperty("publishedDate")
//
//  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
//  @JsonSetter(nulls = Nulls.FAIL)
//  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")// FAIL setting if the value is null
//  private LocalDate publishedDate = null;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String genre;

  private String authors;

  private String skill;

  private boolean available;

  private LocalDate publishedDate;
  public Book id(Integer id) { 

    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  
  @Schema(description = "")
  
  public Integer getId() {  
    return id;
  }



  public void setId(Integer id) { 
    this.id = id;
  }

  public Book genre(String genre) { 

    this.genre = genre;
    return this;
  }

  /**
   * Get genre
   * @return genre
   **/
  
  @Schema(description = "")
  
  public String getGenre() {  
    return genre;
  }



  public void setGenre(String genre) { 
    this.genre = genre;
  }

  public Book authors(String authors) { 

    this.authors = authors;
    return this;
  }

  /**
   * Get authors
   * @return authors
   **/
  
  @Schema(description = "")
  
  public String getAuthors() {  
    return authors;
  }



  public void setAuthors(String authors) { 
    this.authors = authors;
  }

  public Book available(Boolean available) { 

    this.available = available;
    return this;
  }

  /**
   * Get available
   * @return available
   **/
  
  @Schema(description = "")
  
  public Boolean isAvailable() {  
    return available;
  }



  public void setAvailable(Boolean available) { 
    this.available = available;
  }

  public Book publishedDate(LocalDate publishedDate) { 

    this.publishedDate = publishedDate;
    return this;
  }

  /**
   * Get publishedDate
   * @return publishedDate
   **/
  
  @Schema(example = "12-11-2024", description = "")
  
@Valid
  public LocalDate getPublishedDate() {  
    return publishedDate;
  }



  public void setPublishedDate(LocalDate publishedDate) { 
    this.publishedDate = publishedDate;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(this.id, book.id) &&
        Objects.equals(this.genre, book.genre) &&
        Objects.equals(this.authors, book.authors) &&
        Objects.equals(this.available, book.available) &&
        Objects.equals(this.publishedDate, book.publishedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, genre, authors, available, publishedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Book {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("    authors: ").append(toIndentedString(authors)).append("\n");
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
    sb.append("    publishedDate: ").append(toIndentedString(publishedDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
