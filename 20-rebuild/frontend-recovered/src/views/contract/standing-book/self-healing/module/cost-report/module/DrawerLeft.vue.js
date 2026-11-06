import { ref as A } from "vue";
import { inject as m } from "vue";
import { computed as H } from "vue";
import { watchEffect as P } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as t } from "vue";
import { withCtx as a } from "vue";
import { unref as r } from "vue";
import { createTextVNode as U } from "vue";
import { withDirectives as D } from "vue";
import { vShow as $ } from "vue";
import { createElementVNode as s } from "vue";
import { Fragment as I } from "vue";
import { renderList as q } from "vue";
import { toDisplayString as d } from "vue";
import { normalizeClass as T } from "vue";
import { createBlock as z } from "vue";
import { createCommentVNode as K } from "vue";
import { ElCol as O } from "element-plus";
import { ElRow as G } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { InfoFilled as M } from "@element-plus/icons-vue";
import { ElIcon as Q } from "element-plus";
import { ElPopover as W } from "element-plus";
import { ElTable as X } from "element-plus";
import { _ as Y, e3 as Z, lp as ee, L as te, dp as ae, bV as se } from "../../../../../../../shared/runtime.js";
import { c as oe, a as ne } from "../../../../../../../modules/index-a8127339.js";
import { u as le } from "../../../../../../../modules/useTableTotal-3d22365a.js";
import { u as ce } from "../../../../../../../modules/useTableHeight-90797a0b.js";
import { c as re } from "../../../../../../../modules/index-d4be09aa.js";
const ie = { class: "drawer-left-container" }, _e = { class: "statistics-container" }, pe = { class: "basic-info" }, de = { class: "item" }, ue = { class: "value-item" }, fe = { class: "table-container" }, me = { class: "line-container" }, he = ["onClick"], ve = { key: 0 }, be = { key: 1 }, ge = { __name: "DrawerLeft", setup(ye) {
  const h = A(oe), i = m("reportInfo"), { projectInfo: j } = m("tableItem"), { formData: w } = m("selfParentData"), y = H(() => Z(ne, i.value[0])), { getSummaries: C } = le(false, { defineData: ["amount"] }), { tableRef: E, maxHeight: S } = ce({ hasPagination: false }), { radioType: V, costItemInfo: L } = m("common"), N = (l) => {
    V.value = l.key, L.value = l;
  };
  return P(() => {
    var l, _, p, u;
    if (i) {
      if (!((l = i.value) != null && l.length)) return;
      (p = (_ = i.value[0]) == null ? void 0 : _.costSubjectCost) != null && p.length ? (u = i.value[0]) == null || u.costSubjectCost.forEach((o) => {
        const v = ee.VK[o.costType], f = h.value.find((b) => b.key === v);
        f && Object.assign(f, o);
      }) : h.value = [];
    }
  }), (l, _) => {
    var k;
    const p = O, u = G, o = J, v = M, f = Q, b = W, R = X, B = F("ellipsis");
    return n(), c("div", ie, [t(ae, { "header-title": "成本统计" }, { headerRight: a(() => {
      var e, g, x;
      return [t(te, { fn: r(re), params: { year: (e = r(w)) == null ? void 0 : e.year, projectId: (x = (g = r(j)) == null ? void 0 : g.project) == null ? void 0 : x.id }, type: "primary" }, { default: a(() => _[0] || (_[0] = [U(" 下载 ")])), _: 1, __: [0] }, 8, ["fn", "params"])];
    }), _: 1 }), D(s("div", _e, [s("div", pe, [t(u, null, { default: a(() => [(n(true), c(I, null, q(y.value, (e) => (n(), c(I, { key: e.key }, [t(p, { span: e.l_span }, { default: a(() => [s("div", de, [s("span", null, d(e.label), 1)])]), _: 2 }, 1032, ["span"]), t(p, { span: e.v_span }, { default: a(() => [s("div", ue, [D((n(), c("div", { class: T([e.key === "sendingUnit" ? "text-space" : "", "truncate"]) }, [s("span", { class: T(e.key === "sendingUnit" || e.key === "projectName" ? "special-text" : "") }, d(e.value ?? "-"), 3)], 2)), [[B]])])]), _: 2 }, 1032, ["span"])], 64))), 128))]), _: 1 })])], 512), [[$, (k = y.value) == null ? void 0 : k.length]]), s("div", fe, [t(R, { ref_key: "tableRef", ref: E, data: h.value, "highlight-current-row": true, "max-height": r(S), "summary-method": r(C), border: "", "show-summary": "", stripe: "" }, { default: a(() => [t(o, { align: "center", label: "序号", type: "index", width: "60" }), t(o, { align: "center", label: "成本科目", prop: "label" }, { default: a(({ row: e }) => [s("div", me, [s("span", null, d(e.label), 1), e.popover_content ? (n(), z(b, { key: 0, content: e.popover_content, width: 300, class: "tip", effect: "dark", placement: "right", trigger: "hover" }, { reference: a(() => [t(f, { class: "icon" }, { default: a(() => [t(v)]), _: 1 })]), _: 2 }, 1032, ["content"])) : K("", true)])]), _: 1 }), t(o, { align: "center", label: "金额（元）", prop: "amount" }, { default: a(({ row: e }) => [s("span", { class: "specialText", onClick: (g) => N(e) }, d(r(se)(e.amount) ?? "-"), 9, he)]), _: 1 }), t(o, { align: "center", label: "占比", prop: "proportion" }, { default: a(({ row: e }) => [e.proportion ? (n(), c("span", ve, d(e.proportion) + " %", 1)) : (n(), c("span", be, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])])]);
  };
} }, we = Y(ge, [["__scopeId", "data-v-68b5e2b2"]]);
export {
  we as default
};
