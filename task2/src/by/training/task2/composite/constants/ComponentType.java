package by.training.task2.composite.constants;

import by.training.task2.composite.*;

public enum ComponentType {
	TEXT(Text.class.getSimpleName()),
	PARAGRAPH(Paragraph.class.getSimpleName()),
	SEQUENCE(Sequence.class.getSimpleName()), 
	LEXEME(Lexeme.class.getSimpleName()),
	LEXEME_PART(LexemePart.class.getSimpleName()),
	SYMBOL(Symbol.class.getSimpleName());
	
	private String className;
	
	ComponentType(String name){
		this.className = name;
	}
	
	public String getClassName(){
		return this.className;
	}

}
