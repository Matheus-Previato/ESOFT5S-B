package com.bn.demo.Services;

import com.bn.demo.Models.PedidoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoModel salvarPedido(PedidoModel pedidoModel){
        return pedidoRepository.save(PedidoModel);
    }

    public List<PedidoModel> listarTodosPedidos(){
        return pedidoRepository.findAll();
    }

    public PedidoModel acharPedidoPorId(Long id){
        return pedidoRepository.findById(id).get();
    }

    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }

}
