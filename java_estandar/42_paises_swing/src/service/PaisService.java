package service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.Pais;

public interface PaisService {

	//  Lista de continentes
	List<String> mostrarContinentes();

	// Lista de paises a partir del continente
	List<Pais> mostrarPaises(String continente);

	// Pais más poblado
	Pais paisMasPoblado();

	//}
	Map<String, List<Pais>> paisesPorContinente();

	Optional<Pais> mostrarPaisPorCapital(String capital);

	String getPaisFiltradoPor(String capital);

}