# Curso Tratamento de Execoes Java
**Uma Exceção** é um evento que interrompe o fluxo normal de um processamento de uma classe, com tratamentos delas o programa fica mais resitente a erros e conflitos, o programa continua a rodar mesmo com algum problema. 

----------------------------------------------------

### Hierarquia Throwable.
Error e Exception herdam diretamente da classe Throwable

A diferença entre os dois é que...
  - ERROR é algo que não pode mais ser tratado
  - EXCEPTIONS que trata seus erros.

----------------------------------------------------
### Error
- Indica um erro que não pode ser tratada pela aplicação, fazendo com que sua execução não continue.

-------------------------------------------------------

### Exceptions
 
> **Unchecked Exception ( Runtime )**

- Exceções não verificadas, exeções não checadas pelo compilador
- Ocorrem em tempo de execução e podem ser tratadas, as chamadas Runtime Exceptions. (Ignoradas no tempo de compilação)

[Exemplo](https://github.com/Brunarquino/curso-tratamento-de-execoes-java/blob/master/src/br/com/dio/exceptions/uncheckedException/Exemplo01.java)

> **Checked Exception**

  -  Exceções verificadas, exeções checadas pelo compiladores
  -  Ocorrem em tempo de compilação e devem ser tratadas(Obrigatoriamente)

[Exemplo](https://github.com/Brunarquino/curso-tratamento-de-execoes-java/blob/master/src/br/com/dio/exceptions/checkedException/Exemplo01.java)

> **Exception Personalizada**

- As exceções personalizadas são usadas para tratar uma exceção de acordo com a necessidades.
- Derivadas de uma classe Exception
- Podemos ter sua própria exceção e mensagem
- O seu nome deve termiar com Exception

[Exemplos](https://github.com/Brunarquino/curso-tratamento-de-execoes-java/tree/master/src/br/com/dio/exceptions/exceptionPersonalizada)

Estrutura de blocos para tratamento de exceções

```
try //Tente executar esse bloco
{
  //Região onde se encontra o código que queremos verificar se irá ou não lançar uma exceção.  
}catch(tipo_de_exception e)
{
  //instruções de como tratar essa exceção.
}finally{
  //Opiconal
  //Geralmente utilizado quando precisamos executar algum código independente se ocorrer exception ou não.
}
```
 
 _OBS.: Pode haver mais de um bloco catch, porém, será executado apenas o primeiro bloco que identificar a exceção_
 _OBS.: Respeitar a hierarquia, se um catch com a exception herdeira, vem depois, de um catch com exception acima na hierarquia , ou seja, a catch com exception filho vem primeiro_

---
> **Cláusulas throw/throws**
- throw:
  - Lançar exceções explicitamente
  - Pode ser utilizada tanto para exceções checked ou unchecked
  - Usada principalmente para lançar exceções personalizadas
  - Serve para lançar a exceção de dentro do corpo, Caso o tratador adequado não seja encontrado no bloco onde a execução foi lançada, ela é propagada para o nível mais externo.
```
try { // Faz algo } catch(Exception e){ throw new Exeption(); }
```
- throws: 
  - Usada apenas para exceções checked.
  - Serve apenas para informar
  - Para disparar uma exceção é necessario colocar throws na definição do método, indicando quais tipos de exeções pode retornar.
  - A responsabilidade de tratar o método lançado fica no código que chamou o método, ela pode tratá-la ou lançá-la novamente
```
public void foo (int x, int y) throws Exception 
```


