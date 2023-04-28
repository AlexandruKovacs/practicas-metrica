package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;
import calculator.Command;
import calculator.CommandManager;
import calculator.Invoker;

public class CommandTest {

    private Calculator calculator;
    private CommandManager commandManager;

    @Before
    public void setUp() {
        calculator = new Calculator(10);
        commandManager = new CommandManager(calculator);
    }

    @Test
    public void testSumar() {
    	Command sumarCommand = Invoker.getCommand(new String[] {"7", "sumar"}, calculator);
        commandManager.registCommand(sumarCommand);
        assertEquals(17, calculator.getValor());
    }

    @Test
    public void testRestar() {
    	Command restarCommand = Invoker.getCommand(new String[] {"3", "restar"}, calculator);
        commandManager.registCommand(restarCommand);
        assertEquals(7, calculator.getValor());
    }

    @Test
    public void testMultiplicarPor2() {
    	Command multiplicarPor2Command = Invoker.getCommand(new String[] {"2", "multiplicar"}, calculator);
        commandManager.registCommand(multiplicarPor2Command);
        assertEquals(20, calculator.getValor());
    }
    
    @Test
    public void testMultiplicarPor10() {
    	Command multiplicarPor10Command = Invoker.getCommand(new String[] {"10", "multiplicar"}, calculator);
        commandManager.registCommand(multiplicarPor10Command);
        assertEquals(100, calculator.getValor());
    }

    @Test
    public void testDividir() {
    	Command dividirCommand = Invoker.getCommand(new String[] {"5", "dividir"}, calculator);
        commandManager.registCommand(dividirCommand);
        assertEquals(2, calculator.getValor());
    }

    @Test
    public void testSet() {
    	Command setCommand = Invoker.getCommand(new String[] {"7", "set"}, calculator);
        commandManager.registCommand(setCommand);
        assertEquals(7, calculator.getValor());
    }
    
    @Test
    public void testUndoSumar() {
    	Command sumarCommand = Invoker.getCommand(new String[] {"5", "sumar"}, calculator);
        commandManager.registCommand(sumarCommand);
        assertEquals(15, calculator.getValor());
        
        commandManager.undoCommand(sumarCommand);
        assertEquals(10, calculator.getValor());
    }
    
    @Test
    public void testUndoSet() {
    	Command setCommandUndo = Invoker.getCommand(new String[] {"25", "set"}, calculator);
    	commandManager.registCommand(setCommandUndo);
    	assertEquals(25, calculator.getValor());
    	
    	commandManager.undoCommand(setCommandUndo);
    	assertEquals(10, calculator.getValor());
    }
    
    @Test
    public void testOverflow() {
    	Command overflowCommand = Invoker.getCommand(new String[] {String.valueOf(Integer.MAX_VALUE + 1), "multiplicar"}, calculator);
    	
        Throwable exceptionOverflow = assertThrows(NumberFormatException.class, () -> {
        	commandManager.registCommand(overflowCommand);
        });
        
        assertEquals("Overflow!", exceptionOverflow.getMessage());
    }
    
    @Test
    public void testDividirCero() {
    	Command zeroCommand = Invoker.getCommand(new String[] {"0", "dividir"}, calculator);
    	
        Throwable exceptionZero = assertThrows(ArithmeticException.class, () -> {
        	commandManager.registCommand(zeroCommand);
        });
        
        assertEquals("División por cero", exceptionZero.getMessage());
    }
    
    @Test
    public void testWrongCommand() {
    	
    	Throwable exceptionCommand = assertThrows(IllegalArgumentException.class, () -> {
    		Command wrongCommand = Invoker.getCommand(new String[] {"15", "example"}, calculator);
    		commandManager.registCommand(wrongCommand);
    	});
    	
    	assertEquals("Comando no reconocido: example", exceptionCommand.getMessage());
    }
    
    @Test
    public void testArgs() {
    	
    	Throwable exceptionArgs = assertThrows(IllegalArgumentException.class, () -> {
    		Command argsCommand = Invoker.getCommand(new String[] {"10"}, calculator);
    		commandManager.registCommand(argsCommand);
    	});
    	
    	assertEquals("Se debe proporcionar el valor y el comando", exceptionArgs.getMessage());
    }
    
    @Test
    public void manyActions() {
    	Command sumaCommand1 = Invoker.getCommand(new String[] {"25", "sumar"}, calculator);
    	commandManager.registCommand(sumaCommand1);
    	
    	Command sumaCommand2 = Invoker.getCommand(new String[] {"15", "sumar"}, calculator);
    	commandManager.registCommand(sumaCommand2);
    	
    	assertEquals(50, calculator.getValor());
    	
    	commandManager.undoCommand(sumaCommand2);
    	assertEquals(35, calculator.getValor());
    	
    	commandManager.undoCommand(sumaCommand1);
    	assertEquals(10, calculator.getValor());
    }
    
}

