import Classes.Funcoes;
import Classes.Menus;
public class Main {
    public static void main(String[] args){
    Menus menus = new Menus();
    Funcoes funcoes = new Funcoes();
    int escolha=0;
    funcoes.lerArquivoDoDia();
    while(true){



    escolha = menus.menuEscolha();

    if(escolha == 1){
        menus.menuEscolhaLista();
    } else if(escolha == 2){
        menus.menuDataBase();
    }else if(escolha == 3){
        menus.menuAjuda();
    }












    }
  }
}
