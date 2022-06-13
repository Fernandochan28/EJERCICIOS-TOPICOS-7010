//Instalar servidor express 
const express = require('express');
const path = require('path');

const app = express();


// Servir solo los archivos estáticos de la aplicación del directorio dist . use ( express . static ( './dist/angular-app-heroku' ) ) ;

app.use(express.static('./dist/w_publicidad'));

app.get('/*', (req, res) =>
    res.sendFile('index.html', {root: 'dist/w_publicidad/'}),
);


// Inicie la aplicación escuchando en la aplicación de puerto predeterminada de Heroku.
app.listen(process.env.PORT || 8080);