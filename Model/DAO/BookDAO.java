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
import lesson11.Model.DTO.Book;

/**
 *
 * @author HP Pavilion
 */
public class BookDAO {

    Scanner sc = new Scanner(System.in);
    DatabaseUtil databaseUtil = new DatabaseUtil();
    ArrayList<Book> listBook = new ArrayList<>();

    public ArrayList<Book> getAllBooks() throws SQLException {
        String sql = "select * from Book;";
        ResultSet rs = databaseUtil.executeQuery(sql);
        while (rs.next()) {
            Book temp = new Book();
            temp.setId(rs.getInt("id"));
            temp.setName(rs.getString("name"));
            temp.setPrice(rs.getInt("price"));
            listBook.add(temp);
        }
        for (int i = 0; i < listBook.size(); i++) {
            System.out.println(listBook.get(i));
        }
        return listBook;
    }

    public boolean deleteBookById(int deleteId) {
        String sql = ("delete from Book where id = " + deleteId + ";");
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

    public boolean addBook(Book newBook) throws SQLException {
        String newName = newBook.getName();
        int newPrice = newBook.getPrice();
        String sqlCheck = ("select name from Book where exists (select name from Book where name = " + newName + ");");
        String sql = ("insert into Book (name, price) values ('" + newName + "', '" + newPrice + "');");
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

    public boolean updateNameBook(String newName, String oldName) {
        // String getOldNameSql = ("select id from Book where name = '" +oldName+ "'");
        String sqlCheck = ("select name from Book where exists (select name from Book where name = " + oldName + ");");
        String sql = ("update Book set name = '" + newName + "' where name = '" + oldName + "';");
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

    public boolean updatePriceBook(String bookName, int newPrice, int oldPrice) {
        String sqlCheck = ("select price from Book where exists (select price from Book where name = '" + bookName + "');");
        String sql = ("update Book set price = '" + newPrice + "' where name = '" + bookName + "');");
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
