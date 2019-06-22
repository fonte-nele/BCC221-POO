package sisFolhaPgto;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class Evento {

	protected Date dtEvento;
	private float valorEvento;
	private String tipoEvento;

	public Evento(Date dt, float val, String tipo) {
		this.dtEvento = dt;
		Calendar cal = new GregorianCalendar();
		cal.setTime(dtEvento);
		this.valorEvento = val;
		this.tipoEvento = tipo;
	}
	public Date getDtEvento() {
		return this.dtEvento;
	}
	public float getValorEvento() {
		return this.valorEvento;
	}
	public String getTipoEvento() {
		return (this.tipoEvento);
	}
	
	public String toString()
	{
		return getTipoEvento()+" em " +
		this.dtEvento.toString()+ "valor=" +
		this.valorEvento;
	}
}
