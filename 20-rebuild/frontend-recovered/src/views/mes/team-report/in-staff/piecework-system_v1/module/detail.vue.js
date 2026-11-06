import { ref as N } from "vue";
import { watch as A } from "vue";
import { inject as D } from "vue";
import { computed as I } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as x } from "vue";
import { openBlock as V } from "vue";
import { createBlock as P } from "vue";
import { withCtx as r } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as _ } from "vue";
import { withDirectives as w } from "vue";
import { unref as c } from "vue";
import { createTextVNode as E } from "vue";
import { isRef as O } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { vLoading as W } from "element-plus";
import { d as Y } from "../../../../../../modules/piecework-system-3800a6fe.js";
import { t as X, u as G, o as J, pr as K, rX as Z, ps as ee } from "../../../../../../shared/runtime.js";
import { _ as te } from "../../../../../../modules/index-3b2628f3.js";
import { _ as ae } from "../../../../../../modules/index-490fd9d7.js";
const oe = { class: "print-wrap" }, ue = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(g, { emit: R }) {
  const { decimalPrecision: j } = X(), M = N(), B = R, d = g, { visible: v, handleClose: C } = G({ emit: B, props: d, field: "visible" }), { maxHeight: L } = J({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, M);
  A(() => d.visible, (s) => {
    s && z();
  }, { immediate: true });
  const k = N(false), U = N([]), m = D("query"), $ = D("permission"), f = I(() => K({ productType: m.productType })), q = I(() => {
    var s, t, e, l, a, u;
    return Object.assign({ factoryId: (t = (s = d.info) == null ? void 0 : s.factory) == null ? void 0 : t.id, productionLineId: (l = (e = d.info) == null ? void 0 : e.productionLine) == null ? void 0 : l.id, workshopId: (u = (a = d.info) == null ? void 0 : a.workshop) == null ? void 0 : u.id, teamId: d.info.teamId }, m);
  });
  async function z() {
    let s = [];
    try {
      k.value = true;
      const { content: t } = await Y(q.value);
      s = t.map((e, l) => (e.rowId = l + "" + Math.random(), e.showUnit = Z({ wageQuotaType: e.wageQuotaType }).meteUnit, e.checkMete = e.mate, e.mete = ee({ productType: m.productType, length: { num: e.length * e.quantity, to: f.value.unit, dp: f.value.dp }, weight: { num: e.netWeight * e.quantity, to: f.value.unit, dp: f.value.dp } }), e));
    } catch {
      console.log("获取详情列表失败");
    } finally {
      U.value = s, k.value = false;
    }
  }
  function H(s) {
    const { columns: t, data: e } = s, l = [];
    return t.forEach((a, u) => {
      if (u === 0) {
        l[u] = "合计";
        return;
      }
      if (a.property === "price" || a.property === "quantity") {
        const y = e.map((p) => Number(p[a.property]));
        y.every((p) => isNaN(p)) || (l[u] = y.reduce((p, h) => {
          const b = Number(h);
          return isNaN(b) ? p : p + h;
        }, 0), a.property === "price" && (l[u] = l[u].toFixed(j.value.mes)));
      }
    }), l;
  }
  return (s, t) => {
    const e = Q, l = T("print-table"), a = F, u = T("common-table"), y = T("common-drawer"), p = x("parse-time"), h = x("permission"), b = x("to-fixed"), S = W;
    return V(), P(y, { ref_key: "drawerRef", ref: M, title: `${g.info.processName}`, modelValue: c(v), "onUpdate:modelValue": t[0] || (t[0] = (o) => O(v) ? v.value = o : null), direction: "rtl", "before-close": c(C), size: "60%" }, { titleAfter: r(() => [n(e, { effect: "plain", size: "large" }, { default: r(() => [t[1] || (t[1] = i("span", null, "班组：", -1)), i("span", null, _(g.info.leaderName), 1)]), _: 1, __: [1] }), n(e, { type: "success", effect: "plain", size: "large" }, { default: r(() => [t[2] || (t[2] = i("span", null, "统计日期：", -1)), w(i("span", null, null, 512), [[p, { val: c(m).startDate, fmt: "{y}-{m}-{d}" }]]), t[3] || (t[3] = E(" ~ ")), w(i("span", null, null, 512), [[p, { val: c(m).endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [2, 3] })]), titleRight: r(() => [i("div", oe, [w(n(l, { "api-key": "mesPieceworkDetail", params: q.value, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[h, c($).printDetail]])])]), content: r(() => [w((V(), P(u, { ref: "tableRef", data: U.value, "max-height": c(L), "row-key": "rowId", "show-summary": "", "summary-method": H, style: { width: "100%" } }, { default: r(() => [n(a, { label: "序号", type: "index", align: "center", width: "60" }), n(c(te), { showProject: "", showMonomer: "" }), n(c(ae), { productType: c(m).productType, unShowField: ["specification", "material", "color"] }, null, 8, ["productType"]), n(a, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center" }, { default: r((o) => [i("span", null, _(o.row.quantity), 1)]), _: 1 }), n(a, { prop: "mete", "show-overflow-tooltip": true, label: `${f.value.label}(${f.value.unit})`, align: "center" }, { default: r((o) => [i("span", null, _(o.row.mete), 1)]), _: 1 }, 8, ["label"]), n(a, { prop: "showUnit", "show-overflow-tooltip": true, label: "核算单位", align: "center" }, { default: r((o) => [i("span", null, _(o.row.showUnit), 1)]), _: 1 }), n(a, { prop: "checkMete", "show-overflow-tooltip": true, label: "核算量", align: "center" }, { default: r((o) => [i("span", null, _(o.row.checkMete), 1)]), _: 1 }), n(a, { prop: "wage", "show-overflow-tooltip": true, label: "工序单价(元)", align: "center" }, { default: r((o) => [w(i("span", null, null, 512), [[b, { k: "YUAN", val: o.row.wage }]])]), _: 1 }), n(a, { prop: "price", "show-overflow-tooltip": true, label: "工资(元)", align: "center" }, { default: r((o) => [w(i("span", null, null, 512), [[b, { k: "YUAN", val: o.row.price }]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[S, k.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  ue as default
};
