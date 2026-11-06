import { inject as g } from "vue";
import { ref as h } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as o } from "vue";
import { withCtx as n } from "vue";
import { unref as a } from "vue";
import { createElementVNode as r } from "vue";
import { normalizeStyle as E } from "vue";
import { ElFormItem as b } from "element-plus";
import { ElInput as V } from "element-plus";
import { ElForm as w } from "element-plus";
import { ElCard as T } from "element-plus";
import { _ as k, nb as S, R as C, S as z } from "../../../../../../shared/runtime.js";
const B = { style: { flex: "1" } }, I = { style: { flex: "1" } }, N = { __name: "reason", props: { heightStyle: { type: String } }, setup(p, { expose: c }) {
  const t = g("form"), m = h(), u = { changeReasonTypeEnum: [{ required: true, message: "请选择变更原因", trigger: "change" }], changeRemark: [{ max: 200, message: "不能超过 200 个字符", trigger: "blur" }] };
  return c({ validate: () => new Promise((i, e) => {
    m.value.validate((l) => {
      l ? i(l) : e();
    });
  }) }), (i, e) => {
    const l = R("common-select"), d = b, _ = V, f = w, y = T;
    return x(), v("div", { class: "reason-content", style: E(p.heightStyle) }, [o(y, { style: { height: "100%" } }, { default: n(() => [o(f, { ref_key: "formRef", ref: m, model: a(t), rules: u, size: "default", class: "reason-content-form", "label-width": "100px" }, { default: n(() => [r("div", B, [o(d, { label: "变更原因", prop: "changeReasonTypeEnum" }, { default: n(() => [o(l, { modelValue: a(t).changeReasonTypeEnum, "onUpdate:modelValue": e[0] || (e[0] = (s) => a(t).changeReasonTypeEnum = s), options: a(S).ENUM, type: "enum", clearable: "", placeholder: "请选择变更原因" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(d, { label: "原因描述", prop: "changeRemark" }, { default: n(() => [o(_, { modelValue: a(t).changeRemark, "onUpdate:modelValue": e[1] || (e[1] = (s) => a(t).changeRemark = s), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 6, maxRows: 10 }, maxlength: 600, placeholder: "请填写原因描述", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), e[4] || (e[4] = r("div", { class: "divider" }, null, -1)), r("div", I, [e[3] || (e[3] = r("div", { class: "title" }, "变更附件上传", -1)), o(C, { "show-download": "", "file-classify": a(z).CHANGE_LIST_ATT.V, files: a(t).attachments, "onUpdate:files": e[2] || (e[2] = (s) => a(t).attachments = s), "empty-text": "暂未上传变更附件" }, null, 8, ["file-classify", "files"])])]), _: 1, __: [4] }, 8, ["model"])]), _: 1 })], 4);
  };
} }, L = k(N, [["__scopeId", "data-v-615af1b4"]]);
export {
  L as default
};
