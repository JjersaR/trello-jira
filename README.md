# Trello/Jira Management System - GraphQL API

Un sistema de gestión de tareas tipo Trello/Jira construido con Spring Boot y GraphQL.

## 📋 Características

- ✅ Gestión completa de tableros (Boards), columnas, tarjetas y usuarios
- ✅ API GraphQL con queries y mutations tipadas
- ✅ Base de datos MySQL con relaciones JPA
- ✅ Sistema de comentarios en tarjetas
- ✅ Asignación de tareas a usuarios
- ✅ Prioridades y fechas límite para tareas
- ✅ Autocompletado de GraphQL con GraphiQL

## 🚀 Tecnologías

- **Java 21** con **Spring Boot 3.x**
- **GraphQL** para API flexible
- **Spring Data JPA** para persistencia
- **MySQL** como base de datos
- **Lombok** para reducir código boilerplate
- **Maven** para gestión de dependencias

## 📁 Estructura del Proyecto

```
src/main/java/com/trellojira/
├── board
│   ├── controller
│   │   ├── MutationBoardController.java
│   │   └── QueryBoardController.java
│   ├── entity
│   │   └── Board.java
│   ├── repository
│   │   └── IBoardRepository.java
│   └── service
│       └── BoardService.java
├── card
│   ├── controller
│   │   ├── MutationCardController.java
│   │   └── QueryCardController.java
│   ├── entity
│   │   ├── Card.java
│   │   └── EPriority.java
│   ├── repository
│   │   └── ICardRepository.java
│   └── service
│       └── CardService.java
├── column
│   ├── controller
│   │   ├── MutationColumnController.java
│   │   └── QueryColumnController.java
│   ├── entity
│   │   └── Columns.java
│   ├── repository
│   │   └── IColumnRepository.java
│   └── service
│       └── ColumnService.java
├── comment
│   ├── controller
│   │   ├── MutationCommentController.java
│   │   └── QueryCommentController.java
│   ├── entity
│   │   └── Comment.java
│   ├── repository
│   │   └── ICommentRepository.java
│   └── service
│       └── CommentService.java
├── config
│   └── GraphQLScalarConfig.java
├── dto
│   ├── mapper
│   │   └── ModelMapper.java
│   ├── request
│   │   ├── BoardRequest.java
│   │   ├── CardRequest.java
│   │   ├── ColumnRequest.java
│   │   ├── CommentRequest.java
│   │   └── UserRequest.java
│   └── response
│       ├── BoardResponse.java
│       ├── CardResponse.java
│       ├── ColumnResponse.java
│       ├── CommentResponse.java
│       └── UserResponse.java
├── resolver
│   └── DataFetcher.java
├── TrelloJiraApplication.java
└── user
    ├── controller
    │   ├── MutationUserController.java
    │   └── QueryUserController.java
    ├── entity
    │   └── User.java
    ├── repository
    │   └── IUserRepository.java
    └── service
        └── UserService.java
```

## 🗄️ Schema GraphQL

### Tipos Principales

```graphql
type UserResponse {
  id: ID
  username: String
  email: String
  name: String
  createdAt: String
  boardCount: Int
  memberBoardsCount: Int
}

type BoardResponse {
  id: ID
  name: String!
  description: String
  ownerId: Int
  owner: UserResponse
  createdAt: DateTime
  updatedAt: DateTime
  columnsCount: Int
  membersCount: Int
  columns: [ColumnResponse]
  members: [UserResponse]
}

type ColumnResponse {
  id: ID
  name: String
  position: Int
  boardId: ID
  cardsCount: Int
  cards: [CardResponse]
}

type CardResponse {
  id: ID
  title: String
  description: String
  position: Int
  column: ColumnResponse
  assignedTo: UserResponse
  createdBy: UserResponse
  dueDate: DateTime
  createdAt: DateTime
  updatedAt: DateTime
  priority: String
  commentsCount: Int
  comments: [CommentResponse]
}

type CommentResponse {
  id: ID
  content: String
  cardId: ID
  authorUsername: String
  createdAt: DateTime
  updatedAt: DateTime
}
```

## 🔍 Queries Disponibles

### Usuarios
```graphql
query {
  findByUsername(username: "jperez") {
    id
    username
    email
    boardCount
  }

  findByName(name: "Juan") {
    id
    username
  }

  findByEmail(email: "juan@example.com") {
    id
    username
  }

  findByBoard(boardId: 1) {
    id
    username
  }
}
```

### Tableros
```graphql
query {
  findByOwner(id: 1) {
    id
    name
    description
    columnsCount
    membersCount
    owner {
      username
    }
    columns {
      name
      cardsCount
    }
  }
}
```

### Tarjetas
```graphql
query {
  findByColumn(id: 1) {
    id
    title
    priority
    dueDate
    assignedTo {
      username
    }
  }

  findByAssignedTo(id: 1) {
    id
    title
    column {
      name
    }
  }

  findByColumnOrder(id: 1) {
    id
    title
    position
  }
}
```

### Columnas
```graphql
query {
  findByBoardId(id: 1) {
    id
    name
    position
    cardsCount
  }

  findByBoardIdOrder(id: 1) {
    id
    name
    position
  }
}
```

### Comentarios
```graphql
query {
  findByCard(id: 1) {
    id
    content
    authorUsername
    createdAt
  }
}
```

## 📝 Mutations Disponibles

### Usuarios
```graphql
mutation {
  createUser(user: {
    username: "nuevo_usuario",
    email: "nuevo@email.com",
    name: "Nuevo Usuario"
  })

  updateUser(id: 1, user: {
    username: "usuario_actualizado",
    email: "actualizado@email.com",
    name: "Nombre Actualizado"
  })

  deleteUser(id: 1)
}
```

### Tableros
```graphql
mutation {
  createBoard(board: {
    name: "Nuevo Tablero",
    description: "Descripción del tablero",
    ownerId: "1"
  })

  updateBoard(id: 1, board: {
    name: "Tablero Actualizado",
    description: "Nueva descripción"
  })

  deleteBoard(id: 1)
}
```

### Tarjetas
```graphql
mutation {
  createCard(card: {
    title: "Nueva tarea",
    description: "Descripción de la tarea",
    columnId: "1",
    createdById: "1",
    assignedToId: "2",
    dueDate: "2024-12-31T23:59:59",
    priority: "HIGH"
  })

  deleteCard(id: 1)
}
```

### Columnas
```graphql
mutation {
  createColumn(column: {
    name: "Nueva Columna",
    position: 2,
    boardId: "1"
  })

  updateColumn(id: 1, column: {
    name: "Columna Actualizada",
    position: 3
  })

  deleteColumn(id: 1)
}
```

### Comentarios
```graphql
mutation {
  saveComment(comment: {
    content: "Este es un comentario",
    cardId: "1",
    authorId: "1"
  })

  deleteComment(id: 1)
}
```

## 🛠️ Instalación y Configuración

### Prerrequisitos
- Java 21
- Maven 3.9.11

### 1. Clonar el repositorio
```bash
git clone
cd trello-jira
```

### 2. Configurar base de datos
```sql
CREATE DATABASE trellojira;
```

### 3. Configurar aplicación
Editar `src/main/resources/application.properties`:

```properties
spring.datasource.username=<your user>
spring.datasource.password=<your password>
```

### 4. Construir y ejecutar
```bash
# Compilar
mvn clean compile

# Ejecutar
mvn spring-boot:run

# O construir JAR
mvn clean package
java -jar target/*.jar
```

## 🌐 Acceso a la API

- **GraphiQL UI**: `http://localhost:8080/graphiql`

## 📊 Base de Datos

### Diagrama de Entidades
```
┌──────────┐      ┌──────────┐      ┌──────────┐      ┌──────────┐
│  Users   │◄────┤│  Boards  │◄────┤│ Columns  │◄────┤│  Cards   │
└──────────┘      └──────────┘      └──────────┘      └──────────┘
     △                  △                  △                △
     │                  │                  │                │
     └──────────────────┘                  │                │
          (members)                        │                │
                                           │                │
                                           └────────────────┘
                                             (comments)
```

### Tablas Principales
- `users`: Información de usuarios
- `boards`: Tableros con propietario
- `columns`: Columnas dentro de tableros
- `cards`: Tarjetas/tareas dentro de columnas
- `comments`: Comentarios en tarjetas
- `board_members`: Relación muchos-a-muchos usuarios/boards

## 🧪 Ejemplos de Uso

### 1. Crear un flujo completo
```graphql
# 1. Crear usuario
mutation {
  createUser(user: {
    username: "product_owner",
    email: "po@empresa.com",
    name: "Product Owner"
  })
}

# 2. Crear tablero
mutation {
  createBoard(board: {
    name: "Sprint 15",
    description: "Tablero para el sprint actual",
    ownerId: "1"
  })
}

# 3. Crear tarjeta
mutation {
  createCard(card: {
    title: "Implementar login social",
    description: "Integrar autenticación con Google y Facebook",
    columnId: 1,
    createdById: 1,
    assignedToId: "2",
    dueDate: "2024-03-15T17:00:00",
    priority: "HIGH"
  })
}

# 4. Agregar columna
mutation {
  createColumn(column: {
    name: "To Do",
    position: 2,
    boardId: 1
  }
}

# 5. Agregar comentario
mutation {
  saveComment(comment: {
    content: "Recordar incluir refresh token",
    cardId: "1",
    authorId: "1"
  })
}
```

## 🐛 Solución de Problemas

### Error: "Table doesn't exist"
```properties
# En application.properties
spring.jpa.hibernate.ddl-auto=create  # o create-drop para desarrollo
```

## ✨ Autor

Desarrollado con ❤️ usando Spring Boot y GraphQL.
