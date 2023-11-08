package com.akira.apihemomar.services;

import com.akira.apihemomar.exception.NotFoundException;
import com.akira.apihemomar.models.TipoDoacao;
import com.akira.apihemomar.repository.TipoDocaoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoDoacaoService {

    private final TipoDocaoRepository tipoDocaoRepository;

    public TipoDoacaoService(TipoDocaoRepository tipoDocaoRepository) {
        this.tipoDocaoRepository = tipoDocaoRepository;
    }

    public TipoDoacao buscarTipoDoacaoId(Long id) {

        return tipoDocaoRepository.findById(id).orElseThrow(() -> new NotFoundException("Tipo doação não encontrado !"));
    }
}
