/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11.Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import lesson11.Helper.DatabaseUtil;
import lesson11.Model.DTO.Author;

/**
 *
 * @author HP Pavilion
 */
public class AuthorDAO {

    Scanner sc = new Scanner(System.in);
    DatabaseUtil databaseUtil = new DatabaseUtil();
    ArrayList<Author> listAuthor = new ArrayList<>();

    public ArrayList<Author> getAllAuthor() throws SQLException {
        String sql = "select * from Author;";
        ResultSet rs = databaseUtil.executeQuery(sql);
        while (rs.next()) {
            Author temp = new Author();
            temp.setId(rs.getInt("id"));
            temp.setName(rs.getString("name"));
            temp.setAge(rs.getInt("price"));
            listAuthor.add(temp);
        }
        for (int i = 0; i < listAuthor.size(); i++) {
            System.out.println(listAuthor.get(i));
        }
        return listAuthor;

    }

    public boolean deleteAuthorById(int deleteId) {
        String sql = ("delete from Author where id = " + deleteId + ";");
        ResultSet rs = databaseUtil.executeQuery(sql);
        try {
            databaseUtil.updateQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println("Fail to delete");
            return false;
        } finally {

        }

    }

    public boolean addAuthor(Author newAuthor) {
        String newName = newAuthor.getName();
        int newAge = newAuthor.getAge();
        String sqlCheck = ("select name from Author where exists (select name from Author where name = " + newName + ");");
        String sql = ("insert into Author (name, age) values ('" + newName + "', '" + newAge + "');");
        try {
            ResultSet rs = databaseUtil.executeQuery(sqlCheck);
            if (rs.next() == false) {
                databaseUtil.updateQuery(sql);
                System.out.println("Successfully added");
                return true;
            } else {
                System.out.println("Book existed");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error found");
            return false;
        } finally {

        }

    }

    public boolean updateAuthorName(String newName, String oldName) {
        String sqlCheck = ("select name from Author where exists (select name from Author where name = " + oldName + ");");
        String sql = ("update Author set name = '" + newName + "' where name = '" + oldName + "';");
        try {
            ResultSet rs = databaseUtil.executeQuery(sqlCheck);
            if (rs.next() == true) {
                databaseUtil.updateQuery(sql);
                System.out.println("Successfully updated");
                return true;
            } else {
                System.out.println("Book not found");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Fail to update");
            return false;
        } finally {

        }

    }

    public boolean updateAuthorAge(String authorName, int newAge, int oldAge) {
        String sqlCheck = ("select price from Author where exists (select age from Author where name = '" + authorName + "');");
        String sql = ("update Author set price = '" + newAge + "' where name = '" + authorName + "');");
        try {
            ResultSet rs = databaseUtil.executeQuery(sqlCheck);
            if (rs.next() == true) {
                databaseUtil.updateQuery(sql);
                System.out.println("Succesfully updated");
                return true;
            } else {
                System.out.println("Book not found");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Fail to update");
            return false;
        } finally {

        }

    }
}
