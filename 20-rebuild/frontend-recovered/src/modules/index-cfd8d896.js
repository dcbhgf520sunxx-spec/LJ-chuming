import { l as o } from "../shared/runtime.js";
function t(e) {
  return o({ module: "mes", url: "qhse/page", method: "get", params: e });
}
function s({ id: e }) {
  return o({ module: "mes", url: `qhse/detail/${e}/download`, responseType: "blob", method: "get" });
}
const n = { get: t };
export {
  t as a,
  n as c,
  s as g
};
