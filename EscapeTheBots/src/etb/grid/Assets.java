package etb.grid;

import java.awt.image.BufferedImage;

import etb.display.ImageLoader;
import etb.display.SpriteSheet;

public class Assets {
	
	private static final int width = 32, height = 32;
	public static BufferedImage empty, block;

	public static void init(){
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/sprites/spritesheet1.png"));
		
		
		empty = sheet.crop(width * 2, 0, width, height);
		block = sheet.crop(width, 0, width, height);
		
	}
}
