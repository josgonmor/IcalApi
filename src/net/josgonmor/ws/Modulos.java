package net.josgonmor.ws;


public abstract class  Modulos{
	 private String sumario;
	    private String descripcion;

	    protected Modulos(String sumario, String descripcion){
	        this.sumario= sumario;
	        this.descripcion= descripcion;
	    }

	    protected String getSumario() {
	        return sumario;
	    }

	    protected void setSumario(String sumario) {
	        this.sumario = sumario;
	    }

	    protected String getDescripcion() {
	        return descripcion;
	    }

	    protected void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }
}
