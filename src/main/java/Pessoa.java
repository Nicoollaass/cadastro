
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicolas.ssantos
 */
public class Pessoa {
    private String nome;
    private Date dataNasc;
    private String email;
    private String telefone;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setDate(Date dataNasc){
        this.dataNasc = dataNasc;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public Date getDate(){
        return this.dataNasc;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public void save(){
        
    }
    
}