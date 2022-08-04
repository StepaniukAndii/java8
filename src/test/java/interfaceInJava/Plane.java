package interfaceInJava;

public class Plane {

    private String model;
    private int speed;
    private int maxHeight;
    private int maxFlyDistance;

    public Plane(String model, int speed, int maxHeight, int maxFlyDistance) {
        this.model = model;
        this.speed = speed;
        this.maxHeight = maxHeight;
        this.maxFlyDistance = maxFlyDistance;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMaxFlyDistance() {
        return maxFlyDistance;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void setMaxFlyDistance(int maxFlyDistance) {
        this.maxFlyDistance = maxFlyDistance;
    }
}
