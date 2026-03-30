package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

@Service
public class TarefaServices {
    @Autowired
    private TarefaRepository tarefaRepository;

    TarefaServices(){

    }

    public List<TarefaModel> tarefaFindAll(){
        return tarefaRepository.findAll();
    }

    public Optional<TarefaModel>tarefaFindById(Long id){
        return tarefaRepository.findById(id);
    }

    public criarTarefa(TarefaModel model){
        return tarefaRepository.save(model);
    }

    public void excluirTarfa(Long id){
        return tarefaRepository.deleteByid(id);
    }

    private mudarDescricaoTarefa(TarefaModel model, Long id){
        TarefaAtual tarefaAtual= tarefaRepository.findById(id).get();

        TarefaAtual.setDescricao(model.getDescricao());

        return tarefaAtual.save(tarefaAtual);

    }


}
