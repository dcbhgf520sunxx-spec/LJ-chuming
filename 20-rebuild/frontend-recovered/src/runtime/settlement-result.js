export function requireDraftLedgerId(result) {
  const id=result?.data;
  const validId=typeof id==='string'?/^[1-9]\d*$/.test(id):Number.isSafeInteger(id)&&id>0;
  if(Number(result?.code)!==20000||!validId)throw new Error(result?.message||'结算草稿生成失败，未返回有效草稿编号');
  return id;
}
export function requireBooleanOperation(result) {
  if(result!==true)throw new Error(result?.message||'操作未成功，未收到成功结果');
  return true;
}
export function requireOaRequestId(result) {
  let value=result;
  if(typeof value==='string')try{value=JSON.parse(value);}catch{throw new Error('OA未返回有效审批编号');}
  if(value?.code!==undefined&&!["SUCCESS",20000,"20000"].includes(value.code))throw new Error(value.errMsg||value.message||"OA审批请求未成功");
  const id=value?.requestid;
  if(!((typeof id==='string'&&/^[1-9]\d*$/.test(id))||(Number.isSafeInteger(id)&&id>0)))throw new Error(value?.errMsg||value?.message||'OA未返回有效审批编号');
  return id;
}

// Match the serialized POST values; object key order does not change draft identity.
export function settlementDraftFingerprint(payload) {
  return JSON.stringify(payload, (_key, value) => value && typeof value === 'object' && !Array.isArray(value)
    ? Object.fromEntries(Object.keys(value).sort().map(key => [key, value[key]])) : value);
}
