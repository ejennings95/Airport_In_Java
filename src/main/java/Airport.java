import java.util.ArrayList;

public class Airport {

    ArrayList<Object> hangar = new ArrayList<Object>();
    Weather weather = new Weather();

    public Airport() {}

    public Airport(Weather weatherclass) {
        this.weather = weatherclass;
    }

    public ArrayList<Object> getHangar() {
        return hangar;
    }

    public void landPlane (Plane plane) throws PlaneAlreadyLandedException, BadWeatherException {
        if (weather.getCondition() == "stormy") {
            throw new BadWeatherException("Weather condition not good enough to land.");
        } else {
            if (plane.getStatus() == "landed") {
                throw new PlaneAlreadyLandedException("Plane is already landed in an airport.");
            } else {
                hangar.add(plane);
            }
        }
    }

    public void takeOffPlane (Plane plane) throws PlaneAlreadyFlyingException, PlaneNotInHangarException, BadWeatherException {
        if (weather.getCondition() == "stormy") {
            throw new BadWeatherException("Weather condition not good enough to take off.");
        } else {

            if (plane.getStatus() == "flying") {
                throw new PlaneAlreadyFlyingException("Plane is already in the air.");
            } else if (!hangar.contains(plane)) {
                throw new PlaneNotInHangarException("Plane is not in this airport hangar.");
            } else {
                hangar.remove(plane);
            }
        }
    }
}
