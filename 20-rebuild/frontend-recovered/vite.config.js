import fs from 'node:fs';
import {defineConfig} from 'vite';
import {inputNumberAriaCompatibility} from './tools/input-number-aria-compat.mjs';
import {recoveredSharedRuntime} from './tools/assemble.mjs';

function bimViewerConfig(policy, additions) {
  const viewer = policy.bim_viewer;
  if (viewer === undefined) return;
  const originsByField = {
    sdk_loader_url: ['script-src'],
    api_url: ['connect-src'],
    static_url: ['script-src', 'connect-src'],
    resource_url: ['connect-src']
  };
  if (!policy.integration_ids.includes('I03') || !viewer || typeof viewer !== 'object'
      || Array.isArray(viewer) || Object.keys(viewer).length !== 5
      || typeof viewer.sdk_version !== 'string' || !/^\d+\.\d+\.\d+$/.test(viewer.sdk_version)) {
    throw new Error('BIM 浏览器配置须随 I03 审核并明确 SDK 版本与四个地址');
  }
  const config = {sdk_version: viewer.sdk_version};
  for (const [field, directives] of Object.entries(originsByField)) {
    const value = viewer[field];
    if (typeof value !== 'string' || /[\s*'"<>\\?#]/.test(value) || !value.startsWith('https://')) {
      throw new Error('BIM 浏览器地址须使用明确的 HTTPS 地址');
    }
    const url = new URL(value);
    if (url.username || url.password || directives.some(directive => !additions.get(directive)?.includes(url.origin))) {
      throw new Error('BIM 浏览器地址须列入对应的资源策略，地址不能含凭据');
    }
    config[field] = url.href;
  }
  return config;
}

/** Ordinary builds retain the original policy; an integration build adds only reviewed origins. */
export function applyIntegrationBrowserPolicy(html, policy) {
  if (policy == null) return html;
  if (policy.schema !== 1 || policy.approved !== true || !Array.isArray(policy.integration_ids)
      || !policy.integration_ids.length || policy.integration_ids.some(id=>!/^I(?:0[1-9]|1[0-7])$/.test(id))) {
    throw new Error('第三方浏览器策略尚未按具体对接审核');
  }
  const allowed=new Set(['script-src','connect-src','img-src','font-src','style-src','frame-src','worker-src']);
  if (!policy.directives || typeof policy.directives !== 'object' || Array.isArray(policy.directives)) {
    throw new Error('第三方浏览器策略缺少明确的资源来源');
  }
  const additions=new Map();
  for (const [directive, origins] of Object.entries(policy.directives)) {
    if (!allowed.has(directive) || !Array.isArray(origins)) throw new Error('第三方浏览器策略指令无效');
    additions.set(directive, origins.map(origin=>{
      if (typeof origin !== 'string' || /[\s*'"<>]/.test(origin)) throw new Error('第三方资源只允许明确的来源地址');
      let url;try {url=new URL(origin);} catch {throw new Error('第三方资源来源格式无效');}
      const local=['127.0.0.1','localhost','[::1]'].includes(url.hostname);
      const secure=url.protocol==='https:' || (directive==='connect-src' && url.protocol==='wss:');
      const localPrinter=policy.integration_ids.includes('I17') && local
        && (url.protocol==='http:' || (directive==='connect-src' && url.protocol==='ws:'));
      if ((!secure && !localPrinter) || url.username || url.password || url.search || url.hash || url.pathname!=='/') {
        throw new Error('第三方资源必须使用HTTPS/WSS来源；本机打印来源需显式列入I17');
      }
      return url.origin;
    }));
  }
  const viewer = bimViewerConfig(policy, additions);
  let matches=0;
  const result=html.replace(/(<meta\s+http-equiv="Content-Security-Policy"\s+content=")([^"]*)(")/gi,(_,start,value,end)=>{
    matches++;
    const parts=value.split(';').map(part=>part.trim()).filter(Boolean).map(part=>part.split(/\s+/));
    for(const [directive,origins] of additions){
      let target=parts.find(part=>part[0]===directive);
      if(!target) {target=[directive];parts.push(target);}
      for(const origin of origins)if(!target.includes(origin))target.push(origin);
    }
    return start+parts.map(part=>part.join(' ')).join('; ')+end;
  });
  if(matches!==1) throw new Error('需要唯一的原始浏览器资源策略，停止构建');
  return viewer ? result.replace('</head>', `<script type="application/json" id="ljaps-bim-viewer-config">${JSON.stringify(viewer)}</script></head>`) : result;
}

function integrationBrowserPolicy() {
  return {name:'explicit-integration-browser-policy',transformIndexHtml(html){
    const file=process.env.LJAPS_INTEGRATION_BROWSER_POLICY;
    if(!file) return html;
    return applyIntegrationBrowserPolicy(html,JSON.parse(fs.readFileSync(file,'utf8')));
  }};
}

export default defineConfig({plugins:[recoveredSharedRuntime(),inputNumberAriaCompatibility(),integrationBrowserPolicy()],build:{target:'es2022',minify:false,sourcemap:true,chunkSizeWarningLimit:1500},server:{host:'127.0.0.1',port:3120,strictPort:true,proxy:{'/api':{target:'http://127.0.0.1:3119',changeOrigin:true},'/files':{target:'http://127.0.0.1:3119',changeOrigin:true}}}});
