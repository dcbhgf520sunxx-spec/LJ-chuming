import { ref as V } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as b } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as t } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as f } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as q } from "vue";
import { createElementVNode as j } from "vue";
import { createElementBlock as z } from "vue";
import { Fragment as L } from "vue";
import { renderList as A } from "vue";
import { isRef as F } from "vue";
import { ElTag as H } from "element-plus";
import { ElTableColumn as P } from "element-plus";
import { n as M, o as G } from "../../../modules/purchase-data-analysis-1b2dc5a0.js";
import { u as U, G as k, o as W, p as $, L as J, aN as K, bv as Q, jP as v, b as X } from "../../../shared/runtime.js";
const ae = { __name: "supplier-analysis-detail", props: { visible: { type: Boolean, default: false }, branchInfo: { type: Object, default: () => {
} }, query: { type: Object, default: () => {
} }, chartObj: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(d, { emit: B }) {
  const x = V(), y = V([]), O = B, m = d, { visible: w, handleClose: S } = U({ emit: O, props: m, field: "visible", showHook: D });
  async function D() {
    var o, s;
    if (!k((o = m.permission) == null ? void 0 : o.detail)) return false;
    let u = [];
    try {
      u = await M({ ...m.query, supplierId: (s = m.chartObj) == null ? void 0 : s.supplierId }) || [];
    } catch (a) {
      console.log("获取供应商统计详情失败", a);
    } finally {
      y.value = u;
    }
  }
  const { maxHeight: I } = W({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], paginate: false }, () => x.value.loaded);
  function E(u) {
    const { columns: o, data: s } = u, a = [];
    return o.forEach((g, c) => {
      var e, r;
      if (c === 0) {
        a[c] = "合计";
        return;
      }
      if (g.property === "amount") {
        const p = (e = s == null ? void 0 : s.filter((n) => !n.basicClass)) == null ? void 0 : e.map((n) => n.amount);
        p.every((n) => isNaN(n)) || (a[c] = p.reduce((n, C) => {
          const T = Number(C);
          return isNaN(T) ? n : n + C;
        }, 0)), a[c] = (r = a[c]) == null ? void 0 : r.toFixed(2);
      }
    }), a;
  }
  function R({ row: u, rowIndex: o }) {
    if (X(u.basicClass)) return { fontWeight: "bold", fontSize: "18px" };
  }
  return (u, o) => {
    const s = H, a = P, g = N("common-table"), c = N("common-drawer");
    return b(), _(c, { ref_key: "drawerRef", ref: x, title: "供应商交易记录", modelValue: l(w), "onUpdate:modelValue": o[0] || (o[0] = (e) => F(w) ? w.value = e : null), direction: "rtl", "before-close": l(S), size: "60%" }, { titleAfter: t(() => [i(s, { effect: "plain", size: "large", class: "filter-item" }, { default: t(() => [h(" 统计年度： " + f(l($)(d.query.yearDate, "{y}") || "-"), 1)]), _: 1 }), i(s, { effect: "plain", type: "danger", size: "large", class: "filter-item" }, { default: t(() => {
      var e;
      return [h(" 供应商： " + f(((e = d.chartObj) == null ? void 0 : e.name) || "-"), 1)];
    }), _: 1 })]), titleRight: t(() => {
      var e, r, p;
      return [l(k)((e = d.permission) == null ? void 0 : e.download) ? (b(), _(J, { key: 0, fn: l(G), params: { ...m.query, supplierId: (r = m.chartObj) == null ? void 0 : r.supplierId }, disabled: !((p = y.value) != null && p.length) }, { default: t(() => o[1] || (o[1] = [h(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : q("", true)];
    }), content: t(() => [i(g, { ref: "tableRef", data: y.value, "max-height": l(I), "row-style": R, "show-empty-symbol": false, style: { width: "100%" }, "show-summary": "", "summary-method": E }, { default: t(() => [i(a, { "show-overflow-tooltip": true, prop: "index", label: "创建日期", align: "center", width: "100" }, { default: t(({ row: e }) => [j("span", null, f(e.index), 1)]), _: 1 }), i(a, { "show-overflow-tooltip": true, prop: "purchaseSn", label: "采购订单号", align: "center" }), i(a, { "show-overflow-tooltip": true, prop: "branchCompanyName", label: "签订主体", align: "center" }), i(a, { "show-overflow-tooltip": true, prop: "basicClass", label: "类别", align: "center" }, { default: t((e) => [(b(true), z(L, null, A(l(K)(l(Q).getBits(l(v), e.row.basicClass, "V")), (r) => (b(), _(s, { style: { "margin-right": "5px" }, key: r, type: l(v).V[r].T, effect: "light", "disable-transitions": "" }, { default: t(() => [h(f(l(v).VL[r]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), i(a, { "show-overflow-tooltip": true, prop: "amount", label: "入库额（元）", align: "center" }, { default: t(({ row: e }) => [j("span", null, f(e.amount ? e.amount : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ae as default
};
