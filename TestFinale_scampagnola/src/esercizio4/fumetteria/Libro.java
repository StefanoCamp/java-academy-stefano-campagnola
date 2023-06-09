package esercizio4.fumetteria;

public class Libro {
	
	private String titolo, autore, annoDiPubblicazione, editore;
	private double costo;
	
	public Libro() {
		
	}
	
	public Libro(String titolo, String autore, String annoDiPubblicazione, String editore,
			double costo) {
		setTitolo(titolo);
		setAutore(autore);
		setAnnoDiPubblicazione(annoDiPubblicazione);
		setEditore(editore);
		setCosto(costo);
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getAnnoDiPubblicazione() {
		return annoDiPubblicazione;
	}
	public void setAnnoDiPubblicazione(String annoDiPubblicazione) {
		this.annoDiPubblicazione = annoDiPubblicazione;
	}
	public String getEditore() {
		return editore;
	}
	public void setEditore(String editore) {
		this.editore = editore;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "\ntitolo=" + titolo + ", autore=" + autore + ", annoDiPubblicazione=" + annoDiPubblicazione
				+ ", editore=" + editore + ", costo=" + costo;
	}
	
	
	
	

}
