package com.example.presentes.Lista;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PresenteTests {

    @Test
    public void criar(){
        Presente p = new Presente("Roupa", "Camisa do vasco", 1, 50);
        Assertions.assertEquals("Roupa", p.getTipo());
        Assertions.assertEquals("Camisa do vasco", p.getNome());
        Assertions.assertEquals(1, p.getQuantidade());
        Assertions.assertEquals(50, p.getPreco());

        p.setNome("Vascamisa");
        Assertions.assertEquals("Vascamisa", p.getNome());

        p.setPreco(65);
        Assertions.assertEquals(65, p.getPreco());

        p.setQuantidade(0);
        Assertions.assertEquals(0, p.getQuantidade());

        p.setTipo("Camiseta");
        Assertions.assertEquals("Camiseta", p.getTipo());

    }

}
