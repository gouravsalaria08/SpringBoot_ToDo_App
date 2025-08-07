const apiUrl = 'http://localhost:8080/api';

async function fetchTasks() {
  const response = await fetch(apiUrl);
  const tasks = await response.json();

  const tbody = document.getElementById('taskTableBody');
  tbody.innerHTML = '';

  tasks.forEach((task, index) => {
  const rowNumber = index + 1;  // this will be 1, 2, 3...
  const row = document.createElement('tr');
  
  row.innerHTML = `
    <td>${rowNumber}</td>  <!-- Sequential number -->
    <td>${task.title}</td>
    <td>${task.description}</td>
    <td>${task.status}</td>
    <td>
      <button onclick="showUpdateForm(${task.id}, '${task.title}', '${task.description}', '${task.status}')">Update</button>
      <button onclick="deleteTask(${task.id})">Delete</button>
    </td>
  `;

  tbody.appendChild(row);
});

}

// Escape HTML to prevent injection issues in innerHTML
function escapeHtml(text) {
  return text.replace(/&/g, "&amp;")
             .replace(/</g, "&lt;")
             .replace(/>/g, "&gt;")
             .replace(/"/g, "&quot;")
             .replace(/'/g, "&#039;");
}

// Add new task
document.getElementById('addTaskForm').addEventListener('submit', async e => {
  e.preventDefault();

  const title = document.getElementById('title').value.trim();
  const description = document.getElementById('description').value.trim();
  const status = document.getElementById('status').value;

  if (!title || !description) {
    alert('Please fill all fields');
    return;
  }

  const newTask = { title, description, status };

  await fetch(`${apiUrl}/add`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(newTask),
  });

  e.target.reset();
  fetchTasks();
});

// Delete task
async function deleteTask(id) {
  if (confirm('Are you sure you want to delete this task?')) {
    await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
    fetchTasks();
  }
}

// Show update form populated with task data
function showUpdateForm(id, title, description, status) {
  document.getElementById('updateTaskSection').style.display = 'block';
  document.getElementById('taskTable').style.display = 'none';

  document.getElementById('updateId').value = id;
  document.getElementById('updateTitle').value = title;
  document.getElementById('updateDescription').value = description;
  document.getElementById('updateStatus').value = status;
}

// Cancel update and hide form
function cancelUpdate() {
  document.getElementById('updateTaskSection').style.display = 'none';
  document.getElementById('taskTable').style.display = 'table';
}

// Handle update task submission
document.getElementById('updateTaskForm').addEventListener('submit', async e => {
  e.preventDefault();

  const id = document.getElementById('updateId').value;
  const title = document.getElementById('updateTitle').value.trim();
  const description = document.getElementById('updateDescription').value.trim();
  const status = document.getElementById('updateStatus').value;

  if (!title || !description) {
    alert('Please fill all fields');
    return;
  }

  const updatedTask = { title, description, status };

  await fetch(`${apiUrl}/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(updatedTask),
  });

  cancelUpdate();
  fetchTasks();
});

// Load tasks on window load
window.onload = fetchTasks;
