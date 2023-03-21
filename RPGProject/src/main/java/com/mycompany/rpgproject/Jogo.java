/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpgproject;

/**
 *
 * @author alexa
 */
public class Jogo {

    private Player player;

    public Jogo(Player player) {
        this.player = player;
    }

    public void ComeçarJogo() {

        System.out.println("Iniciou um jogo com a personagem " + player.getNome() + " Hp - " + player.getHP() + " Ataque - " + player.getAttack());
        int attack = player.getAttack();
        int hp = player.getHP();

    }

}
