package by.training.task2.composite;

public class Symbol implements Component{
	
	private char symbol;
	
	public Symbol(char symbol){
		this.symbol = symbol;
	}

	@Override
	public String compose() {
		return "" + symbol;
	}	
}
