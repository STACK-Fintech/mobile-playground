const express = require("express");
const router = express.Router();
const User = require("../models/User");

router.get("/", async (req, res) => {
    try {
        const users = await User.find();
        res.json(users)
    } catch (err) {
        res.status(404).json({ message: err });
    }
});

router.post("/", async (req, res) => {
    const user = new User({
        firstName: req.body.firstName,
        lastName: req.body.lastName,
        transactions: req.body.transactions,
    })

    try {
        const savedUser = await user.save();
        res.status(201).json(savedUser)
    } catch (err) {
        res.status.json({ message: err });
    }
});

module.exports = router;
