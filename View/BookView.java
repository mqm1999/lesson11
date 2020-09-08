/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import lesson11.Controller.BookController;
import lesson11.Model.DTO.Book;

/**
 *
 * @author HP Pavilion
 */
public class BookView {

    BookController bookController = BookController.getInstance();
    Scanner sc = new Scanner(System.in);

    public void execute() throws SQLException {
        while (true) {
            System.out.println("Select option: 1. Show \n 2. Add \n 3. Delete \n 4. Update");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    ArrayList<Book> allBooks = bookController.getAllBooks();
                    for (int i = 0; i < allBooks.size(); i++) {
                        System.out.println("STT" + i + ": " + allBooks.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.println("Id: ");
                    int id = sc.nextInt();
                    System.out.println("Name: ");
                    String name = sc.next();
                    System.out.println("Price: ");
                    int price = sc.nextInt();
                    Book newBook = new Book(id, name, price);
                    boolean addBook = bookController.addBook(newBook);
                    if (addBook) {
                        System.out.println("Added");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
                case 3:
                    System.out.println("Id of book you want to delete: ");
                    try {
                        int deleteId = sc.nextInt();
                        boolean response = bookController.deleteBookById(deleteId);
                        if (response) {
                            System.out.println("Deleted");
                        } else {
                            System.out.println("Failed");
                        }
                    } catch (Exception e) {
                        System.out.println("Error");
                    } finally {

                    }
                    break;
                case 4:
                    System.out.println("1 to change name, 2 to change price");
                    System.out.println("Input information you want to change: ");
                    int inputInfo = sc.nextInt();
                    if (inputInfo == 1) {
                        System.out.println("Enter old name: ");
                        String oldName = sc.next();
                        System.out.println("Enter new name: ");
                        String newName = sc.next();
                        boolean updateName = bookController.updateNameBook(newName, oldName);
                        if (updateName) {
                            System.out.println("Name changed");
                        } else {
                            System.out.println("Failed");
                        }
                    } else if (inputInfo == 2) {
                        System.out.println("Enter book name: ");
                        String bookName = sc.next();
                        System.out.println("Enter old price: ");
                        int oldPrice = sc.nextInt();
                        System.out.println("Enter new price: ");
                        int newPrice = sc.nextInt();
                        boolean updatePrice = bookController.updatePriceBook(bookName, newPrice, oldPrice);
                        if (updatePrice) {
                            System.out.println("Price changed");
                        } else {
                            System.out.println("Failed");
                        }
                    } else {
                        System.out.println("Option not found");
                        return;
                    }
                    break;
                default:
            }
        }
    }
}
