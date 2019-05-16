import java.util.ArrayList;

public class Airport {

    ArrayList<Object> hangar = new ArrayList<Object>();

    public ArrayList<Object> getHangar() {
        return hangar;
    }

    public void landPlane (Plane plane) {
        hangar.add(plane);
    }

    public void takeOffPlane (Plane plane) {
        if (hangar.contains(plane)) {
            hangar.remove(plane);
        }
    }
}
