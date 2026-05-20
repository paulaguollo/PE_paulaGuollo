# CodeFest — Sistema de Gestão de Festival de Música

Projeto prático desenvolvido no âmbito da disciplina de **Programação Estruturada** do curso de Software Developer — CESAE Digital.

---

## Descrição

Aplicação de consola em **Java** para gestão do festival de música **CodeFest 2026**.  
Permite consultar bilhetes, gerir festivaleiros, analisar receitas e explorar a programação musical do festival, com dois modos de acesso distintos: **Admin** e **Festivaleiro**.

---

## Estrutura do Projeto

```
PE_paulaGuollo/
│
├── CodeFest/
│   ├── src/
│   │   └── CodeFest/
│   │       ├── Menus.java                   ← Ponto de entrada (main) + menu de login
│   │       ├── MenuADM.java                 ← Menu do administrador
│   │       ├── MenuFestivaleiro.java         ← Menu do festivaleiro
│   │       ├── BibliotecaADM.java           ← Funções administrativas
│   │       ├── BibliotecaFestivaleiro.java  ← Funções do festivaleiro
│   │       ├── BibliotecaFicheiros.java     ← Leitura de ficheiros CSV
│   │       └── BibliotecaFormatacao.java    ← Utilitários de formatação e impressão
│   │
│   └── data/
│       ├── Festival_Bilhetes.csv
│       ├── Festival_AdminLogin.csv
│       ├── Festival_Cartaz.csv
│       ├── Festival_Quiz.csv
│       ├── Festival_Copyright.txt
│       ├── Palco_Main.txt
│       ├── Palco_Java.txt
│       └── Palco_Commit.txt
│
└── README.md
```

---

## Como Executar

1. Certifica-te de que tens o **Java JDK 8+** instalado.
2. Abre o projeto no **IntelliJ IDEA** (ou IDE à tua escolha).
3. Define `Menus.java` como classe de execução principal.
4. Os ficheiros de dados devem estar na pasta `CodeFest/data/` (já incluídos no projeto).
5. Executa o programa — o menu de login será apresentado na consola.

> ⚠️ Os caminhos dos ficheiros são relativos à raiz do módulo `CodeFest`. Certifica-te de que o working directory está configurado corretamente no IntelliJ (`Run > Edit Configurations > Working directory`).

---

## Acesso Admin

As credenciais de acesso são lidas do ficheiro `Festival_AdminLogin.csv` (sem cabeçalho):

```
username;password
```

Exemplo de credenciais para teste (verifica o ficheiro para as credenciais reais):
```
admin;festival2026
```

---

## Funcionalidades

### Menu Admin

| Opção | Funcionalidade |
|:-----:|----------------|
| 1 | Consulta de ficheiros (Bilhetes, Cartaz, Login, Quiz) |
| 2 | Total de bilhetes vendidos e valor total faturado |
| 3 | Pesquisa de festivaleiro por ID (bilhetes + total gasto) |
| 4 | Bilhete(s) mais caro(s) |
| 5 | Melhores festivaleiros (maior total gasto) |
| 6 | Bilhetes vendidos por dia do festival |
| 7 | Receita por tipo de bilhete (Diário, VIP, Backstage) |
| 8 | Receita total por dia do festival |
| 0 | Sair |

### Menu Festivaleiro

| Opção | Funcionalidade |
|:-----:|----------------|
| 1 | Novo registo de festivaleiro (simulado em memória) |
| 2 | Lugares de campismo disponíveis (triangulares × 5, até 300) |
| 3 | Cartaz completo — artistas sem duplicados |
| 4 | Palcos gráficos (conteúdo ASCII dos ficheiros .txt) |
| 5 | Concerto(s) mais longo(s) |
| 6 | Cartaz filtrado por dia (Sexta / Sábado / Domingo) |
| 7 | Cartaz filtrado por género musical |
| 8 | Quiz Musical interativo |
| 0 | Sair |

---

## Estrutura dos Ficheiros CSV

**Festival_Bilhetes.csv**
```
idBilhete ; idCliente ; nomeCliente ; contacto ; email ; dia ; tipoBilhete ; valor
```

**Festival_Cartaz.csv**
```
idConcerto ; dia ; hora ; palco ; artista ; genero ; duracao
```

**Festival_Quiz.csv**
```
pergunta ; opcao1 ; opcao2 ; opcao3 ; opcao4 ; resposta
```

**Festival_AdminLogin.csv** *(sem cabeçalho)*
```
username ; password
```

---

## Nota Técnica — Lugares de Campismo

Os lugares disponíveis são os **números triangulares múltiplos de 5** entre 1 e 300.

Um número triangular é dado por: `T(n) = 1 + 2 + 3 + ... + n`

Exemplos de resultados válidos: **10, 15, 55, 105, 120, 190, 210, 300**

---

## Decisões de Implementação

- Todos os ficheiros CSV são carregados para **matrizes `String[][]`** no arranque do programa, evitando leituras repetidas.
- Os menus repetem em **loop `do-while`** até o utilizador escolher a opção `0`.
- As comparações de texto (dia, género, tipo de bilhete) usam **`equalsIgnoreCase`** para tolerar diferenças de capitalização.
- O input de textos com espaços (géneros musicais, nomes) usa **`nextLine()`** com limpeza prévia do buffer após `next()`.
- Ao sair de qualquer menu, o ficheiro `Festival_Copyright.txt` é impresso na consola.

---

## Autor

**Paula Guollo**  
Curso: Software Developer — CESAE Digital  
Disciplina: Programação Estruturada  
Data de entrega: Maio de 2026
