/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetofinalsofia;

/**
 *
 * @author m79312
 */
public class Itens {

    public Itens (){
    }

    String name;
    int price;
    Atributos atributes;

    @Override
    public String toString() {
        return "Itens{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", atributes=" + atributes +
                '}';
    }

    public Itens(String name, int price) {
        this.name = name;
        this.price = price;
        this.atributes = new Atributos(0, 0, 0);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Atributos getAtributos() {
        return atributes;
    }
}

