package Classes;
import java.util.Scanner;
public class Menus {
    public Menus(){}
    Funcoes funcoes = new Funcoes();
    FuncoesDB db = new FuncoesDB();
    public int menuEscolha(){
        int resp=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("Bem vindo ao menu de escolha");
        System.out.println("1-Editar e verificar a lista de compra");
        System.out.println("2-verificar e editar os itens em estoque");
        System.out.println("3-Ajuda");
        System.out.println("================================");
        try {
            System.out.println("Por favor, selecione uma das opções acima: ");
             resp = scanner.nextInt();
            if((resp > 3)){
                System.out.println("Valor invalido, tente novamente: ");
                menuEscolha();
            }
        }
        catch (Exception e) {

        }

        return resp;

    }

    public int menuEscolhaLista(){
        Scanner scanner = new Scanner(System.in);
        int resp=0,volta=0;

        System.out.println("Bem vindo ao menu de escolha da lista de compras");
        System.out.println("1-Adicionar item à lista de compra");
        System.out.println("2-Remover item da lista de compra");
        System.out.println("3-Verificar a lista de compras");
        System.out.println("4-Editar Lista de compras");
        try {
            System.out.println("Por favor, selecione uma das opções acima(Digite 0 para voltar ao menu principal): ");
            resp = scanner.nextInt();
            if((resp > 4)){
                System.out.println("Valor invalido, tente novamente: ");
                menuEscolhaLista();
            }else if(resp ==0){
                return resp;
            }else if(resp == 1){
                volta = funcoes.adicionarItem();
                // se  a função voltar 1 é porque o usuário decidiu voltar ao menu principal, se aplica a todas os 4 métodos
                if (volta == 1){
                    resp = 0; return resp;
                }
            }else if(resp == 2){
                volta = funcoes.excluirItem();
                if (volta == 1){
                    resp = 0; return resp;
                }
            }else if(resp == 3){
                funcoes.verificarLista();
            }else if(resp == 4){
                volta = menuEditarLista();
                if(volta==0){
                    resp = 0; return resp;
                }
            }
        }
        catch (Exception e) {

        }
        return resp;
    }

    public int menuEditarLista(){
        int resp = 0, volta=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.printf("Menu Editar Lista\n1 - Mudar nome de um produto da lista\n2 - Mudar quantidade de um produto da lista\n3 - Mudar nome, quantidade e tipo de um produto da lista\n");
        System.out.println("================================");
        try {
            System.out.println("Por favor, selecione uma das opções acima(digite 0 para voltar ao menu principal): ");
            resp = scanner.nextInt();
            if((resp > 3)){
                System.out.println("Valor invalido, tente novamente: ");
                menuEditarLista();
            }else if(resp ==1){
                volta = funcoes.editarNome();
                if (volta == 1){
                    resp = 0; return resp;
                }
            }else if(resp == 2){
                volta = funcoes.editarQntd();
                if (volta == 1){
                    resp = 0; return resp;
                }
            }else if(resp == 3){
                volta = funcoes.editarNomeQntdTipo();
                if (volta == 1){
                    resp = 0; return resp;
                }
            }
        }
        catch (Exception e) {

        }

        return resp;
    }

    public int menuAjuda(){
        int resp = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("MENU DE AJUDA:");
        System.out.println("1-Adicionar item à lista de compra");
        System.out.println("2-Remover item da lista de compra");
        System.out.println("3-Verificar a lista de compra");
        System.out.println("4-Editar Lista de compras");
        System.out.println("5-Verificar os itens em estoque");
        System.out.println("6-Editar os itens em estoque");
        System.out.println("Digite o número do item que deseja consultar(ou digite 0 para voltar ao menu pricncipal): ");
       try{
        resp = scanner.nextInt();
        if(resp>6){
            System.out.println("Valor inválido, tente novamente");
            menuAjuda();
        } else if(resp == 0){
            return resp;
        }else{
            funcoes.ajuda(resp);
            menuAjuda();
        }
       }catch (Exception e){

       }
     return resp;
    }

    public int menuVerDataBase(){
        int resp =0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Visualizar todos os itens do estoque");
        System.out.println("2 - Visualizar itens  do estoque por tipo[carnes, vegetais, etc]");
        System.out.println("3 - Visualizar itens do estoque por nome");
        System.out.println("4 - Visualizar itens do estoque por quantidade");
        System.out.println("Digite o tipo visualização de itens que deseja(Digite 0 para voltar ao menu principal): ");
        try{
            resp = scanner.nextInt();
            if(resp>4){
                System.out.println("Valor inválido, tente novamente");
                menuVerDataBase();
            } else if(resp == 0){
                return resp;
            }else{
                db.MostrarItens(resp);
                menuVerDataBase();
            }
        }catch (Exception e){

        }


        return resp;
    }

    public int menuEditarDataBase(){
        int resp =0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("1 - Adicionar item ao estoque");
        System.out.println("2 - Editar item do estoque");
        System.out.println("3 - excluir item do estoque");
        System.out.println("Digite o tipo visualização de itens que deseja(Digite 0 para voltar ao menu principal): ");
        try{
            resp = scanner.nextInt();
            if(resp>3){
                System.out.println("Valor inválido, tente novamente");
                menuEditarDataBase();
            } else if(resp == 0){
                return resp;
            }else if(resp == 1){
                db.adicionarItemDataBase();
            }else if(resp == 2){
                db.editarItem();
            }else if(resp == 3){
                db.excluirItem();
            }
        }catch (Exception e){

        }


        return resp;
    }

    public int menuDataBase(){
        int resp =0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Editar itens do estoque");
        System.out.println("2 - Visualizar itens  do estoque");
        System.out.println("Digite o tipo visualização de itens que deseja(Digite 0 para voltar ao menu principal): ");
        try{
            resp = scanner.nextInt();
            if(resp>2){
                System.out.println("Valor inválido, tente novamente");
                menuDataBase();
            } else if(resp == 0){
                return resp;
            }else if(resp == 1){
                menuEditarDataBase();
            }else if(resp == 2){
                menuVerDataBase();
            }
        }catch (Exception e){

        }


        return resp;


    }


}
