import { ref as y } from "vue";
import { inject as M } from "vue";
import { watch as J } from "vue";
import { computed as z } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as I } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as L } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { toDisplayString as d } from "vue";
import { normalizeClass as P } from "vue";
import { isRef as K } from "vue";
import { ElTableColumn as X } from "element-plus";
import { ElPagination as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { p as ee } from "../../../../../modules/artifact-team-58f45cf9.js";
import { u as te, J as ae, o as oe, pr as ne, V as ie, ps as Q, a3 as le } from "../../../../../shared/runtime.js";
import { _ as se } from "../../../../../modules/index-3b2628f3.js";
import { _ as re } from "../../../../../modules/index-490fd9d7.js";
const ce = { class: "print-wrap" }, ge = { __name: "item-detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} }, itemInfo: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(p, { emit: S }) {
  const _ = y(), V = S, i = p, { visible: f, handleClose: j } = te({ emit: V, props: i, field: "visible" }), { handleSizeChange: B, handleCurrentChange: H, total: R, setTotalPage: D, queryPage: g } = ae({ fetchHook: k }), N = M("permission"), { maxHeight: q } = oe({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: true, clientHRepMainH: true, extraHeight: 60 }, _);
  J(() => [i.visible, i.itemInfo], ([o]) => {
    o && k();
  }, { immediate: true, deep: true });
  const E = M("query"), h = y(false), b = y([]), l = z(() => ne({ productType: i.info.productType, w_unit: "kg" })), v = z(() => {
    var o, s;
    return Object.assign(ie(E), { factoryId: (o = i.info.factory) == null ? void 0 : o.id, processId: i.itemInfo.id, productType: i.info.productType, productionLineId: (s = i.info.productionLine) == null ? void 0 : s.id });
  });
  async function k() {
    try {
      h.value = true;
      const { content: o, totalElements: s } = await ee({ ...v.value, ...g });
      D(s), b.value = o.map((e, r) => (e.rowId = r + "" + Math.random(), e.completeMete = Q({ productType: e.productType, weight: { num: e.completeNetWeight }, length: { num: e.completeLength, to: l.value.unit, dp: l.value.dp } }), e.taskMete = Q({ productType: e.productType, weight: { num: e.taskNetWeight }, length: { num: e.taskLength, to: l.value.unit, dp: l.value.dp } }), e));
    } catch (o) {
      console.log("获取结构班组进度工序详情", o);
    } finally {
      h.value = false;
    }
  }
  return (o, s) => {
    var x, C, T;
    const e = w("print-table"), r = X, O = w("common-table"), U = Y, W = w("common-drawer"), A = G("permission"), F = Z;
    return I(), $(W, { ref_key: "drawerRef", ref: _, title: `生产线：${(x = p.info.workshop) == null ? void 0 : x.name}>${(C = t(le).V[p.info.productType]) == null ? void 0 : C.SL}>${(T = p.info.productionLine) == null ? void 0 : T.name}>${p.itemInfo.name}`, modelValue: t(f), "onUpdate:modelValue": s[0] || (s[0] = (m) => K(f) ? f.value = m : null), direction: "rtl", "before-close": t(j), size: "70%" }, { titleRight: c(() => [u("div", ce, [L(n(e, { "api-key": "mesStructureProcess", params: v.value, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[A, t(N).printDetail]])])]), content: c(() => [L((I(), $(O, { data: b.value, "row-key": "rowId", "max-height": t(q), style: { width: "100%" } }, { default: c(() => {
      var m;
      return [n(r, { label: "序号", type: "index", align: "center", width: "60" }), n(t(se), { showProject: "", showMonomer: "", showArea: "" }), n(t(re), { productType: (m = p.info) == null ? void 0 : m.productType, unShowField: ["material"] }, null, 8, ["productType"]), n(r, { prop: "taskQuantity", "show-overflow-tooltip": true, label: `任务数(${l.value.measure})`, align: "center", "min-width": "100px" }, { default: c(({ row: a }) => [u("span", null, d(a.taskQuantity), 1)]), _: 1 }, 8, ["label"]), n(r, { prop: "taskMete", "show-overflow-tooltip": true, label: `任务量(${l.value.unit})`, align: "center", "min-width": "100px" }, { default: c(({ row: a }) => [u("span", null, d(a.taskMete), 1)]), _: 1 }, 8, ["label"]), n(r, { key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: `完成数(${l.value.measure})`, align: "center", "min-width": "100px" }, { default: c(({ row: a }) => [u("span", { class: P(a.completeQuantity === a.taskQuantity ? "tc-success" : "tc-danger") }, d(a.completeQuantity), 3)]), _: 1 }, 8, ["label"]), n(r, { key: "completeMete", prop: "completeMete", "show-overflow-tooltip": true, label: `完成量(${l.value.unit})`, align: "center", "min-width": "100px" }, { default: c(({ row: a }) => [u("span", { class: P(a.completeQuantity === a.taskQuantity ? "tc-success" : "tc-danger") }, d(a.completeMete), 3)]), _: 1 }, 8, ["label"])];
    }), _: 1 }, 8, ["data", "max-height"])), [[F, h.value]]), n(U, { total: t(R), "current-page": t(g).pageNumber, "page-size": t(g).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(B), onCurrentChange: t(H) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  ge as default
};
