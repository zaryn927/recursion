package edu.cnm.deepdive.recursion;

import java.math.BigInteger;
import java.util.ArrayList;

public class Tower {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  
  public static BigInteger minMoves(int numDisks) {
    if (numDisks <= 0){
      return BigInteger.ZERO;
    }
    if(numDisks == 1){
      return BigInteger.ONE;
    }
    return minMoves(numDisks - 1).multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
  }
  
  public static ArrayList<int[]> getMoves(int numDisks, int from, int to) {
    if (numDisks <= 0) {
      return new ArrayList<int[]>();
    }
    if (numDisks == 1) {
      int [] move = {from, to};
      ArrayList<int[]> moves = new ArrayList<>();
      moves.add(move);
      return moves;
    }
    int staging = 3 - from - to;
    ArrayList<int[]> stageMoves = getMoves(numDisks - 1, from, staging);
    int[] move = {from, to};
    stageMoves.add(move);
    stageMoves.addAll(getMoves(numDisks - 1, staging, to));
    return stageMoves;
  }
  
}
