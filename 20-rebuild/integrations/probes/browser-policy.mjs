import assert from 'node:assert/strict';
import fs from 'node:fs';
import {applyIntegrationBrowserPolicy} from '../../frontend-recovered/vite.config.js';

const original=fs.readFileSync(new URL('../../frontend-recovered/index.html',import.meta.url),'utf8');
assert.equal(applyIntegrationBrowserPolicy(original,null),original);
const policy={schema:1,approved:true,integration_ids:['I03'],directives:{'script-src':['https://static.bimface.com'],'connect-src':['https://api.bimface.com']}};
const result=applyIntegrationBrowserPolicy(original,policy);
assert.ok(result.includes("script-src 'self' 'unsafe-inline' 'unsafe-eval' https://static.bimface.com"));
assert.ok(result.includes("default-src 'self' data: blob:"));
assert.ok(!original.includes('https://static.bimface.com'));
for(const origin of ['*','https://*.example.test','https://user:secret@example.test','https://example.test/path','data:text/html,test','http://example.test','https://example.test/?token=test','https://example.test/#x']) {
  assert.throws(()=>applyIntegrationBrowserPolicy(original,{...policy,directives:{'script-src':[origin]}}));
}
assert.throws(()=>applyIntegrationBrowserPolicy(original,{...policy,approved:false}));
assert.throws(()=>applyIntegrationBrowserPolicy(original,{...policy,directives:{'default-src':['https://example.test']}}));
assert.throws(()=>applyIntegrationBrowserPolicy(original,{...policy,directives:{'connect-src':['http://127.0.0.1:8000']}}));
assert.ok(applyIntegrationBrowserPolicy(original,{...policy,integration_ids:['I17'],directives:{'connect-src':['http://127.0.0.1:8000']}}).includes('http://127.0.0.1:8000'));
assert.throws(()=>applyIntegrationBrowserPolicy('no meta',policy));
console.log(JSON.stringify({status:'passed',checks:17,networkRequests:0,servicesStarted:0}));
