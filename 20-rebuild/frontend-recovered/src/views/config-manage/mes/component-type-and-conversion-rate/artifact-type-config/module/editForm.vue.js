import { ref as b } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as g } from "vue";
import { createBlock as x } from "vue";
import { withCtx as t } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as k } from "vue";
import { ElInput as V } from "element-plus";
import { ElFormItem as y } from "element-plus";
import { ElForm as C } from "element-plus";
import { ao as h } from "../../../../../../shared/runtime.js";
const z = { __name: "editForm", setup(w) {
  const i = { name: void 0, remark: void 0 }, m = b(), { crud: a, form: r } = h(i, m), c = { name: [{ required: true, message: "请填写构件类别名称", trigger: "blur" }, { max: 20, message: "不能超过20个字符", trigger: "blur" }] };
  return (F, o) => {
    const p = u("common-button"), s = V, d = y, f = C, _ = u("common-dialog");
    return g(), x(_, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(a).cancelCU, visible: e(a).status.cu > 0, title: e(a).status.title, width: "500px" }, { titleRight: t(() => [l(p, { loading: e(a).status.cu === 2, type: "primary", size: "default", onClick: e(a).submitCU }, { default: t(() => o[2] || (o[2] = [k("确认")])), _: 1, __: [2] }, 8, ["loading", "onClick"])]), default: t(() => [l(f, { ref_key: "formRef", ref: m, model: e(r), rules: c, size: "default", "label-width": "135px" }, { default: t(() => [l(d, { label: "构件类别名称：", prop: "name" }, { default: t(() => [l(s, { modelValue: e(r).name, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(r).name = n), placeholder: "请输入", clearable: "", maxlength: "20", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(d, { label: "备注：", prop: "remark" }, { default: t(() => [l(s, { modelValue: e(r).remark, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(r).remark = n), placeholder: "请输入", clearable: "", maxlength: "20", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  z as default
};
