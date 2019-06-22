package sisFolhaPgto;

import java.util.Date;

public class EventoReajuste extends Evento {
	public EventoReajuste(Date dt, float val) {
		super(dt, val, "EventoReajuste");
	}
}
