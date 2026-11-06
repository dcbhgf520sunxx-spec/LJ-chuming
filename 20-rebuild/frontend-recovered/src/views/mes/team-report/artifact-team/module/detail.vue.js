import { ref as b } from "vue";
import { watch as E } from "vue";
import { inject as N } from "vue";
import { computed as k } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as V } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as O } from "vue";
import { unref as e } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as A } from "vue";
import { toDisplayString as q } from "vue";
import { createElementVNode as z } from "vue";
import { isRef as U } from "vue";
import { ElTableColumn as W } from "element-plus";
import { ElPagination as F } from "element-plus";
import { vLoading as J } from "element-plus";
import { d as G } from "../../../../../modules/artifact-team-58f45cf9.js";
import { u as K, J as X, o as Y, pr as Z, V as ee, ps as te, a3 as ae } from "../../../../../shared/runtime.js";
import { _ as oe } from "../../../../../modules/index-3b2628f3.js";
import { _ as ne } from "../../../../../modules/index-490fd9d7.js";
const ie = ["innerHTML"], ce = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(s, { emit: H }) {
  const v = b(), M = H, i = s, { visible: m, handleClose: j } = K({ emit: M, props: i, field: "visible" }), { handleSizeChange: P, handleCurrentChange: B, total: Q, setTotalPage: I, queryPage: f } = X({ fetchHook: C }), { maxHeight: R } = Y({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, extraHeight: 60 }, v);
  E(() => [i.visible, i.info], ([u]) => {
    u && C();
  }, { immediate: true, deep: true });
  const D = N("query"), g = b(false), x = b([]), h = k(() => i.info.productType), c = k(() => Z({ productType: h.value, l_unit: "mm", w_unit: "kg", isSingle: true }));
  async function C() {
    var u, o;
    try {
      g.value = true;
      const a = Object.assign(ee(D), { factoryId: (u = i.info.factory) == null ? void 0 : u.id, productType: h.value, productionLineId: (o = i.info.productionLine) == null ? void 0 : o.id, ...f }), { content: y, totalElements: w } = await G(a);
      I(w), x.value = y.map((t, _) => (t.rowId = _ + "" + Math.random(), t.processSequence = t.processSummaryDetailsDOList.map((r) => `<span>【 ${r.name} │ <span style="color: #67C23A;">${r.completeQuantity === t.taskQuantity ? "√" : r.completeQuantity || 0}</span> 】</span>`).join("<span>→</span>"), t.mete = te({ productType: h.value, weight: { num: t.netWeight }, length: { num: t.length, to: c.value.unit, dp: c.value.dp } }), t));
    } catch (a) {
      console.log("获取结构班组进度详情", a);
    } finally {
      g.value = false;
    }
  }
  return (u, o) => {
    var r, T, S;
    const a = W, y = L("common-table"), w = F, t = L("common-drawer"), _ = J;
    return V(), $(t, { ref_key: "drawerRef", ref: v, title: `生产线：${(r = s.info.workshop) == null ? void 0 : r.name}>${(T = e(ae).V[s.info.productType]) == null ? void 0 : T.SL}>${(S = s.info.productionLine) == null ? void 0 : S.name}`, modelValue: e(m), "onUpdate:modelValue": o[0] || (o[0] = (d) => U(m) ? m.value = d : null), direction: "rtl", "before-close": e(j), size: "100%" }, { titleRight: l(() => o[1] || (o[1] = [])), content: l(() => [O((V(), $(y, { data: x.value, "max-height": e(R), "row-key": "rowId", style: { width: "100%" } }, { default: l(() => {
      var d;
      return [n(a, { label: "序号", type: "index", align: "center", width: "60" }), n(e(oe), { showProject: "", showMonomer: "", showArea: "", fixedWidth: "" }), n(e(ne), { productType: (d = s.info) == null ? void 0 : d.productType, unShowField: ["material"] }, null, 8, ["productType"]), n(a, { prop: "mete", "show-overflow-tooltip": true, label: `${c.value.label}(${c.value.unit})`, align: "center", width: "100px" }, { default: l((p) => [A(q(p.row.mete), 1)]), _: 1 }, 8, ["label"]), n(a, { key: "taskQuantity", prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务总数", align: "center", width: "100px" }, { default: l((p) => [z("span", null, q(p.row.taskQuantity), 1)]), _: 1 }), n(a, { prop: "processSequence", "show-overflow-tooltip": true, label: "【工序 │ 完成数】", "min-width": "400px" }, { default: l((p) => [z("span", { innerHTML: p.row.processSequence }, null, 8, ie)]), _: 1 })];
    }), _: 1 }, 8, ["data", "max-height"])), [[_, g.value]]), n(w, { total: e(Q), "current-page": e(f).pageNumber, "page-size": e(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: e(P), onCurrentChange: e(B) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  ce as default
};
