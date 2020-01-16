import java.io.*;
import java.util.Scanner;

public class EscriuFitxerAleatori {
	public static void main(String[] args) throws IOException {
		
		Scanner teclado = new Scanner(System.in);
		
		File fitxer = new File("F:/persones.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori per llegir
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "rw");
		//Les dades per inserir
		String nom[] = new String[2];
		int edad[] = new int[2];
		String ciutat[] = new String[2];
		String estudis[] = new String[2];
		double sou[] = new double[2];
		
		for (int i = 0; i < nom.length; i++) {
			System.out.println("Introduce nombre de la persona: " + i);
			nom[i] = teclado.nextLine();
		}
		
		for (int i = 0; i < edad.length; i++) {
			System.out.println("Introduce edad de la persona: " + i);
			edad[i] = teclado.nextInt();
		}
		
		for (int i = 0; i < ciutat.length; i++) {
			System.out.println("Introduce tu ciudad de la persona: " + i);
			ciutat[i] = teclado.nextLine();
		}
		
		for (int i = 0; i < estudis.length; i++) {
			System.out.println("Introduce estudios de la persona: " + i);
			estudis[i] = teclado.nextLine();
		}
		
		for (int i = 0; i < sou.length; i++) {
			System.out.println("Introduce sueldo de la persona: " + i);
			sou[i] = teclado.nextDouble();
		}
		
		
		//Construeix un buffer (memòria intermèdia) de strings
		StringBuffer buffer = null;
		
		for (int i=0; i<nom.length; i++) {
			aleatoriFile.writeInt(i+1);//1 enter ocupa 4 bytes
			//50 caràcters a 2bytes/caràcter 100 bytes
			buffer = new StringBuffer (nom[i]);
			buffer.setLength(50);
			aleatoriFile.writeChars(buffer.toString());
			//1 enter ocupa 4 bytes
			aleatoriFile.writeInt(edad[i]);
			//25 caràcters a 2bytes/caràcter 50 bytes
			buffer = new StringBuffer (ciutat[i]);
			buffer.setLength(25);
			aleatoriFile.writeChars(buffer.toString());
			//30 caràcters a 2bytes/caràcter 60 bytes
			buffer = new StringBuffer (estudis[i]);
			buffer.setLength(30);
			aleatoriFile.writeChars(buffer.toString());
			//1 float ocupa 4 bytes
			aleatoriFile.writeFloat((float)sou[i]);
			//Total 222 bytes
		}
		aleatoriFile.close();
	}
}