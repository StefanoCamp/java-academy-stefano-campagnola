package esercizio3.implementazione;

import esercizio3.interfaccia.*;

public class Calciatore implements GiocatoreProfessionista{
	
	private String nome, cognome, annoDiNascita, luogoDiNascita, squadra, ruolo;
	private double costoCartellino, stipendioAnnuo;
	private int anniDiContratto;
	
	public Calciatore() {
		
	}
	
	public Calciatore(String nome, String cognome, String annoDiNascita,
			String luogoDiNascita, String squadra, String ruolo, double costoCartellino,
			double stipendioAnnuo, int anniDiContratto) {
		setNome(nome);
		setCognome(cognome);
		setAnnoDiNascita(annoDiNascita);
		setLuogoDiNascita(luogoDiNascita);
		setSquadra(squadra);
		setRuolo(ruolo);
		setCostoCartellino(costoCartellino);
		setStipendioAnnuo(stipendioAnnuo);
		setAnniDiContratto(anniDiContratto);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getAnnoDiNascita() {
		return annoDiNascita;
	}
	public void setAnnoDiNascita(String annoDiNascita) {
		this.annoDiNascita = annoDiNascita;
	}
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}
	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
	public String getSquadra() {
		return squadra;
	}
	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public double getCostoCartellino() {
		return costoCartellino;
	}
	public void setCostoCartellino(double costoCartellino) {
		this.costoCartellino = costoCartellino;
	}
	public double getStipendioAnnuo() {
		return stipendioAnnuo;
	}
	public void setStipendioAnnuo(double stipendioAnnuo) {
		this.stipendioAnnuo = stipendioAnnuo;
	}
	public int getAnniDiContratto() {
		return anniDiContratto;
	}
	public void setAnniDiContratto(int anniDiContratto) {
		this.anniDiContratto = anniDiContratto;
	}
	
	public double calcolaStipendioMensile() {
		return getStipendioAnnuo() / 12;
	}
	
	public void stampaDati() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Calciatore [nome=" + nome + ", cognome=" + cognome + ", annoDiNascita=" + annoDiNascita
				+ ", luogoDiNascita=" + luogoDiNascita + ", squadra=" + squadra + ",\nruolo=" + ruolo
				+ ", costoCartellino=" + costoCartellino + ", stipendioAnnuo=" + stipendioAnnuo + ", anniDiContratto="
				+ anniDiContratto + "]";
	}
	
	
	

}
