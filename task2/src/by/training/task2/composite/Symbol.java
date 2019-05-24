package by.training.task2.composite;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Objects;

public class Symbol implements Component{
	
	private char symbol;
	
	public Symbol(char symbol){
		this.symbol = symbol;
	}

	@Override
	public String compose() {
		return String.valueOf(symbol);
	}

	@Override
	public int hashCode() {
		return Objects.hash(symbol);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Symbol)) return false;
		Symbol symbol1 = (Symbol) o;
		return symbol == symbol1.symbol;
	}
}
