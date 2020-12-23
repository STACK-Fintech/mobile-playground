const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const Transacton = new mongoose.Schema(
    {
        transactionId: {
            type: String,
            unique: true,
            required: [true, 'Please specify the ID']
        },
        transactionDescription: {
            type: String,
            required: [true, 'Please specify the description']
        },
        transactionType: {
            type: String,
            required: [true, 'Please specify the type']
        },
        transactionDate: {
            type: Date,
            default: Date.now
        },
        transactionAmount: {
            type: Number,
            required: [true, 'Please specify the amount']
        }
    }
);

module.exports = mongoose.model('Transacton', Transacton)
