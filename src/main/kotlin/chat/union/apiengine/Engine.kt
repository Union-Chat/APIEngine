package chat.union.apiengine

import chat.union.apiengine.entities.IModule
import org.reflections.Reflections
import org.reflections.scanners.MethodParameterNamesScanner
import org.reflections.scanners.SubTypesScanner
import org.slf4j.LoggerFactory
import java.lang.reflect.Modifier

class Engine(val options: EngineOptions = EngineOptions()) {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    private var modules: MutableMap<String, IModule> = mutableMapOf()

    init {
        registerRoutes("chat.union.apiengine.routes")
    }

    fun registerRoutes(pkg: String) {
        logger.debug("Scanning $pkg for modules...")
        val reflections = Reflections(pkg, MethodParameterNamesScanner(), SubTypesScanner())
        modules.putAll(
                reflections.getSubTypesOf(IModule::class.java)
                        .filter {
                            !it.isInterface &&
                            !Modifier.isAbstract(it.modifiers) &&
                                    IModule::class.java.isAssignableFrom(it)
                        }
                        .map {
                            val instance = it.getDeclaredConstructor().newInstance()
                            Pair(instance.name, instance)
                        }
        )

        logger.debug("Found ${modules.size} modules")
        modules.forEach { (_, route) -> route.registerRoutes(options.httpAdapter) }
    }

    companion object {
        const val LAST_API_VERSION = 2
    }
}
