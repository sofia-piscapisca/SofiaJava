/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetofinalsofia;

/**
 *
 * @author m79312
 */
public class Atributos {

    public Atributos(){
    }

    int attackdamage;
    int armor;
    int health;

    @Override
    public String toString() {
        return "Atributos{" +
                "attackdamage=" + attackdamage +
                ", armor=" + armor +
                ", health=" + health +
                '}';
    }

    public Atributos(int health, int armor, int attackdamage) {
        this.health = health;
        this.armor = armor;
        this.attackdamage = attackdamage;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public int getAttackDamage() {
        return attackdamage;
    }
}


