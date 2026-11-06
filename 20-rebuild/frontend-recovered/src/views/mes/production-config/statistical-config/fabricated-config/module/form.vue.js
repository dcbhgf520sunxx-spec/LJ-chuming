import { ref as b } from "vue";
import { resolveComponent as r } from "vue";
import { openBlock as g } from "vue";
import { createBlock as x } from "vue";
import { withCtx as o } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { createElementVNode as C } from "vue";
import { toDisplayString as k } from "vue";
import { ElFormItem as V } from "element-plus";
import { ElForm as w } from "element-plus";
import { ao as z } from "../../../../../../shared/runtime.js";
const h = { __name: "form", setup(B) {
  const s = b(), i = { id: void 0 }, { crud: t, form: n } = z(i, s), u = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }] };
  return (F, a) => {
    const c = r("common-button"), m = V, d = r("common-input-number"), f = w, p = r("common-dialog");
    return g(), x(p, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(t).cancelCU, visible: e(t).status.cu > 0, title: e(t).status.title, width: "500px" }, { titleRight: o(() => [l(c, { loading: e(t).status.cu === 2, type: "primary", size: "default", onClick: e(t).submitCU }, { default: o(() => a[1] || (a[1] = [y("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), default: o(() => [l(f, { ref_key: "formRef", ref: s, model: e(n), rules: u, size: "default", "label-width": "110px" }, { default: o(() => [l(m, { label: "类别" }, { default: o(() => [C("span", null, k(e(n).auxiliaryName), 1)]), _: 1 }), l(m, { label: "单价（元）", prop: "unitPrice" }, { default: o(() => [l(d, { modelValue: e(n).unitPrice, "onUpdate:modelValue": a[0] || (a[0] = (_) => e(n).unitPrice = _), min: 0, max: 9999999, controls: false, step: 1, size: "default", placeholder: "单价", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  h as default
};
