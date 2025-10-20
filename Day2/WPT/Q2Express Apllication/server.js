const express = require("express");
const mysql = require("mysql");
const bodyParser = require("body-parser");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(bodyParser.json());

// MySQL connection
const db = mysql.createConnection({
  host: "localhost",
  user: "root",       //  username
  password: "Anjali",       //  password
  database: "webtech"
});

db.connect(err => {
  if (err) throw err;
  console.log("✅ Connected to MySQL Database");
});

// POST 
app.post("/register", (req, res) => {
  const { firstname, lastname, email, userid, password } = req.body;
  const sql = "INSERT INTO Users (firstname, lastname, email, userid, password) VALUES (?, ?, ?, ?, ?)";
  db.query(sql, [firstname, lastname, email, userid, password], (err, result) => {
    if (err) {
      console.error(err);
      res.status(500).send("Error inserting data");
    } else {
      res.send("✅ User registered successfully!");
    }
  });
});

app.listen(5000, () => console.log("Server running on http://localhost:5000"));
