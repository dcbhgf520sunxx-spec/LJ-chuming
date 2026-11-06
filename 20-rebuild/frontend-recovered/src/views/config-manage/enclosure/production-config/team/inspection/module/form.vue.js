import { ref as m } from "vue";
import { computed as x } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as C } from "vue";
import { createBlock as V } from "vue";
import { withCtx as s } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { createTextVNode as h } from "vue";
import { ElFormItem as k } from "element-plus";
import { ElForm as w } from "element-plus";
import { ao as R } from "../../../../../../../shared/runtime.js";
import { _ as v } from "../../../../../../../modules/factory-select-b8d0a4ac.js";
import { u as F } from "../../../../../../../modules/index-7da9f094.js";
import "../../../../../../../modules/use-users-4d979987.js";
const N = { __name: "form", setup(U) {
  const n = m(), u = m(), f = { id: void 0, factoryId: void 0, inspectorIds: [] }, { crud: o, form: t } = R(f, n), p = x(() => o.status.edit >= 1), _ = { factoryId: [{ required: true, message: "请选择工厂", trigger: "change" }], inspectorIds: [{ required: true, message: "请选择质检", trigger: "change" }] };
  function g(d) {
    t.inspectors = d;
  }
  return (d, l) => {
    const b = c("common-button"), i = k, y = w, I = c("common-dialog");
    return C(), V(I, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(o).cancelCU, visible: e(o).status.cu > 0, title: e(o).status.title, width: "500px" }, { titleRight: s(() => [r(b, { loading: e(o).status.cu === 2, type: "primary", size: "default", onClick: e(o).submitCU }, { default: s(() => l[2] || (l[2] = [h("确认")])), _: 1, __: [2] }, 8, ["loading", "onClick"])]), default: s(() => [r(y, { ref_key: "formRef", ref: n, model: e(t), rules: _, size: "default", "label-width": "100px" }, { default: s(() => [r(i, { label: "工厂", prop: "factoryId" }, { default: s(() => [r(v, { disabled: p.value, modelValue: e(t).factoryId, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(t).factoryId = a), placeholder: "请选择工厂", style: { width: "270px" } }, null, 8, ["disabled", "modelValue"])]), _: 1 }), r(i, { label: "质检", prop: "inspectorIds" }, { default: s(() => [r(e(F), { ref_key: "inspectorSelectRef", ref: u, modelValue: e(t).inspectorIds, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(t).inspectorIds = a), multiple: true, placeholder: "请选择质检人员", style: { width: "270px" }, onChange: g }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  N as default
};
