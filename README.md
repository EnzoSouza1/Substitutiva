Para executar o código, siga os passos abaixo:

1. Configuração do Projeto Maven:
   - Crie um novo projeto utilizando a ferramenta "Maven".

2. Configuração do arquivo pom.xml:
   - No arquivo `pom.xml`, adicione a seguinte instrução ao final da tag `</properties>` para incluir a dependência necessária:
   
     ```xml
     <dependencies>
         <dependency>
             <groupId>org.json</groupId>
             <artifactId>json</artifactId>
             <version>20210307</version>
         </dependency>
     </dependencies>
     ```

3. Organização do Projeto:
- Dentro da pasta src/main/java, crie um package com o nome desejado para o projeto.

4. Adição dos Arquivos do GitHub:
- Baixe os arquivos necessários do GitHub e adicione-os ao package criado na etapa anterior.
- Certifique-se de excluir o arquivo pom.xml se ele estiver presente nos arquivos baixados, pois já foi configurado anteriormente.

5. Configuração de Threads e Capitais:
   - No código da classe `Main`, localize e ajuste as variáveis nas linhas 8 e 9 para definir o número específico de threads e de capitais por thread conforme necessário.

6. Execução:
   - Após configurar o projeto e ajustar as variáveis conforme desejado, execute o código.

Este procedimento permite configurar e executar o código com a especificação de threads e capitais de acordo com os requisitos do experimento.

Relatório/documentação [Relatorio.pdf](https://github.com/user-attachments/files/16045570/Relatorio.pdf)
