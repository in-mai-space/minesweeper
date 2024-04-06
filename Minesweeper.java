import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javalib.impworld.WorldScene;
import javalib.impworld.World;
import java.awt.Color;
import javalib.worldimages.*;

// represent constants for the game
interface Minesweeper {
  int GAME_WIDTH = 1000;
  int GAME_HEIGHT = 1000;
  Color CELL_COVERED = new Color(195, 217, 255);
  Color CELL_UNCOVERED = new Color(164, 171, 188);
  Color BACKGROUND_COLOR = new Color(255, 255, 255);
  Color MINE = new Color(0, 0, 0);
  Color FLAG = new Color(255, 0, 0);
  ArrayList<Color> COLOR_LIST = new ArrayList<Color>(Arrays.asList(new Color(0, 0, 255),
      new Color(0, 255, 0), new Color(255, 0, 0), new Color(2, 2, 122), new Color(119, 21, 15),
      new Color(55, 126, 127), new Color(189, 46, 246), new Color(89, 194, 249)));
  int CELL_SIZE = 30;
  WorldImage COVERED_CELL = new OverlayImage(
      new RectangleImage(CELL_SIZE, CELL_SIZE, OutlineMode.OUTLINE, MINE),
      new RectangleImage(CELL_SIZE, CELL_SIZE, OutlineMode.SOLID, CELL_COVERED));
  WorldImage COVERED_MINE_CELL = new OverlayImage(
      new CircleImage(CELL_SIZE / 3, OutlineMode.SOLID, MINE), COVERED_CELL);
  WorldImage UNCOVERED_CELL = new OverlayImage(
      new RectangleImage(CELL_SIZE, CELL_SIZE, OutlineMode.OUTLINE, MINE),
      new RectangleImage(CELL_SIZE, CELL_SIZE, OutlineMode.SOLID, CELL_UNCOVERED));
  WorldImage FLAGGED_CELL = new OverlayImage(
      new EquilateralTriangleImage(CELL_SIZE / 1.5, OutlineMode.SOLID, Color.YELLOW), COVERED_CELL);
  WorldImage MINE_CELL = new OverlayImage(new CircleImage(CELL_SIZE / 3, OutlineMode.SOLID, MINE),
      UNCOVERED_CELL);
}

// represent class World 
class MinesweeperGame extends World implements Minesweeper {
  Grid game;
  int rows;
  int cols;
  int mines;
  boolean gameEnded;
  Random rand;

  // for game
  MinesweeperGame(int rows, int cols, int mines, Random rand) {
    this.game = new Grid(rows, cols, mines, rand);
    this.rows = rows;
    this.cols = cols;
    this.mines = mines;
    this.gameEnded = false;
    this.rand = rand;
  }

  // for testing
  MinesweeperGame(int rows, int cols, int mines, Random rand, boolean gameEnded,
      ArrayList<ArrayList<Cell>> list) {
    this.game = new Grid(rows, cols, list, rand, mines);
    this.rows = rows;
    this.cols = cols;
    this.mines = mines;
    this.gameEnded = gameEnded;
    this.rand = rand;
  }

  // draw the game scene
  public WorldScene makeScene() {
    WorldScene scene = new WorldScene(GAME_WIDTH, GAME_HEIGHT);
    Integer score = this.game.countUncoveredCellLeft();
    scene.placeImageXY(this.game.drawGrid(), CELL_SIZE * this.cols / 2, CELL_SIZE * this.rows / 2);
    scene.placeImageXY(
        new TextImage("cells left: " + Integer.toString(score), this.cols, Color.BLACK),
        CELL_SIZE * this.cols / 2, CELL_SIZE * this.rows + 50);
    if (score == 0) {
      scene.placeImageXY(
          new RectangleImage(this.cols * CELL_SIZE * 5 / 6, this.rows / 2 * CELL_SIZE,
              OutlineMode.SOLID, Color.WHITE),
          CELL_SIZE * this.cols / 2, CELL_SIZE * this.rows / 2);
      scene.placeImageXY(new TextImage("you won!", this.cols * 4, Color.GREEN),
          CELL_SIZE * this.cols / 2, CELL_SIZE * this.rows / 2 - CELL_SIZE);
      scene.placeImageXY(new TextImage("click spacebar to restart game", 20, Color.BLACK),
          CELL_SIZE * this.cols / 2, CELL_SIZE * this.rows / 2 + (CELL_SIZE * 2));
    }
    else if (this.gameEnded) {
      scene.placeImageXY(
          new RectangleImage(this.cols * CELL_SIZE * 5 / 6, this.rows / 2 * CELL_SIZE,
              OutlineMode.SOLID, Color.WHITE),
          CELL_SIZE * this.cols / 2, CELL_SIZE * this.rows / 2);
      scene.placeImageXY(new TextImage("game over!", this.cols * 4, Color.RED),
          CELL_SIZE * this.cols / 2, CELL_SIZE * this.rows / 2 - CELL_SIZE);
      scene.placeImageXY(new TextImage("click spacebar to restart game", 20, Color.BLACK),
          CELL_SIZE * this.cols / 2, CELL_SIZE * this.rows / 2 + (CELL_SIZE * 2));
    }
    return scene;
  }

  // play game when user clicks left or right mouse
  public void onMouseClicked(Posn pos, String button) {
    if (this.game.countUncoveredCellLeft() > 0 && !this.gameEnded) {
      this.game.uncoverOrFlagCell(pos.x, pos.y, button);
      this.gameEnded = this.game.cellIsMine(pos.x, pos.y);
    }
    if (this.game.countUncoveredCellLeft() == 0) {
      this.gameEnded = true;
    }
  }

  // display last scene if player lost, else keep continuing
  public WorldEnd worldEnds() {
    if (this.game.countUncoveredCellLeft() == 0 || this.gameEnded) {
      return new WorldEnd(true, this.makeScene());
    }
    else {
      return new WorldEnd(false, this.makeScene());
    }
  }

  // key event handler for restarting the game
  public void onKeyEvent(String key) {
    if (key.equals(" ")) {
      if (!this.gameEnded) {
        return;
      }
      else {
        this.game = new Grid(this.rows, this.cols, this.mines, this.rand);
        this.gameEnded = false;
      }
    }
  }
}