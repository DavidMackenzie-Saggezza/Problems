package Puzzle14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Islands {
    public static int numIslands(int[][] matrix) {

        class Point {
            private int x;
            private int y;

            public Point(int x, int y) {
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
            public int hashCode() {
                return x * y;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Point)) {
                    return false;
                }
                Point point = (Point) obj;
                return this.getX() == point.getX() && this.getY() == point.getY();
            }
        }

        if (matrix.length == 0) {
            return 0;
        }

        List<HashSet<Point>> islands = new ArrayList<>();

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    HashSet<Point> newIsland = new HashSet<>();
                    newIsland.add(new Point(x, y));
                    for (int yOffset = -1; yOffset < 2; yOffset++) {
                        for (int xOffset = -1; xOffset < 2; xOffset++) {
                            int xAdj = x + xOffset;
                            int yAdj = y + yOffset;
                            if (xAdj >= 0 && xAdj < matrix[0].length && yAdj >= 0 && yAdj < matrix.length && !(yOffset == 0 && xOffset == 0)) {
                                Point pointAdj = new Point(xAdj, yAdj);
                                List<HashSet<Point>> toBeDeleted = new ArrayList<>();
                                for (HashSet<Point> island: islands) {
                                    if (island.contains(pointAdj)) {
                                        newIsland.addAll(island);
                                        toBeDeleted.add(island);
                                    }
                                }
                                toBeDeleted.forEach(islands::remove);
                            }
                        }
                    }
                    islands.add(newIsland);
                }
            }
        }
        return islands.size();
    }
}