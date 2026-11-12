import assert from 'node:assert/strict';
const module = await import('../src/views/bim/ifc-model-show/model-cache.js').catch(error => {
  if (error.code !== 'ERR_MODULE_NOT_FOUND') throw error;
  return {};
});
assert.equal(typeof module.createModelBundleCache, 'function');
const { createModelBundleCache } = module;
const revision = 'a'.repeat(64);
const url = '/api/bim/ifc/1/2/3/' + revision;
const indexTag = '"' + revision + '/index.json"';
const calls = [];
let denied = false;
const fetchImpl = async (path, options) => {
  calls.push({path, options});
  if (denied) return new Response('', {status: 403});
  if (path.endsWith('/index')) {
    return options.headers['If-None-Match']
      ? new Response(null, {status: 304, headers: {ETag: indexTag}})
      : new Response(JSON.stringify({assemblies: [], parts: {}}), {headers: {ETag: indexTag}});
  }
  return new Response(new Uint8Array([1, 2, 3]), {headers: {'Content-Type': 'model/gltf-binary'}});
};
const cache = createModelBundleCache({fetchImpl});
const first = await cache.load(url, 'user-one');
assert.equal(calls.length, 2);
const second = await cache.load(url, 'user-one');
assert.strictEqual(second.geometry, first.geometry);
assert.strictEqual(second.index, first.index);
assert.equal(calls.length, 3);
assert.equal(calls[2].options.headers['If-None-Match'], indexTag);
assert.ok(calls.every(call => call.options.cache === 'no-cache'));
const gzipCache = createModelBundleCache({fetchImpl: async (path, options) => {
  const response = await fetchImpl(path, options);
  if (!options.headers['If-None-Match'] && path.endsWith('/index')) response.headers.set('ETag', 'W/' + indexTag);
  return response;
}});
const compressed = await gzipCache.load(url, 'user');
assert.strictEqual((await gzipCache.load(url, 'user')).geometry, compressed.geometry,
  'Nginx weakens compressed ETags but304 retains the equivalent strong validator');
calls.splice(3);
denied = true;
await assert.rejects(cache.load(url, 'user-one'), /无权/);
denied = false;
await cache.load(url, 'user-two');
assert.equal(calls.length, 6, 'Changing account must fetch both resources again');
cache.clear();
await cache.load(url, 'user-two');
assert.equal(calls.length, 8);
await assert.rejects(cache.load(url, ''), /登录/);

const small = createModelBundleCache({fetchImpl, maxBytes: 1});
const oversized = await small.load(url, 'user');
assert.notStrictEqual((await small.load(url, 'user')).geometry, oversized.geometry);
const lru = createModelBundleCache({fetchImpl, maxEntries: 1});
const original = await lru.load(url, 'user');
await lru.load(url + '-other', 'user');
assert.notStrictEqual((await lru.load(url, 'user')).geometry, original.geometry);

const businessFailure = createModelBundleCache({fetchImpl: async () => new Response(
  JSON.stringify({code: 40000, message: '访问已撤销'}), {headers: {'Content-Type': 'application/json'}})});
await assert.rejects(businessFailure.load(url, 'user'), /访问已撤销/);
const mismatched = createModelBundleCache({fetchImpl: async (path, options) => options.headers['If-None-Match']
  ? new Response(null, {status: 304, headers: {ETag: '"different"'}}) : fetchImpl(path, options)});
await mismatched.load(url, 'user');
await assert.rejects(mismatched.load(url, 'user'), /校验/);

let release;
let delayed = true;
const deferred = createModelBundleCache({fetchImpl: async (path, options) => {
  if (delayed && path.endsWith('/index')) await new Promise(resolve => { release = resolve; });
  return fetchImpl(path, options);
}});
const old = deferred.load(url, 'old');
await new Promise(resolve => setTimeout(resolve));
deferred.clear();
delayed = false;
release();
await assert.rejects(old, {name: 'AbortError'});
const controller = new AbortController();
controller.abort();
await assert.rejects(deferred.load(url, 'new', controller.signal), {name: 'AbortError'});
await deferred.load(url, 'new');
let failOldIndex;
let delayOldIndex = true;
const racing = createModelBundleCache({fetchImpl: async (path, options) => {
  if (delayOldIndex && path.endsWith('/index')) {
    delayOldIndex = false;
    await new Promise((resolve, reject) => { failOldIndex = reject; });
  }
  return fetchImpl(path, options);
}});
const failedLoad = assert.rejects(racing.load(url, 'user'), /old request failed/);
await new Promise(resolve => setTimeout(resolve));
const completedLoad = await racing.load(url, 'user');
failOldIndex(new Error('old request failed'));
await failedLoad;
assert.strictEqual((await racing.load(url, 'user')).geometry, completedLoad.geometry,
  'A late failure must not evict a newer completed load for the same account and URL');
console.log('IFC cache authorization revalidation, identity, logout, limits and cancellation passed');

const {readFileSync} = await import('node:fs');
const {runInNewContext} = await import('node:vm');
const fragment = readFileSync(new URL('../src/shared/segments/001.fragment.js', import.meta.url), 'utf8');
const logout = fragment.match(/function bA\(\) \{[\s\S]*?\n\}/)[0];
let sessionCleared = false, notified = false;
runInNewContext(logout + ';bA();', {
  sessionStorage: {removeItem: () => { sessionCleared = true; }},
  window: {Event: class { constructor(type) { this.type = type; } }, dispatchEvent: event => { notified = event.type === 'ljaps-session-ended'; }},
});
assert.ok(sessionCleared && notified, 'Logout clears model reuse together with the session');
