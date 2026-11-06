import { ref as M } from "vue";
import { watch as j } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as C } from "vue";
import { createBlock as D } from "vue";
import { withCtx as n } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as d } from "vue";
import { unref as f } from "vue";
import { createCommentVNode as L } from "vue";
import { createElementVNode as b } from "vue";
import { isRef as O } from "vue";
import { ElTag as S } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { dS as A, u as G, G as V, i as k, o as U, p as P, L as W, c as N } from "../../../shared/runtime.js";
import { g as $, a as J } from "../../../modules/production-performance-dashboard-bb1cff92.js";
const Y = { __name: "average-loss-rate-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object, defaul: () => {
} }, workshopId: { type: Number }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(y, { emit: B }) {
  const { workshops: q } = A(), w = M([]), g = M(""), I = M(0), R = B, m = y, { visible: v, handleClose: z } = G({ emit: R, props: m, field: "visible", showHook: H });
  j(() => m.visible, (p) => {
    var s, a;
    p && (g.value = (a = (s = q.value) == null ? void 0 : s.find((o) => o.id === m.workshopId)) == null ? void 0 : a.name);
  }, { immediate: true });
  async function H() {
    var s;
    if (!V((s = m.permission) == null ? void 0 : s.detail)) return false;
    let p = [];
    try {
      const a = await $({ branchCompanyId: m.query.branchCompanyId, workshopId: m.workshopId, yearDate: m.query.yearDate });
      p = a || [];
      const o = a == null ? void 0 : a.reduce((t, e) => k(e == null ? void 0 : e.sellMete) ? t + (e == null ? void 0 : e.sellMete) : t, 0), u = a == null ? void 0 : a.reduce((t, e) => k(e == null ? void 0 : e.mete) ? t + (e == null ? void 0 : e.mete) : t, 0), l = a == null ? void 0 : a.reduce((t, e) => k(e == null ? void 0 : e.outMete) ? t + (e == null ? void 0 : e.outMete) : t, 0);
      I.value = l ? ((l - u - o) / l * 100).toFixed(2) + "%" : "0%";
    } catch (a) {
      console.log("获取月度平均损耗率详情失败", a);
    } finally {
      w.value = p;
    }
  }
  const { maxHeight: F } = U({ mainBox: ".common-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, extraHeight: 100, paginate: false });
  function T(p) {
    const { columns: s, data: a } = p, o = [];
    return s.forEach((u, l) => {
      var t;
      if (l === 0) {
        o[l] = "合计";
        return;
      }
      if (u.property === "sellMete") {
        const e = a.map((r) => Number(r[u.property]));
        e.every((r) => isNaN(r)) || (o[l] = e.reduce((r, h) => {
          const _ = Number(h);
          return isNaN(_) ? r : r + h;
        }, 0)), o[l] = (t = o[l]) == null ? void 0 : t.toFixed(0);
      }
      if (u.property === "mete" || u.property === "outMete") {
        const e = a.map((r) => Number(r[u.property]));
        e.every((r) => isNaN(r)) || (o[l] = e.reduce((r, h) => {
          const _ = Number(h);
          return isNaN(_) ? r : r + h;
        }, 0)), o[l] = N(o[l], "kg", "t", 0);
      }
    }), o;
  }
  return (p, s) => {
    const a = S, o = E, u = x("common-table"), l = x("common-drawer");
    return C(), D(l, { ref: "drawerRef", "destroy-on-close": "", title: "主材损耗统计详情", modelValue: f(v), "onUpdate:modelValue": s[0] || (s[0] = (t) => O(v) ? v.value = t : null), direction: "rtl", "before-close": f(z), size: "65%" }, { titleAfter: n(() => [i(a, { type: "danger", size: "default" }, { default: n(() => {
      var t, e;
      return [c(" 二级单位： " + d((t = y.branchInfo) != null && t.name ? (e = y.branchInfo) == null ? void 0 : e.name : "全部分支机构"), 1)];
    }), _: 1 }), i(a, { size: "default" }, { default: n(() => [c(" 车间： " + d(g.value ? g.value : "全部车间"), 1)]), _: 1 }), i(a, { type: "success", size: "default" }, { default: n(() => [c(" 年份: " + d(y.query.yearDate ? f(P)(y.query.yearDate, "{y}") : "-"), 1)]), _: 1 }), i(a, { type: "warning", size: "default" }, { default: n(() => s[1] || (s[1] = [c(" 单位: 吨 ")])), _: 1, __: [1] }), i(a, { type: "info", size: "default" }, { default: n(() => [c("平均损耗率: " + d(I.value), 1)]), _: 1 })]), titleRight: n(() => {
      var t, e;
      return [f(V)((t = y.permission) == null ? void 0 : t.download) ? (C(), D(W, { key: 0, fn: f(J), params: { branchCompanyId: m.query.branchCompanyId, workshopId: m.workshopId, yearDate: m.query.yearDate }, disabled: !((e = w.value) != null && e.length) }, { default: n(() => s[2] || (s[2] = [c(" 下载 ")])), _: 1, __: [2] }, 8, ["fn", "params", "disabled"])) : L("", true)];
    }), content: n(() => [i(u, { ref: "tableRef", data: w.value, "show-empty-symbol": false, "max-height": f(F), style: { width: "100%" }, "show-summary": "", "summary-method": T }, { default: n(() => [i(o, { "show-overflow-tooltip": true, prop: "dateTime", label: "日期", align: "center", width: "100" }), i(o, { "show-overflow-tooltip": true, prop: "outMete", label: "钢材领用（吨）", align: "center" }, { default: n(({ row: t }) => [b("span", null, d(t.outMete ? f(N)(t.outMete, "kg", "t", 0) : 0), 1)]), _: 1 }), i(o, { "show-overflow-tooltip": true, prop: "mete", label: "制成品出库（吨）", align: "center" }, { default: n(({ row: t }) => [b("span", null, d(t.mete ? f(N)(t.mete, "kg", "t", 0) : 0), 1)]), _: 1 }), i(o, { "show-overflow-tooltip": true, prop: "sellMete", label: "废料出售（吨）", align: "center" }, { default: n(({ row: t }) => {
      var e;
      return [b("span", null, d(t.sellMete ? (e = t.sellMete) == null ? void 0 : e.toFixed(0) : 0), 1)];
    }), _: 1 }), i(o, { "show-overflow-tooltip": true, prop: "lossMete", label: "损耗（吨）", align: "center" }, { default: n(({ row: t }) => {
      var e;
      return [b("span", null, d(t.lossMete ? (e = t.lossMete) == null ? void 0 : e.toFixed(0) : 0), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Y as default
};
