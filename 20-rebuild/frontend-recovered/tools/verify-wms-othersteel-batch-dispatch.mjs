import fs from 'node:fs';import crypto from 'node:crypto';
const root=new URL('../',import.meta.url).pathname;let checks=[];
for(const [party,path,name,enm,aliases]of [
 [false,'src/views/wms/material-purchase/warehouse-management/material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js','$e','U',['Wt','Lt','At','Ve','kt','Mt']],
 [true,'src/views/wms/material-partyA/warehouse-management/material-outbound/raw-material/components/outbound-batch-handling-form/index.vue.js','Te','y',['mt','pt','dt','ae','ct','rt']]]){
 const source=fs.readFileSync(root+path,'utf8'),start=source.indexOf('  function '+name+'('),end=source.indexOf('\n  }',start)+4,body=source.slice(start,end),types={STEEL_PLATE:{V:1},SECTION_STEEL:{V:2},STEEL_COIL:{V:4},MATERIAL:{V:8},OTHER:{V:128},GAS:{V:16},OTHER_STEEL_MATERIALS:{V:256}},paths=['steel-plate','section-steel','steel-coil','auxiliary-material','other-material','gas'].map(t=>'/api/wms/outbound/application/'+t+'/batch');
 const run=code=>new Function(enm,...aliases,code+';return '+name+'(256);')(types,...paths),actual=run(body),historical=run(body.replace('      case '+enm+'.OTHER_STEEL_MATERIALS.V:\n',''));
 if(actual!==paths[0]||historical!==paths[3])throw Error('256 exact branch did not change as expected');
 checks.push({check_id:'current_othersteel_'+(party?'party':'self')+'_batch_dispatch_actual_function',status:'passed',source:path,source_sha256:crypto.createHash('sha256').update(source).digest('hex'),function:name,material:256,historical_route:historical,current_route:actual,verification:'Exact extracted current function executed with only imported provider functions replaced by their route labels; native HTTP before remains separate.'});
}
const result={verified_at:new Date().toISOString(),cases:checks.length,passed:checks.length,failed:0,http_calls:0,checks};fs.writeFileSync(root+'wms-othersteel-batch-dispatch-verification.json',JSON.stringify(result,null,2)+'\n');console.log(JSON.stringify(result));
