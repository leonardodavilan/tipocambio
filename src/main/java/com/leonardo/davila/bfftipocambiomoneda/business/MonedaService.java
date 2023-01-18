package com.leonardo.davila.bfftipocambiomoneda.business;

import com.leonardo.davila.bfftipocambiomoneda.dao.entity.Moneda;

import java.util.Optional;

public interface MonedaService {

    Moneda saveMoneda(Moneda moneda);
    Optional<Moneda> getMoneda(Long idmoneda);
}
