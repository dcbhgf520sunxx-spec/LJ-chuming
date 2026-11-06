import { ref as A } from "vue";
import { computed as _ } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as j } from "vue";
import { createBlock as C } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as x } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as f } from "vue";
import { unref as p } from "vue";
import { vShow as M } from "vue";
import { createCommentVNode as H } from "vue";
import { createElementVNode as h } from "vue";
import { isRef as z } from "vue";
import { ElTag as R } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { l as m, u as I, p as D, G as S, o as L, L as K, z as U, kx as $ } from "../../../../shared/runtime.js";
function te(a) {
  return m({ url: "/api/pc/operational/contract/projectSummary", method: "get", params: a });
}
function ae(a) {
  return m({ url: "/api/pc/operational/contract/groupProjectDTO", method: "get", params: a, cancelKey: false });
}
function G(a) {
  return m({ url: "/api/pc/operational/contract/groupProjectDetail/yearDate", method: "get", params: a });
}
function oe(a) {
  return m({ url: "/api/pc/operational/contract/groupMonthProjectDTO", method: "get", params: a, cancelKey: false });
}
function J(a) {
  return m({ url: "/api/pc/operational/contract/groupProjectMeteDetail/mouthDate", method: "get", params: a });
}
function Q(a) {
  return m({ url: "/api/pc/operational/contract/groupProjectDeepMeteDetail", method: "get", params: a });
}
function W(a) {
  return m({ url: "/api/pc/operational/contract/download/contract/costSummary/detail", method: "get", responseType: "blob", params: a });
}
function X(a) {
  return m({ url: "/api/pc/operational/contract/download/contract/deepMeteSummary/detail", method: "get", responseType: "blob", params: a });
}
const Y = { __name: "order-detail", props: { visible: { type: Boolean, default: false }, showType: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, info: { type: Object, default: () => {
} }, showTitle: { type: String, default: "" }, businessType: { type: Number, default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(a, { emit: V }) {
  const b = A([]), q = V, t = a, { visible: w, handleClose: B } = I({ emit: q, props: t, field: "visible", showHook: O }), F = _(() => t.showType === 2 && t.showTitle === "订单清单量统计" ? X : W), g = _(() => {
    var u, n;
    return t.showType === 2 && t.showTitle === "订单清单量统计" ? { ...t.query, yearDate: new Date((u = t.info) == null ? void 0 : u.name).getTime() } : t.showType === 2 && t.showTitle && t.showTitle !== "订单清单量统计" ? { branchCompanyId: t.query.branchCompanyId, year: false, yearDate: new Date((n = t.info) == null ? void 0 : n.name).getTime() } : { ...t.query, businessType: t.businessType, year: true };
  });
  console.log(g.value, D(g.value.yearDate, "{y}-{m}"));
  async function O() {
    var n, c, o;
    if (!S((n = t.permission) == null ? void 0 : n.detail)) return false;
    let u = [];
    try {
      u = (t.showType === 1 ? await G({ ...t.query, businessType: t.businessType }) : t.showType === 2 && t.showTitle !== "订单清单量统计" ? await J({ ...t.query, yearDate: new Date((c = t.info) == null ? void 0 : c.name).getTime() }) : t.showType === 2 && t.showTitle === "订单清单量统计" ? await Q({ ...t.query, yearDate: new Date((o = t.info) == null ? void 0 : o.name).getTime() }) : []) || [];
    } catch (d) {
      console.log("获取详情失败", d);
    } finally {
      b.value = u;
    }
  }
  const { maxHeight: P } = L({ mainBox: ".order-detail-class", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, extraHeight: 80 }, w);
  function k(u) {
    const { columns: n, data: c } = u, o = [];
    return n.forEach((d, i) => {
      if (i === 0) {
        o[i] = "合计";
        return;
      }
      if (d.property === "contractAmount") {
        const e = c.map((r) => r.contractAmount);
        e.every((r) => isNaN(r)) || (o[i] = e.reduce((r, y) => {
          const T = Number(y);
          return isNaN(T) ? r : r + y;
        }, 0)), o[i] = (o[i] / 1e4).toFixed(0);
      }
      if (d.property === "deepMete") {
        const e = c.map((r) => r.deepMete);
        e.every((r) => isNaN(r)) || (o[i] = e.reduce((r, y) => {
          const T = Number(y);
          return isNaN(T) ? r : r + y;
        }, 0)), o[i] = (o[i] / 1e3).toFixed(0);
      }
    }), o;
  }
  return (u, n) => {
    const c = R, o = E, d = N("common-table"), i = N("common-drawer");
    return j(), C(i, { ref: "drawerRef", title: `${a.showTitle}详情`, modelValue: p(w), "onUpdate:modelValue": n[0] || (n[0] = (e) => z(w) ? w.value = e : null), direction: "rtl", "before-close": p(B), "csutom-class": "order-detail-class", size: "60%" }, { titleAfter: l(() => [x(s(c, { size: "large", effect: "plain" }, { default: l(() => [v(" 年份： " + f(p(D)(a.query.yearDate, "{y}")), 1)]), _: 1 }, 512), [[M, a.showType === 1]]), x(s(c, { size: "large", effect: "plain" }, { default: l(() => {
      var e;
      return [v(" 月份： " + f((e = a.info) == null ? void 0 : e.name), 1)];
    }), _: 1 }, 512), [[M, a.showType !== 1]])]), titleRight: l(() => {
      var e, r;
      return [p(S)((e = a.permission) == null ? void 0 : e.download) ? (j(), C(K, { key: 0, fn: F.value, params: { ...g.value }, disabled: !((r = b.value) != null && r.length) }, { default: l(() => n[1] || (n[1] = [v(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : H("", true)];
    }), content: l(() => [s(d, { ref: "tableRef", data: b.value, "max-height": p(P), style: { width: "100%" }, "show-summary": "", "summary-method": k }, { default: l(() => [s(o, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), s(o, { "show-overflow-tooltip": true, prop: "createTime", label: "立项日期", align: "center" }, { default: l(({ row: e }) => [h("span", null, f(e.createTime ? p(D)(e.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), s(o, { "show-overflow-tooltip": true, prop: "project", label: "项目", align: "center" }, { default: l((e) => [h("span", null, f(p(U)(e.row.project)), 1)]), _: 1 }), s(o, { "show-overflow-tooltip": true, prop: "businessType", label: "订单类型", align: "center" }, { default: l(({ row: e }) => [h("span", null, f(e.businessType ? p($).VL[e.businessType] : "-"), 1)]), _: 1 }), s(o, { "show-overflow-tooltip": true, prop: "customerUnit", label: "发包单位", align: "center" }), s(o, { "show-overflow-tooltip": true, prop: "branchCompanyName", label: "签证主体", align: "center", "min-width": "120" }), s(o, { "show-overflow-tooltip": true, prop: "contractAmount", label: "合同额（万元）", align: "center" }, { default: l(({ row: e }) => [h("span", null, f(e.contractAmount ? (e.contractAmount / 1e4).toFixed(0) : 0), 1)]), _: 1 }), s(o, { "show-overflow-tooltip": true, prop: "deepMete", label: "清单量（吨）", align: "center" }, { default: l(({ row: e }) => [h("span", null, f(e.deepMete ? (e.deepMete / 1e3).toFixed(0) : 0), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, re = Object.freeze(Object.defineProperty({ __proto__: null, default: Y }, Symbol.toStringTag, { value: "Module" }));
export {
  Y as _,
  ae as a,
  oe as b,
  te as g,
  re as o
};
