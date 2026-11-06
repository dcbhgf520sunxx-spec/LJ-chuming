import { inject as U } from "vue";
import { computed as ge } from "vue";
import { resolveComponent as d } from "vue";
import { resolveDirective as de } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as a } from "vue";
import { withCtx as o } from "vue";
import { unref as i } from "vue";
import { createBlock as m } from "vue";
import { createCommentVNode as x } from "vue";
import { withDirectives as me } from "vue";
import { createElementVNode as N } from "vue";
import { toDisplayString as y } from "vue";
import { normalizeClass as he } from "vue";
import { mergeProps as pe } from "vue";
import { isRef as M } from "vue";
import { Fragment as fe } from "vue";
import { reactive as ye } from "vue";
import { watchEffect as be } from "vue";
import { watch as b } from "vue";
import { ElTableColumn as _e } from "element-plus";
import { ElTooltip as ve } from "element-plus";
import { Edit as We } from "@element-plus/icons-vue";
import { ElInput as Ve } from "element-plus";
import { am as qe, sQ as Te, v7 as L, v8 as Se, c9 as T, uY as ke, bR as P, v6 as Re, i as _, iX as S, D as Ce, aw as Ue, aI as xe, sU as Ne, v9 as Me, b as Le, uZ as Pe } from "../../../../../../../../shared/runtime.js";
const De = { key: 1 }, Ee = { key: 1 }, Ie = { key: 1 }, ze = { __name: "section-steel-table", setup($e, { expose: D }) {
  var C;
  const h = qe.SECTION_STEEL.V, k = U("matSpecRef"), n = (C = U("cu")) == null ? void 0 : C.form;
  console.log(n);
  const { baseUnit: c } = Te(h), { overDiffTip: E, weightOverDiff: I, currentCfg: v } = L(c, { cfgType: "purchase", weightField: "weighingTotalWeight", compareWeightField: "purchaseTotalWeight", weightTip: "申购重量" }), { overDiffTip: $, weightOverDiff: B, diffSubmitValidate: O } = L(c), { specSelectMaxHeight: z, specRef: F, drawerRef: Y, editRow: w, editList: W, materialSelectVisible: p, handleClickEditSpec: A, handleSpecChange: K } = Se(), Q = (e, l) => _(l.weighingTotalWeight) && _(l.unitPrice) ? +S(l.weighingTotalWeight * l.unitPrice, Ce.YUAN) == +e : false, X = ge(() => ({ classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { pattern: T, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: T, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: n.useRequisitions ? null : O, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: T, message: "重量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: Q, message: "金额有误，请手动修改", trigger: "blur" }] })), { handleMeteChangeCalcPrice: j } = Pe("weighingTotalWeight"), { tableValidate: H, wrongCellMask: Z } = Ue({ rules: X, errorMsg: "请修正【型材清单】中标红的信息" });
  function G(e) {
    const l = ye({ uid: xe(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, unitWeight: e.unitWeight, quantity: void 0, length: void 0, totalLength: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, hasOver: false });
    return R(l), l;
  }
  function R(e) {
    be(() => {
      n.useRequisitions ? I(e) : B(e);
    }), b([() => e.length, () => e.unitWeight, c], () => J(e)), b([() => e.theoryWeight, () => e.quantity], () => {
      te(e);
    }), b([() => e.length, () => e.quantity], () => {
      ee(e);
    }), b([() => e.weighingTotalWeight], () => j(e));
  }
  async function J(e) {
    e.theoryWeight = await Ne({ length: e.length, unitWeight: e.unitWeight });
  }
  function ee(e) {
    _(e.length) && e.quantity ? e.totalLength = Me({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
  }
  function te(e) {
    _(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = S(e.theoryWeight * e.quantity, c.value.weight.precision), e.weighingTotalWeight = S(e.theoryWeight * e.quantity, c.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function ie(e, l) {
    k.value ? k.value.delListItem(e, l) : n.sectionSteelList.splice(l, 1);
  }
  function ae() {
    if (Le(n.sectionSteelList)) return true;
    const { validResult: e, dealList: l } = H(n.sectionSteelList);
    return n.sectionSteelList = l, e;
  }
  return D({ rowInit: G, rowWatch: R, validate: ae }), (e, l) => {
    const u = _e, V = ve, ne = We, q = d("common-input-number"), le = Ve, se = d("common-radio-button"), oe = d("common-button"), ue = d("common-table"), ce = d("common-drawer"), re = de("empty-text");
    return r(), f(fe, null, [a(ue, pe(e.$attrs, { data: i(n).sectionSteelList, "cell-class-name": i(Z), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: o(() => [a(u, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), i(n).useRequisitions ? (r(), m(u, { key: 0, label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" })) : x("", true), a(u, { prop: "serialNumber", label: "编号", align: "center", fixed: "left" }), a(u, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [a(V, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: o(() => [me(N("span", null, null, 512), [[re, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(u, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "", "min-width": "140" }, { default: o(({ row: t }) => {
      var s;
      return [!i(n).useRequisitions || i(n).useRequisitions && ((s = i(v)) == null ? void 0 : s.spec) & i(h) ? (r(), m(ne, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (g) => i(A)(t) }, null, 8, ["onClick"])) : x("", true), a(V, { content: t.specificationLabels, placement: "top" }, { default: o(() => [N("span", null, y(t.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), a(u, { prop: "length", align: "center", label: `定尺长度 (${i(c).length.unit})`, "min-width": "120" }, { default: o(({ row: t }) => {
      var s;
      return [!i(n).useRequisitions || i(n).useRequisitions && ((s = i(v)) == null ? void 0 : s.length) & i(h) ? (r(), m(q, { key: 0, modelValue: t.length, "onUpdate:modelValue": (g) => t.length = g, max: 999999999, controls: false, min: 0, precision: i(c).length.precision, size: "default", placeholder: "长" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (r(), f("span", De, y(t.length), 1))];
    }), _: 1 }, 8, ["label"]), a(u, { prop: "quantity", align: "center", label: `数量 (${i(c).measure.unit})`, "min-width": "120" }, { default: o(({ row: t }) => {
      var s;
      return [!i(n).useRequisitions || i(n).useRequisitions && ((s = i(v)) == null ? void 0 : s.quantity) & i(h) ? (r(), m(q, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (g) => t.quantity = g, min: 1, max: i(n).useRequisitions ? t.canPurchaseQuantity : 999999999, "controls-position": "right", controls: false, step: 5, precision: i(c).measure.precision, size: "default", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])) : (r(), f("span", Ee, y(t.quantity), 1))];
    }), _: 1 }, 8, ["label"]), a(u, { prop: "totalLength", align: "center", label: "总长度 (m)", "min-width": "120" }), a(u, { key: "weighingTotalWeight", prop: "weighingTotalWeight", align: "center", label: `总重 (${i(c).weight.unit})`, "min-width": "135" }, { default: o(({ row: t }) => [i(n).useRequisitions ? (r(), f("span", Ie, y(t.weighingTotalWeight || "-"), 1)) : (r(), m(V, { key: 0, class: "item", effect: "dark", content: `单位重量：${t.unitWeight} kg/m， ${i(n).useRequisitions ? `申购重量：${t.purchaseTotalWeight} kg， ${i(E)}` : `理论重量：${t.theoryTotalWeight} kg， ${i($)}`}`, disabled: !t.hasOver, placement: "top" }, { default: o(() => [a(q, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (s) => t.weighingTotalWeight = s, min: 0, max: 999999999, "controls-position": "right", controls: false, precision: i(c).weight.precision, size: "default", placeholder: "重量", class: he({ "over-weight-tip": t.hasOver }) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "class"])]), _: 2 }, 1032, ["content", "disabled"]))]), _: 1 }, 8, ["label"]), a(ke), a(u, { prop: "brand", label: "品牌", align: "center" }, { default: o(({ row: t }) => [a(le, { modelValue: t.brand, "onUpdate:modelValue": (s) => t.brand = s, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(u, { prop: "weightMeasurementMode", label: "计量方式", align: "center", width: "140px" }, { default: o(({ row: t }) => [a(se, { modelValue: t.weightMeasurementMode, "onUpdate:modelValue": (s) => t.weightMeasurementMode = s, options: i(P).ENUM, type: "enum", "unshow-val": [i(P).MIXTURE.V], default: "", props: { key: "K", label: "SL", value: "V" }, size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshow-val"])]), _: 1 }), a(u, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: o(({ row: t, $index: s }) => [a(oe, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (g) => ie(t.sn, s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]), a(ce, { ref_key: "drawerRef", ref: Y, modelValue: i(p), "onUpdate:modelValue": l[1] || (l[1] = (t) => M(p) ? p.value = t : null), title: "型材规格选择", "show-close": true, size: 900, "custom-class": "material-spec-select" }, { content: o(() => [a(Re, { ref_key: "specRef", ref: F, modelValue: i(W), "onUpdate:modelValue": l[0] || (l[0] = (t) => M(W) ? W.value = t : null), visible: i(p), classifyId: i(w).classifyId, "show-classify": false, mode: "selector", "max-height": i(z), "expand-query": "", onChange: i(K) }, null, 8, ["modelValue", "visible", "classifyId", "max-height", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  ze as default
};
