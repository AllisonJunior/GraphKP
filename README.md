# Krukal e Prim

---

### 1 - PROJETO ESCOLHIDO: **`Restaurante Universitário`**

> O projeto utilizado para a aplicação do padrão de projeto foi o segundo, 
> o qual se refere a criação de um sistema de restaurante, que simulava uma 
> sessão de cardápios, com base no conceito do Restaurante Universitário da
> faculdade.

---

### 2 - PADRÃO DE PROJETO UTILIZADO: **`Abstract Factory`**

### 2.1 - O que é:
> O padrão de projeto **Abstract Factory**, também conhecido como **Factory of 
> Factories ou Kit**, é um padrão de projeto de criação que fornece uma 
> interface para criar famílias de objetos relacionados ou dependentes 
> sem especificar suas **classes concretas**. Ele faz parte do grupo de 
> padrões de projeto criacionais e é amplamente utilizado na engenharia 
> de software para criar sistemas que são independentes da maneira como 
> seus objetos são criados, compostos e representados.

### 2.2 - Propriedades:
> **Basicamente esse padrão possui múltiplas propriedades e características, como:** <br>
> 1. *Abstração de criação;*
> 2. *Separação de responsabilidades;*
> 3. *Flexibilidade;*
> 4. *Extensabilidade;*
> 5. *Garantia de consitência;*
> 6. *Encapsulamento;*
> 7. *Manutenção simplificada;*
> 8. *Reusabilidade;*
> 9. *Segurança de tipos;*
> 10. *Polimorfismo.*

### 2.3 - Componentes:
> **Já em relação aos seus componentes temos os seguintes:**

> **1. Abstract Factory:** É uma interface ou classe abstrata que define 
> os métodos para criar objetos de diferentes famílias. Geralmente, há um 
> método abstrato para cada tipo de objeto que a fábrica pode criar. Por 
> exemplo, se a fábrica estiver criando elementos de interface do usuário, 
> pode haver métodos abstratos para criar botões, caixas de texto, janelas etc.

> **2. Concrete Factory:** São classes concretas que implementam a interface 
> da Fábrica Abstrata. Cada Concrete Factory é responsável por criar uma família 
> específica de objetos relacionados. Por exemplo, pode haver uma Concrete Factory 
> para criar elementos de interface do usuário no estilo Windows e outra para 
> criar elementos no estilo macOS.

> **3. Abstract Product:**  É uma interface ou classe abstrata que define os objetos 
> a serem criados pelas fábricas. Cada método na Fábrica Abstrata corresponde a um 
> tipo de Produto Abstrato. Por exemplo, se a Fábrica Abstrata criar elementos de 
> interface do usuário, pode haver uma interface Produto Abstrato para botões, outra 
> para caixas de texto, etc.

> **4. Concrete Product:** São classes concretas que implementam as interfaces de 
> Produto Abstrato. Essas classes representam os objetos reais criados pelas fábricas. 
> Por exemplo, pode haver uma classe Concrete Product para botões no estilo Windows e 
> outra para botões no estilo macOS.

> **5. Código Cliente:** É o código que utiliza as fábricas e os produtos criados por 
> essas fábricas. O Cliente interage apenas com as interfaces abstratas (Fábrica Abstrata 
> e Produto Abstrato), sem conhecer as classes concretas que estão sendo usadas. O Cliente 
> solicita os objetos à Fábrica Abstrata e os utiliza em seu código.

### 2.4 - Como foi utilizado nesse projeto:
> Basicamente nesse projeto temos uma package chamada *abs_fac* que contém todos os
> arquivos desse padrão de projeto, específicamente:
> 
> **Package:** classes
> > ***AlimentosFactory*** , ***BebidaImpl*** , ***PratoPrincipalImpl*** , ***SobremesaImpl***
>
> **Package:** interfaces
> > ***AbstractFactory*** , ***Bebida*** , ***PratoPrincipal*** , ***Sobremesa***
> 
> **Classe:** Days.java
> 
> Enfim, na package classes temos todas as classes concretas que implementam as interfaces
> e definem seu atributo específico, para então na classe **Days**, instânciarmos a fábrica
> com a classe concreta e assim permitir a criação de objetos com base em uma interface.
> 
> **Onde em vez de fazer isso:**
> ```java
> // ...
> 
> /* Instânciação dos nossos objetos sem o uso do padrão */
> public static PratoPrincipalImpl segunda_PratoPrincipal = new PratoPrincipalImpl ();
> public static BebidaImpl segunda_Bebida = new BebidaImpl ();
> public static SobremesaImpl segunda_Sobremesa = new SobremesaImpl ();
> 
> // ...
> ```
> **Podemos fazer isso:**
> ```java
> // ...
> 
> /* Criação da nossa fábrica ( Interface <- Classe Concreta ) */
> final static AbstractFactory fábrica = new AlimentosFactory ();
> 
> /* Criação dos objetos utilizando as interfaces + fábrica */
> public static PratoPrincipal segunda_PratoPrincipal = fábrica . criarUmPratoPrincipal ();
> public static Bebida segunda_Bebida = fábrica . criarUmaBebida ();
> public static Sobremesa segunda_Sobremesa = fábrica . criarUmaSobremesa ();
> 
> // ...
> ```
> 
> Portanto, apesar da implementação nesse projeto não ser tão boa, deixa clara aplicação do
> padrão de projeto, que é a de criar os objetos utilizados no código utilizando a interface
> de fábrica abstrata.
---

### 3 - COMO A APLICAÇÃO FUNCIONA?

> **1º )** A organização do projeto se dá a partir do módulo '***src***' que em seu interior possui 
> uma classe '***Main***' que basicamente é responsável por executar a thread inicial do programa 
> inicializando a interface gráfica. 
> 
> **2º )** O módulo '***src***' contém diversas packages que auxíliam no funcionamento e organização do programa
> como por exemplo a package '***abs_fac***' além de aplicar o padrão de projeto instância para toda a aplicação
> os objetos que serão utilizados no display de alimentos, ou a package '***graphics***' que contem todas as classes
> que servem para a padronização de componentes gráficos no nosso programa.
> 
> **3º )** A aplicação foi simplificada com somente 3 interfaces gráficas ( *Menu Principal* , *Administração* e *Clientes* )
> onde nas 2 útlimas se é utilizado os objetos salvos na classe '***Days***' para alterar as caixas de texto e mostrar os alimentos
> que estão salvos no sistema.
> 
> ```lua
> Trabalho 04
> ├── src
> │   ├── Main.java
> |   ├── abs_fac
> |   |      ├── classes
> |   |      |      ├── AlimentosFactory.java
> |   |      |      ├── BebidaImpl.java
> |   |      |      ├── PratoPrincipalImpl.java
> |   |      |      └── SobremesaImpl.java
> |   |      ├── interfaces
> |   |      |      ├── AbstractFactory.java
> |   |      |      ├── Bebida.java
> |   |      |      ├── PratoPrincipal.java
> |   |      |      └── Sobremesa.java
> |   |      └── Days.java
> |   ├── acess
> |   |      └── Checker.java
> |   ├── graphics
> |   |      ├── Botão.java 
> |   |      ├── Caixa.java 
> |   |      ├── Janela.java 
> |   |      └── Texto.java 
> |   ├── interfaces
> |   |      ├── Administração.java 
> |   |      ├── Clientes.java
> |   |      └── MenuPrincipal.java 
> |   ├── res
> |   |     ├── cursor_def.png
> |   |     ├── cursor_hov.png
> |   |     └── def_icon.png 
> |   ├── utils
> |   |      ├── Controle.java
> |   |      ├── Cores.java
> |   |      ├── Fontes.java
> |   |      └── Imagens.java
> └── └── README.MD
> ```
