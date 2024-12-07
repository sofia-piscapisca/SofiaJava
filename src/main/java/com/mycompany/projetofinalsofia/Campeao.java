/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetofinalsofia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m79312
 */
public class Campeao {

    String name;
    String role;
    Atributos atributes;

    List<Itens> itens;

    public Campeao() {
        this.itens = new ArrayList<>();
    }

    public Campeao(String name, String role, Atributos atributes, List<Itens> itens) {
        this.name = name;
        this.role = role;
        this.atributes = atributes;
        this.itens = itens;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(name)
                .append(", Role: ").append(role)
                .append(", ").append(atributes)
                .append(", Itens: ");

        if (itens == null || itens.isEmpty()) {
            sb.append("Nenhum");
        } else {
            for (Itens item : itens) {
                sb.append("\n   ").append(item);
            }
        }
        return sb.toString();
    }

    public Campeao(String name, String role) {
        this.name = name;
        this.role = role;
        this.itens = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public Atributos getAtributos() {
        return atributes;
    }

    public void setAtributos(Atributos atributes) {
        this.atributes = atributes;
    }

    public List<Itens> getItens() {
        return itens;
    }

    public void adicionarItem(Itens item) {
        this.itens.add(item);
    }

}




