package etb.grid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import etb.grid.Tile1;
import etb.player.Player;

public class GridTest0 {
	
	boolean ans = false;
	boolean sol = true;
	boolean result;
	
	Grid[][] grid = new Grid[10][10];
	Player[][] player1 = new Player[10][10];
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test 
	//Test that the empty tile is not solid 
	public void testnotSolid(){
		Tile1 emptyTile = new EmptyTile(0);
		result = emptyTile.isSolid();
		assertEquals(result, ans);
		
	}
	
	@Test
	//Test that the block tile is solid
	public void testSolid(){
		Tile1 blockTile = new BlockTile(1);
		result = blockTile.isSolid();
		assertEquals(result, sol);
		
	}
	
	@Test
	//Test that the player on the grid
	public void testTile(){
		
	
		
		assertArrayEquals(player1[1][1], grid[1][1]);
		
		
	}
	
	
	private void assertArrayEquals(Player player, Grid grid2) {
		// TODO Auto-generated method stub
		
	}

}
