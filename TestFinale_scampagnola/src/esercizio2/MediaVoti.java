package esercizio2;

public class MediaVoti {

	public static void main(String[] args) {
		
		KeyBoardInput keyBoardInput = new KeyBoardInput();
		int toInsert = 0;
		int count = 0;
		int media = 0;
		while(toInsert != -1) {
				toInsert = keyBoardInput.inputNumber("Inserire un voto: ");
				if((toInsert < 18 || toInsert > 30) && toInsert!=-1) {
					System.out.println("Valore inserito non corretto!");
				}
				else if(toInsert!=-1){
					count++;
					media += toInsert;
				}
		}
		keyBoardInput.closeScanner();
		media = media / count;
		System.out.println("La media voti è : " + media);

	}

}
