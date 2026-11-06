import { ref as b } from "vue";
import { watchEffect as V } from "vue";
import { withDirectives as I } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as r } from "vue";
import { Fragment as i } from "vue";
import { createVNode as N } from "vue";
import { withCtx as k } from "vue";
import { renderList as f } from "vue";
import { createBlock as R } from "vue";
import { unref as _ } from "vue";
import { ElRadioButton as j } from "element-plus";
import { createTextVNode as C } from "vue";
import { toDisplayString as d } from "vue";
import { ElRadioGroup as B } from "element-plus";
import { createElementVNode as u } from "vue";
import { ElCollapseItem as S } from "element-plus";
import { normalizeClass as $ } from "vue";
import { ElCollapse as A } from "element-plus";
import { vShow as L } from "vue";
import { vLoading as z } from "element-plus";
import { _ as G, p as D, G as U, pI as F } from "../../../../../../../../shared/runtime.js";
import { a as H } from "../../../../../../../../modules/project-production-panel-fb6946a2.js";
const M = { class: "main-container" }, O = { class: "team-wrap" }, J = { style: { display: "flex" } }, K = { class: "name" }, W = { class: "quantity" }, X = { class: "time" }, Y = { class: "name" }, Z = { class: "quantity" }, m = { class: "time" }, T = { key: 1, class: "red-tip" }, ss = { key: 1, class: "red-tip" }, ls = { __name: "process-card-detail", props: { detailRow: { type: Object, default: () => {
} } }, setup(P) {
  const q = b(false), v = b(0), g = P, c = b([]);
  async function x() {
    var a, e, l;
    if (!U(F.detailProcess)) return;
    v.value = 0;
    const h = { artifactId: (a = g.detailRow) == null ? void 0 : a.artifactId, productId: (e = g.detailRow) == null ? void 0 : e.id, productType: (l = g.detailRow) == null ? void 0 : l.productType }, { content: n = [] } = await H(h);
    c.value = n, Q();
  }
  function Q() {
    const h = (a) => a == null ? void 0 : a.reduce((e, l) => e + ((l == null ? void 0 : l.quantity) || 0), 0), n = (a) => a == null ? void 0 : a.reduce((e, l) => e + ((l == null ? void 0 : l.totalQuantity) || 0), 0);
    c.value.forEach((a) => {
      var e;
      (e = a.teamTraceList) == null || e.forEach((l) => {
        l.totalQuantity = h(l.produceTeamRecourseList);
      }), a.sumQuantity = n(a.teamTraceList);
    });
  }
  return V(() => {
    x();
  }), (h, n) => {
    var e;
    const a = z;
    return I((o(), r("div", M, [(e = c.value) != null && e.length ? (o(), r(i, { key: 0 }, [N(_(B), { modelValue: v.value, "onUpdate:modelValue": n[0] || (n[0] = (l) => v.value = l), size: "default", class: "filter-item", style: { "margin-bottom": "10px" } }, { default: k(() => [(o(true), r(i, null, f(c.value, (l, y) => (o(), R(_(j), { key: y, value: y }, { default: k(() => [C(d(l.name) + "(" + d(l.sumQuantity || 0) + ") ", 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"]), u("div", O, [(o(true), r(i, null, f(c.value, (l, y) => {
      var w;
      return I((o(), r("div", { key: y }, [(w = l.teamTraceList) != null && w.length ? (o(true), r(i, { key: 0 }, f(l == null ? void 0 : l.teamTraceList, (t) => (o(), R(_(A), { key: t.name }, { default: k(() => {
        var E;
        return [N(_(S), { title: `${t == null ? void 0 : t.productLineName}${t != null && t.groupName ? ">" + (t == null ? void 0 : t.groupName) : ""}>${(E = c.value[v.value]) == null ? void 0 : E.name} / ${t.userName}`, name: t.userId }, { default: k(() => [u("div", J, [u("div", null, [(o(true), r(i, null, f(t == null ? void 0 : t.produceTeamRecourseList, (s, p) => (o(), r("div", { key: p, class: "team-item" }, [u("div", K, "生产：" + d((s == null ? void 0 : s.userName) || "-"), 1), u("div", W, "数量：" + d((s == null ? void 0 : s.quantity) || "-"), 1), u("div", X, "时间：" + d(_(D)(s == null ? void 0 : s.createTime, "{y}-{m}-{d} {h}:{i}:{s}") || "-"), 1)]))), 128))]), u("div", null, [(o(true), r(i, null, f(t == null ? void 0 : t.InspectionTeamRecourseList, (s, p) => (o(), r("div", { key: p, class: "team-item" }, [u("div", Y, [u("i", { class: $([s != null && s.boolAdoptEnum ? "is-success" : "is-error", s != null && s.boolAdoptEnum ? "el-icon-check" : "el-icon-close"]) }, null, 2), C(" 质检：" + d((s == null ? void 0 : s.userName) || "-"), 1)]), u("div", Z, "数量：" + d((s == null ? void 0 : s.quantity) || "-"), 1), u("div", m, "时间：" + d(_(D)(s == null ? void 0 : s.createTime, "{y}-{m}-{d} {h}:{i}:{s}") || "-"), 1)]))), 128))])])]), _: 2 }, 1032, ["title", "name"])];
      }), _: 2 }, 1024))), 128)) : (o(), r("span", T, "* 暂无任务"))])), [[L, v.value === y]]);
    }), 128))])], 64)) : (o(), r("span", ss, "* 暂无任务"))])), [[a, q.value]]);
  };
} }, es = G(ls, [["__scopeId", "data-v-363bb628"]]);
export {
  es as default
};
