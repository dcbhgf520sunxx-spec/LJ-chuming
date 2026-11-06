import { ref as v } from "vue";
import { watch as A } from "vue";
import { inject as U } from "vue";
import { computed as E } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as T } from "vue";
import { openBlock as q } from "vue";
import { createBlock as V } from "vue";
import { withCtx as r } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as s } from "vue";
import { withDirectives as f } from "vue";
import { unref as n } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as h } from "vue";
import { isRef as L } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { vLoading as F } from "element-plus";
import { d as Y } from "../../../../../../modules/piecework-system-3800a6fe.js";
import { t as O, u as X, o as G, pr as J, rX as K, ps as Z } from "../../../../../../shared/runtime.js";
import { _ as ee } from "../../../../../../modules/index-3b2628f3.js";
import { _ as te } from "../../../../../../modules/index-490fd9d7.js";
const ae = { class: "print-wrap" }, ie = { __name: "summary-detail", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(D, { emit: P }) {
  const { decimalPrecision: R } = O(), x = v(), B = P, N = D, { visible: b, handleClose: C } = X({ emit: B, props: N, field: "visible" }), { maxHeight: S } = G({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, x);
  A(() => N.visible, (c) => {
    c && H();
  }, { immediate: true });
  const g = v(false), M = v([]), p = U("query"), j = U("permission"), d = E(() => J({ productType: p.productType }));
  async function H() {
    let c = [];
    try {
      g.value = true;
      const { content: o } = await Y(p);
      c = o.map((e, i) => (e.rowId = i + "" + Math.random(), e.showUnit = K({ wageQuotaType: e.wageQuotaType }).meteUnit, e.checkMete = e.mate, e.mete = Z({ productType: p.productType, length: { num: e.length * e.quantity, to: d.value.unit, dp: d.value.dp }, weight: { num: e.netWeight * e.quantity, to: d.value.unit, dp: d.value.dp } }), e));
    } catch {
      console.log("获取详情列表失败");
    } finally {
      M.value = c, g.value = false;
    }
  }
  function $(c) {
    const { columns: o, data: e } = c, i = [];
    return o.forEach((a, m) => {
      if (m === 0) {
        i[m] = "合计";
        return;
      }
      if (a.property === "price" || a.property === "quantity") {
        const w = e.map((u) => Number(u[a.property]));
        w.every((u) => isNaN(u)) || (i[m] = w.reduce((u, _) => {
          const y = Number(_);
          return isNaN(y) ? u : u + _;
        }, 0), a.property === "price" && (i[m] = i[m].toFixed(R.value.mes)));
      }
    }), i;
  }
  return (c, o) => {
    const e = Q, i = k("print-table"), a = W, m = k("common-table"), w = k("common-drawer"), u = T("parse-time"), _ = T("permission"), y = T("to-fixed"), z = F;
    return q(), V(w, { ref_key: "drawerRef", ref: x, title: "汇总详情", modelValue: n(b), "onUpdate:modelValue": o[0] || (o[0] = (t) => L(b) ? b.value = t : null), direction: "rtl", "before-close": n(C), size: "80%" }, { titleAfter: r(() => [l(e, { type: "success", effect: "plain", size: "large" }, { default: r(() => [o[1] || (o[1] = s("span", null, "统计日期：", -1)), f(s("span", null, null, 512), [[u, { val: n(p).startDate, fmt: "{y}-{m}-{d}" }]]), o[2] || (o[2] = I(" ~ ")), f(s("span", null, null, 512), [[u, { val: n(p).endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [1, 2] })]), titleRight: r(() => [s("div", ae, [f(l(i, { "api-key": "mesPieceworkSummary", params: { ...n(p) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[_, n(j).printDetail]])])]), content: r(() => [f((q(), V(m, { ref: "tableRef", data: M.value, "max-height": n(S), "show-summary": "", "summary-method": $, "row-key": "rowId", style: { width: "100%" } }, { default: r(() => [l(a, { label: "序号", type: "index", align: "center", width: "60" }), l(n(ee), { showProject: "", showMonomer: "", showWorkshop: "", showProcess: "", showTeam: "" }), l(n(te), { productType: n(p).productType, unShowField: ["specification", "material", "color"] }, null, 8, ["productType"]), l(a, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center" }, { default: r((t) => [s("span", null, h(t.row.quantity), 1)]), _: 1 }), l(a, { prop: "mete", "show-overflow-tooltip": true, label: `${d.value.label}(${d.value.unit})`, align: "center" }, { default: r((t) => [s("span", null, h(t.row.mete), 1)]), _: 1 }, 8, ["label"]), l(a, { prop: "showUnit", "show-overflow-tooltip": true, label: "核算单位", align: "center" }, { default: r((t) => [s("span", null, h(t.row.showUnit), 1)]), _: 1 }), l(a, { prop: "checkMete", "show-overflow-tooltip": true, label: "核算量", align: "center" }, { default: r((t) => [s("span", null, h(t.row.checkMete), 1)]), _: 1 }), l(a, { prop: "wage", "show-overflow-tooltip": true, label: "工序单价(元)", align: "center" }, { default: r((t) => [f(s("span", null, null, 512), [[y, { k: "YUAN", val: t.row.wage }]])]), _: 1 }), l(a, { prop: "price", "show-overflow-tooltip": true, label: "工资(元)", align: "center" }, { default: r((t) => [f(s("span", null, null, 512), [[y, { k: "YUAN", val: t.row.price }]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[z, g.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ie as default
};
