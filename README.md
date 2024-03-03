<h1 align="center"> GraphKP </h1>
 
<br>

<p>

<img align="right" src="https://user-images.githubusercontent.com/114815898/232342528-026e718d-f4ce-4e2b-9ec1-508b3484546a.png" width="297" height="293" title="allen-san">

### 1. Essa aplicação foi idealizada com o simples propósito de resolver um problema de  
### 2. Sua criação se deu como forma de estudo e adquirimento de experiência com projetos de larga escala, ou seja, foi produzida por uma só pessoa. 

</p>

<br>

---

<br>

<h3 align="center"> CABEÇALHOS PADRÃO </h3> 
<br>
<br>

```c
# include <stdio.h>
# include <stdlib.h>
# include <math.h>
# include <errno.h>
# include <setjmp.h>
# include <assert.h>
# include <signal.h>
# include <locale.h>
# include <string.h>
# include <windows.h>
# include <stdarg.h>
# include <commctrl.h>
# include <iso646.h>
# include <ctype.h>
# include <stdbool.h>
# include <conio.h>
# include <time.h>
# include <dirent.h>
# include <sys/stat.h>
# include <sys/types.h>
# include <pthread.h>
# include <limits.h>
```

<br> <br>

---

<br>

<h3 align="center"> OBSERVAÇÕES E AVISOS </h3> 

<br>
<br>

- A biblioteca possui suporte ao uso de `threads`, portanto é uma boa, pesquisar sobre;
- Qual é a diferença entre `float` e `double`? float é de formato 32 bits e double de 64 bits, ou seja, double possui um melhor arredondamento;
- A biblioteca foi produzida durante o segundo semestre de ciências da computação, e levou em torno de 3 semanas para ser concluida, fora a documentação;
- A biblioteca não está passível de bugs, caso ocorra reporte na aba issues, e leve em consideração que foi feita por uma só pessoa;
- Em relação a possíveis dúvidas que as documentações desse artigo tragam ou não solucionem, o `chat-gpt` tem capacidade de explicar : );
- A biblioteca é de `código aberto`, ou seja, não possui direitos autorais ( como se alguém fosse licenciar uma simples biblioteca ) e qualquer um pode usar ou melhorar;
- Inicialmente a biblioteca, nas atuais funções `SB` teriam outro nome -> `W`, onde basicamente serviriam para projetar seu próprio programa com interface gráfica, só não foram adicionadas pois perdi o interesse por causa do tempo;
- A biblioteca só funciona no `Windows`, o uso recomendável é no Code::Blocks.

<br> <br>

---

<br>

<h3 align="center"> MACROS DA BIBLIOTECA </h3> 

<br>

#### REGIÕES DO CONSOLE / CÓDIGO DE PÁGINA

| MACRO                                              | Descrição                                                         |
| :------------------------------------------------- | :---------------------------------------------------------------- |
| `DEFAULT`                                          | Define o console como o padrão da linguagem C ( sem acentuação)   |
| `BRAZIL`                                           | Define o console como o nosso pt-br com acentuação                |
| `LATIN`                                            | Define o console como latino não pt-br, possui alguns caracteres  |
| `CIRILICO`                                         | Define o console como do tipo cirílico ( й , и , к , с )          | 
| `JAPAN`                                            | Define o console como do tipo japonês ( 日 , 本 , 語 )             |
| `COREAN`                                           | Define o console como do tipo coreano ( 한 , 글 , 입니다 )         |
| `GREGO`                                            | Define o console como do tipo grego ( Γ , ε , ι , α , σ , μ , ό ) |
| `TURCO`                                            | Define o console como do tipo turco ( ö , ş , ğ )                 |
| `ISO`                                              | Padroniza o console para printar texto de string acentuado        |

<br>

> Esses macros devem ser utilizados somente nas seguintes funções: `SYS_REGION` e `CS_SETREGION`;
  
<br>
<br>

#### ESTILIZAÇÃO DO TEXTO

| MACRO                                              | Descrição                                                         |
| :------------------------------------------------- | :---------------------------------------------------------------- |
| `BRIGHT1`                                          | Deixa o texto ou fundo brilhantes                                 |
| `BRIGHT2`                                          | Deixa o texto ou fundo brilhantes                                 |
| `UNBRIGHT`                                         | Deixa o texto ou fundo escurecidos                                |
| `ITALIC`                                           | Deixa o texto escrito na forma itálica                            |
| `UNDERLINE`                                        | Deixa o texto escrito sublinhado                                  |
| `BLINKER1`                                         | Deixa o texto ou fundo piscando                                   |
| `BLINKER2`                                         | Deixa o texto ou fundo piscando                                   |
| `BACKSET`                                          | Deixa o fundo esbranquiçado                                       |
| `HIDE`                                             | Deixa o texto escrito escondido                                   |
| `CUT`                                              | Deixa o texto escrito cortado                                     |

<br>

> Esses macros devem ser utilizados somente na seguinte função: `PROP_TEXTSTYLE` quando `ENABLEPROPS` tiver sido chamado;

<br>
<br>

#### CORES DE ESTILIZAÇÃO DE TEXTO

| TEXTO                                              | PLANO DE FUNDO                                                    |
| :------------------------------------------------- | :---------------------------------------------------------------- |
| `DEFAULT_TEXT`                                     | `DEFAULT_BACKGROUND`                                              |
| `BLACK_TEXT`                                       | `RED_BACKGROUND`                                                  |
| `RED_TEXT`                                         | `GREEN_BACKGROUND`                                                |
| `GREEN_TEXT`                                       | `YELLOW_BACKGROUND`                                               | 
| `YELLOW_TEXT`                                      | `BLUE_BACKGROUND`                                                 |
| `BLUE_TEXT`                                        | `MAGENTA_BACKGROUND`                                              |
| `MAGENTA_TEXT`                                     | `CYAN_BACKGROUND`                                                 |
| `CYAN_TEXT`                                        | `WHITE_BACKGROUND`                                                |
| `WHITE_TEXT`                                       |                                                                   |

<br>

> Esses macros devem ser utilizados somente nas seguintes funções: `PROP_TEXTCOLOR` e `PROP_BACKGROUNDCOLOR` quando `ENABLEPROPS` tiver sido chamado;

<br>
<br>

#### FUNÇÕES DE STRINGS

| MACRO                                              | Descrição                                                           |
| :------------------------------------------------- | :------------------------------------------------------------------ |
| `stringSZ`                                         | A função GWC_STRING, lerá uma string com um tamanho máximo          |
| `stringEQ`                                         | A função GWC_STRING, lerá uma string até que seja diferente de algo |
| `stringDF`                                         | A função GWC_STRING, lerá uma string até que seja igual a algo      |
| `stringNR`                                         | A função GWC_STRING, lerá uma string normalmente e PR_STRING printará normalmente                   |
| `stringIV`                                         | A função PR_STRING, printará a string de forma invertida            |
| `stringHB`                                         | A função PR_STRING, printará a string em caixa alta ( formatada )   |
| `stringLB`                                         | A função PR_STRING, printará a string em caixa baixa ( formatada )  |
| `stringCY`                                         | A função PR_STRING, printará a string criptografada ( formatada )   |
| `nosubs`                                           | Macro para dizer que não deseja substituições em PR_STRING          |
| `notext`                                           | Macro para dizer que não terá nenhum texto em GWC_STRING            |
| `nosize`                                           | Macro para dizer que não tem limite de tamanho                      |
| `notoken`                                          | Macro para dizer que não há substiuição                             | 
| `norchar`                                          | Macro para dizer que não há char de substiuição                     |

<br>

> Esses macros devem ser utilizados somente nas seguintes funções: `GWC_STRING` e `PR_STRING`;

<br>
<br>

#### OPERADORES

| MACRO                                              | Descrição                                                           |
| :------------------------------------------------- | :------------------------------------------------------------------ |
| `HT`                                               | MAIOR QUE      ( > )                                                |
| `LT`                                               | MENOR QUE      ( < )                                                |
| `EQ`                                               | IGUAL          ( == )                                               |
| `DF`                                               | DIFERENTE      ( != )                                               |
| `HE`                                               | MAIOR OU IGUAL ( >= )                                               |
| `LE`                                               | MENOR OU IGUAL ( <= )                                               |
| `NRM`                                              | NORMAL / SEM RESTRIÇÕES                                             |
| `CRY`                                              | CRIPTOGRAFIA                                                        |
| `SZE`                                              | TAMANHO                                                             |
| `PWD`                                              | SENHA / PASSWORD ( COM NÚMEROS )                                    |
| `ONS`                                              | SOMENTE TEXTO                                                       |
| `PWS`                                              | SENHA / PASSWORD ( SEM NÚMEROS )                                    |
| `ONN`                                              | SOMENTE NÚMEROS                                                     |
| `PWN`                                              | SENHA / PASSWORD ( SÓ NÚMEROS )                                     |
| `PAR`                                              | SE O VALOR FOR PAR                                                  |
| `IMPAR`                                            | SE O VALOR FOR IMPAR                                                |
| `MULTIPLO`                                         | SE O VALOR FOR MÚLTIPLO DO OUTRO                                    |
| `QUADRADO_X_DF_Y`                                  | x² != y                                                             |
| `QUADRADO_X_EQ_Y`                                  | x² == y                                                             |
| `INVERSO`                                          | INVERTE O VETOR OU MATRIZ                                           |
| `CRESCENTE`                                        | ORGANIZAÇÃO DO VETOR OU MATRIZ DE FORMA CRESCENTE ( BUBBLE SORT )   |
| `DECRESCENTE`                                      | ORGANIZAÇÃO DO VETOR OU MATRIZ DE FORMA DECRESCENTE ( BUBBLE SORT ) |
| `NOTMULTIPLO`                                      | SE O VALOR NÃO FOR MÚLTIPLO DO OUTRO                                |

<br>

> Esses macros devem ser utilizados somente nas seguintes funções: `allen_SUBSINTARRAY` , `allen_COPYINTARRAY` , `allen_SUBSINTBARRAY` , `allen_COPYINTBARRAY` , `GWC_INT` , `GWC_DOUBLE` , `GWC_FLOAT` , `GWC_CHAR` , `getI` , `getF` , `getD`;

<br>
<br>

#### ALLEN DEFINEDS

| MACRO                                              | Descrição                                                           |
| :------------------------------------------------- | :------------------------------------------------------------------ |
| `YES` , ` yes ` , `SIM` , `sim`                    | Serve como uma variável booleana                                    |
| `NO` , ` no ` , `NAO` , `nao`                      | Serve como uma variável booleana                                    |
| `se`                                               | if                                                                  | 
| `e_se`                                             | else if                                                             | 
| `outro`                                            | else                                                                | 
| `para`                                             | for                                                                 | 
| `quebre`                                           | break                                                               | 
| `caso`                                             | case                                                                | 
| `caractere`                                        | char                                                                | 
| `constante`                                        | const                                                               | 
| `padrao` , `outro_caso`                            | default                                                             | 
| `faca`                                             | do                                                                  | 
| `enquanto`                                         | while                                                               | 
| `real`                                             | float                                                               | 
| `real_64`                                          | double                                                              | 
| `inteiro`                                          | int                                                                 |
| `longo`                                            | long                                                                |
| `retorne` , `devolva` , `salve`                    | return                                                              |
| `curto`                                            | short                                                               |
| `tamanho_de`                                       | sizeof                                                              |
| `estatico`                                         | static                                                              |
| `registro`                                         | struct                                                              |
| `escolha`                                          | switch                                                              |
| `tipo_de`                                          | typedef                                                             |
| `uniao`                                            | union                                                               |
| `vazio`                                            | void                                                                |
| `open`                                             | (                                                                   |
| `close`                                            | )                                                                   |
| `end`                                              | ;                                                                   |
| `booleana`                                         | bool                                                                |

<br>

> Esses macros podem ser utilizados em qualquer lugar: exemplo `se ( x > 12 ) printf("arroz");`

<br>

---

<br>

<h3 align="center"> FUNÇÕES </h3> 

<h4 align="center"> CLIQUE PARA ACESSAR A DOCUMENTAÇÃO DAS FUNÇÕES </h4>

<br>

### <p align="center"> <a href="https://github.com/AllisonJunior/allen.h/blob/main/FUNCTIONS_DESCRIPTION/RESUME.md" title="Listagem Rápida de Funções."> Resumo das funções </a> </p>

<br>

### <p align="center"> <a href="https://github.com/AllisonJunior/allen.h/blob/main/FUNCTIONS_DESCRIPTION/PR.md" title="Funções de print formatado."> 1. PR </a> </p>
### <p align="center"> <a href="https://github.com/AllisonJunior/allen.h/blob/main/FUNCTIONS_DESCRIPTION/CS.md" title="Funções de controle do console."> 2. CS </a> </p>
### <p align="center"> <a href="https://github.com/AllisonJunior/allen.h/blob/main/FUNCTIONS_DESCRIPTION/SYS.md" title="Funções de controle do sistema."> 3. SYS </a> </p>
### <p align="center"> <a href="https://github.com/AllisonJunior/allen.h/blob/main/FUNCTIONS_DESCRIPTION/PROPS.md" title="Funções de estilização do texto."> 4. PROPS </a> </p>
### <p align="center"> <a href="https://github.com/AllisonJunior/allen.h/blob/main/FUNCTIONS_DESCRIPTION/G.md" title="Funções de controle de entrada stdin."> 5. G </a> </p>
### <p align="center"> <a href="https://github.com/AllisonJunior/allen.h/blob/main/FUNCTIONS_DESCRIPTION/allen.md" title="Funções genêricas da biblioteca."> 6. allen </a> </p>
### <p align="center"> <a href="https://github.com/AllisonJunior/allen.h/blob/main/FUNCTIONS_DESCRIPTION/SB.md" title="Funções para uso de MESSAGEBOXES e WindowsSystemAudios."> 7. SB </a> </p>
### <p align="center"> <a href="https://github.com/AllisonJunior/allen.h/blob/main/FUNCTIONS_DESCRIPTION/MATTE.md" title="Funções matemáticas."> 8. MATTE </a> </p>
### <p align="center"> <a href="https://github.com/AllisonJunior/allen.h/blob/main/FUNCTIONS_DESCRIPTION/LOCH.md" title="Funções do setlocale."> 9. LOCH </a> </p>
### <p align="center"> <a href="https://github.com/AllisonJunior/allen.h/blob/main/FUNCTIONS_DESCRIPTION/FLEE.md" title="Funções para controle total sobre arquivos."> 10. FLEE </a> </p>



<br>

---


