import { ref as g } from "vue";
import { inject as P } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as d } from "vue";
import { createBlock as A } from "vue";
import { withCtx as i } from "vue";
import { createVNode as c } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as u } from "vue";
import { createElementVNode as U } from "vue";
import { unref as h } from "vue";
import { withDirectives as F } from "vue";
import { createElementBlock as _ } from "vue";
import { normalizeClass as G } from "vue";
import { createCommentVNode as y } from "vue";
import { isRef as J } from "vue";
import { ElTag as K } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { vLoading as W } from "element-plus";
import { u as X } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as Z, u as $, o as ee, bV as I, cH as te, D as oe } from "../../../../shared/runtime.js";
const ae = { class: "content-header" }, re = { key: 0 }, le = { key: 0 }, ne = { key: 0 }, se = { key: 0 }, ie = { __name: "production-labor-cost", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(f, { emit: j }) {
  const H = j, D = f, L = g(), M = g(), v = g([]), x = g(false), C = P("query"), { visible: k, handleClose: B } = $({ emit: H, props: D, showHook: S, closeHook: Y }), { maxHeight: T } = ee({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, L);
  async function E() {
    var n;
    x.value = true;
    try {
      const s = { projectId: (n = D.currentData) == null ? void 0 : n.projectId, boolTaxIncluded: C.boolTaxIncluded };
      (await X(s)).forEach(async (o, a) => {
        var t, e, l;
        let r = 0;
        (t = o.monthList) != null && t.length && (o.monthList.forEach((m, w) => {
          m.index = w + 1;
        }), r = o.monthList.reduce((m, w) => m + +w.totalAmount, 0));
        const b = [{ index: te(a + 1), titleRow: true, yearMonth: ((l = (e = o.monthList) == null ? void 0 : e[0]) == null ? void 0 : l.yearMonth) || "-", totalAmount: I(r, 3) }, ...o.monthList || []];
        v.value.push(...b);
      });
    } catch (s) {
      console.log(s);
    } finally {
      x.value = false;
    }
  }
  function S() {
    E();
  }
  function Y() {
    v.value = [];
  }
  const q = (n) => {
    const { columns: s, data: p } = n, o = [];
    return s.forEach((a, r) => {
      if (r === 0) {
        o[r] = "总合计";
        return;
      }
      if (["totalAmount"].findIndex((t) => Array.isArray(t) ? t[0] === a.property : t === a.property) > -1) {
        const e = p.filter((l) => !l.titleRow).map((l) => Number(l[a.property]));
        e.every((l) => Number.isNaN(l)) ? o[r] = "" : (o[r] = e.reduce((l, m) => {
          const w = Number(m);
          return Number.isNaN(w) ? l : l + m;
        }, 0), a.property === "totalAmount" && (o[r] = I(o[r], oe.YUAN)));
      }
    }), o;
  };
  function z({ row: n, rowIndex: s }) {
    return n.titleRow ? "fabricating-cost-statistics-title-row" : "";
  }
  function O({ row: n, rowIndex: s }) {
    return n.titleRow ? "fabricating-cost-statistics-title-row" : "";
  }
  return (n, s) => {
    const p = K, o = R("print-table"), a = Q, r = R("common-table"), N = R("common-drawer"), b = W;
    return d(), A(N, { ref_key: "drawerRef", ref: L, title: "人工直接费", "close-on-click-modal": false, modelValue: h(k), "onUpdate:modelValue": s[0] || (s[0] = (t) => J(k) ? k.value = t : null), direction: "rtl", "before-close": h(B), "wrapper-closable": false, "custom-class": "amount-detail", size: "70%" }, { titleAfter: i(() => [c(p, null, { default: i(() => {
      var t, e;
      return [V("项目：" + u(((t = f.currentData) == null ? void 0 : t.serialNumber) || "-") + " " + u(((e = f.currentData) == null ? void 0 : e.projectName) || "-"), 1)];
    }), _: 1 })]), content: i(() => {
      var t;
      return [U("div", ae, [c(p, null, { default: i(() => [V("统计日期：" + u(f.timeInterval || "-"), 1)]), _: 1 }), c(o, { "api-key": "productionLaborCost", params: { projectId: (t = f.currentData) == null ? void 0 : t.projectId, boolTaxIncluded: h(C).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), F((d(), A(r, { ref_key: "tableRef", ref: M, data: v.value, "max-height": h(T), "data-format": n.columnsDataFormat, "summary-method": q, "show-summary": "", showEmptySymbol: false, stripe: false, "cell-class-name": O, "row-class-name": z }, { default: i(() => [c(a, { prop: "index", key: "index", label: "序号", align: "center", fixed: "left" }), c(a, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "日期", align: "center" }, { default: i((e) => [e.row.totalRow ? y("", true) : (d(), _("span", { key: 0, class: G([e.row.titleRow ? "blod" : ""]) }, u(e.row.yearMonth || "-"), 3))]), _: 1 }), c(a, { "show-overflow-tooltip": "", prop: "processName", key: "processName", label: "工序", align: "center" }, { default: i((e) => [e.row.titleRow ? y("", true) : (d(), _("span", re, u(e.row.processName || "-"), 1))]), _: 1 }), c(a, { "show-overflow-tooltip": "", prop: "unit", key: "unit", label: "计量方式", align: "center" }, { default: i((e) => [e.row.titleRow ? y("", true) : (d(), _("span", le, u(e.row.unit || "-"), 1))]), _: 1 }), c(a, { "show-overflow-tooltip": "", prop: "monthlyYield", key: "monthlyYield", label: "当月产量", align: "center" }, { default: i((e) => [e.row.titleRow ? y("", true) : (d(), _("span", ne, u(e.row.monthlyYield || "-"), 1))]), _: 1 }), c(a, { "show-overflow-tooltip": "", prop: "totalAmount", key: "totalAmount", label: "人工费总额", align: "center" }, { default: i((e) => [e.row.titleRow ? y("", true) : (d(), _("span", se, u(h(I)(e.row.totalAmount, 3) ?? "-"), 1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[b, x.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, me = Z(ie, [["__scopeId", "data-v-fd36ce34"]]);
export {
  me as default
};
