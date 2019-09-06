package chat.union.apiengine.adapters.http.vertx

import chat.union.apiengine.adapters.IHTTPAdapter
import java.lang.reflect.Method

class VertxAdapter : IHTTPAdapter {
    override fun registerRoute(path: String, handler: Method) {
        // @devoxin how about you do the ktor part xd
    }
}
