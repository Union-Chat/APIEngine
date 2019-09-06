package chat.union.apiengine.adapters.http.ktor

import chat.union.apiengine.adapters.http.AbstractRoute
import java.lang.reflect.Method

class KtorRoute(
        override val name: String,
        override val path: String,
        override val methods: Array<String>,
        override val handler: Method,
        override val adapter: KtorAdapter
) : AbstractRoute()
