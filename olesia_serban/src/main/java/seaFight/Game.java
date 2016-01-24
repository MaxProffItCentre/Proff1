package seaFight;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	private int[][] table = new int[10][10];
	private List<Ship> shipList = new ArrayList<>();
	private Ship s1 = new Ship();
	private Ship s2 = new Ship();
	private Ship s3 = new Ship();
	private Ship s4 = new Ship();
	private Ship2 sh1 = new Ship2();
	private Ship2 sh2 = new Ship2();
	private Ship2 sh3 = new Ship2();
	private Ship3 shi1 = new Ship3();
	private Ship3 shi2 = new Ship3();
	private Ship4 ship1 = new Ship4();

	public Game() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				this.table[x][y] = 0;
			}
		}
		this.shipList.add(this.s1);
		this.shipList.add(this.s2);
		this.shipList.add(this.s3);
		this.shipList.add(this.s4);
		this.shipList.add(this.sh1);
		this.shipList.add(this.sh2);
		this.shipList.add(this.sh3);
		this.shipList.add(this.shi1);
		this.shipList.add(this.shi2);
		this.shipList.add(this.ship1);

	}

	private boolean checkShip(Ship sh) {
		giveShipParametrs(sh);
		// code for universal ship
		// orientation horizontal
		if (sh.getOrientation() == 0) {
			// if 0 0
			if (sh.getX() == 0 && sh.getY() == 0) {
				for (int x = 0; x < 2; x++) {
					for (int y = 0; y < sh.getShipSize() + 1; y++) {

						if (table[x][y] == 2) {

							return false;
						}
					}
				}
				// fill with 1
				for (int x = 0; x < 2; x++) {
					for (int y = 0; y < sh.getShipSize() + 1; y++) {
						table[x][y] = 1;
					}
				}

				// fill with 2
				for (int y = 0; y < sh.getShipSize(); y++) {
					table[0][y] = 2;
				}

				return true;

			}
			// if 9 0
			else if (sh.getX() == 9 && sh.getY() == 0) {
				for (int x = 9; x > 7; x--) {
					for (int y = 0; y < sh.getShipSize() + 1; y++) {
						if (table[x][y] == 2) {
							return false;
						}
					}
				}
				// fill with 1
				for (int x = 9; x > 7; x--) {
					for (int y = 0; y < sh.getShipSize() + 1; y++) {
						table[x][y] = 1;
					}
				}

				// fill with 2
				for (int y = 0; y < sh.getShipSize(); y++) {
					table[9][y] = 2;
				}

				return true;

			}
			// if 0 9
			else if (sh.getX() == 0 && sh.getY() == 9) {
				for (int x = 0; x < 2; x++) {
					for (int y = 9; y >= 9 - sh.getShipSize(); y--) {
						if (table[x][y] == 2) {

							return false;
						}
					}
				}
				// fill with 1
				for (int x = 0; x < 2; x++) {
					for (int y = 9; y >= 9 - sh.getShipSize(); y--) {
						table[x][y] = 1;
					}
				}
				// fill with 2
				for (int y = 9; y > 9 - sh.getShipSize(); y--) {
					table[0][y] = 2;
				}

				return true;
			}
			// if 9 9
			else if (sh.getX() == 9 && sh.getY() == 9) {
				for (int x = 9; x > 7; x--) {
					for (int y = 9; y >= 9 - sh.getShipSize(); y--) {
						if (table[x][y] == 2) {

							return false;
						}
					}
				}
				// fill with 1
				for (int x = 9; x > 7; x--) {
					for (int y = 9; y >= 9 - sh.getShipSize(); y--) {
						table[x][y] = 1;
					}
				}
				// fill with 2
				for (int y = 9; y > 9 - sh.getShipSize(); y--) {
					table[9][y] = 2;
				}
				return true;
			}
			// if x 0 debug +
			else if (sh.getX() != 0 && sh.getX() != 9 && sh.getY() == 0) {
				// just code
				// x-1 <= x+1
				// 0 <= 0 + size
				for (int x = sh.getX() - 1; x <= sh.getX() + 1; x++) {
					for (int y = 0; y <= sh.getShipSize(); y++) {
						if (table[x][y] == 2) {

							return false;
						}
					}
				}
				// fill with 1
				for (int x = sh.getX() - 1; x <= sh.getX() + 1; x++) {
					for (int y = 0; y <= sh.getShipSize(); y++) {
						table[x][y] = 1;
					}
				}
				// fill with 2
				for (int y = 0; y < sh.getShipSize(); y++) {
					table[sh.getX()][y] = 2;
				}
				return true;
			}
			// if 0 y
			else if (sh.getX() == 0 && sh.getY() != 0 && sh.getY() != 9) {
				// size/2
				if (sh.getY() < 5) { // debug +
					// 0 < 2
					// y-1 <= y+ size
					for (int x = 0; x < 2; x++) {
						for (int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill with 1
					for (int x = 0; x < 2; x++) {
						for (int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++) {
							table[x][y] = 1;
						}
					}
					// fill with 2
					for (int y = sh.getY(); y < sh.getY() + sh.getShipSize(); y++) {
						table[0][y] = 2;
					}
					return true;

				} else {
					// 0<2
					// y+1 >= y-size
					for (int x = 0; x < 2; x++) {
						for (int y = sh.getY() + 1; y >= sh.getY() - sh.getShipSize(); y--) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill with 1
					for (int x = 0; x < 2; x++) {
						for (int y = sh.getY() + 1; y >= sh.getY() - sh.getShipSize(); y--) {
							table[x][y] = 1;
						}
					}
					// fill with 2
					for (int y = sh.getY(); y > sh.getY() - sh.getShipSize(); y--) {
						table[0][y] = 2;
					}
					return true;

				}
			}
			// if 9 y
			else if (sh.getX() == 9 && sh.getY() != 0 && sh.getY() != 9) {
				// size/2
				if (sh.getY() < 5) {
					for (int x = 9; x > 7; x--) {
						for (int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill with 1
					for (int x = 9; x > 7; x--) {
						for (int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++) {
							table[x][y] = 1;
						}
					}
					// fill with 2
					for (int y = sh.getY(); y < sh.getY() + sh.getShipSize(); y++) {
						table[9][y] = 2;
					}
					return true;

				} else {
					for (int x = 9; x > 7; x--) {
						for (int y = sh.getY() + 1; y >= sh.getY() - sh.getShipSize(); y--) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill with 1
					for (int x = 9; x > 7; x--) {
						for (int y = sh.getY() + 1; y >= sh.getY() - sh.getShipSize(); y--) {
							table[x][y] = 1;
						}
					}
					// fill with 2
					for (int y = sh.getY(); y > sh.getY() - sh.getShipSize(); y--) {
						table[9][y] = 2;
					}
					return true;
				}

			}
			// if x 9
			else if (sh.getX() != 0 && sh.getX() != 9 && sh.getY() == 9) {
				// just code
				// x-1 <= x+1
				// 9 >= 9 - size
				for (int x = sh.getX() - 1; x <= sh.getX() + 1; x++) {
					for (int y = 9; y >= 9 - sh.getShipSize(); y--) {
						if (table[x][y] == 2) {

							return false;
						}
					}
				}
				// fill with 1
				for (int x = sh.getX() - 1; x <= sh.getX() + 1; x++) {
					for (int y = 9; y >= 9 - sh.getShipSize(); y--) {
						table[x][y] = 1;
					}
				}

				// fill with 2
				for (int y = 9; y > 9 - sh.getShipSize(); y--) {
					table[sh.getX()][y] = 2;
				}
				return true;
			}
			// if x y
			else {
				// size/2
				if (sh.getY() < 5) {
					// x-1 <= x+1
					// y-1 <= y+size
					for (int x = sh.getX() - 1; x <= sh.getX() + 1; x++) {
						for (int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill with 1
					for (int x = sh.getX() - 1; x <= sh.getX() + 1; x++) {
						for (int y = sh.getY() - 1; y <= sh.getY() + sh.getShipSize(); y++) {
							table[x][y] = 1;
						}
					}
					// fill with 2
					for (int y = sh.getY(); y < sh.getY() + sh.getShipSize(); y++) {
						table[sh.getX()][y] = 2;
					}
					return true;
				} else {
					// x-1 <= x+1
					// y+1 >= y - size
					for (int x = sh.getX() - 1; x <= sh.getX() + 1; x++) {
						for (int y = sh.getY() + 1; y >= sh.getY() - sh.getShipSize(); y--) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill 1
					for (int x = sh.getX() - 1; x <= sh.getX() + 1; x++) {

						for (int y = sh.getY() + 1; y >= sh.getY() - sh.getShipSize(); y--) {
							table[x][y] = 1;
						}
					}
					// fill 2
					for (int y = sh.getY(); y > sh.getY() - sh.getShipSize(); y--) {
						table[sh.getX()][y] = 2;
					}
					return true;

				}
			}

		}
		// orientation vertical
		else if (sh.getOrientation() == 1) {
			// if 0 0
			if (sh.getX() == 0 && sh.getY() == 0) {
				for (int x = 0; x <= sh.getShipSize(); x++) {
					for (int y = 0; y < 2; y++) {
						if (table[x][y] == 2) {

							return false;
						}
					}
				}
				// fill 1
				for (int x = 0; x <= sh.getShipSize(); x++) {
					for (int y = 0; y < 2; y++) {
						table[x][y] = 1;
					}
				}
				// fill 2
				for (int x = 0; x < sh.getShipSize(); x++) {
					table[x][0] = 2;
				}
				return true;
			}
			// if 9 0
			else if (sh.getX() == 9 && sh.getY() == 0) {
				for (int x = 9; x >= 9 - sh.getShipSize(); x--) {
					for (int y = 0; y < 2; y++) {
						if (table[x][y] == 2) {

							return false;
						}
					}
				}
				// fill1
				for (int x = 9; x >= 9 - sh.getShipSize(); x--) {
					for (int y = 0; y < 2; y++) {
						table[x][y] = 1;
					}
				}
				// fill2
				for (int x = 9; x > 9 - sh.getShipSize(); x--) {
					table[x][0] = 2;
				}
				return true;
			}
			// if 0 9
			else if (sh.getX() == 0 && sh.getY() == 9) {
				for (int x = 0; x <= sh.getShipSize(); x++) {
					for (int y = 9; y > 7; y--) {
						if (table[x][y] == 2) {

							return false;
						}
					}
				}
				// fill 1
				for (int x = 0; x <= sh.getShipSize(); x++) {
					for (int y = 9; y > 7; y--) {
						table[x][y] = 1;
					}
				}
				// fill 2
				for (int x = 0; x < sh.getShipSize(); x++) {
					table[x][9] = 2;
				}
				return true;
			}
			// if 9 9
			else if (sh.getX() == 9 && sh.getY() == 9) {
				for (int x = 9; x >= 9 - sh.getShipSize(); x--) {
					for (int y = 9; y > 7; y--) {
						if (table[x][y] == 2) {

							return false;
						}
					}
				}
				// fill1
				for (int x = 9; x >= 9 - sh.getShipSize(); x--) {
					for (int y = 9; y > 7; y--) {
						table[x][y] = 1;
					}
				}
				// fill2
				for (int x = 9; x > 9 - sh.getShipSize(); x--) {
					table[x][9] = 2;
				}
				return true;
			}
			// if x 0
			else if (sh.getX() != 0 && sh.getX() != 9 && sh.getY() == 0) {
				// X size/2
				if (sh.getX() < 5) {
					for (int x = sh.getX() - 1; x <= sh.getX() + sh.getShipSize(); x++) {
						for (int y = 0; y < 2; y++) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill 1
					for (int x = sh.getX() - 1; x <= sh.getX() + sh.getShipSize(); x++) {
						for (int y = 0; y < 2; y++) {
							table[x][y] = 1;
						}
					}
					// fill 2
					for (int x = sh.getX(); x < sh.getX() + sh.getShipSize(); x++) {
						table[x][sh.getY()] = 2;
					}
					return true;
				} else {
					for (int x = sh.getX() + 1; x >= sh.getX() - sh.getShipSize(); x--) {
						for (int y = 0; y < 2; y++) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill 1
					for (int x = sh.getX() + 1; x >= sh.getX() - sh.getShipSize(); x--) {
						for (int y = 0; y < 2; y++) {
							table[x][y] = 1;
						}
					}
					// fill 2
					for (int x = sh.getX(); x > sh.getX() - sh.getShipSize(); x--) {
						table[x][sh.getY()] = 2;
					}
					return true;

				}
			}
			// if 0 y
			else if (sh.getX() == 0 && sh.getY() != 0 && sh.getY() != 9) {
				// just code
				for (int x = 0; x <= sh.getShipSize(); x++) {
					for (int y = sh.getY() - 1; y <= sh.getY() + 1; y++) {
						if (table[x][y] == 2) {

							return false;
						}
					}
				}
				// fill 1
				for (int x = 0; x <= sh.getShipSize(); x++) {
					for (int y = sh.getY() - 1; y <= sh.getY() + 1; y++) {
						table[x][y] = 1;
					}
				}
				// fill 2
				for (int x = 0; x < sh.getShipSize(); x++) {
					table[x][sh.getY()] = 2;
				}
				return true;
			}
			// if 9 y
			else if (sh.getX() == 9 && sh.getY() != 0 && sh.getY() != 9) {
				// just code
				for (int x = 9; x >= 9 - sh.getShipSize(); x--) {
					for (int y = sh.getY() - 1; y <= sh.getY() + 1; y++) {
						if (table[x][y] == 2) {

							return false;
						}
					}
				}
				// fill 1
				for (int x = 9; x >= 9 - sh.getShipSize(); x--) {
					for (int y = sh.getY() - 1; y <= sh.getY() + 1; y++) {
						table[x][y] = 1;
					}
				}
				// fill 2
				for (int x = 9; x > 9 - sh.getShipSize(); x--) {
					table[x][sh.getY()] = 2;
				}
				return true;
			}
			// if x 9
			else if (sh.getX() != 0 && sh.getX() != 9 && sh.getY() == 9) {
				// X size/2
				if (sh.getX() < 5) {
					for (int x = sh.getX() - 1; x <= sh.getX() + sh.getShipSize(); x++) {
						for (int y = 9; y > 7; y--) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill 1
					for (int x = sh.getX() - 1; x <= sh.getX() + sh.getShipSize(); x++) {
						for (int y = 9; y > 7; y--) {
							table[x][y] = 1;
						}
					}
					// fill 2
					for (int x = sh.getX(); x < sh.getX() + sh.getShipSize(); x++) {
						table[x][sh.getY()] = 2;
					}
					return true;
				} else {
					for (int x = sh.getX() + 1; x >= sh.getX() - sh.getShipSize(); x--) {
						for (int y = 9; y > 7; y--) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill 1
					for (int x = sh.getX() + 1; x >= sh.getX() - sh.getShipSize(); x--) {
						for (int y = 9; y > 7; y--) {
							table[x][y] = 1;
						}
					}
					// fill 2
					for (int x = sh.getX(); x > sh.getX() - sh.getShipSize(); x--) {
						table[x][sh.getY()] = 2;
					}
					return true;

				}
			}
			// if x y
			else {
				if (sh.getX() < 5) {
					for (int x = sh.getX() - 1; x <= sh.getX() + sh.getShipSize(); x++) {
						for (int y = sh.getY() - 1; y <= sh.getY() + 1; y++) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill 1
					for (int x = sh.getX() - 1; x <= sh.getX() + sh.getShipSize(); x++) {
						for (int y = sh.getY() - 1; y <= sh.getY() + 1; y++) {
							table[x][y] = 1;
						}
					}
					// fill 2
					for (int x = sh.getX(); x < sh.getX() + sh.getShipSize(); x++) {
						table[x][sh.getY()] = 2;
					}
					return true;
				} else {
					for (int x = sh.getX() + 1; x >= sh.getX() - sh.getShipSize(); x--) {
						for (int y = sh.getY() - 1; y <= sh.getY() + 1; y++) {
							if (table[x][y] == 2) {

								return false;
							}
						}
					}
					// fill 1
					for (int x = sh.getX() + 1; x >= sh.getX() - sh.getShipSize(); x--) {
						for (int y = sh.getY() - 1; y <= sh.getY() + 1; y++) {
							table[x][y] = 1;
						}
					}
					// fill 2
					for (int x = sh.getX(); x > sh.getX() - sh.getShipSize(); x--) {
						table[x][sh.getY()] = 2;
					}
					return true;
				}
			}

		}
		return true;
	}

	private void giveShipParametrs(Ship sh) {

		int rndX = (int) (Math.random() * 10);
		int rndY = (int) (Math.random() * 10);
		int rndOrient = (int) Math.round(Math.random());
		sh.setX(rndX);
		sh.setY(rndY);
		sh.setOrientation(rndOrient);
		

	}

	private boolean fillTable() {

		for (Ship ship : shipList) {

			boolean valid = false;
			while (!valid) {
				valid = checkShip(ship);
			}
		}
		return true;
	}

	public int[][] getTable() {
		return table;
	}

	

	private String HTMLTable() {
		StringBuilder sb = new StringBuilder("<table> \r\n");
		sb.append("<tbody> \r\n");

		for (int x = 0; x < 10; x++) {
			sb.append("<tr> \r\n");
			for (int y = 0; y < 10; y++) {
				if (table[x][y] == 0) {
					sb.append("<td></td> \r\n");
				} else if (table[x][y] == 1) {
					sb.append("<td class = \"zone\"></td> \r\n");

				} else if (table[x][y] == 2) {
					sb.append("<td class = \"ship\"></td> \r\n");
				}
			}
			sb.append("</tr> \r\n");
		}
		sb.append("</tbody> \r\n");
		sb.append("</table> \r\n");
		return sb.toString();
	}

	private String HTMLFile() {
		StringBuilder sb = new StringBuilder(
				"<!DOCTYPE html> \r\n <html>  \r\n   <head> \r\n <meta charset=\"UTF-8\"> \r\n <link type=\"text/css\" rel=\"stylesheet\" href=\"style.css\"/>    \r\n    <title>Sea Battle</title> \r\n    </head> \r\n    <body> \r\n");
		sb.append(HTMLTable());
		sb.append("</body> \r\n </html> \r\n");

		return sb.toString();
	}

	public void gameInit() throws IOException {
		System.out.println("game started...");
		boolean valid = fillTable();
		System.out.println("table filled...");
		String gameHTML = "";
		if (valid) {
			gameHTML = HTMLFile();
			System.out.println("created HTML string for game...");
		} else {
			System.out.println("table was not filled =(");
		}
		System.out.println("writing into file...");
		boolean written = createHTMLfile(gameHTML,
				"C:/java/repo/Proff1/olesia_serban/src/main/java/seaFight/index.html");
		if (written) {
			System.out.println("fille opening...");
			File htmlFile = new File("C:/java/repo/Proff1/olesia_serban/src/main/java/seaFight/index.html");
			Desktop.getDesktop().browse(htmlFile.toURI());
			System.out.println("file opened! Wish you to win!");
		}

	}

	private boolean createHTMLfile(String content, String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	
}
