package io.vertx.impl.core.http;

import io.netty.handler.codec.DecoderResult;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.Cookie;
import io.vertx.core.http.HttpConnection;
import io.vertx.core.http.HttpFrame;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerFileUpload;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.http.StreamPriority;
import io.vertx.core.net.HostAndPort;
import io.vertx.core.net.NetSocket;
import io.vertx.core.streams.Pipe;
import io.vertx.core.streams.WriteStream;

import java.util.Set;

/**
 * A wrapper class that delegates all method calls to the {@link #delegate} instance.
 *
 * Implementing {@link HttpServerRequest} or extending {@link HttpServerRequestInternal} is not encouraged however if that is necessary,
 * implementations should favor extending this class to ensure minimum breakage when new methods are added to the interface.
 *
 * The delegate instance can be accessed using protected final {@link #delegate} field, any implemented method can be overridden.
 */
public class HttpServerRequestWrapper extends HttpServerRequestInternal {

  protected final HttpServerRequestInternal delegate;

  public HttpServerRequestWrapper(HttpServerRequestInternal delegate) {
    if (delegate == null) {
      throw new NullPointerException("Null delegate not allowed");
    }
    this.delegate = delegate;
  }

  @Override
  public HttpServerRequest exceptionHandler(Handler<Throwable> handler) {
    return delegate.exceptionHandler(handler);
  }

  @Override
  public HttpServerRequest handler(Handler<Buffer> handler) {
    return delegate.handler(handler);
  }

  @Override
  public HttpServerRequest pause() {
    return delegate.pause();
  }

  @Override
  public HttpServerRequest resume() {
    return delegate.resume();
  }

  @Override
  public HttpServerRequest fetch(long amount) {
    return delegate.fetch(amount);
  }

  @Override
  public HttpServerRequest endHandler(Handler<Void> endHandler) {
    return delegate.endHandler(endHandler);
  }

  @Override
  public HttpVersion version() {
    return delegate.version();
  }

  @Override
  public HttpMethod method() {
    return delegate.method();
  }

  @Override
  public String scheme() {
    return delegate.scheme();
  }

  @Override
  public String uri() {
    return delegate.uri();
  }

  @Override
  public String path() {
    return delegate.path();
  }

  @Override
  public String query() {
    return delegate.query();
  }

  @Override
  public HostAndPort authority() {
    return delegate.authority();
  }

  @Override
  public long bytesRead() {
    return delegate.bytesRead();
  }

  @Override
  public HttpServerResponse response() {
    return delegate.response();
  }

  @Override
  public MultiMap headers() {
    return delegate.headers();
  }

  @Override
  public HttpServerRequest setParamsCharset(String charset) {
    return delegate.setParamsCharset(charset);
  }

  @Override
  public String getParamsCharset() {
    return delegate.getParamsCharset();
  }

  @Override
  public MultiMap params(boolean semicolonIsNormalChar) {
    return delegate.params(semicolonIsNormalChar);
  }

  @Override
  public String absoluteURI() {
    return delegate.absoluteURI();
  }

  @Override
  public Future<Buffer> body() {
    return delegate.body();
  }

  @Override
  public Future<Void> end() {
    return delegate.end();
  }

  @Override
  public Future<NetSocket> toNetSocket() {
    return delegate.toNetSocket();
  }

  @Override
  public HttpServerRequest setExpectMultipart(boolean expect) {
    return delegate.setExpectMultipart(expect);
  }

  @Override
  public boolean isExpectMultipart() {
    return delegate.isExpectMultipart();
  }

  @Override
  public HttpServerRequest uploadHandler(Handler<HttpServerFileUpload> uploadHandler) {
    return delegate.uploadHandler(uploadHandler);
  }

  @Override
  public MultiMap formAttributes() {
    return delegate.formAttributes();
  }

  @Override
  public String getFormAttribute(String attributeName) {
    return delegate.getFormAttribute(attributeName);
  }

  @Override
  public int streamId() {
    return delegate.streamId();
  }

  @Override
  public Future<ServerWebSocket> toWebSocket() {
    return delegate.toWebSocket();
  }

  @Override
  public boolean isEnded() {
    return delegate.isEnded();
  }

  @Override
  public HttpServerRequest customFrameHandler(Handler<HttpFrame> handler) {
    return delegate.customFrameHandler(handler);
  }

  @Override
  public HttpConnection connection() {
    return delegate.connection();
  }

  @Override
  public StreamPriority streamPriority() {
    return delegate.streamPriority();
  }

  @Override
  public HttpServerRequest streamPriorityHandler(Handler<StreamPriority> handler) {
    return delegate.streamPriorityHandler(handler);
  }

  @Override
  public DecoderResult decoderResult() {
    return delegate.decoderResult();
  }

  @Override
  public Cookie getCookie(String name) {
    return delegate.getCookie(name);
  }

  @Override
  public Cookie getCookie(String name, String domain, String path) {
    return delegate.getCookie(name, domain, path);
  }

  @Override
  public Set<Cookie> cookies(String name) {
    return delegate.cookies(name);
  }

  @Override
  public Set<Cookie> cookies() {
    return delegate.cookies();
  }

  @Override
  public HttpServerRequest routed(String route) {
    return delegate.routed(route);
  }

  @Override
  public Context context() {
    return delegate.context();
  }

  @Override
  public Object metric() {
    return delegate.metric();
  }

}