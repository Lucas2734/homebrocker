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

/* @ professor Eduardo Silvestre
*  @ author William de Sousa Mota
 * @ author Lucas Feitosa

 * CRUD de Ordem Execução. id, ordem, conta compra*, conta venda*,  quantidade,  data criação e data modificação.
 */

public class Execucao {
    
    private static long serial;
    
    private long id;
    private String tipoOrdem;
    private String contaCompra;
    private String contaVenda;
    private String qtde;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
   private int tipoUsuario; /* 1 administrador / 2 Cliente 3 Cliente 2 */
    
    Util util = new Util();
 
    public Execucao() {
        this.id = ++Execucao.serial;
        this.dataCriacao = this.dataModificacao =  Util.pegaDataAtual();
    }
   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoOrdem() {
        return tipoOrdem;
    }

    public void setTipoOrdem(String tipoOrdem) {
        this.tipoOrdem = tipoOrdem;
    }

    public String getContaCompra() {
        return contaCompra;
    }

    public void setContaCompra(String contaCompra) {
        this.contaCompra = contaCompra;
    }

    public String getContaVenda() {
        return contaVenda;
    }

    public void setContaVenda(String contaVenda) {
        this.contaVenda = contaVenda;
    }

    public String getQtde() {
        return qtde;
    }

    public void setQtde(String qtde) {
        this.qtde = qtde;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

   public void setDataModificacao() {
        this.dataModificacao = Util.pegaDataAtual();
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }
    
    
    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.tipoOrdem);
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
        final Execucao other = (Execucao) obj;
        if (!Objects.equals(this.tipoOrdem, other.tipoOrdem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
            return "-----------------------------------------------------------------------\n"
               + "Identificacao (id): " + id + "\n"
               + "Tipo de Ordem     : " + tipoOrdem + "\n"
               + "Conta Compra      : " + contaCompra + "\n" 
               + "Conta Venda       : " + contaVenda + "\n" 
               + "Quantidade        : " + qtde + "\n"
               + "Data Criacao      : " + util.FormataData(dataCriacao) + "\n"
               + "Data Modificacao  : " + util.FormataData(dataModificacao) + "\n";
    
    }
    
    
}
