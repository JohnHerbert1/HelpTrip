package com.example.HelpTrip;

import com.example.HelpTrip.dao.AreaPlantacaoDAO;
import com.example.HelpTrip.dao.PontoDao;
import com.example.HelpTrip.entidy.AreaPlantacao;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HelpTripApplication implements CommandLineRunner {
/*
	@Autowired
	private PontoDao pontoDao;*/

    @Autowired
    private AreaPlantacaoDAO areaPlantacaoDAO;

	@Override
	public void run(String... args) throws Exception {
	/*	Coordinate[] coordinates = new Coordinate[] {
				new Coordinate(-10.3000, -23.59748),  // Exemplo de ponto 1
				new Coordinate(-1.57420, -30.59747),  // Exemplo de ponto 2
				new Coordinate( -2.11532,  -34.861 )   // Exemplo de ponto 3
		};

		pontoDao.salvar("carioca","cariocando", coordinates);*/

		//areaPlantacaoDAO.salvar("Macro","Plantacao de frutas","POLYGON((-34.854 -7.115,-34.860 -7.110 ,-34.865 -7.115, -34.860 -7.120, -34.854 -7.115))");
//		areaPlantacaoDAO.salvar("Parque dos indios", "Área de plantacao de jua", "POLYGON((-60.3 -3.1, -60.4 -3.2, -60.5 -3.1, -60.6 -3.0, -60.3 -3.1))");
//		areaPlantacaoDAO.salvar("parque da plantacao", "Área de plantacao de cana", "POLYGON((-63.2 -4.3, -63.3 -4.4, -63.5 -4.3, -63.6 -4.2, -63.2 -4.3))");
		//areaPlantacaoDAO.deletar(2);

		//areaPlantacaoDAO.update(1,"floresta dos penhores","plantacao de cana");


	}




	public static void main(String[] args) {
		SpringApplication.run(HelpTripApplication.class, args);
	}

}
