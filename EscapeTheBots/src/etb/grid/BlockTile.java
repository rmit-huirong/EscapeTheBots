package etb.grid;

import etb.grid.Assets;
import etb.grid.Tile;

public class BlockTile extends Tile {

	public BlockTile(int id) {
		super(Assets.block, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}