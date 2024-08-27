const tasks = [
    { id: 1, description: 'Tarea 1' },
    { id: 2, description: 'Tarea 2' },
    { id: 3, description: 'Tarea 3' }
];

function showTaskList() {
    const content = document.getElementById('content');
    content.innerHTML = '<ul>' + tasks.map(task =>
        `<li><a href="#" onclick="showTaskDetails(${task.id})">${task.description}</a></li>`
    ).join('') + '</ul>';
}

function showTaskDetails(taskId) {
    const task = tasks.find(t => t.id === taskId);
    const content = document.getElementById('content');
    content.innerHTML = `
        <h2>Detalles de la Tarea</h2>
        <p>ID: ${task.id}</p>
        <p>Descripción: ${task.description}</p>
        <button onclick="showTaskList()">Volver a la Lista de Tareas</button>
    `;
}

function showAddTaskForm() {
    const content = document.getElementById('content');
    content.innerHTML = `
        <h2>Agregar Nueva Tarea</h2>
        <form onsubmit="addTask(event)">
            <label for="task">Tarea:</label>
            <input type="text" id="task" name="task" required>
            <button type="submit">Agregar</button>
        </form>
    `;
}

function addTask(event) {
    event.preventDefault();
    const newTask = {
        id: tasks.length + 1,
        description: document.getElementById('task').value
    };
    tasks.push(newTask);
    showTaskList();
}

// Inicializa mostrando la lista de tareas
showTaskList();
