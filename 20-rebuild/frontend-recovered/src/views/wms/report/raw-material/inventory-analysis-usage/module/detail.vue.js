import { computed as f } from "vue";
import { inject as oe } from "vue";
import { ref as l } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as ie } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as v } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as s } from "vue";
import { unref as o } from "vue";
import { withModifiers as I } from "vue";
import { createTextVNode as g } from "vue";
import { withDirectives as U } from "vue";
import { toDisplayString as ne } from "vue";
import { createCommentVNode as le } from "vue";
import { ElInput as re } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { vLoading as ue } from "element-plus";
import { a as me, f as pe } from "../../../../../../modules/inventory-analysis-usage-4b0f952d.js";
import { _ as de, t as fe, jX as _e, bD as ve, vx as E, sQ as be, o as ye, u as Te, i as Ne, cO as he, jl as ge, pA as Ee, L as we, jG as xe, k5 as Re, jH as Oe, bl as Ve, k6 as De, ux as Ie, ba as Ue, D as y } from "../../../../../../shared/runtime.js";
const w = { BEGIN_PERIOD: { L: "期初数据", K: "BEGIN_PERIOD", V: 4 }, INBOUND: { L: "入库数据", K: "INBOUND", V: 1 }, TRANSFER: { L: "调拨数据", K: "TRANSFER", V: 3 }, OUTBOUND: { L: "出库数据", K: "OUTBOUND", V: 2 }, END_PERIOD: { L: "期末数据", K: "END_PERIOD", V: 5 } };
const Ce = { class: "head-container query-header filter-container" }, Be = { class: "filter-left-box" }, Le = { class: "filter-right-box" }, Pe = { __name: "detail", props: { visible: { type: Boolean, default: false }, date: { type: [Number, String], required: true }, formType: { type: [Number, void 0] }, materialInfo: { type: Object } }, emits: ["update:visible"], setup(C, { emit: B }) {
  const { decimalPrecision: p } = fe(), L = B, c = C, P = f(() => [..._e, ["invoiceType", ["parse-enum", ve, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", p.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", p.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", p.value.wms]], ["unitPriceNoFreight", ["to-thousand", p.value.wms]], ["receipt.receiptType", ["parse-enum", E]]]), S = oe("permission"), d = l(false), A = l(), M = l(), x = l([]), n = l(), k = l({}), u = l([]), i = l({ formType: w.BEGIN_PERIOD.V, specification: void 0 }), { baseUnit: T } = be(), { maxHeight: F } = ye({ mainBox: ".raw-mat-send-and-receive-storage-detail", extraBox: [".el-drawer__header", ".material-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, d), { visible: H, handleClose: j } = Te({ emit: L, props: c, field: "visible", showHook: q }), Y = f(() => "库存使用分析详情"), K = f(() => u.value && i.value.specification ? u.value.filter((t) => Ne(t.specMerge) && t.specMerge.indexOf(i.value.specification) > -1) : u.value), R = f(() => {
    var t;
    return { ids: (t = c.materialInfo) == null ? void 0 : t.idList, formType: i.value.formType };
  });
  function $() {
    k.value = {}, u.value = [], n.value = c.materialInfo, x.value.length = 0;
  }
  function G() {
    i.value.specification = void 0;
  }
  function q() {
    c.formType && (i.value.formType = c.formType), N();
  }
  async function N() {
    $();
    const t = { ...R.value };
    try {
      d.value = true;
      const e = await me(t);
      u.value = await z(e);
    } catch (e) {
      console.error(e);
    } finally {
      d.value = false;
    }
  }
  async function z(t) {
    return await he(t), await ge(t, { toSmallest: false, toNum: false }), t.forEach((e) => {
      e.specMerge = Ee(e);
    }), t;
  }
  function J(t) {
    const e = n.value.basicClass && T.value && T.value[n.value.basicClass] ? T.value[n.value.basicClass].measure.precision : 0;
    return Ue(t, { props: [["quantity", e], "mete", ["amount", y.YUAN], ["amountExcludingVAT", y.YUAN], ["inputVAT", y.YUAN], ["amountNoFreight", y.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight"] });
  }
  return (t, e) => {
    const Q = m("common-radio-button"), X = re, O = m("common-button"), W = m("table-cell-tag"), h = ce, Z = m("common-table"), ee = m("common-dialog"), te = ie("permission"), ae = ue;
    return _(), v(ee, { ref_key: "drawerRef", ref: A, "before-close": o(j), title: Y.value, visible: o(H), "custom-class": "raw-mat-send-and-receive-storage-detail", fullscreen: "", "show-close": "" }, { default: r(() => [b("div", Ce, [b("div", Be, [s(Q, { modelValue: i.value.formType, "onUpdate:modelValue": e[0] || (e[0] = (a) => i.value.formType = a), options: o(w), class: "filter-item", type: "enum", onChange: N }, null, 8, ["modelValue", "options"]), s(X, { modelValue: i.value.specification, "onUpdate:modelValue": e[1] || (e[1] = (a) => i.value.specification = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "规格", size: "default", style: { width: "250px" } }, null, 8, ["modelValue"]), s(O, { class: "filter-item", icon: "el-icon-search", size: "default", type: "success", onClick: I(N, ["stop"]) }, { default: r(() => e[3] || (e[3] = [g(" 搜索 ")])), _: 1, __: [3] }), s(O, { class: "filter-item", icon: "el-icon-refresh-left", size: "default", type: "warning", onClick: e[2] || (e[2] = I((a) => G(), ["stop"])) }, { default: r(() => e[4] || (e[4] = [g(" 重置 ")])), _: 1, __: [4] })]), b("div", Le, [U((_(), v(we, { fn: o(pe), params: { ids: R.value.ids }, "response-header-result": "" }, { default: r(() => e[5] || (e[5] = [g(" 下载库存使用分析详情 ")])), _: 1, __: [5] }, 8, ["fn", "params"])), [[te, o(S).get]])])]), U((_(), v(Z, { ref_key: "tableRef", ref: M, data: K.value, "data-format": P.value, "expand-row-keys": x.value, "max-height": o(F), "summary-method": J, "highlight-current-row": "", "row-key": "id", "show-summary": "" }, { default: r(() => [s(h, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: r(({ row: a, $index: se }) => {
      var V, D;
      return [s(W, { name: o(E).SUPPLEMENT.L, show: ((D = (V = a.sourceRow) == null ? void 0 : V.receipt) == null ? void 0 : D.receiptType) === o(E).SUPPLEMENT.V, type: "supplement" }, null, 8, ["name", "show"]), b("span", null, ne(se + 1), 1)];
    }), _: 1 }), s(xe, { "basic-class": n.value.basicClass, "show-index": false, "show-outbound-mode": i.value.formType === o(w).INBOUND.V, fixed: "left", "show-oddment-by-half-out": "", "spec-merge": "" }, null, 8, ["basic-class", "show-outbound-mode"]), s(Re, { "basic-class": n.value.basicClass }, null, 8, ["basic-class"]), s(Oe, { "basic-class": n.value.basicClass & o(Ve).STEEL_COIL.V ? "" : n.value.basicClass }, null, 8, ["basic-class"]), s(De, { "show-project": "" }), s(h, { key: "receipt.receiptType", align: "center", label: "类型", prop: "receipt.receiptType", "show-overflow-tooltip": "", width: "70" }), s(h, { key: "receipt", align: "center", label: "单据编号", "min-width": "120", prop: "receipt", "show-overflow-tooltip": "" }, { default: r(({ row: { sourceRow: a } }) => [a != null && a.receipt ? (_(), v(o(Ie), { key: 0, receipt: a == null ? void 0 : a.receipt, "receipt-types": ["INBOUND", "OUTBOUND", "FOR_SALE", "OUTSOURCE", "SCRAPS", "TEMPORARY_LOAN", "TRANSFER", "RETURN", "REJECTED", "SUPPLEMENT", "CONVERT", "ADJUST", "INVENTORY_LOSS", "MOVING_INVENTORY", "INVENTORY_PROFIT", "MODAL_SHIFT"] }, null, 8, ["receipt"])) : le("", true)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])), [[ae, d.value]])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, ke = de(Pe, [["__scopeId", "data-v-31508b64"]]);
export {
  ke as default
};
