/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
//import jdk.internal.util.Preconditions;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import mvc.control.Util;

/**
 *
 /* @ professor Eduardo Silvestre
 *  @author William de Sousa Mota
 *  @author Lucas Feitosa

 */
public class AtivoDAO {

    public Ativo[] ativos = new Ativo[50];
    Util util = new Util();
    Scanner scanner = new Scanner(System.in);

    public AtivoDAO() {
        Ativo d1 = new Ativo();
        Ativo d2 = new Ativo();
        Ativo d3 = new Ativo();
        Ativo d4 = new Ativo();
        Ativo d5 = new Ativo();
        Ativo d6 = new Ativo();
        Ativo d7 = new Ativo();
        Ativo d8 = new Ativo();
        Ativo d9 = new Ativo();
        Ativo d10 = new Ativo();
        Ativo d11 = new Ativo();
        Ativo d12 = new Ativo();

        BigDecimal precoInicial = BigDecimal.valueOf(100);

        this.adiciona(d1);
        this.adiciona(d2);
        this.adiciona(d3);
        this.adiciona(d4);
        this.adiciona(d5);
        this.adiciona(d6);
        this.adiciona(d7);
        this.adiciona(d8);
        this.adiciona(d9);
        this.adiciona(d10);
        this.adiciona(d11);
        this.adiciona(d12);

        d1.setNomeEmpresa("ITAÚSA");
        d1.setTicker("ITSA4");
        d1.setTotalAtivos("4");
        d1.setPrecoInicial(BigDecimal.valueOf(11.47));

        d2.setNomeEmpresa("BRADESCO");
        d2.setTicker("BBDC3");
        d2.setTotalAtivos("2");
        d2.setPrecoInicial(BigDecimal.valueOf(20.41));// é imutável o tal do big decimal - utilizar uma varável auxiliar

        d3.setNomeEmpresa("EDENRED BRASIL");
        d3.setTicker("ITAFE4");
        d3.setTotalAtivos("2");
        d3.setPrecoInicial(BigDecimal.valueOf(13.18));


        d4.setNomeEmpresa("SANEPAR");
        d4.setTicker("SAPR4");
        d4.setTotalAtivos("10");
        d4.setPrecoInicial(BigDecimal.valueOf(3.92));


        d5.setNomeEmpresa("SEGURIDADE ON NM");
        d5.setTicker("BBSE3");
        d5.setTotalAtivos("2");
        d5.setPrecoInicial(BigDecimal.valueOf(21.79));


        d6.setNomeEmpresa("WHIRLPOOL");
        d6.setTicker("WHLR4");
        d6.setTotalAtivos("5");
        d6.setPrecoInicial(BigDecimal.valueOf(8.75));


        d7.setNomeEmpresa("LOGÍSTICA FDO IN IMOB");
        d7.setTicker("HGLG11");
        d7.setTotalAtivos("1");
        d7.setPrecoInicial(BigDecimal.valueOf(167.21));


        d8.setNomeEmpresa("HEDGE INVESTMENTS");
        d8.setTicker("HFOF11");
        d8.setTotalAtivos("1");
        d8.setPrecoInicial(BigDecimal.valueOf(92.05));


        d9.setNomeEmpresa("HECTARE CI");
        d9.setTicker("HFOF11");
        d9.setTotalAtivos("1");
        d9.setPrecoInicial(BigDecimal.valueOf(127.25));


        d10.setNomeEmpresa("REAL ESTATE CAPITAL");
        d10.setTicker("RECR1");
        d10.setTotalAtivos("1");
        d10.setPrecoInicial(BigDecimal.valueOf(106.03));


        d11.setNomeEmpresa("COVEP RENDA FDO");
        d11.setTicker("GGRC11");
        d11.setTotalAtivos("1");
        d11.setPrecoInicial(BigDecimal.valueOf(115.91));


        d12.setNomeEmpresa("BANRISUL NOVAS FRONTEIRAS");
        d12.setTicker("BNFS11");
        d12.setTotalAtivos("1");
        d12.setPrecoInicial(BigDecimal.valueOf(124.80));


    }

    public boolean adiciona(Ativo c) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            ativos[proximaPosicaoLivre] = c;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Ativo user : ativos) {
            if (user != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temAtivo = false;
        for (Ativo user : ativos) {
            if (user != null) {
                System.out.println(user);
                temAtivo = true;
            }
        }
        if (!temAtivo) {
            System.out.println("\n Não existe ativos cadastrado\n");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Ativo user : ativos) {
            if (user != null && user.getNomeEmpresa().equals(nome)) {
                user.setNomeEmpresa(novoNome);
                return true;
            }
        }
        return false;

    }

    public Ativo buscaPorNome(String nomeEmpresa) {
        for (Ativo disciplina : ativos) {
            if (disciplina != null && disciplina.getNomeEmpresa().equals(nomeEmpresa)) {
                return disciplina;
            }
        }
        return null;
    }

    public Ativo buscaAtivoPorId(long id) {
        for (int i = 0; i < ativos.length; i++) {
            if (ativos[i] != null && ativos[i].getId() == id) {
                return ativos[i];
            }
        }
        return null;
    }

    public boolean remover(long id, long user) {
        if (user == id) {
            return false;
        } else {
            for (int i = 0; i < ativos.length; i++) {
                if (ativos[i].getId() == id) {
                    ativos[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < ativos.length; i++) {
            if (ativos[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public boolean buscaPorTicker(String ticker) {
        for (int i = 0; i < ativos.length; i++) {
            if (ticker.equals(ticker)) {
                return true;
            }
        }
        return false;
    }

    public StringBuilder mostraAtivo() {
        StringBuilder a = new StringBuilder();
        a.append("");

        boolean achouAtivo = false;
        for (Ativo ativo : ativos) {
            if (ativo != null) {
                a.append(ativo.toString() + "\n\n");
                achouAtivo = true;
            }

        }

        if (!achouAtivo) {
            a.append("Não ha ativos cadastrados");

        }
        return a;
    }

    public boolean validaId(long id) {
        for (int i = 0; i < ativos.length; i++) {
            if (ativos[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean ehAdm(long id) {
        int tipo;
        for (int i = 0; i < ativos.length; i++) {
            if (ativos[i] != null && ativos[i].getId() == id) {
                tipo = ativos[i].getTipoUser();
                if (tipo == 1) {
                    return true;
                }
            }
        }
        return false;
    }
      

    public boolean alterarAtivo(String nome, String novoNome) {
        for (Ativo user : ativos) {
            if (user != null && user.getNomeEmpresa().equals(nome)) {
                user.setNomeEmpresa(novoNome);
                return true;
            }
        }
        return false;

    }

    public void listaAtivos() {
        boolean temAtivo = false;
        for (Ativo user : ativos) {
            if (user != null) {
                System.out.println("| " + util.textoColuna(String.valueOf(user.getId()), 5) + " | " + util.textoColuna(user.getNomeEmpresa(), 26) + " | ");
                temAtivo = true;
            }
        }
        if (!temAtivo) {
            System.out.println("\n Não existe usuário cadastrado\n");
        }
    }

    public int quantAtivos() {
        int qt = 0;
        for (Ativo user : ativos) {
            if (user != null) {
                qt = qt + 1;
            }
        }
        return qt;
    }
    
      public String buscaTipo(int tipo){
        if (tipo == 1){
            return "Administrador";
        }else if (tipo == 2){
            return "Cliente";
        }else if (tipo == 3){
            return "Cliente 2";
        }else{
            return null;
        }
    }


}
