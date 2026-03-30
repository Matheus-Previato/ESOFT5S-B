package com.bn.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoModel> salvarPedido(Pedido Model pedidoModel){
        PedidoModel request = pedidoService.salvarPedido(pedidoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pedidoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> listarTodosPedidos(){
        List<PedidoModel> request = pedidoService.listarTodosPedidos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> acharPedidoPorId(Long id){
        PedidoModel request = pedidoService.acharPedidoPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido(Long id){
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
