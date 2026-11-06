import { ref as m } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as i } from "vue";
import { createBlock as w } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as r } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as u } from "vue";
import { createElementBlock as d } from "vue";
import { unref as n } from "vue";
import { Fragment as T } from "vue";
import { renderList as S } from "vue";
import { createCommentVNode as $ } from "vue";
import { isRef as L } from "vue";
import { ElDescriptionsItem as O } from "element-plus";
import { ElCol as I } from "element-plus";
import { ElRow as P } from "element-plus";
import { ElDescriptions as U } from "element-plus";
import { _ as F, u as z, ts as h, tt as q, i as A, z as G, p as H, iy as J } from "../../../../../../shared/runtime.js";
import K from "./history-version.vue.js";
import M from "./artifact-bind-detail.vue.js";
import "../../../../../../modules/process-611d795f.js";
import "../../../../../../modules/plan-d12d7ccf.js";
const Q = { style: { "word-break": "break-all" } }, W = { key: 1 }, X = { style: { "word-break": "break-all" } }, Y = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(t, { emit: g }) {
  const D = t, v = g, { visible: b, handleClose: N } = z({ emit: v, props: D }), f = m(false), p = m(false), c = m(false), y = m();
  function j(R) {
    y.value = R.id, c.value = true;
  }
  return (R, e) => {
    const V = k("common-button"), s = O, C = I, x = P, E = U, B = k("common-drawer");
    return i(), w(B, { "append-to-body": "", ref: "drawerRef", modelValue: n(b), "onUpdate:modelValue": e[7] || (e[7] = (o) => L(b) ? b.value = o : null), top: "10vh", width: "600px", "before-close": n(N), title: "文件详情", "wrapper-closable": false, size: "900px", "custom-class": "contract-change" }, { titleRight: l(() => [a(V, { type: "info", onClick: e[0] || (e[0] = (o) => f.value = true) }, { default: l(() => e[8] || (e[8] = [r("修订版本")])), _: 1, __: [8] }), a(V, { type: "primary", onClick: e[1] || (e[1] = (o) => p.value = true) }, { default: l(() => e[9] || (e[9] = [r("绑定列表")])), _: 1, __: [9] })]), content: l(() => [a(E, { class: "margin-top", column: 2, border: "", "label-width": "110" }, { default: l(() => [a(s, { "label-class-name": "fileName", label: "文件名称", span: 2 }, { default: l(() => [_("div", Q, u(t.currentRow.fileName), 1)]), _: 1 }), a(s, { "label-class-name": "attachmentDTO", label: "文件", span: 2 }, { default: l(() => [t.currentRow.attachmentDTO ? (i(), d("div", { key: 0, style: { cursor: "pointer", color: "#409eff", "word-break": "break-all" }, onDblclick: e[2] || (e[2] = (o) => j(t.currentRow.attachmentDTO)) }, u(t.currentRow.attachmentDTO.name), 33)) : (i(), d("span", W, "-"))]), _: 1 }), a(s, { "label-class-name": "processType", label: "文件类型" }, { default: l(() => [r(u(n(h).VL[t.currentRow.processType]), 1)]), _: 1 }), a(s, { "label-class-name": "boolSingleProject", label: "文件属性" }, { default: l(() => [r(u(n(q).VL[t.currentRow.boolSingleProject]), 1)]), _: 1 }), a(s, { "label-class-name": "project", label: t.currentRow.boolSingleProject ? "所属项目" : "关联项目", span: 2 }, { default: l(() => [a(x, null, { default: l(() => [n(A)(t.currentRow.projectList) ? (i(true), d(T, { key: 0 }, S(t.currentRow.projectList, (o) => (i(), w(C, { key: o.id, span: 12 }, { default: l(() => [r(" 【" + u(n(G)(o)) + "】 ", 1)]), _: 2 }, 1024))), 128)) : (i(), d(T, { key: 1 }, [r("-")], 64))]), _: 1 })]), _: 1 }, 8, ["label"]), a(s, { "label-class-name": "userName", label: "上传人" }, { default: l(() => [r(u(t.currentRow.userName), 1)]), _: 1 }), a(s, { "label-class-name": "uploadTime", label: "上传日期" }, { default: l(() => [r(u(t.currentRow.uploadTime ? n(H)(t.currentRow.uploadTime, "{y}-{m}-{d} {h}:{i}:{s}") : "-"), 1)]), _: 1 }), a(s, { "label-class-name": "remark", label: "备注" }, { default: l(() => [_("div", X, u(t.currentRow.remark), 1)]), _: 1 })]), _: 1 }), a(n(K), { modelValue: f.value, "onUpdate:modelValue": e[3] || (e[3] = (o) => f.value = o), currentRow: t.currentRow }, null, 8, ["modelValue", "currentRow"]), a(n(M), { modelValue: p.value, "onUpdate:modelValue": e[4] || (e[4] = (o) => p.value = o), currentRow: t.currentRow, onSuccess: e[5] || (e[5] = (o) => v("success")) }, null, 8, ["modelValue", "currentRow"]), c.value ? (i(), w(J, { key: 0, isVisible: c.value, showType: "attachment", id: y.value, onClose: e[6] || (e[6] = (o) => c.value = false) }, null, 8, ["isVisible", "id"])) : $("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ne = F(Y, [["__scopeId", "data-v-0672e2a8"]]);
export {
  ne as default
};
