import { ref as v } from "vue";
import { nextTick as z } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as h } from "vue";
import { createBlock as T } from "vue";
import { withCtx as n } from "vue";
import { createVNode as m } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as p } from "vue";
import { unref as o } from "vue";
import { createCommentVNode as A } from "vue";
import { createElementVNode as V } from "vue";
import { createElementBlock as F } from "vue";
import { Fragment as L } from "vue";
import { renderList as G } from "vue";
import { isRef as Y } from "vue";
import { ElTag as $ } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { b as U, c as W, d as J } from "../../../modules/purchase-data-analysis-1b2dc5a0.js";
import { u as K, p as Q, G as j, o as X, L as Z, i as C, aN as ee, bv as ae, jP as _, b as te } from "../../../shared/runtime.js";
const ne = { __name: "purchase-order-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object, default: () => {
} }, branchInfo: { type: Object, default: () => {
} }, chartObj: { type: Object, default: () => {
} }, showType: { type: [Number, String], default: void 0 }, dateType: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(d, { emit: B }) {
  const x = v(), y = v([]), O = B, D = v(), a = d, { visible: w, handleClose: S } = K({ emit: O, props: a, field: "visible", showHook: q });
  function q() {
    var s;
    console.log(a.chartObj, a.query, "showHook"), D.value = a.dateType === 1 ? Q(a.query.yearDate, "{y}") : (s = a.chartObj) == null ? void 0 : s.name, z(() => {
      I();
    });
  }
  async function I() {
    var i, u;
    if (!j((i = a.permission) == null ? void 0 : i.detail)) return false;
    let s = [];
    try {
      s = (a.dateType === 1 ? await U({ ...a.query }) : await W({ ...a.query, yearDate: new Date((u = a.chartObj) == null ? void 0 : u.name).getTime() })) || [];
    } catch (t) {
      console.log("获取月度采购订单详情失败", t);
    } finally {
      y.value = s, console.log(y.value, "monthlyData.value");
    }
  }
  const { maxHeight: E } = X({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], paginate: false }, () => x.value.loaded);
  function P(s) {
    const { columns: i, data: u } = s, t = [];
    return i.forEach((g, c) => {
      var e, l;
      if (c === 0) {
        t[c] = "合计";
        return;
      }
      if (g.property === "amount") {
        const f = (e = u == null ? void 0 : u.filter((r) => !r.materialType)) == null ? void 0 : e.map((r) => r.amount);
        f.every((r) => isNaN(r)) || (t[c] = f.reduce((r, k) => {
          const H = Number(k);
          return isNaN(H) ? r : r + k;
        }, 0)), t[c] = (l = t[c]) == null ? void 0 : l.toFixed(2);
      }
    }), t;
  }
  function R({ row: s, rowIndex: i }) {
    if (te(s.materialType)) return { fontWeight: "bold", fontSize: "18px" };
  }
  return (s, i) => {
    const u = $, t = M, g = N("common-table"), c = N("common-drawer");
    return h(), T(c, { ref_key: "drawerRef", ref: x, title: `${d.dateType === 1 ? "全年" : "月度"}采购订单创建记录`, modelValue: o(w), "onUpdate:modelValue": i[0] || (i[0] = (e) => Y(w) ? w.value = e : null), direction: "rtl", "before-close": o(S), size: "60%" }, { titleAfter: n(() => [m(u, { type: "primary", size: "default", class: "filter-item" }, { default: n(() => {
      var e, l;
      return [b(" 单位： " + p((e = d.branchInfo) != null && e.name ? (l = d.branchInfo) == null ? void 0 : l.name : "全部分支机构"), 1)];
    }), _: 1 }), m(u, { type: "danger", size: "default", class: "filter-item" }, { default: n(() => [b(" 统计日期：" + p(D.value), 1)]), _: 1 })]), titleRight: n(() => {
      var e, l, f, r;
      return [o(j)((e = d.permission) == null ? void 0 : e.download) ? (h(), T(Z, { key: 0, fn: o(J), params: { yearDate: a.dateType === 1 ? a.query.yearDate : new Date((l = d.chartObj) == null ? void 0 : l.name).getTime(), branchCompanyId: (f = d.query) == null ? void 0 : f.branchCompanyId, yearGroup: a.dateType === 1 }, disabled: !((r = y.value) != null && r.length) }, { default: n(() => i[1] || (i[1] = [b(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : A("", true)];
    }), content: n(() => [m(g, { ref: "tableRef", data: y.value, "max-height": o(E) + 50, "show-empty-symbol": false, style: { width: "100%" }, "row-style": R, "show-summary": "", "summary-method": P }, { default: n(() => [m(t, { "show-overflow-tooltip": true, prop: "index", label: "日期", align: "center", width: "100" }, { default: n(({ row: e }) => [V("span", null, p(o(C)(e.index) ? e.index : e.dateTime), 1)]), _: 1 }), m(t, { "show-overflow-tooltip": true, prop: "materialType", label: "类型", align: "center" }, { default: n((e) => [(h(true), F(L, null, G(o(ee)(o(ae).getBits(o(_), e.row.materialType, "V")), (l) => (h(), T(u, { style: { "margin-right": "5px" }, key: l, type: o(_).V[l].T, effect: "light", "disable-transitions": "" }, { default: n(() => [b(p(o(_).VL[l]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), m(t, { "show-overflow-tooltip": true, prop: "supplierName", label: "供应商", align: "center" }), m(t, { "show-overflow-tooltip": true, prop: "amount", label: "合同金额（元）", align: "center", "min-width": "120" }), m(t, { "show-overflow-tooltip": true, prop: "dateTime", label: "创建日期", align: "center" }, { default: n(({ row: e }) => [V("span", null, p(o(C)(e.index) ? e.dateTime : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  ne as default
};
