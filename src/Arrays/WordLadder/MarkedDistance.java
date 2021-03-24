package Arrays.WordLadder;

public class MarkedDistance {
    int distance;
    boolean marked;
    MarkedDistance(int distance, boolean marked) {
        this.distance = distance;
        this.marked = marked;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean isMarked() {
        return marked;
    }
}
