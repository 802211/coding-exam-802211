package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */

		
		String howMany = JOptionPane.showInputDialog("How many robots >0");
		int numRobots = Integer.parseInt(howMany);
		
		String color = JOptionPane.showInputDialog("What color: red, green, blue");
		
		String sideNum = JOptionPane.showInputDialog("How many sides >0");
		int numSides = Integer.parseInt(sideNum);
		
		for(int i = 0; i<numRobots+1; i++) {
			int j = i;
			Thread t = new Thread(()->{
				Robot r = new Robot();
				if(color.equalsIgnoreCase("red")) {
					r.setPenColor(Color.red);
				}
				else if(color.equalsIgnoreCase("blue")) {
					r.setPenColor(Color.blue);
				}
				else if(color.equalsIgnoreCase("green")) {
					r.setPenColor(Color.green);
				}
				r.penDown();
				r.setSpeed(10);
				int x = j%5;
				r.setX(x*180+50);
				
				if(j-5>0) {
					r.setY(500);
				}
				else {
					r.setY(300);
				}
				for(int k = 0; k<numSides; k++) {
					r.move(50);
					r.turn(360/numSides);
				}
			});
			
			t.start();
			
		}
		
	}

	
}
