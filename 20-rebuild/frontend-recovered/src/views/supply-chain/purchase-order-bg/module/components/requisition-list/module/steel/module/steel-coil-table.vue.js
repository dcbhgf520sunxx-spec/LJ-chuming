import { inject as h } from "vue";
import { resolveComponent as u } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as I } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as i } from "vue";
import { createVNode as l } from "vue";
import { withDirectives as j } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as D } from "vue";
import { unref as o } from "vue";
import { mergeProps as F } from "vue";
import { watch as b } from "vue";
import { ElTableColumn as O } from "element-plus";
import { ElTooltip as R } from "element-plus";
import { ElInput as S } from "element-plus";
import { am as Q, sQ as A, aw as G, va as H, i as J, c9 as d } from "../../../../../../../../../shared/runtime.js";
const ee = { __name: "steel-coil-table", emits: ["add-purchase"], setup(K, { expose: _, emit: V }) {
  var m;
  const y = V, x = Q.STEEL_COIL.V, k = h("bcListObj"), C = (m = h("cu")) == null ? void 0 : m.form, { baseUnit: s } = A(x), L = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: d, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: d, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: d, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: d, message: "长度必须大于0", trigger: "blur" }] }, { tableValidate: U, wrongCellMask: w } = G({ rules: L, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function T(t) {
    var c;
    return ((c = C.steelCoilList) == null ? void 0 : c.findIndex((a) => a.id === t)) !== -1;
  }
  function v(t) {
    b([() => t.weighingTotalWeight, () => t.width, () => t.thickness, s], () => N(t)), b([() => t.theoryLength], () => W(t));
  }
  async function N(t) {
    t.theoryLength = await H({ classifyId: t.classifyId, name: t.classifyFullName, weight: t.weighingTotalWeight, width: t.width, thickness: t.thickness });
  }
  function W(t) {
    J(t.theoryLength) ? t.length = t.theoryLength * 1 : t.length = void 0;
  }
  function z(t, c) {
    y("add-purchase", t, c);
  }
  function E(t) {
    const { validResult: c } = U(t);
    return c;
  }
  return _({ rowWatch: v, validate: E }), (t, c) => {
    const a = O, p = R, r = u("common-input-number"), g = S, M = u("common-button"), P = u("common-table"), q = B("empty-text");
    return I(), $(P, F(t.$attrs, { data: o(k).steelCoilList, "cell-class-name": o(w), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: i(() => [l(a, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), l(a, { prop: "serialNumber", label: "编号", align: "center", fixed: "left" }), l(a, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: i(({ row: e }) => [l(p, { content: e.classifyParentFullName, disabled: !e.classifyParentFullName, "show-after": 500, placement: "top" }, { default: i(() => [j(f("span", null, null, 512), [[q, e.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(a, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: i(({ row: e }) => [l(p, { content: e.specificationLabels, placement: "top" }, { default: i(() => [f("span", null, D(e.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), l(a, { key: "weighingTotalWeight", prop: "weighingTotalWeight", align: "center", label: `总重 (${o(s).weight.unit})` }, { default: i(({ row: e }) => [l(r, { modelValue: e.weighingTotalWeight, "onUpdate:modelValue": (n) => e.weighingTotalWeight = n, min: 0, max: 999999999, "controls-position": "right", controls: false, precision: o(s).weight.precision, size: "default", placeholder: "重量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(a, { prop: "thickness", align: "center", label: `厚 (${o(s).thickness.unit})` }, { default: i(({ row: e }) => [l(r, { modelValue: e.thickness, "onUpdate:modelValue": (n) => e.thickness = n, min: 0, max: 999999, "controls-position": "right", controls: false, precision: o(s).thickness.precision, size: "default", placeholder: "厚" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(a, { prop: "width", align: "center", label: `宽 (${o(s).width.unit})` }, { default: i(({ row: e }) => [l(r, { modelValue: e.width, "onUpdate:modelValue": (n) => e.width = n, min: 0, max: 999999, "controls-position": "right", controls: false, precision: o(s).width.precision, size: "default", placeholder: "宽" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(a, { prop: "length", align: "center", label: "长 (m)" }, { default: i(({ row: e }) => [l(r, { modelValue: e.length, "onUpdate:modelValue": (n) => e.length = n, min: 0, max: 999999999, precision: e.measurePrecision, controls: false, size: "default", placeholder: "长" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), l(a, { prop: "color", label: "颜色", align: "center" }, { default: i(({ row: e }) => [l(g, { modelValue: e.color, "onUpdate:modelValue": (n) => e.color = n, modelModifiers: { trim: true }, maxlength: "20", size: "default", placeholder: "颜色" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(a, { prop: "brand", label: "品牌", align: "center" }, { default: i(({ row: e }) => [l(g, { modelValue: e.brand, "onUpdate:modelValue": (n) => e.brand = n, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(a, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: i(({ row: e, $index: n }) => [l(M, { icon: "el-icon-plus", disabled: T(e.id) || e.boolPurchase, type: "warning", size: "default", onClick: (X) => z(e, n) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  ee as default
};
