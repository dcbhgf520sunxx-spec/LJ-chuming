import { ref as R } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as g } from "vue";
import { openBlock as i } from "vue";
import { createBlock as f } from "vue";
import { withCtx as l } from "vue";
import { createVNode as n } from "vue";
import { createElementBlock as r } from "vue";
import { toDisplayString as K } from "vue";
import { withDirectives as y } from "vue";
import { normalizeClass as T } from "vue";
import { createElementVNode as N } from "vue";
import { withModifiers as D } from "vue";
import { createCommentVNode as B } from "vue";
import { mergeProps as w } from "vue";
import { nextTick as S } from "vue";
import { ElTableColumn as z } from "element-plus";
import { ElInputNumber as A } from "element-plus";
import { ElTooltip as G } from "element-plus";
import { _ as L, jN as M, sG as k, iX as O } from "../../../../../../../../shared/runtime.js";
const U = { key: 1 }, j = { key: 0 }, W = { key: 1 }, $ = { key: 1 }, q = { __name: "structure", props: { height: { type: Number, default: 250 }, list: { type: Array, default: () => [] }, techPrepMeteKV: { type: Object, default: () => ({}) }, editMode: { type: Boolean, default: false } }, setup(a, { expose: C }) {
  const c = a, m = R(), v = [["listMete", ["to-fixed", M.weight.precision]]];
  function x(o) {
    c.list.splice(o, 1);
  }
  function I(o, p, t) {
    const u = () => {
      if (p !== t.listMete) {
        t.operateType !== k.ADD.V && (t.operateType = k.EDIT.V);
        const s = c.techPrepMeteKV[t.id];
        s.diff = O(s.preparation - t.listMete, M.weight.precision), s.isEnough = s.diff >= 0;
      }
    };
    !o || o <= 0 ? S(() => {
      t.listMete = p, u();
    }) : u();
  }
  return C({ setCurrentRow: (o) => {
    m.value.setCurrentRow(o);
  } }), (o, p) => {
    const t = z, u = A, s = b("common-button"), V = G, P = b("common-table"), _ = g("to-fixed"), E = g("prefix");
    return i(), f(P, w({ class: "list-table" }, o.$attrs, { ref_key: "tableRef", ref: m, data: a.list, "data-format": v, height: c.height, "row-key": "id" }), { default: l(() => [n(t, { label: "序号", type: "index", align: "center", width: "60" }), n(t, { label: "钢材种类", key: "steelClassifyConfName", prop: "steelClassifyConfName", align: "center", width: "100" }), n(t, { label: "材质", key: "material", prop: "material", align: "center", width: "100" }), n(t, { label: "厚度/规格", key: "specification", prop: "specification", align: "center" }), n(t, { label: "清单量（kg）", key: "listMete", prop: "listMete", align: "center", width: "110" }, { default: l(({ row: e }) => [c.editMode ? (i(), f(u, { key: 0, modelValue: e.sourceRow.listMete, "onUpdate:modelValue": (d) => e.sourceRow.listMete = d, controls: false, min: 0, max: 999999999, placeholder: "清单量", size: "default", onChange: (d, h) => I(d, h, e.sourceRow) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (i(), r("span", U, K(e.listMete), 1))]), _: 1 }), n(t, { label: "备料量（kg）", key: "preparationMete", prop: "preparationMete", align: "center", width: "110" }, { default: l(({ row: { sourceRow: e } }) => [a.techPrepMeteKV[e.id] ? y((i(), r("span", j, null, 512)), [[_, { val: a.techPrepMeteKV[e.id].preparation, k: "COM_WT__KG" }]]) : (i(), r("span", W, "-"))]), _: 1 }), n(t, { label: "差值（kg）", key: "diff", prop: "diff", align: "center", width: "100" }, { default: l(({ row: { sourceRow: e } }) => [a.techPrepMeteKV[e.id] ? y((i(), r("span", { key: 0, class: T(a.techPrepMeteKV[e.id].isEnough ? "over-text" : "not-over-text") }, null, 2)), [[_, { val: a.techPrepMeteKV[e.id].diff, k: "COM_WT__KG" }], [E, a.techPrepMeteKV[e.id].isEnough && a.techPrepMeteKV[e.id].diff !== 0 ? "+" : ""]]) : (i(), r("span", $, "-"))]), _: 1 }), c.editMode ? (i(), f(t, { label: "操作", key: "preparationMete", prop: "preparationMete", align: "center", width: "55" }, { default: l(({ row: { sourceRow: e }, $index: d }) => [n(V, { class: "item", effect: "dark", content: "当前清单有“绑定的库存利用清单”或“需要采购清单”，无法被删除", disabled: !(e.boundInvIds && e.boundInvIds.length > 0 || e.boundPurIds && e.boundPurIds.length > 0), placement: "top-start" }, { default: l(() => [N("span", null, [n(s, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, disabled: e.boundInvIds && e.boundInvIds.length > 0 || e.boundPurIds && e.boundPurIds.length > 0, onClick: D((h) => x(d), ["stop"]) }, null, 8, ["disabled", "onClick"])])]), _: 2 }, 1032, ["disabled"])]), _: 1 })) : B("", true)]), _: 1 }, 16, ["data", "height"]);
  };
} }, H = L(q, [["__scopeId", "data-v-e23eb582"]]);
export {
  H as default
};
