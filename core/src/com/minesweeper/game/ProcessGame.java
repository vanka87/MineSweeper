package com.minesweeper.game;

public class ProcessGame {
    private MineSweeperGame game = MineSweeperGame.getInstance();

    public static final int NUM_CELLS_X = 10;
    public static final int NUM_CELLS_Y = 10;
    public static final int NUM_MINES = 10;
    public static final int NUM_CELLS = NUM_CELLS_X * NUM_CELLS_Y;

    private static final String BOMB = "X";
    private static final String EMPTY = "0";

    private String[] grid = new String[NUM_CELLS_X * NUM_CELLS_Y];
    private Integer[] mines = new Integer[NUM_MINES];
    private boolean[] isVisible = new boolean[NUM_CELLS_X * NUM_CELLS_Y];
    private int i, j = 0;

    public ProcessGame() {
        fillGrid();
        calcMines();
    }

    //generation of mines unique(random) indexes 0-99 and grid filling
    private void fillGrid() {
        do {
            mines[j] = (int) Math.round((NUM_CELLS - 1) * Math.random());
            for (int i = 0; i < j; i++) {
                if (mines[j] == mines[i]) {
                    j--;
                    break;
                }
            }
            j++;
        } while (j < NUM_MINES);

        for (int i = 0; i < NUM_CELLS; i++) {
            grid[i] = EMPTY;
            isVisible[i] = false;
        }

        for (int i = 0; i < mines.length; i++) {
            grid[mines[i]] = BOMB;
        }
    }

    //mines number calculation
    private void calcMines() {
        for (int i = 0; i < NUM_CELLS_X; i++) {
            for (int j = 0; j < NUM_CELLS_Y; j++) {
                if (grid[NUM_CELLS_X * i + j].compareTo(BOMB) != 0) {
                    grid[NUM_CELLS_X * i + j] = summMines(i, j);
                }
            }
        }
    }

    //circular sum of mines
    private String summMines(int x, int y) {
        int resMines = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i >= 0 && i < NUM_CELLS_Y && j >= 0 && j < NUM_CELLS_X) {
                    if (grid[NUM_CELLS_X * i + j].compareTo(BOMB) == 0) {
                        resMines++;
                    }
                }
            }
        }
        return String.valueOf(resMines);
    }

    //demining cells
    public void openCell(int x, int y) {
        if (grid[NUM_CELLS_X * x + y].compareTo(BOMB) == 0) {
            for (int i = 0; i < NUM_CELLS; i++) {
                isVisible[i] = true;
            }
            game.menu.tableGameOver.showGameOverTable();
        } else if (grid[NUM_CELLS_X * x + y].compareTo(EMPTY) == 0) {
            isVisible[NUM_CELLS_X * x + y] = true;
            for (int i = x - 1; i < x + 2; i++) {
                for (int j = y - 1; j < y + 2; j++) {
                    if (i >= 0 && i < NUM_CELLS_Y && j >= 0 && j < NUM_CELLS_X && isVisible[NUM_CELLS_X * i + j] == false) {
                        isVisible[NUM_CELLS_X * x + y] = true;
                        openCell(i, j);
                    }
                }
            }
        } else {
            isVisible[NUM_CELLS_X * x + y] = true;
        }
    }

    public String[] getGrid() {
        return grid;
    }

    public boolean[] getVisible() {
        return isVisible;
    }
}
