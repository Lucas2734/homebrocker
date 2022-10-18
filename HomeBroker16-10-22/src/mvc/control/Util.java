/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.control;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import mvc.model.Cliente;
import mvc.model.Ativo;
import mvc.model.ContaCorrente;
/**
 * @ professor Eduardo Silvestre
 * @author william de Sousa Mota
 */
public class Util {

    private static Cliente clienteLogado = null;
    private static Ativo ativoLogado = null;
    private static ContaCorrente contaLogada = null;
    private static LocalDateTime dateTime = LocalDateTime.now();
    
    
    static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");
    public static Object doubleToString;
    
    public static String doubleToString(Double valor){
        return formatandoValores.format(valor);
}

    public static void registraCliente(Cliente cliente) {
        clienteLogado = cliente;
    }

    public static Cliente pegaClienteLogado() {
        return clienteLogado;
    }
    
    public static LocalDateTime incrementaDias(long qtdDias) {
        dateTime = dateTime.plusDays(qtdDias);
        return dateTime;
    }
    
    public static LocalDateTime pegaDataAtual() {
        return dateTime;
    }

    public static void registraAtivo(Ativo ativo) {
        ativoLogado = ativo;
    }
    public static Ativo pegaAtivoLogado() {
       return ativoLogado;
    }

    public static  ContaCorrente pegaContaLogada() {
         return contaLogada;
    }
    
     public static void registraConta(ContaCorrente conta) {
        contaLogada = conta;
    }

   

    public String FormataData(LocalDateTime data) {
        if (data == null) {
            return "";
        }
        DateTimeFormatter formata = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String agoraFormatado = data.format(formata);
        return agoraFormatado;
    }

    public String FormataApenasData(LocalDate data) {
        if (data == null) {
            return "";
        }
        DateTimeFormatter formata = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String agoraFormatado = data.format(formata);
        return agoraFormatado;
    }

    public LocalDate stringParaData(String data) {
        LocalDate result = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return result;
    }

    public String ValidaVazio(String texto) {
        if (texto == null) {
            return "";
        }
        return texto;
    }

    public boolean validaData(String data, int st) {
        if (data.isEmpty() && st != 0) {
            return true;
        }

        if (data.length() != 10) {
            return false;
        }

        int ano = Integer.parseInt(data.substring(6, 10));
        int mes = Integer.parseInt(data.substring(3, 5));
        int dia = Integer.parseInt(data.substring(0, 2));
        if (ano > 2000 && ano < 2040) {
            int testeAno = ano % 4;
            boolean anoBi;
            if (testeAno == 0) {
                anoBi = true;
            } else {
                anoBi = false;
            }
            if (mes >= 1 && mes <= 12) {
                if (mes == 2 && anoBi) {
                    if (dia >= 1 && dia <= 29) {
                        return true;
                    }
                } else {
                    if (mes == 2 && !anoBi) {
                        if (dia >= 1 && dia <= 28) {
                            return true;
                        }
                    } else {
                        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                            if (dia >= 1 && dia <= 31) {
                                return true;
                            }
                        } else {
                            if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                                if (dia >= 1 && dia <= 30) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String textoColuna(String tx, int tm) {
        String[] palavras = tx.split("");
        if (tx.length() > tm) {
            String texto = "";
            for (int i = 0; i < tm; i++) {
                texto = texto + palavras[i];
            }
            return texto;
        } else if (tx.length() < tm) {
            int calc = tm - tx.length();
            String comp = tx;
            for (int i = 0; i < calc; i++) {
                comp = comp + " ";
            }
            return comp;
        } else {
            return tx;
        }
    }

    public String textoGrande(String tx, int tm) {
        String[] palavras = tx.split("");
        if (tx.length() > tm) {
            String texto = "";
            int tamQuebra = 0;
            for (int i = 0; i < tx.length(); i++) {
                if (tamQuebra == tm) {
                    texto = texto + " \n " + palavras[i];
                    tamQuebra = 1;
                } else {
                    texto = texto + palavras[i];
                    tamQuebra = tamQuebra + 1;
                }
            }
            return texto;
        } else if (tx.length() < tm) {
            int calc = tm - tx.length();
            String comp = tx;
            for (int i = 0; i < calc; i++) {
                comp = comp + " ";
            }
            return comp;
        } else {
            return tx;
        }
    }

}
