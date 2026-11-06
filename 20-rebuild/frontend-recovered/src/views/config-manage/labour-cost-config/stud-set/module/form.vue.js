import { ref as d } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as C } from "vue";
import { createBlock as v } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as w } from "vue";
import { ElFormItem as h } from "element-plus";
import { ElInput as k } from "element-plus";
import { ElForm as I } from "element-plus";
import { ao as N } from "../../../../../shared/runtime.js";
import { g as T, a as D } from "../../../../../modules/stud-set-1d850c87.js";
const R = { __name: "form", setup(U) {
  const m = d(), p = d(), c = d(), y = { id: void 0, processId: void 0, leaderId: void 0, organizationType: void 0, typeNameList: [], unit: "支" }, { crud: n, form: l } = N(y, m), _ = { typeNameList: [{ required: true, type: "array", message: "请选择类型", trigger: "change" }], processId: [{ required: true, message: "请选择绑定工序", trigger: "change" }], price: [{ required: true, message: "请输入单价", trigger: "blur" }] };
  (async () => {
    try {
      p.value = await T();
    } catch (r) {
      console.log(r);
    }
  })();
  const b = { ProductSectionNameEnum: 1, productClassificationEnum: 32, productType: 8 };
  return (async () => {
    try {
      const r = await D(b);
      c.value = r[0].sectionWarehouseConfigDTOList;
    } catch (r) {
      console.log(r);
    }
  })(), (r, t) => {
    const L = u("common-button"), f = u("common-select"), i = h, g = k, V = I, x = u("common-dialog");
    return C(), v(x, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, width: "550px" }, { titleRight: a(() => [o(L, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: a(() => t[4] || (t[4] = [w("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: a(() => [o(V, { ref_key: "formRef", ref: m, model: e(l), rules: _, size: "default", "label-width": "100px" }, { default: a(() => [o(i, { label: "类型", prop: "typeNameList" }, { default: a(() => [o(f, { dataStructure: { key: "id", label: "name", value: "name" }, modelValue: e(l).typeNameList, "onUpdate:modelValue": t[0] || (t[0] = (s) => e(l).typeNameList = s), multiple: true, options: c.value, placeholder: "请选择类型", style: { width: "270px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(i, { label: "绑定工序", prop: "processId" }, { default: a(() => [o(f, { dataStructure: { key: "id", label: "name", value: "id" }, modelValue: e(l).processId, "onUpdate:modelValue": t[1] || (t[1] = (s) => e(l).processId = s), options: p.value, placeholder: "请选择工序", style: { width: "270px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(i, { label: "计算单位", prop: "unit" }, { default: a(() => [o(g, { disabled: "", modelValue: e(l).unit, "onUpdate:modelValue": t[2] || (t[2] = (s) => e(l).unit = s), modelModifiers: { trim: true }, type: "text", placeholder: "请输入计算单位", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), o(i, { label: "单价（元）", prop: "price" }, { default: a(() => [o(g, { modelValue: e(l).price, "onUpdate:modelValue": t[3] || (t[3] = (s) => e(l).price = s), modelModifiers: { number: true }, type: "number", placeholder: "请输入单价", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  R as default
};
