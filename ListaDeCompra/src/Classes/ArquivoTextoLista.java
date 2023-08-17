package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ArquivoTextoLista {
    Datas data = new Datas();
    private Integer mes = data.getMes();

    private Integer dia = data.getDia();
    private String mesExtenso = Integer.toString(mes);
    private String diaExtenso = Integer.toString(dia);
    String nomeArquivo = new String();

    public ArquivoTextoLista(){
        this.nomeArquivo = "Lista de compras "+diaExtenso+"-"+mesExtenso;
    }

    //criando caminho do arquivo
    public Path caminhoArquivo() {
        Path caminho = Paths.get("C:\\CAMNHIO"+this.nomeArquivo+".txt");
        return (caminho);
    }

    //método para verificar se o arquivo existe
    public boolean verificaExistencia(){
        Path caminho = caminhoArquivo();
        boolean existe = Files.exists(caminho);
        return (existe);
    }

    //método para escrever o aqruivo com base na Arraylist
    public void escreveArquivo(List<String> list1, List<String> list2,List<String> list3,List<String> list4 ){
        Path caminho = caminhoArquivo();
        String caminhoTexto = String.valueOf(caminho);
        try{
            FileWriter escrever = new FileWriter(caminhoTexto);
            BufferedWriter buff = new BufferedWriter(escrever);
            buff.write("Itens\t-\t\tQuantidade\t-\t\tMedida\t-\t\ttipo");
            buff.newLine();
            for(int i=0; i< list1.size(); i++){
                buff.write(list1.get(i) + "\t - \t\t"+list2.get(i)+ "\t - \t\t"+list3.get(i)+ "\t - \t\t"+list4.get(i));
                buff.newLine();
            }
            buff.flush();
            buff.close();
        }catch(Exception e){
            System.out.println("Lista escrita com sucesso!");
        }

    }

    public void lerArquivo(List<String> list1, List<String> list2,List<String> list3,List<String> list4 ){
       Path caminho = caminhoArquivo();

       String caminhoTexto = String.valueOf(caminho);

       File arquivo = new File(caminhoTexto);

       String texto = new String();
        try{
            Scanner scanner = new Scanner(arquivo);
            scanner.nextLine(); // exluindo primeira linha ja n é necessária
            while(scanner.hasNext()){
                texto = scanner.nextLine();

                String[] parte = texto.split("-");
                list1.add(parte[0]);
                list2.add(parte[1]);
                list3.add(parte[2]);
                list4.add(parte[3]);
            }
        }catch(Exception e){}

    }

}
