package esercizio4.fumetteria;

import java.util.Arrays;

public class Fumetteria {

	private String nome, via, titolare;
	private int numeroDiFumettiMassimi;
	private Fumetto[] fumetti;
	
	public Fumetteria() {
		
	}
	
	public Fumetteria(String nome, String via, String titolare, int numeroDiFumettiMassimi,
			Fumetto[] fumetti) {
		setNome(nome);
		setVia(via);
		setTitolare(titolare);
		setNumeroDiFumettiMassimi(numeroDiFumettiMassimi);
		setFumetti(fumetti);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getTitolare() {
		return titolare;
	}
	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}
	public int getNumeroDiFumettiMassimi() {
		return numeroDiFumettiMassimi;
	}
	public void setNumeroDiFumettiMassimi(int numeroDiFumettiMassimi) {
		this.numeroDiFumettiMassimi = numeroDiFumettiMassimi;
	}
	public Fumetto[] getFumetti() {
		return fumetti;
	}
	public void setFumetti(Fumetto[] fumetti) {
		this.fumetti = fumetti;
	}
	
	public void stampaDati() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Fumetteria [nome=" + nome + ", via=" + via + ", titolare=" + titolare + ", numeroDiFumettiMassimi="
				+ numeroDiFumettiMassimi + ",\n\nfumetti:\n" + Arrays.toString(fumetti) + "]";
	}
	
	
	
	
	
}
