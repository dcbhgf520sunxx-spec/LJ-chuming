import { ref as g } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as V } from "vue";
import { createBlock as v } from "vue";
import { withCtx as r } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { ElInput as h } from "element-plus";
import { ElFormItem as x } from "element-plus";
import { ElInputNumber as k } from "element-plus";
import { ElForm as C } from "element-plus";
import { ao as F } from "../../../../../../../shared/runtime.js";
const q = { __name: "editFrom", setup(S) {
  const s = g(), p = { name: "", behaviorScore: "", penalty: "" }, d = { name: [{ required: true, message: "请输入分类名称", trigger: "blur" }], behaviorScore: [{ required: true, message: "请输入行为分", trigger: "blur" }], penalty: [{ required: true, message: "请输入罚金", trigger: "change" }] }, { crud: a, form: t } = F(p, s);
  return (U, o) => {
    const c = i("common-button"), u = h, m = x, _ = k, f = C, b = i("common-dialog");
    return V(), v(b, { "close-on-click-modal": false, "before-close": e(a).cancelCU, visible: e(a).status.cu > 0, title: e(a).status.title, width: "500px" }, { titleRight: r(() => [l(c, { loading: e(a).status.cu === 2, type: "primary", size: "default", onClick: e(a).submitCU }, { default: r(() => o[3] || (o[3] = [y("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: r(() => [l(f, { ref_key: "formRef", ref: s, model: e(t), rules: d, size: "default", "label-width": "100px" }, { default: r(() => [l(m, { label: "二级分类", prop: "name" }, { default: r(() => [l(u, { modelValue: e(t).name, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(t).name = n), placeholder: "输入分类名称" }, null, 8, ["modelValue"])]), _: 1 }), l(m, { label: "行为分", prop: "behaviorScore" }, { default: r(() => [l(u, { modelValue: e(t).behaviorScore, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(t).behaviorScore = n), placeholder: "请输入", oninput: "value=value.replace(/[^0-9.]/g, '').replace(/\\./g,'')" }, null, 8, ["modelValue"])]), _: 1 }), l(m, { label: "处罚（元）", prop: "penalty" }, { default: r(() => [l(_, { modelValue: e(t).penalty, "onUpdate:modelValue": o[2] || (o[2] = (n) => e(t).penalty = n), modelModifiers: { number: true }, min: 0, max: 9999999, step: 1, precision: 2, "controls-position": "right", placeholder: "请输入罚金", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  q as default
};
