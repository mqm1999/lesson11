/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11;

/**
 *
 * @author HP Pavilion
 */
public class SampleSingletonController {
    private static SampleSingletonController INSTANCE = null;
    
    private SampleSingletonController(){
        
    }
    
    public static SampleSingletonController getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new SampleSingletonController();
        }
        return INSTANCE;
    }
    
    public void show(){
        System.out.println("This is an instance");
    }
    
    
}
