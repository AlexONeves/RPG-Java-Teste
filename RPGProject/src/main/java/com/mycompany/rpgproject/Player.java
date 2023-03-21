/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpgproject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class Player {

    public static ArrayList<Player> allPlayers = new ArrayList<>();

    private String Nome;
    private int HP, Ataque;

    public Player(String Nome) {
        this.Nome = Nome;
        this.HP = generateRandomHPValue();
        this.Ataque = generateRandomAttackValue();
        allPlayers.add(this);
    }

    private int generateRandomAttackValue() {
        Random randAttack = new Random();
        return randAttack.nextInt(5) + 1;
    }

    private int generateRandomHPValue() {
        Random randHP = new Random();
        return randHP.nextInt(30) + 20;
    }

    public static void criarJogador(int num) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < num; i++) {
            System.out.println("Indique o nome do jogador: ");
            String Nome = sc.nextLine();
            new Player(Nome);

        }

    }

    public String getNome() {
        return Nome;
    }

    public int getAttack() {
        return Ataque;
    }

    public int getHP() {
        return HP;
    }

    public static void verJogadores() {
        if (allPlayers.isEmpty()) {
            System.out.println("Não existem Jogadores");
        } else {
            for (int i = 0; i < allPlayers.size(); i++) {
                System.out.println("Jogador " + (i + 1) + " - " + allPlayers.get(i).Nome);
            }
        }

    }

}
