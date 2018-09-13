
public class ParserTable {
	public static int getRule(String production, String lookahead) throws ParseErrorHandle{
		int i = 0;
		switch(production){
		case "<Trump>":
			if(lookahead.equalsIgnoreCase("Make"))
				return 1;
			else 
				throw new ParseErrorHandle("<Trump>", lookahead);
		
		case "<first>":
			if(lookahead.equalsIgnoreCase("Make"))
				return 2;
			else 
				throw new ParseErrorHandle("<first>", lookahead);
			
		case "<last>":
			if(lookahead.equalsIgnoreCase("America"))
				return 3;
			else 
				throw new ParseErrorHandle("<last>", lookahead);			
		
		case "<stmts>":
			if(lookahead.equalsIgnoreCase("make") || lookahead.equalsIgnoreCase("[id]") || lookahead.equalsIgnoreCase("if") || 
					lookahead.equalsIgnoreCase("as") || lookahead.equalsIgnoreCase("tell") || lookahead.equalsIgnoreCase("as"))
				return 4;
			else 
				throw new ParseErrorHandle("<stmts>", lookahead);
		
		case "<more-stmts>":
			if(lookahead.equalsIgnoreCase("make") || lookahead.equalsIgnoreCase("[id]") || lookahead.equalsIgnoreCase("if") || 
					lookahead.equalsIgnoreCase("as") || lookahead.equalsIgnoreCase("tell") || lookahead.equalsIgnoreCase("say"))
				return 5;
			else if(lookahead.equalsIgnoreCase("America") || lookahead.equalsIgnoreCase("!"))
				return 6;
			else 
				throw new ParseErrorHandle("<more-stmts>", lookahead);
			
		case "<stmt>":
			switch(lookahead){
			case "make":
				return 7;
			case "Make":
				return 7;
			case "[id]":
				return 8;
			case "if":
				return 9;
			case "If":
				return 9;
			case "as":
				return 10;
			case "As":
				return 10;
			case "tell":
				return 11;
			case "Tell":
				return 11;
			case "say":
				return 11;
			case "Say":
				return 11;
			 default:
				throw new ParseErrorHandle("<stmt>", lookahead);	
			}
			
		case "<decl>":
			if(lookahead.equalsIgnoreCase("make"))
				return 12;
			else 
				throw new ParseErrorHandle("<decl>", lookahead);
			
		case "<type>":
			if(lookahead.equalsIgnoreCase("number"))
				return 13;
			else if(lookahead.equalsIgnoreCase("boolean"))
				return 14;
			else 
				throw new ParseErrorHandle("<type>", lookahead);
			
		case "<asmt>":
			if(lookahead.equalsIgnoreCase("[id]"))
				return 15;
			else 
				throw new ParseErrorHandle("<asmt>", lookahead);
		
		case "<cond>":
			if(lookahead.equalsIgnoreCase("if"))
				return 16;
			else 
				throw new ParseErrorHandle("<cond>", lookahead);
			
		case "<loop>":
			if(lookahead.equalsIgnoreCase("as"))
				return 17;
			else 
				throw new ParseErrorHandle("<loop>", lookahead);
			
		case "<output>":
			if(lookahead.equalsIgnoreCase("tell"))
				return 18;
			else if(lookahead.equalsIgnoreCase("say"))
				return 19;
			else 
				throw new ParseErrorHandle("<output>", lookahead);
			
		case "<ids>":
			if(lookahead.equalsIgnoreCase("[id]"))
				return 20;
			else 
				throw new ParseErrorHandle("<ids>", lookahead);
			
		case "<more-ids>":
			if(lookahead.equalsIgnoreCase("[id]"))
				return 21;
			else if(lookahead.equalsIgnoreCase("number") || lookahead.equalsIgnoreCase("boolean") || lookahead.equalsIgnoreCase(";"))
				return 22;
			else 
				throw new ParseErrorHandle("<more-ids>", lookahead);
			
		case "<expr>":
			if(lookahead.equalsIgnoreCase("fact") || lookahead.equalsIgnoreCase("lie") || lookahead.equalsIgnoreCase("not") || 
					lookahead.equalsIgnoreCase("less") || lookahead.equalsIgnoreCase("is") || lookahead.equalsIgnoreCase("more"))
				return 23;
			else if(lookahead.equalsIgnoreCase("[id]") || lookahead.equalsIgnoreCase("[const]") || lookahead.equalsIgnoreCase("("))
				return 24;
			else 
				throw new ParseErrorHandle("<expr>", lookahead);
			
		case "<bool>":
			switch(lookahead){
			case "fact":
				return 25;
			case "lie":
				return 26;
			case "not":
				return 27;
			case "less":
				return 28;
			case "is":
				return 28;
			case "more":
				return 28;
			case"More":
				return 28;
			 default:
				throw new ParseErrorHandle("<bool>", lookahead);	
			}
			
		case "<bool-tail>":
			switch(lookahead){
			case "and":
				return 29;
			case "or":
				return 30;
			case ";":
				return 31;
			 default:
				throw new ParseErrorHandle("<bool-tail>", lookahead);	
			}
			
		case "<test>":
			switch(lookahead){
			case "less":
				return 32;
			case "is":
				return 33;
			case "more":
				return 34;
			 default:
				throw new ParseErrorHandle("<test>", lookahead);	
			}
			
		case "<arith>":
			switch(lookahead){
			case "[id]":
				return 35;
			case "[const]":
				return 36;
			case "(":
				return 37;
			 default:
				throw new ParseErrorHandle("<arith>", lookahead);	
			}
			
		case "<arith-tail>":
			switch(lookahead){
			case "plus":
				return 38;
			case "Plus":
				return 38;
			case "times":
				return 39;
			case "Times":
				return 39;
			case ";":
				return 40;
			case "[id]":
				return 40;
			case "[const]":
				return 40;
			case "(":
				return 40;
			case "?":
				return 40;
			case ")":
				return 40;
			 default:
				throw new ParseErrorHandle("<arith-tail>", lookahead);	
			}
			
		}
		return i;
	}
}
