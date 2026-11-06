import { ref as V } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as h } from "vue";
import { createBlock as y } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as x } from "vue";
import { createElementVNode as U } from "vue";
import { toDisplayString as E } from "vue";
import { ElInput as S } from "element-plus";
import { ElFormItem as w } from "element-plus";
import { ElInputNumber as C } from "element-plus";
import { ElSwitch as k } from "element-plus";
import { ElForm as F } from "element-plus";
import { ao as B, au as p } from "../../../../../../../shared/runtime.js";
const N = { style: { "margin-left": "4px" } }, T = { __name: "editFrom", setup(R) {
  const m = V(), d = { name: "", behaviorScore: "", penalty: "", boolUpdate: false }, c = { name: [{ required: true, message: "请输入分类名称", trigger: "blur" }], behaviorScore: [{ required: true, message: "请输入行为分", trigger: "blur" }], penalty: [{ required: true, message: "请输入罚金", trigger: "change" }] }, { crud: r, form: o } = B(d, m);
  return (q, l) => {
    const _ = i("common-button"), u = S, s = w, f = C, b = k, g = F, v = i("common-dialog");
    return h(), y(v, { "close-on-click-modal": false, "before-close": e(r).cancelCU, visible: e(r).status.cu > 0, title: e(r).status.title, width: "500px" }, { titleRight: n(() => [t(_, { loading: e(r).status.cu === 2, type: "primary", size: "default", onClick: e(r).submitCU }, { default: n(() => l[4] || (l[4] = [x("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: n(() => [t(g, { ref_key: "formRef", ref: m, model: e(o), rules: c, size: "default", "label-width": "100px" }, { default: n(() => [t(s, { label: "二级分类", prop: "name" }, { default: n(() => [t(u, { modelValue: e(o).name, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(o).name = a), maxlength: 8, placeholder: "输入分类名称" }, null, 8, ["modelValue"])]), _: 1 }), t(s, { label: "行为分", prop: "behaviorScore" }, { default: n(() => [t(u, { modelValue: e(o).behaviorScore, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(o).behaviorScore = a), placeholder: "请输入", oninput: "value=value.replace(/[^0-9.]/g, '').replace(/\\./g,'')" }, null, 8, ["modelValue"])]), _: 1 }), t(s, { label: "处罚（元）", prop: "penalty" }, { default: n(() => [t(f, { modelValue: e(o).penalty, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(o).penalty = a), modelModifiers: { number: true }, min: 0, max: 9999999, step: 1, precision: 2, "controls-position": "right", placeholder: "请输入罚金", style: { width: "200px" } }, null, 8, ["modelValue"]), t(b, { modelValue: e(o).boolUpdate, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(o).boolUpdate = a), "active-value": e(p).TRUE.V, "inactive-value": e(p).FALSE.V, style: { "margin-left": "10px" } }, null, 8, ["modelValue", "active-value", "inactive-value"]), U("span", N, E(e(o).boolUpdate ? "可" : "不可") + "修改金额", 1)]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  T as default
};
