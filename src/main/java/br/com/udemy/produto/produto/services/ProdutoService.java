package br.com.udemy.produto.produto.services;

import br.com.udemy.produto.produto.model.Produto;
import br.com.udemy.produto.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos(){
        return this.produtoRepository.obterTodos();
    }

    public Optional<Produto> obterPorId(Integer id){
        return this.produtoRepository.obterPorId(id);
    }

    public Produto adicionar(Produto produto){
        return this.produtoRepository.adicionar(produto);
    }

    public void deletar(Integer id){
        this.produtoRepository.deletar(id);
    }

    public Produto atualizar(Integer Id, Produto produto){
        produto.setId(Id);

        return this.produtoRepository.atualizar(produto);

    }

}
