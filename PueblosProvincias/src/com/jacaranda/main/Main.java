package com.jacaranda.main;

import com.jacaranda.Provincia.Provincia;
import com.jacaranda.Provincia.ProvinciaException;
import com.jacaranda.pueblo.Pueblo;
import com.jacaranda.pueblo.PuebloException;

public class Main {

	public static void main(String[] args){


		Provincia p1, p2, p3, p4, p5, p6;
		try {

			p1=new Provincia("Sevilla","23");
//			p2=new Provincia(null,"11");
//			p3=new Provincia("Cordoba",null);
//			p4=new Provincia("Malaga","3");
//			p5=new Provincia("Almeria","234");
			p1.addPueblo("Brenes", "124", 23342, 12333, 2133421);
//			p1.addPueblo("Brenes", "124", 23342, 12333, 2133421);
			System.out.println(p1.listadoPueblos());
//			p1.setRentaPerCapita(-5);
//			p1.setSuperficie("Brenes", -5);
			p1.setNumeroHabitantes("brenes", -4);
		} catch (ProvinciaException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
