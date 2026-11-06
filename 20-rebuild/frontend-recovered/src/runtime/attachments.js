// Only this deployment's historical file hosts are aliases for the local backup.
// Unrelated external links and BIM/OA services are never redirected or contacted here.
const legacyOrigins=new Set([
  'https://znzhlj.znjs.com:7077',
  'http://znzhlj.znjs.com:7077',
  'http://39.170.3.158:6006',
  'http://172.16.0.176:6006',
  'http://127.0.0.1:3120',
  'http://127.0.0.1:3119'
]);
export function localAttachmentUrl(value, currentOrigin=globalThis.location?.origin) {
  if(typeof value!=='string'||!/^https?:\/\//i.test(value))return value;
  let url;try{url=new URL(value);}catch{return value;}
  if(url.username||url.password||!url.pathname.startsWith('/files/'))return value;
  if(!legacyOrigins.has(url.origin)&&url.origin!==currentOrigin)return value;
  return url.pathname+url.search+url.hash;
}
export function normalizeAttachmentUrls(value, currentOrigin, seen=new WeakSet()) {
  if(typeof value==='string')return localAttachmentUrl(value,currentOrigin);
  if(!value||typeof value!=='object'||seen.has(value))return value;
  seen.add(value);
  for(const key of Object.keys(value))value[key]=normalizeAttachmentUrls(value[key],currentOrigin,seen);
  return value;
}
