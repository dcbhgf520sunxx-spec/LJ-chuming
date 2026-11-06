import { ref as k } from "vue";
import { inject as at } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as a } from "vue";
import { createBlock as V } from "vue";
import { withCtx as r } from "vue";
import { createVNode as c } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as i } from "vue";
import { createElementVNode as nt } from "vue";
import { unref as f } from "vue";
import { withDirectives as rt } from "vue";
import { createElementBlock as s } from "vue";
import { normalizeClass as lt } from "vue";
import { createCommentVNode as d } from "vue";
import { isRef as ut } from "vue";
import { ElTag as it } from "element-plus";
import { ElTableColumn as st } from "element-plus";
import { vLoading as ct } from "element-plus";
import { o as dt } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as wt, u as mt, p as ft, o as yt, D as p, bs as N, bV as h, cO as Y, jl as z, cH as _t } from "../../../../shared/runtime.js";
const pt = { class: "content-header" }, ht = { key: 0 }, bt = { key: 0 }, gt = { key: 0 }, Ct = { key: 0 }, xt = { key: 0 }, Rt = { key: 0 }, kt = { key: 0 }, Nt = { key: 0 }, vt = { key: 0, style: { color: "red" } }, Vt = { key: 1 }, Et = { key: 2 }, It = { key: 0, style: { color: "red" } }, At = { key: 1 }, Dt = { key: 0, style: { color: "red" } }, Lt = { key: 1 }, Tt = { key: 0 }, Ut = { key: 0 }, St = { __name: "material-direct-cost", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(x, { emit: F }) {
  const O = F, T = x, U = k(), W = k(), E = k([]), I = k(false), b = at("query"), { visible: A, handleClose: G } = mt({ emit: O, props: T, showHook: X, closeHook: Z });
  ft(/* @__PURE__ */ new Date(), "{y}-{m}");
  const { maxHeight: J } = yt({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, U), K = k([["amortizationAmount", ["to-thousand", p.YUAN]], ["totalFee", ["to-thousand", p.YUAN]]]);
  async function Q() {
    var _;
    I.value = true;
    try {
      const y = { projectId: (_ = T.currentData) == null ? void 0 : _.projectId, boolTaxIncluded: b.boolTaxIncluded };
      (await dt(y)).forEach(async (e, o) => {
        var S, q, M, j, B, H;
        let w = 0, g = 0, C = 0, l = 0, t = [], u = [];
        (S = e.outboundList) != null && S.length ? (await Y(e.outboundList, { multipleSpec: true }), t = await z(e.outboundList, { toSmallest: false, toNum: true }, { quantity: ["quantityCount"], mete: ["meteCount"] }), w = t.reduce((n, m) => n + +m.meteCount, 0), g = t.reduce((n, m) => n + (b.boolTaxIncluded ? +m.amountCount : +m.amountExcludingVatCount), 0), t.forEach((n, m) => {
          n.index = m + 1;
        }), (t == null ? void 0 : t.length) > 0 && e.outboundList.push({ totalRow: true, type: "小计", meteCount: N(w, 3) || 0, amountCount: h(g, p.YUAN), amountExcludingVatCount: h(g, p.YUAN) })) : t = [], (q = e.returnList) != null && q.length ? (await Y(e.returnList, { multipleSpec: true }), u = await z(e.returnList, { toSmallest: false, toNum: true }, { quantity: ["quantityCount"], mete: ["meteCount"] }), u.forEach((n) => {
          n.meteCount = n.meteCount && -n.meteCount, n.amountCount = n.amountCount && -n.amountCount, n.amountExcludingVatCount = n.amountExcludingVatCount && -n.amountExcludingVatCount;
        }), C = u.reduce((n, m) => n + +m.meteCount, 0), l = u.reduce((n, m) => n + (b.boolTaxIncluded ? +m.amountCount : +m.amountExcludingVatCount), 0), u.forEach((n, m) => {
          n.index = m + 1;
        }), (u == null ? void 0 : u.length) > 0 && e.returnList.push({ totalRow: true, type: "小计", meteCount: N(C, 3) || 0, amountCount: h(l, p.YUAN), amountExcludingVatCount: h(l, p.YUAN) })) : e.returnList = [];
        const v = { index: _t(o + 1), titleRow: true, yearMonth: ((j = (M = e.outboundList) == null ? void 0 : M[0]) == null ? void 0 : j.yearMonth) || ((H = (B = e.returnList) == null ? void 0 : B[0]) == null ? void 0 : H.yearMonth) || "-" }, D = { totalRow: true, type: "月合计", meteCount: N(w + C, 3), amountCount: h(g + l, p.YUAN), amountExcludingVatCount: h(g + l, p.YUAN) }, ot = [v, ...e.outboundList || [], ...e.returnList || [], D];
        E.value.push(...ot);
      });
    } catch (y) {
      console.log(y);
    } finally {
      I.value = false;
    }
  }
  function X() {
    Q();
  }
  function Z() {
    E.value = [];
  }
  const $ = (_) => {
    const { columns: y, data: R } = _, e = [];
    return y.forEach((o, w) => {
      if (w === 0) {
        e[w] = "总合计";
        return;
      }
      if (["meteCount", "amountCount", "amountExcludingVatCount"].findIndex((l) => Array.isArray(l) ? l[0] === o.property : l === o.property) > -1) {
        const t = R.filter((u) => !u.titleRow && !u.totalRow).map((u) => Number(u[o.property]));
        t.every((u) => Number.isNaN(u)) ? e[w] = "" : (e[w] = t.reduce((u, v) => {
          const D = Number(v);
          return Number.isNaN(D) ? u : u + v;
        }, 0), (o.property === "amountCount" || o.property === "amountExcludingVatCount") && (e[w] = h(e[w], p.YUAN)), o.property === "meteCount" && (e[w] = N(e[w], 3)));
      }
    }), e;
  };
  function tt({ row: _, rowIndex: y }) {
    return _.titleRow ? "fabricating-cost-statistics-title-row" : "";
  }
  function et({ row: _, rowIndex: y }) {
    return _.titleRow ? "fabricating-cost-statistics-title-row" : "";
  }
  return (_, y) => {
    const R = it, e = L("print-table"), o = st, w = L("common-table"), g = L("common-drawer"), C = ct;
    return a(), V(g, { ref_key: "drawerRef", ref: U, title: "辅材直接成本", "close-on-click-modal": false, modelValue: f(A), "onUpdate:modelValue": y[0] || (y[0] = (l) => ut(A) ? A.value = l : null), direction: "rtl", "before-close": f(G), "wrapper-closable": false, "custom-class": "amount-detail", size: "70%" }, { titleAfter: r(() => [c(R, null, { default: r(() => {
      var l, t;
      return [P("项目：" + i(((l = x.currentData) == null ? void 0 : l.serialNumber) || "-") + " " + i(((t = x.currentData) == null ? void 0 : t.projectName) || "-"), 1)];
    }), _: 1 })]), content: r(() => {
      var l;
      return [nt("div", pt, [c(R, null, { default: r(() => [P("统计日期：" + i(x.timeInterval || "-"), 1)]), _: 1 }), c(e, { "api-key": "auxiliaryMaterialsDirectCost", params: { projectId: (l = x.currentData) == null ? void 0 : l.projectId, boolTaxIncluded: f(b).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), rt((a(), V(w, { ref_key: "tableRef", ref: W, data: E.value, "max-height": f(J), "data-format": K.value, "summary-method": $, "show-summary": "", showEmptySymbol: false, stripe: false, "cell-class-name": et, "row-class-name": tt }, { default: r(() => [c(o, { prop: "index", key: "index", label: "序号", align: "center", fixed: "left" }), c(o, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "出/退库日期", align: "center" }, { default: r((t) => [t.row.totalRow ? d("", true) : (a(), s("span", { key: 0, class: lt([t.row.titleRow ? "blod" : ""]) }, i(t.row.yearMonth || "-"), 3))]), _: 1 }), c(o, { "show-overflow-tooltip": "", prop: "type", key: "type", label: "类型", align: "center" }, { default: r((t) => [t.row.titleRow ? d("", true) : (a(), s("span", ht, i(t.row.type || "-"), 1))]), _: 1 }), c(o, { "show-overflow-tooltip": "", prop: "classifyName", key: "classifyName", label: "物料种类", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", bt, i(t.row.classifyName || "-"), 1)) : d("", true)]), _: 1 }), c(o, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "规格", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", gt, i(t.row.specification || "-"), 1)) : d("", true)]), _: 1 }), c(o, { "show-overflow-tooltip": "", prop: "model", key: "model", label: "材质", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Ct, i(t.row.model || "-"), 1)) : d("", true)]), _: 1 }), c(o, { "show-overflow-tooltip": "", prop: "measureUnit", key: "measureUnit", label: "计量单位", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", xt, i(t.row.measureUnit || "-"), 1)) : d("", true)]), _: 1 }), c(o, { "show-overflow-tooltip": "", prop: "quantityCount", key: "quantityCount", label: "数量", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Rt, i(t.row.quantityCount || t.row.quantityCount === 0 ? t.row.quantityCount : "-"), 1)) : d("", true)]), _: 1 }), c(o, { "show-overflow-tooltip": "", prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", kt, i(t.row.accountingUnit || "-"), 1)) : d("", true)]), _: 1 }), c(o, { "show-overflow-tooltip": "", prop: "meteCount", key: "meteCount", label: "核算量", align: "center" }, { default: r((t) => [t.row.titleRow ? d("", true) : (a(), s("span", Nt, i(t.row.meteCount || t.row.meteCount === 0 ? f(N)(t.row.meteCount, 3) : "-"), 1))]), _: 1 }), c(o, { "show-overflow-tooltip": "", prop: "unitPrice", key: "unitPrice", label: "单价(元)", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (a(), s("span", vt, " 未月末加权 ")) : !t.row.titleRow && !t.row.totalRow && f(b).boolTaxIncluded ? (a(), s("span", Vt, i(t.row.unitPrice || t.row.unitPrice === 0 ? f(h)(t.row.unitPrice, 3) : "-"), 1)) : !t.row.titleRow && !t.row.totalRow && !f(b).boolTaxIncluded ? (a(), s("span", Et, i(t.row.unitPriceExcludingVAT || t.row.unitPriceExcludingVAT === 0 ? f(h)(t.row.unitPriceExcludingVAT, 3) : "-"), 1)) : d("", true)]), _: 1 }), f(b).boolTaxIncluded ? (a(), V(o, { "show-overflow-tooltip": "", prop: "amountCount", key: "amountCount", label: "金额", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (a(), s("span", It, " 未月末加权 ")) : t.row.titleRow ? d("", true) : (a(), s("span", At, i(t.row.amountCount || t.row.amountCount === 0 ? t.row.amountCount : "-"), 1))]), _: 1 })) : d("", true), f(b).boolTaxIncluded ? d("", true) : (a(), V(o, { "show-overflow-tooltip": "", prop: "amountExcludingVatCount", key: "amountExcludingVatCount", label: "金额", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (a(), s("span", Dt, " 未月末加权 ")) : t.row.titleRow ? d("", true) : (a(), s("span", Lt, i(t.row.amountExcludingVatCount || t.row.amountExcludingVatCount === 0 ? t.row.amountExcludingVatCount : "-"), 1))]), _: 1 })), c(o, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "出/退库单据号", align: "center", width: "140px" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Tt, i(t.row.serialNumber || "-"), 1)) : d("", true)]), _: 1 }), c(o, { "show-overflow-tooltip": "", prop: "workshopName", key: "workshopName", label: "领用车间", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Ut, i(t.row.workshopName || "-"), 1)) : d("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[C, I.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Bt = wt(St, [["__scopeId", "data-v-a5b4ae3a"]]);
export {
  Bt as default
};
