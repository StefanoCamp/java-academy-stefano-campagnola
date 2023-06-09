package esercizio2;

import java.util.Scanner;

public class KeyBoardInput {
	
private Scanner scanner;
	
	public KeyBoardInput() {
		setScanner(new Scanner(System.in));
	}

	public int inputNumber(String message) {
		int errore = 0;
		int a = 0;
		while(errore ==0) {
			try{
				System.out.print(message);
				String stringa = scanner.nextLine();
				a = Integer.parseInt(stringa);
				errore = 1;
			}catch(NumberFormatException e) {
				System.out.println("Non un intero! Re-inserirlo...");
			}
		}
		return a;
		
	}
	
	
	public Scanner getScanner() {
		return scanner;
	}
	public void closeScanner() {
		this.getScanner().close();
	}
	

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

}
