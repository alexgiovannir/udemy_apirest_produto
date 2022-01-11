package br.com.udemy.produto.produto.repository;

import br.com.udemy.produto.produto.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<Produto>();

    private Integer ultimoId = 0 ;

    public List<Produto>obterTodos(){
        return this.produtos;
    }

    public Optional<Produto> obterPorId(Integer id){
        return this.produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public Produto atualizar(Produto produto){
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não econtrado");
        }

        deletar(produto.getId());

        produtos.add(produto);

        return produto;
    }


}
