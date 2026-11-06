import { useStore as ue } from "vuex";
import { inject as ie } from "vue";
import { computed as r } from "vue";
import { ref as x } from "vue";
import { watch as de } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as c } from "vue";
import { createBlock as v } from "vue";
import { withCtx as u } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as Y } from "vue";
import { unref as f } from "vue";
import { createElementVNode as D } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as T } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as re } from "vue";
import { isRef as ce } from "vue";
import { ElTableColumn as me } from "element-plus";
import { ElTag as pe } from "element-plus";
import { ElCheckbox as fe } from "element-plus";
import { _ as he, t as xe, jX as ve, bD as _e, D as l, jY as ge, gS as Ae, G as be, jZ as we, o as Ne, u as ye, xo as je, V as Ve, k0 as L, xl as Te, w5 as _, i as B, cO as Ee, jl as ke, xm as Se, xn as Ce, aR as Ue, jG as Fe, jH as Pe, k5 as Re, jI as Ie, k6 as Ye, j$ as $, xp as De, iX as k, ba as Le, jN as Be } from "../../../../../shared/runtime.js";
const $e = { style: "width:800px;padding-right:20px;padding-left:20px;", class: "mtb-10" }, Oe = { key: 1 }, We = { key: 1 }, He = { __name: "adjust-form", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["success", "update:modelValue"], setup(O, { emit: W }) {
  const H = ue(), { decimalPrecision: m } = xe(), S = W, w = O, G = ie("permission"), z = r(() => [...ve, ["invoiceType", ["parse-enum", _e, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", m.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", m.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", m.value.wms]], ["unitPriceNoFreight", ["to-thousand", m.value.wms]], ["amount", ["to-thousand", l.YUAN]], ["amountExcludingVAT", ["to-thousand", l.YUAN]], ["amountNoFreight", ["to-thousand", l.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", l.YUAN]], ["inputVAT", ["to-thousand", l.YUAN]], ["inputVATNoFreight", ["to-thousand", l.YUAN]], ["remark", "empty-text"]]), q = r(() => [["unitPrice", ["to-thousand", m.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", m.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", m.value.wms]], ["unitPriceNoFreight", ["to-thousand", m.value.wms]], ["amount", ["to-thousand", l.YUAN]], ["amountExcludingVAT", ["to-thousand", l.YUAN]], ["amountNoFreight", ["to-thousand", l.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", l.YUAN]], ["inputVAT", ["to-thousand", l.YUAN]], ["inputVATNoFreight", ["to-thousand", l.YUAN]], ["createTime", ["parse-time"]]]), M = x(), h = x(false), N = x(false), g = x([]), K = x(), s = x({}), { inboundFillWayCfg: C } = ge(), X = r(() => C.value ? C.value.amountFillWay === Ae.REVIEWING.V : false), y = r(() => be(G.showAmount) || X.value), U = x(false), j = r(() => {
    var e;
    return ((e = s.value) == null ? void 0 : e.supplyType) === we.PARTY_A.V;
  }), p = r(() => s.value.purchaseOrder || {}), Z = r(() => h.value ? "入库单金额调整" : `入库单：${s.value.serialNumber}（ ${p.value.supplier ? p.value.supplier.name : "无供应商"} ）金额调整`), J = r(() => {
    const e = y.value && !j.value && (p.value.projects && p.value.requisitionsSN || U.value), t = y.value && j.value && p.value.projects && p.value.requisitionsSN && U.value;
    return !(e || t);
  }), { maxHeight: Q } = Ne({ mainBox: ".raw-mat-inbound-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => r(() => !h.value)), { visible: V, handleClose: F } = ye({ emit: S, props: w });
  de(() => w.data, async (e) => {
    ee(), e && e.id && (K.value = e.id, h.value = true, te(e.id));
  }, { immediate: true, deep: true });
  function ee() {
    h.value = false, N.value = false, g.value = [], s.value = { list: [] };
  }
  async function te(e) {
    if (!e) {
      s.value.list = [];
      return;
    }
    try {
      h.value = true, s.value = await je(e), s.value.originList = Ve(s.value.list), s.value.list = s.value.originList.filter((t) => t.qualityTestingEnum & (L.ALL_PASS.V | L.NO.V) && t.rejectStatus === Te.NONE.V), s.value.list.forEach((t) => {
        var i;
        t.uncheckAble = ((i = t.adjustDetailList) == null ? void 0 : i.findIndex((n) => n.reviewStatus === _.UNREVIEWED.V)) > -1, t.tagShow = B(t.adjustDetailList) ? t.uncheckAble ? "调整待审" : "调整" + (t.adjustDetailList[0].reviewStatus === _.PASS.V ? "过" : "驳回") : "", t.tagColor = B(t.adjustDetailList) ? t.uncheckAble ? "#409EFF" : _.V[t.adjustDetailList[0].reviewStatus].O_COLOR : "";
      }), await Ee(s.value.list), s.value.list = await ke(s.value.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
    } catch (t) {
      console.log("加载失败", t);
    } finally {
      h.value = false;
    }
  }
  async function ae() {
    try {
      N.value = true;
      const e = s.value.list.filter((i) => i.checked && i.adjustAmount), t = [];
      e.forEach((i) => {
        t.push({ amount: i.adjustAmount, amountExcludingVat: i.adjustAmountNoTax, inboundDetailId: i.id, inboundId: w.data.id, inputVat: i.adjustTax });
      }), await De(t), await H.dispatch("approval_list/fetchApprovalNum"), F(), S("success");
    } catch (e) {
      console.log("通过提交", e);
    } finally {
      N.value = false;
    }
  }
  function P(e) {
    s.value.inboundWay === $.OPENING_RECEIPT.V ? e.adjustAmount && e.adjustAmountNoTax ? e.adjustTax = k(e.adjustAmount - (e.adjustAmountNoTax || 0), l.YUAN) : e.adjustTax = 0 : e.adjustAmount ? (e.adjustAmountNoTax = e.taxRate ? k(e.adjustAmount / (1 + e.taxRate / 100), l.YUAN) : e.adjustAmount, e.adjustTax = k(e.adjustAmount - (e.adjustAmountNoTax || 0), l.YUAN)) : (e.adjustAmountNoTax = 0, e.adjustTax = 0);
  }
  function oe(e) {
    return Le(e, { props: ["quantity", ["mete", Be.weight.precision], ["amount", l.YUAN]], toThousandFields: ["mete", "amount"] });
  }
  return (e, t) => {
    const i = A("common-button"), n = me, se = pe, R = A("common-table"), le = fe, I = A("common-input-number"), ne = A("common-drawer");
    return c(), v(ne, { ref_key: "drawerRef", ref: M, modelValue: f(V), "onUpdate:modelValue": t[1] || (t[1] = (a) => ce(V) ? V.value = a : null), "before-close": f(F), "content-loading": h.value, "show-close": true, title: Z.value, "custom-class": "raw-mat-inbound-application-review-form", size: "100%" }, { titleAfter: u(() => [o(Se, { detail: s.value, order: p.value }, null, 8, ["detail", "order"]), o(Ce, { "purchase-id": p.value.id, size: "default" }, null, 8, ["purchase-id"])]), titleRight: u(() => [o(i, { size: "default", type: "primary", onClick: ae }, { default: u(() => t[2] || (t[2] = [Y("发起审批")])), _: 1, __: [2] })]), content: u(() => [o(R, { data: s.value.list, "data-format": z.value, "expand-row-keys": g.value, "max-height": f(Q), "summary-method": oe, "row-key": "id", "show-summary": "" }, { default: u(() => [o(Ue, { "expand-row-keys": g.value, "onUpdate:expandRowKeys": t[0] || (t[0] = (a) => g.value = a), data: s.value.list, stripe: false, fixed: "left", "row-key": "id", style: { background: "#f4f4f5" } }, { default: u(({ row: { sourceRow: a } }) => [D("div", $e, [(c(), v(R, { key: a.id, data: a.adjustDetailList, "data-format": q.value, "header-cell-style": { background: "#f0f9eb !important" }, stripe: false, style: { "margin-bottom": "10px" } }, { default: u(() => [o(n, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), o(n, { align: "center", label: "历史调整" }, { default: u(() => [o(n, { align: "left", label: "含税金额", "min-width": "120px", prop: "Amount", "show-overflow-tooltip": "" }), o(n, { align: "left", label: "不含税金额", "min-width": "120px", prop: "AmountExcludingVat", "show-overflow-tooltip": "" }), o(n, { align: "left", label: "税额", "min-width": "120px", prop: "inputVat", "show-overflow-tooltip": "" })]), _: 1 }), o(n, { label: "状态", prop: "reviewStatus" }, { default: u(({ row: d }) => [o(se, { type: f(_).V[d.reviewStatus].TAG }, { default: u(() => [Y(b(f(_).VL[d.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 2 }, 1024), o(n, { align: "center", label: "调整日期", "min-width": "120px", prop: "createTime", "show-overflow-tooltip": "" }), o(n, { align: "center", label: "调整单号", prop: "serialNumber", "show-overflow-tooltip": "", width: "120px" })]), _: 2 }, 1032, ["data", "data-format"]))])]), _: 1 }, 8, ["expand-row-keys", "data"]), o(n, { align: "center", label: "序号", type: "index", width: "55" }, { default: u(({ row: a, $index: d }) => [D("span", null, b(d + 1), 1)]), _: 1 }), o(Fe, { "basic-class": s.value.basicClass, showIndex: false }, null, 8, ["basic-class"]), o(Pe, { "basic-class": s.value.basicClass }, null, 8, ["basic-class"]), J.value ? (c(), v(Re, { key: 0, "basic-class": s.value.basicClass }, null, 8, ["basic-class"])) : T("", true), y.value ? (c(), E(re, { key: 1 }, [j.value ? T("", true) : (c(), v(Ie, { key: 0, showFreight: false }))], 64)) : T("", true), o(n, { align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" }), o(Ye), o(n, { align: "center", fixed: "right", label: "价格调整", prop: "checked", "show-overflow-tooltip": "", width: "100px" }, { default: u(({ row: { sourceRow: a } }) => [o(le, { modelValue: a.checked, "onUpdate:modelValue": (d) => a.checked = d, disabled: a.uncheckAble }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), o(n, { fixed: "right", label: "本次调整", width: "420px" }, { default: u(() => [o(n, { align: "left", label: "含税金额", prop: "adjustAmount", "show-overflow-tooltip": "", width: "150px" }, { default: u(({ row: { sourceRow: a } }) => [a.checked ? (c(), v(I, { key: 0, modelValue: a.adjustAmount, "onUpdate:modelValue": (d) => a.adjustAmount = d, controls: false, max: 9999999999, min: a.adjustAmountNoTax ? a.adjustAmountNoTax : 0, precision: f(l).YUAN, step: 1, placeholder: "含税金额", size: "default", onChange: (d) => P(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "min", "precision", "onChange"])) : (c(), E("span", Oe, b(a.adjustAmount || "-"), 1))]), _: 1 }), o(n, { align: "left", label: "不含税金额", prop: "adjustAmountNoTax", "show-overflow-tooltip": "", width: "150px" }, { default: u(({ row: { sourceRow: a } }) => [a.checked && s.value.inboundWay === f($).OPENING_RECEIPT.V ? (c(), v(I, { key: 0, modelValue: a.adjustAmountNoTax, "onUpdate:modelValue": (d) => a.adjustAmountNoTax = d, controls: false, max: a.adjustAmount ? a.adjustAmount : 9999999999, min: 0, precision: f(l).YUAN, step: 1, placeholder: "不含税金额", size: "default", onChange: (d) => P(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : (c(), E("span", We, b(a.adjustAmountNoTax || "-"), 1))]), _: 1 }), o(n, { align: "left", label: "进项税", prop: "adjustTax", "show-overflow-tooltip": "", width: "120px" })]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close", "content-loading", "title"]);
  };
} }, qe = he(He, [["__scopeId", "data-v-c231b3c3"]]);
export {
  qe as default
};
