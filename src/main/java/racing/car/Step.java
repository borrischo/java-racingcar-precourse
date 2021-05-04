package racing.car;

public class Step {
    private int position;

    public Step() {
        this.position = 0;
    }

    public void forward() {
        this.position += 1;
    }

    public int getPosition() {
        return this.position;
    }


}
