package chat.union.apiengine.entities

import chat.union.apiengine.adapters.IHTTPAdapter

interface IModule {
    val name: String
    val version: Int
    var enabled: Boolean

    fun registerRoutes(adapter: IHTTPAdapter)
}
