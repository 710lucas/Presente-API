package com.example.presentes.Lista;

import java.io.*;
import java.util.ArrayList;

public class Lista implements Serializable {

    private ArrayList<Presente> lista = new ArrayList<>();

    public void adicionaPresente(Presente p){
        lista.add(p);
    }

    public Presente getPresente(String nome){

        for(Presente p : lista)
            if(p.getNome().equals(nome))
                return p;

        return null;
    }

    public boolean temPresente(String nome){
        return getPresente(nome) != null;
    }

    public ArrayList<Presente> getPresentes(){
        return lista;
    }

    public Lista pesquisaPresentes(String palavra){

        Lista l = new Lista();

        for(Presente p : lista)
            if(p.getNome().contains(palavra))
                l.adicionaPresente(p);

        if(l.getPresentes().size() == 0)
            return null;

        return l;
    }

    public void deletaPresente(String nome){
        if(temPresente(nome))
            lista.remove(getPresente(nome));
    }

    public void organizaPorTipo(){
        ArrayList<String> tipos = new ArrayList<>();
        for(Presente p : lista)
            if(!tipos.contains(p.getTipo()))
                tipos.add(p.getTipo());

        ArrayList<Presente> listaNova = new ArrayList<>();

        for (String tipo : tipos)
            for (Presente p : lista)
                if (p.getTipo().equals(tipo))
                    listaNova.add(p);


        if(lista.size() != listaNova.size())
            return; //erro

        for(Presente p : listaNova)
            if(!lista.contains(p))
                return; //erro

        lista = listaNova;
    }

    @Override
    public String toString(){
        String out = "";
        for(Presente p : lista)
            out+=p.getNome()+"; R$"+p.getPreco()+"; "+p.getQuantidade()+"; "+p.getTipo()+"\n";
        return out;
    }

    public String toJson(){
        String out = "[";
        for(Presente p : lista){
            out+="{";
            out+="\"nome\":\""+p.getNome()+"\",";
            out+="\"tipo\":\""+p.getTipo()+"\",";
            out+="\"preco\":"+p.getPreco()+",";
            out+="\"quantidade\":"+p.getQuantidade()+"}";
            if(lista.indexOf(p) != lista.size()-1)
                out+=",";
        }
        out+="]";
        return out;
    }


    public static Lista recuperaLista(){
        try {
            ObjectInputStream in = new ObjectInputStream((new FileInputStream("lista.save")));
            Lista recuperado = (Lista) in.readObject();
            in.close();
            return recuperado;
        } catch (IOException e) {
            return new Lista();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void salvaLista(){
        try {
            ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream("lista.save")));
            out.writeObject(this);
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}
