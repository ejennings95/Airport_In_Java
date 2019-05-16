import java.util.Random;

public class Weather {

    String condition = "clear";

    public void setCondition() {
        if (randomise() == 0) {
            this.condition = "clear";
        } else {
            this.condition = "stormy";
        }
    }

    public String getCondition() {
        this.setCondition();
        return condition;
    }

    public int randomise () {
        Random rand = new Random();
        int value = rand.nextInt(2);
        return value;
    }

}
