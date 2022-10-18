/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.control;

import java.util.Scanner;
import mvc.model.AtivoDAO;
import mvc.model.ClienteDAO;
import mvc.model.ContaCorrente;
import mvc.model.ContaCorrenteDAO;
import mvc.view.Telas;

/**
 * @ professor Eduardo Silvestre
 * @author william de Sousa MotaW
 */
public class HomeBroker {

    Util util = new Util();
    ClienteDAO clienteDAO = new ClienteDAO();
    AtivoDAO ativoDAO = new AtivoDAO();
    ContaCorrenteDAO contaDAO = new ContaCorrenteDAO();

    Telas telas;

    Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public HomeBroker() {
        contaDAO.metodoPegaCliente(clienteDAO);

        this.telas = new Telas();
        contaDAO.buscaCliente(clienteDAO);
        telas.inicio();

        boolean testeBrocker = true;
        String user;

        do {
            if (testeBrocker == true) {
                System.out.print(" ID do Usuário : ");
                user = scanner.nextLine();
                testeBrocker = clienteDAO.buscaPorLogin(user);
            } else {
                System.out.println(" Usuário inexistente.");
                System.out.print(" Usuário: ");
                user = scanner.nextLine();
                testeBrocker = clienteDAO.buscaPorLogin(user);

            }
        } while (testeBrocker != true);

        long idConectado = -2;
        int tentativa = 0;
        String senha;
        do {
            if (idConectado == -2) {
                System.out.print(" Senha: ");
                senha = scanner.nextLine();
                idConectado = clienteDAO.buscaSenhaPorLogin(user, senha);

            } else {
                do {
                    tentativa++;
                    if (tentativa < 3) {
                        System.out.println(" Senha incorreta.");
                        System.out.print(" Senha: ");
                        senha = scanner.nextLine();
                        idConectado = clienteDAO.buscaSenhaPorLogin(user, senha);
                    } else {
                        System.out.println(" Senha incorreta 3ª tentativa.\n\n Sistema Finalizado.");
                        System.exit(0);
                    }
                } while (idConectado < 0);

            }
        } while (idConectado < 0);

        Util.registraCliente(clienteDAO.buscaClientePorId(idConectado));
        ContaCorrente u1 = new ContaCorrente();
        u1.setCliente(Util.pegaClienteLogado());
        contaDAO.adiciona(u1);
        Util.registraAtivo(ativoDAO.buscaAtivoPorId(idConectado));
        Util.registraConta(contaDAO.buscaContaporId(idConectado));

        //telas.menuPrincipal(idConectado);
        int opcaoMenu;
        do {
            opcaoMenu = telas.menuPrin(clienteDAO, ativoDAO, contaDAO, idConectado);
            switch (opcaoMenu) {
                case 1:
                    telas.menuCad(clienteDAO, ativoDAO, contaDAO, idConectado);
                    break;
                case 2:
                    System.out.println("teste");
                    contaDAO.listaClientes();
                    break;
                case 3:
                    System.out.println("teste");
                    break;
                case 4: {
                    telas.alterarData();
                    break;
                }
            }
        } while (opcaoMenu != 0);
        System.out.println("\n\n Obrigado por utilizar nosso Home Brocker!\n Home Brocker Finalizado.");
        System.exit(0);
    }

    public static void main(String[] args) {
        new HomeBroker();

    }

}
