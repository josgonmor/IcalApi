package net.josgonmor.ws;

public class Todos extends Modulos{
	 private int prioridad;

	    protected Todos(String sumario, String descripcion, int prioridad){
	        super(sumario, descripcion);
	        this.prioridad=prioridad;
	    }

	    protected int getPrioridad() {
	        return prioridad;
	    }

	    protected void setPrioridad(int prioridad) {
	        this.prioridad = prioridad;
	    }
}
