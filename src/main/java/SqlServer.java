
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServer {

	private String host = "localhost";
	private String user = "sa";
	private String pass = "123456";
	private String database = "pessoa" ;
        private Connection c;
    
    /**
     * Construtor da classe
    
   
    /**
     * M�todo que estabelece a conex�o com o banco de dados
     *
     * @return True se conseguir conectar, falso em caso contr�rio.
     */
    public boolean connect() {
        boolean isConnected = false;
        
        String url;
        String portNumber = "1433";
        String userName   = this.user;
        String passName   = this.pass;
        url = "jdbc:sqlserver://"+ this.host+":" +portNumber + ";databaseName=" +this.database;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            this.c = DriverManager.getConnection(url,userName, passName);
            isConnected = true;
        } catch( SQLException e ) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( InstantiationException e ) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( IllegalAccessException e ) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            isConnected = false;
        }
       
        return isConnected;
    }
   
    /**
     * M�todo que estabelece a desconex�o com o banco de dados
     *
     * @return True se conseguir desconectar, falso em caso contr�rio.
     */
    public boolean disconnect() {
        boolean isConnected = false;
       
        String url;
        String portNumber = "1433";
        String userName   = this.user;
        String passName   = this.pass;
        url = "jdbc:sqlserver://"+ this.host+":" +portNumber + ";databaseName=" +this.database;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            this.c = DriverManager.getConnection(url,userName, passName);
            this.c.close();
            isConnected = true;
        } catch( SQLException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( ClassNotFoundException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( InstantiationException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( IllegalAccessException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        }
       
        return isConnected;
    }

    /**
     * Esse m�todo executa a query dada, e retorna um ResultSet
     * Talvez fosse melhor id�ia fazer esse m�todo lan�ar uma exception
     * a faze-lo retornar null como eu fiz, por�m isso � apenas um exemplo
     * para demonstrar a funcionalidade do comando execute
     *
     * @param query String contendo a query que se deseja executar
     * @return ResultSet em caso de estar tudo Ok, null em caso de erro.
     */
    public ResultSet executar( String query ) {
        Statement st;
        ResultSet rs;
        
        try {
            st = this.c.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
       
        return null;
    }
   
    /**
     * Executa uma query como update, delete ou insert.
     * Retorna o n�mero de registros afetados quando falamos de um update ou delete
     * ou retorna 1 quando o insert � bem sucedido. Em outros casos retorna -1
     *
     * @param query A query que se deseja executar
     * @return 0 para um insert bem sucedido. -1 para erro
     */
    public int inserir( String query ) {
        Statement st;
        int result = -1;
       
        try {
            st = this.c.createStatement();
            result = st.executeUpdate(query);
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
       
        return result;
    }
    
    

}

