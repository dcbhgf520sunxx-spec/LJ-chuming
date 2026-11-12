// Completed resources only: access is checked on every open, business progress stays fresh.
export function createModelBundleCache({fetchImpl = fetch, maxEntries = 2, maxBytes = 64 * 1024 * 1024} = {}) {
  const entries = new Map();
  let owner = '', epoch = 0, bytes = 0;
  function clear() { entries.clear(); bytes = 0; owner = ''; epoch++; }
  function remove(url) {
    const entry = entries.get(url);
    if (entry) { bytes -= entry.bytes; entries.delete(url); }
  }
  async function load(url, token, signal) {
    if (token !== owner) { clear(); owner = token; }
    if (!token) { clear(); throw new Error('请先登录后查看模型'); }
    const generation = epoch;
    const controller = new AbortController();
    const abort = () => controller.abort();
    signal?.addEventListener('abort', abort, {once: true});
    if (signal?.aborted) abort();
    const check = () => {
      if (controller.signal.aborted || generation !== epoch) throw new DOMException('加载已取消', 'AbortError');
    };
    const request = async (suffix, etag) => {
      check();
      const response = await fetchImpl(url + suffix, {
        signal: controller.signal, cache: 'no-cache',
        headers: {Authorization: token, ...(etag ? {'If-None-Match': etag} : {})},
      });
      check();
      if (response.status !== 304 && !response.ok) {
        throw new Error(response.status === 403 ? '当前账号无权查看此项目模型' : '模型请求失败，请刷新后重试');
      }
      return response;
    };
    const parse = async (response, binary) => {
      if (binary && !response.headers.get('content-type')?.includes('application/json')) return response.arrayBuffer();
      const payload = await response.json();
      if (payload.code != null && Number(payload.code) !== 20000) throw new Error(payload.message || '模型请求失败，请刷新后重试');
      if (binary) throw new Error('模型文件格式不正确');
      if (!Array.isArray(payload.assemblies) || !payload.parts) throw new Error('模型索引格式不正确');
      return payload;
    };
    const cached = entries.get(url);
    try {
      let indexResponse;
      if (cached?.etag) {
        indexResponse = await request('/index', cached.etag);
        // Gzip responses use weak validators;304 may return the equivalent strong tag.
        const returnedTag = indexResponse.headers.get('etag');
        if (returnedTag && returnedTag.replace(/^W\//, '') === cached.etag.replace(/^W\//, '')) {
          await indexResponse.body?.cancel();
          check();
          entries.delete(url); entries.set(url, cached);
          return cached.bundle;
        }
        if (entries.get(url) === cached) remove(url);
        if (indexResponse.status === 304) throw new Error('模型缓存校验失败，请刷新后重试');
      }
      const [index, geometryResponse] = await Promise.all([
        (async () => {
          indexResponse ||= await request('/index');
          return parse(indexResponse, false);
        })(),
        request('/geometry'),
      ]);
      const geometry = await parse(geometryResponse, true);
      check();
      const bundle = {index, geometry};
      const size = geometry.byteLength + JSON.stringify(index).length * 2;
      const etag = indexResponse.headers.get('etag');
      if (etag && size <= maxBytes && maxEntries > 0) {
        remove(url);
        while (entries.size && (entries.size >= maxEntries || bytes + size > maxBytes)) remove(entries.keys().next().value);
        entries.set(url, {bundle, etag, bytes: size}); bytes += size;
      }
      return bundle;
    } catch (error) {
      controller.abort();
      if (generation === epoch && entries.get(url) === cached) remove(url);
      throw error;
    } finally {
      signal?.removeEventListener('abort', abort);
    }
  }
  return {load, clear};
}

export const modelBundleCache = createModelBundleCache();
if (typeof window !== 'undefined') window.addEventListener('ljaps-session-ended', () => modelBundleCache.clear());
