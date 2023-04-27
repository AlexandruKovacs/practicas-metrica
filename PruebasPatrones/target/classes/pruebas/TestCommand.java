package tests;

import calculator.*;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCommand {

	private Calculator calculator;
	private CommandManager commandManager;
	private static final double DELTA = 1e-15;
	
	@BeforeEach
	public void setup() {
		calculator = new Calculator();
		commandManager = new CommandManager();
		commandManager.registerCommand("add", new AddCommand(calculator, 5));
		commandManager.registerCommand("substract", new SubstractCommand(calculator, 3));
	}
	
	@Test
	public void testAddCommand() {
		assertEquals(5.0, calculator.getAccumulator(), DELTA);
		commandManager.getCommand(null, 0).execute(calculator);
		assertEquals(10.0, calculator.getAccumulator(), DELTA);
	}
	
	@Test
	public void testSubstractCommand() {
		assertEquals(5.0, calculator.getAccumulator(), DELTA);
		commandManager.getCommand(null, 1).execute(calculator);
		assertEquals(2.0, calculator.getAccumulator(), DELTA);
	}
	
	@Test
	public void testUndoCommand() {
        assertEquals(5.0, calculator.getAccumulator(), DELTA);
        commandManager.getCommand(null, 0).execute(calculator);
        commandManager.getCommand(null, 1).execute(calculator);
        assertEquals(2.0, calculator.getAccumulator(), DELTA);
        commandManager.undoLastCommand();
        assertEquals(10.0, calculator.getAccumulator(), DELTA);
        commandManager.undoLastCommand();
        assertEquals(5.0, calculator.getAccumulator(), DELTA);
	}
}