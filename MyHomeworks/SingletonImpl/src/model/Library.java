package model;

import java.util.List;

/**
 * Created by TOM RED on 11.04.2017.
 */
public interface Library {

    public String getLibraryName();

    public String getLibraryAddress();

    public List<Book> getBooks();

    public void addBook(Book book);

}
