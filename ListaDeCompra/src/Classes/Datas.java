package Classes;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Datas {
        //craindo variavel de data
        Date date = new Date();
        // Criando variável para receber a data local baseada na zona do sistema
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        public int getMes(){
        int mes = localDate.getMonthValue();
        return mes;
        }

    public int getDia(){
        int dia = localDate.getDayOfMonth();
        return dia;
    }


    }

