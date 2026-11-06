import { ref as w } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as k } from "vue";
import { createBlock as C } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as c } from "vue";
import { ElFormItem as E } from "element-plus";
import { ElInput as U } from "element-plus";
import { ElForm as q } from "element-plus";
import { bl as z, c9 as g, sQ as M, ap as R } from "../../../../../../../../shared/runtime.js";
import { u as v } from "../../../../../../../../modules/use-purchase-material-form-info-d099f05d.js";
const T = { __name: "section-steel", props: { technologyRow: { type: Object, default: () => ({}) }, classifyIds: { type: Array, default: () => [] } }, setup(d, { expose: y }) {
  const n = d, m = z.SECTION_STEEL.V, b = w({ classifyId: [{ required: true, message: "请选择科目", trigger: "change" }], length: [{ required: true, message: "请输入钢板长度", trigger: "blur" }, { pattern: g, message: "钢板长度必须大于0", trigger: "blur" }], quantity: [{ pattern: g, message: "数量必须大于0", trigger: "blur" }] }), { baseUnit: i } = M(m), { form: t, formRef: h, add: V, resetForm: _ } = v({ props: n, basicClass: m });
  return y({ add: V, resetForm: _ }), (B, a) => {
    const r = E, u = I("common-input-number"), p = U, x = q;
    return k(), C(x, { ref_key: "formRef", ref: h, model: e(t), rules: b.value, "label-position": "right", "label-width": "80px" }, { default: s(() => [l(r, { label: "科目", prop: "classifyId" }, { default: s(() => [l(R, { "check-strictly": "", modelValue: e(t).classifyId, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(t).classifyId = o), classifyId: d.classifyIds, default: "", separator: " > ", "show-all-levels": "", size: "default", class: "filter-item", style: { width: "200px" }, placeholder: "可选择/输入科目、编号搜索" }, null, 8, ["modelValue", "classifyId"])]), _: 1 }), l(r, { label: "材质", prop: "material" }, { default: s(() => [f(c(n.technologyRow.material), 1)]), _: 1 }), l(r, { label: "规格", prop: "material" }, { default: s(() => [f(c(n.technologyRow.specification), 1)]), _: 1 }), l(r, { label: `长(${e(i).length.unit})`, prop: "length" }, { default: s(() => [l(u, { modelValue: e(t).length, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(t).length = o), min: 0, max: 999999, precision: e(i).length.precision, controls: false, "text-align": "left", size: "default", placeholder: "长", style: { width: "200px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"]), l(r, { label: "品牌", prop: "brand" }, { default: s(() => [l(p, { modelValue: e(t).brand, "onUpdate:modelValue": a[2] || (a[2] = (o) => e(t).brand = o), modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "数量", prop: "quantity" }, { default: s(() => [l(u, { modelValue: e(t).quantity, "onUpdate:modelValue": a[3] || (a[3] = (o) => e(t).quantity = o), min: 0, max: 999999999, step: 1, precision: e(i).measure.precision, controls: false, "text-align": "left", size: "default", placeholder: "数量", style: { width: "200px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), l(r, { label: "备注", prop: "remark" }, { default: s(() => [l(p, { modelValue: e(t).remark, "onUpdate:modelValue": a[4] || (a[4] = (o) => e(t).remark = o), modelModifiers: { trim: true }, maxlength: "250", size: "default", placeholder: "备注", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"]);
  };
} };
export {
  T as default
};
