public class Plane {

    String status = "flying";

    public String getStatus() {
        return status;
    }

    public void landed () {
        this.status = "landed";
    }

    public void flying () {
        this.status = "flying";
    }
}
