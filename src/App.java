import Package.*;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String dbName = "lasalle";

        FabricaConexao fabricaConexao = new FabricaConexao();

        CriarBanco.run(fabricaConexao, dbName);
        CriarTabelaFunc.run(fabricaConexao, dbName);

        // Menu: 1. Inserir 2. Consultar 3. Alterar 4. Excluir 5. Sair

        String menu = "1. Inserir 2. Consultar 3. Excluir 4. Sair";
        System.out.println(menu);

        // loop
        while (true) {
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    // Read
                    System.out.println("Inserir");
                    System.out.println("Digite o codigo:");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome:");
                    String nome = sc.next();
                    System.out.println("Digite o cargo:");
                    String cargo = sc.next();
                    System.out.println("Digite o endereço:");
                    String end = sc.next();
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
                    System.out.println("Digite o código:");
                    codigo = sc.nextInt();
                    sc.nextLine();
                    func = ConsultarFunc.run(fabricaConexao, dbName, codigo);
                    // Print
                    if (func != null)
                    System.out.println(func.toString());
                    else
                    System.out.println("Funcionário não encontrado!");
                    break;
                    case 3:
                    System.out.println("Excluir");
                    System.out.println("Digite o código:");
                    codigo = sc.nextInt();
                    response = ExcluirFunc.run(fabricaConexao, dbName, codigo);
                    // Response
                    if (response == null)
                    System.out.println("Excluído com sucesso!");
                    else
                    System.out.println("Erro ao excluir: " + response);
                    break;
                    case 4:
                    System.out.println("Sair");
                    sc.close();
                    System.exit(0);
                    break;
                    default:
                    System.out.println("Opção inválida");
                    break;
                }
                System.out.println(menu);
            }
    }
}
