package sisFolhaPgto;

import java.util.Date;

public class EventoAtraso extends Evento {
	public EventoAtraso(Date dt, float qtd) {
		super(dt, qtd, "EventoAtraso");
		if (qtd > 2) {
			System.out.println("\n (Numero de horas extras > 2: "
					+ "nao sera computado um evento do tipo atraso) \n");
		}
	}
}
