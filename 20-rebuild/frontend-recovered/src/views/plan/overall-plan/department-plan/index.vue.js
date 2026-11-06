import { ref as x } from "vue";
import { computed as R } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as o } from "vue";
import { createBlock as m } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as n } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as v } from "vue";
import { ElTag as G } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { g as $ } from "../../../../modules/sectional-entry-plan-49cfc1e2.js";
import { fg as q, o as A, bN as O, p as u, c7 as D, ng as L, mw as K, G as F, aI as V } from "../../../../shared/runtime.js";
import { d as J } from "../../../../modules/plan-d12d7ccf.js";
const Q = { class: "app-container" }, W = { class: "head-container", style: { display: "flex" } }, X = { key: 0, style: { color: "#e6a23c" } }, Y = { style: { color: "#67c23a" } }, Z = { style: { color: "#67c23a", "margin-left": "10px" } }, w = { key: 1 }, ee = { key: 0, class: "monomer-time-box", style: { background: "#b8dec7" } }, te = { key: 1, style: { display: "flex", "align-items": "center", "justify-content": "center" } }, ae = { style: { "margin-right": "5px" } }, se = { key: 0, class: "monomer-time-box", style: { background: "#fceec5" } }, ne = { key: 1, style: { display: "flex", "align-items": "center", "justify-content": "center" } }, le = { style: { "margin-right": "5px" } }, de = { key: 0, class: "monomer-time-box", style: { background: "#cad4f8" } }, ie = { key: 1, style: { display: "flex", "align-items": "center", "justify-content": "center" } }, re = { key: 0, style: { "margin-right": "5px" } }, pe = { key: 0, class: "monomer-time-box", style: { background: "#fceec5" } }, ce = { key: 1, style: { display: "flex", "align-items": "center", "justify-content": "center" } }, oe = { style: { "margin-right": "5px" } }, ue = { key: 0, class: "monomer-time-box", style: { background: "#f8cae4" } }, De = { key: 1, style: { display: "flex", "align-items": "center", "justify-content": "center" } }, ye = { style: { "margin-right": "5px" } }, me = { key: 1, style: { color: "red" } }, he = { key: 2, style: { color: "red" } }, xe = { __name: "index", setup(fe) {
  const { projectTree: M } = q(), { maxHeight: N } = A({}), C = x(), h = x(void 0), j = x([]), f = x(void 0), b = x(true), P = x([]), I = R(() => M.value.map((t) => (t.serialNumberName = t.serialNumber + " " + t.name, t)));
  async function B() {
    if (!h.value || !F(J.get)) return;
    const { content: r } = await $(h.value);
    b.value = r == null ? void 0 : r.some((t) => {
      var _;
      return !(((_ = t.areaDTOList) == null ? void 0 : _.length) > 0);
    }), j.value = r == null ? void 0 : r.map((t, _) => {
      var y;
      return t.idx = _ + 1, t.uid = t.uid || V(), t.isMonomer = true, t.deepenEndDate = S(t.areaDTOList.map((a) => a.deepenEndDate)), t.deepenStartDate = E(t.areaDTOList.map((a) => a.deepenStartDate)), t.purchaseEndDate = S(t.areaDTOList.map((a) => a.purchaseEndDate)), t.purchaseStartDate = E(t.areaDTOList.map((a) => a.purchaseStartDate)), t.processEndDate = S(t.areaDTOList.map((a) => a.processEndDate)), t.processStartDate = E(t.areaDTOList.map((a) => a.processStartDate)), t.shippingEndDate = S(t.areaDTOList.map((a) => a.shippingEndDate)), t.shippingStartDate = E(t.areaDTOList.map((a) => a.shippingStartDate)), t.installEndDate = S(t.areaDTOList.map((a) => a.installEndDate)), t.installStartDate = E(t.areaDTOList.map((a) => a.installStartDate)), t.startDate = E([t.deepenStartDate, t.purchaseStartDate, t.processStartDate, t.shippingStartDate, t.installStartDate]), t.endDate = S([t.deepenEndDate, t.purchaseEndDate, t.processEndDate, t.shippingEndDate, t.installEndDate]), (y = t.areaDTOList) == null || y.forEach((a, T) => {
        a.idx = `${t.idx}.${T + 1}`, a.uid = a.uid || V(), a.startDate = E([a.deepenStartDate, a.purchaseStartDate, a.processStartDate, a.shippingStartDate, a.installStartDate]), a.endDate = S([a.deepenEndDate, a.purchaseEndDate, a.processEndDate, a.shippingEndDate, a.installEndDate]), a.deliveryDate = a.deliveryStartDate && a.deliveryEndDate ? [a.deliveryStartDate, a.deliveryEndDate] : null;
      }), t;
    });
  }
  function H(r) {
    const t = M.value.filter((_) => _.id === r);
    f.value = t[0], B();
  }
  const E = (r) => {
    const t = r.filter(Boolean);
    return t.length ? Math.min(...t) : null;
  }, S = (r) => {
    const t = r.filter(Boolean);
    return t.length ? Math.max(...t) : null;
  };
  return (r, t) => {
    const _ = z("common-select"), y = G, a = U, T = z("common-table");
    return l(), p("div", Q, [c("div", W, [o(_, { modelValue: h.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => h.value = e), options: I.value, type: "other", "data-structure": { key: "id", label: "serialNumberName", value: "id" }, class: "filter-item", filterable: "", style: { width: "350px" }, placeholder: "选择项目", onChange: H }, null, 8, ["modelValue", "options"]), h.value ? (l(), m(y, { key: 0, size: "large", effect: "plain" }, { default: i(() => {
      var e, g, k;
      return [(e = f.value) != null && e.orderType ? (l(), p("span", X, n(s(O).V[f.value.orderType].L || "-"), 1)) : d("", true), t[1] || (t[1] = c("span", { style: { margin: "0 10px" } }, " | ", -1)), c("span", Y, " 开工日期：" + n(s(u)((g = f.value) == null ? void 0 : g.startDate, "{y}-{m}-{d}") || "-") + " ~ 完工日期：" + n(s(u)((k = f.value) == null ? void 0 : k.endDate, "{y}-{m}-{d}") || "-"), 1), c("span", Z, "工期：" + n(s(D)(f.value.startDate, f.value.endDate)) + "天", 1)];
    }), _: 1, __: [1] })) : d("", true)]), h.value && !b.value ? (l(), m(T, { key: 0, ref_key: "tableRef", ref: C, data: j.value, "empty-text": "暂无数据", "max-height": s(N), "return-source-data": "", "show-empty-symbol": false, style: { width: "100%" }, "row-key": "uid", stripe: false, "default-expand-all": "", "expand-row-keys": P.value, class: "dept-plan-table-wrapper", "cell-class-name": r.wrongCellMask, "cell-style": r.cellStyle, "tree-props": { children: "areaDTOList" } }, { default: i(() => [o(a, { label: "序号", prop: "idx", align: "center", width: "55" }, { default: i(({ row: e }) => [c("span", null, n(e.idx), 1)]), _: 1 }), o(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "单体/区段", "min-width": "100px" }, { default: i(({ row: e }) => [c("span", null, n(e.name), 1)]), _: 1 }), o(a, { prop: "itemizedType", align: "center", label: "制品分类", width: "120px" }, { default: i(({ row: e }) => {
      var g;
      return [parseInt(e.itemizedType) ? (l(), m(y, { key: 0, type: (g = s(L).V[e.itemizedType]) == null ? void 0 : g.T, effect: "plain" }, { default: i(() => [v(n(parseInt(e.itemizedType) ? s(L).VL[e.itemizedType] : e.itemizedType), 1)]), _: 2 }, 1032, ["type"])) : (l(), p("span", w))];
    }), _: 1 }), o(a, { prop: "unit", align: "center", label: "单位", width: "70px" }, { default: i(({ row: e }) => {
      var g, k;
      return [c("span", null, n((k = (g = s(L).V) == null ? void 0 : g[e.itemizedType]) == null ? void 0 : k.unit), 1)];
    }), _: 1 }), o(a, { prop: "mete", label: "工程量", align: "center", width: "130px" }, { default: i(({ row: e }) => [c("span", null, n(e.mete), 1)]), _: 1 }), o(a, { key: "type", prop: "type", label: "生产方式", align: "center", width: "80px" }, { default: i(({ row: e }) => [c("span", null, n(s(K).VL[e.type]), 1)]), _: 1 }), o(a, { prop: "deepenTimes", label: "深化计划", align: "center", width: "220px" }, { default: i(({ row: e }) => [e.isMonomer ? (l(), p("div", ee, n(e.deepenStartDate && e.deepenEndDate ? s(D)(e.deepenStartDate, e.deepenEndDate) + "天" : "-"), 1)) : d("", true), e.isMonomer ? d("", true) : (l(), p("div", te, [c("span", ae, n(e.deepenStartDate && e.deepenEndDate ? s(u)(e.deepenStartDate, "{y}-{m}-{d}") + " ~ " + s(u)(e.deepenEndDate, "{y}-{m}-{d}") : "-"), 1), e.deepenStartDate && e.deepenEndDate ? (l(), m(y, { key: 0, size: "default", effect: "plain" }, { default: i(() => [v(n(s(D)(e.deepenStartDate, e.deepenEndDate)), 1)]), _: 2 }, 1024)) : d("", true)]))]), _: 1 }), o(a, { prop: "purchaseTimes", label: "采购计划", align: "center", width: "220px" }, { default: i(({ row: e }) => [e.isMonomer ? (l(), p("div", se, n(e.purchaseStartDate && e.purchaseEndDate ? s(D)(e.purchaseStartDate, e.purchaseEndDate) + "天" : "-"), 1)) : d("", true), e.isMonomer ? d("", true) : (l(), p("div", ne, [c("span", le, n(e.purchaseStartDate && e.purchaseEndDate ? s(u)(e.purchaseStartDate, "{y}-{m}-{d}") + " ~ " + s(u)(e.purchaseEndDate, "{y}-{m}-{d}") : "-"), 1), e.purchaseStartDate && e.purchaseEndDate ? (l(), m(y, { key: 0, size: "default", effect: "plain" }, { default: i(() => [v(n(s(D)(e.purchaseStartDate, e.purchaseEndDate)), 1)]), _: 2 }, 1024)) : d("", true)]))]), _: 1 }), o(a, { prop: "processTimes", label: "加工计划", align: "center", width: "220px" }, { default: i(({ row: e }) => [e.isMonomer ? (l(), p("div", de, n(e.processStartDate && e.processEndDate ? s(D)(e.processStartDate, e.processEndDate) + "天" : "-"), 1)) : d("", true), e.isMonomer ? d("", true) : (l(), p("div", ie, [!e.isMonomer && !e.isPlanEdit ? (l(), p("span", re, n(e.processStartDate && e.processEndDate ? s(u)(e.processStartDate, "{y}-{m}-{d}") + " ~ " + s(u)(e.processEndDate, "{y}-{m}-{d}") : "-"), 1)) : d("", true), e.processStartDate && e.processEndDate ? (l(), m(y, { key: 1, size: "default", effect: "plain" }, { default: i(() => [v(n(s(D)(e.processStartDate, e.processEndDate)), 1)]), _: 2 }, 1024)) : d("", true)]))]), _: 1 }), o(a, { prop: "shippingTimes", label: "发运计划", align: "center", width: "220px" }, { default: i(({ row: e }) => [e.isMonomer ? (l(), p("div", pe, n(e.shippingStartDate && e.shippingEndDate ? s(D)(e.shippingStartDate, e.shippingEndDate) + "天" : "-"), 1)) : d("", true), e.isMonomer ? d("", true) : (l(), p("div", ce, [c("span", oe, n(e.shippingStartDate && e.shippingEndDate ? s(u)(e.shippingStartDate, "{y}-{m}-{d}") + " ~ " + s(u)(e.shippingEndDate, "{y}-{m}-{d}") : "-"), 1), e.shippedStartDate && e.shippedEndDate ? (l(), m(y, { key: 0, size: "default", effect: "plain" }, { default: i(() => [v(n(s(D)(e.shippedStartDate, e.shippedEndDate)), 1)]), _: 2 }, 1024)) : d("", true)]))]), _: 1 }), f.value.orderType !== s(O).MACHINING.V ? (l(), m(a, { key: 0, prop: "installTimes", label: "安装计划", align: "center", width: "220px" }, { default: i(({ row: e }) => [e.isMonomer ? (l(), p("div", ue, n(e.installStartDate && e.installEndDate ? s(D)(e.installStartDate, e.installEndDate) + "天" : "-"), 1)) : d("", true), e.isMonomer ? d("", true) : (l(), p("div", De, [c("span", ye, n(e.installStartDate && e.installEndDate ? s(u)(e.installStartDate, "{y}-{m}-{d}") + " ~ " + s(u)(e.installEndDate, "{y}-{m}-{d}") : "-"), 1), e.installStartDate && e.installEndDate ? (l(), m(y, { key: 0, size: "default", effect: "plain" }, { default: i(() => [v(n(s(D)(e.installStartDate, e.installEndDate)), 1)]), _: 2 }, 1024)) : d("", true)]))]), _: 1 })) : d("", true), o(a, { align: "center", label: "工期(天)", width: "70px" }, { default: i(({ row: e }) => [c("span", null, n(e.startDate && e.endDate ? s(D)(e.startDate, e.endDate) : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys", "cell-class-name", "cell-style"])) : d("", true), h.value ? d("", true) : (l(), p("span", me, "* 请先选择项目")), b.value && h.value ? (l(), p("span", he, "* 暂无数据")) : d("", true)]);
  };
} };
export {
  xe as default
};
