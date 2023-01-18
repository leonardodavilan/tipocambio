package com.leonardo.davila.bfftipocambiomoneda.dao.repository;

import com.leonardo.davila.bfftipocambiomoneda.dao.entity.TipoCambio;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TipoCambioDao extends CrudRepository<TipoCambio, Long> {

    TipoCambio findTipoCambioByMoneda_Idmoneda(Long idmoneda);
}
