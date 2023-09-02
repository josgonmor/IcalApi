package net.josgonmor.ws;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VToDo;

public class IcalManager {
	private static ArrayList<Eventos> listaEventos = new ArrayList<>();
	private static ArrayList<Todos> listatodos= new ArrayList<>();
	protected static void loadClasses() {
		 try {
	            FileInputStream fin = new FileInputStream("calcurse.ical");
	            CalendarBuilder builder = new CalendarBuilder();
	            Calendar calendar = builder.build(fin);

	            ArrayList<VEvent> eventos= new ArrayList<>(calendar.getComponents(Component.VEVENT));
	             

	            for(VEvent d: eventos){
	                String sumario=null;
	                String descripcion=null;
	                String fechaString=null;
	                String duracionString=null;
	                String [] aux= d.getSummary().toString().split(":");
	                sumario=aux[1];
	                if(!(d.getDescription()==null)){
	                    aux=d.getDescription().toString().split(":");
	                    descripcion=aux[1];
	                }
	                aux=d.getStartDate().toString().split(":");
	                fechaString=aux[1];
	                if(!(d.getDuration()==null)){
	                    aux=d.getDuration().toString().split(":");
	                    duracionString=aux[1];
	                }
	                listaEventos.add(new Eventos(sumario, descripcion, fechaString, duracionString));
	            }


	            ArrayList<VToDo> todos = new ArrayList<>(calendar.getComponents(Component.VTODO));
	            

	            for(VToDo d: todos){
	                String sumario= null;
	                String descripcion= null;
	                int prioridad = 0;

	                String[] aux =d.getSummary().toString().split(":");
	                sumario= aux[1];
	                if(!(d.getDescription()==null)){
	                    aux=d.getDescription().toString().split(":");
	                    descripcion=aux[1];
	                }
	                aux=d.getPriority().toString().split(":");
	                Scanner sc= new Scanner(aux[1]);
	                prioridad= sc.nextInt();
	                listatodos.add(new Todos(sumario, descripcion, prioridad));
	            }	            

	        }catch (NumberFormatException e){
	            System.out.println("NumberFormatException");
	            System.out.println(e.getMessage());
	        }
		 	catch (IOException e) {
				System.out.println("IOException");
				System.out.println(e.getMessage());
			}
	        catch (Exception e){
	            System.out.println(e.getMessage());
	        
	        }
	}
	protected static ArrayList<Todos> returnTodos(){
		return listatodos;
	}
	protected static ArrayList<Eventos> returnEventos(){
		return listaEventos;
	}
}
