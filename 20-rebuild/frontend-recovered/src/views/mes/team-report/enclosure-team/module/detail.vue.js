import { ref as _ } from "vue";
import { watch as O } from "vue";
import { inject as R } from "vue";
import { computed as q } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as x } from "vue";
import { createBlock as T } from "vue";
import { withCtx as u } from "vue";
import { withDirectives as D } from "vue";
import { unref as m } from "vue";
import { createVNode as c } from "vue";
import { createElementVNode as y } from "vue";
import { toDisplayString as h } from "vue";
import { normalizeClass as Q } from "vue";
import { isRef as H } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as z } from "element-plus";
import { l as $, u as A, o as U, pr as W, V as E, ps as j, ba as F } from "../../../../../shared/runtime.js";
import { _ as G } from "../../../../../modules/index-3b2628f3.js";
import { _ as J } from "../../../../../modules/index-490fd9d7.js";
function K(n) {
  return $({ module: "mes", url: "team_form/enclosure", method: "get", params: n });
}
function X(n) {
  return $({ module: "mes", url: "team_form/enclosure/details", method: "get", params: n });
}
const ae = { get: K }, Y = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(n, { emit: C }) {
  const v = _(), L = C, t = n, { visible: b, handleClose: V } = A({ emit: L, props: t, field: "visible" }), { maxHeight: B } = U({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, v);
  O(() => [t.visible, t.info], ([i]) => {
    i && S();
  }, { immediate: true, deep: true });
  const I = R("query"), g = _(false), k = _([]);
  function P(i) {
    return F(i, { props: ["taskQuantity", "completeQuantity", ["taskMete", o.value.DP], ["completeMete", o.value.DP]] });
  }
  const o = q(() => W({ productType: t.info.productType, w_unit: "kg" }));
  async function S() {
    var i, r, l;
    try {
      g.value = true;
      const p = Object.assign({ factoryId: (i = t.info.factory) == null ? void 0 : i.id, productType: t.info.productType, productionLineId: (r = t.info.productionLine) == null ? void 0 : r.id, projectId: (l = t.info.project) == null ? void 0 : l.id }, E(I)), w = await X(p);
      k.value = w.map((a, f) => {
        var d, s;
        return a.rowId = f + "" + Math.random(), a.completeMete = j({ productType: (d = t.info) == null ? void 0 : d.productType, weight: { num: a.completeNetWeight }, length: { num: a.completeLength, to: o.value.unit, dp: o.value.dp } }), a.taskMete = j({ productType: (s = t.info) == null ? void 0 : s.productType, weight: { num: a.taskNetWeight }, length: { num: a.taskLength, to: o.value.unit, dp: o.value.dp } }), a;
      });
    } catch (p) {
      console.log("获取围护班组进度详情", p);
    } finally {
      g.value = false;
    }
  }
  return (i, r) => {
    var f, d;
    const l = N, p = M("common-table"), w = M("common-drawer"), a = z;
    return x(), T(w, { ref_key: "drawerRef", ref: v, title: `生产线：${(f = n.info.workshop) == null ? void 0 : f.name}>${(d = n.info.productionLine) == null ? void 0 : d.name}`, modelValue: m(b), "onUpdate:modelValue": r[0] || (r[0] = (s) => H(b) ? b.value = s : null), direction: "rtl", "before-close": m(V), size: "70%" }, { titleRight: u(() => r[1] || (r[1] = [])), content: u(() => [D((x(), T(p, { "show-summary": "", "summary-method": P, data: k.value, "row-key": "rowId", "max-height": m(B), style: { width: "100%" } }, { default: u(() => {
      var s;
      return [c(l, { label: "序号", type: "index", align: "center", width: "60" }), c(m(G), { showProject: "", showMonomer: "", showArea: "" }), c(m(J), { productType: (s = n.info) == null ? void 0 : s.productType }, null, 8, ["productType"]), c(l, { prop: "taskQuantity", "show-overflow-tooltip": true, label: `任务数(${o.value.measure})`, align: "center", "min-width": "100px" }, { default: u(({ row: e }) => [y("span", null, h(e.taskQuantity), 1)]), _: 1 }, 8, ["label"]), c(l, { prop: "taskMete", "show-overflow-tooltip": true, label: `任务量(${o.value.unit})`, align: "center", "min-width": "100px" }, { default: u(({ row: e }) => [y("span", null, h(e.taskMete), 1)]), _: 1 }, 8, ["label"]), c(l, { key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: `完成数(${o.value.measure})`, align: "center", "min-width": "100px" }, { default: u(({ row: e }) => [y("span", { class: Q(e.completeQuantity === e.taskQuantity ? "tc-success" : "tc-danger") }, h(e.completeQuantity), 3)]), _: 1 }, 8, ["label"]), c(l, { key: "completeMete", prop: "completeMete", "show-overflow-tooltip": true, label: `完成量(${o.value.unit})`, align: "center", "min-width": "100px" }, { default: u(({ row: e }) => [y("span", { class: Q(e.completeQuantity === e.taskQuantity ? "tc-success" : "tc-danger") }, h(e.completeMete), 3)]), _: 1 }, 8, ["label"])];
    }), _: 1 }, 8, ["data", "max-height"])), [[a, g.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ne = Object.freeze(Object.defineProperty({ __proto__: null, default: Y }, Symbol.toStringTag, { value: "Module" }));
export {
  Y as _,
  ae as c,
  ne as d
};
