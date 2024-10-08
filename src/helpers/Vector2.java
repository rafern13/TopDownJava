package helpers;

public class Vector2 {
    public int x = 0;
    public int y = 0;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {

    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static Vector2 vetorNulo() {
        return new Vector2(0, 0);
    }
}
