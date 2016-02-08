package com.epam.jmp.threads04.runner;

import com.epam.jmp.threads04.model.Car;

public class Runner {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Car("AAA", 10L, true));
        Thread t2 = new Thread(new Car("BBB", 20L, false));
        t1.setName("AAA");
        t2.setName("BBB");
        t1.start();
        t2.start();
        String winner = null;
        try {
            while (true) {
                Thread.sleep(100);
                if (!t1.isAlive() && t2.isAlive()){
                	winner = t1.getName();
                }
                if (!t2.isAlive() && t1.isAlive()){
                	winner = t2.getName();
                }
                if (!(t1.isAlive() || t2.isAlive())) {    
                	System.out.println("Winner is " + winner + "!");
                    break;
                } 
                
            }
        } catch (InterruptedException e) {
        }
        
        

	}

}
