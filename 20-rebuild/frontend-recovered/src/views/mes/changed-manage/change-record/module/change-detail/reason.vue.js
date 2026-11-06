import { inject as m } from "vue";
import { resolveDirective as p } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as n } from "vue";
import { withCtx as l } from "vue";
import { unref as e } from "vue";
import { createElementVNode as s } from "vue";
import { withDirectives as y } from "vue";
import { toDisplayString as h } from "vue";
import { normalizeStyle as v } from "vue";
import { ElFormItem as g } from "element-plus";
import { ElForm as E } from "element-plus";
import { ElCard as R } from "element-plus";
import { _ as x, nb as S, R as T, S as b } from "../../../../../../shared/runtime.js";
const C = { style: { flex: "1" } }, k = { style: { flex: "1" } }, w = { __name: "reason", props: { heightStyle: { type: String } }, setup(i) {
  const t = m("changeInfo");
  return (B, a) => {
    const o = g, r = E, _ = R, c = p("parse-enum");
    return f(), u("div", { class: "reason-content", style: v(i.heightStyle) }, [n(_, { style: { height: "100%" } }, { default: l(() => [n(r, { ref: "formRef", model: e(t), size: "default", class: "reason-content-form" }, { default: l(() => [s("div", C, [n(o, { label: "变更原因", prop: "changeReasonTypeEnum" }, { default: l(() => [y(s("span", null, null, 512), [[c, { e: e(S), v: e(t).changeReasonTypeEnum }]])]), _: 1 }), n(o, { label: "原因描述", prop: "changeRemark" }, { default: l(() => [s("span", null, h(e(t).changeRemark), 1)]), _: 1 })]), a[2] || (a[2] = s("div", { class: "divider" }, null, -1)), s("div", k, [a[1] || (a[1] = s("div", { class: "title" }, "变更附件上传", -1)), n(T, { "show-download": "", uploadable: false, "file-classify": e(b).CHANGE_LIST_ATT.V, files: e(t).attachments, "onUpdate:files": a[0] || (a[0] = (d) => e(t).attachments = d), "empty-text": "暂未上传变更附件" }, null, 8, ["file-classify", "files"])])]), _: 1, __: [2] }, 8, ["model"])]), _: 1 })], 4);
  };
} }, D = x(w, [["__scopeId", "data-v-8a154ad5"]]);
export {
  D as default
};
