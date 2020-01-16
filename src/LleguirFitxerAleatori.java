import java.io.*;

public class LleguirFitxerAleatori {
	public static void main(String[] args) throws IOException {
		File fitxer = new File("F:/persones.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori només lectura
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
		
		//Apuntador s'inicialitza apuntant a l'inici del fitxer
		int apuntador = 0, isbn, id;
		float preu;
		char titol[] = new char[50], autor[] = new char[25], editorial[] = new char[30], aux;
		
		//Recorrer el fitxer llibres
		for (;;) {
			aleatoriFile.seek(apuntador);//Apuntar a l'inici de cada llibre al fitxer
			//Llegeix ID
			id = aleatoriFile.readInt();
			//Llegeix Títol
			for(int i = 0; i<titol.length; i++) {
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
			System.out.println("ID: "+id+"\nNom: "+titols+"\nEdad: "+isbn+"\nCiutat: "+autors+"\nEstudis: "+editorials+"\nSou: "+preu+"€\n\n");
			//S'ha de posicionar l'apuntador al següent llibre
			apuntador += 222;
			//Si coincideix on s'està apuntat amb el final del fitxer, sortim
			if(aleatoriFile.getFilePointer()==aleatoriFile.length()) break;
		}
		aleatoriFile.close();//Tancar el fitxer
	}
}
