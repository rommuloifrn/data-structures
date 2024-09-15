# Hashtable (tabela de dispersão)
// TODO: parte de busca
Índice:
- A função de dispersão (hash)
- Inserção
- Lidando com colisões: Linear Probing
- Lidando com colisões: Hashing duplo

A hashtable é uma implementação do dicionário, que por meio de uma <b>função de dispersão</b> consegue dispôr os elementos na lista de forma "aleatória", mantendo a complexidade temporal da pesquisa em O(1).

A ideia é que, usando um array, a função de dispersão defina a posição do elemento sendo inserido. Como essa posição é calculada (O(1)), a pesquisa usando a mesma chave vai chamar a função de dispersão e acessar direto o endereço do elemento no array, em tempo constante.


## 1. A função de dispersão (******há muita variedade nos tipos delas?)

A função de dispersão precisa levar em conta o tamanho do array, caso contrário ela pode usar somente parte do array (o que levaria a mais <u>colisões</u>) ou fazer inserções em endereços que estão fora da área de memória.

Uma função de dispersão comum seria h(x) = x%tamanhoDoArray.

## 2. Inserção

Considere um array de tamanho 12:

![](image.png)

Vamos inserir alguns números. 23, 178, 38 e 56. Ficamos assim:

![alt text](image-3.png)

## 3. Lidando com colisões

A função de hash pode retornar um endereço já preenchido anteriormente. Segue algumas formas de lidar com esse erro.

### 3.1 Encadeamento

<b>Encadeamento</b> é a forma mais simples. Caso haja uma colisão, armazena os itens numa sequência (lista, array). Você pode desde o início usar uma matriz, por exemplo. Vejamos:

Vamos pegar o exemplo do item 2 e adicionar o num....

FOTO

Con


### 3.2 Endereçamento

<u>Endereçamento</u> é um método onde arranjamos o elemento em outra posição no array, e pode ser feito tradicionalmente de duas formas:

### 3.2.1 Linear probing

### 3.2.2 Hashing duplo
