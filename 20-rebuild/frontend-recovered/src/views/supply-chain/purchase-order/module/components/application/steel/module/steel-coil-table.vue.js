import { inject as y } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as D } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { withDirectives as A } from "vue";
import { createElementVNode as N } from "vue";
import { toDisplayString as K } from "vue";
import { unref as c } from "vue";
import { mergeProps as X } from "vue";
import { reactive as Y } from "vue";
import { watch as V } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElTooltip as O } from "element-plus";
import { ElInput as Q } from "element-plus";
import { am as Z, sQ as G, uY as H, bR as x, aw as J, aI as ee, va as te, i as C, b as le, c9 as b, uZ as ae, iX as ie, D as ne } from "../../../../../../../../shared/runtime.js";
const de = { __name: "steel-coil-table", setup(se, { expose: M }) {
  var k;
  const T = Z.STEEL_COIL.V, I = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: b, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: b, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: b, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: b, message: "长度必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, n) => C(n.weighingTotalWeight) && C(n.unitPrice) ? +ie(n.weighingTotalWeight * n.unitPrice, ne.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }] }, L = y("matSpecRef"), u = (k = y("cu")) == null ? void 0 : k.form, { baseUnit: d } = G(T), o = y("cu"), { handleMeteChangeCalcPrice: w } = ae("weighingTotalWeight"), { tableValidate: P, wrongCellMask: R } = J({ rules: I, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function W({ row: e, rowIndex: n }) {
    var a, r;
    if ((r = (a = o == null ? void 0 : o.submitResult) == null ? void 0 : a.data) != null && r.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function q(e) {
    const n = Y({ uid: ee(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, classifySerialNumber: e.classify.serialNumber, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, quantity: void 0, color: void 0, brand: void 0, thickness: void 0, length: void 0, width: void 0, theoryLength: void 0, weighingTotalWeight: void 0 });
    return U(n), n;
  }
  function U(e) {
    V([() => e.weighingTotalWeight, () => e.width, () => e.thickness, d], () => E(e)), V([() => e.weighingTotalWeight], () => w(e)), V([() => e.theoryLength], () => S(e));
  }
  async function E(e) {
    e.theoryLength = await te({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
  }
  function S(e) {
    C(e.theoryLength) ? e.length = e.theoryLength * 1 : e.length = void 0;
  }
  function z(e, n, a) {
    var r, m, g, f;
    if ((m = (r = o == null ? void 0 : o.submitResult) == null ? void 0 : r.data) != null && m.includes(a.classifyId)) {
      const _ = (g = o == null ? void 0 : o.submitResult) == null ? void 0 : g.data.findIndex((p) => p === a.classifyId);
      u.steelCoilList.filter((p) => p.classifyId === a.classifyId).length === 1 && ((f = o == null ? void 0 : o.submitResult) == null || f.data.splice(_, 1));
    }
    L.value ? L.value.delListItem(e, n) : u.steelCoilList.splice(n, 1);
  }
  function B() {
    if (le(u.steelCoilList)) return true;
    const { validResult: e, dealList: n } = P(u.steelCoilList);
    return u.steelCoilList = n, u.steelCoilList.forEach((a) => {
      a.quantity = a.length;
    }), e;
  }
  return M({ rowInit: q, rowWatch: U, validate: B }), (e, n) => {
    const a = j, r = O, m = h("common-input-number"), g = Q, f = h("common-radio-button"), _ = h("common-button"), v = h("common-table"), p = F("empty-text");
    return D(), $(v, X({ "cell-class-name": c(R), data: c(u).steelCoilList, "row-style": W, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: s(() => [l(a, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), l(a, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }), l(a, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [l(r, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: s(() => [A(N("span", null, null, 512), [[p, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(a, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [l(r, { content: t.specificationLabels, placement: "top" }, { default: s(() => [N("span", null, K(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), l(a, { key: "weighingTotalWeight", label: `总重 (${c(d).weight.unit})`, align: "center", "min-width": "135", prop: "weighingTotalWeight" }, { default: s(({ row: t }) => [l(m, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (i) => t.weighingTotalWeight = i, controls: false, max: 999999999, min: 0, precision: c(d).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(a, { label: `厚 (${c(d).thickness.unit})`, align: "center", "min-width": "120", prop: "thickness" }, { default: s(({ row: t }) => [l(m, { modelValue: t.thickness, "onUpdate:modelValue": (i) => t.thickness = i, controls: false, max: 999999, min: 0, precision: c(d).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(a, { label: `宽 (${c(d).width.unit})`, align: "center", "min-width": "120", prop: "width" }, { default: s(({ row: t }) => [l(m, { modelValue: t.width, "onUpdate:modelValue": (i) => t.width = i, controls: false, max: 999999, min: 0, precision: c(d).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(a, { label: "长 (m)", align: "center", "min-width": "120", prop: "length" }, { default: s(({ row: t }) => [l(m, { modelValue: t.length, "onUpdate:modelValue": (i) => t.length = i, controls: false, max: 999999999, min: 0, precision: t.measurePrecision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), l(H), l(a, { align: "center", label: "颜色", prop: "color" }, { default: s(({ row: t }) => [l(g, { modelValue: t.color, "onUpdate:modelValue": (i) => t.color = i, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(a, { align: "center", label: "品牌", prop: "brand" }, { default: s(({ row: t }) => [l(g, { modelValue: t.brand, "onUpdate:modelValue": (i) => t.brand = i, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(a, { align: "center", label: "计量方式", prop: "weightMeasurementMode", width: "140px" }, { default: s(({ row: t }) => [l(f, { modelValue: t.weightMeasurementMode, "onUpdate:modelValue": (i) => t.weightMeasurementMode = i, options: c(x).ENUM, props: { key: "K", label: "SL", value: "V" }, "unshow-val": [c(x).MIXTURE.V], default: "", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshow-val"])]), _: 1 }), l(a, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: s(({ row: t, $index: i }) => [l(_, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (ce) => z(t.sn, i, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  de as default
};
