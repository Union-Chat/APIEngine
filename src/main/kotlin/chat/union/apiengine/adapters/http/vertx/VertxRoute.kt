package chat.union.apiengine.adapters.http.vertx

import chat.union.apiengine.adapters.http.AbstractRoute
import java.lang.reflect.Method

class VertxRoute(
        override val name: String,
        override val path: String,
        override val methods: Array<String>,
        override val handler: Method,
        override val adapter: VertxAdapter
) : AbstractRoute()
