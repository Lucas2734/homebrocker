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
 *  @author William de Sousa Mota
 *  @author Lucas Feitosa

 * 
 * CRUD de Ordem.: id, conta*, tipo da ordem (compra, venda, ordem 0), ticker, quantidade, valor, valor total, estado (parcial, total, não),  data criação e data modificação. 
 */
public class Ordem {
    
     private static String serial;

      
    
    private long id;
    private ContaCorrente contacorrente;
    private String tipoOrdem;
    private String ticker;
    private int qtde;
    private BigDecimal valor;
    private BigDecimal valorTotal;
    private String estado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    
      Util util = new Util();

    public static String getSerial() {
        return serial;
    }

    public static void setSerial(String serial) {
        Ordem.serial = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ContaCorrente getContacorrente() {
        return contacorrente;
    }

    public void setContacorrente(ContaCorrente contacorrente) {
        this.contacorrente = contacorrente;
    }

    public String getTipoOrdem() {
        return tipoOrdem;
    }

    public void setTipoOrdem(String tipoOrdem) {
        this.tipoOrdem = tipoOrdem;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 73 * hash + Objects.hashCode(this.contacorrente);
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
        final Ordem other = (Ordem) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.contacorrente, other.contacorrente)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {          
         return "-----------------------------------------------------------------------\n"
               + "Identificacao (id): " + id + "\n"
               + "Conta Corrente    : " + contacorrente + "\n"
               + "Tipo de Ordem     : " + tipoOrdem + "\n" 
               + "Ticker            : " + ticker + "\n" 
               + "Quantidade        : " + qtde + "\n"
               + "Valor             : " + valor + "\n"
               + "Valor Total       : " + valorTotal + "\n"
               + "estado            : " + estado + "\n"
               + "Data Criacao      : " + util.FormataData(dataCriacao) + "\n"
               + "Data Modificacao  : " + util.FormataData(dataModificacao) + "\n";
    
    }
    
    
}
