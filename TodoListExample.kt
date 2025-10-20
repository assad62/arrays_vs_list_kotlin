/**
 * Kotlin Todo List Example
 * Demonstrates using MutableList for dynamic todo management
 */

data class Todo(
    val id: Int,
    val task: String,
    val isCompleted: Boolean = false
)

class TodoList {
    private val todos = mutableListOf<Todo>()
    private var nextId = 1

    // Add a new todo
    fun addTodo(task: String) {
        val newTodo = Todo(nextId++, task)
        todos.add(newTodo)
        println("✅ Added: $task")
    }

    // Remove todo by ID
    fun removeTodo(id: Int) {
        val todoToRemove = todos.find { it.id == id }
        if (todoToRemove != null) {
            todos.remove(todoToRemove)
            println("❌ Removed: ${todoToRemove.task}")
        } else {
            println("⚠️ Todo with ID $id not found")
        }
    }

    // Remove todo by task name
    fun removeTodoByTask(task: String) {
        val todoToRemove = todos.find { it.task == task }
        if (todoToRemove != null) {
            todos.remove(todoToRemove)
            println("❌ Removed: $task")
        } else {
            println("⚠️ Todo '$task' not found")
        }
    }

    // Toggle todo completion status
    fun toggleTodo(id: Int) {
        val todoIndex = todos.indexOfFirst { it.id == id }
        if (todoIndex != -1) {
            val todo = todos[todoIndex]
            todos[todoIndex] = todo.copy(isCompleted = !todo.isCompleted)
            val status = if (todos[todoIndex].isCompleted) "completed" else "pending"
            println("🔄 Toggled: ${todo.task} - $status")
        } else {
            println("⚠️ Todo with ID $id not found")
        }
    }

    // Display all todos
    fun displayTodos() {
        if (todos.isEmpty()) {
            println("📝 No todos yet!")
            return
        }
        
        println("\n📋 Your Todo List:")
        println("=" * 30)
        todos.forEach { todo ->
            val status = if (todo.isCompleted) "✅" else "⏳"
            println("$status [${todo.id}] ${todo.task}")
        }
        println("=" * 30)
    }

    // Get completed todos count
    fun getCompletedCount(): Int = todos.count { it.isCompleted }

    // Get pending todos count
    fun getPendingCount(): Int = todos.count { !it.isCompleted }

    // Clear all completed todos
    fun clearCompleted() {
        val completedCount = todos.count { it.isCompleted }
        todos.removeAll { it.isCompleted }
        println("🧹 Cleared $completedCount completed todos")
    }

    // Get all todos (read-only)
    fun getAllTodos(): List<Todo> = todos.toList()
}

fun main() {
    val todoList = TodoList()

    println("🚀 Welcome to Kotlin Todo List Example!")
    println("This demonstrates MutableList operations\n")

    // Add some todos
    todoList.addTodo("Learn Kotlin arrays vs lists")
    todoList.addTodo("Create a todo app")
    todoList.addTodo("Write documentation")
    todoList.addTodo("Test the application")

    // Display todos
    todoList.displayTodos()

    // Toggle some todos
    todoList.toggleTodo(1)
    todoList.toggleTodo(3)

    // Display updated todos
    todoList.displayTodos()

    // Show statistics
    println("📊 Statistics:")
    println("Total todos: ${todoList.getAllTodos().size}")
    println("Completed: ${todoList.getCompletedCount()}")
    println("Pending: ${todoList.getPendingCount()}")

    // Remove a todo
    todoList.removeTodo(2)
    todoList.displayTodos()

    // Clear completed todos
    todoList.clearCompleted()
    todoList.displayTodos()

    // Demonstrate list operations
    println("\n🔍 List Operations Demo:")
    val allTodos = todoList.getAllTodos()
    println("All todos (immutable list): $allTodos")
    
    // Filter pending todos
    val pendingTodos = allTodos.filter { !it.isCompleted }
    println("Pending todos: $pendingTodos")
    
    // Map to task names only
    val taskNames = allTodos.map { it.task }
    println("Task names: $taskNames")
}

// Extension function for string repetition
operator fun String.times(n: Int): String = this.repeat(n)
