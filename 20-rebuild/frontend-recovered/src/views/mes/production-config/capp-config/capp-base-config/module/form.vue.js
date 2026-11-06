import { ref as E } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as r } from "vue";
import { createBlock as c } from "vue";
import { withCtx as t } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { createElementBlock as C } from "vue";
import { toDisplayString as w } from "vue";
import { ElInput as x } from "element-plus";
import { ElFormItem as h } from "element-plus";
import { ElInputNumber as U } from "element-plus";
import { ElSwitch as B } from "element-plus";
import { ElForm as S } from "element-plus";
import { ao as R, G as z, aS as d } from "../../../../../../shared/runtime.js";
const I = { key: 1 }, q = { __name: "form", setup(N) {
  const m = E(), p = { id: void 0, sort: "", dictValue: "", enabledFlag: void 0 }, { crud: n, form: o } = R(p, m), _ = { dictValue: [{ required: true, message: "请填写字典值", trigger: "blur" }] };
  return (L, l) => {
    const f = u("common-button"), b = x, i = h, V = U, g = B, v = S, F = u("common-dialog");
    return r(), c(F, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, width: "550px" }, { titleRight: t(() => [a(f, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: t(() => l[3] || (l[3] = [y("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: t(() => [a(v, { ref_key: "formRef", ref: m, model: e(o), rules: _, size: "default", "label-width": "70px" }, { default: t(() => [a(i, { label: "字典值", prop: "dictValue" }, { default: t(() => [a(b, { modelValue: e(o).dictValue, "onUpdate:modelValue": l[0] || (l[0] = (s) => e(o).dictValue = s), modelModifiers: { trim: true }, placeholder: "请输入字典值", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), a(i, { label: "排序", prop: "sort" }, { default: t(() => [a(V, { modelValue: e(o).sort, "onUpdate:modelValue": l[1] || (l[1] = (s) => e(o).sort = s), clearable: "", placeholder: "请输入排序", min: 0, max: 9999999, "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), a(i, { label: "状态", prop: "enabledFlag" }, { default: t(() => {
      var s;
      return [e(z)(e(n).permission.editStatus) ? (r(), c(g, { key: 0, modelValue: e(o).enabledFlag, "onUpdate:modelValue": l[2] || (l[2] = (k) => e(o).enabledFlag = k), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(d).TRUE.V, "inactive-value": e(d).FALSE.V }, null, 8, ["modelValue", "active-value", "inactive-value"])) : (r(), C("span", I, w((s = e(d).VL) == null ? void 0 : s[e(o).enabledFlag]), 1))];
    }), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  q as default
};
