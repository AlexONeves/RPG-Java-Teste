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

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getAttack() {
        return Ataque;
    }

    public void setAttack(int newAttack) {
        this.Ataque = newAttack;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int newHP) {
        this.HP = newHP;
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

    public static void verStatus() {

        for (int i = 0; i < allPlayers.size(); i++) {
            System.out.println("Jogador " + (i + 1) + " - " + allPlayers.get(i).Nome + " Hp - " + allPlayers.get(i).HP + " Ataque - " + allPlayers.get(i).Ataque);
        }

    }

    public static void EditarJogadorOpt() {
        int option = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Selecione a personagem que deseja editar -- ");
        verJogadores();
        System.out.println("Opção: ");
        String Name = sc.nextLine();

        Player JogadorSelecionado = null;

        for (Player p : allPlayers) {
            if (p.getNome().equals(Name)) {
                JogadorSelecionado = p;
                break;
            }
        }

        if (JogadorSelecionado != null) {
            do {
                System.out.print("Escolha uma das opções: \n"
                        + "1 - Editar Nome\n"
                        + "2 - Editar HP\n"
                        + "3 - Editar Ataque\n"
                        + "4 - Exit\n");

                System.out.println("Opção: ");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Nome Atual: " + JogadorSelecionado.getNome());
                        System.out.println("Novo Valor: ");
                        sc.nextLine();
                        String NovoNome = sc.nextLine();
                        JogadorSelecionado.setNome(NovoNome);
                        System.out.println("Nome atualizado para: " + JogadorSelecionado.getNome());
                        break;
                    case 2:
                        System.out.println("HP Atual: " + JogadorSelecionado.getHP());
                        System.out.println("Novo Valor: ");
                        int NovoHP = sc.nextInt();
                        JogadorSelecionado.setHP(NovoHP);
                        System.out.println("Nome atualizado para: " + JogadorSelecionado.getHP());
                        break;
                    case 3:
                        System.out.println("Ataque Atual: " + JogadorSelecionado.getAttack());
                        System.out.println("Novo Valor: ");
                        int NovoAtaque = sc.nextInt();
                        JogadorSelecionado.setAttack(NovoAtaque);
                        System.out.println("Nome atualizado para: " + JogadorSelecionado.getAttack());
                        break;
                    case 4:
                        System.out.println("Exiting Edição...");
                        break;
                    default:
                        System.out.println("Wrong");
                        break;
                }
            } while (option != 4);

        } else {
            System.out.println("Jogador não encontrado.");
        }

    }

}
