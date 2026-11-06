import { ref as p } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as o } from "vue";
import { createBlock as g } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as r } from "vue";
import { createElementBlock as n } from "vue";
import { createTextVNode as m } from "vue";
import { unref as s } from "vue";
import { Fragment as u } from "vue";
import { renderList as _ } from "vue";
import { createCommentVNode as I } from "vue";
import { isRef as P } from "vue";
import { ElDescriptionsItem as z } from "element-plus";
import { ElTooltip as M } from "element-plus";
import { ElDescriptions as U } from "element-plus";
import { ElDivider as q } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { _ as G, u as J, o as K, ts as Q, tt as W, i as D, z as k, p as X, iy as Y } from "../../../../../../shared/runtime.js";
const Z = { style: { "word-break": "break-all" } }, ee = { key: 1 }, te = { class: "project-div" }, ae = { style: { "word-break": "break-all" } }, le = ["onDblclick"], oe = { key: 1 }, ne = { __name: "history-version", props: { modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(e, { emit: V }) {
  const x = e, j = V, { visible: w, handleClose: O } = J({ emit: j, props: x }), v = p(), { maxHeight: N } = K({ mainBox: [".history-version", ".table-form"], extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, v), b = p(false), R = p(), L = p([["uploadTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]);
  function y(T) {
    R.value = T.id, b.value = true;
  }
  return (T, c) => {
    const i = z, B = M, C = U, E = q, d = A, F = h("common-button"), S = h("common-table"), H = h("common-drawer");
    return o(), g(H, { "append-to-body": "", ref_key: "drawerRef", ref: v, modelValue: s(w), "onUpdate:modelValue": c[2] || (c[2] = (a) => P(w) ? w.value = a : null), top: "10vh", width: "600px", "before-close": s(O), title: "修订版本", "wrapper-closable": false, size: "900px", "custom-class": "history-version" }, { content: l(() => [t(C, { class: "margin-top", column: 2, border: "", "label-width": "110" }, { default: l(() => [t(i, { "label-class-name": "fileName", label: "文件名称", span: 2 }, { default: l(() => [f("div", Z, r(e.currentRow.fileName), 1)]), _: 1 }), t(i, { "label-class-name": "attachmentDTO", label: "文件", span: 2 }, { default: l(() => [e.currentRow.attachmentDTO ? (o(), n("div", { key: 0, style: { cursor: "pointer", color: "#409eff", "word-break": "break-all" }, onDblclick: c[0] || (c[0] = (a) => y(e.currentRow.attachmentDTO)) }, r(e.currentRow.attachmentDTO.name), 33)) : (o(), n("span", ee, "-"))]), _: 1 }), t(i, { "label-class-name": "processType", label: "文件类型" }, { default: l(() => [m(r(s(Q).VL[e.currentRow.processType]), 1)]), _: 1 }), t(i, { "label-class-name": "boolSingleProject", label: "文件属性" }, { default: l(() => [m(r(s(W).VL[e.currentRow.boolSingleProject]), 1)]), _: 1 }), t(i, { "label-class-name": "project", label: e.currentRow.boolSingleProject ? "所属项目" : "关联项目", span: 2 }, { default: l(() => [t(B, { placement: "top" }, { content: l(() => [s(D)(e.currentRow.projectList) ? (o(true), n(u, { key: 0 }, _(e.currentRow.projectList, (a) => (o(), n("div", { key: a.id }, r(s(k)(a)), 1))), 128)) : (o(), n(u, { key: 1 }, [m("-")], 64))]), default: l(() => [f("div", te, [s(D)(e.currentRow.projectList) ? (o(), n(u, { key: 0 }, [e.currentRow.projectList.length === 1 ? (o(true), n(u, { key: 0 }, _(e.currentRow.projectList, (a) => (o(), n("span", { key: a.id }, r(s(k)(a)), 1))), 128)) : (o(true), n(u, { key: 1 }, _(e.currentRow.projectList, (a) => (o(), n("span", { key: a.id }, "【" + r(s(k)(a)) + "】", 1))), 128))], 64)) : (o(), n(u, { key: 1 }, [m("-")], 64))])]), _: 1 })]), _: 1 }, 8, ["label"]), t(i, { "label-class-name": "userName", label: "上传人" }, { default: l(() => [m(r(e.currentRow.userName), 1)]), _: 1 }), t(i, { "label-class-name": "uploadTime", label: "上传日期" }, { default: l(() => [m(r(e.currentRow.uploadTime ? s(X)(e.currentRow.uploadTime, "{y}-{m}-{d} {h}:{i}:{s}") : "-"), 1)]), _: 1 }), t(i, { "label-class-name": "remark", label: "备注" }, { default: l(() => [f("div", ae, r(e.currentRow.remark), 1)]), _: 1 })]), _: 1 }), t(E, null, { default: l(() => c[3] || (c[3] = [f("span", { class: "title" }, "历史修订版本", -1)])), _: 1, __: [3] }), t(S, { ref: "detailRef", border: "", data: e.currentRow.processFileRecordDTOList, "max-height": s(N) - 380, style: { width: "100%" }, class: "table-form", dataFormat: L.value }, { default: l(() => [t(d, { label: "序号", type: "index", align: "center", width: "55" }), t(d, { prop: "fileVersion", label: "版本", align: "center", width: "80" }), t(d, { key: "attachmentDTO", prop: "attachmentDTO", label: "文件", align: "left" }, { default: l((a) => [a.row.attachmentDTO ? (o(), n("div", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onDblclick: ($) => y(a.row.attachmentDTO) }, r(a.row.attachmentDTO.name), 41, le)) : (o(), n("span", oe, "-"))]), _: 1 }), t(d, { prop: "userName", label: "上传人", align: "center", width: "90" }), t(d, { prop: "uploadTime", label: "上传时间", align: "center", width: "140" }), t(d, { label: "操作", align: "center", width: "80" }, { default: l((a) => [t(F, { size: "default", icon: "el-icon-view", type: "primary", onClick: ($) => y(a.row.attachmentDTO) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "dataFormat"]), b.value ? (o(), g(Y, { key: 0, isVisible: b.value, showType: "attachment", id: R.value, onClose: c[1] || (c[1] = (a) => b.value = false) }, null, 8, ["isVisible", "id"])) : I("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ce = G(ne, [["__scopeId", "data-v-1d79d54e"]]);
export {
  ce as default
};
