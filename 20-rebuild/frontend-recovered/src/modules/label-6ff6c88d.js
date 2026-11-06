import { l as i, bp as r } from "../shared/runtime.js";
function A(s, e) {
  return i({ module: "mes", url: "print/config", method: "get", params: { projectId: s, printType: e } });
}
function _(s) {
  return i({ module: "mes", url: "print/config", method: "post", data: s });
}
const l = { ARTIFACT_TASK: "/s/s/a", ENCLOSURE_TASK: "/s/s/e", AUXILIARY_MATERIAL: "/s/s/m", BRIDGE_BOX_TASK: "/s/b/b", BRIDGE_SINGLE_ELEMENT_TASK: "/s/b/s", BRIDGE_AUXILIARY_MATERIAL: "/s/b/m" };
function m(s, e) {
  let t = r(s, e);
  if (t.length > 271) {
    const n = JSON.parse(JSON.stringify(e));
    delete n.mn, t = r(s, n);
  }
  return t;
}
export {
  l as Q,
  _ as a,
  A as g,
  m as s
};
