package net.josgonmor.ws;

import java.time.LocalDate;
import java.time.LocalTime;

public class Eventos extends Modulos{
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int duracion;

    protected Eventos(String sumario, String descripcion, String fechaString, String duracionString){
        super(sumario, descripcion);
        LocalDate day=findDate(fechaString);
        LocalTime time=findInicio(fechaString);
        this.year= day.getYear();
        this.month= day.getMonthValue();
        this.day= day.getDayOfMonth();
        if(time==null) {
        	this.hour= 0;
        	this.minute=0;
        }else {
        	this.hour= time.getHour();
        	this.minute= time.getMinute();
        }
        if(duracionString==null)
            this.duracion=0;
        else{
            this.duracion=findDuracion(duracionString);
        }
    }

    

    protected int getYear() {
		return year;
	}



	protected void setYear(int year) {
		this.year = year;
	}



	protected int getMonth() {
		return month;
	}



	protected void setMonth(int month) {
		this.month = month;
	}



	protected int getDay() {
		return day;
	}



	protected void setDay(int day) {
		this.day = day;
	}



	protected int getHour() {
		return hour;
	}



	protected void setHour(int hour) {
		this.hour = hour;
	}



	protected int getMinute() {
		return minute;
	}



	protected void setMinute(int minute) {
		this.minute = minute;
	}



	protected int getDuracion() {
        return duracion;
    }

    protected void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    private static LocalDate findDate(String fecha){
       String[] a = fecha.split("T");
       int ano = Integer.parseInt(a[0].substring(0, 4));
       int mes = Integer.parseInt(a[0].substring(4, 6));
       int dia = Integer.parseInt(a[0].substring(6 ,8));
       return LocalDate.of(ano, mes, dia);
    }

    private static LocalTime findInicio(String fecha){
        if(fecha.contains("T")){
            String[] a = fecha.split("T");

            int hora= Integer.parseInt(a[1].substring(0, 2));
            int min= Integer.parseInt(a[1].substring(2, 4));
            return LocalTime.of(hora, min);

        }else
            return null;

    }

    private static int findDuracion(String duracionString){
    	String [] cad= duracionString.split("T");
    	String aux = cad[1];
    	int hour=0;
    	int minute=0;
    	if (aux.contains("H")){
    		cad = aux.split("H");
        	hour= Integer.parseInt(cad[0]);
        	aux = cad[1];
    	}
    	if (aux.contains("M")) {
    		cad = aux.split("M");
    		minute = Integer.parseInt(cad[0]);
    	}
    	return (hour*60)+minute;
    	
    	
    	
    	/*
    	 cad = aux.split("H");
    	int hour= Integer.parseInt(cad[0]);
    	aux= cad[1];
    	cad = aux.replace("M", "").split("M");
    	aux = cad[0];
    	int minute = Integer.parseInt(aux.trim().replace("M", ""));
    	return (hour*60)+minute; 
    	
    	*/
    	
    	
    }
    

    
}
