import { ref as h } from "vue";
import { watch as K } from "vue";
import { resolveComponent as E } from "vue";
import { withDirectives as T } from "vue";
import { vShow as M } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as o } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as V } from "vue";
import { withKeys as H } from "vue";
import { createBlock as A } from "vue";
import { toDisplayString as S } from "vue";
import { unref as n } from "vue";
import { ElTag as $ } from "element-plus";
import { ElInput as J } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { ElPagination as G } from "element-plus";
import { vLoading as W } from "element-plus";
import { s as X } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { o as Y, J as Z, on as ee, c as L, D as te } from "../../../../../../shared/runtime.js";
import ae from "./package-detail-drawer.vue.js";
const oe = { style: { "margin-top": "20px" } }, le = { class: "head-container" }, se = ["onClick"], pe = { __name: "ship-list", props: { modelValue: { type: Boolean, default: false }, showType: { type: String }, query: { type: Object }, workshopId: { type: Number }, projectId: { type: Number }, weightStatus: { type: Number }, permission: { type: Object, default: () => {
} } }, setup(C, { expose: I }) {
  const j = { TRUE: { L: "已发运", K: "TRUE", V: true, COLOR: "" }, FALSE: { L: "未发运", K: "FALSE", V: false, COLOR: "" } }, q = h([["createTime", ["parse-time", "{y}-{m}-{d}"]]]), l = C, y = h([]), v = h(false), p = h({}), _ = h(false), k = h({}), { maxHeight: z } = Y({ extraBox: [".head-container"], wrapperBox: [".detail-container"], paginate: true }), { handleSizeChange: B, handleCurrentChange: D, total: O, setTotalPage: U, queryPage: w } = Z({ fetchHook: c });
  K(() => l.showType, (r) => {
    r && (p.value = {}, c());
  }, { immediate: true, deep: true });
  async function c() {
    if (y.value = [], !!l.showType) {
      v.value = true;
      try {
        const { content: r = [], totalElements: a } = await X({ projectId: l.projectId, ...l.query, workshopId: l.workshopId, shipEnumType: ee[l.showType].V, ...p.value, ...w });
        y.value = r, U(a), v.value = false;
      } catch (r) {
        console.log("获取详情失败", r), v.value = false;
      }
    }
  }
  function P(r) {
    const { columns: a, data: g } = r, m = [];
    return a.forEach((d, s) => {
      if (s === 0) {
        m[s] = "合计";
        return;
      }
      if (d.property === "quantity") {
        const i = g.map((t) => Number(t[d.property]));
        let u = 0;
        i.every((t) => isNaN(t)) || (u = i.reduce((t, e) => {
          const b = Number(e);
          return isNaN(b) ? t : t + e;
        }, 0)), m[s] = u;
      }
      if (d.property === "totalLength") {
        const i = g.map((t) => Number(t[d.property]));
        let u = 0;
        i.every((t) => isNaN(t)) || (u = i.reduce((t, e) => {
          const b = Number(e);
          return isNaN(b) ? t : t + e;
        }, 0)), m[s] = L(u, "mm", "m", 2);
      }
    }), m;
  }
  function R(r) {
    k.value = r, _.value = true;
  }
  return I({ refresh: c }), (r, a) => {
    const g = $, m = E("common-radio-button"), d = J, s = Q, i = E("common-table"), u = G, t = W;
    return T((x(), F("div", oe, [N("div", le, [o(g, { size: "default", class: "filter-item" }, { default: f(() => a[3] || (a[3] = [V("打包发运")])), _: 1, __: [3] }), o(m, { "show-option-all": "", modelValue: p.value.boolShip, "onUpdate:modelValue": a[0] || (a[0] = (e) => p.value.boolShip = e), options: j, type: "enum", class: "filter-item", onChange: c }, null, 8, ["modelValue"]), o(d, { modelValue: p.value.serialNumber, "onUpdate:modelValue": a[1] || (a[1] = (e) => p.value.serialNumber = e), modelModifiers: { trim: true }, size: "default", placeholder: "输入包单号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: H(c, ["enter"]), onChange: c }, null, 8, ["modelValue"])]), T((x(), A(i, { data: y.value, "show-empty-symbol": false, "data-format": q.value, "show-summary": "", "summary-method": P, "max-height": n(z) - 140 }, { default: f(() => [o(s, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), o(s, { "show-overflow-tooltip": "", prop: "createTime", key: "createTime", label: "打包日期", align: "center" }), o(s, { key: "serialNumber", prop: "serialNumber", label: "包单号", align: "center", "show-overflow-tooltip": true }, { default: f(({ row: e }) => [N("div", { onClick: (b) => R(e), class: "tc-primary", style: { cursor: "pointer" } }, S(e.serialNumber), 9, se)]), _: 1 }), o(s, { key: "quantity", prop: "quantity", label: "包内数量（件）", align: "center", "show-overflow-tooltip": true }), o(s, { prop: "totalLength", label: "总长（m）", align: "center", "show-overflow-tooltip": true }, { default: f(({ row: e }) => [N("span", null, S(n(L)(e.totalLength, "mm", "m", n(te).MES_ENCLOSURE_L__M) || "-"), 1)]), _: 1 }), o(s, { prop: "boolShip", label: "状态", align: "center", "show-overflow-tooltip": true, width: "120" }, { default: f(({ row: e }) => [o(g, { type: e.boolShip ? "success" : "danger", effect: "plain" }, { default: f(() => [V(S(e.boolShip ? "已发运" : "未发运"), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[t, v.value]]), o(u, { total: n(O), "current-page": n(w).pageNumber, "page-size": n(w).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(B), onCurrentChange: n(D) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), o(ae, { visible: _.value, "onUpdate:visible": a[2] || (a[2] = (e) => _.value = e), "detail-data": y.value, query: C.query, packageInfo: k.value, "workshop-id": l.workshopId, "project-id": l.projectId, category: l.category, "weight-status": l.weightStatus }, null, 8, ["visible", "detail-data", "query", "packageInfo", "workshop-id", "project-id", "category", "weight-status"])], 512)), [[M, l.showType]]);
  };
} };
export {
  pe as default
};
