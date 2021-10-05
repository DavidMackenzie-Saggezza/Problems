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

        int height = matrix.length;
        if (height == 0) {
            return 0;
        }
        int width = matrix[0].length;


        List<HashSet<Point>> islands = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1) {
                    HashSet<Point> newIsland = new HashSet<>();
                    newIsland.add(new Point(j, i));
                    for (int k = -1; k < 2; k++) {
                        for (int l = -1; l < 2; l++) {
                            if (!(k == 0 && l == 0)) {
                                int x = j + l;
                                int y = i + k;
                                if (x >= 0 && x < width && y >= 0 && y < height) {
                                    Point point = new Point(x, y);
                                    List<HashSet<Point>> toBeDeleted = new ArrayList<>();
                                    for (HashSet<Point> island: islands) {
                                        if (island.contains(point)) {
                                            newIsland.addAll(island);
                                            toBeDeleted.add(island);
                                        }
                                    }
                                    toBeDeleted.forEach(islands::remove);
                                }
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


