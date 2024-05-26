package conteudo;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LendoFileComFileReader {

	public static void main(String[] args) {
		//Local do arquivo
		File file = new File("C:\\Users\\demi\\Documents\\good.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while(sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
			//IOException para tratar erros de leitura
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}finally {
			if(sc != null) {
				sc.close();
			}
		}
	}

}
