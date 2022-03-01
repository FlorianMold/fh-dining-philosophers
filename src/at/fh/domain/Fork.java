package at.fh.domain;

public class Fork {
    private final int id;

    public Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Fork{" +
                "id=" + id +
                '}';
    }
}
