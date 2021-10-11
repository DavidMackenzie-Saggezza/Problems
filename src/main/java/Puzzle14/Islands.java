package Puzzle14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Islands {

    public static int numIslands(int[][] matrix) {
        if (matrixHasZeroWidthOrHeight(matrix)) {
            return 0;
        }
        List<HashSet<Point>> islands = new ArrayList<>();
        createIslandsFromMatrix(matrix, islands);
        return islands.size();
    }

    private static boolean matrixHasZeroWidthOrHeight(int[][] matrix) {
        return matrix.length == 0 || matrix[0].length == 0;
    }

    private static void createIslandsFromMatrix(int[][] matrix, List<HashSet<Point>> islands) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                processPoint(matrix, x, y, islands);
            }
        }
    }

    private static void processPoint(int[][] matrix, int x, int y, List<HashSet<Point>> islands) {
        if (matrix[y][x] == 1) {
                addPointToIslands(matrix, x, y, islands);
            }
        }

    private static void addPointToIslands(int[][] matrix, int x, int y, List<HashSet<Point>> islands) {
        HashSet<Point> newIsland = new HashSet<>();
        newIsland.add(new Point(x, y));
        addAllAdjacentPoints(matrix, x, y, islands, newIsland);
        islands.add(newIsland);
    }

    private static void addAllAdjacentPoints(int[][] matrix, int x, int y, List<HashSet<Point>> islands, HashSet<Point> newIsland) {
        for (int yOffset = -1; yOffset < 2; yOffset++) {
            for (int xOffset = -1; xOffset < 2; xOffset++) {
                processAdjacentPoint(matrix, x, y, islands, newIsland, xOffset, yOffset);
            }
        }
    }

    private static void processAdjacentPoint(int[][] matrix, int x, int y, List<HashSet<Point>> islands, HashSet<Point> newIsland, int xOffset, int yOffset) {
        int xAdj = x + xOffset;
        int yAdj = y + yOffset;
        if (isValidAdjacentPoint(matrix, xAdj, yAdj, xOffset, yOffset)) {
            addAdjacentPointsIslandToNewIslandAndDeleteAdjacentPointsIsland(xAdj, yAdj, islands, newIsland);
        }
    }

    private static boolean isValidAdjacentPoint(int[][] matrix, int xAdj, int yAdj, int xOffset, int yOffset) {
        return xAdj >= 0 && xAdj < matrix[0].length && yAdj >= 0 && yAdj < matrix.length && !(xOffset == 0 && yOffset == 0);
    }

    private static void addAdjacentPointsIslandToNewIslandAndDeleteAdjacentPointsIsland(int xAdj, int yAdj, List<HashSet<Point>> islands, HashSet<Point> newIsland) {
        Point pointAdj = new Point(xAdj, yAdj);
        List<HashSet<Point>> islandsToBeDeleted = new ArrayList<>();
        for (HashSet<Point> island : islands) {
            if (island.contains(pointAdj)) {
                newIsland.addAll(island);
                islandsToBeDeleted.add(island);
            }
        }
        islandsToBeDeleted.forEach(islands::remove);
    }
}