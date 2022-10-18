/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Scanner;
import mvc.control.Util;
import java.time.format.DateTimeFormatter;

/* @ professor Eduardo Silvestre
 *  @author William de Sousa Mota
 *  @author Lucas Feitosa

 */


public class ContaCorrenteDAO {

    public ContaCorrente[] contacorrente= new ContaCorrente[50];
     Util util = new Util();
    Scanner scanner = new Scanner(System.in);
    
     

    public ContaCorrenteDAO() {
        
  //      ContaCorrente u1 = new ContaCorrente();
 //       u1.setCliente(Util.pegaClienteLogado());
//        ContaCorrente u2 = new ContaCorrente();
//        ContaCorrente u3 = new ContaCorrente();
//        ContaCorrente u4 = new ContaCorrente();

//        this.adiciona(u1);
//        this.adiciona(u2);
//        this.adiciona(u3);
//        this.adiciona(u4);
        
        
        

    
        //uti1.setDataCriacao(LocalDateTime.MIN);o();
        //util.setDataModificacao(LocalDateTime.MIN);
    }

    public ContaCorrenteDAO(ClienteDAO clienteDAO) {
        
    }

    public boolean adiciona(ContaCorrente u) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            contacorrente[proximaPosicaoLivre] = u;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean ehVazio() {
        for (ContaCorrente conta : contacorrente) {
            if (conta != null) {
                return false;
            }
        }
        return true;
    }
    
    
    public StringBuilder mostrarTodos() {
        boolean temConta= false;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        
        for (ContaCorrente conta : contacorrente) {
            if (conta != null) {
                sb.append(conta.toString()).append("\n");
                temConta = true;
            }
        }
        
        if (!temConta) {
            sb.append("\n Não existe contas cadastrada\n");
        }
        return sb;
    }
    
    public void listaClientes() {
        boolean temConta = false;
        for (ContaCorrente conta : contacorrente) {
            if (conta != null) {
                System.out.println("| " + util.textoColuna(String.valueOf(conta.getId()), 5) + " | ");
                String nome = conta.getCliente().getNome();
                System.out.println(nome);
                temConta = true;
            }
        }
        if (!temConta) {
            System.out.println("\n Não existe usuário cadastrado\n");
        }
    }
    
    
    public void buscaCliente(ClienteDAO clienteDAO) {

        
    }
   

    private int proximaPosicaoLivre() {
        for (int i = 0; i < contacorrente.length; i++) {
            if (contacorrente[i] == null) {
                return i;
            }
        }
        return -1;
    }

    
    public Cliente buscaContaPorId(long id){
        for (int i = 0; i < contacorrente.length; i++) {
            if (contacorrente[i].getId() == id) {
                return contacorrente[i].getCliente();
            }
        }
        return null;
    }
    
  
     public boolean ehAdm(long id) {
        int tipo;
        for (int i = 0; i < contacorrente.length; i++) {
            if (contacorrente[i] != null && contacorrente[i].getId() == id) {
                tipo = contacorrente[i].getTipoUser();
                if (tipo == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean alterarConta(String nome, String novoNome) {
        for (ContaCorrente user : contacorrente) {
            if (user != null && user.getCliente().equals(nome)) {
                user.setCliente(null);
                return true;
            }
        }
        return false;

    }
    
    public ContaCorrente buscaContaporId(long id) {
        for (int i = 0; i < contacorrente.length; i++) {
            if (contacorrente[i] != null && contacorrente[i].getId() == id) {
                return contacorrente[i];
            }
        }
        return null;
    }
    
    public boolean validaId(long id) {
        for (int i = 0; i < contacorrente.length; i++) {
            if (contacorrente[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
  
    public boolean remover(long id, long user) {
        if (user == id) {
            return false;
        } else {
            for (int i = 0; i < contacorrente.length; i++) {
                if (contacorrente[i].getId() == id) {
                    contacorrente[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
    
     

  

    public void metodoPegaCliente(ClienteDAO clienteDAO) {
       
    }

  
 
    
}
