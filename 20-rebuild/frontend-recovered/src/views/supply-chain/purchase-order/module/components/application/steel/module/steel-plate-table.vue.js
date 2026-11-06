import { inject as U } from "vue";
import { computed as me } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as ge } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as l } from "vue";
import { withCtx as r } from "vue";
import { unref as i } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as L } from "vue";
import { withDirectives as he } from "vue";
import { createElementVNode as D } from "vue";
import { toDisplayString as _ } from "vue";
import { normalizeClass as pe } from "vue";
import { mergeProps as fe } from "vue";
import { isRef as E } from "vue";
import { Fragment as ye } from "vue";
import { reactive as be } from "vue";
import { watchEffect as _e } from "vue";
import { watch as P } from "vue";
import { ElTableColumn as Ve } from "element-plus";
import { ElTooltip as ke } from "element-plus";
import { Edit as ve } from "@element-plus/icons-vue";
import { ElInput as qe } from "element-plus";
import { am as Re, sQ as Te, v7 as B, v8 as We, c9 as q, uY as xe, bR as $, v6 as Ue, i as C, iX as N, D as Pe, aw as Ce, aI as Ne, sT as Se, b as Ie, uZ as Me } from "../../../../../../../../shared/runtime.js";
const we = { key: 1 }, Le = { key: 1 }, De = { key: 1 }, Ee = { key: 1 }, Be = { key: 1 }, Oe = { __name: "steel-plate-table", setup($e, { expose: z }) {
  var M;
  const y = Re.STEEL_PLATE.V, S = U("matSpecRef"), s = (M = U("cu")) == null ? void 0 : M.form, u = U("cu"), { baseUnit: c } = Te(y), { handleMeteChangeCalcPrice: F } = Me("weighingTotalWeight"), { overDiffTip: O, weightOverDiff: A, currentCfg: V } = B(c, { cfgType: "purchase", weightField: "weighingTotalWeight", compareWeightField: "purchaseTotalWeight", weightTip: "申购重量" }), { overDiffTip: Y, weightOverDiff: K, diffSubmitValidate: Q } = B(c), { specSelectMaxHeight: X, specRef: j, drawerRef: H, editRow: Z, editList: W, materialSelectVisible: R, handleClickEditSpec: G, handleSpecChange: J } = We(), ee = (e, o) => C(o.weighingTotalWeight) && C(o.unitPrice) ? +N(o.weighingTotalWeight * o.unitPrice, Pe.YUAN) == +e : false, te = me(() => ({ classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: q, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: q, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: s.useRequisitions ? null : Q, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: q, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: q, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: q, message: "数量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: ee, message: "金额有误，请手动修改", trigger: "blur" }] })), { tableValidate: ie, wrongCellMask: ae } = Ce({ rules: te, errorMsg: "请修正【钢板清单】中标红的信息" });
  function le({ row: e, rowIndex: o }) {
    var n, m, p;
    if ((m = (n = u == null ? void 0 : u.submitResult) == null ? void 0 : n.data) != null && m.includes(e.classifyId) && ((p = u == null ? void 0 : u.submitResult) == null ? void 0 : p.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  function se(e) {
    const o = be({ uid: Ne(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, classifySerialNumber: e.classify.serialNumber, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0 });
    return I(o), o;
  }
  function I(e) {
    _e(() => {
      s.useRequisitions ? A(e) : K(e);
    }), P([() => e.weighingTotalWeight], () => F(e)), P([() => e.length, () => e.width, () => e.thickness, c], () => ne(e)), P([() => e.theoryWeight, () => e.quantity], () => {
      oe(e);
    });
  }
  async function ne(e) {
    e.theoryWeight = await Se({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness });
  }
  function oe(e) {
    C(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = N(e.theoryWeight * e.quantity, c.value.weight.precision), e.weighingTotalWeight = N(e.theoryWeight * e.quantity, c.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function ue(e, o, n) {
    var m, p, h, T;
    if ((p = (m = u == null ? void 0 : u.submitResult) == null ? void 0 : m.data) != null && p.includes(n.classifyId)) {
      const x = (h = u == null ? void 0 : u.submitResult) == null ? void 0 : h.data.findIndex((k) => k === n.classifyId);
      s.steelPlateList.filter((k) => k.classifyId === n.classifyId).length === 1 && ((T = u == null ? void 0 : u.submitResult) == null || T.data.splice(x, 1));
    }
    S.value ? S.value.delListItem(e, o) : s.steelPlateList.splice(o, 1);
  }
  function ce() {
    if (Ie(s.steelPlateList)) return true;
    const { validResult: e, dealList: o } = ie(s.steelPlateList);
    return s.steelPlateList = o, e;
  }
  return z({ rowInit: se, rowWatch: I, validate: ce }), (e, o) => {
    const n = Ve, m = ke, p = ve, h = v("common-input-number"), T = qe, x = v("common-radio-button"), w = v("common-button"), k = v("common-table"), re = v("common-drawer"), de = ge("empty-text");
    return d(), b(ye, null, [l(k, fe({ "cell-class-name": i(ae), data: i(s).steelPlateList, "row-style": le, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: r(() => [l(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), i(s).useRequisitions ? (d(), f(n, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : L("", true), l(n, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }), l(n, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: r(({ row: t }) => [l(m, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: r(() => [he(D("span", null, null, 512), [[de, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(n, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: r(({ row: t }) => {
      var a;
      return [((a = i(V)) == null ? void 0 : a.spec) & i(y) ? (d(), f(p, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (g) => i(G)(t) }, null, 8, ["onClick"])) : L("", true), l(m, { content: t.specificationLabels, placement: "top" }, { default: r(() => [D("span", null, _(t.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), l(n, { label: `厚 (${i(c).thickness.unit})`, align: "center", "min-width": "120", prop: "thickness" }, { default: r(({ row: t }) => {
      var a;
      return [!i(s).useRequisitions || i(s).useRequisitions && ((a = i(V)) == null ? void 0 : a.thickness) & i(y) ? (d(), f(h, { key: 0, modelValue: t.thickness, "onUpdate:modelValue": (g) => t.thickness = g, controls: false, max: 999999, min: 0, precision: i(c).thickness.precision, size: "default", "controls-position": "right", placeholder: "厚" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (d(), b("span", we, _(t.thickness), 1))];
    }), _: 1 }, 8, ["label"]), l(n, { label: `宽 (${i(c).width.unit})`, align: "center", "min-width": "120", prop: "width" }, { default: r(({ row: t }) => {
      var a;
      return [!i(s).useRequisitions || i(s).useRequisitions && ((a = i(V)) == null ? void 0 : a.width) & i(y) ? (d(), f(h, { key: 0, modelValue: t.width, "onUpdate:modelValue": (g) => t.width = g, controls: false, max: 999999, min: 0, precision: i(c).width.precision, "controls-position": "right", size: "default", placeholder: "宽" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (d(), b("span", Le, _(t.width), 1))];
    }), _: 1 }, 8, ["label"]), l(n, { label: `长 (${i(c).length.unit})`, align: "center", "min-width": "120", prop: "length" }, { default: r(({ row: t }) => {
      var a;
      return [!i(s).useRequisitions || i(s).useRequisitions && ((a = i(V)) == null ? void 0 : a.length) & i(y) ? (d(), f(h, { key: 0, modelValue: t.length, "onUpdate:modelValue": (g) => t.length = g, controls: false, max: 999999999, min: 0, precision: i(c).length.precision, size: "default", placeholder: "长" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (d(), b("span", De, _(t.length), 1))];
    }), _: 1 }, 8, ["label"]), l(n, { label: `数量 (${i(c).measure.unit})`, align: "center", "min-width": "120", prop: "quantity" }, { default: r(({ row: t }) => {
      var a;
      return [!i(s).useRequisitions || i(s).useRequisitions && ((a = i(V)) == null ? void 0 : a.quantity) & i(y) ? (d(), f(h, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (g) => t.quantity = g, controls: false, max: i(s).useRequisitions ? t.canPurchaseQuantity : 999999999, min: 1, precision: i(c).measure.precision, step: 1, "controls-position": "right", size: "default", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])) : (d(), b("span", Ee, _(t.quantity), 1))];
    }), _: 1 }, 8, ["label"]), l(n, { key: "weighingTotalWeight", label: `总重 (${i(c).weight.unit})`, align: "center", "min-width": "135", prop: "weighingTotalWeight" }, { default: r(({ row: t }) => [i(s).useRequisitions ? (d(), b("span", Be, _(t.weighingTotalWeight || "-"), 1)) : (d(), f(m, { key: 0, content: i(s).useRequisitions ? `申购重量：${t.purchaseTotalWeight} kg， ${i(O)}` : `理论重量：${t.theoryTotalWeight} kg， ${i(Y)}`, disabled: !t.hasOver, class: "item", effect: "dark", placement: "top" }, { default: r(() => [l(h, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (a) => t.weighingTotalWeight = a, class: pe({ "over-weight-tip": t.hasOver }), controls: false, max: 999999999, min: 0, precision: i(c).weight.precision, "controls-position": "right", size: "default", placeholder: "重量" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"]))]), _: 1 }, 8, ["label"]), l(xe), l(n, { align: "center", label: "品牌", prop: "brand" }, { default: r(({ row: t }) => [l(T, { modelValue: t.brand, "onUpdate:modelValue": (a) => t.brand = a, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(n, { align: "center", label: "计量方式", prop: "weightMeasurementMode", width: "140px" }, { default: r(({ row: t }) => [l(x, { modelValue: t.weightMeasurementMode, "onUpdate:modelValue": (a) => t.weightMeasurementMode = a, options: i($).ENUM, props: { key: "K", label: "SL", value: "V" }, "unshow-val": [i($).MIXTURE.V], default: "", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshow-val"])]), _: 1 }), l(n, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: r(({ row: t, $index: a }) => [l(w, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (g) => ue(t.sn, a, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]), l(re, { ref_key: "drawerRef", ref: H, modelValue: i(R), "onUpdate:modelValue": o[1] || (o[1] = (t) => E(R) ? R.value = t : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: r(() => [l(Ue, { ref_key: "specRef", ref: j, modelValue: i(W), "onUpdate:modelValue": o[0] || (o[0] = (t) => E(W) ? W.value = t : null), classifyId: i(Z).classifyId, "max-height": i(X), "show-classify": false, visible: i(R), "expand-query": "", mode: "selector", onChange: i(J) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  Oe as default
};
