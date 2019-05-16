import java.util.ArrayList;

public class Airport {

    ArrayList<Object> hangar = new ArrayList<Object>();

    public ArrayList<Object> getHangar() {
        return hangar;
    }

    public void landPlane (Plane plane) throws PlaneAlreadyLandedException {
        if (plane.getStatus() == "landed") {
            throw new PlaneAlreadyLandedException("Plane is already landed in an airport.");
        } else {
            hangar.add(plane);
        }
    }

    public void takeOffPlane (Plane plane) {
        if (hangar.contains(plane)) {
            hangar.remove(plane);
        }
    }
}
