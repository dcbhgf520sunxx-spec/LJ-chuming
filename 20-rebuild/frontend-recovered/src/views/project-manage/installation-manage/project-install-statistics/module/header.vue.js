import { ref as O } from "vue";
import { watch as D } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as n } from "vue";
import { withCtx as Q } from "vue";
import { createElementVNode as g } from "vue";
import { unref as o } from "vue";
import { withModifiers as I } from "vue";
import { toDisplayString as d } from "vue";
import { ElProgress as $ } from "element-plus";
import { ElDivider as G } from "element-plus";
import { ElCard as H } from "element-plus";
import { l as w, _ as L, m as X, K as E, tQ as M, F as V, B as z, G as S } from "../../../../../shared/runtime.js";
import { v as R } from "../../../../../modules/project-19a12d6b.js";
function K(c) {
  return w({ module: "project", url: "install-report/projectInstall/Details", method: "get", params: c });
}
function U(c) {
  return w({ module: "project", url: "install-report/projectInstall/Summary", method: "get", params: c });
}
const de = { get: K };
const J = { class: "head-container" }, W = { style: { display: "flex" } }, Y = { style: { display: "flex", flex: "1", "justify-content": "space-evenly" } }, Z = { key: 0, class: "title" }, ee = { key: 1, class: "title" }, te = { key: 0, class: "title" }, oe = { key: 1, class: "title" }, ae = { key: 0, class: "title" }, re = { key: 1, class: "title" }, le = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, emits: ["progress-change"], setup(c, { emit: F }) {
  const T = c, { deliveryInstallEnumArr: P } = X("deliveryInstallEnumArr"), e = O({}), q = { projectId: { value: void 0, resetAble: false }, productType: T.globalProject.projectType === E.STEEL.V ? M.ARTIFACT.V : V.BOX.V }, { crud: i, query: p } = z(q), b = F;
  D(() => T.projectId, (a) => {
    a && (i.query.projectId = T.projectId, x());
  }, { immediate: true, deep: true });
  async function x() {
    var a, t, h, u, m, f, v, y, _, r, C, A;
    if (!(!i.query.projectId || !i.query.productType || !S(R.get))) try {
      const k = await U({ projectId: i.query.projectId, productType: i.query.productType });
      e.value = k || {}, e.value.totalRate = (a = e.value) != null && a.taskMete && ((t = e.value) != null && t.mete) ? (((h = e.value) == null ? void 0 : h.mete) / ((u = e.value) == null ? void 0 : u.taskMete) * 100).toFixed(2) : 0, e.value.lastRate = (m = e.value) != null && m.lastMonthMete && ((f = e.value) != null && f.taskMete) ? (((v = e.value) == null ? void 0 : v.lastMonthMete) / ((y = e.value) == null ? void 0 : y.taskMete) * 100).toFixed(2) : 0, e.value.currentRate = (_ = e.value) != null && _.currentMonthMete && ((r = e.value) != null && r.taskMete) ? (((C = e.value) == null ? void 0 : C.currentMonthMete) / ((A = e.value) == null ? void 0 : A.taskMete) * 100).toFixed(2) : 0;
    } catch (k) {
      console.log(k, "获取汇总数据失败");
    }
  }
  function j(a, t) {
    S(R.detail) && b("progress-change", t, a);
  }
  function B() {
    x(), b("progress-change", void 0, {}), i.toQuery();
  }
  return (a, t) => {
    const h = N("common-radio-button"), u = $, m = G, f = H;
    return l(), s("div", J, [n(f, null, { default: Q(() => {
      var v, y, _;
      return [g("div", W, [n(h, { modelValue: o(p).productType, "onUpdate:modelValue": t[0] || (t[0] = (r) => o(p).productType = r), options: c.globalProject.projectType === o(E).STEEL.V ? o(P) : [o(V).BOX], type: "enum", class: "filter-item", style: { "margin-right": "20px" }, onChange: B }, null, 8, ["modelValue", "options"]), g("div", Y, [g("div", { class: "title-item", onClick: t[1] || (t[1] = I((r) => j(e.value, "total"), ["stop"])) }, [n(u, { "stroke-width": 12, type: "circle", percentage: (v = e.value) == null ? void 0 : v.totalRate }, null, 8, ["percentage"]), o(p).productType === o(M).ARTIFACT.V ? (l(), s("div", Z, "累计完成（吨）：" + d(e.value.mete || 0), 1)) : (l(), s("div", ee, "累计完成（平方米）：" + d(e.value.mete || 0), 1))]), n(m, { class: "divider", style: { height: "120px" }, direction: "vertical" }), g("div", { class: "title-item", onClick: t[2] || (t[2] = I((r) => j(e.value, "last"), ["stop"])) }, [n(u, { "stroke-width": 12, type: "circle", percentage: (y = e.value) == null ? void 0 : y.lastRate }, null, 8, ["percentage"]), o(p).productType === o(M).ARTIFACT.V ? (l(), s("div", te, "上月完成（吨）：" + d(e.value.lastMonthMete || 0), 1)) : (l(), s("div", oe, "上月完成（平方米）：" + d(e.value.lastMonthMete || 0), 1))]), n(m, { class: "divider", style: { height: "120px" }, direction: "vertical" }), g("div", { class: "title-item", onClick: t[3] || (t[3] = I((r) => j(e.value, "current"), ["stop"])) }, [n(u, { "stroke-width": 12, type: "circle", percentage: (_ = e.value) == null ? void 0 : _.currentRate }, null, 8, ["percentage"]), o(p).productType === o(M).ARTIFACT.V ? (l(), s("div", ae, "本月完成（吨）：" + d(e.value.currentMonthMete || 0), 1)) : (l(), s("div", re, "本月完成（平方米）：" + d(e.value.currentMonthMete || 0), 1))])])])];
    }), _: 1 })]);
  };
} }, se = L(le, [["__scopeId", "data-v-e94c406c"]]), pe = Object.freeze(Object.defineProperty({ __proto__: null, default: se }, Symbol.toStringTag, { value: "Module" }));
export {
  de as c,
  pe as h,
  se as m
};
