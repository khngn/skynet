/**
 * 
 */
package skynet.vertx.hello;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * @author K.H.Nguyen
 *
 */
public class MyFirstVerticle extends AbstractVerticle {
	@Override
	public void start(Future<Void> fut) {
		int port = config().getInteger("http.port", 8080);

		vertx.createHttpServer().requestHandler(r -> {
			r.response().end("<h1>Hello from my first " + "Vert.x 3 application</h1>");
		}).listen(port, result -> {
			if (result.succeeded()) {
				fut.complete();
			} else {
				fut.fail(result.cause());
			}
		});
	}
}
