# FicticiusClean
FicticiusClean empresa de entrega de produtos de limpeza:

O projeto foi desenvolvido em java 8.

### Como rodar o projeto:

#### Direto pela IDE - Exemplo - STS 4 (Spring Tool Suite 4)
-----------------------------------
1. Clonar o projeto para a máquina
2. importar o projeto como um Maven project
3. Run as -> Spring Boot App
-----------------------------------
#### Linux - Terminal
-----------------------------------
1. Baixar o arquivo .jar do repository que fica na pasta /projeto/
2. Acessar o local onde onde foi baixado FicticiusClean-0.0.1-SNAPSHOT.jar
3. Executar o comando java -jar "nomeArquivo.jar" no terminal
-----------------------------------
#### Windows 
-----------------------------------
1. Baixar o arquivo .jar do repository que fica na pasta /projeto/
2. Acessar o local onde onde foi baixado FicticiusClean-0.0.1-SNAPSHOT.jar
3. Executar o comando java -jar "nomeArquivo.jar" no Prompt de Comando
-----------------------------------

### Executar os comandos - a porta de acesso é a 8080 - URL: localhost:8080/api/veiculo...

Foi utilizado o Postman para facilitar a execução dos dados, mas é possível cadastrar, e fazer as execuções através de um navegador web.

#### URLs:

__Mostra veiculos cadastrados__
```
localhost:8080/api/veiculo/listar
```
__Criar 5 veiculos com dados ficticios (dados de teste criados)__
```
localhost:8080/api/veiculo/inserirDadosTeste
```
__Cadastra um veiculo através de parametros__
```
localhost:8080/api/veiculo/salvarParametros?nome="nomeVeiculo"&marca="marcaVeiculo"&modelo="modeloVeiculo"&dataFabricacao="dd/MM/yyyy"&consumoMedioCidade="valor"&consumoMedioRodovia="valor"
```
OBS: inserir cada campo sem aspas, exemplo: ...nome=Fox&...dataFabricacao=01/02/2020...

__Calcula da previsão__
```
localhost:8080/api/veiculo/previsao?precoGasolina="valor"&kmCidade="valor"&kmRodovia="valor"
```
OBS:o "valor" deve ser substituido por valor em double, por exemplo: ...precoGasolina=3.45&kmCidade=5...

__Busca o veiculo com determinado id (id é gerado automaticamente após o cadastro do veículo)__

```
localhost:8080/api/veiculo/"id"
```
__Cadastra um veículo, porém deve ser passado o veículo através do "body" em formato json, como segue o exemplo abaixo:__
```
localhost:8080/api/veiculo/salvar
```
Exemplo: 
```
{
    "nome": "nome_teste",
    "marca": "marca_teste",
    "modelo": "modelo_teste",
    "dataFabricacao": "2011-04-09",
    "consumoMedioCidade": 7.5,
    "consumoMedioRodovia": 11.2
}
```

## Exemplo de execução pelo Postman

#### Listar veiculo (sem ter cadastrado)
![listarVazio](https://user-images.githubusercontent.com/15754200/106294302-c601f700-622d-11eb-99e9-cc38024ffdff.png)

#### Inserir dados de teste
![inserirDadosTeste](https://user-images.githubusercontent.com/15754200/106294838-6c4dfc80-622e-11eb-97b2-71f97369e1e1.png)

#### Listar veiculos cadastrados
![listarPreenchidoAtualizado](https://user-images.githubusercontent.com/15754200/106295017-acad7a80-622e-11eb-9864-03a973153a08.png)

#### Salvar veiculo
![salvar](https://user-images.githubusercontent.com/15754200/106294636-298c2480-622e-11eb-9e09-80bb07fa0bcc.png)

#### Salvar veículo parametro
![salvarParametros](https://user-images.githubusercontent.com/15754200/106294904-8687da80-622e-11eb-814c-dc9a41060d33.png)

#### Cálculo de previsão
![calculoPrevisao](https://user-images.githubusercontent.com/15754200/106298327-84c01600-6232-11eb-8dfc-d1a810b98eb5.png)
