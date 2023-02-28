public class task5 {



public static void main(String[] args) {
    var mg = new MapGenerator();

    // Печать "сырой" карты
    System.out.println(
            new MapPrinter().rawData(
                    mg.getMap())

    );
// Это понадобится для следующей домашней работы:
    //var lee = new WaveAlgorithm(mg.getMap());
    //lee.Colorize(new Point2D(3, 3));
    

    // Печать "красивой" карты
    System.out.println(
        new MapPrinter().mapColor(
                mg.getMap())

);

// Это понадобится для следующей домашней работы:
    // System.out.println(
    //         new MapPrinter().rawData(
    //                 mg.getMap())

    // );
    
}


class Point2D {
    int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("x: %d  y: %d", x, y);
    }
}



static class MapGenerator {
    int[][] map;

    public MapGenerator() {
        int[][] map = {
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, -1, 00, 00, -1, 00, 00, 00, 00, -3, 00, -1},
                {-1, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1},
                {-1, -1, -1, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, -1, 00, -1, 00, 00, -1, -1, -1, 00, 00, -1},
                {-1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1},
                {-1, 00, -2, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, -1},
                {-1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };

        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }

    public void setCat(Point2D pos) {
        map[pos.x][pos.y] = -2;
    }

    public void setExit(Point2D pos) {
        map[pos.x][pos.y] = -3;
    }
}



static class MapPrinter {

    public MapPrinter() {
    }

    public String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%5d", map[row][col]));
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }

        return sb.toString();
    }

    public String mapColor(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                switch (map[row][col]) {
                    case 0:
                        sb.append(" 0 ");
                        break;
                    case -1:
                        sb.append(" # ");
                        break;
                    case -2:
                        sb.append("^^");
                        break;
                    case -3:
                        sb.append(" = ");
                        break;
                    default:
                        break;
                }
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }
        return sb.toString();
    }
}



}