package intens.dao;
import Factory.ConnectionFactory;
import Itens.model.Itens;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItensDAO {
    /*
    CRUD
    c: create - feito
    r: read - feito
    u: update - feito
    d: delete - feito
     */
    //método para salvar itens na DB
    public void save(Itens item){

        String sql = "INSERT INTO itens(nome, quantidade, medidas, tipo, datainsert) VALUES(?, ?, ?, ?, ?)";


        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //criar uma conexão com a databse
            conn = ConnectionFactory.createConnectionToMySQL();
            // prepareStatement para criar uma query
            pstm = conn.prepareStatement(sql);

            //adicionar os valores que são esperados pela query
            pstm.setString(1, item.getNome());
            pstm.setDouble(2, item.getQuantidade());
            pstm.setString(3,item.getMedida());
            pstm.setString(4, item.getTipo());
            pstm.setDate(5,new Date(item.getDataInsert().getTime()));

            //executar a query
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //fechar conexões
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }


            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    //método pegar item por tipo
     public List<Itens> getItemTipo(String tipo){

        String slq="SELECT * FROM itens WHERE tipo ="+"'"+ tipo.toUpperCase()+"'";

        List<Itens> itens = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(slq);

            rset= pstm.executeQuery();


            while (rset.next()){
                Itens itemNovo = new Itens();

                //pegando id
                itemNovo.setId(rset.getInt("id"));
                //pegando nome
                itemNovo.setNome(rset.getString("nome"));
                //pegando quantidade
                itemNovo.setQuantidade(rset.getDouble("quantidade"));
                //pegando medida
                itemNovo.setMedida(rset.getString("medidas"));
                //pegando tipo
                itemNovo.setTipo(rset.getString("tipo"));
                //pegando data
                itemNovo.setDataInsert(rset.getDate("dataInsert"));

                itens.add(itemNovo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    return itens;
}

    //método para pegar todos os itens da db
    public List<Itens> getItens(){

        String slq="SELECT * FROM itens" ;

        List<Itens> itens = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(slq);

            rset= pstm.executeQuery();


            while (rset.next()){
                Itens itemNovo = new Itens();

                //pegando id
                itemNovo.setId(rset.getInt("id"));
                //pegando nome
                itemNovo.setNome(rset.getString("nome"));
                //pegando quantidade
                itemNovo.setQuantidade(rset.getDouble("quantidade"));
                //pegando medida
                itemNovo.setMedida(rset.getString("medidas"));
                //pegando tipo
                itemNovo.setTipo(rset.getString("tipo"));
                //pegando data
                itemNovo.setDataInsert(rset.getDate("dataInsert"));

                itens.add(itemNovo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }


        return itens;
    }

    //método para pegar itens por id
    public List<Itens> getItemNome(String nome){

        String slq="SELECT * FROM itens WHERE tipo ="+"'"+ nome.toUpperCase()+"'";

        List<Itens> itens = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(slq);

            rset= pstm.executeQuery();


            while (rset.next()){
                Itens itemNovo = new Itens();

                //pegando id
                itemNovo.setId(rset.getInt("id"));
                //pegando nome
                itemNovo.setNome(rset.getString("nome"));
                //pegando quantidade
                itemNovo.setQuantidade(rset.getDouble("quantidade"));
                //pegando medida
                itemNovo.setMedida(rset.getString("medidas"));
                //pegando tipo
                itemNovo.setTipo(rset.getString("tipo"));
                //pegando data
                itemNovo.setDataInsert(rset.getDate("dataInsert"));

                itens.add(itemNovo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }


        return itens;
    }

    //método para pegar itens através da quantidade
    public List<Itens> getItemQuantidade(int qntd){

        String slq="SELECT * FROM itens WHERE tipo ="+qntd;

        List<Itens> itens = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(slq);

            rset= pstm.executeQuery();


            while (rset.next()){
                Itens itemNovo = new Itens();

                //pegando id
                itemNovo.setId(rset.getInt("id"));
                //pegando nome
                itemNovo.setNome(rset.getString("nome"));
                //pegando quantidade
                itemNovo.setQuantidade(rset.getDouble("quantidade"));
                //pegando medida
                itemNovo.setMedida(rset.getString("medidas"));
                //pegando tipo
                itemNovo.setTipo(rset.getString("tipo"));
                //pegando data
                itemNovo.setDataInsert(rset.getDate("dataInsert"));

                itens.add(itemNovo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }


        return itens;
    }

    //métodos para atualizar a DB
    public  void updateQuantidade(Itens item){

        String sql = "UPDATE itens SET quantidade = ?, dataInsert = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn =  ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setDouble(1,item.getQuantidade());
            pstm.setDate(2, new Date(item.getDataInsert().getTime()));
            pstm.setInt(3,item.getId());


            pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();

                }

            }catch(Exception e ){
                e.printStackTrace();
            }

        }
    }

    public  void updateNome(Itens item){

        String sql = "UPDATE itens SET nome = ?, dataInsert = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn =  ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1,item.getNome());
            pstm.setDate(2, new Date(item.getDataInsert().getTime()));
            pstm.setInt(3,item.getId());


            pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();

                }

            }catch(Exception e ){
                e.printStackTrace();
            }

        }
    }

    public  void updateTipo(Itens item){ //mudar para update TIPO

        String sql = "UPDATE itens SET tipo = ?, dataInsert = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn =  ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1,item.getTipo());
            pstm.setDate(2, new Date(item.getDataInsert().getTime()));
            pstm.setInt(3,item.getId());


            pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();

                }

            }catch(Exception e ){
                e.printStackTrace();
            }

        }
    }

    public  void updateMedida(Itens item){

        String sql = "UPDATE itens SET medidas = ?, dataInsert = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn =  ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1,item.getMedida());
            pstm.setDate(2, new Date(item.getDataInsert().getTime()));
            pstm.setInt(3,item.getId());


            pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();

                }

            }catch(Exception e ){
                e.printStackTrace();
            }

        }
    }

    //método para excluir itens da DB
    public void deleteById(int id){
        String sql ="DELETE FROM itens WHERE id = ?";

        Connection conn = null;

        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1,id);

            pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(conn!=null){
                    conn.close();
                }
                if (pstm!=null){
                    pstm.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
