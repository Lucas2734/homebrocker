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

/**
 * @ professor Eduardo Silvestre
 * @ author William de Sousa Mota
 * @ author Lucas Feitosa
 * 
 * 
 * 
CRUD de movimentação de conta. Isso ajuda gerar o extrato. Informações importantes: id, conta*, tipo movimento (crédito, débito), descrição, valor, data criação e data modificação.
 */
public class MovimentacaoConta {
    
   private String id;
   private ContaCorrente contacorrente;
   private Double saldo;
   private String tipMov; /* 1 CRÉDITO / 2 DÉBITO*/
   private String descricao;
   private String valor;
   private LocalDateTime dataCriacao;
   private LocalDateTime dataModificacao;

       Util util = new Util();

    public ContaCorrente getContacorrente() {
        return contacorrente;
    }

    public void setContacorrente(ContaCorrente contacorrente) {
        this.contacorrente = contacorrente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTipMov() {
        return tipMov;
    }

    public void setTipMov(String tipMmov) {
        this.tipMov = tipMov;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    
    
    
   

    @Override
    public String toString() {
          
         return "-----------------------------------------------------------------------\n"
               + "Identificacao (id): " + id + "\n"
               + "Cliente           : " + contacorrente + "\n"
               + "Saldo             : " + saldo + "\n" 
               + "Data Criacao      : " + util.FormataData(dataCriacao) + "\n"
               + "Data Modificacao  : " + util.FormataData(dataModificacao) + "\n";
    
    
    }
    
    
}
