/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetofinalsofia;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


/**
 *
 * @author m79312
 */
public class ProjetoFinalSofia {

    private static final String CAMPEOES_FILE = "campeoes.json";
    private static final String ITENS_FILE = "itens.json";

    public static void main(String[] args) {
        List<Campeao> campeoes = new ArrayList();
        List<Itens> todosItens = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        salvarCampeoes(campeoes);
        salvarItens(itens);

        do {
            System.out.println("====== MENU ======");
            System.out.println("1 - Adicionar um campeão");
            System.out.println("2 - Listar campeões");
            System.out.println("3 - Adicionar um item e colocá-lo em um campeão");
            System.out.println("4 - Remover um item de um campeão");
            System.out.println("5 - Listar os itens");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Atributos atributos = new Atributos();
                    Campeao campeao = new Campeao();
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Digite o nome do campeão");

                    campeao.name = scanner2.nextLine();

                    System.out.println("Digite a role do campeão");
                    campeao.role = scanner2.nextLine();

                    System.out.println("Nome Campeao: " + campeao.name + " | Posicao: " + campeao.role);

                    System.out.print("Digite a vida do campeão: ");
                    atributos.health = scanner.nextInt();
                    System.out.print("Digite a armadura do campeão: ");
                    atributos.armor = scanner.nextInt();
                    System.out.print("Digite o dano do campeão: ");
                    atributos.attackdamage = scanner.nextInt();
                    scanner.nextLine();
                    campeao.atributes = atributos;
                    campeoes.add(campeao);


                    break;
                case 2:
                    System.out.println("Lista de Campeões:");

                    if (campeoes.isEmpty()) {
                        System.out.println("Nenhum campeão disponível.");
                        break;
                    }

                    int opcaoListagem = -1;

                    while (opcaoListagem != 0) {
                        System.out.println("\nSelecione uma opção:");
                        System.out.println("1 - Filtrar campeões por nome");
                        System.out.println("2 - Filtrar campeões por função");
                        System.out.println("3 - Mostrar todos os campeões");
                        System.out.println("0 - Sair");

                        opcaoListagem = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoListagem) {
                            case 1:
                                System.out.print("Digite o nome do campeão: ");
                                String nomeFiltro = scanner.nextLine();
                                filtrarCampeoesPorNome(campeoes, nomeFiltro);
                                break;

                            case 2:
                                System.out.print("Digite a função do campeão: ");
                                String funcaoFiltro = scanner.nextLine();
                                filtrarCampeoesPorFuncao(campeoes, funcaoFiltro);
                                break;

                            case 3:
                                listarCampeoes(campeoes);
                                break;

                            case 0:
                                System.out.println("Saindo...");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Criar e colocar item em campeão");
                    System.out.println("Selecione um campeão:");
                    for (int i = 0; i < campeoes.size(); i++) {
                        System.out.println(i + 1 + ". " + campeoes.get(i).name);
                    }
                    System.out.print("Escolha pelo número: ");
                    int campeaoIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (campeaoIndex >= 0 && campeaoIndex < campeoes.size()) {
                        Itens item = new Itens();

                        System.out.print("Digite o nome do item: ");
                        item.name = scanner.nextLine();

                        System.out.print("Digite o preço do item: ");
                        item.price = scanner.nextInt();

                        Atributos itemAtributos = new Atributos();
                        System.out.print("Digite a vida adicional do item: ");
                        itemAtributos.health = scanner.nextInt();
                        System.out.print("Digite a armadura adicional do item: ");
                        itemAtributos.armor = scanner.nextInt();
                        System.out.print("Digite o dano adicional do item: ");
                        itemAtributos.attackdamage = scanner.nextInt();
                        scanner.nextLine();

                        item.atributes = itemAtributos;

                        campeoes.get(campeaoIndex).itens.add(item);
                        todosItens.add(item);
                        System.out.println("Item adicionado com sucesso!");
                    } else {
                        System.out.println("Campeão inválido!");
                    }
                    break;
                case 4:
                    System.out.println("Remover um item de um campeão");
                    if (campeoes.isEmpty()) {
                        System.out.println("Nenhum campeão disponível. Adicione um primeiro.");
                        break;
                    }

                    System.out.println("Selecione um campeão:");
                    for (int i = 0; i < campeoes.size(); i++) {
                        System.out.println(i + 1 + ". " + campeoes.get(i).name);
                    }
                    System.out.print("Escolha pelo número: ");
                    int removerCampeaoIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (removerCampeaoIndex >= 0 && removerCampeaoIndex < campeoes.size()) {
                        Campeao removerCampeao = campeoes.get(removerCampeaoIndex);

                        if (removerCampeao.itens.isEmpty()) {
                            System.out.println("Esse campeão não possui itens.");
                            break;
                        }

                        System.out.println("Itens do Campeão:");
                        for (int i = 0; i < removerCampeao.itens.size(); i++) {
                            System.out.println(i + 1 + ". " + removerCampeao.itens.get(i).name);
                        }
                        System.out.print("Escolha o item a ser removido (0 para cancelar): ");
                        int itemIndex = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (itemIndex >= 0 && itemIndex < removerCampeao.itens.size()) {
                            Itens itemRemovido = removerCampeao.itens.remove(itemIndex);
                            System.out.println("Item \"" + itemRemovido.name + "\" removido com sucesso!");
                        } else if (itemIndex != -1) {
                            System.out.println("Item inválido!");
                        }
                    } else {
                        System.out.println("Campeão inválido!");
                    }
                    break;
                case 5:
                    if (todosItens.isEmpty()) {
                        System.out.println("Nenhum item disponível.");
                    } else {
                        System.out.println("Lista de Itens:");
                        for (Itens item : todosItens) {
                            System.out.println("- Nome: " + item.name);
                            System.out.println("  Preço: " + item.price);
                            System.out.println("  Atributos adicionais:");
                            System.out.println("    Vida: " + item.atributes.health);
                            System.out.println("    Armadura: " + item.atributes.armor);
                            System.out.println("    Dano: " + item.atributes.attackdamage);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);

        scanner.close();


    }

    private static void listarCampeoes(List<Campeao> campeoes) {
        if (campeoes.isEmpty()) {
            System.out.println("Nenhum campeão encontrado com o filtro aplicado.");
        } else {
            System.out.println("\nCampeões:");
            for (Campeao campeao : campeoes) {
                System.out.println("- Nome: " + campeao.name);
                System.out.println("  Função: " + campeao.role);
                System.out.println("  Atributos:");
                System.out.println("    Vida: " + campeao.atributes.health);
                System.out.println("    Armadura: " + campeao.atributes.armor);
                System.out.println("    Dano: " + campeao.atributes.attackdamage);
            }
        }
    }

    private static void filtrarCampeoesPorNome(List<Campeao> campeoes, String nomeFiltro) {
        List<Campeao> campeoesFiltrados = campeoes.stream()
                .filter(c -> c.name.equalsIgnoreCase(nomeFiltro))
                .collect(Collectors.toList());
        listarCampeoes(campeoesFiltrados);
    }

    private static void filtrarCampeoesPorFuncao(List<Campeao> campeoes, String funcaoFiltro) {
        List<Campeao> campeoesFiltrados = campeoes.stream()
                .filter(c -> c.role.equalsIgnoreCase(funcaoFiltro))
                .collect(Collectors.toList());
        listarCampeoes(campeoesFiltrados);
    }
        List<Campeao> campeoes = carregarCampeoes();
        static List<Itens> itens = carregarItens();



    private static void salvarCampeoes(List<Campeao> campeoes) {
        try (Writer writer = new FileWriter(CAMPEOES_FILE)) {
            new Gson().toJson(campeoes, writer);
            System.out.println("Campeões salvos no arquivo: " + CAMPEOES_FILE);
        } catch (IOException e) {
            System.out.println("Erro ao salvar campeões: " + e.getMessage());
        }
    }

    private static List<Campeao> carregarCampeoes() {
        try (Reader reader = new FileReader(CAMPEOES_FILE)) {
            Type campeaoListType = new TypeToken<ArrayList<Campeao>>() {}.getType();
            List<Campeao> campeoes = new Gson().fromJson(reader, campeaoListType);
            System.out.println("Campeões carregados: " + campeoes.size());
            return campeoes;
        } catch (IOException e) {
            System.out.println("Erro ao carregar campeões: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private static void salvarItens(List<Itens> itens) {
        try (Writer writer = new FileWriter(ITENS_FILE)) {
            new Gson().toJson(itens, writer);
            System.out.println("Itens salvos no arquivo: " + ITENS_FILE);
        } catch (IOException e) {
            System.out.println("Erro ao salvar itens: " + e.getMessage());
        }
    }

    private static List<Itens> carregarItens() {
        try (Reader reader = new FileReader(ITENS_FILE)) {
            Type itemListType = new TypeToken<ArrayList<Itens>>() {}.getType();
            List<Itens> itens = new Gson().fromJson(reader, itemListType);
            System.out.println("Itens carregados: " + itens.size());
            return itens;
        } catch (IOException e) {
            System.out.println("Erro ao carregar itens: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

