package chat.union.apiengine

import chat.union.apiengine.adapters.IHTTPAdapter
import chat.union.apiengine.adapters.IStorageAdapter
import chat.union.apiengine.adapters.http.KtorAdapter
import chat.union.apiengine.adapters.storage.SqliteAdapter
import chat.union.apiengine.entities.ServiceCredentials

class EngineOptions {
    var bindAddress = "127.0.0.1"
    var bindPort = 8080
    var httpAdapter: IHTTPAdapter = KtorAdapter()
    var storageAdapter: IStorageAdapter = SqliteAdapter()

    var recaptchaCredentials = ServiceCredentials.EMPTY
    var sentryCredentials = ServiceCredentials.EMPTY
    var discordCredentials = ServiceCredentials.EMPTY
    var githubCredentials = ServiceCredentials.EMPTY
    var redditCredentials = ServiceCredentials.EMPTY
    var twitterCredentials = ServiceCredentials.EMPTY
}
