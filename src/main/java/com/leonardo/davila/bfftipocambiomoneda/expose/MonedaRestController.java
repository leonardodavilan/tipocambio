package com.leonardo.davila.bfftipocambiomoneda.expose;

import com.leonardo.davila.bfftipocambiomoneda.business.MonedaService;
import com.leonardo.davila.bfftipocambiomoneda.dao.entity.Moneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/moneda")
@CrossOrigin("*")
public class MonedaRestController {

	@Autowired
	private MonedaService monedaService;
/*
	@GetMapping(value = "/all")
	public List<Moneda> getAll() {
		return monedaService.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Moneda find(@PathVariable Long id) {
		return monedaService.get(id);
	}
*/
	@PostMapping(value = "/save")
	public ResponseEntity<Moneda> save(@RequestBody Moneda Moneda) {
		Moneda obj = monedaService.saveMoneda(Moneda);
		return new ResponseEntity<Moneda>(obj, HttpStatus.OK);
	}
/*
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Moneda> delete(@PathVariable Long id) {
		Moneda Moneda = monedaService.get(id);
		if (Moneda != null) {
			monedaService.delete(id);
		}else {
			return new ResponseEntity<Moneda>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Moneda>(Moneda, HttpStatus.OK);
	}*/

}
