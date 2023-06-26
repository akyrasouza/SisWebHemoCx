package com.akira.apihemomar.services;



import com.akira.apihemomar.models.StatusDoacao;
import com.akira.apihemomar.repository.StatusDoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusDoacaoService {
    @Autowired
    private StatusDoacaoRepository  statusDoacaoRepository;
    public StatusDoacao buscarStatusDocaoId(Long id){
        //todo:substituir exception pela customizada
        return statusDoacaoRepository.findById(id).orElseThrow(()->new RuntimeException("Status doação não encontrado !"));
    }
}
