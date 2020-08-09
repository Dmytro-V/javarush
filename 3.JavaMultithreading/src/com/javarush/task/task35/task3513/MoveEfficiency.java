package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency>{
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency otherMove) {

        int comparator1 = Integer.compare(this.numberOfEmptyTiles, otherMove.numberOfEmptyTiles);
        if (comparator1 != 0) {
            return comparator1;
        }
        return Integer.compare(this.score, otherMove.score);

    }
}
