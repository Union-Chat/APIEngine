package chat.union.apiengine.adapters

import java.lang.reflect.Method

interface IHTTPAdapter {
    fun registerRoute(path: String, handler: Method)
}
