package br.com.cielo.stb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cielo.stb.entity.PendenciasBandeira;
import br.com.cielo.stb.repository.AlertaPendenciaRepository;

@RestController
public class AlertaPendenciaAPI {

	@Autowired
	AlertaPendenciaRepository repository;

	@GetMapping("/pendencias/relatorio")
	public ResponseEntity<List<PendenciasBandeira>> pendencias() {
		List<PendenciasBandeira> pendencias = repository.consultaPendencias();
		if (pendencias.isEmpty()) {
			return new ResponseEntity<List<PendenciasBandeira>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PendenciasBandeira>>(pendencias, HttpStatus.OK);
	}

}
