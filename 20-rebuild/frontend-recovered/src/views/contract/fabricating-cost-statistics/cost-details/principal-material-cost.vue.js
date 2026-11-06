import { ref as k } from "vue";
import { inject as rt } from "vue";
import { computed as lt } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as a } from "vue";
import { createBlock as v } from "vue";
import { withCtx as r } from "vue";
import { createVNode as c } from "vue";
import { createTextVNode as O } from "vue";
import { toDisplayString as i } from "vue";
import { createElementVNode as ut } from "vue";
import { unref as y } from "vue";
import { withDirectives as it } from "vue";
import { createElementBlock as s } from "vue";
import { normalizeClass as st } from "vue";
import { createCommentVNode as d } from "vue";
import { isRef as ct } from "vue";
import { ElTag as dt } from "element-plus";
import { ElTableColumn as wt } from "element-plus";
import { vLoading as mt } from "element-plus";
import { t as ft } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as yt, u as _t, p as pt, o as ht, jn as V, D as p, bs as E, bV as h, cO as z, jl as F, cH as bt } from "../../../../shared/runtime.js";
const Ct = { class: "content-header" }, gt = { key: 0 }, xt = { key: 0 }, Rt = { key: 0 }, kt = { key: 0 }, Et = { key: 0 }, Nt = { key: 0 }, vt = { key: 0 }, Vt = { key: 0 }, Tt = { key: 0, style: { color: "red" } }, It = { key: 1 }, Lt = { key: 2 }, At = { key: 0, style: { color: "red" } }, St = { key: 1 }, Ut = { key: 0, style: { color: "red" } }, Mt = { key: 1 }, Dt = { key: 0 }, qt = { key: 0 }, jt = { __name: "principal-material-cost", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(x, { emit: W }) {
  const G = W, T = x, M = k(), J = k(), I = k([]), L = k(false), b = rt("query"), { visible: A, handleClose: K } = _t({ emit: G, props: T, showHook: $, closeHook: tt });
  pt(/* @__PURE__ */ new Date(), "{y}-{m}");
  const { maxHeight: Q } = ht({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, M), D = lt(() => {
    var f;
    switch ((f = T.currentRow) == null ? void 0 : f.indexNumber) {
      case 11:
        return V.STEEL_PLATE.V;
      case 12:
        return V.SECTION_STEEL.V;
      case 13:
        return V.STEEL_COIL.V;
      case 15:
        return V.OTHER_STEEL.V;
      default:
        return "";
    }
  }), X = k([["amortizationAmount", ["to-thousand", p.YUAN]], ["totalFee", ["to-thousand", p.YUAN]]]);
  async function Z() {
    var f;
    L.value = true;
    try {
      const _ = { projectId: (f = T.currentData) == null ? void 0 : f.projectId, boolTaxIncluded: b.boolTaxIncluded, basicMaterialClassEnum: D.value };
      (await ft(_)).forEach(async (e, o) => {
        var q, j, B, H, P, Y;
        let w = 0, C = 0, g = 0, l = 0, t = [], u = [];
        (q = e.outboundList) != null && q.length ? (await z(e.returnList, { multipleSpec: true }), t = await F(e.outboundList, { toSmallest: false, toNum: true }, { quantity: ["quantityCount"], mete: ["meteCount"] }), w = t.reduce((n, m) => n + +m.meteCount, 0), C = t.reduce((n, m) => n + (b.boolTaxIncluded ? +m.amountCount : +m.amountExcludingVatCount), 0), t.forEach((n, m) => {
          n.index = m + 1;
        }), (t == null ? void 0 : t.length) > 0 && e.outboundList.push({ totalRow: true, type: "小计", meteCount: E(w, 3) || 0, amountCount: h(C, p.YUAN), amountExcludingVatCount: h(C, p.YUAN) })) : t = [], (j = e.returnList) != null && j.length ? (await z(e.returnList, { multipleSpec: true }), u = await F(e.returnList, { toSmallest: false, toNum: true }, { quantity: ["quantityCount"], mete: ["meteCount"] }), u.forEach((n) => {
          n.meteCount = n.meteCount && -n.meteCount, n.amountCount = n.amountCount && -n.amountCount, n.amountExcludingVatCount = n.amountExcludingVatCount && -n.amountExcludingVatCount;
        }), g = u.reduce((n, m) => n + +m.meteCount, 0), l = u.reduce((n, m) => n + (b.boolTaxIncluded ? +m.amountCount : +m.amountExcludingVatCount), 0), u.forEach((n, m) => {
          n.index = m + 1;
        }), (u == null ? void 0 : u.length) > 0 && e.returnList.push({ totalRow: true, type: "小计", meteCount: E(g, 3) || 0, amountCount: h(l, p.YUAN), amountExcludingVatCount: h(l, p.YUAN) })) : e.returnList = [];
        const N = { index: bt(o + 1), titleRow: true, yearMonth: ((H = (B = e.outboundList) == null ? void 0 : B[0]) == null ? void 0 : H.yearMonth) || ((Y = (P = e.returnList) == null ? void 0 : P[0]) == null ? void 0 : Y.yearMonth) || "-" }, S = { totalRow: true, type: "月合计", meteCount: E(w + g, 3), amountCount: h(C + l, p.YUAN), amountExcludingVatCount: h(C + l, p.YUAN) }, nt = [N, ...e.outboundList || [], ...e.returnList || [], S];
        I.value.push(...nt);
      });
    } catch (_) {
      console.log(_);
    } finally {
      L.value = false;
    }
  }
  function $() {
    Z();
  }
  function tt() {
    I.value = [];
  }
  const et = (f) => {
    const { columns: _, data: R } = f, e = [];
    return _.forEach((o, w) => {
      if (w === 0) {
        e[w] = "总合计";
        return;
      }
      if (["meteCount", "amountCount", "amountExcludingVatCount"].findIndex((l) => Array.isArray(l) ? l[0] === o.property : l === o.property) > -1) {
        const t = R.filter((u) => !u.titleRow && !u.totalRow).map((u) => Number(u[o.property]));
        t.every((u) => Number.isNaN(u)) ? e[w] = "" : (e[w] = t.reduce((u, N) => {
          const S = Number(N);
          return Number.isNaN(S) ? u : u + N;
        }, 0), (o.property === "amountCount" || o.property === "amountExcludingVatCount") && (e[w] = h(e[w], p.YUAN)), o.property === "meteCount" && (e[w] = E(e[w], 3)));
      }
    }), e;
  };
  function ot({ row: f, rowIndex: _ }) {
    return f.titleRow ? "fabricating-cost-statistics-title-row" : "";
  }
  function at({ row: f, rowIndex: _ }) {
    return f.titleRow ? "fabricating-cost-statistics-title-row" : "";
  }
  return (f, _) => {
    const R = dt, e = U("print-table"), o = wt, w = U("common-table"), C = U("common-drawer"), g = mt;
    return a(), v(C, { ref_key: "drawerRef", ref: M, modelValue: y(A), "onUpdate:modelValue": _[0] || (_[0] = (l) => ct(A) ? A.value = l : null), "before-close": y(K), "close-on-click-modal": false, "wrapper-closable": false, "custom-class": "amount-detail", direction: "rtl", size: "70%", title: "主材费明细" }, { titleAfter: r(() => [c(R, null, { default: r(() => {
      var l, t;
      return [O("项目：" + i(((l = x.currentData) == null ? void 0 : l.serialNumber) || "-") + " " + i(((t = x.currentData) == null ? void 0 : t.projectName) || "-"), 1)];
    }), _: 1 })]), content: r(() => {
      var l;
      return [ut("div", Ct, [c(R, null, { default: r(() => [O("统计日期：" + i(x.timeInterval || "-"), 1)]), _: 1 }), c(e, { params: { projectId: (l = x.currentData) == null ? void 0 : l.projectId, boolTaxIncluded: y(b).boolTaxIncluded, basicMaterialClassEnum: D.value }, "api-key": "mainMaterialsStatistics", size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), it((a(), v(w, { ref_key: "tableRef", ref: J, "cell-class-name": at, data: I.value, "data-format": X.value, "max-height": y(Q), "row-class-name": ot, showEmptySymbol: false, stripe: false, "summary-method": et, "show-summary": "" }, { default: r(() => [c(o, { key: "index", align: "center", fixed: "left", label: "序号", prop: "index" }), c(o, { key: "yearMonth", align: "center", label: "出/退库日期", prop: "yearMonth" }, { default: r((t) => [t.row.totalRow ? d("", true) : (a(), s("span", { key: 0, class: st([t.row.titleRow ? "blod" : ""]) }, i(t.row.yearMonth || "-"), 3))]), _: 1 }), c(o, { key: "type", align: "center", label: "类型", prop: "type", "show-overflow-tooltip": "" }, { default: r((t) => [t.row.titleRow ? d("", true) : (a(), s("span", gt, i(t.row.type || "-"), 1))]), _: 1 }), c(o, { key: "classifyName", align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", xt, i(t.row.classifyName || "-"), 1)) : d("", true)]), _: 1 }), c(o, { key: "specification", align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Rt, i(t.row.specification || "-"), 1)) : d("", true)]), _: 1 }), c(o, { key: "model", align: "center", label: "材质", prop: "model", "show-overflow-tooltip": "" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", kt, i(t.row.model || "-"), 1)) : d("", true)]), _: 1 }), c(o, { key: "measureUnit", align: "center", label: "计量单位", prop: "measureUnit", "show-overflow-tooltip": "" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Et, i(t.row.measureUnit || "-"), 1)) : d("", true)]), _: 1 }), c(o, { key: "quantityCount", align: "center", label: "数量", prop: "quantityCount", "show-overflow-tooltip": "" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Nt, i(t.row.quantityCount || t.row.quantityCount === 0 ? t.row.quantityCount : "-"), 1)) : d("", true)]), _: 1 }), c(o, { key: "accountingUnit", align: "center", label: "核算单位", prop: "accountingUnit", "show-overflow-tooltip": "" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", vt, i(t.row.accountingUnit || "-"), 1)) : d("", true)]), _: 1 }), c(o, { key: "meteCount", align: "center", label: "核算量", prop: "meteCount", "show-overflow-tooltip": "" }, { default: r((t) => [t.row.titleRow ? d("", true) : (a(), s("span", Vt, i(t.row.meteCount || t.row.meteCount === 0 ? y(E)(t.row.meteCount, 3) : "-"), 1))]), _: 1 }), c(o, { key: "unitPrice", align: "center", label: "单价(元)", prop: "unitPrice", "show-overflow-tooltip": "" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (a(), s("span", Tt, " 未月末加权 ")) : !t.row.titleRow && !t.row.totalRow && y(b).boolTaxIncluded ? (a(), s("span", It, i(t.row.unitPrice || t.row.unitPrice === 0 ? y(h)(t.row.unitPrice, 3) : "-"), 1)) : !t.row.titleRow && !t.row.totalRow && !y(b).boolTaxIncluded ? (a(), s("span", Lt, i(t.row.unitPriceExcludingVAT || t.row.unitPriceExcludingVAT === 0 ? y(h)(t.row.unitPriceExcludingVAT, 3) : "-"), 1)) : d("", true)]), _: 1 }), y(b).boolTaxIncluded ? (a(), v(o, { key: "amountCount", align: "center", label: "金额", prop: "amountCount", "show-overflow-tooltip": "" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (a(), s("span", At, " 未月末加权 ")) : t.row.titleRow ? d("", true) : (a(), s("span", St, i(t.row.amountCount || t.row.amountCount === 0 ? t.row.amountCount : "-"), 1))]), _: 1 })) : d("", true), y(b).boolTaxIncluded ? d("", true) : (a(), v(o, { key: "amountExcludingVatCount", align: "center", label: "金额", prop: "amountExcludingVatCount", "show-overflow-tooltip": "" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (a(), s("span", Ut, " 未月末加权 ")) : t.row.titleRow ? d("", true) : (a(), s("span", Mt, i(t.row.amountExcludingVatCount || t.row.amountExcludingVatCount === 0 ? t.row.amountExcludingVatCount : "-"), 1))]), _: 1 })), c(o, { key: "serialNumber", align: "center", label: "出/退库单据号", prop: "serialNumber", "show-overflow-tooltip": "", width: "140px" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", Dt, i(t.row.serialNumber || "-"), 1)) : d("", true)]), _: 1 }), c(o, { key: "workshopName", align: "center", label: "领用车间", prop: "workshopName", "show-overflow-tooltip": "" }, { default: r((t) => [!t.row.titleRow && !t.row.totalRow ? (a(), s("span", qt, i(t.row.workshopName || "-"), 1)) : d("", true)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[g, L.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Yt = yt(jt, [["__scopeId", "data-v-792dae10"]]);
export {
  Yt as default
};
