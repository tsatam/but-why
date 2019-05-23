package but.why.api

external fun require(module: String): dynamic

inline fun main() {
    val express = require("express")
    val cors = require("cors")

    val app = express()
    app.listen(3001, { println("Listening on port 3001") })
    app.get("/hello", cors(), { _, res -> res.send("Welcome to this mistake")})
}
