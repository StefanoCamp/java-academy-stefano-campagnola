package esercizio4.fumetteria;

public class Fumetto extends Libro{
	
	private String nome, disegnatore;
	
	public Fumetto() {
		
	}
	
	public Fumetto(String titolo, String autore, String annoDiPubblicazione, String editore,
			double costo, String nome, String disegnatore) {
		super(titolo, autore, annoDiPubblicazione, editore, costo);
		setNome(nome);
		setDisegnatore(disegnatore);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisegnatore() {
		return disegnatore;
	}

	public void setDisegnatore(String disegnatore) {
		this.disegnatore = disegnatore;
	}

	@Override
	public String toString() {
		return super.toString() + "[nome=" + nome + ",\n             disegnatore=" + disegnatore + "]";
	}
	
	
	
	

}
