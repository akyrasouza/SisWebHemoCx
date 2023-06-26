package com.akira.apihemomar.services;

import com.akira.apihemomar.models.TipoDoacao;
import com.akira.apihemomar.repository.TipoDocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDoacaoService {
    @Autowired
    private TipoDocaoRepository  tipoDocaoRepository;
    public TipoDoacao buscarTipoDoacaoId(Long id){
        //todo:substituir exception pela customizada
        return tipoDocaoRepository.findById(id).orElseThrow(()->new RuntimeException("Tipo doação não encontrado !"));
    }
}
