import java.util.ArrayList;

import javalib.worldimages.OverlayImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldImage;

// represent a cell on the grid
class Cell implements Minesweeper {
  ArrayList<Cell> neighbors;
  boolean isMine;
  boolean flagged;
  boolean uncovered;

  Cell() {
    this.neighbors = new ArrayList<Cell>();
    this.isMine = false;
    this.flagged = false;
    this.uncovered = false;
  }

  Cell(boolean isMine, boolean flagged, boolean uncovered, ArrayList<Cell> neighbors) {
    this.isMine = isMine;
    this.flagged = flagged;
    this.uncovered = uncovered;
    this.neighbors = neighbors;
  }

  // link two cells together
  void linkCell(Cell that) {
    this.neighbors.add(that);
    that.neighbors.add(this);
  }

  // set cell to contain mine
  void setMineTrue() {
    this.isMine = true;
  }

  // count number of mines of neighbors
  int countNeighborMines() {
    int result = 0;
    for (Cell element : this.neighbors) {
      if (element.isMine) {
        result = result + 1;
      }
    }
    return result;
  }

  // return 0 if a cell that is not a mine has not been uncovered
  int countCellLeft() {
    if (this.uncovered && !this.isMine) {
      return 1;
    }
    else {
      return 0;
    }
  }

  // draw a cell
  WorldImage drawCell() {
    if (!(this.uncovered)) {
      if (this.flagged) {
        return FLAGGED_CELL;
      }
      else {
        return COVERED_CELL;
      }
    }
    else {
      int neighbors = this.countNeighborMines();
      if (this.isMine) {
        return MINE_CELL;
      }
      else if (neighbors > 0) {
        return new OverlayImage(new TextImage(Integer.toString(neighbors), CELL_SIZE - 5,
            COLOR_LIST.get(neighbors - 1)), UNCOVERED_CELL);
      }
      else {
        return UNCOVERED_CELL;
      }
    }
  }

  // uncover cells when it is clicked
  void setUncovered(ArrayList<Cell> arr) {
    if (this.flagged) {
      return;
    }
    else if (this.isMine) {
      for (Cell element : arr) {
        if (element.isMine) {
          element.uncovered();
        }
      }
    }
    else if (this.countNeighborMines() > 0) {
      this.uncovered();
    }
    else {
      this.uncovered();
      this.uncoverNeighbors(new ArrayList<Cell>());
    }
  }

  // check if a cell is uncovered and is a mine
  boolean mineUncovered() {
    return this.uncovered && this.isMine;
  }

  // set the cell to be uncovered
  void uncovered() {
    if (this.flagged) {
      return;
    }
    else {
      this.uncovered = true;
    }
  }

  // uncovered neighbor cells
  void uncoverNeighbors(ArrayList<Cell> searchedCells) {
    for (Cell neighborCell : this.neighbors) {
      searchedCells.add(this);
      if (!this.flagged && !searchedCells.contains(neighborCell)
          && neighborCell.countNeighborMines() > 0) {
        neighborCell.uncovered();
        searchedCells.add(neighborCell);
      }
      else if (!this.flagged && !searchedCells.contains(neighborCell)
          && neighborCell.countNeighborMines() == 0) {
        neighborCell.uncovered();
        searchedCells.add(neighborCell);
        neighborCell.uncoverNeighbors(searchedCells);
      }
    }
  }

  // flag a cell
  void flag() {
    if (!this.uncovered) {
      this.flagged = !this.flagged;
    }
  }
}