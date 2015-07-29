package chess;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
    public String printPosition(){
        return ("(" + x + "," + y + ")");
    }
    
   public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position pos = (Position) o;

        if (x != pos.x) return false;
        if (y != pos.y) return false;
        
        return true;
    }

    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}