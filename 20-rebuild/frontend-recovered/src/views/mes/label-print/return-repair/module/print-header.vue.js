import { inject as n } from "vue";
import { ref as c } from "vue";
import { reactive as b } from "vue";
import { watch as z } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as H } from "vue";
import { createCommentVNode as q } from "vue";
import { withDirectives as $ } from "vue";
import { unref as a } from "vue";
import { createBlock as B } from "vue";
import { withCtx as D } from "vue";
import { createTextVNode as U } from "vue";
import { g as G, s as J, Q as K } from "../../../../../modules/label-6ff6c88d.js";
import { l as u, _ as W, m as X, bo as Y, bh as v, bm as Z, V as P } from "../../../../../shared/runtime.js";
import { u as ee } from "../../../../../modules/use-label-print-e19db37a.js";
import "../../../../../modules/constant_2-1ad5d80f.js";
function te(r) {
  return u({ module: "mes", url: "print/returnArtifact/project/list", method: "get", params: r });
}
function le(r) {
  return u({ module: "mes", url: "print/returnArtifact/list", method: "get", params: r });
}
function N({ id: r, quantity: l, startTime: d, endTime: s, numberList: i }) {
  return u({ module: "mes", url: "print/returnArtifact/print", method: "post", data: { warehouseId: r, quantity: l, startTime: d, endTime: s, numberList: i } });
}
function de(r) {
  return u({ module: "mes", url: `print/returnArtifact/${r}`, method: "get" });
}
const me = { get: te };
const re = { class: "flex-rbc" }, oe = { __name: "print-header", emits: ["refresh"], setup(r, { expose: l, emit: d }) {
  const { globalProjectId: s, user: i, requestUrl: A } = X(["globalProjectId", "user", "requestUrl"]), C = d, T = n("permission");
  n("productType");
  const I = n("printType"), g = n("selections"), labelProjectId = n("labelProjectId", s);
  c(false), c(false);
  const h = c(false);
  let t = b({ weight: Y.NET.V, type: v.COMMON.V, labelSize: Z.ONE.V, showProjectName: true, showProjectSerialNumber: true, showLength: true, showArea: true, showMonomer: true, dateInProduced: true, showSpecification: true, showQuantity: true, manufacturerName: "", copiesQuantity: 1, language: "zh" });
  const m = c(P(t)), j = b({});
  function L() {
    for (const e in v.V) j[e] = false;
  }
  L(), z(() => labelProjectId.value, () => {
    x();
  }, { immediate: true });
  async function x() {
    if (labelProjectId.value == null) return;
    try {
      h.value = true;
      const e = await G(labelProjectId.value, I);
      if (e) {
        const { type: o, weight: p, showArea: f, showMonomer: _, dateInProduced: E, manufacturerName: M, copiesQuantity: O } = e;
        t.weight = p, t.type = o, t.showArea = f, t.showMonomer = _, t.dateInProduced = E, t.manufacturerName = M, t.copiesQuantity = O || 1, m.value = P(t);
      }
    } catch (e) {
      console.log("项目打印配置", e);
    } finally {
      h.value = false;
    }
  }
  function Q() {
    C("refresh");
  }
  const { getLabelInfo: V, printLabelFunc: R } = n("headerObj"), { batchPrint: S, print: k } = ee({ getPrintTotalNumber: (e) => (e.printQuantity || 0) * m.value.copiesQuantity, getLabelInfo: V, printFinallyHook: Q, getLoadingTextFunc: (e) => `${e.name}-${e.serialNumber}`, printLabelFunc: R, needAddPrintRecord: true, addPrintIdField: "warehouseId", addPrintRecordReq: N });
  return l({ companyName: i.value && i.value.companyName, printConfig: m, spliceQrCodeUrl: J, QR_SCAN_PATH: K, requestUrl: A, print: k }), (e, o) => {
    y("common-radio-button");
    const p = y("common-button"), f = F("permission");
    return w(), H("div", re, [q("", true), $((w(), B(p, { disabled: a(g).length === 0, size: "small", type: "success", onClick: o[9] || (o[9] = (_) => a(S)(a(g), "warehouseId", a(N))) }, { default: D(() => o[18] || (o[18] = [U("批量打印标签 ")])), _: 1, __: [18] }, 8, ["disabled"])), [[f, a(T).print]])]);
  };
} }, ne = W(oe, [["__scopeId", "data-v-90fadeed"]]), pe = Object.freeze(Object.defineProperty({ __proto__: null, default: ne }, Symbol.toStringTag, { value: "Module" }));
export {
  de as a,
  me as c,
  le as g,
  ne as m,
  pe as p
};
