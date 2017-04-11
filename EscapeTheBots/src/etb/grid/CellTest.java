package etb.grid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CellTest {
	
	Cell cell = new Cell(1, 1, 1, 1);
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testSetX()
	{
		assertEquals(1, cell.getX());
	}
	
	@Test
	public void testSetY()
	{
		assertEquals(1, cell.getY());
		
	}
	
	@Test
	public void testSetHeight()
	{
		assertEquals(1, cell.getHeight());
		
	}
	
	@Test
	public void testSetWidth()
	{
		assertEquals(1, cell.getWidth());
	}
	

}
