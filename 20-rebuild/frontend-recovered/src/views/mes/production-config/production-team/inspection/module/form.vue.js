import { ref as u } from "vue";
import { computed as L } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as y } from "vue";
import { createBlock as I } from "vue";
import { withCtx as l } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as N } from "vue";
import { createCommentVNode as v } from "vue";
import { ElFormItem as A } from "element-plus";
import { ElForm as w } from "element-plus";
import { m as F, aU as f, ao as S, a3 as p, nt as z } from "../../../../../../shared/runtime.js";
import { _ as q } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import { _ as O } from "../../../../../../modules/process-select-b35dffc0.js";
import { u as P } from "../../../../../../modules/index-7da9f094.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
import "../../../../../../modules/use-users-4d979987.js";
const Q = { __name: "form", setup(B) {
  const { hasIntelligent: T } = F(["hasIntelligent"]), _ = u(), g = u(), V = u(), m = u(), b = { id: void 0, productionLineTypeEnum: f.TRADITION.V, processId: void 0, inspectorIds: [] }, { crud: r, form: t } = S(b, _), E = L(() => r.status.edit >= 1), C = { factoryId: [{ required: true, message: "请选择工厂", trigger: "change" }], productionLineTypeEnum: [{ required: true, message: "请选择生产线", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], inspectorIds: [{ required: true, message: "请选择质检", trigger: "change" }] };
  function R(a) {
    var o, d;
    m.value = (d = (o = g.value) == null ? void 0 : o.getOption(a)) == null ? void 0 : d.productType, m.value !== p.ARTIFACT.V && (t.productionLineTypeEnum = f.TRADITION.V);
  }
  function h(a) {
    t.inspectors = a;
  }
  return (a, o) => {
    const d = c("common-button"), i = A, x = c("common-select"), U = w, k = c("common-dialog");
    return y(), I(k, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(r).cancelCU, visible: e(r).status.cu > 0, title: e(r).status.title, width: "500px" }, { titleRight: l(() => [n(d, { loading: e(r).status.cu === 2, type: "primary", size: "default", onClick: e(r).submitCU }, { default: l(() => o[4] || (o[4] = [N("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: l(() => [n(U, { ref_key: "formRef", ref: _, model: e(t), rules: C, size: "default", "label-width": "100px" }, { default: l(() => [n(i, { label: "工厂", prop: "factoryId" }, { default: l(() => [n(q, { disabled: E.value, modelValue: e(t).factoryId, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(t).factoryId = s), placeholder: "请选择工厂", style: { width: "270px" } }, null, 8, ["disabled", "modelValue"])]), _: 1 }), n(i, { label: "工序", prop: "processId" }, { default: l(() => [n(e(O), { ref_key: "processSelectRef", ref: g, modelValue: e(t).processId, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(t).processId = s), disabledProductType: [e(p).ENCLOSURE.V, e(p).MACHINE_PART.V], size: "default", multiple: false, style: { width: "270px" }, onChange: R }, null, 8, ["modelValue", "disabledProductType"])]), _: 1 }), m.value === e(p).ARTIFACT.V ? (y(), I(i, { key: 0, label: "生产线类型", prop: "productionLineTypeEnum" }, { default: l(() => [n(x, { modelValue: e(t).productionLineTypeEnum, "onUpdate:modelValue": o[2] || (o[2] = (s) => e(t).productionLineTypeEnum = s), options: e(T) ? e(f).ENUM : e(z).ENUM, type: "enum", size: "default", style: { width: "270px" }, placeholder: "请选择生产线类型" }, null, 8, ["modelValue", "options"])]), _: 1 })) : v("", true), n(i, { label: "质检", prop: "inspectorIds" }, { default: l(() => [n(e(P), { ref_key: "inspectorSelectRef", ref: V, modelValue: e(t).inspectorIds, "onUpdate:modelValue": o[3] || (o[3] = (s) => e(t).inspectorIds = s), multiple: true, placeholder: "请选择质检人员", style: { width: "270px" }, onChange: h }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  Q as default
};
