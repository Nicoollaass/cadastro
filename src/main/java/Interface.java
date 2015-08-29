
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fi|le, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HERICK
 */
public class Interface {

    public static void main(String[] args) {
        CrudPessoa pessoa = new CrudPessoa();
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaString = new Scanner(System.in);
        
        int opcao;
        do {
            System.out.println("=====Menu=====\n"
                    + "1 - Salvar\n"
                    + "2 - Editar\n"
                    + "3 - Buscar\n"
                    + "4 - Excluir\n"
                    + "5 - Sair\n");
            System.out.println("Digite uma opção: ");
            opcao = entradaInt.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.println("Digite seu nome:");
                    pessoa.setNome(entradaString.nextLine());
                    System.out.println("Digite sua data de Nascimento:");
                    pessoa.setDate(entradaString.nextLine());
                    System.out.println("Digite E-mail:");
                    pessoa.setEmail(entradaString.nextLine());
                    System.out.println("Digite Telefone:");
                    pessoa.setTelefone(entradaString.nextLine());
                    System.out.println(pessoa.salvar());
                    break;
                case 2:
                    pessoa.listarPessoas(pessoa.buscarPessoas());
                    System.out.println("Digite um ID de pessoa que você queira editar: ");
                    pessoa.setId(entradaInt.nextInt());
                    System.out.println("Digite um nome: ");
                    pessoa.setNome(entradaString.nextLine());
                    System.out.println("Digite sua data de Nascimento:");
                    pessoa.setDate(entradaString.nextLine());
                    System.out.println("Digite E-mail:");
                    pessoa.setEmail(entradaString.nextLine());
                    System.out.println("Digite Telefone:");
                    pessoa.setTelefone(entradaString.nextLine());
                    System.out.println(pessoa.editar());
                    break;
                case 3:
                    pessoa.listarPessoas(pessoa.buscarPessoas());                    
                    break;
                case 4:
                    pessoa.listarPessoas(pessoa.buscarPessoas());
                    System.out.println("Digite o ID de pessoa que você quer Excluir :");
                    pessoa.excluir(entradaInt.nextInt());
                    break;
                case 5:
                    System.out.println("Até logo 3.2.1..");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

       
    }
}
