import java.io.*;
import java.util.*;

public class ConsultarFitxerAleatori {
	public static void main(String[] args) throws IOException {
		File fitxer = new File("/home/user/Escriptori/llibres");
		//Crea un flux (stream) d'arxiu d'accés aleatori només lectura
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
		
		int apuntador, isbn, id, seleccio;
		float preu;
		char titol[] = new char[50], autor[] = new char[25], editorial[] = new char[30], aux;
		//Demana a l'usuari que seleccioni el llibre pel seu identificador
		System.out.print("Introdueixi el ID del llibre a consultar: ");
		Scanner stdin = new Scanner (System.in);
				
		seleccio = stdin.nextInt();
		apuntador = (seleccio-1)*222;
		
		if (apuntador >= aleatoriFile.length()) {
			System.out.println("ERROR: ID incorrecte, no existeix aquest llibre");
		} else {//Apuntar a l'inici del llibre seleccionat al fitxer
			aleatoriFile.seek(apuntador);
			id = aleatoriFile.readInt();//Llegeix ID
			for(int i = 0; i<titol.length; i++) {//Llegeix Títol
				aux = aleatoriFile.readChar();
				titol[i] = aux;
			}
			String titols = new String(titol);
			//Llegeix ISBN
			isbn = aleatoriFile.readInt();
			//Llegeix Autor
			for(int i = 0; i<autor.length; i++) {
				aux = aleatoriFile.readChar();
				autor[i] = aux;
			}
			String autors = new String(autor);
			//Llegeix Editorial
			for(int i = 0; i<editorial.length; i++) {
				aux = aleatoriFile.readChar();
				editorial[i] = aux;
			}
			String editorials = new String(editorial);
			//Llegeix Preu
			preu = aleatoriFile.readFloat();
			//Sortida de les dades de cada llibre
			System.out.println("ID: "+id+"\nTítol: "+titols+"\nISBN: "+isbn+"\nAutor: "+autors+"\nEditrorial: 							"+editorials+"\nPreu: "+preu+"€\n\n");
		}
		aleatoriFile.close();//Tancar el fitxer
	}
}