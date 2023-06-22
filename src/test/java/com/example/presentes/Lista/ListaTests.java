package com.example.presentes.Lista;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaTests {

    Lista l;

    @BeforeEach
    public void setup(){

        l = new Lista();
        Presente p = new Presente("Camiseta", "Vascamisa", 1, 65);
        l.adicionaPresente(p);

    }


    @Test
    public void teste(){
        Assertions.assertEquals("Vascamisa", l.getPresente("Vascamisa").getNome());
        Assertions.assertEquals("Camiseta", l.getPresente("Vascamisa").getTipo());

        Presente p = new Presente("Tecnologia", "mousepad", 1, 10);
        Presente p2 = new Presente("livro", "O estrangeiro", 1, 25);
        Presente p3 = new Presente("Tecnologia", "SSD 500GB Sata AliExpress Promoção primeira compra", 2, 120);
        Presente p4 = new Presente("Camiseta", "Camiseta vasco da gama preta", 1, 65);
        l.adicionaPresente(p);
        l.adicionaPresente(p2);
        l.adicionaPresente(p3);
        l.adicionaPresente(p4);

        System.out.println(l.toString());
        System.out.println(l.toJson());
        l.organizaPorTipo();
        System.out.println(l.toString());
        System.out.println(l.toJson());
    }
}
