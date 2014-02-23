/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hatsunearu.physicssim.objectmodels;

import hatsunearu.physicssim.simulator.Vector;

/**
 *
 * @author hatsunearu
 */
public class DraggyBall extends PhysicalObject implements PhysicalObjectModel {

	//sample implementation of a aerodynamic bowling ball equivalent affected both by earth gravity and drag, using the drag equation.
	
	public DraggyBall(double mass, Vector velocity, Vector position, double tickTime) {
		super(mass, velocity, position, tickTime);
	}

	@Override
	public Vector getForceVector() {
		 Vector dragF = v.getUnitVector().multiplyScalar(-0.0312 * Math.pow(v.getMag(), 2));
	     Vector gravF = new Vector(0, -9.81 * m);
	     return dragF.addVector(gravF);
	}

	@Override
	public String getModelName() {
		return "Standard bowling ball shaped object affected by drag and earth gravity";
	}
	
	
    
}
