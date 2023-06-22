package com.example.presentes.Lista;


import org.springframework.web.bind.annotation.*;

@RestController
public class ListaController {

    Lista l = Lista.recuperaLista();

    @GetMapping("/lista")
    public String getLista(){
        return l.toJson();
    }

    @PostMapping("/lista/add/{nome}/{tipo}/{quantidadeString}/{precoString}")
    public String adiciona(@PathVariable String nome, @PathVariable String tipo, @PathVariable String quantidadeString, @PathVariable String precoString){

        try {
            int quantidade = Integer.parseInt(quantidadeString);
            double preco = Double.parseDouble(precoString);
            l.adicionaPresente(new Presente(tipo, nome, quantidade, preco));
            l.salvaLista();
            return "Presente adicionado com sucesso!";
        }catch(NumberFormatException | NullPointerException e){
            return "Quantidade ou preço informados são invalidos";
        }

    }

    @PutMapping("/lista/organizar")
    public String organizar(){
        l.organizaPorTipo();
        l.salvaLista();
        return "Organizada!";
    }

    @PostMapping("/lista/apagar/{nome}")
    public String apagar(@PathVariable String nome){
        l.deletaPresente(nome);
        l.salvaLista();
        return "Apagado com sucesso";
    }


}
