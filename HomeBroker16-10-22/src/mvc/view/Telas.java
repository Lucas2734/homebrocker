package mvc.view;

import java.math.BigDecimal;
import mvc.model.Ativo;
import mvc.model.AtivoDAO;
import mvc.model.Cliente;
import mvc.model.ClienteDAO;
import mvc.model.ContaCorrente;
import mvc.model.ContaCorrenteDAO;
import mvc.model.Execucao;
import mvc.model.ExecucaoDAO;
import mvc.model.MovimentacaoConta;
import mvc.model.MovimentacaoContaDAO;
import mvc.model.Ordem;
import mvc.model.OrdemDAO;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;

import mvc.control.Util;
import java.util.Scanner;
import javax.swing.JOptionPane;
/* @ professor Eduardo Silvestre
 * @author william de Sousa Mota/*
 */

public class Telas {

    Scanner scanner = new Scanner(System.in);
    Util util = new Util();
    ExecucaoDAO execucaoDAO = new ExecucaoDAO();
    private String CPF;
    private Object clienteDAO;

    public void menuPrincipal(long id) {

    }

    // VALIDAÇÃO DE OPÇÃO DE CASE
    public int validaOpcao(int fim) {
        int opcao;
        do {
            System.out.print("Opção: ");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextInt()) {
                System.out.println("Opção invalida!\n");
                System.out.print("Opção: ");
                scanner.next();
            }
            opcao = scanner.nextInt();

            if (opcao < 0 || opcao > fim) {
                System.out.println("Opção invalida!\n");
            }
        } while (opcao < 0 || opcao > fim);

        return opcao;
    }

    // MENU INICIO
    public void inicio() {
        System.out.println(" =========================================================================");
        System.out.println(" Home Brocker - Login ");
        System.out.println(" =========================================================================");
        System.out.println("\n Entre com seus dados:\n");
    }

    // MENU PRINCIPAL 
    public int menuPrin(ClienteDAO clienteDAO, AtivoDAO ativoDAO, ContaCorrenteDAO contaDAO, long id) {
        System.out.println("\n\n\n\n\n\n\n =========================================================================");
        System.out.println(" Home Brocker ");
        System.out.println(" ====================================================================/Home");
        System.out.println(" Seja bem vindo " + clienteDAO.buscaNomePorId(id) + " - " + clienteDAO.buscaTipoPorId(id));
        System.out.println(" Identificação: " + id);
        System.out.println("\n Escolha a opcão desejada\n");
        System.out.println(" 1 - Cadastros");
        System.out.println(" 2 - Book de Ofertas");
        System.out.println(" 3 - Relatórios");
        System.out.println(" 4 - Calendario\n");
        System.out.println(" 0 - Sair do programa");

        int opcao = validaOpcao(4);
        return opcao;
    }

    // MENU CADASTRO
    private int menuCadastro(ClienteDAO clienteDAO, AtivoDAO ativoDAO, ContaCorrenteDAO contaDAO, long id) {
        System.out.println(" =========================================================================");
        System.out.println(" Home Brocker - Cadastros");
        System.out.println(" ==========================================================/Home/Clientes");
        System.out.println("\n Escolha a opcão desejada\n");
        System.out.println("  1 - Clientes");
        System.out.println("  2 - Ativos");
        System.out.println("  3 - Conta Corrente");
        System.out.println("  4 - Ordem Execuçao");
        System.out.println("  5 - Ultima Negociação");
        System.out.println("  6 - Meus Ativos");
        System.out.println("  7 - Estado de um Ativo");
        System.out.println("  0 - Voltar para o menu");

        int opcao = validaOpcao(8);
        return opcao;

    }

    // MENU CLIENTE
    private int menuCliente(long id) {
        System.out.println(" =========================================================================");
        System.out.println(" Home Brocker - Clientes");
        System.out.println(" =================================================/Home/Cadastros/Clientes");
        System.out.println("\n Escolha a opcão desejada\n");
        System.out.println("  1 - Criar Cliente");
        System.out.println("  2 - Listar Clientes");
        System.out.println("  3 - Alterar Cliente");
        System.out.println("  4 - Deletar Cliente\n");
        System.out.println("  0 - Voltar para o menu anterior");

        int opcao = validaOpcao(4);
        return opcao;
    }

    // MENU CLIENTE
    private int menuConta(long id) {
        System.out.println(" =========================================================================");
        System.out.println(" Home Brocker - Clientes");
        System.out.println(" =================================================/Home/Cadastros/Clientes");
        System.out.println("\n Escolha a opcão desejada\n");
        System.out.println("  1 - Criar   Conta");
        System.out.println("  2 - Listar  Conta");
        System.out.println("  3 - Alterar Conta");
        System.out.println("  4 - Deletar Conta\n");
        System.out.println("  0 - Voltar para o menu anterior");

        int opcao = validaOpcao(4);
        return opcao;
    }

    // MENU Ativo
    private int menuAtivo(long id) {
        System.out.println(" =========================================================================");
        System.out.println(" Home Brocker - Clientes");
        System.out.println(" =================================================/Home/Cadastros/Ativos");
        System.out.println("\n Escolha a opcão desejada\n");
        System.out.println("  1 - Criar   Ativos");
        System.out.println("  2 - Listar  Ativos");
        System.out.println("  3 - Alterar Ativos");
        System.out.println("  4 - Deletar Ativos\n");
        System.out.println("  0 - Voltar para o menu anterior");

        int opcao = validaOpcao(4);
        return opcao;
    }

    // MENU EXECUÇÃO
    private int menuExecucao(long id) {
        System.out.println(" =========================================================================");
        System.out.println(" Home Brocker - Clientes");
        System.out.println(" =================================================/Home/Cadastros/Execucao");
        System.out.println("\n Escolha a opcão desejada\n");
        System.out.println("  1 - Criar   Execuçao");
        System.out.println("  2 - Listar  Execução");
        System.out.println("  3 - Alterar Execução");
        System.out.println("  4 - Deletar Execução\n");
        System.out.println("  0 - Voltar para o menu anterior");

        int opcao = validaOpcao(4);
        return opcao;
    }
    
    
    
     private int menuMovimentacao(long id) {
        System.out.println(" =========================================================================");
        System.out.println(" Home Brocker - Clientes");
        System.out.println(" =================================================/Home/Movimentação/Execucao");
        System.out.println("\n Escolha a opcão desejada\n");
        System.out.println("  1 - Depositar");
        System.out.println("  2 - Sacar");
        System.out.println("  3 - Transferir");
        System.out.println("  4 - Deletar \n");
        System.out.println("  0 - Voltar para o menu anterior");

        int opcao = validaOpcao(4);
        return opcao;
        
        
        
    }
     
     // CASE MOVIMENTAÇÃO
     
      
     
     
    // CASE CADASTRO
    public void menuCad(ClienteDAO clienteDAO, AtivoDAO ativoDAO, ContaCorrenteDAO contaDAO, long id) {
        int opcaoMenu;

        do {
            opcaoMenu = menuCadastro(clienteDAO, ativoDAO, contaDAO, id);
            switch (opcaoMenu) {
                case 1:
                    menuCli(clienteDAO, ativoDAO, id);

                case 2:
                    menuAti(clienteDAO, ativoDAO, id);

                case 3:
                    menuCont(clienteDAO, contaDAO, id);

                case 4:
                    menuExec(clienteDAO, contaDAO, id);

                case 5:
                    System.out.println("teste");

                case 6:
                    System.out.println("teste");

            }
        } while (opcaoMenu != 0);
        menuPrincipal(id);
    }

    // CASE CLIENTE
    public void menuCli(ClienteDAO clienteDAO, AtivoDAO ativoDAO, long id) {
        int elementoASerAlterado;
        int elementoASerExcluido;
        int opcaoMenu;
        do {
            opcaoMenu = menuCliente(id);
            switch (opcaoMenu) {
                case 1:
                    //if (clienteDAO.ehAdm(id)) {
                    if (1 == Util.pegaClienteLogado().getTipoUsuario()) {
                        Cliente c = criaCliente();
                        if (clienteDAO.equals(c)) {
                            System.out.println(" ATENÇÃO: Cliente não inserido. Login já cadastrado.");
                        } else if (clienteDAO.adiciona(c)) {
                            System.out.println(" Cliente inserido com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: Cliente não inserido. Limite de cadastro excedido.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println(" \n\nATENÇÃO: Essa opção é Liberada apenas para Administradores.");
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }

                case 2:
                    System.out.println(" Listagem de Cliente(s) do sistema:");
                    clienteDAO.mostrarTodos();
                    System.out.println(" Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    if (clienteDAO.ehAdm(id)) {
                        clienteDAO.mostrarTodos();

                        System.out.print(" Qual id do cliente que deseja Alterar: ");
                        elementoASerAlterado = Integer.parseInt(scanner.nextLine());

                        if (alterarCliente(clienteDAO, elementoASerAlterado)) {
                            System.out.println(" Cliente alterado com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: Cliente não alterado.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    } else {
                        if (this.alterarSenhaCliente(clienteDAO, id)) {
                            System.out.println(" Senha alterada com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: Senha não alterada");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }

                case 4:
                    if (clienteDAO.ehAdm(id)) {
                        clienteDAO.mostrarTodos();

                        System.out.print(" Qual id do Cliente que deseja excluir: ");
                        elementoASerExcluido = Integer.parseInt(scanner.nextLine());

                        if (clienteDAO.remover(elementoASerExcluido, id)) {
                            System.out.println(" Cliente excluido com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: Cliente é o mesmo conectado no momento ou inexistente.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println(" \n\nATENÇÃO: Essa opção é Liberada apenas para Administradores.");
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;

                    }
            }
        } while (opcaoMenu != 0);
        menuCad(clienteDAO, ativoDAO, null, id);
    }

    // CASE ATIVOS
    public void menuAti(ClienteDAO clienteDAO, AtivoDAO ativoDAO, long id) {
        int elementoASerAlterado;
        int elementoASerExcluido;
        int opcaoMenu;

        do {
            opcaoMenu = menuAtivo(id);
            switch (opcaoMenu) {
                case 1:
                    if (clienteDAO.ehAdm(id)) {
                        // if (1 == Util.pegaAtivoLogado().getTipoUser()) {
                        Ativo a = criaAtivo();
                        if (ativoDAO.equals(a)) {
                            System.out.println(" ATENÇÃO: Ativo não inserido. Login já cadastrado.");
                        } else if (ativoDAO.adiciona(a)) {
                            System.out.println(" Ativo inserido com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: Ativo não inserido. Limite de cadastro excedido.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println(" \n\nATENÇÃO: Essa opção é Liberada apenas para Administradores.");
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }

                case 2:
                    System.out.println(" Listagem de Ativo(s) do sistema:");
                    ativoDAO.mostrarTodos();
                    System.out.println(" Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    if (clienteDAO.ehAdm(id)) {
                        ativoDAO.mostrarTodos();

                        System.out.print(" Qual id do Ativo que deseja Alterar: ");
                        elementoASerAlterado = Integer.parseInt(scanner.nextLine());

                        if (alterarAtivo(ativoDAO, elementoASerAlterado)) {
                            System.out.println(" Ativo alterado com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: Ativo não alterado.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }

                case 4:
                    if (clienteDAO.ehAdm(id)) {
                        ativoDAO.mostrarTodos();

                        System.out.print(" Qual id do Ativo que deseja excluir: ");
                        elementoASerExcluido = Integer.parseInt(scanner.nextLine());

                        if (ativoDAO.remover(elementoASerExcluido, id)) {
                            System.out.println(" Ativo excluido com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: Ativo é o mesmo conectado no momento ou inexistente.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println(" \n\nATENÇÃO: Essa opção é Liberada apenas para Administradores.");
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }
            }
        } while (opcaoMenu != 0);
        menuCad(clienteDAO, ativoDAO, null, id);
    }

    // CASE CONTA CORRENTE
    public void menuCont(ClienteDAO clienteDAO, ContaCorrenteDAO contaDAO, long id) {
        int elementoASerAlterado;
        int elementoASerExcluido;
        int opcaoMenu;

        do {
            opcaoMenu = menuConta(id);
            switch (opcaoMenu) {
                case 1:
                    if (clienteDAO.ehAdm(id)) {

                        // if (1 == Util.pegaContaLogada().getTipoUser()) {
                        ContaCorrente a = criaClienteConta(clienteDAO);
                        if (contaDAO.equals(a) == true) {
                            System.out.println("  Conta já cadastrada.");
                        } else if (contaDAO.adiciona(a)) {
                            System.out.println(" Conta inserida com sucesso!");
                        } else {
                            System.out.println(" Conta não inserida. Limite de cadastro excedido.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                    } else {
                        System.out.println(" \n\nATENÇÃO: Essa opção é Liberada apenas para Administradores.");
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }
                case 2:
                    System.out.println(" Listagem da(s) contas no sistema:\n");
                    System.out.println(contaDAO.mostrarTodos());
                    System.out.println(" Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    if (clienteDAO.ehAdm(id)) {
                        contaDAO.mostrarTodos();

                        System.out.print(" Qual Conta (id) deseja Alterar: ");
                        elementoASerAlterado = Integer.parseInt(scanner.nextLine());

                        if (this.alterarConta(contaDAO, elementoASerAlterado)) {
                            System.out.println(" Conta alterada com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: Conta não alterado.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println(" \n\nATENÇÃO: Essa opção é Liberada apenas para Administradores.");
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }
                case 4:
                    if (clienteDAO.ehAdm(id)) {
                        contaDAO.mostrarTodos();

                        System.out.print(" Qual conta você deseja excluir: ");
                        elementoASerExcluido = Integer.parseInt(scanner.nextLine());

                        if (contaDAO.remover(elementoASerExcluido, id)) {
                            System.out.println(" Conta Excluída com com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: conta inexistente.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println(" \n\nATENÇÃO: Essa opção é Liberada apenas para Administradores.");
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }
            }
        } while (opcaoMenu != 0);
        menuCad(clienteDAO, null, contaDAO, id);
    }


    public void menuExec(ClienteDAO clienteDAO, ContaCorrenteDAO contaDAO, long id) {
        int elementoASerAlterado;
        int elementoASerExcluido;
        int opcaoMenu;

        do {
            opcaoMenu = menuExecucao(id);
            switch (opcaoMenu) {
                case 1:
                     if (clienteDAO.ehAdm(id)) {
                       // if (1 == Util.pegaAtivoLogado().getTipoUser()) {
                        Execucao u = criaExecucao();
                        if (execucaoDAO.equals(u)) {
                            System.out.println(" ATENÇÃO: Execucao não inserido. Login já cadastrado.");
                        } else if (execucaoDAO.adiciona(u)) {
                            System.out.println(" Execucao realizada com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: Execucao não inserida. Limite de cadastro excedido.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println(" \n\nATENÇÃO: Essa opção é Liberada apenas para Administradores.");
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }

                case 2:
                    System.out.println(" Listagem de Execucao(oes) do sistema:");
                    execucaoDAO.mostrarTodos();
                    System.out.println(" Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    if (clienteDAO.ehAdm(id)) {
                        execucaoDAO.mostrarTodos();

                        System.out.print(" Qual id do Ativo que deseja Alterar: ");
                        elementoASerAlterado = Integer.parseInt(scanner.nextLine());

                        if (alterarExecucao(execucaoDAO, elementoASerAlterado)) {
                            System.out.println(" Ativo alterado com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: Ativo não alterado.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }

                case 4:
                    if (clienteDAO.ehAdm(id)) {
                        execucaoDAO.mostrarTodos();

                        System.out.print(" Qual id do Ativo que deseja excluir: ");
                        elementoASerExcluido = Integer.parseInt(scanner.nextLine());

                        if (execucaoDAO.remover(elementoASerExcluido, id)) {
                            System.out.println(" Ativo excluido com sucesso!");
                        } else {
                            System.out.println(" ATENÇÃO: Ativo é o mesmo conectado no momento ou inexistente.");
                        }
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println(" \n\nATENÇÃO: Essa opção é Liberada apenas para Administradores.");
                        System.out.println(" Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }
            }
        } while (opcaoMenu != 0);
        menuCad(null, null, null, id);
    }
    
    
    // CASE MOVIMENTAÇÃO

    // MÉTODO CRIANDO CLIENTES 
    public Cliente criaCliente() {
        Cliente c = new Cliente();

        System.out.print("\n Nome: ");
        String nome = scanner.nextLine();

        System.out.print(" Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print(" Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print(" CPF: ");
        String CPF = scanner.nextLine();

        System.out.print(" Tipo (1 - Administrador / 2 - Cliente): ");
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print(" Login: ");
        String login = scanner.nextLine();

        System.out.print(" Senha: ");
        String senha = scanner.nextLine();

        c.setNome(nome);
        c.setEndereco(endereco);
        c.setTelefone(telefone);
        c.setCPF(CPF);
        c.setTipoUsuario(tipo);
        c.setLogin(login);
        c.setSenha(senha);
        c.setDataModificacao();

        return c;
    }

    // MÉTODO ALTERA CLIENTES    
    private boolean alterarCliente(ClienteDAO clienteDAO, long id) {
        for (int i = 0; i < clienteDAO.cliente.length; i++) {
            if (clienteDAO.cliente[i] != null && clienteDAO.cliente[i].getId() == id) {

                System.out.print("\n Nome: ");
                String nome = scanner.nextLine();

                System.out.print(" Endereco: ");
                String endereco = scanner.nextLine();

                System.out.print(" Telefone: ");
                String telefone = scanner.nextLine();

                System.out.print(" Tipo (1 - Administrador / 2 - Servidor): ");
                int tipo = Integer.parseInt(scanner.nextLine());

                System.out.print(" Login: ");
                String login = scanner.nextLine();

                System.out.print(" Senha: ");
                String senha = scanner.nextLine();

                if (clienteDAO.cliente.equals(i)) {
                    return false;
                } else {
                    clienteDAO.cliente[i].setNome(nome);
                    clienteDAO.cliente[i].setEndereco(endereco);
                    clienteDAO.cliente[i].setTelefone(telefone);
                    clienteDAO.cliente[i].setTipoUsuario(tipo);
                    clienteDAO.cliente[i].setLogin(login);
                    clienteDAO.cliente[i].setSenha(senha);
                    clienteDAO.cliente[i].setDataModificacao();
                    return true;
                }
            }
        }

        return false;

    }

    // MÉTODO ALTERA SENHA CLIENTES    
    private boolean alterarSenhaCliente(ClienteDAO clienteDAO, long id) {
        for (int i = 0; i < clienteDAO.cliente.length; i++) {
            if (clienteDAO.cliente[i] != null && clienteDAO.cliente[i].getId() == id) {
                System.out.print(" \nDigite sua Senha Atual: ");
                String senhaAtual = scanner.nextLine();

                if (clienteDAO.cliente[i].getSenha().equals(senhaAtual)) {
                    System.out.print(" \nDigite sua nova Senha: ");
                    String senha1 = scanner.nextLine();
                    System.out.print(" \nConfirme sua nova Senha: ");
                    String senha2 = scanner.nextLine();

                    if (senha1.equals(senha2)) {
                        clienteDAO.cliente[i].setSenha(senha2);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    // MÉTODOS CRIANDO ATIVOS
    private Ativo criaAtivo() {
        Ativo a = new Ativo();

        System.out.print("\n Nome da Empresa: ");
        String nome = scanner.nextLine();

        System.out.print(" Ticher: ");
        String ticker = scanner.nextLine();

        System.out.print(" Quantidade de Ativos: ");
        String totalAtivos = scanner.nextLine();

        System.out.print("Favor inserir o novo valor do Ativo: ");
        BigDecimal precoInicial = new BigDecimal(scanner.nextLine());

        a.setNomeEmpresa(nome);
        a.setTicker(nome);
        a.setTicker(ticker);
        a.setTotalAtivos(totalAtivos);
        a.setPrecoInicial(precoInicial);

        return a;
    }

    // MÉTODO ALTERA ATIVO
    private boolean alterarAtivo(AtivoDAO ativoDAO, long id) {
        for (int i = 0; i < ativoDAO.ativos.length; i++) {
            if (ativoDAO.ativos[i] != null && ativoDAO.ativos[i].getId() == id) {

                System.out.print("\n Nome da Empresa: ");
                String nome = scanner.nextLine();

                System.out.print(" Ticker: ");
                String endereco = scanner.nextLine();

                System.out.print(" Tipo (1 - Administrador / 2 - Servidor): ");
                int tipo = Integer.parseInt(scanner.nextLine());

                if (ativoDAO.ativos.equals(i)) {
                    return false;
                } else {
                    ativoDAO.ativos[i].setNomeEmpresa(nome);
                    ativoDAO.ativos[i].setTicker(nome);
                    //ativoDAO.ativos[i].setDataModificacao();
                    return true;
                }
            }
        }

        return false;

    }

    // METODO ALTERA VALOR ATIVO
    private boolean alterarValorAtivo(AtivoDAO ativoDAO, long id) {

        for (int i = 0; i < ativoDAO.ativos.length; i++) {
            if (ativoDAO.ativos[i] != null && ativoDAO.ativos[i].getId() == id) {

                String inputPrecoInicial;

                inputPrecoInicial = JOptionPane.showInputDialog(null, "Favor inserir o novo valor do Ativo");
                BigDecimal precoInicial = new BigDecimal(inputPrecoInicial);

                if (ativoDAO.equals(i)) {
                    return false;
                } else {
                    ativoDAO.ativos[i].setPrecoInicial(precoInicial);

                    return true;
                }
            }
        }
        return false;
    }

    //MÉTODO CRIA CONTA
    public ContaCorrente criaConta() {
        ContaCorrente a = new ContaCorrente();

        System.out.print("\n Nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String CPF = scanner.nextLine();

        //a.setCliente(nome);
        // a.setCPF(CPF);
        return a;
    }

    //MÉTODO ALTERA CALENDARIO
    public void alterarData() {
        System.out.println("Informe a qauntidade de dias a aumentar na data atual: " + util.FormataData(Util.pegaDataAtual()));
        LocalDateTime dateTime = Util.incrementaDias(Long.parseLong(scanner.nextLine()));
        System.out.println("Data Alterada com sucesso!\nNova data: " + util.FormataData(dateTime) + "\n\nPressione Enter para continuar ...");
        scanner.nextLine();
    }

    // MÉTODO ALTERA CONTA    
    private boolean alterarConta(ContaCorrenteDAO contaDAO, long id) {
        for (int i = 0; i < contaDAO.contacorrente.length; i++) {
            if (contaDAO.contacorrente[i] != null && contaDAO.contacorrente[i].getId() == id) {

                System.out.print(" Tipo (1 - Administrador / 2 - Servidor): ");
                int tipo = Integer.parseInt(scanner.nextLine());

                if (contaDAO.contacorrente.equals(i)) {
                    return false;
                } else {

                    contaDAO.contacorrente[i].getId();
                    contaDAO.contacorrente[i].setDataModificacao();
                    return true;
                }
            }
        }

        return false;

    }

    public ContaCorrente criaClienteConta(ClienteDAO clienteDAO) {
        ContaCorrente c = new ContaCorrente();

        System.out.println("Cliente: ");
        clienteDAO.mostrarClientesDisponiveis();

        System.out.println("Digite o ID: ");
        long idLido = Long.parseLong(scanner.nextLine());
        Cliente a = clienteDAO.buscaClientePorId(idLido);
        a.setTemConta(true);

        c.setCliente(a);

        return c;
    }

    //MÉTODO ALTERA EXECUCAO
    private boolean alterarExecucao(ExecucaoDAO execDAO, long id) {
        for (int i = 0; i < execDAO.execucao.length; i++) {
            if (execDAO.execucao[i] != null && execDAO.execucao[i].getId() == id) {

                System.out.print("\n Ordem: ");
                String tipoOrdem = scanner.nextLine();

                System.out.print(" Conta Compra: ");
                String contaCompra = scanner.nextLine();

                System.out.print(" Conta Venda: ");
                String contaVenda = scanner.nextLine();

                System.out.print(" Quantidade: ");
                String qtde = scanner.nextLine();

                System.out.print(" Tipo (1 - Administrador / 2 - Servidor): ");
                int tipo = Integer.parseInt(scanner.nextLine());

                if (execDAO.execucao.equals(i)) {
                    return false;
                } else {
                    execDAO.execucao[i].setTipoOrdem(tipoOrdem);
                    execDAO.execucao[i].setContaCompra(contaCompra);
                    execDAO.execucao[i].setContaVenda(contaVenda);
                    execDAO.execucao[i].setQtde(qtde);

                    //ativoDAO.ativos[i].setDataModificacao();
                    return true;
                }
            }
        }

        return false;

    }

    private Execucao criaExecucao() {
        Execucao u = new Execucao();

        System.out.print("\n Ordem: ");
        String tipoOrdem = scanner.nextLine();

        System.out.print(" Conta Compra: ");
        String contaCompra = scanner.nextLine();

        System.out.print(" Conta Venda: ");
        String contaVenda = scanner.nextLine();

        System.out.print(" Quantidades: ");
        String qtde = scanner.nextLine();

        System.out.print(" Tipo (1 - Administrador / 2 - Cliente): ");
        int tipo = Integer.parseInt(scanner.nextLine());

        u.setTipoOrdem(tipoOrdem);
        u.setContaCompra(contaCompra);
        u.setContaVenda(contaVenda);
        u.setQtde(qtde);
        u.setTipoUsuario(tipo);
        u.setDataModificacao();

        return u;
    }
    
    
   
    
       
    }
    
     


