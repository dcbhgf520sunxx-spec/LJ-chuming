import { ref as k } from "vue";
import { inject as at } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as a } from "vue";
import { createBlock as v } from "vue";
import { withCtx as r } from "vue";
import { createVNode as c } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as i } from "vue";
import { createElementVNode as nt } from "vue";
import { unref as y } from "vue";
import { withDirectives as rt } from "vue";
import { createElementBlock as s } from "vue";
import { normalizeClass as lt } from "vue";
import { createCommentVNode as d } from "vue";
import { isRef as ut } from "vue";
import { ElTag as it } from "element-plus";
import { ElTableColumn as st } from "element-plus";
import { vLoading as ct } from "element-plus";
import { e as dt } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as wt, u as mt, p as ft, o as yt, D as h, bV as p, cO as Y, jl as z, bs as L, cH as _t } from "../../../../shared/runtime.js";
const ht = { class: "content-header" }, pt = { key: 0 }, gt = { key: 0 }, bt = { key: 0 }, Ct = { key: 0 }, xt = { key: 0 }, Rt = { key: 0 }, kt = { key: 0 }, Nt = { key: 0 }, vt = { key: 0, style: { color: "red" } }, Vt = { key: 1 }, Et = { key: 2 }, It = { key: 0, style: { color: "red" } }, At = { key: 1 }, Dt = { key: 0, style: { color: "red" } }, Lt = { key: 1 }, Tt = { key: 0 }, Ut = { key: 0 }, St = { __name: "gas-direct-cost", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(x, { emit: F }) {
  const O = F, T = x, U = k(), W = k(), V = k([]), E = k(false), g = at("query"), { visible: I, handleClose: G } = mt({ emit: O, props: T, showHook: X, closeHook: Z });
  ft(/* @__PURE__ */ new Date(), "{y}-{m}");
  const { maxHeight: J } = yt({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, U), K = k([["amortizationAmount", ["to-thousand", h.YUAN]], ["totalFee", ["to-thousand", h.YUAN]]]);
  async function Q() {
    var _;
    E.value = true;
    try {
      const f = { projectId: (_ = T.currentData) == null ? void 0 : _.projectId, boolTaxIncluded: g.boolTaxIncluded };
      (await dt(f)).forEach(async (o, e) => {
        var S, q, j, B, H, M;
        let m = 0, b = 0, C = 0, l = 0, t = [], u = [];
        (S = o.outboundList) != null && S.length ? (await Y(o.outboundList, { multipleSpec: true }), t = await z(o.outboundList, { toSmallest: false, toNum: true }, { quantity: ["quantityCount"], mete: ["meteCount"] }), m = t.reduce((n, w) => n + +w.meteCount, 0), b = t.reduce((n, w) => n + (g.boolTaxIncluded ? +w.amountCount : +w.amountExcludingVatCount), 0), t.forEach((n, w) => {
          n.index = w + 1;
        }), (t == null ? void 0 : t.length) > 0 && o.outboundList.push({ totalRow: true, type: "小计", meteCount: L(m, 3) || 0, amountCount: p(b, h.YUAN), amountExcludingVatCount: p(b, h.YUAN) })) : t = [], (q = o.returnList) != null && q.length ? (await Y(o.returnList, { multipleSpec: true }), u = await z(o.returnList, { toSmallest: false, toNum: true }, { quantity: ["quantityCount"], mete: ["meteCount"] }), u.forEach((n) => {
          n.meteCount = n.meteCount && -n.meteCount, n.amountCount = n.amountCount && -n.amountCount, n.amountExcludingVatCount = n.amountExcludingVatCount && -n.amountExcludingVatCount;
        }), C = u.reduce((n, w) => n + +w.meteCount, 0), l = u.reduce((n, w) => n + (g.boolTaxIncluded ? +w.amountCount : +w.amountExcludingVatCount), 0), u.forEach((n, w) => {
          n.index = w + 1;
        }), (u == null ? void 0 : u.length) > 0 && o.returnList.push({ totalRow: true, type: "小计", meteCount: L(C, 3) || 0, amountCount: p(l, h.YUAN), amountExcludingVatCount: p(l, h.YUAN) })) : o.returnList = [];
        const N = { index: _t(e + 1), titleRow: true, yearMonth: ((B = (j = o.outboundList) == null ? void 0 : j[0]) == null ? void 0 : B.yearMonth) || ((M = (H = o.returnList) == null ? void 0 : H[0]) == null ? void 0 : M.yearMonth) || "-" }, A = { totalRow: true, type: "月合计", meteCount: L(m + C, 3), amountCount: p(b + l, h.YUAN), amountExcludingVatCount: p(b + l, h.YUAN) }, ot = [N, ...o.outboundList || [], ...o.returnList || [], A];
        V.value.push(...ot);
      });
    } catch (f) {
      console.log(f);
    } finally {
      E.value = false;
    }
  }
  function X() {
    Q();
  }
  function Z() {
    V.value = [];
  }
  const $ = (_) => {
    const { columns: f, data: R } = _, o = [];
    return f.forEach((e, m) => {
      if (m === 0) {
        o[m] = "总合计";
        return;
      }
      if (["meteCount", "amountCount", "amountExcludingVatCount"].findIndex((l) => Array.isArray(l) ? l[0] === e.property : l === e.property) > -1) {
        const t = R.filter((u) => !u.titleRow && !u.totalRow).map((u) => Number(u[e.property]));
        t.every((u) => Number.isNaN(u)) ? o[m] = "" : (o[m] = t.reduce((u, N) => {
          const A = Number(N);
          return Number.isNaN(A) ? u : u + N;
        }, 0), (e.property === "amountCount" || e.property === "amountExcludingVatCount") && (o[m] = p(o[m], h.YUAN)));
      }
    }), o;
  };
  function tt({ row: _, rowIndex: f }) {
    return _.titleRow ? "fabricating-cost-statistics-title-row" : "";
  }
  function et({ row: _, rowIndex: f }) {
    return _.titleRow ? "fabricating-cost-statistics-title-row" : "";
  }
  return (_, f) => {
    const R = it, o = D("print-table"), e = st, m = D("common-table"), b = D("common-drawer"), C = ct;
    return a(), v(b, { ref_key: "drawerRef", ref: U, title: "气体直接成本", "close-on-click-modal": false, modelValue: y(I), "onUpdate:modelValue": f[0] || (f[0] = (l) => ut(I) ? I.value = l : null), direction: "rtl", "before-close": y(G), "wrapper-closable": false, "custom-class": "amount-detail", size: "70%" }, { titleAfter: r(() => [c(R, null, { default: r(() => {
      var l, t;
      return [P("项目：" + i(((l = x.currentData) == null ? void 0 : l.serialNumber) || "-") + " " + i(((t = x.currentData) == null ? void 0 : t.projectName) || "-"), 1)];
    }), _: 1 })]), content: r(() => {
      var l;
      return [nt("div", ht, [c(R, null, { default: r(() => [P("统计日期：" + i(x.timeInterval || "-"), 1)]), _: 1 }), c(o, { "api-key": "fabricatingCostStatisticsGasDirectCost", params: { projectId: (l = x.currentData) == null ? void 0 : l.projectId, boolTaxIncluded: y(g).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), rt((a(), v(m, { ref_key: "tableRef", ref: W, data: V.value, "max-height": y(J), "data-format": K.value, "summary-method": $, "show-summary": "", showEmptySymbol: false, stripe: false, "cell-class-name": et, "row-class-name": tt }, { default: r(() => [c(e, { prop: "index", key: "index", label: "序号", align: "center", fixed: "left" }), c(e, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "出/退库日期", align: "center" }, { default: r((t) => [t.row.totalRow ? d("", true) : (a(), s("span", { key: 0, class: lt([t.row.titleRow ? "blod" : ""]) }, i(t.row.yearMonth || "-"), 3))]), _: 1 }), c(e, { "show-overflow-tooltip": "", prop: "type", key: "type", label: "类型", align: "center" }, { default: r((t) => [t.row.titleRow ? d("", true) : (a(), s("span", pt, i(t.row.type || "-"), 1))]), _: 1 }), c(e, { "show-overflow-tooltip": "", prop: "classifyName", key: "classifyName", label: "物料种类", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", gt, i(t.row.classifyName || "-"), 1)) : d("", true)]), _: 1 }), c(e, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "规格", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", bt, i(t.row.specification || "-"), 1)) : d("", true)]), _: 1 }), c(e, { "show-overflow-tooltip": "", prop: "model", key: "model", label: "材质", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Ct, i(t.row.model || "-"), 1)) : d("", true)]), _: 1 }), c(e, { "show-overflow-tooltip": "", prop: "measureUnit", key: "measureUnit", label: "计量单位", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", xt, i(t.row.measureUnit || "-"), 1)) : d("", true)]), _: 1 }), c(e, { "show-overflow-tooltip": "", prop: "quantityCount", key: "quantityCount", label: "数量", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Rt, i(t.row.quantityCount || t.row.quantityCount === 0 ? t.row.quantityCount : "-"), 1)) : d("", true)]), _: 1 }), c(e, { "show-overflow-tooltip": "", prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", kt, i(t.row.accountingUnit || "-"), 1)) : d("", true)]), _: 1 }), c(e, { "show-overflow-tooltip": "", prop: "meteCount", key: "meteCount", label: "核算量", align: "center" }, { default: r((t) => [t.row.titleRow ? d("", true) : (a(), s("span", Nt, i(t.row.meteCount || t.row.meteCount === 0 ? t.row.meteCount : "-"), 1))]), _: 1 }), c(e, { "show-overflow-tooltip": "", prop: "unitPrice", key: "unitPrice", label: "单价(元)", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (a(), s("span", vt, " 未月末加权 ")) : !t.row.titleRow && !t.row.totalRow && y(g).boolTaxIncluded ? (a(), s("span", Vt, i(t.row.unitPrice || t.row.unitPrice === 0 ? y(p)(t.row.unitPrice, 3) : "-"), 1)) : !t.row.titleRow && !t.row.totalRow && !y(g).boolTaxIncluded ? (a(), s("span", Et, i(t.row.unitPriceExcludingVAT || t.row.unitPriceExcludingVAT === 0 ? y(p)(t.row.unitPriceExcludingVAT, 3) : "-"), 1)) : d("", true)]), _: 1 }), y(g).boolTaxIncluded ? (a(), v(e, { "show-overflow-tooltip": "", prop: "amountCount", key: "amountCount", label: "金额", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (a(), s("span", It, " 未月末加权 ")) : t.row.titleRow ? d("", true) : (a(), s("span", At, i(t.row.amountCount || t.row.amountCount === 0 ? t.row.amountCount : "-"), 1))]), _: 1 })) : d("", true), y(g).boolTaxIncluded ? d("", true) : (a(), v(e, { "show-overflow-tooltip": "", prop: "amountExcludingVatCount", key: "amountExcludingVatCount", label: "金额", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (a(), s("span", Dt, " 未月末加权 ")) : t.row.titleRow ? d("", true) : (a(), s("span", Lt, i(t.row.amountExcludingVatCount || t.row.amountExcludingVatCount === 0 ? t.row.amountExcludingVatCount : "-"), 1))]), _: 1 })), c(e, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "出/退库单据号", align: "center", width: "140px" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Tt, i(t.row.serialNumber || "-"), 1)) : d("", true)]), _: 1 }), c(e, { "show-overflow-tooltip": "", prop: "workshopName", key: "workshopName", label: "领用车间", align: "center" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Ut, i(t.row.workshopName || "-"), 1)) : d("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[C, E.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ht = wt(St, [["__scopeId", "data-v-9ef90134"]]);
export {
  Ht as default
};
