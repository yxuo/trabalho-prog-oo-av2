Trabalho 2 de POO.
Grupo de até 4 alunos.
Apresentação no dia 22/11/2022. Horário de 18:20 às 20:00.
Encaminhar as classes *.java para a atividade a ser criada.

1) Crie o projeto jdbcflusao no Eclipse. Crie a pasta libs no eclipse e arraste o arquivo `mysql-
connector-java-8.0.27.jar` para essa pasta. Clique com o botão direito do mouse no arquivo e

> Link: https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-community-8.0.31.0.msi
>
> Diretório: C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-j-8.0.31.jar

selecione Build Path, escolhendo Add to Build Path.
2) Crie a classe FabricaConexao para acesso JDBC ao trabalho.
3) Crie a classe CriarBanco, para ser criado o banco no MySql.
4) Crie a classe CriarTabelaFunc para criar a tabela func com:

```
CREATE TABLE IF NOT EXISTS func (
codigo INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(80) NOT NULL,
cargo VARCHAR(20) NOT NULL,
end VARCHAR(80) NOT NULL)
```

1) Crie a classe NovoFunc para inserir um registro na tabela func, sendo informados pelo
teclado o nome, cargo e endereço.

6) Crie a classe Func com código, nome, cargo e endereço, métodos get/set e método
construtor.

7) Crie a classe ConsultarFunc para mostrar para cada funcionário o código, nome, cargo e
endereço.

8) Crie a classe EcluirFunc para excluir um funcionário dado o seu código.

# Eclipse

## Importando mysql

Provavelmente está em:

```
C:\Program Files (x86)\MySQL\Connector J 8.0\
``` 

importe o arquivo `mysql-connector-j-x.x.xx.jar` para Referenced Libraries, fazendo o seguinte:

1. Clique com botão direito na pasta de projeto

2. `Build Path` > `Add External Archives...`

3. Escolha o arquivo e pronto.

