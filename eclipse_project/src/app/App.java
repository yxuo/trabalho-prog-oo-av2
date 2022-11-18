package app;

import pack.*;

import java.util.*;

public class App {

    // function with default parameter
    public static int readInt(String prompt) {
        Scanner sc = new Scanner(System.in);
        // read string
        do {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                if (prompt != null && !prompt.isEmpty())
                    System.out.println(prompt);
                else
                    System.out.println("Entrada invalida, tente novamente!");
            }
        } while (true);

    }

    public static int readInt() {
        return readInt("");
    }

    public static String readString(String prompt) {
        Scanner sc = new Scanner(System.in);
        // read string
        String s = "";
        boolean ok = false;
        do {
            try {
                s = sc.next();
                ok = true;
            } catch (InputMismatchException e) {
                if (prompt != null && !prompt.isEmpty())
                    System.out.println(prompt);
                else
                    System.out.println("Entrada invalida, tente novamente!");
            }
        } while (!ok);

        return s;
    }
    public static String readString(){
        return readString("");
    }


    public static void main(String[] args) throws Exception {
        System.out.println("App MYSQL Connector");
        String dbName = "lasalle";

        FabricaConexao fabricaConexao = new FabricaConexao();

        CriarBanco.run(fabricaConexao, dbName);
        CriarTabelaFunc.run(fabricaConexao, dbName);

        // Menu: 1. Inserir 2. Consultar 3. Alterar 4. Excluir 5. Sair

        String menu = "1. Inserir 2. Consultar 3. Excluir 4. Sair";
        System.out.println(menu);

        // loop
        while (true) {
            int opcao = readInt();
            switch (opcao) {
                case 1:
                    // Read
                    System.out.println("Inserir");
                    System.out.println("Digite o codigo:");
                    int codigo = readInt();
                    System.out.println("Digite o nome:");
                    String nome = readString();
                    System.out.println("Digite o cargo:");
                    String cargo = readString();
                    System.out.println("Digite o endereco:");
                    String end = readString();
                    // Create
                    Func func = new Func(codigo, nome, cargo, end);
                    Exception response = NovoFunc.run(fabricaConexao, dbName, func);
                    // Response
                    if (response == null) {
                        System.out.println("Inserido com sucesso!");
                    } else {
                        System.out.println("Erro ao inserir: " + response);
                    }
                    break;
                case 2:
                    System.out.println("Consultar");
                    System.out.println("Digite o codigo:");
                    codigo = readInt();
                    func = ConsultarFunc.run(fabricaConexao, dbName, codigo);
                    // Print
                    if (func != null)
                        System.out.println(func.toString());
                    else
                        System.out.println("Funcionario nao encontrado!");
                    break;
                case 3:
                    System.out.println("Excluir");
                    System.out.println("Digite o codigo:");
                    codigo = readInt();
                    response = ExcluirFunc.run(fabricaConexao, dbName, codigo);
                    // Response
                    if (response == null)
                        System.out.println("Excluído com sucesso!");
                    else
                        System.out.println("Erro ao excluir: " + response);
                    break;
                case 4:
                    System.in.close();
                    System.out.println("Sair");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
            System.out.println(menu);
        }
    }
}
