import { inject as V } from "vue";
import { resolveComponent as d } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as B } from "vue";
import { createBlock as F } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { withDirectives as D } from "vue";
import { createElementVNode as C } from "vue";
import { toDisplayString as $ } from "vue";
import { unref as o } from "vue";
import { mergeProps as A } from "vue";
import { reactive as K } from "vue";
import { watch as g } from "vue";
import { ElTableColumn as X } from "element-plus";
import { ElTooltip as Y } from "element-plus";
import { ElInput as j } from "element-plus";
import { am as O, sQ as Q, uY as Z, bR as L, aw as G, aI as H, va as J, i as p, b as ee, c9 as m, uZ as te, iX as le, D as ae } from "../../../../../../../../shared/runtime.js";
const re = { __name: "steel-coil-table", setup(ie, { expose: U }) {
  var b;
  const v = O.STEEL_COIL.V, k = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: m, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: m, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: m, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: m, message: "长度必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, n) => p(n.weighingTotalWeight) && p(n.unitPrice) ? +le(n.weighingTotalWeight * n.unitPrice, ae.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }] }, h = V("matSpecRef"), r = (b = V("cu")) == null ? void 0 : b.form, { baseUnit: c } = Q(v), { handleMeteChangeCalcPrice: M } = te("weighingTotalWeight"), { tableValidate: N, wrongCellMask: T } = G({ rules: k, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function x(e) {
    const n = K({ uid: H(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, quantity: void 0, color: void 0, brand: void 0, thickness: void 0, length: void 0, width: void 0, theoryLength: void 0, weighingTotalWeight: void 0 });
    return f(n), n;
  }
  function f(e) {
    g([() => e.weighingTotalWeight, () => e.width, () => e.thickness, c], () => w(e)), g([() => e.weighingTotalWeight], () => M(e)), g([() => e.theoryLength], () => P(e));
  }
  async function w(e) {
    e.theoryLength = await J({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
  }
  function P(e) {
    p(e.theoryLength) ? e.length = e.theoryLength * 1 : e.length = void 0;
  }
  function W(e, n) {
    h.value ? h.value.delListItem(e, n) : r.steelCoilList.splice(n, 1);
  }
  function q() {
    if (ee(r.steelCoilList)) return true;
    const { validResult: e, dealList: n } = N(r.steelCoilList);
    return r.steelCoilList = n, r.steelCoilList.forEach((a) => {
      a.quantity = a.length;
    }), e;
  }
  return U({ rowInit: x, rowWatch: f, validate: q }), (e, n) => {
    const a = X, _ = Y, u = d("common-input-number"), y = j, E = d("common-radio-button"), I = d("common-button"), z = d("common-table"), S = R("empty-text");
    return B(), F(z, A(e.$attrs, { data: o(r).steelCoilList, "cell-class-name": o(T), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: s(() => [l(a, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), l(a, { prop: "serialNumber", label: "编号", align: "center", fixed: "left" }), l(a, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [l(_, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: s(() => [D(C("span", null, null, 512), [[S, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(a, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [l(_, { content: t.specificationLabels, placement: "top" }, { default: s(() => [C("span", null, $(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), l(a, { key: "weighingTotalWeight", prop: "weighingTotalWeight", align: "center", label: `总重 (${o(c).weight.unit})`, "min-width": "135" }, { default: s(({ row: t }) => [l(u, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (i) => t.weighingTotalWeight = i, min: 0, max: 999999999, "controls-position": "right", controls: false, precision: o(c).weight.precision, size: "default", placeholder: "重量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(a, { prop: "thickness", align: "center", label: `厚 (${o(c).thickness.unit})`, "min-width": "120" }, { default: s(({ row: t }) => [l(u, { modelValue: t.thickness, "onUpdate:modelValue": (i) => t.thickness = i, min: 0, max: 999999, "controls-position": "right", controls: false, precision: o(c).thickness.precision, size: "default", placeholder: "厚" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(a, { prop: "width", align: "center", label: `宽 (${o(c).width.unit})`, "min-width": "120" }, { default: s(({ row: t }) => [l(u, { modelValue: t.width, "onUpdate:modelValue": (i) => t.width = i, min: 0, max: 999999, "controls-position": "right", controls: false, precision: o(c).width.precision, size: "default", placeholder: "宽" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(a, { prop: "length", align: "center", label: "长 (m)", "min-width": "120" }, { default: s(({ row: t }) => [l(u, { modelValue: t.length, "onUpdate:modelValue": (i) => t.length = i, min: 0, max: 999999999, precision: t.measurePrecision, controls: false, size: "default", placeholder: "长" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), l(Z), l(a, { prop: "color", label: "颜色", align: "center" }, { default: s(({ row: t }) => [l(y, { modelValue: t.color, "onUpdate:modelValue": (i) => t.color = i, modelModifiers: { trim: true }, maxlength: "20", size: "default", placeholder: "颜色" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(a, { prop: "brand", label: "品牌", align: "center" }, { default: s(({ row: t }) => [l(y, { modelValue: t.brand, "onUpdate:modelValue": (i) => t.brand = i, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(a, { prop: "weightMeasurementMode", label: "计量方式", align: "center", width: "140px" }, { default: s(({ row: t }) => [l(E, { modelValue: t.weightMeasurementMode, "onUpdate:modelValue": (i) => t.weightMeasurementMode = i, options: o(L).ENUM, type: "enum", "unshow-val": [o(L).MIXTURE.V], default: "", props: { key: "K", label: "SL", value: "V" }, size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshow-val"])]), _: 1 }), l(a, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: s(({ row: t, $index: i }) => [l(I, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (se) => W(t.sn, i) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  re as default
};
