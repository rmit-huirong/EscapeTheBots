package etb.strategy;

import java.util.Random;

import etb.monster.Monster;
import etb.player.Player;

public class Strategy {
	private int up = 0, down = 1, left = 2, right = 3;
	private int state = 1, random = 0, smart = 1, find_path = 2;
	private int time = 0;
	Random randomNum = new Random();
	boolean move = false;

	public void chase_1(Player player, Monster monster, int speed) {
		if (state == smart) {
			if (monster.x < player.x) {
				if (monster.canMove(monster.x + speed, monster.y)) {
					monster.x += speed;
					move = true;
					monster.setLastDir(right);
				}
			}
			if (monster.x > player.x) {
				if (monster.canMove(monster.x - speed, monster.y)) {
					monster.x -= speed;
					move = true;
					monster.setLastDir(left);
				}
			}
			if (monster.y < player.y) {
				if (monster.canMove(monster.x, monster.y + speed)) {
					monster.y += speed;
					move = true;
					monster.setLastDir(down);
				}
			}
			if (monster.y > player.y) {
				if (monster.canMove(monster.x, monster.y - speed)) {
					monster.y -= speed;
					move = true;
					monster.setLastDir(up);
				}
			}
			if (monster.x == player.x && monster.y == player.y)
				move = true;
			if (!move) {
				state = find_path;

			}
			/*
			 * time++; if (time == 240) { state = random; time = 0; }
			 */
		} else if (state == find_path) {
			if (monster.getLastDir() == right) {
				if (monster.y < player.y) {
					if (monster.canMove(monster.x, monster.y + speed)) {
						monster.y += speed;
						state = smart;
					}
				} else {
					if (monster.canMove(monster.x, monster.y - speed)) {
						monster.y -= speed;
						state = smart;
					}
				}
				if (monster.canMove(monster.x + speed, monster.y)) {
					monster.x += speed;
				}
			} else if (monster.getLastDir() == left) {
				if (monster.y < player.y) {
					if (monster.canMove(monster.x, monster.y + speed)) {
						monster.y += speed;
						state = smart;
					}
				} else {
					if (monster.canMove(monster.x, monster.y - speed)) {
						monster.y -= speed;
						state = smart;
					}
				}
				if (monster.canMove(monster.x - speed, monster.y)) {
					monster.x -= speed;
				}
			} else if (monster.getLastDir() == up) {
				if (monster.x < player.x) {
					if (monster.canMove(monster.x + speed, monster.y)) {
						monster.x += speed;
						state = smart;
					}
				} else {
					if (monster.canMove(monster.x - speed, monster.y)) {
						monster.x -= speed;
						state = smart;
					}
				}
				if (monster.canMove(monster.x, monster.y - speed)) {
					monster.y -= speed;
				}
			} else if (monster.getLastDir() == down) {
				if (monster.x < player.x) {
					if (monster.canMove(monster.x + speed, monster.y)) {
						monster.x += speed;
						state = smart;
					}
				} else {
					if (monster.canMove(monster.x - speed, monster.y)) {
						monster.x -= speed;
						state = smart;
					}
				}
				if (monster.canMove(monster.x, monster.y + speed)) {
					monster.y += speed;
				}
			}
		}
	}
}
