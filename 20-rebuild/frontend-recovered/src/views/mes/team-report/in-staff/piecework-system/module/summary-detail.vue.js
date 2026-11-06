import { ref as y } from "vue";
import { watch as $ } from "vue";
import { inject as U } from "vue";
import { computed as q } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as P } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as o } from "vue";
import { createVNode as r } from "vue";
import { createElementVNode as l } from "vue";
import { withDirectives as h } from "vue";
import { unref as s } from "vue";
import { createTextVNode as z } from "vue";
import { toDisplayString as d } from "vue";
import { isRef as A } from "vue";
import { ElTag as E } from "element-plus";
import { ElTableColumn as I } from "element-plus";
import { vLoading as W } from "element-plus";
import { d as Y } from "../../../../../../modules/piecework-system-3800a6fe.js";
import { t as O, u as X, o as G, pr as J, rX as K, ps as Z } from "../../../../../../shared/runtime.js";
import { _ as ee } from "../../../../../../modules/index-3b2628f3.js";
import { _ as te } from "../../../../../../modules/index-490fd9d7.js";
const ae = { class: "print-wrap" }, ie = { __name: "summary-detail", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(V, { emit: D }) {
  const { decimalPrecision: R } = O(), k = y(), B = D, x = V, { visible: g, handleClose: C } = X({ emit: B, props: x, field: "visible" }), { maxHeight: S } = G({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, k);
  $(() => x.visible, (p) => {
    p && H();
  }, { immediate: true });
  const j = y([["wage", ["to-fixed-ck", "YUAN"]], ["price", ["to-fixed-ck", "YUAN"]]]), b = y(false), N = y([]), i = U("query"), F = U("permission"), m = q(() => J({ productType: i.productType }));
  async function H() {
    try {
      b.value = true;
      const { content: p } = await Y(i);
      N.value = p.map((e, f) => (e.rowId = f + "" + Math.random(), e.showUnit = K({ wageQuotaType: e.wageQuotaType }).meteUnit, e.checkMete = e.mate, e.mete = Z({ productType: i.productType, length: { num: e.length * e.completeQuantity, to: m.value.unit, dp: m.value.dp }, weight: { num: e.netWeight * e.completeQuantity, to: m.value.unit, dp: m.value.dp } }), e));
    } catch {
      console.log("获取详情列表失败");
    } finally {
      b.value = false;
    }
  }
  function L(p) {
    const { columns: e, data: f } = p, u = [];
    return e.forEach((a, c) => {
      if (c === 0) {
        u[c] = "合计";
        return;
      }
      if (a.property === "price" || a.property === "completeQuantity") {
        const w = f.map((n) => Number(n[a.property]));
        w.every((n) => isNaN(n)) || (u[c] = w.reduce((n, _) => {
          const v = Number(_);
          return isNaN(v) ? n : n + _;
        }, 0), a.property === "price" && (u[c] = u[c].toFixed(R.value.mes)));
      }
    }), u;
  }
  return (p, e) => {
    const f = E, u = T("print-table"), a = I, c = T("common-table"), w = T("common-drawer"), n = M("parse-time"), _ = M("permission"), v = W;
    return P(), Q(w, { ref_key: "drawerRef", ref: k, title: "汇总详情", modelValue: s(g), "onUpdate:modelValue": e[0] || (e[0] = (t) => A(g) ? g.value = t : null), direction: "rtl", "before-close": s(C), size: "80%" }, { titleAfter: o(() => [r(f, { type: "success", effect: "plain", size: "large" }, { default: o(() => [e[1] || (e[1] = l("span", null, "统计日期：", -1)), h(l("span", null, null, 512), [[n, { val: s(i).startDate, fmt: "{y}-{m}-{d}" }]]), e[2] || (e[2] = z(" ~ ")), h(l("span", null, null, 512), [[n, { val: s(i).endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [1, 2] })]), titleRight: o(() => [l("div", ae, [h(r(u, { "api-key": "mesPieceworkSummary", params: { ...s(i) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[_, s(F).printDetail]])])]), content: o(() => [h((P(), Q(c, { ref: "tableRef", data: N.value, "data-format": j.value, "max-height": s(S), "show-summary": "", "summary-method": L, "row-key": "rowId", style: { width: "100%" } }, { default: o(() => [r(a, { label: "序号", type: "index", align: "center", width: "60" }), r(s(ee), { showProject: "", showFactory: "", showProductionLine: "", showProcess: "", showTeam: "" }), r(s(te), { productType: s(i).productType, unShowField: ["color"] }, null, 8, ["productType"]), r(a, { prop: "completeQuantity", "show-overflow-tooltip": true, label: "数量", align: "center" }, { default: o((t) => [l("span", null, d(t.row.completeQuantity), 1)]), _: 1 }), r(a, { prop: "mete", "show-overflow-tooltip": true, label: `${m.value.label}(${m.value.unit})`, align: "center" }, { default: o((t) => [l("span", null, d(t.row.mete), 1)]), _: 1 }, 8, ["label"]), r(a, { prop: "showUnit", "show-overflow-tooltip": true, label: "核算单位", align: "center" }, { default: o((t) => [l("span", null, d(t.row.showUnit), 1)]), _: 1 }), r(a, { prop: "checkMete", "show-overflow-tooltip": true, label: "核算量", align: "center" }, { default: o((t) => [l("span", null, d(t.row.checkMete), 1)]), _: 1 }), r(a, { prop: "wage", "show-overflow-tooltip": true, label: "工序单价(元)", align: "center" }, { default: o((t) => [l("span", null, d(t.row.wage), 1)]), _: 1 }), r(a, { prop: "price", "show-overflow-tooltip": true, label: "工资(元)", align: "center" }, { default: o((t) => [l("span", null, d(t.row.price), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[v, b.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ie as default
};
