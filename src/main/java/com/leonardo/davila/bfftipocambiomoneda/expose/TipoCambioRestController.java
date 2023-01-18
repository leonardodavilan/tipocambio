package com.leonardo.davila.bfftipocambiomoneda.expose;

import com.leonardo.davila.bfftipocambiomoneda.business.TipoCambioService;
import com.leonardo.davila.bfftipocambiomoneda.dao.entity.TipoCambio;
import com.leonardo.davila.bfftipocambiomoneda.expose.dto.TipoCambioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tipo-cambio")
@CrossOrigin("*")
public class TipoCambioRestController {

	@Autowired
	private TipoCambioService tipoCambioService;

	/*
	@GetMapping(value = "/all")
	public List<TipoCambio> getAll() {
		return tipoCambioService.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public TipoCambio find(@PathVariable Long id) {
		return tipoCambioService.get(id);
	}*/

	@PostMapping(value = "/save")
	public ResponseEntity<TipoCambio> save(@RequestBody TipoCambio TipoCambio) {
		TipoCambio obj = tipoCambioService.saveTipoCambio(TipoCambio);
		return new ResponseEntity<TipoCambio>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/convertion")
	public TipoCambioDto.Response find(@RequestBody TipoCambioDto.Request request) {
		return tipoCambioService.getConvertion(request);
	}
/*
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<TipoCambio> delete(@PathVariable Long id) {
		TipoCambio TipoCambio = tipoCambioService.get(id);
		if (TipoCambio != null) {
			tipoCambioService.delete(id);
		}else {
			return new ResponseEntity<TipoCambio>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<TipoCambio>(TipoCambio, HttpStatus.OK);
	}
*/
}
