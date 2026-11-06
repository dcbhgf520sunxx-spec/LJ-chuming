import { ref as k } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as i } from "vue";
import { createBlock as u } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as p } from "vue";
import { unref as r } from "vue";
import { ElFormItem as q } from "element-plus";
import { ElInput as C } from "element-plus";
import { ElForm as P } from "element-plus";
import { bl as f, c9 as d, sQ as I } from "../../../../../../../../shared/runtime.js";
import { u as N } from "../../../../../../../../modules/use-purchase-material-form-info-d099f05d.js";
const F = { __name: "aux-material", props: { technologyRow: { type: Object, default: () => ({}) }, classifyIds: { type: Array, default: () => [] } }, setup(y, { expose: b }) {
  const e = y, h = f.STEEL_PLATE.V, _ = k({ classifyId: [{ required: true, message: "请选择科目", trigger: "change" }], length: [{ required: true, message: "请输入钢板长度", trigger: "blur" }, { pattern: d, message: "钢板长度必须大于0", trigger: "blur" }], width: [{ required: true, message: "请输入钢板宽度", trigger: "blur" }, { pattern: d, message: "钢板宽度必须大于0", trigger: "blur" }], quantity: [{ pattern: d, message: "数量必须大于0", trigger: "blur" }] });
  I(f.STEEL_PLATE.V);
  const { form: t, formRef: w, add: R, resetForm: x } = N({ props: e, basicClass: h });
  return b({ add: R, resetForm: x }), (T, n) => {
    const l = q, g = U("common-input-number"), V = C, E = P;
    return i(), u(E, { ref_key: "formRef", ref: w, model: r(t), rules: _.value, "label-position": "right", "label-width": "130px" }, { default: o(() => [a(l, { label: "科目", prop: "classifyId" }, { default: o(() => [m(c(e.technologyRow.classifyName), 1)]), _: 1 }), e.technologyRow.specification ? (i(), u(l, { key: 0, label: "规格", prop: "material" }, { default: o(() => [m(c(e.technologyRow.specification), 1)]), _: 1 })) : p("", true), e.technologyRow.color ? (i(), u(l, { key: 1, label: "颜色", prop: "color" }, { default: o(() => [m(c(e.technologyRow.color), 1)]), _: 1 })) : p("", true), e.technologyRow.brand ? (i(), u(l, { key: 2, label: "品牌", prop: "brand" }, { default: o(() => [m(c(e.technologyRow.brand), 1)]), _: 1 })) : p("", true), a(l, { label: `数量（${e.technologyRow.measureUnit}）`, prop: "quantity" }, { default: o(() => [a(g, { modelValue: r(t).quantity, "onUpdate:modelValue": n[0] || (n[0] = (s) => r(t).quantity = s), min: 0, max: 999999999, step: 1, precision: e.technologyRow.measurePrecision, controls: false, "text-align": "left", size: "default", placeholder: `数量（${e.technologyRow.measureUnit}）`, style: { width: "200px" } }, null, 8, ["modelValue", "precision", "placeholder"])]), _: 1 }, 8, ["label"]), a(l, { label: `核算量（${e.technologyRow.accountingUnit}）`, prop: "mete" }, { default: o(() => [a(g, { modelValue: r(t).mete, "onUpdate:modelValue": n[1] || (n[1] = (s) => r(t).mete = s), min: 0, max: 999999999, step: 1, precision: e.technologyRow.accountingPrecision, controls: false, "text-align": "left", size: "default", placeholder: `核算量（${e.technologyRow.accountingUnit}）`, style: { width: "200px" } }, null, 8, ["modelValue", "precision", "placeholder"])]), _: 1 }, 8, ["label"]), a(l, { label: "备注", prop: "remark" }, { default: o(() => [a(V, { modelValue: r(t).remark, "onUpdate:modelValue": n[2] || (n[2] = (s) => r(t).remark = s), modelModifiers: { trim: true }, maxlength: "250", size: "default", placeholder: "备注", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"]);
  };
} };
export {
  F as default
};
