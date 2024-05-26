package conteudo;
import java.io.File;
import java.util.Scanner;

public class ManipulandoPastasComFile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Caminho para um pasta: ");
		// c:\temp por exemplo..
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		File[] foldes = path.listFiles(File::isDirectory);
		System.out.println("Folders: ");
		for(File folder : foldes) {
			System.out.println(folder);
		}
		
		File[] files = path.listFiles(File::isFile);
			System.out.println("Files: ");
			for(File file : files) {
				System.out.println(file);
			}
		// Criando um novo diretório a partir do caminho
		// escrito pelo usuário.
		boolean success = new File(strPath+"\\novoSubDir").mkdir();
		System.out.println("Diretório criado com successo: "+ success);
		
		sc.close();
	}
}
