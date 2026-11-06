import { ref as i } from "vue";
import { computed as h } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as x } from "vue";
import { createBlock as R } from "vue";
import { withCtx as r } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { createTextVNode as k } from "vue";
import { ElFormItem as E } from "element-plus";
import { ElForm as v } from "element-plus";
import { aU as w, ao as U, aD as P } from "../../../../../../shared/runtime.js";
import { _ as S } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import { _ as z } from "../../../../../../modules/process-select-cf7cf476.js";
import { u as F } from "../../../../../../modules/index-7da9f094.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-bridge-process-6f90ba68.js";
import "../../../../../../modules/use-users-4d979987.js";
const H = { __name: "form", setup(N) {
  const p = i(), u = i(), f = i(), _ = i(), g = { id: void 0, processId: void 0, productionLineTypeEnum: w.TRADITION.V, inspectorIds: [] }, { crud: l, form: t } = U(g, p), y = h(() => l.status.edit >= 1), b = { factoryId: [{ required: true, message: "请选择工厂", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], inspectorIds: [{ required: true, message: "请选择质检", trigger: "change" }] };
  function I(d) {
    var o, n;
    _.value = (n = (o = u.value) == null ? void 0 : o.getOption(d)) == null ? void 0 : n.productType;
  }
  function V(d) {
    t.inspectors = d;
  }
  return (d, o) => {
    const n = m("common-button"), c = E, C = v, T = m("common-dialog");
    return x(), R(T, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(l).cancelCU, visible: e(l).status.cu > 0, title: e(l).status.title, width: "500px" }, { titleRight: r(() => [s(n, { loading: e(l).status.cu === 2, type: "primary", size: "default", onClick: e(l).submitCU }, { default: r(() => o[3] || (o[3] = [k("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: r(() => [s(C, { ref_key: "formRef", ref: p, model: e(t), rules: b, size: "default", "label-width": "100px" }, { default: r(() => [s(c, { label: "工厂", prop: "factoryId" }, { default: r(() => [s(S, { disabled: y.value, modelValue: e(t).factoryId, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).factoryId = a), placeholder: "请选择工厂", style: { width: "270px" } }, null, 8, ["disabled", "modelValue"])]), _: 1 }), s(c, { label: "工序", prop: "processId" }, { default: r(() => [s(e(z), { ref_key: "processSelectRef", ref: u, modelValue: e(t).processId, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).processId = a), disabledProductType: [e(P).MACHINE_PART.V], size: "default", multiple: false, style: { width: "270px" }, onChange: I }, null, 8, ["modelValue", "disabledProductType"])]), _: 1 }), s(c, { label: "质检", prop: "inspectorIds" }, { default: r(() => [s(e(F), { ref_key: "inspectorSelectRef", ref: f, modelValue: e(t).inspectorIds, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).inspectorIds = a), multiple: true, placeholder: "请选择质检人员", style: { width: "270px" }, onChange: V }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  H as default
};
