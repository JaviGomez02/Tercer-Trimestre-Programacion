package com.jacaranda.main;

import com.jacaranda.Provincia.Provincia;
import com.jacaranda.Provincia.ProvinciaException;
import com.jacaranda.pueblo.Pueblo;
import com.jacaranda.pueblo.PuebloException;

public class Main {

	public static void main(String[] args){


		Provincia p2;
		try {
			p2 = new Provincia("Sevilla","12");
			System.out.println(p2.toString());
			p2.addPueblo("Campana", "123", 5, 6, 4);
			p2.addPueblo("carmona", "122", 3, 5, 7);
			p2.addPueblo("lora", "121", 3, 5, 7);
			System.out.println(p2.listadoNombresPueblos());
			System.out.println(p2.listadoPueblos());
			System.out.println(p2.getInformacionPueblo("lora"));
			p2.delPueblo("Carmona");
			System.out.println(p2.listadoNombresPueblos());
		} catch (ProvinciaException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
