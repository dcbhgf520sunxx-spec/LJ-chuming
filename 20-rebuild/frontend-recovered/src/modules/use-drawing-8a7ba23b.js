import { a3 as p } from "../shared/runtime.js";
import { ref as i } from "vue";
function b({ pidField: u = "id", typeField: c = "productType", productTypeField: m }) {
  const t = i(false), a = i({});
  function o(e) {
    var n, r;
    a.value = { boolBim: e.boolBim, monomerId: e.monomerId || ((n = e == null ? void 0 : e.monomer) == null ? void 0 : n.id), serialNumber: e.artifactSerialNumber || e.serialNumber || e.productSerialNumber, drawingSN: e.numbers || e.number, attachmentId: e.attachmentId, productId: e[u], productType: m && ((r = p[m]) == null ? void 0 : r.V) || e[c], projectType: e.projectType }, t.value = true;
  }
  return { showDrawing: t, drawingRow: a, drawingPreview: o };
}
export {
  b as u
};
