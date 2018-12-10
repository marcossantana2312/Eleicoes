"# Projeto-Eleicoes" 
Aplicação WEB para disciplina de Programação WEB ministrada por Mario Jorge Pereira

Para execução sem transtornos da aplicação é necessário ter o banco de dados relacional PostgreSQL instalado, com a tabela Eleicoes já criada
Defina o usuario e o servidor do banco na classe ConnectionFactory no pacote br.ucsal.eleicoes.jdbc, as suas variáveis são respectivamente user e password
Se o postgres não máquina não tiver rodando na porta default que é a 5432, indicar qual a porta na variável estática url, sobrepondo o 5432
Com os passos anteriores finalizados, rodar como Maven build, e no goal, jetty:run
