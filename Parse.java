import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;

public class Parse {
	
	static final String[] SYMBOL = {"Z0","[id]","[const]", "[string]", "make", "programming", "great",       //6
			"again", "america", "is", "number", "boolean", "if", "as", "long", "tell", "else", "say",        //17
			"fact", "lie", "not", "and", "or", "less", "more", "plus", "times", ",", ";", ":", "!",          //30
			"?", "(", ")", "<Trump>", "<first>", "<last>", "<stmts>", "<more-stmts>", "<stmt>","<decl>",     //40
			"<type>", "<asmt>", "<cond>", "<loop>", "<output>", "<ids>", "<more-ids>", "<expr>", "<bool>", 	 //49
			"<bool-tail>", "<test>", "<arith>", "<arith-tail>"};  											 //53 
	
	private Scanner scan;
	private Stack<Integer> stack;
	
	public Parse(BufferedReader read, BufferedWriter bw) throws IOException{
		String line;
		Vector<Token> in = new Vector<>();;
		stack = new Stack<>();
		scan = new Scanner();
		
		 File outputFile = new File("output.txt");
         if (!outputFile.exists())
             outputFile.createNewFile();
         
         bw.write(String.format("%-15s %-25s %-25s %-25s", "Step", "Stack-top", "LOOKAHEAD", "ACTION"));
         bw.newLine();
         
         bw.write(String.format("%-15s %-25s %-25s %-25s", "0", "Z0(0)", "--------", "Push<Trump>"));
         bw.newLine();

		stack.push(0);
		stack.push(getIndex("<Trump>"));
		
		
		while ((line = read.readLine()) != null) {

            if(line.charAt(0) == '#')
            	continue;
			Token input = new Token(line);
			Token out;				
            
			while(input.hasNext()){
	            out = scan.scan(input);
	            if(input.ifSkip()){
	            	break;
	            }
	            if(out != null){
	            	in.add(out);
	            	System.out.println(out);
	            }
	        }
		}
		
		//parsing now.
		try{
			int i = 0;
			int steps = 1;
			while(i < in.size()){
				int top = (int) stack.pop();
				String intoken;
				
				if(in.get(i).getState() == FinalState.string)
					intoken = "[string]";
				else if(in.get(i).getState() == FinalState.id)
					intoken = "[id]";
				else if(in.get(i).getState() == FinalState.constant)
					intoken = "[const]";
				else 
					intoken = in.get(i).getValue();
				
				if(SYMBOL[top].charAt(0) != '<' && intoken.equalsIgnoreCase(SYMBOL[top])){
					
					String lookahead;
					if(in.get(i).getState() == FinalState.string)
						lookahead = "[string]";
					else if(in.get(i).getState() == FinalState.id)
						lookahead = "[id]";
					else if(in.get(i).getState() == FinalState.constant)
						lookahead = "[const]";
					else 
						lookahead = in.get(i).getValue();
					
			         bw.write(String.format("%-15s %-25s %-25s %-25s", Integer.toString(steps), 
			        		 SYMBOL[top] + "(" + Integer.toString(top) + ")", 
			        		 lookahead + "(" + Integer.toString(getIndex(lookahead)) + ")" , 
			        		 "Match(Pop&consume input token)"));


					bw.newLine();
					steps++;
					i++;
					continue;
				}
				
				String lookahead;
				if(in.get(i).getState() == FinalState.string)
					lookahead = "[string]";
				else if(in.get(i).getState() == FinalState.id)
					lookahead = "[id]";
				else if(in.get(i).getState() == FinalState.constant)
					lookahead = "[const]";
				else 
					lookahead = in.get(i).getValue();
					
				int rule = ParserTable.getRule(SYMBOL[top], lookahead);
				Vector<String> produces = Rule.getProduce(rule);
				for(int k = produces.size() - 1; k >= 0; k-- ){
					stack.push(getIndex(produces.get(k)));
				}
				
				
		         bw.write(String.format("%-15s %-25s %-25s %-25s", Integer.toString(steps), 
		        		 SYMBOL[top] + "(" + Integer.toString(top) + ")", 
		        		 lookahead + "(" + Integer.toString(getIndex(lookahead)) + ")" , 
		        		 "Use Rule(" + Integer.toString(rule) + ")"));

				bw.newLine();
				steps++;
			}
		}catch(ParseErrorHandle e){
			e.print();
		}
		
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.newLine();
	}
	
	public Book getBook(){
		return this.scan.getBookkeeper();
	}
	
	private int getIndex(String symbol){
		for(int i = 0; i < SYMBOL.length; i++){
			if(SYMBOL[i].equalsIgnoreCase(symbol)){
				return i;
			}
		}
		
		return -1;
	}
}
