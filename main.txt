import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {			
			File file = new File("input.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			//output
            File outputFile = new File("output.txt");
            if (!outputFile.exists())
                outputFile.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, false));
            
            bw.write("Source Program:");
            bw.newLine();
			while((line=bufferedReader.readLine()) != null){
				System.out.println(line);
				bw.write(line);
                bw.newLine();
			}
            bw.newLine();
            bw.newLine();

			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			bw.write("All Tokens: ");
			bw.newLine();
			
				Parse p = new Parse(bufferedReader, bw);
		
			bw.write("SYMTAB: ");
			bw.newLine();
			bw.write(String.format("%-25s %-25s", "Tokens: ", "Type: "));
			bw.newLine();
			
			//print SYMTAB
			for(Token a : p.getBook().getSymtab()){
				a.toString();
				bw.write(String.format("%-25s %-25s", a.getValue(), a.getTag()));

				bw.newLine();
			}
			
			bw.flush();
            bw.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
