import { ref as _ } from "vue";
import { watch as q } from "vue";
import { inject as U } from "vue";
import { computed as j } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as I } from "vue";
import { createBlock as N } from "vue";
import { withCtx as a } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as g } from "vue";
import { unref as s } from "vue";
import { createTextVNode as W } from "vue";
import { toDisplayString as d } from "vue";
import { isRef as E } from "vue";
import { ElTag as F } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { vLoading as X } from "element-plus";
import { l as V, t as G, u as J, o as K, pr as Z, rX as ee, ps as te, ba as oe } from "../../../../../../shared/runtime.js";
import { _ as ae } from "../../../../../../modules/index-3b2628f3.js";
import { _ as le } from "../../../../../../modules/index-490fd9d7.js";
function re(u) {
  return V({ module: "mes", url: "wages/out_staff/summary", method: "get", params: u });
}
function ne(u) {
  return V({ module: "mes", url: "wages/out_staff/details", method: "get", params: u });
}
const de = { get: re }, ie = { class: "print-wrap" }, se = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(u, { emit: L }) {
  const { decimalPrecision: P } = G(), v = _(), R = L, c = u, { visible: y, handleClose: S } = J({ emit: R, props: c, field: "visible" }), { maxHeight: $ } = K({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, v);
  q(() => c.visible, (r) => {
    r && Q();
  }, { immediate: true });
  const B = _([["wage", ["to-fixed-ck", "YUAN"]], ["price", ["to-fixed-ck", "YUAN"]]]), h = _(false), x = _([]), p = U("query"), C = U("permission"), f = j(() => Z({ productType: p.productType })), M = j(() => {
    var r, o, e, m, n, w;
    return Object.assign({ factoryId: (o = (r = c.info) == null ? void 0 : r.factory) == null ? void 0 : o.id, productionLineId: (m = (e = c.info) == null ? void 0 : e.productionLine) == null ? void 0 : m.id, workshopId: (w = (n = c.info) == null ? void 0 : n.workshop) == null ? void 0 : w.id, teamId: c.info.teamId }, p);
  });
  async function Q() {
    let r = [];
    try {
      h.value = true;
      const { content: o } = await ne(M.value);
      r = o.map((e, m) => (e.rowId = m + "" + Math.random(), e.showUnit = ee({ wageQuotaType: e.wageQuotaType }).meteUnit, e.checkMete = e.mate, e.completeMete = te({ productType: p.productType, weight: { num: e.completeNetWeight, to: f.value.unit, dp: f.value.dp }, length: { num: e.completeLength, to: f.value.unit, dp: f.value.dp } }), e));
    } catch {
      console.log("获取详情列表失败");
    } finally {
      x.value = r, h.value = false;
    }
  }
  function O(r) {
    return oe(r, { props: ["completeQuantity", "completeMete", ["price", P.value.mes]] });
  }
  return (r, o) => {
    var T;
    const e = F, m = b("print-table"), n = Y, w = b("common-table"), z = b("common-drawer"), k = D("parse-time"), A = D("permission"), H = X;
    return I(), N(z, { ref_key: "drawerRef", ref: v, title: `${(T = u.info.productionLine) == null ? void 0 : T.name}>${u.info.processName}>${u.info.leaderName}`, modelValue: s(y), "onUpdate:modelValue": o[0] || (o[0] = (t) => E(y) ? y.value = t : null), direction: "rtl", "before-close": s(S), size: "70%" }, { titleAfter: a(() => [l(e, { type: "success", effect: "plain", size: "large" }, { default: a(() => [o[1] || (o[1] = i("span", null, "统计日期：", -1)), g(i("span", null, null, 512), [[k, { val: s(p).startDate, fmt: "{y}-{m}-{d}" }]]), o[2] || (o[2] = W(" ~ ")), g(i("span", null, null, 512), [[k, { val: s(p).endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [1, 2] })]), titleRight: a(() => [i("div", ie, [g(l(m, { "api-key": "mesWageDetail", params: M.value, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[A, s(C).printDetail]])])]), content: a(() => [g((I(), N(w, { ref: "tableRef", data: x.value, "data-format": B.value, "max-height": s($), "row-key": "rowId", "show-summary": "", "summary-method": O, style: { width: "100%" } }, { default: a(() => [l(n, { label: "序号", type: "index", align: "center", width: "60" }), l(s(ae), { showProject: "", showMonomer: "" }), l(s(le), { productType: s(p).productType, unShowField: ["material", "color"] }, null, 8, ["productType"]), l(n, { prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成数", align: "center" }, { default: a((t) => [i("span", null, d(t.row.completeQuantity), 1)]), _: 1 }), l(n, { prop: "completeMete", "show-overflow-tooltip": true, label: `完成量(${f.value.unit})`, align: "center" }, { default: a((t) => [i("span", null, d(t.row.completeMete), 1)]), _: 1 }, 8, ["label"]), l(n, { prop: "showUnit", "show-overflow-tooltip": true, label: "核算单位", align: "center" }, { default: a((t) => [i("span", null, d(t.row.showUnit), 1)]), _: 1 }), l(n, { prop: "checkMete", "show-overflow-tooltip": true, label: "核算量", align: "center" }, { default: a((t) => [i("span", null, d(t.row.checkMete), 1)]), _: 1 }), l(n, { prop: "wage", "show-overflow-tooltip": true, label: "工序单价(元)", align: "center" }, { default: a((t) => [i("span", null, d(t.row.wage), 1)]), _: 1 }), l(n, { prop: "price", "show-overflow-tooltip": true, label: "工资(元)", align: "center" }, { default: a((t) => [i("span", null, d(t.row.price), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[H, h.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, fe = Object.freeze(Object.defineProperty({ __proto__: null, default: se }, Symbol.toStringTag, { value: "Module" }));
export {
  se as _,
  de as c,
  fe as d
};
