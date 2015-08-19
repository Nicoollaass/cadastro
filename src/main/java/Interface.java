
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HERICK
 */
public class Interface {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite seu nome:");
        pessoa.setNome(entrada.nextLine());        
        System.out.println("Digite sua data de Nascimento:");
        pessoa.setDate(entrada.nextLine());
        System.out.println("Digite E-mail:");
        pessoa.setEmail(entrada.nextLine());
        System.out.println("Digite Telefone:");
        pessoa.setTelefone(entrada.nextLine());
        
    }
}
