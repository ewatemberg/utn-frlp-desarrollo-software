const express = require('express');
const app = express();
const PORT = 3000;

// Ruta principal
app.get('/', (req, res) => {
  res.send('¡Hola desde Express!');
});

// Ruta con parámetro "nombre"
app.get('/saludo/:nombre', (req, res) => {
  const nombre = req.params.nombre;
  res.send(`Hola, ${nombre}`);
});

// Ruta que devuelve la fecha actual
app.get('/fecha', (req, res) => {
  const fechaActual = new Date().toLocaleString();
  res.send(`Fecha actual: ${fechaActual}`);
});

// Iniciar servidor
app.listen(PORT, () => {
  console.log(`Servidor corriendo en http://localhost:${PORT}`);
});