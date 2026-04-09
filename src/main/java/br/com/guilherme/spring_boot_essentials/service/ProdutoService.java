package br.com.guilherme.spring_boot_essentials.service;

import br.com.guilherme.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.guilherme.spring_boot_essentials.dto.ProdutoDto;
import br.com.guilherme.spring_boot_essentials.exception.NotFoundException;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>(List.of(
            new ProdutoEntity(1L, "Smartphone Galaxy S24", "Eletrônicos", 4500.00, 15),
            new ProdutoEntity(2L, "Notebook Dell Inspiron", "Informática", 3800.50, 8),
            new ProdutoEntity(3L, "Monitor LG 27'' 4K", "Informática", 1890.00, 5),
            new ProdutoEntity(4L, "Fone de Ouvido Sony XM5", "Acessórios", 1200.00, 20),
            new ProdutoEntity(5L, "Cadeira Gamer Ergonômica", "Móveis", 950.99, 12),
            new ProdutoEntity(6L, "Teclado Mecânico RGB", "Periféricos", 350.00, 30),
            new ProdutoEntity(7L, "Mouse Sem Fio Logitech", "Periféricos", 150.00, 50),
            new ProdutoEntity(8L, "Smartwatch Apple Watch", "Wearables", 2900.00, 10),
            new ProdutoEntity(9L, "Câmera Mirrorless Canon", "Fotografia", 5200.00, 3),
            new ProdutoEntity(10L, "SSD NVMe 1TB", "Hardware", 450.00, 25)
    ));

    public List<ProdutoEntity> findAll() {
        return PRODUTOS;
    }

    public ProdutoEntity createProduct(ProdutoDto produtoDto) {
        Long proximoId = PRODUTOS.stream()
                .mapToLong(ProdutoEntity::getId)
                .max()
                .orElse(0L) + 1;

        ProdutoEntity novoProduto = ProdutoEntity.builder()
                .id(proximoId)
                .nome(produtoDto.getNome())
                .preco(Double.valueOf(produtoDto.getPreco()))
                .quantidade(produtoDto.getQuantidade())
                .build();

        PRODUTOS.add(novoProduto);
        return novoProduto;
    }

    public ProdutoEntity atualizarProduto(Long id, ProdutoDto produtoDto) {
        ProdutoEntity produtoExistente = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                // Trocamos RuntimeException pela sua classe personalizada:
                .orElseThrow(() -> new NotFoundException("Produto não encontrado com o id: " + id));

        produtoExistente.setNome(produtoDto.getNome());
        produtoExistente.setPreco(Double.valueOf(produtoDto.getPreco()));
        produtoExistente.setQuantidade(produtoDto.getQuantidade());

        return produtoExistente;
    }

    public void deleteProduct(Long id) { // Alterado para Long para manter consistência
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }
}