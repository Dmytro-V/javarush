package com.javarush.task.task35.task3513;

import java.util.*;


public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;

    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.isEmpty()) {
            return;
        }
        int index = (int)(Math.random() * emptyTiles.size());
        int randomValue = (Math.random() < 0.9 ? 2 : 4);
        emptyTiles.get(index).value = randomValue;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (Tile[] lineTile : gameTiles) {
            for (Tile tile : lineTile) {
                if (tile.isEmpty()) {
                    emptyTiles.add(tile);
                }
            }
        }
        return emptyTiles;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean change = false;
        for (int j = 0; j < tiles.length - 1; j++) {
            for (int i = 0; i < tiles.length - 1; i++) {
                if (tiles[i].isEmpty() && !tiles[i + 1].isEmpty()) {
                    tiles[i].value = tiles[i + 1].value;
                    tiles[i + 1].value = 0;
                    change = true;
                }
            }
        }
        return change;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean change = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value != 0
                && tiles[i].value == tiles[i + 1].value) {
                tiles[i].value +=  tiles[i + 1].value;
                tiles[i + 1].value = 0;
                change = true;

                this.score += tiles[i].value;
                if (tiles[i].value > this.maxTile) {
                    maxTile = tiles[i].value;
                }
            }
        }
        compressTiles(tiles);
        return change;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean change = false;
        for (int i = 0; i < gameTiles.length; i++) {
            change = compressTiles(gameTiles[i]) || change;
            change = mergeTiles(gameTiles[i]) || change;
        }
        if (change) {
            addTile();
        }
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        rotateGameTiles();
        rotateGameTiles();
        left();
        rotateGameTiles();
        rotateGameTiles();

    }

    public void up() {
        saveState(gameTiles);
        rotateGameTiles();
        rotateGameTiles();
        rotateGameTiles();
        left();
        rotateGameTiles();
    }

    public void down() {
        saveState(gameTiles);
        rotateGameTiles();
        left();
        rotateGameTiles();
        rotateGameTiles();
        rotateGameTiles();
    }

    private void rotateGameTiles() {
        int[][] rotatedGameTiles = new int[FIELD_WIDTH][FIELD_WIDTH];

        // поворот матрицы на 90 гр по часовой стрелке
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                rotatedGameTiles[j][FIELD_WIDTH - 1 - i] = gameTiles[i][j].value;
            }
        }

        //копирование матрицы
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j].value = rotatedGameTiles[i][j];
            }
        }

    }

    public boolean canMove() {

        if (!getEmptyTiles().isEmpty()) {
            return true;
        }
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i + 1][j].value
                        || gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                    return true;
                }
            }
        }
        return false;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tilesForSave = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tilesForSave[i][j] = new Tile();
                tilesForSave[i][j].value = tiles[i][j].value;
            }
        }

        this.previousStates.push(tilesForSave);
        this.previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (previousScores.empty() || previousStates.empty()) {
            return;
        }
        gameTiles = previousStates.pop();
        score = previousScores.pop();


    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public boolean hasBoardChanged() {

        int weightGameTiles = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                weightGameTiles += gameTiles[i][j].value;
            }
        }

        int weightStackTiles = 0;
        Tile[][] stackTiles = previousStates.peek();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                weightStackTiles += stackTiles[i][j].value;
            }
        }
        return weightGameTiles != weightStackTiles;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency = null;
        move.move();
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), this.score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));

        queue.poll().getMove().move();


    }

}
