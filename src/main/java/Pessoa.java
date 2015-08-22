
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicolas.ssantos
 */
    public class Pessoa extends SqlServer {
    private String nome;
    private String dataNasc;
    private String email;
    private String telefone;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setDate(String dataNasc){
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
    
    public String getDate(){
        return this.dataNasc;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    @SuppressWarnings("empty-statement")
    public List buscarPessoas(){   
        List pessoa =  new ArrayList();
        try {
            this.connect();
            ResultSet consulta  = this.executar("SELECT * FROM pessoa");          
            while(consulta.next()){
                List dados =  new ArrayList();
                dados.add(consulta.getString("id_pessoa"));
                dados.add(consulta.getString("nome"));
                dados.add(consulta.getString("data"));
                dados.add(consulta.getString("email"));
                dados.add(consulta.getString("telefone"));
                pessoa.add(dados);                
            };            
           
        } catch (Exception e) {
            System.out.println("Houve algum problema ao buscar pessoas");
        }
        finally {  
            this.disconnect();
        }
        /*for(Iterator iter = pessoa.iterator(); iter.hasNext();) {
            System.out.println(iter.next()); 
        }*/
        return pessoa;
        
    }
    
}
