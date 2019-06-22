package editor;

import java.awt.*;
import java.awt.geom.Point2D;


public class Pentagono extends Figura {
	int[] xPoints;
	int[] yPoints;
	Ponto p2;

	public Pentagono () {
		super();
		p2 = new Ponto();
		xPoints = new int [5];
		yPoints = new int [5];

	}
	public Pentagono (int x, int y, int x2, int y2, Color cor){
		super(x, y, cor);
		p2 = new Ponto(x2, y2);
		xPoints = new int [5];
		yPoints = new int [5];
		setCoordenadas(x, y, x2, y2);
	}

	@Override
	public void setCoordenadas(int x1, int y1, int x2, int y2) {
		p.x = x1;
		p.y = y1;
		p2.x = x2;
		p2.y = y2;
		
		double raio = Point2D.distance(x1, y1, x2, y2);
		double ang = Math.atan2(y2-y1, x2-x1);
		double inc = 72 * Math.PI / 180;
		for(int i=0; i<xPoints.length; i++) {
			xPoints[i] = (int) (raio * Math.cos(ang) + x1);
			yPoints[i] = (int) (raio * Math.sin(ang) + y1);
			ang += inc;
		}
	}
	public void desenha(Graphics g) {
		g.setColor(cor);
		g.drawPolygon(xPoints, yPoints, 5);
	}
	public double Area() {
		Ponto p2 = new Ponto(xPoints[1], yPoints[1]);
		Ponto p3 = new Ponto(xPoints[2], yPoints[2]);
		double d = distancia(p2, p3);
		return( ((5*(d*d)) * Math.tan(54))/4);
	}
	public double Perimetro() {
		Ponto p2 = new Ponto(xPoints[1], yPoints[1]);
		Ponto p3 = new Ponto(xPoints[2], yPoints[2]);
		return ( 5 * (distancia(p2, p3)));
	}
	private double distancia(Ponto r, Ponto s) {
		return Math.sqrt(
				Math.pow(r.x-s.x, 2) + 
				Math.pow(r.y-s.y, 2)
				);
	}
	public String mostrarInfo() {
		Ponto p = new Ponto(xPoints[0], yPoints[0]);
    	return (" Area = " +Area() +" Perimetro = " +Perimetro()+
    			" Ponto Inicial = " +p.x +"," + p.y);
    }
	public boolean contains(int x, int y) {
		Polygon p = new Polygon(xPoints, yPoints, 5);
		if (p.contains(x, y)) {
			return true;
		}
		return false;
	}
	public void mover (int dx, int dy) {
    	for(int i = 0; i < xPoints.length; i++) {
    		xPoints[i] += dx;
    		yPoints[i] += dy;
    	}
    }
}