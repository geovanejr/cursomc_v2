package br.com.geovanejunior.cursomc.domain.utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class FormataDados {

    public String formataValor(Double valor) {

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(valor);
    }

    public String formataData(Date data) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
        return sdf.format(data);
    }
}
