package com.universidad;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.universidad.modelo.entidades.Carrera;
import com.universidad.servicios.contratos.CarreraDAO;
import com.universidad.servicios.contratos.PersonaDAO;

@Component
public class CommandRun implements CommandLineRunner {
	@Autowired
	private CarreraDAO servicio;
	

	@Override
	public void run(String... args) throws Exception {
//		  Carrera ingSistemas = new Carrera(null,"Ing Sistemas",10,50);
//      Carrera ingIndustrial = new Carrera(null,"ing Industrial",20,30);
//      Carrera ingAlimentos = new Carrera(null,"ing Alimentos",40,60);
//      Carrera ingElectronica = new Carrera(null,"ing Electronica",70,80);
//      Carrera LicSistemas = new Carrera(null,"LicSistemas",90,100);
//      Carrera LicDataScience = new Carrera(null,"Lic ciencia de datos",110,120);
//      Carrera LicAdmminEmp = new Carrera(null,"Lic administracion de empresas",130,140);
//      Carrera LicIdiomas = new Carrera(null,"Lic Idiomas",70,150);
//
//
//
//      servicio.crear(ingSistemas);
//      servicio.crear(ingAlimentos);
//      servicio.crear(ingIndustrial);
//      servicio.crear(ingElectronica);
//      servicio.crear(LicSistemas);
//      servicio.crear(LicAdmminEmp);
//      servicio.crear(LicDataScience);
//      servicio.crear(LicIdiomas);
		
		//servicio.listar().forEach(System.out::println);
//      List< Carrera> carreras = (List<Carrera>) servicio.findByNombreContains("sistemas");
//      carreras.forEach(System.out::println);
//
//      List< Carrera> carrerasICarreras1 = (List<Carrera>) servicio.findByNombreContainsIgnoreCase("SISTEMAS");
//      carrerasICarreras1.forEach(System.out::println);
//
//      List< Carrera> carrerasICarreras2 = (List<Carrera>) servicio.findByNombreContainsIgnoreCase("sistemas");
//      carrerasICarreras2.forEach(System.out::println);
//      List< Carrera> carreras1 = (List<Carrera>) servicio.findByCantidadAniosAfter(1);
//      carreras1	.forEach(System.out::println);
		

	}

}