import { inject as Te } from "vue";
import { ref as Ce } from "vue";
import { computed as Ne } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as Pe } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as a } from "vue";
import { withCtx as o } from "vue";
import { createBlock as v } from "vue";
import { createCommentVNode as V } from "vue";
import { unref as l } from "vue";
import { createElementVNode as x } from "vue";
import { withDirectives as E } from "vue";
import { toDisplayString as b } from "vue";
import { Fragment as U } from "vue";
import { normalizeClass as K } from "vue";
import { createTextVNode as A } from "vue";
import { mergeProps as Ie } from "vue";
import { isRef as J } from "vue";
import { reactive as H } from "vue";
import { watchEffect as Ue } from "vue";
import { watch as z } from "vue";
import { ElTableColumn as Ae } from "element-plus";
import { ElInput as Le } from "element-plus";
import { ElTooltip as Re } from "element-plus";
import { Edit as Oe } from "@element-plus/icons-vue";
import { am as $e, sQ as qe, tC as Be, v7 as De, v8 as Ee, aR as ze, i as k, yt as Me, uY as je, v6 as we, c9 as M, aw as Qe, aI as X, sU as Fe, v9 as Ye, iX as j, D as G, b as Ke } from "../../../../../../../shared/runtime.js";
import { u as Je } from "../../../../../../../modules/use-over-receive-ba08adae.js";
import He from "../../components/inbound-quantity-column.vue.js";
const Xe = { class: "mtb-10" }, Ge = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px" } }, Ze = { class: "color-green" }, et = { class: "color-green" }, tt = { key: 1 }, lt = { key: 1 }, at = { key: 1 }, it = { key: 1 }, dt = { __name: "section-steel-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false } }, setup(w, { expose: Z }) {
  const c = w, S = $e.SECTION_STEEL.V, L = Te("matSpecRef"), { baseUnit: r } = qe(S), { cu: p, form: u } = Be(), R = Ce([]), { overDiffTip: Q, weightOverDiff: ee, diffSubmitValidate: te, currentCfg: O } = De(r), { handleOverQuantity: le, handleOverMete: ae } = Je({ meteField: "weighingTotalWeight" }), { specSelectMaxHeight: ie, specRef: ne, drawerRef: se, editRow: oe, editList: $, materialSelectVisible: C, handleClickEditSpec: ce, handleSpecChange: ue } = Ee(), de = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { pattern: M, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: M, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: te, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: M, message: "重量必须大于0", trigger: "blur" }] }, re = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, n) => k(n.weighingTotalWeight) && k(n.unitPrice) ? +j(n.weighingTotalWeight * n.unitPrice, G.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }] }, ge = Ne(() => {
    let e = Object.assign({}, de);
    return !c.boolPartyA && c.fillableAmount && (e = Object.assign(e, re)), e;
  }), { tableValidate: me, wrongCellMask: pe } = Qe({ rules: ge, errorMsg: "请修正【型材清单】中标红的信息" });
  function he(e, n) {
    return !!e.canPurchaseQuantity || true;
  }
  function fe(e, n) {
    const i = e.findIndex((h) => h.id === n.id) !== -1;
    u.selectObj[n.mergeId].isSelected = i;
  }
  function be(e) {
    const n = !!(e != null && e.length);
    u.sectionSteelList.forEach((i) => {
      u.selectObj[i.mergeId].isSelected = n;
    });
  }
  function ye({ row: e, rowIndex: n }) {
    var i, h;
    if ((h = (i = p == null ? void 0 : p.submitResult) == null ? void 0 : i.data) != null && h.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function _e(e) {
    const n = H({ uid: X(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifySerialNumber: e.classify.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, unitWeight: e.unitWeight, quantity: void 0, length: void 0, totalLength: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, hasOver: false });
    return !c.boolPartyA && c.fillableAmount && (n.unitPrice = void 0, n.amount = void 0), q(n), n;
  }
  function q(e) {
    Ue(() => ee(e)), z([() => e.length, () => e.unitWeight, r], () => ve(e)), z([() => e.theoryWeight, () => e.quantity], () => {
      ke(e), B(e);
    }), z([() => e.length, () => e.quantity], () => {
      xe(e);
    });
  }
  async function ve(e) {
    e.theoryWeight = await Fe({ length: e.length, unitWeight: e.unitWeight });
  }
  function xe(e) {
    k(e.length) && e.quantity ? e.totalLength = Ye({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
  }
  function ke(e) {
    k(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = e.theoryWeight * e.quantity, e.weighingTotalWeight = j(e.theoryWeight * e.quantity)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function B(e) {
    k(e.unitPrice) && k(e.weighingTotalWeight) && (e.amount = j(e.weighingTotalWeight * e.unitPrice, G.YUAN));
  }
  function Ve(e, n, i) {
    var h, f, _, N;
    if ((f = (h = p == null ? void 0 : p.submitResult) == null ? void 0 : h.data) != null && f.includes(i.classifyId)) {
      const P = (_ = p == null ? void 0 : p.submitResult) == null ? void 0 : _.data.findIndex((W) => W === i.classifyId);
      u.sectionSteelList.filter((W) => W.classifyId === i.classifyId).length === 1 && ((N = p == null ? void 0 : p.submitResult) == null || N.data.splice(P, 1));
    }
    L.value ? L.value.delListItem(e, n) : u.sectionSteelList.splice(n, 1);
  }
  function Se(e, n) {
    const i = H(JSON.parse(JSON.stringify(e)));
    i.uid = X(), u.sectionSteelList.push(i), q(i), L.value.initSelected([i]);
  }
  function We() {
    if (Ke(u.sectionSteelList)) return true;
    const { validResult: e, dealList: n } = me(u.sectionSteelList);
    return u.sectionSteelList = n, e;
  }
  return Z({ rowInit: _e, rowWatch: q, validate: We }), (e, n) => {
    const i = Ae, h = Le, f = Re, _ = I("common-input-number"), N = Oe, P = I("common-button"), F = I("common-table"), W = I("common-drawer"), D = Pe("empty-text");
    return d(), y(U, null, [a(F, Ie({ ref: "tableRef", "cell-class-name": l(pe), data: l(u).sectionSteelList, "expand-row-keys": R.value, "row-style": ye, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs, { onSelect: fe, onSelectAll: be }), { default: o(() => [!c.boolPartyA && !c.noDetail ? (d(), v(i, { key: 0, selectable: he, align: "center", type: "selection", width: "55" })) : V("", true), a(ze, { "expand-row-keys": R.value, "onUpdate:expandRowKeys": n[0] || (n[0] = (t) => R.value = t), data: l(u).sectionSteelList, "row-key": "uid" }, { default: o(({ row: t }) => [x("div", Xe, [a(h, { modelValue: t.remark, "onUpdate:modelValue": (s) => t.remark = s, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), l(k)(t.inboundList) ? (d(), y("div", Ge, [a(l(Me), { "basic-class": l(S), list: t.inboundList, material: t, stripe: false, style: { width: "1600px" } }, null, 8, ["basic-class", "list", "material"])])) : V("", true)]), _: 1 }, 8, ["expand-row-keys", "data"]), a(i, { align: "center", label: "序号", type: "index", width: "60" }), a(i, { align: "center", label: "编号", "min-width": "110px", prop: "serialNumber" }), a(i, { "sort-by": ["serialNumber"], align: "center", label: "物料种类", "min-width": "120", prop: "classifyName", "show-overflow-tooltip": "", sortable: "" }, { default: o(({ row: t }) => [a(f, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: o(() => [E(x("span", null, null, 512), [[D, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(i, { align: "center", label: "规格", "min-width": "200px", prop: "specification", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [a(f, { content: t.specificationLabels, placement: "top" }, { default: o(() => [x("span", null, b(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), a(i, { label: `定尺长度 (${l(r).length.unit})`, align: "center", "min-width": "135px", prop: "length" }, { default: o(({ row: t }) => [a(_, { modelValue: t.length, "onUpdate:modelValue": (s) => t.length = s, controls: false, max: 999999, min: 0, precision: l(r).length.precision, size: "default", placeholder: "长" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), c.boolPartyA || c.noDetail ? (d(), y(U, { key: 1 }, [a(i, { label: `数量 (${l(r).measure.unit})`, align: "center", "min-width": "135px", prop: "quantity" }, { default: o(({ row: t }) => [a(_, { modelValue: t.quantity, "onUpdate:modelValue": (s) => t.quantity = s, controls: false, max: 999999999, min: 1, precision: l(r).measure.precision, size: "default", step: 5, "controls-position": "right", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), a(i, { label: "总长度 (m)", align: "center", "min-width": "135px", prop: "totalLength" }), a(i, { key: "weighingTotalWeight", label: `总重 (${l(r).weight.unit})`, align: "center", "min-width": "135px", prop: "weighingTotalWeight" }, { default: o(({ row: t }) => [a(f, { content: `单位重量：${t.unitWeight} kg/m， 理论重量：${t.theoryTotalWeight} kg， ${l(Q)}`, disabled: !t.hasOver, class: "item", effect: "dark", placement: "top" }, { default: o(() => [a(_, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (s) => t.weighingTotalWeight = s, class: K({ "over-weight-tip": t.hasOver }), controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, size: "default", "controls-position": "right", placeholder: "重量", onChange: (s) => B(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onChange"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["label"])], 64)) : (d(), y(U, { key: 2 }, [a(i, { label: `采购数量 (${l(r).measure.unit})`, align: "right", "min-width": "100px", prop: "purchaseQuantity" }, { default: o(({ row: t }) => [x("span", null, [a(f, { content: "已入库数量", effect: "dark", placement: "top" }, { default: o(() => [x("span", Ze, b(t.inboundQuantity), 1)]), _: 2 }, 1024), A(" / " + b(t.purchaseQuantity), 1)])]), _: 1 }, 8, ["label"]), a(i, { label: `采购重量 (${l(r).weight.unit})`, align: "right", "min-width": "110px", prop: "purchaseMete" }, { default: o(({ row: t }) => [x("span", null, [a(f, { content: "已入库量", effect: "dark", placement: "top" }, { default: o(() => [x("span", et, b(t.inboundMete), 1)]), _: 2 }, 1024), A(" / " + b(t.purchaseMete), 1)])]), _: 1 }, 8, ["label"])], 64)), !c.boolPartyA && w.fillableAmount ? (d(), v(je, { key: 3 })) : V("", true), a(i, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }, { default: o(({ row: t }) => {
      var s, g;
      return [c.boolPartyA || c.noDetail || !c.boolPartyA && !c.noDetail && ((g = (s = l(u).selectObj) == null ? void 0 : s[t.mergeId]) != null && g.isSelected) ? (d(), v(h, { key: 0, modelValue: t.brand, "onUpdate:modelValue": (m) => t.brand = m, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : E((d(), y("span", tt, [A(b(t.brand), 1)])), [[D]])];
    }), _: 1 }), a(i, { align: "center", label: "炉批号", "min-width": "150px", prop: "heatNoAndBatchNo" }, { default: o(({ row: t }) => {
      var s, g;
      return [c.boolPartyA || c.noDetail || !c.boolPartyA && !c.noDetail && ((g = (s = l(u).selectObj) == null ? void 0 : s[t.mergeId]) != null && g.isSelected) ? (d(), v(h, { key: 0, modelValue: t.heatNoAndBatchNo, "onUpdate:modelValue": (m) => t.heatNoAndBatchNo = m, modelModifiers: { trim: true }, size: "default", placeholder: "炉批号", maxlength: "200" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : E((d(), y("span", lt, [A(b(t.heatNoAndBatchNo), 1)])), [[D]])];
    }), _: 1 }), !c.boolPartyA && !c.noDetail ? (d(), y(U, { key: 4 }, [a(l(He), { "base-unit": l(r), "basic-class": l(S), "current-cfg": l(O), form: l(u), handleOverQuantity: l(le) }, { editColumn: o(({ row: t }) => [a(i, { align: "center", label: "规格", "min-width": "200px", prop: "specification", "show-overflow-tooltip": "" }, { default: o(({ row: s }) => {
      var g, m, T;
      return [(m = (g = l(u).selectObj) == null ? void 0 : g[t.mergeId]) != null && m.isSelected && ((T = l(O)) == null ? void 0 : T.spec) & l(S) ? (d(), v(N, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Y) => l(ce)(s) }, null, 8, ["onClick"])) : V("", true), a(f, { content: s.specificationLabels, placement: "top" }, { default: o(() => [x("span", null, b(s.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 2 }, 1024), a(i, { label: `定尺长度 (${l(r).length.unit})`, align: "center", "min-width": "100px", prop: "length" }, { default: o(({ row: s }) => {
      var g, m, T;
      return [c.boolPartyA || c.noDetail || (m = (g = l(u).selectObj) == null ? void 0 : g[t.mergeId]) != null && m.isSelected && ((T = l(O)) == null ? void 0 : T.length) & l(S) ? (d(), v(_, { key: 0, modelValue: s.length, "onUpdate:modelValue": (Y) => s.length = Y, controls: false, max: 999999999, min: 0, precision: l(r).length.precision, size: "default", placeholder: "长" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (d(), y("span", at, b(s.length), 1))];
    }), _: 2 }, 1032, ["label"])]), _: 1 }, 8, ["base-unit", "basic-class", "current-cfg", "form", "handleOverQuantity"]), a(i, { label: "实收总长度 (m)", align: "center", "min-width": "135px", prop: "totalLength" }), a(i, { label: `理论重量 (${l(r).weight.unit})`, align: "center", "min-width": "100px", prop: "theoryTotalWeight" }, null, 8, ["label"]), a(i, { key: "weighingTotalWeight", label: `实收量 (${l(r).weight.unit})`, align: "center", "min-width": "135px", prop: "weighingTotalWeight" }, { default: o(({ row: t }) => [a(f, { content: `单位重量：${t.unitWeight} kg/m， 理论重量：${t.theoryTotalWeight} kg， ${l(Q)}`, disabled: !t.hasOver, class: "item", effect: "dark", placement: "top" }, { default: o(() => {
      var s, g;
      return [(g = (s = l(u).selectObj) == null ? void 0 : s[t.mergeId]) != null && g.isSelected ? (d(), v(_, { key: 0, modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (m) => t.weighingTotalWeight = m, class: K({ "over-weight-tip": t.hasOver }), controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, size: "default", "controls-position": "right", placeholder: "实收量", onBlur: (m) => l(ae)(t), onChange: (m) => B(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onBlur", "onChange"])) : (d(), y("span", it, b(t.weighingTotalWeight || "-"), 1))];
    }), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["label"])], 64)) : V("", true), c.boolPartyA || c.noDetail ? (d(), v(i, { key: 5, align: "center", fixed: "right", label: "操作", width: "160" }, { default: o(({ row: t, $index: s }) => [a(P, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (g) => Se(t, s) }, null, 8, ["onClick"]), a(P, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (g) => Ve(t.sn, s, t) }, null, 8, ["onClick"])]), _: 1 })) : V("", true)]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]), a(W, { ref_key: "drawerRef", ref: se, modelValue: l(C), "onUpdate:modelValue": n[2] || (n[2] = (t) => J(C) ? C.value = t : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "型材规格选择" }, { content: o(() => [a(we, { ref_key: "specRef", ref: ne, modelValue: l($), "onUpdate:modelValue": n[1] || (n[1] = (t) => J($) ? $.value = t : null), classifyId: l(oe).classifyId, "max-height": l(ie), "show-classify": false, visible: l(C), "expand-query": "", mode: "selector", onChange: l(ue) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  dt as default
};
