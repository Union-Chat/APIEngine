package chat.union.apiengine.annotations

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Route(val name: String, val route: String, val methods: Array<String> = ["GET"])
