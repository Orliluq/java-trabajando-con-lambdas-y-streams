package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Hola Mundo con Spring");
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obtenerDatos( "https://www.omdbapi.com/?t=Game%20of%20Thrones&apikey=b7ab1911");
//		var json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");

		System.out.println(json);
//		json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);
		ConvierteDatos conversor = new ConvierteDatos();
		DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);
	}
}