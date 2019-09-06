package chat.union.apiengine.routes

import chat.union.apiengine.Engine
import chat.union.apiengine.adapters.IHTTPAdapter
import chat.union.apiengine.annotations.Route
import chat.union.apiengine.entities.IModule
import chat.union.apiengine.entities.RequestContext
import java.lang.reflect.Method
import kotlin.coroutines.Continuation

abstract class AbstractModule(override val name: String, override val version: Int) : IModule {
    override var enabled: Boolean = true
    private val routes: MutableMap<String, Method> = mutableMapOf()

    override fun registerRoutes(adapter: IHTTPAdapter) {
        val methods = this::class.java.methods.filter {
            it.isAnnotationPresent(Route::class.java) &&
                    it.parameterTypes.first() == RequestContext::class.java &&
                    (it.parameterCount == 1 ||
                            (it.parameterCount == 2 && it.parameterTypes.last() == Continuation::class.java))
        }

        methods.forEach {
            val attributes = it.getAnnotation(Route::class.java)
            adapter.registerRoute("/v$version${attributes.route}", it)
            if (version == Engine.LAST_API_VERSION) {
                adapter.registerRoute(attributes.route, it)
            }
            println(attributes.name)
            routes[attributes.name] = it
        }
    }
}
