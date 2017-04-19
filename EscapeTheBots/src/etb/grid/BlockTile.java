package etb.grid;

public class BlockTile extends Tile1 {
	
	public BlockTile(int id){
		
		super(Assets.block, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
