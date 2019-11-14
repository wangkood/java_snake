package cn.wangxing.snake.domain;

/**
 * 点对象，保存坐标，高宽
 */
public class GamePoint {
    private int x;
    private int y;
    private int width;
    private int height;

    public GamePoint() {}
    public GamePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public GamePoint(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setSize(int width,int height){
        this.width = width;
        this.height=height;
    }

    public void setLocation(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "GamePoint{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
