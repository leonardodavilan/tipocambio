package com.leonardo.davila.bfftipocambiomoneda.business;


import com.leonardo.davila.bfftipocambiomoneda.dao.entity.TipoCambio;
import com.leonardo.davila.bfftipocambiomoneda.expose.dto.TipoCambioDto;

import java.util.Optional;

public interface TipoCambioService{

    TipoCambio saveTipoCambio(TipoCambio tipoCambio);

    TipoCambioDto.Response getConvertion(TipoCambioDto.Request request);
    Optional<TipoCambio> findById(Long id);
    TipoCambio findByMoneda(Long idmoneda);

}
