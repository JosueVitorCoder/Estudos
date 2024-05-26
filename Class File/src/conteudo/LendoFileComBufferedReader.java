package conteudo;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class LendoFileComBufferedReader {

	public static void main(String[] args) {
		String path = "C:\\Users\\demi\\Documents\\good.txt";
		
		// Desta maneira não será preciso o bloco finally
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}