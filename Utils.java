//represent util class
class Utils {
  // check condition for constructor of grid
  int checkConstructorGrid(int rows, int cols, int mine) {
    if (rows < 2 || cols < 2) {
      throw new IllegalArgumentException("Grid must have at least 2 rows and 2 columns");
    }
    else if (mine > (rows * cols)) {
      throw new IllegalArgumentException("Number of mines must be less than number of cells");
    }
    else {
      return rows;
    }
  }
}