package chat.union.apiengine.entities

class ServiceCredentials(val client: String, val secret: String) {
    companion object {
        val EMPTY: ServiceCredentials? = null
    }
}
