package impl;

import model.Book;
import model.Library;

import java.util.ArrayList;
import java.util.List;

/**
 * ArmenianNationalLibrary implements Library and
 * singleton design pattern because there is one national library in country
 * Created by TOM RED on 11.04.2017.
 */
public class ArmenianNationalLibrary implements Library {

    private static ArmenianNationalLibrary armenianNationalLibrary;

    private String name;

    private String address;

    private List<Book> books;

    private ArmenianNationalLibrary() {
    }

    private ArmenianNationalLibrary(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
    }

    public static ArmenianNationalLibrary getInstance(String name, String address) {
        if (armenianNationalLibrary == null) {
            armenianNationalLibrary = new ArmenianNationalLibrary(name, address);
        }

        return armenianNationalLibrary;
    }

    @Override
    public String getLibraryName() {
        return this.name;
    }

    @Override
    public String getLibraryAddress() {
        return this.address;
    }

    @Override
    public List<Book> getBooks() {
        return this.books;
    }

    @Override
    public void addBook(Book book) {
        this.books.add(book);
    }
}
