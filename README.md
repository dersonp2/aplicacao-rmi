# aplicacao-rmi

Aplicação feita em sala de aula para fins didáticos da disciplina de **Sistemas distribúidos**.


Nesta aplicação há uma interface, um Servidor que implementa esta interface e um Cliente que acessa o metodo remoto. 


Para executar basta: 

- na pasta do projeto compilar as classes através do JavaC

- Transformar a classe Servidor em RMIC através do comando  rmic Servidor

- Iniciar o RMI Registry através do comando rmiregistry &

- Iniciar o Servidor e o Cliente (java Servidor e java Cliente.
