package com.javarush.task.task35.task3513;

import java.util.*;


public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;

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
        this.score = 0;
        this.maxTile = 0;
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

    private void compressTiles(Tile[] tiles) {

        for (int j = 0; j < tiles.length - 1; j++) {
            for (int i = 0; i < tiles.length - 1; i++) {
                if (tiles[i].isEmpty() && !tiles[i + 1].isEmpty()) {
                    tiles[i].value = tiles[i + 1].value;
                    tiles[i + 1].value = 0;
                }
            }
        }
    }

    private void mergeTiles(Tile[] tiles) {
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value) {
                tiles[i].value +=  tiles[i + 1].value;
                tiles[i + 1].value = 0;

                this.score += tiles[i].value;
                if (tiles[i].value > this.maxTile) {
                    maxTile = tiles[i].value;
                }
            }
        }
        compressTiles(tiles);
    }
}
