/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import mvc.control.Util;
import mvc.model.ClienteDAO;
import mvc.model.ContaCorrenteDAO;

/*
/*  @ professor Eduardo Silvestre
 *  @author William de Sousa Mota
 *  @author Lucas Feitosa

 
 CRUD de conta corrente. Informações importantes: id, cliente*, saldo, dataCriacao e dataModificacao. */
public class ContaCorrente {

    private static long serial;

    private long id;
    private Cliente cliente;
    private Double saldo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private Ativo ativo;

    private int tipoUser; /* 1 administrador / 2 Cliente 3 Cliente 2 */

    Util util = new Util();

    public ContaCorrente() {
        this.id = ++ContaCorrente.serial;
        this.dataCriacao = dataModificacao = Util.pegaDataAtual();
        saldo = 20000.00;

    }

    public static long getSerial() {
        return serial;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }

    public static void setSerial(long serial) {
        ContaCorrente.serial = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao() {
        this.dataModificacao = Util.pegaDataAtual();
    }

    public String buscaTipo(int tipo) {
        if (tipo == 1) {
            return "Administrador";
        } else if (tipo == 2) {
            return "Cliente";
        } else if (tipo == 3) {
            return "Cliente 2";
        } else {
            return null;
        }
    }

    @Override
    public String toString() {

        return "-----------------------------------------------------------------------\n"
                + "Identificacao (id): " + id + "\n"
                + "Cliente           : " + cliente.getNome() + "\n"
                + "Saldo             : " + Util.doubleToString(this.getSaldo()) + "\n"
                + "Data Criacao      : " + util.FormataData(dataCriacao) + "\n"
                + "Data Modificacao  : " + util.FormataData(dataModificacao) + "\n";

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContaCorrente other = (ContaCorrente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    // MÉTODO DEPOSITAR VALOR
    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);

        } else {
            ////

        }
    }
    //MÉTODO SACAR VALOR

    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

        } else {
            ////

        }

    }

    public void transferir(ContaCorrente contaParaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;

        } else {

            ////
        }
    }
}
