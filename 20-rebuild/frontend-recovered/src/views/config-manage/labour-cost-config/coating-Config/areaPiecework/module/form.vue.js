import { ref as V } from "vue";
import { computed as k } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as U } from "vue";
import { createBlock as x } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as h } from "vue";
import { ElFormItem as w } from "element-plus";
import { ElInput as T } from "element-plus";
import { ElForm as P } from "element-plus";
import { _ as C, aT as E, ao as v, ef as m } from "../../../../../../shared/runtime.js";
const I = { __name: "form", props: { measurementManner: { type: Number } }, setup(M) {
  const a = V(), p = { id: void 0, processId: void 0, selectId: void 0, leaderId: void 0, organizationType: void 0, measureUnit: E.AREA.V }, { crud: u, form: t, CRUD: c } = v(p, a);
  k(() => u.status.edit >= 1);
  const f = { type: [{ required: true, message: "请选择涂装类型", trigger: "click" }], thickness: [{ required: true, message: "请输入标准厚度", trigger: "blur" }], unitPrice: [{ required: true, message: "请输入标准单价", trigger: "blur" }], outThickness: [{ required: true, message: "请输入超标厚度", trigger: "blur" }], outUnitPrice: [{ required: true, message: "请输入超标单价", trigger: "blur" }] };
  return c.HOOK.beforeSubmit = () => {
    t.name = m.VL[t.type];
  }, (q, o) => {
    const _ = i("common-button"), b = i("common-radio"), s = w, d = T, g = P, y = i("common-dialog");
    return U(), x(y, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(u).cancelCU, visible: e(u).status.cu > 0, title: e(u).status.title, width: "550px" }, { titleRight: n(() => [l(_, { loading: e(u).status.cu === 2, type: "primary", size: "default", onClick: e(u).submitCU }, { default: n(() => o[5] || (o[5] = [h("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: n(() => [l(g, { ref_key: "formRef", ref: a, model: e(t), rules: f, size: "default", "label-width": "100px" }, { default: n(() => [l(s, { label: "涂装类型: ", prop: "type" }, { default: n(() => [l(b, { modelValue: e(t).type, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(t).type = r), options: e(m).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(s, { label: "标准厚度（um）", prop: "thickness", style: { width: "300px" } }, { default: n(() => [l(d, { modelValue: e(t).thickness, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(t).thickness = r), modelModifiers: { number: true }, type: "number", placeholder: "请输入标准厚度", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(s, { label: "标准单价（元/㎡）", prop: "unitPrice" }, { default: n(() => [l(d, { modelValue: e(t).unitPrice, "onUpdate:modelValue": o[2] || (o[2] = (r) => e(t).unitPrice = r), modelModifiers: { number: true }, type: "number", placeholder: "请输入标准单价", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(s, { label: "超标厚度值（um）", prop: "outThickness" }, { default: n(() => [l(d, { modelValue: e(t).outThickness, "onUpdate:modelValue": o[3] || (o[3] = (r) => e(t).outThickness = r), modelModifiers: { number: true }, type: "number", placeholder: "请输入超标厚度值", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(s, { label: "超标单价（元/㎡）", prop: "outUnitPrice" }, { default: n(() => [l(d, { modelValue: e(t).outUnitPrice, "onUpdate:modelValue": o[4] || (o[4] = (r) => e(t).outUnitPrice = r), modelModifiers: { number: true }, type: "number", placeholder: "请输入超标单价", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, z = C(I, [["__scopeId", "data-v-f2bfe2de"]]);
export {
  z as default
};
