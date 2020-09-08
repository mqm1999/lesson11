/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import lesson11.Model.DAO.BookDAO;
import lesson11.Model.DTO.Book;

/**
 *
 * @author HP Pavilion
 */
public class BookController {

    BookDAO bookDAO = new BookDAO();
    private static BookController instance;

    public static BookController getInstance() {
        if (instance == null) {
            instance = new BookController();
        }
        return instance;
    }

    private BookController() {

    }

    public ArrayList<Book> getAllBooks() throws SQLException {
        try {
            return bookDAO.getAllBooks();
        } catch (SQLException e) {
            System.out.println("Failed");
            return null;
        }

    }

    public boolean deleteBookById(int deleteId) {
        try {
            return bookDAO.deleteBookById(deleteId);
        } catch (Exception e) {
            System.out.println("Failed");
            return false;
        }
    }

    public boolean addBook(Book newBook) {
        try {
            return bookDAO.addBook(newBook);
        } catch (Exception e) {
            System.out.println("Failed");
            return false;
        }
    }

    public boolean updateNameBook(String newName, String oldName) {
        try {
            return bookDAO.updateNameBook(newName, oldName);
        } catch (Exception e) {
            System.out.println("Failed");
            return false;
        }
    }

    public boolean updatePriceBook(String bookName, int newPrice, int oldPrice) {
        try {
            return bookDAO.updatePriceBook(bookName, newPrice, oldPrice);
        } catch (Exception e) {
            System.out.println("Failed");
            return false;
        }
    }

}
