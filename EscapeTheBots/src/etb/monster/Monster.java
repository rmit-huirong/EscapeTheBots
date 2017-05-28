// Huirong Huang - s3615907
package etb.monster;

import java.awt.Graphics;
import java.util.Random;

import etb.entity.Entity;
import etb.game.Game;
import etb.graphics.Level;
import etb.graphics.Spritesheet;

public class Monster extends Entity {

	private static final long serialVersionUID = 1L;

	private final int MAX_SPEED = 4;

	private Random randomNum;
	private int up = 0, down = 1, left = 2, right = 3;
	private int smart = 1, find_path = 2, find_another_path = 3;
	private int state = smart;
	private int dir = -1;
	private int lastDir = -1;
	private int time = 0;


	public void setLastDir(int lastDir) {
		this.lastDir = lastDir;
	}

	public int getLastDir() {
		return lastDir;
	}

	public Monster(int x, int y) {
		super(x,y);
	}

	public void tick() {
		setCurSpeed(MAX_SPEED/unit);
		Level level = Game.level;

			if (state == smart) {
			// follow the player

			boolean move = false;

			if (x < level.player.x) {
				if (canMove(x + curSpeed, y)) {
					x += curSpeed;
					move = true;
					lastDir = right;
				}
			}
			if (x > level.player.x) {
				if (canMove(x - curSpeed, y)) {
					x -= curSpeed;
					move = true;
					lastDir = left;
				}
			}
			if (!move && y < level.player.y) {
				if (canMove(x, y + curSpeed)) {
					y += curSpeed;
					move = true;
					lastDir = down;
				}
			}
			if (!move && y > level.player.y) {
				if (canMove(x, y - curSpeed)) {
					y -= curSpeed;
					move = true;
					lastDir = up;
				}
			}

			if (x == level.player.x && y == level.player.y)
				move = true;

			if (!move) {
				state = find_path;
			}
		} else if (state == find_path) {
			if (lastDir == right) {
				if (y < level.player.y) {
					if (canMove(x, y + curSpeed)) {
						y += curSpeed;
						state = smart;
					} else if (canMove(x + curSpeed, y)) {
						x += curSpeed;
					} else if (canMove(x - curSpeed, y)) {
						x -= curSpeed;
						lastDir = left;
						state = find_another_path;
					}
				} else {
					if (canMove(x, y - curSpeed)) {
						y -= curSpeed;
						state = smart;
					} else if (canMove(x + curSpeed, y)) {
						x += curSpeed;
					} else if (canMove(x - curSpeed, y)) {
						x -= curSpeed;
						lastDir = left;
						state = find_another_path;
					}
				}
			} else if (lastDir == left) {
				if (y < level.player.y) {
					if (canMove(x, y + curSpeed)) {
						y += curSpeed;
						state = smart;
					} else if (canMove(x - curSpeed, y)) {
						x -= curSpeed;
					} else if (canMove(x + curSpeed, y)) {
						x += curSpeed;
						lastDir = right;
						state = find_another_path;
					}
				} else {
					if (canMove(x, y - curSpeed)) {
						y -= curSpeed;
						state = smart;
					} else if (canMove(x - curSpeed, y)) {
						x -= curSpeed;
					} else if (canMove(x + curSpeed, y)) {
						x += curSpeed;
						lastDir = right;
						state = find_another_path;
					}
				}
			} else if (lastDir == up) {
				if (x < level.player.x) {
					if (canMove(x + curSpeed, y)) {
						x += curSpeed;
						state = smart;
					} else if (canMove(x, y - curSpeed)) {
						y -= curSpeed;
					} else if (canMove(x, y + curSpeed)) {
						y += curSpeed;
						lastDir = down;
						state = find_another_path;
					}
				} else {
					if (canMove(x - curSpeed, y)) {
						x -= curSpeed;
						state = smart;
					} else if (canMove(x, y - curSpeed)) {
						y -= curSpeed;
					} else if (canMove(x, y + curSpeed)) {
						y += curSpeed;
						lastDir = down;
						state = find_another_path;
					}
				}
			} else if (lastDir == down) {
				if (x < level.player.x) {
					if (canMove(x + curSpeed, y)) {
						x += curSpeed;
						state = smart;
					} else if (canMove(x, y + curSpeed)) {
						y += curSpeed;
					} else if (canMove(x, y - curSpeed)) {
						y -= curSpeed;
						lastDir = up;
						state = find_another_path;
					}
				} else {
					if (canMove(x - curSpeed, y)) {
						x -= curSpeed;
						state = smart;
					} else if (canMove(x, y + curSpeed)) {
						y += curSpeed;
					} else if (canMove(x, y - curSpeed)) {
						y -= curSpeed;
						lastDir = up;
						state = find_another_path;
					}
				}
			}
		} else if (state == find_another_path) {
			boolean movefirst = false;

			if (lastDir == right) {
				if (y < level.player.y) {
					if (canMove(x, y + curSpeed)) {
						y += curSpeed;
						state = find_path;
						movefirst = true;
					}
				} else {
					if (canMove(x, y - curSpeed)) {
						y -= curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				if (!movefirst) {
					x += curSpeed;
				}
			}
			if (lastDir == left) {
				if (y < level.player.y) {
					if (canMove(x, y + curSpeed)) {
						y += curSpeed;
						state = find_path;
						movefirst = true;
					}
				} else {
					if (canMove(x, y - curSpeed)) {
						y -= curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				if (!movefirst) {
					x -= curSpeed;
				}
			}
			if (lastDir == up) {
				if (x < level.player.x) {
					if (canMove(x + curSpeed, y)) {
						x += curSpeed;
						state = find_path;
						movefirst = true;
					}
				} else {
					if (canMove(x - curSpeed, y)) {
						x -= curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				if (!movefirst) {
					y -= curSpeed;
				}
			}
			if (lastDir == down) {
				if (x < level.player.x) {
					if (canMove(x + curSpeed, y)) {
						x += curSpeed;
						state = find_path;
						movefirst = true;
					}
				} else {
					if (canMove(x - curSpeed, y)) {
						x -= curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				if (!movefirst) {
					y += curSpeed;
				}
			}
		}
		poisonEntity(level);

		cureEntity();
	}

	public void render(Graphics g) {
		Spritesheet sheet = Game.spritesheet;
		g.drawImage(sheet.getSprite(0, 16), x, y, width, height, null);
	}

	public void setDirection(int dir) {
		this.dir = dir;
	}

}
