const fs = require('fs');
const Transaction = require('../models/Transaction');
const User = require('../models/User');

module.exports.loadUsers = async() => {
    let usersData = fs.readFileSync('mocks/users.json');  
    let users = JSON.parse(usersData);  
    console.log(users); 
    await User.insertMany(users)
}

module.exports.loadTransactions = async() => {
    let transactionsData = fs.readFileSync('mocks/transactions.json');  
    let transactions = JSON.parse(transactionsData);  
    console.log(transactions); 
    await Transaction.insertMany(transactions)
}
