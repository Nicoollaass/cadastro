
import java.sql.ResultSet;
import java.util.ArrayList;
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
public class CrudPessoa extends Pessoa{
    @SuppressWarnings("empty-statement")
    public List buscarPessoas(){   
        List<Pessoa> pessoa = new <Pessoa>ArrayList();
        try {
            this.connect();
            ResultSet consulta  = this.executar("SELECT * FROM pessoa");          
            while(consulta.next()){
                Pessoa dadosPessoa = new Pessoa();
                dadosPessoa.setId(consulta.getInt("id_pessoa"));
                dadosPessoa.setNome(consulta.getString("nome"));
                dadosPessoa.setDate(consulta.getString("data"));
                dadosPessoa.setEmail(consulta.getString("email"));
                dadosPessoa.setTelefone(consulta.getString("telefone"));
                pessoa.add(dadosPessoa);                
            };              
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Houve algum problema ao buscar pessoas");
        }
        finally {  
            this.disconnect();
        }        
        return pessoa;
        
    }
    
    public void listarPessoas(List<Pessoa> pessoa){
        for (int i=0; i<pessoa.size(); i++){
           System.out.printf("====== Pessoa %d =======\n",i+1);
           System.out.println(pessoa.get(i).getId());
           System.out.println(pessoa.get(i).getNome());
           System.out.println(pessoa.get(i).getTelefone());
           System.out.println(pessoa.get(i).getEmail());
           System.out.println(pessoa.get(i).getDate());
        }
    }
    
    public int salvar(){
        int inserir = -1;
        try {
            this.connect();
              inserir  = this.inserir("INSERT INTO "
                                    + "pessoa (nome,data,email,telefone)"
                                    + "VALUES('"+this.getNome()+"','"+this.getDate()+"','"+this.getEmail()+"','"+this.getTelefone()+"')");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Houve algum problema ao salvar pessoa");
        }
        finally {  
            this.disconnect();
        } 
        return inserir;
    }
    
    
    public int editar(){
        int editar = -1;
        try {
            this.connect();
            editar  = this.inserir("UPDATE pessoa "
                                  + "SET nome='"+this.getNome()+"',"
                                  + "data='"+this.getDate()+"',"
                                  + "email='"+this.getEmail()+"',"
                                  + "telefone='"+this.getTelefone()+"'"
                                  + "WHERE id_pessoa="+this.getId());
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Houve algum problema ao editar pessoas");
        }
        finally {  
            this.disconnect();
        } 
        return editar;
    }
    
    public int excluir(int id){
        int excluir = -1;
        try {
            this.connect();
            excluir  = this.inserir("DELETE FROM pessoa WHERE id_pessoa="+id);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Houve algum problema ao excluir pessoas");        }
        finally {  
            this.disconnect();
        } 
        return excluir;
    }
}
