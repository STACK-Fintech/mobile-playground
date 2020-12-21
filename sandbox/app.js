const express = require("express");
const mongoose = require("mongoose");
const bodyParser = require("body-parser");
const dbHandler = require('./api/helpers/db-handler');
const app = express();

const transRoute = require("./api/routes/transactions")

app.use(bodyParser.json());
app.use("/transactions", transRoute);

dbHandler.connect().then( async() => {
    app.listen(3000);
});
