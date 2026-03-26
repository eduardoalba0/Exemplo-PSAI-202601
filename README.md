# Projeto - Programação de Software e Aplicativos I (PSA I)

Este repositório contém o projeto de API REST desenvolvido com Spring Boot, referente às aulas da disciplina de **Programação de Software e Aplicativos I (PSA I)**, ofertada no curso de Bacharelado em Sistemas de Informação do **Instituto Federal do Paraná (IFPR) - Campus Palmas**. O desenvolvimento ocorreu durante o semestre letivo de **2026/01**.

**Professor da Disciplina:** Prof. MSc. Eduardo Luiz Alba.

## 💻 Tecnologias e Conceitos Abordados
Este projeto explora as seguintes tecnologias e conceitos de engenharia de software presentes na ementa da disciplina:
* **Java e Spring Boot:** Criação de aplicações de forma simples e rápida, já contendo um servidor web embutido (Tomcat).
* **API RESTful:** Implementação de endpoints e uso prático dos métodos HTTP (GET, POST, PUT, DELETE).
* **Persistência de Dados:** Integração com banco de dados utilizando Spring Data JPA para a implementação de repositórios baseados em interfaces.

## 🚀 Como baixar e executar o projeto no IntelliJ IDEA

O IntelliJ IDEA é uma excelente IDE para o desenvolvimento Java. Siga os passos abaixo para importar e rodar a aplicação localmente:

### Pré-requisitos
* **Java JDK** instalado na máquina.
* **IntelliJ IDEA** instalado.
* **Git** (opcional, para clonar o repositório).

### Passo a Passo

1. **Baixe o código-fonte:** Clone o repositório via terminal utilizando o Git (`git clone https://github.com/eduardoalba0/Exemplo-PSAI-202601`) ou baixe o arquivo ZIP da plataforma e descompacte-o em seu computador.
2. **Importe o projeto no IntelliJ:** Abra o IntelliJ IDEA. Na tela inicial, clique em **Open** (ou no menu superior acesse `File > Open`). Selecione a pasta raiz do projeto, que contém o arquivo `pom.xml`, e clique em **OK**.
3. **Sincronize as dependências (Maven):** Como o projeto utiliza o gerenciador Maven, ao abrir o diretório, a IDE detectará o arquivo `pom.xml` e começará a baixar as dependências do Spring Boot automaticamente. Aguarde a conclusão deste processo. Se não iniciar o download, você pode forçar a sincronização clicando com o botão direito no ícone do Maven do lado direito do IntelliJ e selecionando a opção "**Download Sources**" ou "**Reimport**".
4. **Crie e configure o src/resources/application.properties**: Certifique-se de que o arquivo `application.properties` esteja presente na pasta `src/main/resources`. Este arquivo é essencial para configurar as propriedades da aplicação, como a conexão com o banco de dados. Crie um arquivo com este nome e adicione as configurações necessárias para o seu ambiente de desenvolvimento (por exemplo, URL do banco de dados, usuário e senha). Siga o arquivo application.properties.example como modelo para criar o seu arquivo de configuração.
5. **Execute a aplicação:** No painel explorador de arquivos, navegue até a pasta `src/main/java` e encontre a classe principal do projeto. Esta classe estará anotada com `@SpringBootApplication` e conterá o método `public static void main`. Clique com o botão direito sobre o nome desta classe e selecione a opção **Run** (ou clique no ícone de "Play" ao lado do método).
5. **Teste a API:** Acompanhe o terminal (Console) da IDE. Quando a mensagem indicando que o Tomcat foi iniciado na porta 8080 aparecer, a aplicação estará no ar. Utilize o seu navegador ou uma ferramenta de requisições REST (como o Postman) para acessar e testar os serviços em `http://localhost:8080`.
