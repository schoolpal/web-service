const express = require('express');
const path = require('path');
const app = express();

app.use(express.static('static'));

app.all('*', function (req, res) {
    res.sendFile(path.resolve(__dirname, 'index.html'));
});

app.listen(3000);