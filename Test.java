import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import tester.Tester;
import javalib.impworld.WorldScene;
import javalib.worldimages.*;

class Examples implements Minesweeper {
  Grid grid;
  Grid grid2;
  Grid grid3;
  Grid gridMine;
  Grid floodEffect;
  Grid drawGrid;
  ArrayList<Cell> row;
  ArrayList<Cell> abc;
  ArrayList<Cell> def;
  ArrayList<Cell> efg;
  ArrayList<Cell> ghi;
  ArrayList<Cell> xyz;
  ArrayList<Cell> firstRow;
  ArrayList<Cell> secondRow;
  ArrayList<Cell> thirdRow;
  ArrayList<Cell> fourthRow;
  ArrayList<Cell> fifthRow;
  ArrayList<ArrayList<Cell>> fiveByFive;
  ArrayList<ArrayList<Cell>> rows;
  ArrayList<ArrayList<Cell>> testMinePosition;
  ArrayList<ArrayList<Cell>> twoByThree;
  ArrayList<ArrayList<Cell>> threeByThree;
  ArrayList<ArrayList<Cell>> drawList;
  Cell a;
  Cell b;
  Cell c;
  Cell d;
  Cell e;
  Cell f;
  Cell g;
  Cell h;
  Cell i;
  Cell x;
  Cell y;
  Cell z;
  Cell t;
  Cell oneOne;
  Cell oneTwo;
  Cell oneThree;
  Cell oneFour;
  Cell oneFive;
  Cell twoOne;
  Cell twoTwo;
  Cell twoThree;
  Cell twoFour;
  Cell twoFive;
  Cell threeOne;
  Cell threeTwo;
  Cell threeThree;
  Cell threeFour;
  Cell threeFive;
  Cell fourOne;
  Cell fourTwo;
  Cell fourThree;
  Cell fourFour;
  Cell fourFive;
  Cell fiveOne;
  Cell fiveTwo;
  Cell fiveThree;
  Cell fiveFour;
  Cell fiveFive;
  Cell mine;
  Cell empty;
  Cell num1;
  Cell num2;
  Cell num3;
  Cell num4;
  Cell num5;
  Cell num6;
  Cell num7;
  Cell num8;
  Cell flagged;
  Cell flaggedMine;
  Cell unflagged;
  Cell unflaggedMine;
  Cell r1c1;
  Cell r1c2;
  Cell r1c3;
  Cell r2c1;
  Cell r2c2;
  Cell r2c3;
  Cell r3c1;
  Cell r3c2;
  Cell r3c3;
  int gameRows;
  int gameCols;
  int worldWidth;
  int worldHeight;
  MinesweeperGame mockGame;
  MinesweeperGame mockGame2;
  MinesweeperGame mockGame3;
  WorldImage gridImage;
  WorldImage row1;
  WorldImage row2;
  WorldImage row3;
  WorldScene scene;

  void initData() {
    this.gameRows = 16;
    this.gameCols = 30;
    this.worldWidth = gameCols * CELL_SIZE;
    this.worldHeight = gameRows * CELL_SIZE + 100;
    this.grid = new Grid(3, 3, new ArrayList<ArrayList<Cell>>(), new Random(20), 3);
    this.a = new Cell();
    this.b = new Cell();
    this.c = new Cell();
    this.d = new Cell(true, false, false, new ArrayList<Cell>());
    this.e = new Cell();
    this.f = new Cell();
    this.g = new Cell();
    this.h = new Cell();
    this.x = new Cell();
    this.y = new Cell();
    this.z = new Cell();
    // boolean isMine, boolean flagged, boolean uncovered,
    this.oneOne = new Cell(false, false, false, new ArrayList<Cell>());
    this.oneTwo = new Cell(false, false, false, new ArrayList<Cell>());
    this.oneThree = new Cell(false, false, false, new ArrayList<Cell>());
    this.oneFour = new Cell(false, false, false, new ArrayList<Cell>());
    this.oneFive = new Cell(false, false, false, new ArrayList<Cell>());
    this.twoOne = new Cell(false, false, false, new ArrayList<Cell>());
    this.twoTwo = new Cell(true, false, false, new ArrayList<Cell>());
    this.twoThree = new Cell(false, false, false, new ArrayList<Cell>());
    this.twoFour = new Cell(false, false, false, new ArrayList<Cell>());
    this.twoFive = new Cell(false, false, false, new ArrayList<Cell>());
    this.threeOne = new Cell(false, false, false, new ArrayList<Cell>());
    this.threeTwo = new Cell(false, false, false, new ArrayList<Cell>());
    this.threeThree = new Cell(false, false, false, new ArrayList<Cell>());
    this.threeFour = new Cell(false, false, false, new ArrayList<Cell>());
    this.threeFive = new Cell(true, false, false, new ArrayList<Cell>());
    this.fourOne = new Cell(false, true, false, new ArrayList<Cell>());
    this.fourTwo = new Cell(false, false, false, new ArrayList<Cell>());
    this.fourThree = new Cell(false, false, false, new ArrayList<Cell>());
    this.fourFour = new Cell(false, false, false, new ArrayList<Cell>());
    this.fourFive = new Cell(false, false, false, new ArrayList<Cell>());
    this.fiveOne = new Cell(false, false, false, new ArrayList<Cell>());
    this.fiveTwo = new Cell(false, false, false, new ArrayList<Cell>());
    this.fiveThree = new Cell(true, false, false, new ArrayList<Cell>());
    this.fiveFour = new Cell(false, false, false, new ArrayList<Cell>());
    this.fiveFive = new Cell(false, false, false, new ArrayList<Cell>());
    this.firstRow = new ArrayList<Cell>(Arrays.asList(oneOne, oneTwo, oneThree, oneFour, oneFive));
    this.secondRow = new ArrayList<Cell>(Arrays.asList(twoOne, twoTwo, twoThree, twoFour, twoFive));
    this.thirdRow = new ArrayList<Cell>(
        Arrays.asList(threeOne, threeTwo, threeThree, threeFour, threeFive));
    this.fourthRow = new ArrayList<Cell>(
        Arrays.asList(fourOne, fourTwo, fourThree, fourFour, fourFive));
    this.fifthRow = new ArrayList<Cell>(
        Arrays.asList(fiveOne, fiveTwo, fiveThree, fiveFour, fiveFive));
    this.fiveByFive = new ArrayList<ArrayList<Cell>>(
        Arrays.asList(firstRow, secondRow, thirdRow, fourthRow, fifthRow));
    this.floodEffect = new Grid(5, 5, fiveByFive, new Random(), 3);

    this.r1c1 = new Cell(true, false, false, new ArrayList<Cell>());
    this.r1c2 = new Cell(false, false, false, new ArrayList<Cell>());
    this.r1c3 = new Cell(false, false, false, new ArrayList<Cell>());
    this.r2c1 = new Cell(false, false, false, new ArrayList<Cell>());
    this.r2c2 = new Cell(false, false, false, new ArrayList<Cell>());
    this.r2c3 = new Cell(true, false, false, new ArrayList<Cell>());
    this.r3c1 = new Cell(false, false, false, new ArrayList<Cell>());
    this.r3c2 = new Cell(false, false, false, new ArrayList<Cell>());
    this.r3c3 = new Cell(false, false, false, new ArrayList<Cell>());
    this.drawList = new ArrayList<ArrayList<Cell>>(
        Arrays.asList(new ArrayList<Cell>(Arrays.asList(r1c1, r1c2, r1c3)),
            new ArrayList<Cell>(Arrays.asList(r2c1, r2c2, r2c3)),
            new ArrayList<Cell>(Arrays.asList(r3c1, r3c2, r3c3))));
    this.drawGrid = new Grid(3, 3, drawList, new Random(20), 2);
    this.row1 = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), COVERED_CELL), COVERED_CELL),
        COVERED_CELL);
    this.row2 = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), COVERED_CELL), COVERED_CELL),
        COVERED_CELL);
    this.row3 = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), COVERED_CELL), COVERED_CELL),
        COVERED_CELL);
    this.gridImage = new AboveImage(new AboveImage(new AboveImage(new EmptyImage(), row1), row2),
        row3);

    this.i = new Cell(true, false, false, new ArrayList<Cell>());
    this.abc = new ArrayList<Cell>(Arrays.asList(a, b, c));
    this.def = new ArrayList<Cell>(Arrays.asList(d, e, f));
    this.ghi = new ArrayList<Cell>(Arrays.asList(g, h, i));

    this.xyz = new ArrayList<Cell>(Arrays.asList(x, y, z));
    this.efg = new ArrayList<Cell>(Arrays.asList(e, f, g));
    this.testMinePosition = new ArrayList<ArrayList<Cell>>(Arrays.asList(abc, xyz, efg));
    this.row = new ArrayList<Cell>(Arrays.asList(new Cell(), new Cell(), new Cell()));
    this.rows = new ArrayList<ArrayList<Cell>>(Arrays.asList(row, row, row));
    this.threeByThree = new ArrayList<ArrayList<Cell>>(Arrays.asList(abc, def, ghi));
    this.twoByThree = new ArrayList<ArrayList<Cell>>(Arrays.asList(abc, def));
    this.grid2 = new Grid(2, 3, twoByThree, new Random(20), 3);
    this.grid3 = new Grid(3, 3, threeByThree, new Random(20), 3);
    this.gridMine = new Grid(3, 3, testMinePosition, new Random(20), 3);

    this.mine = new Cell(true, false, true, new ArrayList<Cell>());
    this.empty = new Cell(false, false, true, new ArrayList<Cell>());
    this.num1 = new Cell(false, false, true, new ArrayList<Cell>(Arrays.asList(mine)));
    this.num2 = new Cell(false, false, true, new ArrayList<Cell>(Arrays.asList(mine, mine)));
    this.num3 = new Cell(false, false, true, new ArrayList<Cell>(Arrays.asList(mine, mine, mine)));
    this.num4 = new Cell(false, false, true,
        new ArrayList<Cell>(Arrays.asList(mine, mine, mine, mine)));
    this.num5 = new Cell(false, false, true,
        new ArrayList<Cell>(Arrays.asList(mine, mine, mine, mine, mine)));
    this.num6 = new Cell(false, false, true,
        new ArrayList<Cell>(Arrays.asList(mine, mine, mine, mine, mine, mine)));
    this.num7 = new Cell(false, false, true,
        new ArrayList<Cell>(Arrays.asList(mine, mine, mine, mine, mine, mine, mine)));
    this.num8 = new Cell(false, false, true,
        new ArrayList<Cell>(Arrays.asList(mine, mine, mine, mine, mine, mine, mine, mine)));
    this.flagged = new Cell(false, true, false, new ArrayList<Cell>());
    this.flaggedMine = new Cell(true, true, false, new ArrayList<Cell>());
    this.unflagged = new Cell(false, false, false, new ArrayList<Cell>());
    this.unflaggedMine = new Cell(true, false, false, new ArrayList<Cell>());

    this.mockGame = new MinesweeperGame(5, 5, 3, new Random(20), false, fiveByFive);
    this.mockGame2 = new MinesweeperGame(5, 5, 3, new Random(20), true, fiveByFive);
    this.mockGame3 = new MinesweeperGame(3, 3, 2, new Random(20), false, drawList);
    this.scene = new WorldScene(GAME_WIDTH, GAME_HEIGHT);
  }

  /* TEST CASES FOR GRID */
  void testBuildGrid(Tester t) {
    this.initData();
    t.checkExpect(grid.cells, new ArrayList<ArrayList<Cell>>());
    grid.buildGrid();
    t.checkExpect(grid.cells, rows);
  }

  boolean testAllCells(Tester t) {
    this.initData();
    return t.checkExpect(this.gridMine.allCells(),
        new ArrayList<Cell>(
            Arrays.asList(this.a, this.b, this.c, this.x, this.y, this.z, this.e, this.f, this.g)))
        && t.checkExpect(this.grid2.allCells(),
            new ArrayList<Cell>(Arrays.asList(this.a, this.b, this.c, this.d, this.e, this.f)))
        && t.checkExpect(this.grid3.allCells(), new ArrayList<Cell>(
            Arrays.asList(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i)));
  }

  void testLinkHorizontal(Tester t) {
    this.initData();
    t.checkExpect(a.neighbors, new ArrayList<Cell>());
    t.checkExpect(b.neighbors, new ArrayList<Cell>());
    t.checkExpect(c.neighbors, new ArrayList<Cell>());
    grid.linkHorizontalRow(this.abc);
    t.checkExpect(a.neighbors, new ArrayList<Cell>(Arrays.asList(b)));
    t.checkExpect(b.neighbors, new ArrayList<Cell>(Arrays.asList(a, c)));
    t.checkExpect(c.neighbors, new ArrayList<Cell>(Arrays.asList(b)));
  }

  void testCountUncoveredCellLeft(Tester t) {
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    t.checkExpect(floodEffect.countUncoveredCellLeft(), 22);
    // uncover a cell whose neighbor is a mine
    oneOne.setUncovered(floodEffect.allCells());
    t.checkExpect(floodEffect.countUncoveredCellLeft(), 21);
    // uncover an empty cell
    fiveFive.setUncovered(floodEffect.allCells());
    t.checkExpect(floodEffect.countUncoveredCellLeft(), 17);
    // uncover an empty cell
    oneFive.setUncovered(floodEffect.allCells());
    t.checkExpect(floodEffect.countUncoveredCellLeft(), 11);
    // click on mine cell, number of cell left is same
    twoTwo.setUncovered(floodEffect.allCells());
    t.checkExpect(floodEffect.countUncoveredCellLeft(), 11);
  }

  void testLinkAllHorizontalRows(Tester t) {
    this.initData();
    t.checkExpect(a.neighbors, new ArrayList<Cell>());
    t.checkExpect(b.neighbors, new ArrayList<Cell>());
    t.checkExpect(c.neighbors, new ArrayList<Cell>());
    t.checkExpect(d.neighbors, new ArrayList<Cell>());
    t.checkExpect(e.neighbors, new ArrayList<Cell>());
    t.checkExpect(f.neighbors, new ArrayList<Cell>());
    grid2.linkAllHorizontalRows();
    t.checkExpect(a.neighbors, new ArrayList<Cell>(Arrays.asList(b)));
    t.checkExpect(b.neighbors, new ArrayList<Cell>(Arrays.asList(a, c)));
    t.checkExpect(c.neighbors, new ArrayList<Cell>(Arrays.asList(b)));
    t.checkExpect(d.neighbors, new ArrayList<Cell>(Arrays.asList(e)));
    t.checkExpect(e.neighbors, new ArrayList<Cell>(Arrays.asList(d, f)));
    t.checkExpect(f.neighbors, new ArrayList<Cell>(Arrays.asList(e)));
  }

  void testLinkVerticalAndDiagonal(Tester t) {
    this.initData();
    t.checkExpect(a.neighbors, new ArrayList<Cell>());
    t.checkExpect(b.neighbors, new ArrayList<Cell>());
    t.checkExpect(c.neighbors, new ArrayList<Cell>());
    t.checkExpect(d.neighbors, new ArrayList<Cell>());
    t.checkExpect(e.neighbors, new ArrayList<Cell>());
    t.checkExpect(f.neighbors, new ArrayList<Cell>());
    t.checkExpect(g.neighbors, new ArrayList<Cell>());
    t.checkExpect(h.neighbors, new ArrayList<Cell>());
    t.checkExpect(i.neighbors, new ArrayList<Cell>());
    grid3.linkAllDiagonalAndVertical();
    t.checkExpect(a.neighbors, new ArrayList<Cell>(Arrays.asList(d, e)));
    t.checkExpect(b.neighbors, new ArrayList<Cell>(Arrays.asList(d, e, f)));
    t.checkExpect(c.neighbors, new ArrayList<Cell>(Arrays.asList(e, f)));
    t.checkExpect(d.neighbors, new ArrayList<Cell>(Arrays.asList(a, b, g, h)));
    t.checkExpect(e.neighbors, new ArrayList<Cell>(Arrays.asList(a, b, c, g, h, i)));
    t.checkExpect(f.neighbors, new ArrayList<Cell>(Arrays.asList(b, c, h, i)));
    t.checkExpect(g.neighbors, new ArrayList<Cell>(Arrays.asList(d, e)));
    t.checkExpect(h.neighbors, new ArrayList<Cell>(Arrays.asList(d, e, f)));
    t.checkExpect(i.neighbors, new ArrayList<Cell>(Arrays.asList(e, f)));
  }

  void testLinkVerticalAndDiagonalForTwoRow(Tester t) {
    this.initData();
    t.checkExpect(a.neighbors, new ArrayList<Cell>());
    t.checkExpect(b.neighbors, new ArrayList<Cell>());
    t.checkExpect(c.neighbors, new ArrayList<Cell>());
    t.checkExpect(d.neighbors, new ArrayList<Cell>());
    t.checkExpect(e.neighbors, new ArrayList<Cell>());
    t.checkExpect(f.neighbors, new ArrayList<Cell>());
    grid3.linkVerticalAndDiagonal(abc, def);
    t.checkExpect(a.neighbors, new ArrayList<Cell>(Arrays.asList(d, e)));
    t.checkExpect(b.neighbors, new ArrayList<Cell>(Arrays.asList(d, e, f)));
    t.checkExpect(c.neighbors, new ArrayList<Cell>(Arrays.asList(e, f)));
    t.checkExpect(d.neighbors, new ArrayList<Cell>(Arrays.asList(a, b)));
    t.checkExpect(e.neighbors, new ArrayList<Cell>(Arrays.asList(a, b, c)));
    t.checkExpect(f.neighbors, new ArrayList<Cell>(Arrays.asList(b, c)));
  }

  void testSetMine(Tester t) {
    this.initData();
    t.checkExpect(gridMine.cells, testMinePosition);
    t.checkExpect(a.isMine, false);
    t.checkExpect(b.isMine, false);
    t.checkExpect(c.isMine, false);
    t.checkExpect(x.isMine, false);
    t.checkExpect(y.isMine, false);
    t.checkExpect(z.isMine, false);
    t.checkExpect(e.isMine, false);
    t.checkExpect(f.isMine, false);
    t.checkExpect(g.isMine, false);
    gridMine.setMine(new Random(20));
    // three mines are set randomly
    t.checkExpect(a.isMine, true);
    t.checkExpect(b.isMine, false);
    t.checkExpect(c.isMine, false);
    t.checkExpect(x.isMine, false);
    t.checkExpect(y.isMine, false);
    t.checkExpect(z.isMine, false);
    t.checkExpect(e.isMine, false);
    t.checkExpect(f.isMine, true);
    t.checkExpect(g.isMine, true);
  }

  void testUncoverNeighbors(Tester t) {
    this.initData();
    t.checkExpect(floodEffect.cells, fiveByFive);
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    oneFive.uncoverNeighbors(new ArrayList<Cell>());
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(oneFour.uncovered, true);
    t.checkExpect(oneThree.uncovered, true);
    t.checkExpect(twoThree.uncovered, true);
    t.checkExpect(twoFour.uncovered, true);
    t.checkExpect(twoFive.uncovered, true);
    t.checkExpect(twoFive.uncovered, true);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFour.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(oneTwo.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(threeTwo.uncovered, false);
    fiveOne.uncoverNeighbors(new ArrayList<Cell>());
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fourOne.uncovered, false);
    t.checkExpect(fourTwo.uncovered, true);
    t.checkExpect(fiveTwo.uncovered, true);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeTwo.uncovered, false);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(fourThree.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
    fiveFive.uncoverNeighbors(new ArrayList<Cell>());
    t.checkExpect(fiveFive.uncovered, false);
    t.checkExpect(fourFour.uncovered, true);
    t.checkExpect(fourFive.uncovered, true);
    t.checkExpect(fiveFour.uncovered, true);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFour.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourThree.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
  }

  void testSetUncovered(Tester t) {
    this.initData();
    // click on three different empty cells
    t.checkExpect(floodEffect.cells, fiveByFive);
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    oneFive.setUncovered(floodEffect.allCells());
    t.checkExpect(oneFive.uncovered, true);
    t.checkExpect(oneFour.uncovered, true);
    t.checkExpect(oneThree.uncovered, true);
    t.checkExpect(twoThree.uncovered, true);
    t.checkExpect(twoFour.uncovered, true);
    t.checkExpect(twoFive.uncovered, true);
    t.checkExpect(twoFive.uncovered, true);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFour.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(oneTwo.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(threeTwo.uncovered, false);
    fiveOne.setUncovered(floodEffect.allCells());
    t.checkExpect(fiveOne.uncovered, true);
    t.checkExpect(fourOne.uncovered, false);
    t.checkExpect(fourTwo.uncovered, true);
    t.checkExpect(fiveTwo.uncovered, true);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeTwo.uncovered, false);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(fourThree.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
    fiveFive.setUncovered(floodEffect.allCells());
    t.checkExpect(fiveFive.uncovered, true);
    t.checkExpect(fourFour.uncovered, true);
    t.checkExpect(fourFive.uncovered, true);
    t.checkExpect(fiveFour.uncovered, true);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFour.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourThree.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);

    // click on a cell whose neighbors contain mine
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    oneOne.setUncovered(floodEffect.allCells());
    t.checkExpect(oneOne.uncovered, true);
    t.checkExpect(oneTwo.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoOne.uncovered, false);

    // click on a flagged cell
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    fourOne.setUncovered(floodEffect.allCells());
    t.checkExpect(fourOne.uncovered, false);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeTwo.uncovered, false);
    t.checkExpect(fourTwo.uncovered, false);
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fiveTwo.uncovered, false);

    // click on a cell that is a mine
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    twoTwo.setUncovered(floodEffect.allCells());
    t.checkExpect(twoTwo.uncovered, true);
    // two other mined cells are bombed
    t.checkExpect(threeFive.uncovered, true);
    t.checkExpect(fiveThree.uncovered, true);
    // other cells that are not mine is not uncovered
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(fourOne.uncovered, false);
    t.checkExpect(twoOne.uncovered, false);
    t.checkExpect(fiveFive.uncovered, false);
  }

  void testUncoverOrFlagCell(Tester t) {
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    // oneOne cell in the grid (cell whose neighbors are mine)
    floodEffect.uncoverOrFlagCell(25, 25, "LeftButton");
    t.checkExpect(oneOne.uncovered, true);
    t.checkExpect(oneTwo.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoOne.uncovered, false);

    // click outside that is not a cell, nothing changes
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    floodEffect.uncoverOrFlagCell(200, 1000, "LeftButton");
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneThree.uncovered, false);
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoFour.uncovered, false);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourTwo.uncovered, false);
    t.checkExpect(fourFour.uncovered, false);
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
    t.checkExpect(fiveFive.uncovered, false);

    // click on a bomb
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    floodEffect.uncoverOrFlagCell(45, 45, "LeftButton");
    t.checkExpect(twoTwo.uncovered, true);
    // two other mined cells are bombed
    t.checkExpect(threeFive.uncovered, true);
    t.checkExpect(fiveThree.uncovered, true);
    // other cells that are not mine is not uncovered
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(fourOne.uncovered, false);
    t.checkExpect(twoOne.uncovered, false);
    t.checkExpect(fiveFive.uncovered, false);

    // click on a flagged cell with left button
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    floodEffect.uncoverOrFlagCell(25, 115, "LeftButton");
    t.checkExpect(fourOne.uncovered, false);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeTwo.uncovered, false);
    t.checkExpect(fourTwo.uncovered, false);
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fiveTwo.uncovered, false);

    // click on an empty cell with left button (flood)
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    floodEffect.uncoverOrFlagCell(145, 145, "LeftButton");
    t.checkExpect(fiveFive.uncovered, true);
    t.checkExpect(fourFour.uncovered, true);
    t.checkExpect(fourFive.uncovered, true);
    t.checkExpect(fiveFour.uncovered, true);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFour.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourThree.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);

    // click on a cell that is not uncovered with right button
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    // cell whose number is a mine
    t.checkExpect(oneOne.flagged, false);
    floodEffect.uncoverOrFlagCell(25, 25, "RightButton");
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneOne.flagged, true);
    floodEffect.uncoverOrFlagCell(25, 25, "LeftButton");
    // if a button is flagged, cannot uncover it
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneOne.flagged, true);
    floodEffect.uncoverOrFlagCell(25, 25, "RightButton");
    t.checkExpect(oneOne.uncovered, false);
    // unflag the cell that is flagged
    t.checkExpect(oneOne.flagged, false);
    // empty cell
    t.checkExpect(fiveFive.flagged, false);
    floodEffect.uncoverOrFlagCell(147, 147, "RightButton");
    t.checkExpect(fiveFive.uncovered, false);
    t.checkExpect(fiveFive.flagged, true);
    floodEffect.uncoverOrFlagCell(147, 147, "LeftButton");
    t.checkExpect(fiveFive.uncovered, false);
    t.checkExpect(fiveFive.flagged, true);
    floodEffect.uncoverOrFlagCell(147, 147, "RightButton");
    t.checkExpect(fiveFive.flagged, false);
    // cell contains mine
    t.checkExpect(twoTwo.flagged, false);
    floodEffect.uncoverOrFlagCell(45, 43, "RightButton");
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoTwo.flagged, true);
    floodEffect.uncoverOrFlagCell(45, 43, "LeftButton");
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoTwo.flagged, true);
    floodEffect.uncoverOrFlagCell(45, 43, "RightButton");
    t.checkExpect(twoTwo.flagged, false);

    // click on any positions that are not a cell
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    floodEffect.uncoverOrFlagCell(200, 1000, "RightButton");
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneThree.uncovered, false);
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoFour.uncovered, false);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourTwo.uncovered, false);
    t.checkExpect(fourFour.uncovered, false);
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
    t.checkExpect(fiveFive.uncovered, false);

    // click on middle button
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    floodEffect.uncoverOrFlagCell(25, 25, "MiddleButton");
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneThree.uncovered, false);
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoFour.uncovered, false);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourTwo.uncovered, false);
    t.checkExpect(fourFour.uncovered, false);
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
    t.checkExpect(fiveFive.uncovered, false);
  }

  boolean testDrawRow(Tester t) {
    this.initData();
    // row with mine, num1, empty
    return t.checkExpect(
        this.grid.drawRow(new ArrayList<Cell>(Arrays.asList(this.mine, this.num1, this.empty))),
        new BesideImage(new BesideImage(new BesideImage(new EmptyImage(), this.mine.drawCell()),
            this.num1.drawCell()), this.empty.drawCell()))
        // row with flag, mine, unflagged mine, num3
        && t.checkExpect(
            this.grid.drawRow(new ArrayList<Cell>(
                Arrays.asList(this.flaggedMine, this.unflaggedMine, this.num3))),
            new BesideImage(
                new BesideImage(new BesideImage(new EmptyImage(), this.flaggedMine.drawCell()),
                    this.unflaggedMine.drawCell()),
                this.num3.drawCell()))
        // row with mine, unflagged, and flagged
        && t.checkExpect(
            this.grid.drawRow(
                new ArrayList<Cell>(Arrays.asList(this.mine, this.unflagged, this.flagged))),
            new BesideImage(new BesideImage(new BesideImage(new EmptyImage(), this.mine.drawCell()),
                this.unflagged.drawCell()), this.flagged.drawCell()));
  }

  void testCellIsMine(Tester t) {
    this.initData();
    t.checkExpect(floodEffect.cellIsMine(45, 45), false);
    twoTwo.uncovered();
    t.checkExpect(floodEffect.cellIsMine(45, 45), true);
    t.checkExpect(floodEffect.cellIsMine(147, 25), false);
    oneFive.uncovered();
    t.checkExpect(floodEffect.cellIsMine(147, 25), false);
    t.checkExpect(floodEffect.cellIsMine(110, 25), false);
    fourOne.uncovered();
    t.checkExpect(floodEffect.cellIsMine(110, 25), false);
    t.checkExpect(floodEffect.cellIsMine(25, 25), false);
    oneOne.uncovered();
    t.checkExpect(floodEffect.cellIsMine(25, 25), false);
    // click on any locations in game that is not a cell
    t.checkExpect(floodEffect.cellIsMine(200, 1000), false);
  }

  boolean testConstructorExceptionForGrid(Tester t) {
    return t.checkConstructorException(
        new IllegalArgumentException("Grid must have at least 2 rows and 2 columns"), "Grid", 1, 2,
        1, new Random())
        && t.checkConstructorException(
            new IllegalArgumentException("Grid must have at least 2 rows and 2 columns"), "Grid", 4,
            1, 1, new Random())
        && t.checkConstructorException(
            new IllegalArgumentException("Number of mines must be less than number of cells"),
            "Grid", 5, 5, 26, new Random());
  }

  boolean testGetCell(Tester t) {
    this.initData();
    return t.checkExpect(this.grid3.getCell(0, this.abc), this.a)
        && t.checkExpect(this.grid3.getCell(1, this.abc), this.b)
        && t.checkExpect(this.grid3.getCell(2, this.abc), this.c)
        && t.checkExpect(this.grid3.getCell(0, this.def), this.d)
        && t.checkExpect(this.grid3.getCell(1, this.def), this.e)
        && t.checkExpect(this.grid3.getCell(2, this.def), this.f)
        && t.checkExpect(this.grid3.getCell(0, this.ghi), this.g)
        && t.checkExpect(this.grid3.getCell(1, this.ghi), this.h)
        && t.checkExpect(this.grid3.getCell(2, this.ghi), this.i);
  }

  /* TEST CASES FOR UTILS */
  boolean checkUtils(Tester t) {
    this.initData();
    return t.checkException(
        new IllegalArgumentException("Grid must have at least 2 rows and 2 columns"), "Utils",
        "checkConstructorGrid", 1, 3, 1)
        && t.checkException(
            new IllegalArgumentException("Grid must have at least 2 rows and 2 columns"), "Utils",
            "checkConstructorGrid", 3, 1, 1)
        && t.checkException(
            new IllegalArgumentException("Grid must have at least 2 rows and 2 columns"), "Utils",
            "checkConstructorGrid", 1, 1, 1)
        && t.checkException(
            new IllegalArgumentException("Number of mines must be less than number of cells"),
            "Utils", "checkConstructorGrid", 1, 1, 3)
        && t.checkExpect(new Utils().checkConstructorGrid(2, 2, 4), 2);
  }

  /* TEST CASES FOR CELL */
  void testLinkCell(Tester t) {
    this.initData();
    t.checkExpect(a.neighbors, new ArrayList<Cell>());
    t.checkExpect(b.neighbors, new ArrayList<Cell>());
    a.linkCell(b);
    t.checkExpect(a.neighbors, new ArrayList<Cell>(Arrays.asList(b)));
    t.checkExpect(b.neighbors, new ArrayList<Cell>(Arrays.asList(a)));
  }

  void testSetMineTrue(Tester t) {
    this.initData();
    t.checkExpect(a.isMine, false);
    a.setMineTrue();
    t.checkExpect(a.isMine, true);
  }

  void testCountMines(Tester t) {
    this.initData();
    grid3.linkAllDiagonalAndVertical();
    grid3.linkAllHorizontalRows();
    t.checkExpect(a.countNeighborMines(), 1);
    t.checkExpect(b.countNeighborMines(), 1);
    t.checkExpect(c.countNeighborMines(), 0);
    t.checkExpect(d.countNeighborMines(), 0);
    t.checkExpect(e.countNeighborMines(), 2);
    t.checkExpect(f.countNeighborMines(), 1);
    t.checkExpect(h.countNeighborMines(), 2);
    t.checkExpect(g.countNeighborMines(), 1);
  }

  boolean testCountCellLeft(Tester t) {
    this.initData();
    return t.checkExpect(this.mine.countCellLeft(), 0)
        && t.checkExpect(this.empty.countCellLeft(), 1)
        && t.checkExpect(this.num1.countCellLeft(), 1)
        && t.checkExpect(this.num2.countCellLeft(), 1)
        && t.checkExpect(this.flagged.countCellLeft(), 0)
        && t.checkExpect(this.unflagged.countCellLeft(), 0)
        && t.checkExpect(this.flaggedMine.countCellLeft(), 0)
        && t.checkExpect(this.unflaggedMine.countCellLeft(), 0);
  }

  void testFlag(Tester t) {
    this.initData();
    t.checkExpect(this.mine.flagged, false);
    t.checkExpect(this.empty.flagged, false);
    t.checkExpect(this.num1.flagged, false);
    t.checkExpect(this.flagged.flagged, true);
    t.checkExpect(this.unflagged.flagged, false);
    t.checkExpect(this.flaggedMine.flagged, true);
    t.checkExpect(this.unflaggedMine.flagged, false);
    this.mine.flag();
    this.empty.flag();
    this.num1.flag();
    this.flagged.flag();
    this.unflagged.flag();
    this.flaggedMine.flag();
    this.unflaggedMine.flag();
    t.checkExpect(this.mine.flagged, false);
    t.checkExpect(this.empty.flagged, false);
    t.checkExpect(this.num1.flagged, false);
    t.checkExpect(this.flagged.flagged, false);
    t.checkExpect(this.unflagged.flagged, true);
    t.checkExpect(this.flaggedMine.flagged, false);
    t.checkExpect(this.unflaggedMine.flagged, true);
    this.mine.flag();
    this.empty.flag();
    this.num1.flag();
    this.flagged.flag();
    this.unflagged.flag();
    this.flaggedMine.flag();
    this.unflaggedMine.flag();
    t.checkExpect(this.mine.flagged, false);
    t.checkExpect(this.empty.flagged, false);
    t.checkExpect(this.num1.flagged, false);
    t.checkExpect(this.flagged.flagged, true);
    t.checkExpect(this.unflagged.flagged, false);
    t.checkExpect(this.flaggedMine.flagged, true);
    t.checkExpect(this.unflaggedMine.flagged, false);
  }

  void testUncovered(Tester t) {
    this.initData();
    t.checkExpect(a.uncovered, false);
    a.uncovered();
    t.checkExpect(a.uncovered, true);
    a.uncovered();
    t.checkExpect(a.uncovered, true);
  }

  void testMineUncovered(Tester t) {
    this.initData();
    t.checkExpect(a.mineUncovered(), false);
    a.uncovered();
    t.checkExpect(a.mineUncovered(), false);
    t.checkExpect(d.mineUncovered(), false);
    d.uncovered();
    t.checkExpect(d.mineUncovered(), true);
  }

  boolean testDrawCell(Tester t) {
    this.initData();
    return t.checkExpect(this.mine.drawCell(), MINE_CELL)
        && t.checkExpect(this.empty.drawCell(), UNCOVERED_CELL)
        && t.checkExpect(this.num1.drawCell(),
            new OverlayImage(new TextImage(Integer.toString(1), CELL_SIZE - 5, COLOR_LIST.get(0)),
                UNCOVERED_CELL))
        && t.checkExpect(this.num2.drawCell(),
            new OverlayImage(new TextImage(Integer.toString(2), CELL_SIZE - 5, COLOR_LIST.get(1)),
                UNCOVERED_CELL))
        && t.checkExpect(this.num3.drawCell(),
            new OverlayImage(new TextImage(Integer.toString(3), CELL_SIZE - 5, COLOR_LIST.get(2)),
                UNCOVERED_CELL))
        && t.checkExpect(this.num4.drawCell(),
            new OverlayImage(new TextImage(Integer.toString(4), CELL_SIZE - 5, COLOR_LIST.get(3)),
                UNCOVERED_CELL))
        && t.checkExpect(this.num5.drawCell(),
            new OverlayImage(new TextImage(Integer.toString(5), CELL_SIZE - 5, COLOR_LIST.get(4)),
                UNCOVERED_CELL))
        && t.checkExpect(this.num6.drawCell(),
            new OverlayImage(new TextImage(Integer.toString(6), CELL_SIZE - 5, COLOR_LIST.get(5)),
                UNCOVERED_CELL))
        && t.checkExpect(this.num7.drawCell(),
            new OverlayImage(new TextImage(Integer.toString(7), CELL_SIZE - 5, COLOR_LIST.get(6)),
                UNCOVERED_CELL))
        && t.checkExpect(this.num8.drawCell(),
            new OverlayImage(new TextImage(Integer.toString(8), CELL_SIZE - 5, COLOR_LIST.get(7)),
                UNCOVERED_CELL))
        && t.checkExpect(this.flagged.drawCell(), FLAGGED_CELL)
        && t.checkExpect(this.flaggedMine.drawCell(), FLAGGED_CELL)
        && t.checkExpect(this.unflagged.drawCell(), COVERED_CELL)
        && t.checkExpect(this.unflaggedMine.drawCell(), COVERED_CELL);
  }

  void testDrawGrid(Tester t) {
    this.initData();
    drawGrid.linkAllDiagonalAndVertical();
    drawGrid.linkAllHorizontalRows();
    // all cells covered
    t.checkExpect(drawGrid.drawGrid(), gridImage);
    // uncover one cell whose neighbor is a mine
    r3c3.uncovered();
    WorldImage uncoveredCell = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), COVERED_CELL), COVERED_CELL),
        new OverlayImage(new TextImage("1", CELL_SIZE - 5, COLOR_LIST.get(0)), UNCOVERED_CELL));
    WorldImage modifiedGrid1 = new AboveImage(
        new AboveImage(new AboveImage(new EmptyImage(), row1), row2), uncoveredCell);
    t.checkExpect(drawGrid.drawGrid(), modifiedGrid1);

    this.initData();
    drawGrid.linkAllDiagonalAndVertical();
    drawGrid.linkAllHorizontalRows();
    t.checkExpect(drawGrid.drawGrid(), gridImage);
    // flag a cell
    r2c1.flag();
    WorldImage secondRowChange = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), FLAGGED_CELL), COVERED_CELL),
        COVERED_CELL);
    WorldImage modifiedGrid2 = new AboveImage(
        new AboveImage(new AboveImage(new EmptyImage(), row1), secondRowChange), row3);
    t.checkExpect(drawGrid.drawGrid(), modifiedGrid2);
    // flood the grid when there is flagged cell near by
    r3c1.setUncovered(drawGrid.allCells());
    WorldImage secondRowChange2 = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), FLAGGED_CELL),
            new OverlayImage(new TextImage("2", CELL_SIZE - 5, COLOR_LIST.get(1)), UNCOVERED_CELL)),
        COVERED_CELL);
    WorldImage thirdRowChange = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), UNCOVERED_CELL),
            new OverlayImage(new TextImage("1", CELL_SIZE - 5, COLOR_LIST.get(0)), UNCOVERED_CELL)),
        COVERED_CELL);
    WorldImage modifiedGrid3 = new AboveImage(
        new AboveImage(new AboveImage(new EmptyImage(), row1), secondRowChange2), thirdRowChange);
    t.checkExpect(drawGrid.drawGrid(), modifiedGrid3);

    this.initData();
    drawGrid.linkAllDiagonalAndVertical();
    drawGrid.linkAllHorizontalRows();
    t.checkExpect(drawGrid.drawGrid(), gridImage);
    // flood the grid when empty cell is clicked
    r3c1.setUncovered(drawGrid.allCells());
    WorldImage secondRowChange3 = new BesideImage(
        new BesideImage(
            new BesideImage(new EmptyImage(),
                new OverlayImage(new TextImage("1", CELL_SIZE - 5, COLOR_LIST.get(0)),
                    UNCOVERED_CELL)),
            new OverlayImage(new TextImage("2", CELL_SIZE - 5, COLOR_LIST.get(1)), UNCOVERED_CELL)),
        COVERED_CELL);
    WorldImage modifiedGrid4 = new AboveImage(
        new AboveImage(new AboveImage(new EmptyImage(), row1), secondRowChange3), thirdRowChange);
    t.checkExpect(drawGrid.drawGrid(), modifiedGrid4);
    // click on the cell that is a mine
    r1c1.setUncovered(drawGrid.allCells());
    WorldImage firstRowChange = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), MINE_CELL), COVERED_CELL), COVERED_CELL);
    WorldImage secondRowChange4 = new BesideImage(
        new BesideImage(
            new BesideImage(new EmptyImage(),
                new OverlayImage(new TextImage("1", CELL_SIZE - 5, COLOR_LIST.get(0)),
                    UNCOVERED_CELL)),
            new OverlayImage(new TextImage("2", CELL_SIZE - 5, COLOR_LIST.get(1)), UNCOVERED_CELL)),
        MINE_CELL);
    WorldImage modifiedGrid5 = new AboveImage(
        new AboveImage(new AboveImage(new EmptyImage(), firstRowChange), secondRowChange4),
        thirdRowChange);
    t.checkExpect(drawGrid.drawGrid(), modifiedGrid5);
  }

  /* TEST CASES FOR MINESWEEPER */
  void testBigBang(Tester t) {
    this.initData();
    MinesweeperGame world = new MinesweeperGame(gameRows, gameCols, 99, new Random());
    world.bigBang(worldWidth, worldHeight);
  }

  void testOnKeyEvent(Tester t) {
    this.initData();
    // game is still going on when player clicks space, nothing happen
    t.checkExpect(mockGame.gameEnded, false);
    mockGame.onKeyEvent(" ");
    t.checkExpect(mockGame.gameEnded, false);
    // game is still going on and user clicks a random key
    t.checkExpect(mockGame.gameEnded, false);
    mockGame.onKeyEvent("a");
    t.checkExpect(mockGame.gameEnded, false);
    // game ended and user clicks spacebar to replay
    t.checkExpect(mockGame2.gameEnded, true);
    mockGame2.onKeyEvent(" ");
    t.checkExpect(mockGame2.gameEnded, false);
    t.checkExpect(mockGame2.game, new Grid(5, 5, 3, new Random(20)));

    this.initData();
    // game ended and user clicks on other non-spacebar key
    t.checkExpect(mockGame2.gameEnded, true);
    mockGame2.onKeyEvent("a");
    t.checkExpect(mockGame2.gameEnded, true);
    t.checkExpect(mockGame2.game, floodEffect);
    t.checkExpect(mockGame2.rows, 5);
    t.checkExpect(mockGame2.cols, 5);
    t.checkExpect(mockGame2.mines, 3);
  }

  void testOnMouseClick(Tester t) {
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    // oneOne cell in the grid (cell whose neighbors are mine)
    floodEffect.uncoverOrFlagCell(25, 25, "LeftButton");
    t.checkExpect(oneOne.uncovered, true);
    t.checkExpect(oneTwo.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoOne.uncovered, false);

    // click outside that is not a cell, nothing changes
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    floodEffect.uncoverOrFlagCell(200, 1000, "LeftButton");
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneThree.uncovered, false);
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoFour.uncovered, false);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourTwo.uncovered, false);
    t.checkExpect(fourFour.uncovered, false);
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
    t.checkExpect(fiveFive.uncovered, false);

    // click on a mine
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    floodEffect.uncoverOrFlagCell(45, 45, "LeftButton");
    t.checkExpect(twoTwo.uncovered, true);
    // two other cells are also mine
    t.checkExpect(threeFive.uncovered, true);
    t.checkExpect(fiveThree.uncovered, true);
    // other cells that are not mine is not uncovered
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(fourOne.uncovered, false);
    t.checkExpect(twoOne.uncovered, false);
    t.checkExpect(fiveFive.uncovered, false);

    // click on a flagged cell with left button
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    floodEffect.uncoverOrFlagCell(25, 115, "LeftButton");
    t.checkExpect(fourOne.uncovered, false);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeTwo.uncovered, false);
    t.checkExpect(fourTwo.uncovered, false);
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fiveTwo.uncovered, false);

    // click on an empty cell with left button (flood)
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    mockGame.onMouseClicked(new Posn(145, 145), "LeftButton");
    t.checkExpect(fiveFive.uncovered, true);
    t.checkExpect(fourFour.uncovered, true);
    t.checkExpect(fourFive.uncovered, true);
    t.checkExpect(fiveFour.uncovered, true);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFour.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourThree.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
    // click on a cell that is not uncovered with right button
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    // cell whose number is a mine
    t.checkExpect(oneOne.flagged, false);
    mockGame.onMouseClicked(new Posn(25, 25), "RightButton");
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneOne.flagged, true);
    mockGame.onMouseClicked(new Posn(25, 25), "LeftButton");
    // if a button is flagged, cannot uncover it
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneOne.flagged, true);
    mockGame.onMouseClicked(new Posn(25, 25), "RightButton");
    t.checkExpect(oneOne.uncovered, false);
    // unflag the cell that is flagged
    t.checkExpect(oneOne.flagged, false);
    // empty cell
    t.checkExpect(fiveFive.flagged, false);
    mockGame.onMouseClicked(new Posn(147, 147), "RightButton");
    t.checkExpect(fiveFive.uncovered, false);
    t.checkExpect(fiveFive.flagged, true);
    mockGame.onMouseClicked(new Posn(147, 147), "LeftButton");
    t.checkExpect(fiveFive.uncovered, false);
    t.checkExpect(fiveFive.flagged, true);
    mockGame.onMouseClicked(new Posn(147, 147), "RightButton");
    t.checkExpect(fiveFive.flagged, false);
    // cell contains mine
    t.checkExpect(twoTwo.flagged, false);
    mockGame.onMouseClicked(new Posn(45, 43), "RightButton");
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoTwo.flagged, true);
    mockGame.onMouseClicked(new Posn(45, 43), "LeftButton");
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoTwo.flagged, true);
    mockGame.onMouseClicked(new Posn(45, 43), "RightButton");
    t.checkExpect(twoTwo.flagged, false);

    // click on any positions that are not a cell
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    mockGame.onMouseClicked(new Posn(200, 1000), "RightButton");
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneThree.uncovered, false);
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoFour.uncovered, false);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourTwo.uncovered, false);
    t.checkExpect(fourFour.uncovered, false);
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
    t.checkExpect(fiveFive.uncovered, false);

    // click on middle button
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    mockGame.onMouseClicked(new Posn(25, 25), "MiddleButton");
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneThree.uncovered, false);
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoFour.uncovered, false);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourTwo.uncovered, false);
    t.checkExpect(fourFour.uncovered, false);
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
    t.checkExpect(fiveFive.uncovered, false);

    mockGame2.onMouseClicked(new Posn(25, 25), "LeftButton");
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneThree.uncovered, false);
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoFour.uncovered, false);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourTwo.uncovered, false);
    t.checkExpect(fourFour.uncovered, false);
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
    t.checkExpect(fiveFive.uncovered, false);
    mockGame2.onMouseClicked(new Posn(25, 25), "RightButton");
    t.checkExpect(oneOne.uncovered, false);
    t.checkExpect(oneThree.uncovered, false);
    t.checkExpect(oneFive.uncovered, false);
    t.checkExpect(twoTwo.uncovered, false);
    t.checkExpect(twoFour.uncovered, false);
    t.checkExpect(threeOne.uncovered, false);
    t.checkExpect(threeThree.uncovered, false);
    t.checkExpect(threeFive.uncovered, false);
    t.checkExpect(fourTwo.uncovered, false);
    t.checkExpect(fourFour.uncovered, false);
    t.checkExpect(fiveOne.uncovered, false);
    t.checkExpect(fiveThree.uncovered, false);
    t.checkExpect(fiveFive.uncovered, false);
  }

  void testWorldEnds(Tester t) {
    this.initData();
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    t.checkExpect(mockGame.gameEnded, false);
    t.checkExpect(mockGame.worldEnds(), new WorldEnd(false, mockGame.makeScene()));
    // did not flood all the cells
    oneFive.setUncovered(floodEffect.allCells());
    t.checkExpect(mockGame.worldEnds(), new WorldEnd(false, mockGame.makeScene()));
    fiveFive.setUncovered(floodEffect.allCells());
    t.checkExpect(mockGame.worldEnds(), new WorldEnd(false, mockGame.makeScene()));
    fourOne.flag();
    fiveOne.setUncovered(floodEffect.allCells());
    t.checkExpect(mockGame.worldEnds(), new WorldEnd(false, mockGame.makeScene()));
    oneOne.uncovered();
    oneTwo.uncovered();
    twoOne.uncovered();
    threeOne.uncovered();
    threeTwo.uncovered();
    threeThree.uncovered();
    threeFour.uncovered();
    fourThree.uncovered();
    // all cells uncovered, world ends
    t.checkExpect(mockGame.worldEnds(), new WorldEnd(true, mockGame.makeScene()));

    // click on a cell that is a mine, game ended since user lost
    this.initData();
    t.checkExpect(mockGame.worldEnds(), new WorldEnd(false, mockGame.makeScene()));
    floodEffect.linkAllHorizontalRows();
    floodEffect.linkAllDiagonalAndVertical();
    mockGame.onMouseClicked(new Posn(45, 45), "LeftButton");
    t.checkExpect(mockGame.worldEnds(), new WorldEnd(true, mockGame.makeScene()));
  }

  void testMakeScene(Tester t) {
    // initial condition all covered cells
    this.initData();
    drawGrid.linkAllDiagonalAndVertical();
    drawGrid.linkAllHorizontalRows();
    scene.placeImageXY(drawGrid.drawGrid(), CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2);
    scene.placeImageXY(new TextImage("cells left: 7", 3, Color.BLACK), CELL_SIZE * 3 / 2,
        CELL_SIZE * 3 + 50);
    t.checkExpect(mockGame3.makeScene(), scene);

    // flag a cell
    this.initData();
    drawGrid.linkAllDiagonalAndVertical();
    drawGrid.linkAllHorizontalRows();
    r2c1.flag();
    WorldImage secondRowChange = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), FLAGGED_CELL), COVERED_CELL),
        COVERED_CELL);
    WorldImage modifiedGrid2 = new AboveImage(
        new AboveImage(new AboveImage(new EmptyImage(), row1), secondRowChange), row3);
    scene.placeImageXY(modifiedGrid2, CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2);
    scene.placeImageXY(new TextImage("cells left: 7", 3, Color.BLACK), CELL_SIZE * 3 / 2,
        CELL_SIZE * 3 + 50);
    t.checkExpect(mockGame3.makeScene(), scene);
    // unflag a cell
    r2c1.flag();
    WorldScene sceneModified = new WorldScene(GAME_WIDTH, GAME_HEIGHT);
    sceneModified.placeImageXY(drawGrid.drawGrid(), CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2);
    sceneModified.placeImageXY(new TextImage("cells left: 7", 3, Color.BLACK), CELL_SIZE * 3 / 2,
        CELL_SIZE * 3 + 50);
    t.checkExpect(mockGame3.makeScene(), sceneModified);

    // flood a cell when there is a flagged cell nearby
    this.initData();
    drawGrid.linkAllDiagonalAndVertical();
    drawGrid.linkAllHorizontalRows();
    // flagged cell
    r2c1.flag();
    r3c1.setUncovered(drawGrid.allCells());
    WorldImage secondRowChange2 = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), FLAGGED_CELL),
            new OverlayImage(new TextImage("2", CELL_SIZE - 5, COLOR_LIST.get(1)), UNCOVERED_CELL)),
        COVERED_CELL);
    WorldImage thirdRowChange = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), UNCOVERED_CELL),
            new OverlayImage(new TextImage("1", CELL_SIZE - 5, COLOR_LIST.get(0)), UNCOVERED_CELL)),
        COVERED_CELL);
    WorldImage modifiedGrid3 = new AboveImage(
        new AboveImage(new AboveImage(new EmptyImage(), row1), secondRowChange2), thirdRowChange);
    scene.placeImageXY(modifiedGrid3, CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2);
    scene.placeImageXY(new TextImage("cells left: 4", 3, Color.BLACK), CELL_SIZE * 3 / 2,
        CELL_SIZE * 3 + 50);
    t.checkExpect(mockGame3.makeScene(), scene);

    // flood a cell normally with no flagged cell nearby
    this.initData();
    drawGrid.linkAllDiagonalAndVertical();
    drawGrid.linkAllHorizontalRows();
    r3c1.setUncovered(drawGrid.allCells());
    WorldImage secondRowChange3 = new BesideImage(
        new BesideImage(
            new BesideImage(new EmptyImage(),
                new OverlayImage(new TextImage("1", CELL_SIZE - 5, COLOR_LIST.get(0)),
                    UNCOVERED_CELL)),
            new OverlayImage(new TextImage("2", CELL_SIZE - 5, COLOR_LIST.get(1)), UNCOVERED_CELL)),
        COVERED_CELL);
    WorldImage modifiedGrid4 = new AboveImage(
        new AboveImage(new AboveImage(new EmptyImage(), row1), secondRowChange3), thirdRowChange);
    scene.placeImageXY(modifiedGrid4, CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2);
    scene.placeImageXY(new TextImage("cells left: 3", 3, Color.BLACK), CELL_SIZE * 3 / 2,
        CELL_SIZE * 3 + 50);
    t.checkExpect(mockGame3.makeScene(), scene);

    // click on cell that is a mine & lose
    this.initData();
    drawGrid.linkAllDiagonalAndVertical();
    drawGrid.linkAllHorizontalRows();
    mockGame3.onMouseClicked(new Posn(5, 5), "LeftButton");
    WorldImage firstRowChange = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), MINE_CELL), COVERED_CELL), COVERED_CELL);
    WorldImage secondRowModified = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), COVERED_CELL), COVERED_CELL), MINE_CELL);
    WorldImage thirdRow = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), COVERED_CELL), COVERED_CELL),
        COVERED_CELL);
    WorldImage modifiedGrid5 = new AboveImage(
        new AboveImage(new AboveImage(new EmptyImage(), firstRowChange), secondRowModified),
        thirdRow);
    scene.placeImageXY(modifiedGrid5, CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2);
    scene.placeImageXY(new TextImage("cells left: 7", 3, Color.BLACK), CELL_SIZE * 3 / 2,
        CELL_SIZE * 3 + 50);
    scene.placeImageXY(new RectangleImage(3 * CELL_SIZE * 5 / 6, 3 / 2 * CELL_SIZE,
        OutlineMode.SOLID, Color.WHITE), CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2);
    scene.placeImageXY(new TextImage("game over!", 3 * 4, Color.RED), CELL_SIZE * 3 / 2,
        CELL_SIZE * 3 / 2 - CELL_SIZE);
    scene.placeImageXY(new TextImage("click spacebar to restart game", 20, Color.BLACK),
        CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2 + (CELL_SIZE * 2));
    t.checkExpect(mockGame3.makeScene(), scene);

    // win when all cells are uncovered
    this.initData();
    drawGrid.linkAllDiagonalAndVertical();
    drawGrid.linkAllHorizontalRows();
    r1c2.uncovered();
    r1c3.uncovered();
    r2c1.uncovered();
    r2c2.uncovered();
    r3c1.uncovered();
    r3c2.uncovered();
    r3c3.uncovered();
    WorldImage firstRowChange2 = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), COVERED_CELL),
            new OverlayImage(new TextImage("2", CELL_SIZE - 5, COLOR_LIST.get(1)), UNCOVERED_CELL)),
        new OverlayImage(new TextImage("1", CELL_SIZE - 5, COLOR_LIST.get(0)), UNCOVERED_CELL));
    WorldImage secondRowModified2 = new BesideImage(
        new BesideImage(
            new BesideImage(new EmptyImage(),
                new OverlayImage(new TextImage("1", CELL_SIZE - 5, COLOR_LIST.get(0)),
                    UNCOVERED_CELL)),
            new OverlayImage(new TextImage("2", CELL_SIZE - 5, COLOR_LIST.get(1)), UNCOVERED_CELL)),
        COVERED_CELL);
    WorldImage thirdRow2 = new BesideImage(
        new BesideImage(new BesideImage(new EmptyImage(), UNCOVERED_CELL),
            new OverlayImage(new TextImage("1", CELL_SIZE - 5, COLOR_LIST.get(0)), UNCOVERED_CELL)),
        new OverlayImage(new TextImage("1", CELL_SIZE - 5, COLOR_LIST.get(0)), UNCOVERED_CELL));
    WorldImage modifiedGrid6 = new AboveImage(
        new AboveImage(new AboveImage(new EmptyImage(), firstRowChange2), secondRowModified2),
        thirdRow2);
    scene.placeImageXY(modifiedGrid6, CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2);
    scene.placeImageXY(new TextImage("cells left: 0", 3, Color.BLACK), CELL_SIZE * 3 / 2,
        CELL_SIZE * 3 + 50);
    scene.placeImageXY(
        new RectangleImage(3 * CELL_SIZE * 5 / 6, CELL_SIZE, OutlineMode.SOLID, Color.WHITE),
        CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2);
    scene.placeImageXY(new TextImage("you won!", 3 * 4, Color.GREEN), CELL_SIZE * 3 / 2,
        CELL_SIZE * 3 / 2 - CELL_SIZE);
    scene.placeImageXY(new TextImage("click spacebar to restart game", 20, Color.BLACK),
        CELL_SIZE * 3 / 2, CELL_SIZE * 3 / 2 + (CELL_SIZE * 2));
    t.checkExpect(mockGame3.makeScene(), scene);
  }
}