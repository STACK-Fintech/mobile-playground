const express = require("express");
const mongoose = require("mongoose");
const bodyParser = require("body-parser");
const dbHandler = require('./api/helpers/db-handler');
const mockReader = require('./api/helpers/mock-reader')
const usersRoute = require("./api/routes/users")
const transRoute = require("./api/routes/transactions")
const app = express();

app.use(bodyParser.json());
app.use("/users", usersRoute);
app.use("/transactions", transRoute);

dbHandler.connect().then( async() => {
    mockReader.loadUsers()
    mockReader.loadTransactions()
    app.listen(3000);
});
