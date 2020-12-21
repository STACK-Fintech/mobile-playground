const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const User = new mongoose.Schema(
    {
        firstName: {
            type: String,
            required: [true, 'Please specify the firstName']
        },
        lastName: {
            type: String,
            required: [true, 'Please specify the lastName']
        },
        transactions: {
            type: [String]
        }
    }
);

module.exports = mongoose.model('User', User)
