import { ref as c } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as d } from "vue";
import { createBlock as E } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as v } from "vue";
import { createElementBlock as w } from "vue";
import { Fragment as C } from "vue";
import { renderList as I } from "vue";
import { ElFormItem as T } from "element-plus";
import { ElOption as U } from "element-plus";
import { ElSelect as D } from "element-plus";
import { ElInputNumber as q } from "element-plus";
import { ElForm as F } from "element-plus";
import { g8 as R, ao as z, qe as B } from "../../../../../shared/runtime.js";
const j = { __name: "form", setup(N) {
  const m = R(["enclosure_type"]), u = c(), p = { enclosureTypeDictionaryId: void 0, unit: void 0, price: void 0 }, { crud: r, form: a } = z(p, u), _ = [B.METER.L], f = c({ enclosureTypeDictionaryId: [{ required: true, message: "请选择围护类型", trigger: "change" }], unit: [{ required: true, message: "请选择单位", trigger: "change" }], price: [{ required: true, message: "请输入单价", trigger: "change" }] });
  return (S, l) => {
    const b = i("common-button"), g = i("common-select"), s = T, y = U, V = D, h = q, x = F, k = i("common-dialog");
    return d(), E(k, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(r).cancelCU, visible: e(r).status.cu > 0, title: e(r).status.title, top: "2vh", width: "600px" }, { titleRight: n(() => [t(b, { loading: e(r).status.cu === 2, type: "primary", size: "default", onClick: e(r).submitCU }, { default: n(() => l[3] || (l[3] = [v("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: n(() => [t(x, { ref_key: "formRef", ref: u, model: e(a), rules: f.value, size: "default", "label-width": "150px" }, { default: n(() => [t(s, { label: "围护类型：", prop: "enclosureTypeDictionaryId" }, { default: n(() => [t(g, { modelValue: e(a).enclosureTypeDictionaryId, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(a).enclosureTypeDictionaryId = o), options: e(m).enclosure_type, placeholder: "选择围护类型", dataStructure: { key: "id", label: "label", value: "id" }, type: "other", clearable: "", filterable: "", style: { width: "340px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), t(s, { label: "单位：", prop: "unit" }, { default: n(() => [t(V, { modelValue: e(a).unit, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(a).unit = o), clearable: "", size: "default", placeholder: "选择单位", style: { width: "340px" } }, { default: n(() => [(d(), w(C, null, I(_, (o) => t(y, { key: o, label: o, value: o }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), t(s, { label: "单价（元）：", prop: "price" }, { default: n(() => [t(h, { modelValue: e(a).price, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(a).price = o), placeholder: "输入单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "340px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  j as default
};
