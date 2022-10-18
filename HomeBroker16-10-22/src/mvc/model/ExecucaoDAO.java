/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import mvc.control.Util;

/**
 *
 /* @ professor Eduardo Silvestre
 *  @author William de Sousa Mota
 *  @author Lucas Feitosa

 */
public class ExecucaoDAO {
    
    public Execucao[] execucao = new Execucao[10];
    Util util = new Util();
    
    

    
     public ExecucaoDAO() {
        Execucao d1 = new Execucao();
        Execucao d2 = new Execucao();
        Execucao d3 = new Execucao();
        this.adiciona(d1);
        
        
        d1.setContaCompra("001");
        d1.setContaVenda("888");
        d1.setDataModificacao();
        d1.setQtde("5");
        d1.setTipoOrdem("Venda");
        
        
        d2.setContaCompra("002");
        d2.setContaVenda("882");
        d2.setDataModificacao();
        d2.setQtde("6");
        d2.setTipoOrdem("Compra");
        
        d3.setContaCompra("003");
        d3.setContaVenda("883");
        d3.setDataModificacao();
        d3.setQtde("7");
        d3.setTipoOrdem("Venda");
        
     
        
       
     }

    public ExecucaoDAO(ExecucaoDAO execDAO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public boolean adiciona(Execucao u) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            execucao[proximaPosicaoLivre] = u;
            return true;
        } else {
            return false;
        }
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < execucao.length; i++) {
            if (execucao[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean remover(long id, long user) {
        if (user == id) {
            return false;
        } else {
            for (int i = 0; i < execucao.length; i++) {
                if (execucao[i].getId() == id) {
                    execucao[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
    
    

    public boolean ehAdm(long id) {
         int tipo;
        for (int i = 0; i < execucao.length; i++) {
            if (execucao[i] != null && execucao[i].getId() == id) {
                tipo = execucao[i].getTipoUsuario();
                if (tipo == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrarTodos() {
        boolean temExecucao = false;
        for (Execucao user : execucao) {
            if (user != null) {
                System.out.println(user);
                temExecucao = true;
            }
        }
        if (!temExecucao) {
            System.out.println("\n Não existe usuário cadastrado\n");
        }
    }
    
    }




    
    
    

