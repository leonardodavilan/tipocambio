package com.leonardo.davila.bfftipocambiomoneda.business.impl;

import com.leonardo.davila.bfftipocambiomoneda.business.TipoCambioService;
import com.leonardo.davila.bfftipocambiomoneda.dao.entity.TipoCambio;
import com.leonardo.davila.bfftipocambiomoneda.dao.repository.TipoCambioDao;
import com.leonardo.davila.bfftipocambiomoneda.expose.dto.TipoCambioDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

	private final TipoCambioDao tipoCambioDao;

	public TipoCambioServiceImpl(TipoCambioDao tipoCambioDao ) {
		this.tipoCambioDao = tipoCambioDao;
	}

	@Override
	public TipoCambio saveTipoCambio(TipoCambio tipoCambio) {
		return tipoCambioDao.save(tipoCambio);
	}

	@Override
	public TipoCambioDto.Response getConvertion(TipoCambioDto.Request request) {
		TipoCambio tipoCambioOrigen = findByMoneda(request.getMonedaOrigen().getIdmoneda());
		TipoCambio tipoCambioDestino = findByMoneda(request.getMonedaDestino().getIdmoneda());
		BigDecimal tipoCambio = tipoCambioDestino.getValue().divide(tipoCambioOrigen.getValue(),4, RoundingMode.HALF_UP);
		BigDecimal valorConversion = tipoCambio.multiply(request.getMonto());

		TipoCambioDto.Response response = new TipoCambioDto.Response();
		response.setTipoCambio(tipoCambio);
		response.setMonedaOrigen(tipoCambioOrigen.getMoneda().getName());
		response.setMonedaDestino(tipoCambioDestino.getMoneda().getName());
		response.setMonto(request.getMonto());
		response.setConversion(valorConversion);

		return response;
	}

	@Override
	public Optional<TipoCambio> findById(Long id) {
		return tipoCambioDao.findById(id);
	}

	@Override
	public TipoCambio findByMoneda(Long idmoneda) {
		return tipoCambioDao.findTipoCambioByMoneda_Idmoneda(idmoneda);
	}
}
