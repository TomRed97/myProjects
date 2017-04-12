import impl.ArmenianNationalLibrary;
import model.Author;
import model.Book;
import model.Genre;

/**
 * Created by tamara.aprikyan on 4/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        Author author = new Author(1, "Pauelo", "Coelho");
        Book book = new Book(1, "Pilgrimage", author, Genre.NOVEL);
        ArmenianNationalLibrary armenianNationalLibrary = ArmenianNationalLibrary.getInstance("ANL", "Abovyan street");
        armenianNationalLibrary.addBook(book);
    }

}
