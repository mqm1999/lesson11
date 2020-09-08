/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11;

import java.sql.SQLException;
import lesson11.View.BookView;

/**
 *
 * @author HP Pavilion
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        BookView bookView = new BookView();
        bookView.execute();
    }

}
