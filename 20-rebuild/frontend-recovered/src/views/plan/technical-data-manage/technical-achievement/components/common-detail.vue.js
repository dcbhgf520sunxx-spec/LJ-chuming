import { resolveComponent as f } from "vue";
import { openBlock as i } from "vue";
import { createBlock as p } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as b } from "vue";
import { createVNode as V } from "vue";
import { unref as l } from "vue";
import { isRef as g } from "vue";
import { ElTag as _ } from "element-plus";
import { u as v } from "../../../../../shared/runtime.js";
import C from "./match-detail/index.vue.js";
import "./drawing-upload-btn.vue.js";
import "../../../../../modules/index-ce9deea8.js";
import "./match-detail/module/header.vue.js";
const B = { __name: "common-detail", props: { modelValue: { type: Boolean, require: false }, currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, title: { type: String, default: "文件匹配详情" }, uploadType: { type: String, default: ".pdf" }, tip: { type: String, default: void 0 } }, emits: ["success", "update:modelValue"], setup(o, { emit: m }) {
  const e = o, s = m, { visible: r, handleClose: u } = v({ emit: s, props: e });
  return (N, t) => {
    const c = _, d = f("common-drawer");
    return i(), p(d, { "append-to-body": "", modelValue: l(r), "onUpdate:modelValue": t[1] || (t[1] = (n) => g(r) ? r.value = n : null), top: "10vh", "before-close": l(u), title: e.title, "wrapper-closable": false, size: "80%" }, { titleAfter: a(() => [o.currentRow.monomerName ? (i(), p(c, { key: 0, size: "large", effect: "plain" }, { default: a(() => [y(w(o.currentRow.monomerName), 1)]), _: 1 })) : b("", true)]), content: a(() => [V(l(C), { "current-row": e.currentRow, permission: e.permission, "upload-type": e.uploadType, tip: e.tip, onSuccess: t[0] || (t[0] = (n) => s("success")) }, null, 8, ["current-row", "permission", "upload-type", "tip"])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} };
export {
  B as default
};
