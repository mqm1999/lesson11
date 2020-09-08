/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import lesson11.Model.DAO.AuthorDAO;
import lesson11.Model.DTO.Author;

/**
 *
 * @author HP Pavilion
 */
public class AuthorController {

    AuthorDAO authorDAO = new AuthorDAO();
    private static AuthorController instance;

    public static AuthorController getInstance() {
        if (instance == null) {
            instance = new AuthorController();
        }
        return instance;
    }

    private AuthorController() {

    }

    public ArrayList<Author> getAllAuthor() throws SQLException {
        return authorDAO.getAllAuthor();
    }

    public boolean deleteBookById(int deleteId) {
        try {
            return authorDAO.deleteAuthorById(deleteId);
        } catch (Exception e) {
            System.out.println("Failed");
            return false;
        }
    }

    public boolean addAuthor(Author newAuthor) {
        try {
            return authorDAO.addAuthor(newAuthor);
        } catch (Exception e) {
            System.out.println("Failed");
            return false;
        }
    }

    public boolean updateAuthorName(String newName, String oldName) {
        try {
            return authorDAO.updateAuthorName(newName, oldName);
        } catch (Exception e) {
            System.out.println("Failed");
            return false;
        }
    }

    public boolean updateAuthorAge(String authorName, int newAge, int oldAge) {
        try {
            return authorDAO.updateAuthorAge(authorName, newAge, oldAge);
        } catch (Exception e) {
            System.out.println("Failed");
            return false;
        }
    }

}
