package esercizio1;

public class CalcoloMediaArray {

	public static void main(String[] args) {
		
		int[] arr = {547, 87, 1, 24, 4, 9, 54, 37, 26, 19};
		int media = 0;
		for(int x : arr) {
			media += x;
		}
		media = media / arr.length;
		System.out.println("La media dell'array è : " + media);

	}

}
