package Classes;

import Itens.model.Itens;
import intens.dao.ItensDAO;

import java.util.Date;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class FuncoesDB {
    Itens items = new Itens();
    ItensDAO itemDAO = new ItensDAO();

    //Método Geral para as 3 opções


    //Método de adicionar
    public void adicionarItemDataBase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o NOME do item a ser adicionado ao estoque: ");
        String nomeItem = scanner.nextLine();

        System.out.println("Digite a medida do item a ser adicionado ao estoque(UN,Kg,g,L,Mkl): ");
        String medida = scanner.nextLine();
        System.out.println("Digite a QUANTIDADE do item a ser adicionado ao estoque");
        Double qntd = scanner.nextDouble();

        scanner.nextLine();
        System.out.println("Digite o TIPO do item a ser adicionado(massa, carne,etc...): ");
        String tipo = scanner.nextLine();

        //adicionando items para enviar a database
        items.setNome(nomeItem.toUpperCase());
        items.setQuantidade(qntd);
        items.setMedida(medida.toUpperCase());
        items.setTipo(tipo.toUpperCase());
        items.setDataInsert(new Date());
        //Salvando Itens
        itemDAO.save(items);

    }

    //Método de editar
    public int editarItem(){
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int resp = 0;
        System.out.println("1 - Editar nome");
        System.out.println("2 - Editar quantidade");
        System.out.println("3 - Editar tipo");
        System.out.println("4 - Editar medida");
        System.out.println("Selecione a opção de edição que deseja fazer(digite o para voltar para o menu principal): ");
        try {
            resp = scanner.nextInt();
            if (resp > 4) {
                System.out.println("Valor inválido, tente novamente: ");
                editarItem();
            } else if (resp == 0) {
                return resp;
            } else if (resp == 1) {
                String nome;
                int id;

                System.out.println("Digite o id do item que deseja atualizar(consultar visualização para encontrar ID ou digite o para voltar ao menu principal): ");
                id = scanner.nextInt();
                if(id == 0){
                    resp = 0;
                    return resp;
                }

                System.out.println("Digite o novo nome para o item: ");
                nome = scanner.nextLine();

                items.setId(id);
                items.setNome(nome.toUpperCase());
                items.setDataInsert(new Date());
                itemDAO.updateNome(items);

            } else if (resp == 2) {
                int id;
                Double qntd;

                System.out.println("Digite o id do item que deseja atualizar(consultar visualização para encontrar ID ou digite o para voltar ao menu principal): ");
                id = scanner.nextInt();
                if(id == 0){
                    resp = 0;
                    return resp;
                }

                System.out.println("Digite a nova quantidade do item: ");
                qntd = scanner.nextDouble();

                items.setId(id);
                items.setQuantidade(qntd);
                items.setDataInsert(new Date());

                itemDAO.updateQuantidade(items);
            } else if (resp == 3) {
                String tipo;
                int id;

                System.out.println("Digite o id do item que deseja atualizar(consultar visualização para encontrar ID ou digite o para voltar ao menu principal): ");
                id = scanner.nextInt();
                if(id == 0){
                    resp = 0;
                    return resp;
                }
                scanner.nextLine();

                System.out.println("Digite o novo tipo para o item: ");
                tipo = scanner.nextLine();

                items.setId(id);
                items.setTipo(tipo.toUpperCase());
                items.setDataInsert(new Date());
                itemDAO.updateTipo(items);
            } else if (resp == 4) {
                String medida;
                int id;

                System.out.println("Digite o id do item que deseja atualizar(consultar visualização para encontrar ID ou digite o para voltar ao menu principal): ");
                id = scanner.nextInt();
                if(id == 0){
                    resp = 0;
                    return resp;
                }

                System.out.println("Digite a nova medida(UN,Kg,L) para o item: ");
                medida = scanner.nextLine();

                items.setId(id);
                items.setTipo(medida.toUpperCase());
                items.setDataInsert(new Date());
                itemDAO.updateMedida(items);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }

    //Método de excluir
    public void excluirItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do item que deseja excluir(consulte o ID na aba de visualização): ");
        int id = scanner.nextInt();

        itemDAO.deleteById(id);

    }

    //método de visualizar
    public void MostrarItens(int resp) {
        Scanner scanner = new Scanner(System.in);
        if (resp == 1) {
            System.out.println("=================================================================");
            System.out.println("ID\t\t NOME\t\t QUANTIDADE\t\t MEDIDA\t\tTIPO");
            for (Itens i : itemDAO.getItens()) {
                System.out.println(i.getId() + "\t\t " + i.getNome() + "\t\t\t " + i.getQuantidade() + "\t\t\t " + i.getMedida() + "\t\t\t " + i.getTipo());

            }
            System.out.println("=================================================================");
        } else if (resp == 2) {
            System.out.println("Digite o tipo dos item do estoque que deseja visualizar[carnes,frutas,...].");
            String tipo = scanner.nextLine();
            System.out.println("=================================================================");
            System.out.println("ID\t\t NOME\t\t QUANTIDADE\t\t MEDIDA\t\tTIPO");
            for (Itens i : itemDAO.getItemTipo(tipo)) {
                System.out.println(i.getId() + "\t\t\t " + i.getNome() + "\t\t\t " + i.getQuantidade() + "\t\t\t " + i.getMedida() + "\t\t\t " + i.getTipo());

            }
            System.out.println("=================================================================");
        } else if (resp == 3) {
            System.out.println("Digite o nome do item do estoque que deseja visualizar.");
            String nome = scanner.nextLine();
            System.out.println("=================================================================");
            System.out.println("ID\t\t NOME\t\t QUANTIDADE\t\t MEDIDA\t\tTIPO");
            for (Itens i : itemDAO.getItemNome(nome)) {
                System.out.println(i.getId() + "\t\t\t " + i.getNome() + "\t\t\t " + i.getQuantidade() + "\t\t\t " + i.getMedida() + "\t\t\t " + i.getTipo());

            }
            System.out.println("=================================================================");

        }else if(resp==4){
            System.out.println("Digite a quantidade disponível dos itens a serem visualizados[1 mostra itens com quantidade igual a 1,etc...]. ");
            int qntd = scanner.nextInt();
            System.out.println("=================================================================");
            System.out.println("ID\t\t NOME\t\t QUANTIDADE\t\t MEDIDA\t\tTIPO");
            for (Itens i : itemDAO.getItemQuantidade(qntd)) {
                System.out.println(i.getId() + "\t\t\t " + i.getNome() + "\t\t\t " + i.getQuantidade() + "\t\t\t " + i.getMedida() + "\t\t\t " + i.getTipo());

            }
            System.out.println("=================================================================");
        }

    }
}
