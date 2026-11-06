import { ref as M } from "vue";
import { watch as j } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as x } from "vue";
import { createBlock as C } from "vue";
import { withCtx as n } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as u } from "vue";
import { unref as f } from "vue";
import { createCommentVNode as L } from "vue";
import { createElementVNode as b } from "vue";
import { isRef as O } from "vue";
import { ElTag as q } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { dS as A, u as G, G as V, i as N, o as U, p as P, L as W, c as k } from "../../../shared/runtime.js";
import { g as $, a as J } from "../../../modules/production-performance-dashboard-bb1cff92.js";
const Y = { __name: "material-loss-analysis-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object, defaul: () => {
} }, workshopId: { type: Number }, searchDate: { type: [Number, String] }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(c, { emit: B }) {
  const { workshops: R } = A(), w = M([]), g = M(""), I = M(0), z = B, m = c, { visible: v, handleClose: H } = G({ emit: z, props: m, field: "visible", showHook: F });
  j(() => m.visible, (p) => {
    var s, a;
    p && (g.value = (a = (s = R.value) == null ? void 0 : s.find((o) => o.id === m.workshopId)) == null ? void 0 : a.name);
  }, { immediate: true });
  async function F() {
    var s;
    if (!V((s = m.permission) == null ? void 0 : s.detail)) return false;
    let p = [];
    try {
      const a = await $({ branchCompanyId: m.query.branchCompanyId, workshopId: m.workshopId, yearDate: m.searchDate });
      p = a || [];
      const o = a == null ? void 0 : a.reduce((t, e) => N(e == null ? void 0 : e.sellMete) ? t + (e == null ? void 0 : e.sellMete) : t, 0), d = a == null ? void 0 : a.reduce((t, e) => N(e == null ? void 0 : e.mete) ? t + (e == null ? void 0 : e.mete) : t, 0), l = a == null ? void 0 : a.reduce((t, e) => N(e == null ? void 0 : e.outMete) ? t + (e == null ? void 0 : e.outMete) : t, 0);
      I.value = l ? ((l - d - o * 1000) / l * 100).toFixed(2) + "%" : "0%";
    } catch (a) {
      console.log("获取月度平均损耗率详情失败", a);
    } finally {
      w.value = p;
    }
  }
  const { maxHeight: S } = U({ mainBox: ".common-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, extraHeight: 100, paginate: false });
  function T(p) {
    const { columns: s, data: a } = p, o = [];
    return s.forEach((d, l) => {
      var t;
      if (l === 0) {
        o[l] = "合计";
        return;
      }
      if (d.property === "sellMete") {
        const e = a.map((r) => Number(r[d.property]));
        e.every((r) => isNaN(r)) || (o[l] = e.reduce((r, y) => {
          const _ = Number(y);
          return isNaN(_) ? r : r + y;
        }, 0)), o[l] = (t = o[l]) == null ? void 0 : t.toFixed(0);
      }
      if (d.property === "mete" || d.property === "outMete") {
        const e = a.map((r) => Number(r[d.property]));
        e.every((r) => isNaN(r)) || (o[l] = e.reduce((r, y) => {
          const _ = Number(y);
          return isNaN(_) ? r : r + y;
        }, 0)), o[l] = k(o[l], "kg", "t", 0);
      }
    }), o;
  }
  return (p, s) => {
    const a = q, o = E, d = D("common-table"), l = D("common-drawer");
    return x(), C(l, { ref: "drawerRef", "destroy-on-close": "", title: "主材损耗统计详情", modelValue: f(v), "onUpdate:modelValue": s[0] || (s[0] = (t) => O(v) ? v.value = t : null), direction: "rtl", "before-close": f(H), size: "65%" }, { titleAfter: n(() => [i(a, { type: "danger", size: "default" }, { default: n(() => {
      var t, e;
      return [h(" 二级单位： " + u((t = c.branchInfo) != null && t.name ? (e = c.branchInfo) == null ? void 0 : e.name : "全部分支机构"), 1)];
    }), _: 1 }), i(a, { size: "default" }, { default: n(() => [h(" 车间： " + u(g.value ? g.value : "全部车间"), 1)]), _: 1 }), i(a, { type: "success", size: "default" }, { default: n(() => [h(" 年份: " + u(c.searchDate ? f(P)(c.searchDate, "{y}") : "-"), 1)]), _: 1 }), i(a, { type: "warning", size: "default" }, { default: n(() => s[1] || (s[1] = [h(" 单位: 吨 ")])), _: 1, __: [1] }), i(a, { type: "info", size: "default" }, { default: n(() => [h("平均损耗率: " + u(I.value), 1)]), _: 1 })]), titleRight: n(() => {
      var t, e;
      return [f(V)((t = c.permission) == null ? void 0 : t.download) ? (x(), C(W, { key: 0, fn: f(J), params: { branchCompanyId: m.query.branchCompanyId, workshopId: m.workshopId, yearDate: m.searchDate }, disabled: !((e = w.value) != null && e.length) }, { default: n(() => s[2] || (s[2] = [h(" 下载 ")])), _: 1, __: [2] }, 8, ["fn", "params", "disabled"])) : L("", true)];
    }), content: n(() => [i(d, { ref: "tableRef", data: w.value, "show-empty-symbol": false, "max-height": f(S), style: { width: "100%" }, "show-summary": "", "summary-method": T }, { default: n(() => [i(o, { "show-overflow-tooltip": true, prop: "dateTime", label: "日期", align: "center", width: "100" }), i(o, { "show-overflow-tooltip": true, prop: "outMete", label: "钢材领用（吨）", align: "center" }, { default: n(({ row: t }) => [b("span", null, u(t.outMete ? f(k)(t.outMete, "kg", "t", 0) : 0), 1)]), _: 1 }), i(o, { "show-overflow-tooltip": true, prop: "mete", label: "制成品出库（吨）", align: "center" }, { default: n(({ row: t }) => [b("span", null, u(t.mete ? f(k)(t.mete, "kg", "t", 0) : 0), 1)]), _: 1 }), i(o, { "show-overflow-tooltip": true, prop: "sellMete", label: "废料出售（吨）", align: "center" }, { default: n(({ row: t }) => {
      var e;
      return [b("span", null, u(t.sellMete ? (e = t.sellMete) == null ? void 0 : e.toFixed(0) : 0), 1)];
    }), _: 1 }), i(o, { "show-overflow-tooltip": true, prop: "lossMete", label: "损耗（吨）", align: "center" }, { default: n(({ row: t }) => {
      var e;
      return [b("span", null, u(t.lossMete ? (e = t.lossMete) == null ? void 0 : e.toFixed(0) : 0), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Y as default
};
