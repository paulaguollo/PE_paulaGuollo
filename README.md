# PE_paulaGuollo
# CodeFest — Sistema de Gestão de Festival

Projeto prático desenvolvido no âmbito da disciplina de **Programação Estruturada** do curso de Software Developer (CESAE Digital).

---

## Descrição

Aplicação de consola em **Java** para gestão do festival de música **CodeFest**. Permite consultar bilhetes, gerir festivaleiros, analisar receitas e explorar a programação musical do festival, com dois modos de acesso distintos: **Admin** e **Festivaleiro**.

---

## Estrutura de Ficheiros

```
PE_nomeAluno/
│
├── src/
│   └── (ficheiros .java)
│
├── data/
│   ├── Festival_Bilhetes.csv
│   ├── Festival_AdminLogin.csv
│   ├── Festival_Cartaz.csv
│   ├── Festival_Quiz.csv
│   ├── Festival_Copyright.txt
│   ├── Palco_Main.txt
│   ├── Palco_Java.txt
│   └── Palco_Commit.txt
│
└── README.md
```

---

## ▶️ Como Executar

1. Certifica-te de que tens o **Java JDK** instalado (versão 8 ou superior).
2. Compila os ficheiros `.java`:
   ```bash
   javac src/*.java
   ```
3. Executa o programa:
   ```bash
   java -cp src Main
   ```
4. Os ficheiros `.csv` e `.txt` devem estar na pasta `data/` (ou no caminho configurado no código).

---

##  Acesso Admin

As credenciais de acesso estão definidas no ficheiro `Festival_AdminLogin.csv`.

Exemplo de credenciais (para teste):
```
admin;festival2026
```

---

## Funcionalidades

### Menu Admin
| Opção | Descrição |
|-------|-----------|
| 1 | Consulta de ficheiros (Bilhetes, Cartaz, Login, Quiz) |
| 2 | Total de bilhetes vendidos e valor faturado |
| 3 | Pesquisa de festivaleiro por ID |
| 4 | Bilhete(s) mais caro(s) |
| 5 | Melhores festivaleiros (maior gasto) |
| 6 | Pesquisa de bilhetes por dia |
| 7 | Receita por tipo de bilhete |
| 8 | Receita por dia do festival |
| 0 | Sair |

### Menu Festivaleiro
| Opção | Descrição |
|-------|-----------|
| 1 | Novo registo de festivaleiro |
| 2 | Procurar lugares de campismo disponíveis |
| 3 | Imprimir cartaz (todos os artistas, sem duplicados) |
| 4 | Imprimir palcos gráficos (ficheiros .txt) |
| 5 | Concerto(s) mais longo(s) |
| 6 | Cartaz filtrado por dia |
| 7 | Cartaz filtrado por género musical |
| 8 | Quiz Musical |
| 0 | Sair |

---

## Ficheiros CSV — Estrutura

**Festival_Bilhetes.csv**
```
idBilhete;idCliente;nomeCliente;contacto;email;dia;tipoBilhete;valor
```

**Festival_Cartaz.csv**
```
idConcerto;dia;hora;palco;artista;genero;duracao
```

**Festival_Quiz.csv**
```
pergunta;opcao1;opcao2;opcao3;opcao4;resposta
```

**Festival_AdminLogin.csv** *(sem cabeçalho)*
```
username;password
```

---

## Nota sobre Lugares de Campismo

Os lugares disponíveis são os **números triangulares múltiplos de 5** entre 1 e 300.

Um número triangular é obtido pela soma dos naturais consecutivos a partir de 1:
> T(n) = n × (n + 1) / 2

Exemplos válidos: 10, 15, 55, 105, 120, 190, 210, 300...

---

## Requisitos Técnicos

- Linguagem: **Java**
- Leitura de ficheiros `.csv` e `.txt`
- Validação de inputs do utilizador
- Menus em loop até o utilizador escolher sair
- Ao sair, imprime o ficheiro `Festival_Copyright.txt`

---

## Autor

**Paula Guollo**  
Curso: Software Developer — CESAE Digital  
Disciplina: Algoritmia - Iniciação e Avançada 
Ano: Maio de 2026
