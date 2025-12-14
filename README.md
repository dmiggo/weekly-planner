# 📅 Weekly Planner API

Spring Boot REST API для управления задачами и планированием недели.

## 🚀 Возможности

- Управление пользователями (CRUD)
- Управление задачами (CRUD)
- Отметить задачу как выполненную
- Получить задачи пользователя
- Приоритеты задач (LOW, MEDIUM, HIGH, URGENT)

## 📋 Требования

- Java 17+
- PostgreSQL 12+
- Maven 3.6+

## 🔧 Установка
1. Клонируйте репозиторий
   git clone https://github.com/dmiggo/weekly-planner.git
   cd weekly-planner

2. Создайте БД
   createdb weekly_planner

3. Запустите приложение
   mvn spring-boot:run

text

## 📡 API Endpoints

### Users

GET /api/users # Получить всех пользователей
GET /api/users/{id} # Получить пользователя
POST /api/users # Создать пользователя
PUT /api/users/{id} # Обновить пользователя
DELETE /api/users/{id} # Удалить пользователя

text

### Tasks

GET /api/tasks # Получить все задачи
GET /api/tasks/{id} # Получить задачу
GET /api/tasks/user/{userId}# Получить задачи пользователя
POST /api/tasks # Создать задачу
PUT /api/tasks/{id} # Обновить задачу
DELETE /api/tasks/{id} # Удалить задачу
PATCH /api/tasks/{id}/complete# Отметить как выполненную

text

## 📝 Примеры

### Создать пользователя

POST http://localhost:8080/api/users
Content-Type: application/json

{
"email": "john@example.com",
"password": "pwd123",
"firstName": "John",
"lastName": "Doe",
"enabled": true
}

text

### Создать задачу

POST http://localhost:8080/api/tasks
Content-Type: application/json

{
"title": "Купить продукты",
"description": "Молоко, хлеб, яйца",
"userId": 1,
"priority": "HIGH",
"isCompleted": false
}

text

## 🗄️ БД структура

### users table
- `id` - ID пользователя
- `email` - Email (unique)
- `password` - Пароль
- `first_name` - Имя
- `last_name` - Фамилия
- `enabled` - Активен ли
- `created_at` - Дата создания
- `updated_at` - Дата обновления

### tasks table
- `id` - ID задачи
- `title` - Название
- `description` - Описание
- `is_completed` - Выполнена ли
- `priority` - Приоритет (LOW, MEDIUM, HIGH, URGENT)
- `user_id` - ID пользователя (FK)
- `due_date` - Дата выполнения
- `created_at` - Дата создания
- `updated_at` - Дата обновления

## 👨‍💻 Автор

Dmitry Miggo

