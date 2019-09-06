package chat.union.apiengine.entities

import chat.union.apiengine.adapters.IHTTPAdapter
import java.lang.reflect.Method

interface IRoute {
    val name: String
    val path: String
    val methods: Array<String>
    val handler: Method
    val adapter: IHTTPAdapter

    var enabled: Boolean
}
