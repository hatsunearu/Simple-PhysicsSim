package hatsunearu.physicssim.objectmodels;

import hatsunearu.physicssim.simulator.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hatsunearu
 */
public class PhysicalObject implements PhysicalObjectModel {
    
    double m, t = 0, dt; //mass, elapsed time, and tick time
    Vector v; //velocity vector
    Vector r; //displacement vector
    
    public PhysicalObject(double mass, Vector velocity, Vector position, double tickTime) {
        m = mass;
        v = velocity;
        dt = tickTime;
        r = position;
    }
    public Vector getForceVector() { //to be overridden
    	return new Vector(0,-9.81);
    }
    
    public void tick() {
        r = r.addComponent(v.getX() * dt, v.getY() * dt);
        v = v.addComponent(getForceVector().getX() * dt / m, getForceVector().getY() * dt / m);
        t+=dt;
    }
    
    public Vector getPos() {
    	return r;
    }
    
    public double getTime() {
    	return t;
    }
    
	@Override
	public String getModelName() {
		return "Object under simple earth gravity";
	}
}
