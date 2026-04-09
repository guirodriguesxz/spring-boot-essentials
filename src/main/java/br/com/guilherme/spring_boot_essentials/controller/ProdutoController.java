package br.com.guilherme.spring_boot_essentials.controller;

import br.com.guilherme.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.guilherme.spring_boot_essentials.dto.ProdutoDto;
import br.com.guilherme.spring_boot_essentials.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> listarTodos() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> criar(@RequestBody ProdutoDto produtoDto) {
        return new ResponseEntity<>(produtoService.createProduct(produtoDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> atualizar(@PathVariable Long id, @RequestBody ProdutoDto produtoDto) {
        // O Handler cuida do erro se o id não existir
        return ResponseEntity.ok(produtoService.atualizarProduto(id, produtoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deleteProduct(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content (sucesso sem corpo)
    }

}