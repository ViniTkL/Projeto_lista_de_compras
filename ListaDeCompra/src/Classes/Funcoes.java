package Classes;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Itens.model.Itens;
import intens.dao.ItensDAO;

public class Funcoes {
    /*

    Falta FAZER:
    resolver problema em add item que está adicionando duas vezes quando se aperta o valor diferente de 1 ou 0


     */

     private List lista = new ArrayList<String>();
    private List listaQntd = new ArrayList<String>();

    private List listaTipo= new ArrayList<String>();
    private List listaMedida= new ArrayList<String>();
    ArquivoTextoLista arquivo = new ArquivoTextoLista();

    public int adicionarItem(){
        int volta = 0;
        Scanner scanner = new Scanner(System.in);

        double qntdD = 0;
        int qntdI=0;

        System.out.println("Digite o item que deseja adicionar à lista(Digite SAIR caso queira voltar ao menu principal): ");
        String item = scanner.nextLine();

        if(item.toLowerCase().equals("sair")){
            volta =1;
            return volta;
        }

        System.out.println("Digite o tipo do seu item(Ex.: Carne, frios, verduras,etc...)");
        String tipo = scanner.nextLine();

        System.out.println("Digite a medida do item a ser comprado[UN,Kg,g,L,ml]:" );
        String medida = scanner.nextLine();

        if(medida.equalsIgnoreCase("kg") || medida.equalsIgnoreCase("g") || medida.equalsIgnoreCase("L") || medida.equalsIgnoreCase("Ml")){
            System.out.println("Digite a quantidade do item a ser comprado: ");
            qntdD = scanner.nextDouble();
        }else if(medida.equalsIgnoreCase("un") || medida.equalsIgnoreCase("fardo") || medida.equalsIgnoreCase("caixa")){
            System.out.println("Digite a quantidade do item a ser comprado: ");
            qntdI = scanner.nextInt();
        }




        confirmacaoAdicaoItem(item, qntdD, qntdI,tipo, medida);



        return volta;
    }

    public int confirmacaoAdicaoItem( String item, double qntdD, int qntdI,String tipo,String medida){
        int volta =0, loop = 0, confirm=0;
        Scanner scanner = new Scanner(System.in);
        if(qntdD !=0){
        System.out.printf("Item: %s - quantidade: %.2f\nDeseja confirmar?(1 para Sim/0 para Não): ",item,qntdD);
          confirm = scanner.nextInt();
        }else if(qntdI !=0){
            System.out.printf("Item: %s - quantidade: %d\nDeseja confirmar?(1 para Sim/0 para Não): ",item,qntdI);
            confirm = scanner.nextInt();
        }

        if(confirm == 1 && qntdD !=0){
            //Aqui o item vai ser adicionado à ArrayList
            volta = 1;
            System.out.println("Item adicionado.");
            lista.add(item.toUpperCase());
            listaQntd.add(String.valueOf(qntdD));
            listaTipo.add(tipo.toUpperCase());
            listaMedida.add(medida.toUpperCase());



            int index = lista.indexOf(item.toUpperCase());
            System.out.println(listaQntd.get(index) +" "+ lista.get(index));
        }else if(confirm == 1 && qntdI !=0){
            //Aqui o item vai ser adicionado à ArrayList
            volta = 1;
            System.out.println("Item adicionado.");
            lista.add(item.toUpperCase());
            listaQntd.add(String.valueOf(qntdI));
            listaTipo.add(tipo.toUpperCase());
            listaMedida.add(medida.toUpperCase());



            int index = lista.indexOf(item.toUpperCase());
            System.out.println(listaQntd.get(index) +" "+ lista.get(index));
        } else if(confirm == 0){
            volta = 1;
            //Ver se vale a pena so voltar ao menu principal ou deixar o usuario digitar novamente o item
            System.out.println("Item não adicionado.");
        }
        else if((confirm != 1) && (confirm != 0)){
            System.out.println("Valor inválido, tente novament: ");
            while((confirm != 1) && (confirm != 0) && (loop == 0)){
                loop = confirmacaoAdicaoItem( item, qntdD,qntdI,tipo,medida);
                confirm = loop;
            }
        }
        return volta;
    }
    //método para removerr o nome quantidade e tipo do item de uma posição do ArryList
    public int excluirItem(){
        int volta=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome item que deseja remover ou digite SAIR para voltar ao menu principal: ");
        String item = scanner.nextLine();

        if(item.toLowerCase().equals("sair")){
            volta =1;
            return volta;
        }

        try {
            if (!lista.contains(item.toUpperCase())) {
                System.out.println("Item não adicionado na lista, tente novamente:.");
                excluirItem();
            }

            int posicao = lista.indexOf(item.toUpperCase());


            lista.remove(posicao);
            listaQntd.remove(posicao);
            listaTipo.remove(posicao);
            listaMedida.remove(posicao);

        }
        catch (Exception e){

        }



        return volta;
    }
    //método para visualizar todas as posições do ArrayList
    public void verificarLista(){
        System.out.println("=================================================");
        System.out.println("Item\t-\tQuantidade\t-\tMedida\t-\tTipo");
        for(int i=0;i<lista.size();i++){
            System.out.println(lista.get(i) + "\t-\t"+listaQntd.get(i)+"\t-\t"+listaMedida.get(i)+"\t-\t"+listaTipo.get(i));

        }
    }

    public int editarNome(){


        Scanner scanner = new Scanner(System.in);
        int volta = 0;
        System.out.println("Digite o nome do item que deseja renomear(Digite SAIR caso queira voltar ao menu principal): ");
        String nome = scanner.nextLine();

        if(!lista.contains(nome.toUpperCase())){
            System.out.println("Item não encontrado.");
            volta = 1;
            return volta;
        }
        else if(nome.toLowerCase().contains("sair")){
            volta = 1;
            return volta;
        }

        int posicao = lista.indexOf(nome.toUpperCase());
        System.out.printf("Nome atual: %s\nDigite o novo nome do item %s: ",lista.get(posicao), nome);
        String novoNome = scanner.nextLine();




        lista.set(posicao,novoNome.toUpperCase());
        System.out.printf("Nome alterado para: %s\n",lista.get(posicao));

        return volta;
    }
    //método para editar o nome do item de um posição do ArryList
    public int editarQntd(){


        Scanner scanner = new Scanner(System.in);
        int volta = 0;
        System.out.println("Digite o nome do item que deseja alterar a quantidade(Digite SAIR caso queira voltar ao menu principal): ");
        String nome = scanner.nextLine();

        if(!lista.contains(nome.toUpperCase())){
            System.out.println("Item não encontrado.");
            volta = 1;
            return volta;
        } else if(nome.toLowerCase().contains("sair")){
            volta = 1;
            return volta;
        }


        int posicao = lista.indexOf(nome.toUpperCase());
        System.out.printf("Quantidade atual: %s\nDigite a nova quantidade do item %s: ",listaQntd.get(posicao), nome);
        double novaQntd = scanner.nextDouble();




        listaQntd.set(posicao,String.valueOf(novaQntd));
        System.out.printf("Quantidade do item %S alterada para %s\n",nome, listaQntd.get(posicao));

        return volta;
    }
    //método para editar o nome quantidade e tipo do item de um posição do ArryList
    public int editarNomeQntdTipo(){


        int volta = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do item que deseja renomear e alterar a quantidade(Digite SAIR caso queira voltar ao menu principal): ");
        String nome = scanner.nextLine();

        if(!lista.contains(nome.toUpperCase())){
            System.out.println("Item não encontrado.");
            volta = 1;
            return volta;
        } else if(nome.toLowerCase().contains("sair")){
            volta = 1;
            return volta;
        }

        int posicao = lista.indexOf(nome.toUpperCase());
        System.out.printf("Nome atual: %s\nDigite o novo nome do item: ",lista.get(posicao));
        String novoNome = scanner.nextLine();
        lista.set(posicao,novoNome.toUpperCase());





        System.out.printf("Quantidade atual: %s\nDigite a nova quantidade do item %s: ",listaQntd.get(posicao), nome);
        double novaQntd = scanner.nextDouble();



        listaQntd.set(posicao,String.valueOf(novaQntd));
        scanner.nextLine();

        System.out.println("Digite o novo tipo do produto: ");
        String tipo=  scanner.nextLine();

        listaTipo.set(posicao,tipo);



        System.out.printf("Nome: %s\tQuantidade: %.2f\n",lista.get(posicao),listaQntd.get(posicao));


        return volta;
    }

    //método para escrever o aqruivo com base na Arraylist
    public void escreveArquivo(){
       arquivo.escreveArquivo(lista,listaQntd,listaMedida,listaTipo);
    }

    //método ajuda
    public void ajuda(int resp){

        if(resp == 1){
            System.out.println("=================================================================");
            System.out.println("1 - adiciona um item na sua lista de compras, necessário digitar nome do produto e quantidade");
            System.out.println("=================================================================");
        }else if(resp == 2){
            System.out.println("=================================================================");
            System.out.println("2 - Remove um item complemtamente da sua lista de compras, necessário digitar nome do produto");
            System.out.println("=================================================================");
        }else if(resp == 3){
            System.out.println("=================================================================");
            System.out.println("3 - Mostra os item de sua lista e suas respectivas quqntidade");
            System.out.println("=================================================================");
        }else if(resp == 4){
            System.out.println("=================================================================");
            System.out.println("4 - Editar a lista de comprar: 1 - Editar somente o nome de um item, 2 - Editar somente a quantidade de um item, 3 - Editar nome quantidade de um item");
            System.out.println("=================================================================");
        }else if(resp == 5){
            System.out.println("=================================================================");
            System.out.println("5 - Gera um arquivo de texto(.txt) no seu computador para você poder consultar ou imprimir a lista, caso necessário");
            System.out.println("=================================================================");
        }else if(resp == 6){
            System.out.println("=================================================================");
            System.out.printf("Consulta o banco de dados para verficar os itens do estoque, possui 4 opções:\n" +
                    "1- visualizar todos os itens do banco de dados\n" +
                    "2 - visulaizar os itens do banco de dados filtrados por meio do tipo deles[carnes, frios, etc...]\n" +
                    "3- visulaizar os itens do banco de dados por filtrados por nome\n" +
                    "4 - visualizar os itens do banco de dados filtrados por quantidade\n");
            System.out.println("=================================================================");
        }else if(resp== 7){
            System.out.println("=================================================================");
            System.out.printf("Função para editar o banco de dados, possui 3 opções:\n" +
                    "1 - Adicionar um item ao banco de dados, para isso deve-se inserir: nome, tipo, medida e quantidade\n" +
                    "2 - Edita um item do banco de dados, possui opção de editar o nome, quantidade, tipo e medida do item\n" +
                    "3 - remove um item do banco de dados através de seu ID, que pode ser consultado na aba de visualização de itens\n");

            System.out.println("=================================================================");
        }
    }

    public void lerArquivoDoDia(){
        if(arquivo.verificaExistencia()){
            arquivo.lerArquivo(lista,listaQntd,listaMedida,listaTipo);
        }
    }





}
