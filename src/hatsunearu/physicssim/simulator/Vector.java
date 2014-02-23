/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hatsunearu.physicssim.simulator;

/**
 *
 * @author hatsunearu
 */
public class Vector {
    
    double x = 0, y = 0;
    
    public Vector() {
        x=0;
        y=0;
    }
    
    public Vector(double i, double j) {
        x = i;
        y = j;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getAngle() {
        return Math.atan(y / x);
    }
    
    public double getMag() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y,2));
    }
    
    public Vector addComponent(double i, double j) {
        return new Vector(x + i, y + j);
    }
    
    public Vector addVector(Vector v) {
        return new Vector(x + v.getX(), y + v.getY());
    }
    
    public Vector dotProd(Vector v) {
    	return new Vector(v.getX() + x, v.getY() + y);
    }
    
    public Vector multiplyScalar(double c) {
        return new Vector(x * c, y * c);
    }
    
    public Vector getUnitVector() {
        return new Vector(x / getMag(), y / getMag());
    }
}
