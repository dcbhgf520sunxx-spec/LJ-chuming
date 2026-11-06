import { inject as P } from "vue";
import { computed as re } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as de } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as l } from "vue";
import { withCtx as c } from "vue";
import { unref as t } from "vue";
import { createBlock as m } from "vue";
import { createCommentVNode as C } from "vue";
import { withDirectives as me } from "vue";
import { createElementVNode as N } from "vue";
import { toDisplayString as p } from "vue";
import { normalizeClass as ge } from "vue";
import { mergeProps as he } from "vue";
import { isRef as M } from "vue";
import { Fragment as pe } from "vue";
import { reactive as fe } from "vue";
import { watchEffect as ye } from "vue";
import { watch as q } from "vue";
import { ElTableColumn as be } from "element-plus";
import { ElTooltip as _e } from "element-plus";
import { Edit as Ve } from "@element-plus/icons-vue";
import { ElInput as ke } from "element-plus";
import { am as ve, sQ as qe, v7 as S, v8 as Te, c9 as V, uY as We, bR as w, v6 as Re, i as T, iX as W, D as Ue, aw as xe, aI as Pe, sT as Ce, b as Ne, uZ as Me } from "../../../../../../../../shared/runtime.js";
const Se = { key: 1 }, we = { key: 1 }, De = { key: 1 }, Ee = { key: 1 }, Le = { key: 1 }, ze = { __name: "steel-plate-table", setup(Ie, { expose: D }) {
  var x;
  const g = ve.STEEL_PLATE.V, R = P("matSpecRef"), n = (x = P("cu")) == null ? void 0 : x.form, { baseUnit: o } = qe(g), { handleMeteChangeCalcPrice: E } = Me("weighingTotalWeight"), { overDiffTip: L, weightOverDiff: I, currentCfg: f } = S(o, { cfgType: "purchase", weightField: "weighingTotalWeight", compareWeightField: "purchaseTotalWeight", weightTip: "申购重量" }), { overDiffTip: B, weightOverDiff: $, diffSubmitValidate: z } = S(o), { specSelectMaxHeight: F, specRef: O, drawerRef: A, editRow: Y, editList: k, materialSelectVisible: _, handleClickEditSpec: K, handleSpecChange: Q } = Te(), X = (e, s) => T(s.weighingTotalWeight) && T(s.unitPrice) ? +W(s.weighingTotalWeight * s.unitPrice, Ue.YUAN) == +e : false, j = re(() => ({ classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: V, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: V, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: n.useRequisitions ? null : z, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: V, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: V, message: "长度必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: X, message: "金额有误，请手动修改", trigger: "blur" }] })), { tableValidate: H, wrongCellMask: Z } = xe({ rules: j, errorMsg: "请修正【钢板清单】中标红的信息" });
  function G(e) {
    const s = fe({ uid: Pe(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0 });
    return U(s), s;
  }
  function U(e) {
    ye(() => {
      n.useRequisitions ? I(e) : $(e);
    }), q([() => e.weighingTotalWeight], () => E(e)), q([() => e.length, () => e.width, () => e.thickness, o], () => J(e)), q([() => e.theoryWeight, () => e.quantity], () => {
      ee(e);
    });
  }
  async function J(e) {
    e.theoryWeight = await Ce({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness });
  }
  function ee(e) {
    T(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = W(e.theoryWeight * e.quantity, o.value.weight.precision), e.weighingTotalWeight = W(e.theoryWeight * e.quantity, o.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function te(e, s) {
    R.value ? R.value.delListItem(e, s) : n.steelPlateList.splice(s, 1);
  }
  function ie() {
    if (Ne(n.steelPlateList)) return true;
    const { validResult: e, dealList: s } = H(n.steelPlateList);
    return n.steelPlateList = s, e;
  }
  return D({ rowInit: G, rowWatch: U, validate: ie }), (e, s) => {
    const u = be, v = _e, ae = Ve, y = b("common-input-number"), le = ke, ne = b("common-radio-button"), se = b("common-button"), oe = b("common-table"), ce = b("common-drawer"), ue = de("empty-text");
    return r(), h(pe, null, [l(oe, he(e.$attrs, { data: t(n).steelPlateList, "cell-class-name": t(Z), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: c(() => [l(u, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), t(n).useRequisitions ? (r(), m(u, { key: 0, label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" })) : C("", true), l(u, { prop: "serialNumber", label: "编号", align: "center", fixed: "left" }), l(u, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: c(({ row: i }) => [l(v, { content: i.classifyParentFullName, disabled: !i.classifyParentFullName, "show-after": 500, placement: "top" }, { default: c(() => [me(N("span", null, null, 512), [[ue, i.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(u, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: c(({ row: i }) => {
      var a;
      return [((a = t(f)) == null ? void 0 : a.spec) & t(g) ? (r(), m(ae, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (d) => t(K)(i) }, null, 8, ["onClick"])) : C("", true), l(v, { content: i.specificationLabels, placement: "top" }, { default: c(() => [N("span", null, p(i.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), l(u, { prop: "thickness", align: "center", label: `厚 (${t(o).thickness.unit})`, "min-width": "120" }, { default: c(({ row: i }) => {
      var a;
      return [!t(n).useRequisitions || t(n).useRequisitions && ((a = t(f)) == null ? void 0 : a.thickness) & t(g) ? (r(), m(y, { key: 0, modelValue: i.thickness, "onUpdate:modelValue": (d) => i.thickness = d, min: 0, max: 999999, "controls-position": "right", controls: false, precision: t(o).thickness.precision, size: "default", placeholder: "厚" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (r(), h("span", Se, p(i.thickness), 1))];
    }), _: 1 }, 8, ["label"]), l(u, { prop: "width", align: "center", label: `宽 (${t(o).width.unit})`, "min-width": "120" }, { default: c(({ row: i }) => {
      var a;
      return [!t(n).useRequisitions || t(n).useRequisitions && ((a = t(f)) == null ? void 0 : a.width) & t(g) ? (r(), m(y, { key: 0, modelValue: i.width, "onUpdate:modelValue": (d) => i.width = d, min: 0, max: 999999, "controls-position": "right", controls: false, precision: t(o).width.precision, size: "default", placeholder: "宽" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (r(), h("span", we, p(i.width), 1))];
    }), _: 1 }, 8, ["label"]), l(u, { prop: "length", align: "center", label: `长 (${t(o).length.unit})`, "min-width": "120" }, { default: c(({ row: i }) => {
      var a;
      return [!t(n).useRequisitions || t(n).useRequisitions && ((a = t(f)) == null ? void 0 : a.length) & t(g) ? (r(), m(y, { key: 0, modelValue: i.length, "onUpdate:modelValue": (d) => i.length = d, max: 999999999, controls: false, min: 0, precision: t(o).length.precision, size: "default", placeholder: "长" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (r(), h("span", De, p(i.length), 1))];
    }), _: 1 }, 8, ["label"]), l(u, { prop: "quantity", align: "center", label: `数量 (${t(o).measure.unit})`, "min-width": "120" }, { default: c(({ row: i }) => {
      var a;
      return [!t(n).useRequisitions || t(n).useRequisitions && ((a = t(f)) == null ? void 0 : a.quantity) & t(g) ? (r(), m(y, { key: 0, modelValue: i.quantity, "onUpdate:modelValue": (d) => i.quantity = d, min: 1, max: t(n).useRequisitions ? i.canPurchaseQuantity : 999999999, "controls-position": "right", controls: false, step: 1, precision: t(o).measure.precision, size: "default", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])) : (r(), h("span", Ee, p(i.quantity), 1))];
    }), _: 1 }, 8, ["label"]), l(u, { key: "weighingTotalWeight", prop: "weighingTotalWeight", align: "center", label: `总重 (${t(o).weight.unit})`, "min-width": "135" }, { default: c(({ row: i }) => [t(n).useRequisitions ? (r(), h("span", Le, p(i.weighingTotalWeight || "-"), 1)) : (r(), m(v, { key: 0, class: "item", effect: "dark", content: t(n).useRequisitions ? `申购重量：${i.purchaseTotalWeight} kg， ${t(L)}` : `理论重量：${i.theoryTotalWeight} kg， ${t(B)}`, disabled: !i.hasOver, placement: "top" }, { default: c(() => [l(y, { modelValue: i.weighingTotalWeight, "onUpdate:modelValue": (a) => i.weighingTotalWeight = a, min: 0, max: 999999999, "controls-position": "right", controls: false, precision: t(o).weight.precision, size: "default", placeholder: "重量", class: ge({ "over-weight-tip": i.hasOver }) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "class"])]), _: 2 }, 1032, ["content", "disabled"]))]), _: 1 }, 8, ["label"]), l(We), l(u, { prop: "brand", label: "品牌", align: "center" }, { default: c(({ row: i }) => [l(le, { modelValue: i.brand, "onUpdate:modelValue": (a) => i.brand = a, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(u, { prop: "weightMeasurementMode", label: "计量方式", align: "center", width: "140px" }, { default: c(({ row: i }) => [l(ne, { modelValue: i.weightMeasurementMode, "onUpdate:modelValue": (a) => i.weightMeasurementMode = a, options: t(w).ENUM, type: "enum", "unshow-val": [t(w).MIXTURE.V], default: "", props: { key: "K", label: "SL", value: "V" }, size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshow-val"])]), _: 1 }), l(u, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: c(({ row: i, $index: a }) => [l(se, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (d) => te(i.sn, a) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]), l(ce, { ref_key: "drawerRef", ref: A, modelValue: t(_), "onUpdate:modelValue": s[1] || (s[1] = (i) => M(_) ? _.value = i : null), title: "钢材规格选择", "show-close": true, size: 900, "custom-class": "material-spec-select" }, { content: c(() => [l(Re, { ref_key: "specRef", ref: O, modelValue: t(k), "onUpdate:modelValue": s[0] || (s[0] = (i) => M(k) ? k.value = i : null), visible: t(_), classifyId: t(Y).classifyId, "show-classify": false, mode: "selector", "max-height": t(F), "expand-query": "", onChange: t(Q) }, null, 8, ["modelValue", "visible", "classifyId", "max-height", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  ze as default
};
