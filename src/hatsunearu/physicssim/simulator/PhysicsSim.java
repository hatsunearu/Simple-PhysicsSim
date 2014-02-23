/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hatsunearu.physicssim.simulator;

import hatsunearu.physicssim.objectmodels.DraggyBall;
import hatsunearu.physicssim.objectmodels.PhysicalObject;

import java.util.Scanner;

/**
 *
 * @author hatsunearu
 */
public class PhysicsSim {

    
    static double timeToRun = 10;
    static double tickTime = 0.000005;
    static double samplingInterval = 0.1;
    
    static double vx,vy,rx,ry,m;
    
    static PhysicalObject obj = new DraggyBall(m, new Vector(vx, vy), new Vector(rx,ry), tickTime); //define your object here
	private static Scanner s;
    
    public static void main(String[] args) {
        
        s = new Scanner(System.in);
        
        System.out.println("PhysicsSim, Rev 4.0, written by hatsunearu (www.github.com/hatsunearu)\n");
        
        System.out.println("Simulation Object: "+obj.getModelName()+"\n");
        
        System.out.println("Input mass of object");
        m = s.nextDouble();
        
        System.out.println("Input Horizontal Velocity followed by Vertical Velocity");
        vx = s.nextDouble();
        vy = s.nextDouble();
        
        System.out.println("Input Horizontal Position followed by Vertical Position");
        rx = s.nextDouble();
        ry = s.nextDouble();
        
        s.nextLine();
        
        System.out.println("Do you want to define simulation parameters? y/[N]");
        if (s.nextLine().equalsIgnoreCase("y")) {
        	System.out.println("Input time to simulate, tick interval (determines accuracy), and sampling interval (how often you want to take measurements)");
            timeToRun = s.nextDouble();
            tickTime = s.nextDouble();
            samplingInterval = s.nextDouble();
        }
        
        System.out.println("\nPhysical Parameters: m = " + m+ " v = <"+vx+", "+vy+">" + " r = <"+rx+", "+ry+">");
        System.out.println("\nRun Parameters: total time = "+timeToRun+" tick interval = "+tickTime+" sampling interval = "+samplingInterval);
        
        System.out.println("Press enter to continue...");
        
        s.nextLine();
       
        System.out.println("Time\tX\tY");
        
        for(long i = 0; i <= (long)(timeToRun / tickTime); i++) {
            if(i % (samplingInterval / tickTime) == 0) {
                System.out.println(obj.getTime() + "\t" + obj.getPos().getX() + "\t" + obj.getPos().getY());
            }
            obj.tick();
        }
    }
}
