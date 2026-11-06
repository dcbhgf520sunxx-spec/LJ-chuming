import { ref as h } from "vue";
import { watch as I } from "vue";
import { inject as T } from "vue";
import { computed as x } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as L } from "vue";
import { createBlock as M } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as b } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { toDisplayString as w } from "vue";
import { isRef as $ } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as q } from "element-plus";
import { l as V, u as z, o as W, a3 as p, pr as F, V as G, ps as J } from "../../../../../../shared/runtime.js";
import { _ as K } from "../../../../../../modules/index-3b2628f3.js";
import { _ as X } from "../../../../../../modules/index-490fd9d7.js";
function Y(i) {
  return V({ module: "mes", url: "analysis/hysteresis", method: "get", params: i });
}
function Z(i) {
  return V({ module: "mes", url: "analysis/hysteresis/details", method: "get", params: i });
}
const re = { get: Y }, ee = { class: "print-wrap" }, te = { class: "tc-danger" }, ae = { class: "tc-danger" }, se = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(i, { emit: A }) {
  const g = h(), R = A, m = i, { visible: d, handleClose: P } = z({ emit: R, props: m, field: "visible" }), { maxHeight: j } = W({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, g);
  I(() => m.visible, (n) => {
    n && Q();
  }, { immediate: true });
  const l = T("query"), B = T("permission"), _ = h(false), v = h([]), E = { [p.ARTIFACT.V]: "artifactAssembleList", [p.ASSEMBLE.V]: "artifactAssembleList", [p.MACHINE_PART.V]: "artifactAssembleList", [p.ENCLOSURE.V]: "enclosureList" }, r = x(() => F({ productType: l.productType, w_unit: "kg" })), C = x(() => Object.assign(G(l), { dateTime: m.info.askCompleteTime }));
  async function Q() {
    try {
      _.value = true;
      const n = await Z(C.value);
      v.value = n[E[l.productType]].map((e, f) => (e.rowId = f + "" + Math.random(), e.unCompleteQuantity = e.taskQuantity - e.completeQuantity, e.unCompleteMete = J({ productType: l.productType, weight: { num: e.taskNetWeight - e.completeNetWeight }, length: { num: e.taskLength - e.completeLength, to: r.value.unit, dp: r.value.dp } }), e));
    } catch (n) {
      console.log("获取未完成清单", n);
    } finally {
      _.value = false;
    }
  }
  return (n, e) => {
    const f = y("print-table"), c = U, S = y("common-table"), N = y("common-drawer"), O = k("permission"), D = k("parse-time"), H = q;
    return L(), M(N, { ref_key: "drawerRef", ref: g, title: "未完成清单", modelValue: o(d), "onUpdate:modelValue": e[0] || (e[0] = (t) => $(d) ? d.value = t : null), direction: "rtl", "before-close": o(P), size: "80%" }, { titleRight: s(() => [u("div", ee, [b(a(f, { "api-key": "mesUnfinishedList", params: C.value, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[O, o(B).printDetail]])])]), content: s(() => [b((L(), M(S, { "row-key": "rowId", data: v.value, "max-height": o(j), style: { width: "100%" } }, { default: s(() => [a(c, { label: "序号", type: "index", align: "center", width: "60" }), a(o(K), { showProject: "", showMonomer: "", showArea: "", showProductionLine: "" }), a(o(X), { productType: o(l).productType }, null, 8, ["productType"]), a(c, { prop: "taskQuantity", label: `任务数(${r.value.measure})`, "min-width": "100px", align: "center" }, { default: s((t) => [u("span", null, w(t.row.taskQuantity), 1)]), _: 1 }, 8, ["label"]), a(c, { prop: "askCompleteTime", label: "要求完成日期", align: "center", "min-width": "110px" }, { default: s((t) => [b(u("span", null, null, 512), [[D, { val: t.row.askCompleteTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), a(c, { prop: "unCompleteQuantity", label: `未完成数(${r.value.measure})`, "min-width": "100px", align: "center" }, { default: s((t) => [u("span", te, w(t.row.unCompleteQuantity), 1)]), _: 1 }, 8, ["label"]), a(c, { prop: "unCompleteMete", label: `未完成量(${r.value.unit})`, "min-width": "100px", align: "center" }, { default: s((t) => [u("span", ae, w(t.row.unCompleteMete), 1)]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["data", "max-height"])), [[H, _.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ce = Object.freeze(Object.defineProperty({ __proto__: null, default: se }, Symbol.toStringTag, { value: "Module" }));
export {
  se as _,
  re as c,
  ce as d
};
