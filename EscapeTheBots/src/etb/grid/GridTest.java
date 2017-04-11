package etb.grid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import etb.monster.Monster;

public class GridTest {
	
	Grid[][] grid = new Grid[20][20];
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGrid(){
		
		assertEquals(20, grid.length);
	}
	
	@Test
	public void testGrid1(){
		
		assertArrayEquals(grid[19][19], grid[19][19]);
		assertEquals(20, grid.length);
		for (int i = 0; i < grid.length; i++)
		    assertEquals("the position is equal at " + i, grid[4][2], grid[19][19]);
	}

	private void assertArrayEquals(Grid grid2, Grid grid3) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

	
	
	
}
