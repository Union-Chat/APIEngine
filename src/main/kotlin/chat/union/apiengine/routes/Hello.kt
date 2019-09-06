package chat.union.apiengine.routes

import chat.union.apiengine.annotations.Route
import chat.union.apiengine.entities.RequestContext

class Hello : AbstractModule("v2_hello_world", 2) {
    @Route("v2_root", "/")
    fun home(ctx: RequestContext) {

    }

    @Route("v2_root", "/coffee")
    fun coffee(ctx: RequestContext) {

    }
}
