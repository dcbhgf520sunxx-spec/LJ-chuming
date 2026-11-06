import { ref as u } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as C } from "vue";
import { createBlock as y } from "vue";
import { withCtx as t } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as k } from "vue";
import { ElFormItem as v } from "element-plus";
import { ElForm as x } from "element-plus";
import { ao as w, cJ as z, ap as U } from "../../../../../shared/runtime.js";
const I = { __name: "form", props: { disabledIds: { type: Array, default: () => [] } }, setup(c) {
  const m = u(), f = { ids: void 0 }, s = u(), { crud: a, form: n } = w(f, m), p = { ids: [{ required: true, message: "请选择需要质检的科目", trigger: "change" }] };
  return (E, o) => {
    const _ = i("common-button"), b = i("common-radio-button"), r = v, g = x, V = i("common-dialog");
    return C(), y(V, { "before-close": e(a).cancelCU, "close-on-click-modal": false, title: e(a).status.title, visible: e(a).status.cu > 0, "append-to-body": "", width: "570px" }, { titleRight: t(() => [l(_, { loading: e(a).status.cu === 2, type: "primary", size: "default", onClick: e(a).submitCU }, { default: t(() => o[2] || (o[2] = [k("确认")])), _: 1, __: [2] }, 8, ["loading", "onClick"])]), default: t(() => [l(g, { ref_key: "formRef", ref: m, model: e(n), rules: p, size: "default" }, { default: t(() => [l(r, null, { default: t(() => [l(b, { modelValue: s.value, "onUpdate:modelValue": o[0] || (o[0] = (d) => s.value = d), options: e(z).ENUM, class: "filter-item", showOptionAll: "", type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(r, { prop: "ids" }, { default: t(() => [l(U, { modelValue: e(n).ids, "onUpdate:modelValue": o[1] || (o[1] = (d) => e(n).ids = d), "basic-class": s.value, disabledVal: c.disabledIds, clearable: "", size: "default", style: { width: "332px" }, multiple: "", placeholder: "请选择需要质检的科目" }, null, 8, ["modelValue", "basic-class", "disabledVal"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} };
export {
  I as default
};
