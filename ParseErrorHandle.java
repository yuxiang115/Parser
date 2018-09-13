import java.util.Vector;

public class ParseErrorHandle extends Exception{
	private String production, lookahead;
	
	
	public ParseErrorHandle(String message){
		super(message);
	}
	
	public ParseErrorHandle(String production, String lookahead){
		this.production = production;
		this.lookahead = lookahead;
	}
	
	public void print(){
		System.out.println("Sytax Error occurs during Parse production: " + production +  " by lookahead: " + lookahead);
	}
}
