import java.util.Vector;

public final class Rule {
	private final static String productions[] = {"", "<Trump>", "<first>", "<last>", "<stmts>", 
			"<more-stmts>", "<more-stmts>", "<stmt>", "<stmt>", "<stmt>", "<stmt>", "<stmt>",
			"<decl>", "<type>", "<type>", "<asmt>", "<cond>", "<loop>", "<output>", "<output>",
			"<ids>", "<more-ids>", "<more-ids>", "<expr>"};
	
	
	public static Vector<String> getProduce(int i) {
		Vector<String> p = new Vector<>();
		switch(i){ //i is rules number
			case 1:
				p.add("<first>");
				p.add("<stmts>");
				p.add("<last>");
				return p;
				
			case 2:
				p.add("Make");
				p.add("programming");
				p.add("great");
				p.add("again");
				return p;

				
			case 3:
				p.add("America");
				p.add("is");
				p.add("great");
				return p;

				
			case 4:
				p.add("<stmt>");
				p.add(";");
				p.add("<more-stmts>");
				return p;

				
			case 5:
				p.add("<stmt>");
				p.add(";");
				p.add("<more-stmts>");
				return p;

				
			case 6:
				return p;

			case 7:
				p.add("<decl>");
				return p;

			case 8:
				p.add("<asmt>");
				return p;

			case 9:
				p.add("<cond>");
				return p;

			case 10:
				p.add("<loop>");
				return p;

			case 11:
				p.add("<output>");
				return p;

			case 12:
				p.add("make");
				p.add("<ids>");
				p.add("<type>");
				return p;

			case 13:
				p.add("number");
				return p;

			case 14:
				p.add("boolean");
				return p;

			case 15:
				p.add("[id]");
				p.add("is");
				p.add("<expr>");
				return p;

			case 16:
				p.add("if");
				p.add(",");
				p.add("<bool>");
				p.add(";");
				p.add(":");
				p.add("<stmts>");
				p.add("!");
				p.add("else");
				p.add(":");
				p.add("<stmts>");
				p.add("!");
				return p;

			case 17:
				p.add("as");
				p.add("long");
				p.add("as");
				p.add(",");
				p.add("<bool>");
				p.add(";");
				p.add(":");
				p.add("<stmts>");
				p.add("!");
				return p;

			case 18:
				p.add("tell");
				p.add("<ids>");
				return p;

			case 19:
				p.add("say");
				p.add("[string]");
				return p;

			case 20:
				p.add("[id]");
				p.add("<more-ids>");
				return p;

			case 21:
				p.add("[id]");
				p.add("<more-ids>");
				return p;

			case 22:
				return p;

			case 23:
				p.add("<bool>");
				return p;

			case 24:
				p.add("<arith>");
				return p;

			case 25:
				p.add("fact");
				p.add("<bool-tail>");
				return p;

			case 26:
				p.add("lie");
				p.add("<bool-tail>");
				return p;

			case 27:
				p.add("not");
				p.add("<bool>");
				return p;

			case 28:
				p.add("<test>");
				p.add("<arith>");
				p.add("<arith>");
				p.add("?");
				return p;

			case 29:
				p.add("and");
				p.add("<bool>");
				return p;

			case 30:
				p.add("or");
				p.add("<bool>");
				return p;

			case 31:
				return p;

			case 32:
				p.add("less");
				return p;

			case 33:
				p.add("is");
				return p;

			case 34:
				p.add("more");
				return p;

			case 35:
				p.add("[id]");
				p.add("<arith-tail>");
				return p;

			case 36:
				p.add("[const]");
				p.add("<arith-tail>");
				return p;

			case 37:
				p.add("(");
				p.add("<arith>");
				p.add(")");
				p.add("<arith-tail>");
				return p;

			case 38:
				p.add("plus");
				p.add("<arith>");
				return p;

			case 39:
				p.add("times");
				p.add("<arith>");
				return p;

			case 40:
				return p;
						
			default:
				return p;

		}
		
		
	}
	
	public static String getProduction(int i){
		return productions[i];
	}

}	
