import { ref as h } from "vue";
import { watch as q } from "vue";
import { inject as P } from "vue";
import { computed as U } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as M } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as l } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as p } from "vue";
import { withDirectives as b } from "vue";
import { unref as u } from "vue";
import { createTextVNode as z } from "vue";
import { toDisplayString as w } from "vue";
import { isRef as A } from "vue";
import { ElTag as E } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { vLoading as W } from "element-plus";
import { d as Y } from "../../../../../../modules/piecework-system-3800a6fe.js";
import { t as X, u as G, o as J, pr as K, rX as Z, ps as ee } from "../../../../../../shared/runtime.js";
import { _ as te } from "../../../../../../modules/index-3b2628f3.js";
import { _ as ae } from "../../../../../../modules/index-490fd9d7.js";
const oe = { class: "print-wrap" }, pe = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(V, { emit: R }) {
  const { decimalPrecision: j } = X(), x = h(), B = R, m = V, { visible: g, handleClose: C } = G({ emit: B, props: m, field: "visible" }), { maxHeight: L } = J({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, x);
  q(() => m.visible, (n) => {
    n && S();
  }, { immediate: true });
  const F = h([["wage", ["to-fixed-ck", "YUAN"]], ["price", ["to-fixed-ck", "YUAN"]]]), v = h(false), N = h([]), d = P("query"), H = P("permission"), f = U(() => K({ productType: d.productType })), I = U(() => {
    var n, a, e, r, t, i;
    return Object.assign({ factoryId: (a = (n = m.info) == null ? void 0 : n.factory) == null ? void 0 : a.id, productionLineId: (r = (e = m.info) == null ? void 0 : e.productionLine) == null ? void 0 : r.id, workshopId: (i = (t = m.info) == null ? void 0 : t.workshop) == null ? void 0 : i.id, teamId: m.info.teamId, processId: m.info.processId }, d);
  });
  async function S() {
    let n = [];
    try {
      v.value = true;
      const { content: a } = await Y(I.value);
      n = a.map((e, r) => (e.rowId = r + "" + Math.random(), e.showUnit = Z({ wageQuotaType: e.wageQuotaType }).meteUnit, e.checkMete = e.mate, e.mete = ee({ productType: d.productType, length: { num: e.length * e.completeQuantity, to: f.value.unit, dp: f.value.dp }, weight: { num: e.netWeight * e.completeQuantity, to: f.value.unit, dp: f.value.dp } }), e));
    } catch {
      console.log("获取详情列表失败");
    } finally {
      N.value = n, v.value = false;
    }
  }
  function $(n) {
    const { columns: a, data: e } = n, r = [];
    return a.forEach((t, i) => {
      if (i === 0) {
        r[i] = "合计";
        return;
      }
      if (t.property === "price" || t.property === "completeQuantity") {
        const _ = e.map((c) => Number(c[t.property]));
        _.every((c) => isNaN(c)) || (r[i] = _.reduce((c, y) => {
          const k = Number(y);
          return isNaN(k) ? c : c + y;
        }, 0), t.property === "price" && (r[i] = r[i].toFixed(j.value.mes)));
      }
    }), r;
  }
  return (n, a) => {
    const e = E, r = T("print-table"), t = O, i = T("common-table"), _ = T("common-drawer"), c = D("parse-time"), y = D("permission"), k = W;
    return M(), Q(_, { ref_key: "drawerRef", ref: x, title: "计价制详情", modelValue: u(g), "onUpdate:modelValue": a[0] || (a[0] = (o) => A(g) ? g.value = o : null), direction: "rtl", "before-close": u(C), size: "100%" }, { titleAfter: l(() => [s(e, { type: "success", effect: "plain", size: "large" }, { default: l(() => [a[1] || (a[1] = p("span", null, "统计日期：", -1)), b(p("span", null, null, 512), [[c, { val: u(d).startDate, fmt: "{y}-{m}-{d}" }]]), a[2] || (a[2] = z(" ~ ")), b(p("span", null, null, 512), [[c, { val: u(d).endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [1, 2] })]), titleRight: l(() => [p("div", oe, [b(s(r, { "api-key": "mesPieceworkDetail", params: I.value, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[y, u(H).printDetail]])])]), content: l(() => [b((M(), Q(i, { ref: "tableRef", data: N.value, "data-format": F.value, "max-height": u(L), "row-key": "rowId", "show-summary": "", "summary-method": $, style: { width: "100%" } }, { default: l(() => [s(t, { label: "序号", type: "index", align: "center", width: "60" }), s(u(te), { showProject: "", showFactory: "", showProductionLine: "", showProcess: "", showTeam: "" }), s(u(ae), { productType: u(d).productType, unShowField: ["color"] }, null, 8, ["productType"]), s(t, { prop: "completeQuantity", "show-overflow-tooltip": true, label: "生产数量", align: "center" }, { default: l(({ row: o }) => [p("span", null, w(o.completeQuantity), 1)]), _: 1 }), s(t, { prop: "mete", "show-overflow-tooltip": true, label: `${f.value.label}(${f.value.unit})`, align: "center" }, { default: l((o) => [p("span", null, w(o.row.mete), 1)]), _: 1 }, 8, ["label"]), s(t, { prop: "showUnit", "show-overflow-tooltip": true, label: "核算单位", align: "center" }, { default: l(({ row: o }) => [p("span", null, w(o.showUnit), 1)]), _: 1 }), s(t, { prop: "checkMete", "show-overflow-tooltip": true, label: "产量", align: "center" }, { default: l(({ row: o }) => [p("span", null, w(o.checkMete), 1)]), _: 1 }), s(t, { prop: "wage", "show-overflow-tooltip": true, label: "工序单价(元)", align: "center" }, { default: l(({ row: o }) => [p("span", null, w(o.wage), 1)]), _: 1 }), s(t, { prop: "price", "show-overflow-tooltip": true, label: "工资(元)", align: "center" }, { default: l(({ row: o }) => [p("span", null, w(o.price), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[k, v.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  pe as default
};
