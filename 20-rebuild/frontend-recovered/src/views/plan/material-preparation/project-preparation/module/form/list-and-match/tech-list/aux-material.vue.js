import { ref as V } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as i } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as r } from "vue";
import { createVNode as n } from "vue";
import { unref as g } from "vue";
import { createElementBlock as o } from "vue";
import { toDisplayString as E } from "vue";
import { withDirectives as M } from "vue";
import { normalizeClass as K } from "vue";
import { mergeProps as R } from "vue";
import { nextTick as D } from "vue";
import { ElTableColumn as T } from "element-plus";
import { ElInputNumber as A } from "element-plus";
import { _ as B, am as I, jG as z, k5 as U, sG as b, iX as L } from "../../../../../../../../shared/runtime.js";
const N = { key: 1 }, j = { key: 0 }, w = { key: 1 }, G = { key: 1 }, $ = { __name: "aux-material", props: { height: { type: Number, default: 250 }, list: { type: Array, default: () => [] }, techPrepMeteKV: { type: Object, default: () => ({}) }, editMode: { type: Boolean, default: false } }, setup(a) {
  const d = a, u = I.MATERIAL.V, y = V(), x = [["listMete", ["to-fixed-field", "accountingPrecision"]]];
  function k(l, f, t) {
    const c = () => {
      if (f !== t.listMete) {
        t.operateType !== b.ADD.V && (t.operateType = b.EDIT.V);
        const s = d.techPrepMeteKV[t.id];
        s.diff = L(s.preparation - t.listMete, t.accountingPrecision), s.isEnough = s.diff >= 0;
      }
    };
    !l || l <= 0 ? D(() => {
      t.listMete = f, c();
    }) : c();
  }
  return (l, f) => {
    const t = T, c = A, s = C("common-table"), m = h("to-fixed"), v = h("prefix");
    return i(), _(s, R({ class: "list-table" }, l.$attrs, { ref_key: "tableRef", ref: y, data: a.list, "data-format": x, height: d.height, "row-key": "id" }), { default: r(() => [n(z, { "show-serial-number": false, "basic-class": g(u), "show-frozen-tip": "", "frozen-viewable": "", "spec-merge": "", sortable: "", fixed: "left" }, null, 8, ["basic-class"]), n(U, { "basic-class": g(u) }, null, 8, ["basic-class"]), n(t, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", width: "70px", "show-overflow-tooltip": "" }), n(t, { label: "清单量", key: "listMete", prop: "listMete", align: "center", width: "110" }, { default: r(({ row: e }) => [d.editMode ? (i(), _(c, { key: 0, modelValue: e.sourceRow.listMete, "onUpdate:modelValue": (p) => e.sourceRow.listMete = p, controls: false, min: 0, max: 999999999, placeholder: "清单量", size: "default", onChange: (p, P) => k(p, P, e.sourceRow) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (i(), o("span", N, E(e.listMete), 1))]), _: 1 }), n(t, { label: "备料量", key: "preparationMete", prop: "preparationMete", align: "center", width: "110" }, { default: r(({ row: { sourceRow: e } }) => [a.techPrepMeteKV[e.id] ? M((i(), o("span", j, null, 512)), [[m, { val: a.techPrepMeteKV[e.id].preparation, dp: e.accountingPrecision }]]) : (i(), o("span", w, "-"))]), _: 1 }), n(t, { label: "差值", key: "diff", prop: "diff", align: "center", width: "100" }, { default: r(({ row: { sourceRow: e } }) => [a.techPrepMeteKV[e.id] ? M((i(), o("span", { key: 0, class: K(a.techPrepMeteKV[e.id].isEnough ? "over-text" : "not-over-text") }, null, 2)), [[m, { val: a.techPrepMeteKV[e.id].diff || 0, dp: e.accountingPrecision }], [v, a.techPrepMeteKV[e.id].isEnough && a.techPrepMeteKV[e.id].diff !== 0 ? "+" : ""]]) : (i(), o("span", G, "-"))]), _: 1 })]), _: 1 }, 16, ["data", "height"]);
  };
} }, O = B($, [["__scopeId", "data-v-f468823a"]]);
export {
  O as default
};
