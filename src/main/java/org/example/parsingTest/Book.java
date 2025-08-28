package org.example.parsingTest;

import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private Integer year;
    private String genre;
    private Double price;

    public Book(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && Objects.equals(year, book.year)
                && Objects.equals(genre, book.genre)
                && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, genre, price);
    }

    @Override
    public String toString() {
        return String.format("\nBook{\nНазвание: %s\nАвтор: %s\nГод: %s\nЖанр: %s\nЦена: %s\n}", title, author, year, genre, price);
    }
}
