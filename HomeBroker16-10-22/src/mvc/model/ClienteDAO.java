/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;
import mvc.control.Util;

/**
 *
 /* @ professor Eduardo Silvestre
 *  @author William de Sousa Mota
 *  @author Lucas Feitosa

 */
public class ClienteDAO {

    public Cliente[] cliente = new Cliente[10];
    Util util = new Util();
    Scanner scanner = new Scanner(System.in);
    
    
   

    public ClienteDAO() {
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();

        this.adiciona(c1);
        this.adiciona(c2);
        this.adiciona(c3);

        c1.setNome("William");
        c1.setEndereco("AV. DOUTOR FLORESTAN FERNANDES , 131");
        c1.setCPF("123-231-888-01");
        c1.setTelefone("034-98808-88-88");
        c1.setTipoUsuario(1);
        c1.setLogin("0");
        c1.setSenha("0");
//        c1.setDataCriacao();
        c1.setDataModificacao();

        c2.setNome("Lucas");
        c2.setEndereco("Rua José Fernando da Silva , 876");
        c2.setCPF("846.884.546.72");
        c2.setTelefone("34-8741-45-89");
        c2.setTipoUsuario(1);
        c2.setLogin("1");
        c2.setSenha("1");
//        c2.setDataCriacao();
//        c2.setDataModificacao();

        c3.setNome("Joservefon Teresvaldo Onex");
        c3.setEndereco("Rua Gordonha Fielis , 0187");
        c3.setCPF("945.884.546.72");
        c3.setTelefone("35-8791-45-89");
        c3.setTipoUsuario(1);
        c3.setLogin("2");
        c3.setSenha("2");
//        c3.setDataCriacao();
//        c3.setDataModificacao();
    }

    public boolean adiciona(Cliente c) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            cliente[proximaPosicaoLivre] = c;
            return true;
        } else {
            return false;
        }
    }

    public boolean ehVazio() {
        for (Cliente user : cliente) {
            if (user != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temCliente = false;
        for (Cliente user : cliente) {
            if (user != null) {
                System.out.println(user);
                temCliente = true;
            }
        }
        if (!temCliente) {
            System.out.println("\n Não existe usuário cadastrado\n");
        }
    }
    
     public void mostrarClientesDisponiveis() {
        boolean temCliente = false;
        for (Cliente user : cliente) {
            if (user != null && !user.isTemConta()) {
                System.out.println(user);
                temCliente = true;
            }
        }
        if (!temCliente) {
            System.out.println("\n Não existe usuário cadastrado\n");
        }
    }
    
    

    public void listaClientes() {
        boolean temCliente = false;
        for (Cliente user : cliente) {
            if (user != null) {
                System.out.println("| " + util.textoColuna(String.valueOf(user.getId()), 5) + " | " + util.textoColuna(user.getNome(), 26) + " | ");
                temCliente = true;
            }
        }
        if (!temCliente) {
            System.out.println("\n Não existe usuário cadastrado\n");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Cliente user : cliente) {
            if (user != null && user.getNome().equals(nome)) {
                user.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    public Cliente buscaPorNome(String nome) {
        for (Cliente camp : cliente) {
            if (camp != null && camp.getNome().equals(nome)) {
                return camp;
            }
        }
        return null;

    }

    public boolean buscaPorLogin(String login) {
        for (Cliente user : cliente) {
            if (user != null && user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public long buscaSenhaPorLogin(String login, String senha) {
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] != null && cliente[i].getLogin().equals(login) && cliente[i].getSenha().equals(senha)) {
                return cliente[i].getId();
            }
        }
        return -1;
    }

    public String buscaNomePorId(long id) {
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i].getId() == id) {
                return cliente[i].getNome();
            }
        }
        return null;
    }

    public String buscaTipoPorId(long id) {
        int tipo;
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] != null && cliente[i].getId() == id) {
                tipo = cliente[i].getTipoUsuario();
                if (tipo == 1) {
                    return "Administrador";
                } else if (tipo == 2) {
                    return "Cliente";
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public boolean remover(long id, long user) {
        if (user == id) {
            return false;
        } else {
            for (int i = 0; i < cliente.length; i++) {
                if (cliente[i].getId() == id) {
                    cliente[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean alterarCliente(String nome, String novoNome) {
        for (Cliente user : cliente) {
            if (user != null && user.getNome().equals(nome)) {
                user.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    public boolean validaId(long id) {
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Cliente buscaClientePorId(long id) {
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] != null && cliente[i].getId() == id) {
                return cliente[i];
            }
        }
        return null;
    }

    public boolean ehAdm(long id) {
        int tipo;
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] != null && cliente[i].getId() == id) {
                tipo = cliente[i].getTipoUsuario();
                if (tipo == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int quantClientes() {
        int qt = 0;
        for (Cliente user : cliente) {
            if (user != null) {
                qt = qt + 1;
            }
        }
        return qt;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] == null) {
                return i;
            }

        }
        return -1;
    }
  


}
