import { ref as T } from "vue";
import { watch as q } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as z } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as W } from "vue";
import { createVNode as a } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as c } from "vue";
import { unref as t } from "vue";
import { Fragment as A } from "vue";
import { renderList as G } from "vue";
import { createBlock as J } from "vue";
import { normalizeClass as K } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { ElPagination as Y } from "element-plus";
import { e as Z, f as $ } from "../../../../../modules/detail-fee-ef8adaab.js";
import { _ as ee, J as te, t as ae, o as oe, c as C, D as P, bV as re, bx as le, aN as se, bv as ne, bi as S, bB as D, bs as F } from "../../../../../shared/runtime.js";
const ie = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, ce = { style: { width: "300px" } }, pe = { __name: "shipping-fee", props: { costTypeData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(y) {
  const { handleSizeChange: I, handleCurrentChange: B, total: O, setTotalPage: L, queryPage: f } = te({ fetchHook: V }), { decimalPrecision: d } = ae(), b = y, R = T(), E = T([]), w = T(), { maxHeight: H } = oe({ paginate: true });
  q(() => b.costTypeData.projectId, (l) => {
    V(), U();
  }, { immediate: true, deep: true });
  function M(l) {
    const { columns: g, data: h } = l, n = [];
    return g.forEach((o, p) => {
      var _;
      if (p === 0) {
        n[p] = "合计";
        return;
      }
      if (o.property === "actualWeight") {
        const u = h.map((r) => C(r.actualWeight, "kg", "t", P.COM_WT__T));
        u.every((r) => isNaN(r)) || (n[p] = u.reduce((r, m) => {
          const e = Number(m);
          return isNaN(e) ? r : r + m;
        }, 0));
      }
      if (o.property === "totalPrice") {
        const u = h.map((r) => r.totalPrice);
        u.every((r) => isNaN(r)) || (n[p] = u.reduce((r, m) => {
          const e = Number(m);
          return isNaN(e) ? r : r + m;
        }, 0)), n[p] = (_ = n[p]) == null ? void 0 : _.toFixed(d.value.contract);
      }
    }), n;
  }
  async function U() {
    try {
      const l = await Z(b.costTypeData.projectId);
      w.value = l || {};
    } catch (l) {
      console.log("运输汇总", l);
    }
  }
  async function V() {
    try {
      const { content: l, totalElements: g } = await $({ projectId: b.costTypeData.projectId, ...f });
      E.value = l || [], L(g);
    } catch (l) {
      console.log("运输费用", l);
    }
  }
  return (l, g) => {
    const h = N("print-table"), n = Q, o = X, p = N("table-cell-tag"), _ = N("common-table"), u = Y, r = j("permission"), m = j("parse-time");
    return k(), z("div", null, [i("div", ie, [i("div", ce, [W(a(h, { "api-key": "shippingFeeList", params: y.costTypeData.projectId, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[r, y.permission.print]])]), i("div", null, [a(n, { style: { "margin-right": "8px" } }, { default: s(() => {
      var e;
      return [x(" 装载重量合计（单位:t）： " + c(t(C)((e = w.value) == null ? void 0 : e.actualWeight, "kg", "t", t(P).COM_WT__T)), 1)];
    }), _: 1 }), a(n, { type: "danger" }, { default: s(() => {
      var e;
      return [x("运输费合计（单位:元）：" + c(t(re)((e = w.value) == null ? void 0 : e.totalPrice, t(d).contract)), 1)];
    }), _: 1 })])]), a(_, { ref_key: "tableRef", ref: R, data: E.value, "empty-text": "暂无数据", "max-height": t(H), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": M }, { default: s(() => [a(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(o, { key: "serialNumber", prop: "serialNumber", sortable: "custom", label: "车次/船次", align: "center" }, { default: s((e) => [a(p, { show: e.row.deliveryStatus === t(le).RETURN.V, name: "已取消", color: "#f56c6c" }, null, 8, ["show"]), i("span", null, c(e.row.serialNumber), 1)]), _: 1 }), a(o, { key: "auditTime", prop: "auditTime", sortable: "custom", label: "承运日期", width: "120" }, { default: s((e) => [W(i("span", null, null, 512), [[m, { val: e.row.auditTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), a(o, { key: "productType", prop: "productType", label: "装载类型", width: "100" }, { default: s((e) => [(k(true), z(A, null, G(t(se)(t(ne).getBits(t(S), e.row.productType, "V")), (v) => (k(), J(n, { style: { "margin-right": "5px" }, key: v, type: t(S).V[v].T, effect: "light", "disable-transitions": "" }, { default: s(() => [x(c(t(S).VL[v]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), a(o, { key: "licensePlate", prop: "licensePlate", sortable: "custom", "show-overflow-tooltip": true, label: "车牌/船牌号", align: "center" }), a(o, { key: "driverName", prop: "driverName", sortable: "custom", "show-overflow-tooltip": true, label: "司机姓名", align: "center" }), a(o, { key: "driverPhone", prop: "driverPhone", "show-overflow-tooltip": true, label: "司机电话", align: "center", width: "140" }), a(o, { key: "auditUserName", prop: "auditUserName", sortable: "custom", "show-overflow-tooltip": true, label: "办理人", align: "center" }), a(o, { "show-overflow-tooltip": true, prop: "actualWeight", label: "装载重量(t)", align: "center" }, { default: s((e) => [i("span", null, c(t(C)(e.row.actualWeight, "kg", "t", t(P).COM_WT__T)), 1)]), _: 1 }), a(o, { prop: "priceType", label: "计价方式", align: "center" }, { default: s((e) => [i("span", null, c(t(D).VL[e.row.priceType]), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, prop: "price", label: "运输单价", align: "right", "min-width": "120" }, { default: s((e) => [i("span", null, c(t(F)(e.row.price, t(d).contract)), 1), i("span", { class: K(e.row.priceType === t(D).WEIGHT.V ? "blue" : "orange"), style: { "margin-left": "3px" } }, c(t(D).V[e.row.priceType].unit), 3)]), _: 1 }), a(o, { "show-overflow-tooltip": true, prop: "totalPrice", label: "运输费(元)", align: "right", "min-width": "120" }, { default: s((e) => [i("span", null, c(t(F)(e.row.totalPrice, t(d).contract)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), a(u, { total: t(O), "current-page": t(f).pageNumber, "page-size": t(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(I), onCurrentChange: t(B) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]);
  };
} }, ge = ee(pe, [["__scopeId", "data-v-a54c0f4c"]]);
export {
  ge as default
};
