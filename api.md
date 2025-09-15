# API's

---

### API de Busca

- **URL:** ``/api/recipes``
- **Método:** ``Get``

**Descrição:**

Returna a lista de receitas já cadastrada

**Resposta 200 OK**

```
{
     "id": 2,
     "titulo": "Omelete Simples",
     "descricao": "Uma omelete rápida com ovos e temperos básicos.",
     "categoria": "Café da Manhã",
     "tempoDePreparo": 10,
     "imagemUrl": "https://example.com/omelete.jpg"
}
```

--- 

### API de Cadastrar receitas

- **URL:** ``/{id}``
- **Método:** ``POST``

**Descrição:**

Você cria uma nova receita baseada nas informações que você passar (Ainda vou implementar os ingredientes individuais e de forma que funcione a quantidade)

**Resposta 200 OK**

```
{
    "id": 6,
    "titulo": "Pão de queijo",
    "descricao": "Uma massa de queijo muito boa",
    "categoria": "Café da Manhã",
    "tempoDePreparo": 30,
    "imagemUrl": "https://example.com/paodequeijo.jpg"
}
```