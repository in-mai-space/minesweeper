import java.util.ArrayList;
import java.util.Random;

import javalib.worldimages.AboveImage;
import javalib.worldimages.BesideImage;
import javalib.worldimages.EmptyImage;
import javalib.worldimages.WorldImage;

// represent a grid of cells
class Grid implements Minesweeper {
  int rows;
  int cols;
  int mine;
  ArrayList<ArrayList<Cell>> cells;
  Random rand;
  ArrayList<Cell> allCells;

  // constructor for game
  Grid(int rows, int cols, int mine, Random rand) {
    this.rows = new Utils().checkConstructorGrid(rows, cols, mine);
    this.cols = cols;
    this.mine = mine;
    this.cells = new ArrayList<ArrayList<Cell>>();
    this.rand = rand;
    this.buildGrid();
    this.setMine(rand);
    this.linkAllHorizontalRows();
    this.linkAllDiagonalAndVertical();
  }

  // constructor for testing
  Grid(int rows, int cols, ArrayList<ArrayList<Cell>> cells, Random rand, int mines) {
    this.rows = rows;
    this.cols = cols;
    this.cells = cells;
    this.rand = rand;
    this.mine = mines;
  }

  // build list of rows of cells
  void buildGrid() {
    ArrayList<ArrayList<Cell>> result = new ArrayList<ArrayList<Cell>>();
    for (int i = 0; i < this.rows; i++) {
      ArrayList<Cell> row = new ArrayList<Cell>();
      for (int j = 0; j < this.cols; j++) {
        row.add(new Cell());
      }
      result.add(row);
    }
    this.cells = result;
  }

  // draw a row of cells
  WorldImage drawRow(ArrayList<Cell> arr) {
    WorldImage result = new EmptyImage();
    for (Cell element : arr) {
      result = new BesideImage(result, element.drawCell());
    }
    return result;
  }

  // draw a whole grid of cells
  WorldImage drawGrid() {
    WorldImage result = new EmptyImage();
    if (this.cells.size() > 0) {
      for (ArrayList<Cell> element : this.cells) {
        result = new AboveImage(result, this.drawRow(element));
      }
    }
    return result;
  }

  // link cells within a row
  void linkHorizontalRow(ArrayList<Cell> row) {
    for (int i = 0; i < this.cols - 1; i++) {
      row.get(i).linkCell(row.get(i + 1));
    }
  }

  // link cells horizontally for all rows
  void linkAllHorizontalRows() {
    for (int i = 0; i < this.rows; i++) {
      this.linkHorizontalRow(this.cells.get(i));
    }
  }

  // link cells vertically and diagonally for two rows
  void linkVerticalAndDiagonal(ArrayList<Cell> arr1, ArrayList<Cell> arr2) {
    for (int i = 0; i < arr1.size(); i++) {
      if (i == 0) {
        arr1.get(i).linkCell(arr2.get(i));
        arr1.get(i).linkCell(arr2.get(i + 1));
      }
      else if (i == arr1.size() - 1) {
        arr1.get(i).linkCell(arr2.get(i - 1));
        arr1.get(i).linkCell(arr2.get(i));
      }
      else {
        arr1.get(i).linkCell(arr2.get(i - 1));
        arr1.get(i).linkCell(arr2.get(i));
        arr1.get(i).linkCell(arr2.get(i + 1));
      }
    }
  }

  // link cells vertically and diagonally for all rows
  void linkAllDiagonalAndVertical() {
    for (int i = 0; i < this.rows - 1; i++) {
      this.linkVerticalAndDiagonal(this.cells.get(i), this.cells.get(i + 1));
    }
  }

  // randomize mine placement in grid
  void setMine(Random rand) {
    ArrayList<Cell> allCells = this.allCells();
    ArrayList<Cell> mineCells = new ArrayList<Cell>();
    for (int i = 0; i < this.mine; i++) {
      int index = rand.nextInt(allCells.size());
      Cell item = allCells.get(index);
      if (!mineCells.contains(item)) {
        mineCells.add(item);
      }
      else {
        i = i - 1;
      }
    }
    for (Cell element : mineCells) {
      element.setMineTrue();
    }
  }

  // turn ArrayList<ArrayList<Cell>> to ArrayList<Cell>
  ArrayList<Cell> allCells() {
    ArrayList<Cell> allCells = new ArrayList<Cell>();
    for (int i = 0; i < this.rows; i++) {
      allCells.addAll(this.cells.get(i));
    }
    return allCells;
  }

  // uncover cells
  void uncoverOrFlagCell(double x, double y, String mouse) {
    Double colAsDouble = Math.floor(x / CELL_SIZE);
    int colIndex = colAsDouble.intValue();
    Double rowAsDouble = Math.floor(y / CELL_SIZE);
    int rowIndex = rowAsDouble.intValue();
    if (rowIndex >= this.cells.size() || colIndex >= this.cells.get(rowIndex).size()) {
      return;
    }
    else {
      Cell fetchedCell = this.getCell(colIndex, this.cells.get(rowIndex));
      if (mouse.equals("LeftButton")) {
        fetchedCell.setUncovered(this.allCells());
      }
      else if (mouse.equals("RightButton")) {
        fetchedCell.flag();
      }
    }
  }

  // check if uncovered cell is a mine or not
  boolean cellIsMine(double x, double y) {
    Double colAsDouble = Math.floor(x / CELL_SIZE);
    int colIndex = colAsDouble.intValue();
    Double rowAsDouble = Math.floor(y / CELL_SIZE);
    int rowIndex = rowAsDouble.intValue();
    if (rowIndex >= this.cells.size() || colIndex >= this.cells.get(rowIndex).size()) {
      return false;
    }
    else {
      Cell fetchedCell = this.getCell(colIndex, this.cells.get(rowIndex));
      return fetchedCell.mineUncovered();
    }
  }

  // get a cell in a specific row
  Cell getCell(int colIndex, ArrayList<Cell> arr) {
    return arr.get(colIndex);
  }

  // count how cells have not been uncovered that are not mine
  int countUncoveredCellLeft() {
    int result = this.rows * this.cols - this.mine;
    for (Cell element : this.allCells()) {
      result = result - element.countCellLeft();
    }
    return result;
  }
}