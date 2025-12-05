# 📘 Linter Pedagógico Inteligente (Spring AI)

> "Mais do que corrigir, ensinar."

Este projeto consiste em uma API REST desenvolvida em **Java** com **Spring Boot**, que utiliza Inteligência Artificial (**Spring AI**) para realizar análises estáticas e pedagógicas de códigos Java. O objetivo principal não é apenas apontar erros, mas atuar como um "Mentor Digital", explicando o *porquê* das falhas e ensinando boas práticas.

## 🎯 Sobre o Projeto

Programadores iniciantes frequentemente enfrentam dificuldades em manter a consistência e a qualidade do código, esbarrando em erros que poderiam ser evitados e recebendo feedbacks "secos" de compiladores tradicionais.

Esta ferramenta visa resolver esse problema oferecendo:

* **Análise Pedagógica:** Explicações claras sobre violações de regras.
* **Boas Práticas:** Verificação de *Clean Code*, princípios *SOLID* e *Design Patterns*.
* **Feedback em Tempo Real:** Redução de retrabalho e aceleração do aprendizado.

## 🚀 Funcionalidades Principais

O sistema vai além de um linter tradicional (como Checkstyle ou PMD), focando na qualidade semântica e estrutural do código através de IA Generativa.

* **Autenticação e Gestão de Usuários:** Cadastro, login e atualização de perfil.
* **Upload e Análise de Arquivos:** Envio de arquivos `.java` para processamento.
* **Relatórios Inteligentes com IA:**
    * Detecção de erros de lógica e sintaxe.
    * Sugestões de refatoração baseadas em *Clean Code*.
    * Identificação de violação de princípios SOLID.
    * Sugestão de *Design Patterns* aplicáveis.
    *  Explicação educativa do erro (o "porquê" está errado).

## 🛠️ Tecnologias Utilizadas

*  **Linguagem:** Java 17+ 
* **Framework:** Spring Boot 3.x
* **IA Integration:** Spring AI (OpenAI/Ollama/Azure - *configurável*)
* **Banco de Dados:** PostgreSQL (sugerido para persistência de usuários/relatórios)
*  **Testes:** JUnit 5 
*  **Ferramentas:** IntelliJ IDEA, Git.

## 🔌 Documentação da API

Abaixo estão os principais *endpoints* da aplicação.

### 👤 Usuários (User Management)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/auth/register` | Cria uma nova conta de usuário (Aluno/Professor). |
| `POST` | `/auth/login` | Autentica o usuário e retorna o token (JWT). |
| `PUT` | `/users/{id}` | Atualiza dados do usuário. |
| `POST` | `/auth/logout` | Realiza o logout do usuário. |

### 📝 Relatórios e Análise (Reports)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/reports/upload` | Envia um arquivo `.java` para análise da IA. |
| `GET` | `/reports` | Lista todos os relatórios gerados pelo usuário logado. |
| `GET` | `/reports/{id}` | Retorna os detalhes de um relatório específico (JSON/PDF). |

## 🧠 Como Funciona a Análise (Exemplo)

Quando um aluno envia um código com variáveis mal nomeadas ou lógica confusa:

**Entrada (Código do Aluno):**

```java
int s(int a, int b) {
    int x = 0; // x não é usado
    return a + b;
}
```

**Saída (Relatório da API):**

> **⚠️ Aviso de Clean Code:** O nome da função `s` não é descritivo.
>
>   * **Explicação:** Nomes de métodos devem revelar a intenção do que eles fazem.
>   * **Sugestão:** Renomeie para `somar(int a, int b)`.
>
> **⚠️ Variável Não Utilizada:** A variável `x` foi inicializada mas nunca usada.
>  \* **Impacto:** Isso consome memória desnecessária e polui a leitura do código.

## 👥 Equipe de Desenvolvimento

Projeto desenvolvido por alunos da **PUC Campinas**:

* **Gabriel Hemo Gonçalves Santos** (RA: 24011872) 
* **Igor Hein Dalan** (RA: 24023696) 
* **João Henrique Lopes Divino** (RA: 24000599) 
* **Marcus Vinícius Lopes Divino** (RA: 24005440) 
* **Vinicius Bueno de Oliveira** (RA: 24007569) 
* **Lucas Joaquim de Souza** (RA: 24020901) 

## 🏁 Como Executar

1.  Clone este repositório:
    ```bash
    git clone https://github.com/seu-usuario/linter-pedagogico-ai.git
    ```
2.  Configure as variáveis de ambiente (Chave da API da IA e Banco de Dados) no `application.properties`.
3.  Execute o projeto via Maven ou na IDE:
    ```bash
    ./mvnw spring-boot:run
    ```

-----

*Este projeto foi idealizado para mitigar a evasão em cursos de programação e auxiliar no onboarding de novos desenvolvedores.*