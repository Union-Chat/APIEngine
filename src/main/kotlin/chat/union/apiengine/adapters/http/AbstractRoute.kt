package chat.union.apiengine.adapters.http

import chat.union.apiengine.entities.IRoute

abstract class AbstractRoute : IRoute {
    override var enabled: Boolean = true
}
