package but.why.client.app

import react.*
import react.dom.*
import org.w3c.fetch.*
import kotlin.browser.window

interface AppState : RState {
    var message: String
}

class App() : RComponent<RProps, AppState>() {

    override fun componentDidMount() {
        window.fetch("http://localhost:3001/hello")
                .then { it.text() }
                .then { setState { message = it } }
    }

    override fun RBuilder.render() {
        div("App-header") {
            h2 {
                +"${state.message}"
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {}
