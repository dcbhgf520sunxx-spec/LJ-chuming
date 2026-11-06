import { l as o } from "../shared/runtime.js";
function c(t) {
  return o({ module: "contract", url: "contract/collection/project", method: "get", params: t });
}
function u(t) {
  return o({ module: "contract", url: "contract/collection/listPage", method: "get", params: t });
}
function e(t) {
  return o({ module: "contract", url: "contract/collection/project", method: "post", params: { projectId: t.projectId }, data: t.list });
}
function n(t) {
  return o({ module: "contract", url: "contract/collection/project", method: "put", data: t });
}
function r(t) {
  return o({ module: "contract", url: `contract/collection/deleteById/${t}/project`, method: "delete" });
}
function a(t) {
  return o({ module: "contract", url: "contract/collection/getFinanceInfo", method: "get", params: t, cancelKey: false });
}
function d(t) {
  return o({ module: "contract", url: "contract/collection/audit/project", method: "put", data: t });
}
function i(t) {
  return o({ module: "contract", url: `branchCompany/listBankAccountByCompanyId/${t}`, method: "get" });
}
function m(t) {
  return o({ module: "contract", url: "contract/collection/getCollectionSum", method: "get", params: t });
}
const s = { get: c, add: e, edit: n, del: r };
export {
  m as a,
  a as b,
  s as c,
  i as d,
  d as e,
  u as g
};
