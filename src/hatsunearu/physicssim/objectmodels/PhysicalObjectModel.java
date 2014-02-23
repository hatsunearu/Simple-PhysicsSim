package hatsunearu.physicssim.objectmodels;

import hatsunearu.physicssim.simulator.Vector;

public interface PhysicalObjectModel {
	public Vector getForceVector(); //return vector that contains force information
	public String getModelName(); //return a string containing what the class is intended to model
}
