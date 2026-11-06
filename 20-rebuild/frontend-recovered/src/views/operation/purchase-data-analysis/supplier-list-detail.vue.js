import { ref as v } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as c } from "vue";
import { createBlock as y } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as d } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as R } from "vue";
import { createElementBlock as I } from "vue";
import { Fragment as O } from "vue";
import { renderList as S } from "vue";
import { createElementVNode as V } from "vue";
import { isRef as A } from "vue";
import { ElTag as H } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { l as P, m as z } from "../../../modules/purchase-data-analysis-1b2dc5a0.js";
import { u as F, G as C, o as G, p as T, L as M, aN as U, bv as Y, jP as h } from "../../../shared/runtime.js";
const Q = { __name: "supplier-list-detail", props: { visible: { type: Boolean, default: false }, branchInfo: { type: Object, default: () => {
} }, query: { type: Object }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(s, { emit: k }) {
  const w = v(), m = v([]), D = k, p = s, { visible: u, handleClose: B } = F({ emit: D, props: p, field: "visible", showHook: N });
  async function N() {
    var l;
    if (!C((l = p.permission) == null ? void 0 : l.detail)) return false;
    let f = [];
    try {
      f = await P({ ...p.query }) || [];
    } catch (i) {
      console.log("获取供应商统计详情失败", i);
    } finally {
      m.value = f;
    }
  }
  const { maxHeight: j } = G({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], paginate: false }, () => w.value.loaded);
  return (f, l) => {
    const i = H, n = L, q = x("common-table"), E = x("common-drawer");
    return c(), y(E, { ref_key: "drawerRef", ref: w, title: "供应商统计", modelValue: e(u), "onUpdate:modelValue": l[0] || (l[0] = (a) => A(u) ? u.value = a : null), direction: "rtl", "before-close": e(B), size: "60%" }, { titleAfter: t(() => [o(i, { effect: "plain", size: "large", class: "filter-item" }, { default: t(() => [b(" 统计年度： " + d(e(T)(s.query.yearDate, "{y}") || "-"), 1)]), _: 1 })]), titleRight: t(() => {
      var a, r, _, g;
      return [e(C)((a = s.permission) == null ? void 0 : a.download) ? (c(), y(M, { key: 0, fn: e(z), params: { yearDate: (r = s.query) == null ? void 0 : r.yearDate, branchCompanyId: (_ = s.query) == null ? void 0 : _.branchCompanyId }, disabled: !((g = m.value) != null && g.length) }, { default: t(() => l[1] || (l[1] = [b(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : R("", true)];
    }), content: t(() => [o(q, { ref: "tableRef", data: m.value, "max-height": e(j), "show-empty-symbol": false, style: { width: "100%" } }, { default: t(() => [o(n, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), o(n, { "show-overflow-tooltip": true, prop: "materialType", label: "类别", align: "center" }, { default: t((a) => [(c(true), I(O, null, S(e(U)(e(Y).getBits(e(h), a.row.materialType, "V")), (r) => (c(), y(i, { style: { "margin-right": "5px" }, key: r, type: e(h).V[r].T, effect: "light", "disable-transitions": "" }, { default: t(() => [b(d(e(h).VL[r]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), o(n, { "show-overflow-tooltip": true, prop: "supplierName", label: "供应商", align: "center" }), o(n, { "show-overflow-tooltip": true, prop: "socialCode", label: "社会信用统一代码", align: "center" }, { default: t(({ row: a }) => [V("span", null, d(a.socialCode || "-"), 1)]), _: 1 }), o(n, { "show-overflow-tooltip": true, prop: "createTime", label: "登记日期", align: "center" }, { default: t(({ row: a }) => [V("span", null, d(a.createTime ? e(T)(a.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Q as default
};
