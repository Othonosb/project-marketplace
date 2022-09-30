// CRIANDO UM UTILITARIO.CONJUNTO DE FUNÇÕES QUE VAI AJUDAR.
package helper;

import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Utils {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static NumberFormat nf = new DecimalFormat("R$ #, ##0.00",
            new DecimalFormatSymbols(new Locale("pt","BR")));

    public static String dateParaString(Date data){
        return Utils.sdf.format(data);
    }

    public static String doubleParaString(Double valor){
        return Utils.nf.format(valor);
    }

    public static Double stringParaDouble(String valor){
        try{
            return (Double)Utils.nf.parse(valor);
        }catch (ParseException e){
            return null;
        }
    }

    public static void pausar(int segundos){
        try{
            TimeUnit.SECONDS.sleep(segundos);
        }catch (InterruptedException e){
            System.out.println("Erro ao pausar por " + segundos + "segundos.");
        }
    }




}

/*

    Uso do SimpleDateFormat -> Serve para configurar data.
    Uso do DecimalFormat -> Serve para pegar um valor double e tranformar para reais no formato texto.
    Uso de Try/Catch -> Por que precisa tratar as exceões checadas.

*/
