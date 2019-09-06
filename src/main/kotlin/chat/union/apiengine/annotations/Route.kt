package chat.union.apiengine.annotations

import chat.union.apiengine.entities.HttpMethod

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Route(val name: String, val route: String, val methods: Array<HttpMethod> = [HttpMethod.GET])
