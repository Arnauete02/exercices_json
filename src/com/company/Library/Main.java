/*
 * Arnau Gràcia Taberner        21/10/21
 *
 * Library.java
 */

package com.company.Library;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    class Author{
        protected String name;
        protected String birthday;
    }
    class Library{
        protected String name;
        protected String city;
    }
    class Book{
        protected String title;
    }

    static class AuthorXBooks{
        protected Author author;
        protected List<Book> books;
    }
    static class LibraryXBooks{
        protected Library library;
        protected List<Book> books;
    }

    public static final Path json = Paths.get("C:\\Users\\arnau\\Documents\\DAM\\M06\\exercices_json\\src\\com\\company\\Library\\file.json");
    public static ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static Book book1;// = new Book("Hobbit: Un viaje inesperado");
    public static Book book2;// = new Book("Hobbit: La desolacon de Smaug");
    public static Book book3;// = new Book("Hobbit: La batalla de los cinco ejercitos");
    public static Book book4;// = new Book("El Codigo Da Vinci");
    public static Book book5;// = new Book("Los Pilares de la Tierra");
    public static Book book6;// = new Book("Inferno");

    public static Author author1;// = new Author("J.R.R.Tolkien");
    public static Author author2;// = new Author("Ken Follet");
    public static Author author3;// = new Author("Dan Brown");

    public static Library library1;// = new Library("Nou Barris");
    public static Library library2;// = new Library("Vilapicina i la Torre Llobeta");

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);

        book1.title = "Hobbit: Un viaje inesperado";
        book2.title = "Hobbit: La desolacon de Smaug";
        book3.title = "Hobbit: La batalla de los cinco ejercitos";
        book4.title = "El Codigo Da Vinci";
        book5.title = "Los Pilares de la Tierra";
        book6.title = "Inferno";
        author1.name = "J.R.R.Tolkien";
        author2.name = "Ken Follet";
        author3.name = "Dan Brown";
        library1.name = "Nou Barris";
        library2.name = "Vilapicina i la Torre Llobeta";

        AuthorXBooks authorXBooks1 = new AuthorXBooks();
        authorXBooks1.author = author1;
        List<Book> books1 = new ArrayList<>();
        books1.add(book1);
        books1.add(book2);
        books1.add(book3);
        authorXBooks1.books = books1;

        AuthorXBooks authorXBooks2 = new AuthorXBooks();
        authorXBooks2.author = author2;
        List<Book> books2 = new ArrayList<>();
        books2.add(book4);
        books2.add(book5);
        authorXBooks2.books = books2;

        AuthorXBooks authorXBooks3 = new AuthorXBooks();
        authorXBooks3.author = author3;
        List<Book> books3 = new ArrayList<>();
        books3.add(book6);
        authorXBooks3.books = books3;

        LibraryXBooks libraryXBooks1 = new LibraryXBooks();
        libraryXBooks1.library = library1;
        List<Book> books4 = new ArrayList<>();
        books4.add(book2);
        books4.add(book5);
        books4.add(book3);
        books4.add(book1);
        libraryXBooks1.books = books4;

        LibraryXBooks libraryXBooks2 = new LibraryXBooks();
        libraryXBooks2.library = library2;
        List<Book> books5 = new ArrayList<>();
        books5.add(book5);
        books5.add(book6);
        books5.add(book3);
        libraryXBooks2.books = books5;

        objectMapper.writeValue(json.toFile(), authorXBooks1);
        objectMapper.writeValue(json.toFile(), authorXBooks2);
        objectMapper.writeValue(json.toFile(), authorXBooks3);
        objectMapper.writeValue(json.toFile(), libraryXBooks1);
        objectMapper.writeValue(json.toFile(), libraryXBooks2);
    }
}

