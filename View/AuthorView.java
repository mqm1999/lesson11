/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import lesson11.Controller.AuthorController;
import lesson11.Model.DTO.Author;

/**
 *
 * @author HP Pavilion
 */
public class AuthorView {
    Scanner sc = new Scanner(System.in);
    AuthorController authorController = AuthorController.getInstance();
    
    public void executeAuthor() throws SQLException {
        while (true) {
            System.out.println("Select option: 1. Show \n 2. Add \n 3. Delete \n 4. Update");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    ArrayList<Author> allAuthors = authorController.getAllAuthor();
                    for (int i = 0; i < allAuthors.size(); i++) {
                        System.out.println("STT" + i + ": " + allAuthors.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.println("Id: ");
                    int id = sc.nextInt();
                    System.out.println("Name: ");
                    String name = sc.next();
                    System.out.println("Age: ");
                    int age = sc.nextInt();
                    Author newAuthor = new Author(id, name, age);
                    boolean addAuthor = authorController.addAuthor(newAuthor);
                    if (addAuthor) {
                        System.out.println("Added");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
                case 3:
                    System.out.println("Id of book you want to delete: ");
                    try {
                        int deleteId = sc.nextInt();
                        boolean response = authorController.deleteBookById(deleteId);
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
                    System.out.println("1 to change name, 2 to change age");
                    System.out.println("Input information you want to change: ");
                    int inputInfo = sc.nextInt();
                    if (inputInfo == 1) {
                        System.out.println("Enter old name: ");
                        String oldName = sc.next();
                        System.out.println("Enter new name: ");
                        String newName = sc.next();
                        boolean updateName = authorController.updateAuthorName(newName, oldName);
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
                        boolean updatePrice = authorController.updateAuthorAge(bookName, newPrice, oldPrice);
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
