import { ref as E } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as k } from "vue";
import { createBlock as U } from "vue";
import { withCtx as r } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as c } from "vue";
import { ElFormItem as q } from "element-plus";
import { ElInput as z } from "element-plus";
import { ElForm as C } from "element-plus";
import { bl as g, c9 as u, sQ as M, ap as R } from "../../../../../../../../shared/runtime.js";
import { u as T } from "../../../../../../../../modules/use-purchase-material-form-info-d099f05d.js";
const L = { __name: "steel-plate", props: { technologyRow: { type: Object, default: () => ({}) }, classifyIds: { type: Array, default: () => [] } }, setup(m, { expose: b }) {
  const n = m, y = g.STEEL_PLATE.V, h = E({ classifyId: [{ required: true, message: "请选择科目", trigger: "change" }], length: [{ required: true, message: "请输入钢板长度", trigger: "blur" }, { pattern: u, message: "钢板长度必须大于0", trigger: "blur" }], width: [{ required: true, message: "请输入钢板宽度", trigger: "blur" }, { pattern: u, message: "钢板宽度必须大于0", trigger: "blur" }], quantity: [{ pattern: u, message: "数量必须大于0", trigger: "blur" }] }), { baseUnit: i } = M(g.STEEL_PLATE.V), { form: t, formRef: V, add: x, resetForm: w } = T({ props: n, basicClass: y });
  return b({ add: x, resetForm: w }), (v, a) => {
    const s = q, d = I("common-input-number"), p = z, _ = C;
    return k(), U(_, { ref_key: "formRef", ref: V, model: e(t), rules: h.value, "label-position": "right", "label-width": "80px" }, { default: r(() => [l(s, { label: "科目", prop: "classifyId" }, { default: r(() => [l(R, { "check-strictly": "", modelValue: e(t).classifyId, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(t).classifyId = o), classifyId: m.classifyIds, default: "", separator: " > ", "show-all-levels": "", size: "default", class: "filter-item", style: { width: "200px" }, placeholder: "可选择/输入科目、编号搜索" }, null, 8, ["modelValue", "classifyId"])]), _: 1 }), l(s, { label: "材质", prop: "material" }, { default: r(() => [f(c(n.technologyRow.material), 1)]), _: 1 }), l(s, { label: `厚(${e(i).thickness.unit})`, prop: "material" }, { default: r(() => [f(c(n.technologyRow.specification), 1)]), _: 1 }, 8, ["label"]), l(s, { label: `宽(${e(i).width.unit})`, prop: "width" }, { default: r(() => [l(d, { modelValue: e(t).width, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(t).width = o), min: 0, max: 999999, precision: e(i).length.precision, controls: false, "text-align": "left", size: "default", placeholder: "宽", style: { width: "200px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(s, { label: `长(${e(i).length.unit})`, prop: "length" }, { default: r(() => [l(d, { modelValue: e(t).length, "onUpdate:modelValue": a[2] || (a[2] = (o) => e(t).length = o), min: 0, max: 999999, precision: e(i).length.precision, controls: false, "text-align": "left", size: "default", placeholder: "长", style: { width: "200px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(s, { label: "品牌", prop: "brand" }, { default: r(() => [l(p, { modelValue: e(t).brand, "onUpdate:modelValue": a[3] || (a[3] = (o) => e(t).brand = o), modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), l(s, { label: "数量", prop: "quantity" }, { default: r(() => [l(d, { modelValue: e(t).quantity, "onUpdate:modelValue": a[4] || (a[4] = (o) => e(t).quantity = o), min: 0, max: 999999999, step: 1, precision: e(i).measure.precision, controls: false, "text-align": "left", size: "default", placeholder: "数量", style: { width: "200px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), l(s, { label: "备注", prop: "remark" }, { default: r(() => [l(p, { modelValue: e(t).remark, "onUpdate:modelValue": a[5] || (a[5] = (o) => e(t).remark = o), modelModifiers: { trim: true }, maxlength: "250", size: "default", placeholder: "备注", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"]);
  };
} };
export {
  L as default
};
