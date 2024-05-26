package conteudo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrevendoEmFileComBufferedWriter {

	public static void main(String[] args) {
		String[] lines = new String[] {"Good nigth, Boa Noite"};
		
		// Arquivo não existente
		// O programa irá cria-lo e escrever as strings nele
		String path = "C:\\Users\\demi\\Documents\\boaNoite.txt";
		
		// Se a instanciação de fileWriter tiver o true como parâmetro
		// 'new FileWriter(path, true)'
		// O sistema vai escrever no fim do arquivo e deixar o que já tem lá
		// caso não haja o true 'new FileWriter(path)'
		// O arquivo será apagado e reescrito do zero. (Caso haja um).
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
