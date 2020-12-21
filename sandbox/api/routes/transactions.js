const express = require("express");
const router = express.Router();
const Transaction = require("../models/Transaction");

router.get("/", async (req, res) => {
    try {
        const transactions = await Transaction.find();
        res.json(transactions)
    } catch (err) {
        res.status(404).json({ message: err });
    }
});

router.post("/", async (req, res) => {
    const trans = new Transaction({
        transactionId: req.body.transactionId,
        transactionType: req.body.transactionType,
        transactionDate: req.body.property,
        transactionAmount: req.body.transactionAmount,
    })

    try {
        const savedTrans = await trans.save();
        res.status(201).json(savedTrans)
    } catch (err) {
        res.status.json({ message: err });
    }
});

module.exports = router;
