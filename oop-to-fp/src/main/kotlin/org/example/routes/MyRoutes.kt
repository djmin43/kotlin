import org.http4k.core.*
import org.http4k.core.Method.GET
import org.http4k.core.Status.OK
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer



class MyRoutes {
    val app: HttpHandler = routes(
        "/greetings" bind GET to ::greetings,
        "/data" bind POST to ::receiveData
    )

}
