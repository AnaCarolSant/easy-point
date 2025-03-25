# Teste de Requisições no Postman - Easy Point API

## 1. Listar Todos os Pontos

**Método:** GET\
**URL:** [http://localhost:8080/api/pontos](http://localhost:8080/api/pontos)\
**Resposta Esperada:** Lista de todos os registros de ponto.

---

## 2. Criar um Ponto

**Método:** POST\
**URL:** [http://localhost:8080/api/pontos](http://localhost:8080/api/pontos)\
**Headers:**

- Content-Type: application/json

**Body:**

```json
{
  "id": 1,
  "funcionario": "João Silva",
  "data": "2024-03-25",
  "horaEntrada": "08:00",
  "horaSaida": "17:00"
}
```

**Resposta Esperada:** "Ponto cadastrado com sucesso!"

---

## 3. Buscar um Ponto por ID

**Método:** GET\
**URL:** [http://localhost:8080/api/pontos/1](http://localhost:8080/api/pontos/1)\
**Resposta Esperada:** Dados do ponto específico.

---

## 4. Atualizar um Ponto

**Método:** PUT\
**URL:** [http://localhost:8080/api/pontos/1](http://localhost:8080/api/pontos/1)\
**Headers:**

- Content-Type: application/json

**Body:**

```json
{
  "funcionario": "João Silva",
  "data": "2024-03-25",
  "horaEntrada": "09:00",
  "horaSaida": "18:00"
}
```

**Resposta Esperada:** "Ponto atualizado com sucesso!"

---

## 5. Deletar um Ponto

**Método:** DELETE\
**URL:** [http://localhost:8080/api/pontos/1](http://localhost:8080/api/pontos/1)\
**Resposta Esperada:** "Ponto deletado com sucesso"

