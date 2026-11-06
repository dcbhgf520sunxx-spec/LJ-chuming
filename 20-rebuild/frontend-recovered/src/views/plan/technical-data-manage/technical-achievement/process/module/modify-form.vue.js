import { ref as b } from "vue";
import { watch as Z } from "vue";
import { nextTick as ee } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as le } from "vue";
import { openBlock as u } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as z } from "vue";
import { createTextVNode as d } from "vue";
import { unref as s } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as i } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as V } from "vue";
import { renderList as I } from "vue";
import { createCommentVNode as P } from "vue";
import { isRef as te } from "vue";
import { ElMessage as _ } from "element-plus";
import { ElDivider as ae } from "element-plus";
import { ElDescriptionsItem as oe } from "element-plus";
import { ElCol as ne } from "element-plus";
import { ElRow as re } from "element-plus";
import { ElDescriptions as se } from "element-plus";
import { ElInput as ie } from "element-plus";
import { ElForm as ue } from "element-plus";
import { vLoading as de } from "element-plus";
import { c as me } from "../../../../../../modules/process-611d795f.js";
import { _ as ce, u as fe, ts as B, tt as $, i as A, z as U, p as J, S as pe, iy as ve } from "../../../../../../shared/runtime.js";
import { _ as be } from "../../../../../../modules/UploadBtn-b4cfb47a.js";
import { j as ye } from "../../../../../../modules/judgeSameValue-9683bdce.js";
import { u as we } from "../../../../../../modules/plan-d12d7ccf.js";
import ke from "./history-version.vue.js";
const Re = { style: { "word-break": "break-all" } }, ge = { key: 1 }, Ve = { style: { "word-break": "break-all", width: "100%" } }, _e = { style: { display: "flex" } }, xe = { style: { flex: "1", "padding-right": "10px" } }, he = { style: { "text-align": "right" } }, Ne = { __name: "modify-form", props: { modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(o, { emit: M }) {
  const x = o, t = b(JSON.parse(JSON.stringify({ fileName: void 0, file: void 0, attachmentId: void 0, remark: void 0 }))), w = b(), k = b(), F = M, { visible: g, handleClose: D } = fe({ emit: F, props: x }), h = b(false), R = b(false), N = b(), T = b(false);
  Z(() => g.value, (c) => {
    w.value && w.value.resetFields(), t.value = JSON.parse(JSON.stringify(x.currentRow)), w.value && ee(() => {
      w.value.clearValidate();
    }), k.value && k.value.clearFiles(), t.value.attachmentFiles = [];
  }, { deep: true, immediate: true });
  function S(c) {
    N.value = c.id, R.value = true;
  }
  function q(c) {
    N.value = c.attachmentId, R.value = true;
  }
  function G() {
    const c = t.value.attachmentFiles[0].name, e = c.split(".");
    let p = "";
    for (let f = 0; f < e.length; f++) f !== e.length - 1 && (f !== e.length - 2 ? p = p + e[f] + "." : p = p + e[f]);
    t.value.fileName = p, t.value.file = c, t.value.attachmentId = t.value.attachmentFiles[0].id, k.value && k.value.clearFiles(), t.value.attachmentFiles = [];
  }
  function H() {
    F("success"), D();
  }
  async function K() {
    if (ye(x.currentRow, t.value)) {
      _.error("未改动，请修改后提交");
      return;
    }
    if (!t.value.fileName) {
      _.error("新文件文件名称不能为空");
      return;
    }
    if (t.value.fileName.length > 50) {
      _.error("新文件文件名称长度不能超过50");
      return;
    }
    T.value = true;
    try {
      await me.edit({ attachmentId: t.value.attachmentId, fileName: t.value.fileName, id: t.value.id, remark: t.value.remark }), _.success("修改成功"), H();
    } catch (c) {
      console.log("提交失败", c);
    } finally {
      T.value = false;
    }
  }
  return (c, e) => {
    const p = O("common-button"), f = ae, r = oe, j = ne, E = re, L = se, C = ie, Q = ue, W = O("common-drawer"), X = le("permission"), Y = de;
    return u(), y(W, { ref: "drawerRef", modelValue: s(g), "onUpdate:modelValue": e[9] || (e[9] = (n) => te(g) ? g.value = n : null), "before-close": s(D), "wrapper-closable": false, "append-to-body": "", "custom-class": "contract-change", size: "900px", title: "文件修改", top: "10vh", width: "600px" }, { titleRight: l(() => [z((u(), y(p, { type: "info", onClick: e[0] || (e[0] = (n) => h.value = true) }, { default: l(() => e[10] || (e[10] = [d("修订版本")])), _: 1, __: [10] })), [[X, s(we).detail]]), z((u(), y(p, { size: "default", type: "primary", onClick: K }, { default: l(() => e[11] || (e[11] = [d("提交")])), _: 1, __: [11] })), [[Y, T.value]])]), content: l(() => [a(f, null, { default: l(() => e[12] || (e[12] = [m("span", { class: "title" }, "原文件信息", -1)])), _: 1, __: [12] }), a(L, { column: 2, border: "", class: "margin-top", "label-width": "110" }, { default: l(() => [a(r, { span: 2, label: "文件名称" }, { default: l(() => [m("div", Re, i(o.currentRow.fileName), 1)]), _: 1 }), a(r, { span: 2, label: "文件" }, { default: l(() => [o.currentRow.attachmentDTO ? (u(), v("div", { key: 0, style: { cursor: "pointer", color: "#409eff", "word-break": "break-all" }, onDblclick: e[1] || (e[1] = (n) => S(o.currentRow.attachmentDTO)) }, i(o.currentRow.attachmentDTO.name), 33)) : (u(), v("span", ge, "-"))]), _: 1 }), a(r, { label: "文件类型" }, { default: l(() => [d(i(s(B).VL[o.currentRow.processType]), 1)]), _: 1 }), a(r, { label: "文件属性" }, { default: l(() => [d(i(s($).VL[o.currentRow.boolSingleProject]), 1)]), _: 1 }), a(r, { span: 2, label: "所属项目" }, { default: l(() => [a(E, null, { default: l(() => [s(A)(o.currentRow.projectList && o.currentRow.boolSingleProject) ? (u(true), v(V, { key: 0 }, I(o.currentRow.projectList, (n) => (u(), y(j, { key: n.id, span: 12 }, { default: l(() => [d(i(s(U)(n)), 1)]), _: 2 }, 1024))), 128)) : (u(), v(V, { key: 1 }, [d("-")], 64))]), _: 1 })]), _: 1 }), a(r, { label: "上传人" }, { default: l(() => [d(i(o.currentRow.userName), 1)]), _: 1 }), a(r, { label: "上传日期" }, { default: l(() => [d(i(o.currentRow.uploadTime ? s(J)(o.currentRow.uploadTime, "{y}-{m}-{d} {h}:{i}:{s}") : "-"), 1)]), _: 1 }), a(r, { label: "备注" }, { default: l(() => [m("div", Ve, i(o.currentRow.remark), 1)]), _: 1 })]), _: 1 }), a(f, null, { default: l(() => e[13] || (e[13] = [m("span", { class: "title", style: { "background-color": "#e6a23c" } }, "新文件信息", -1)])), _: 1, __: [13] }), a(Q, { ref_key: "formRef", ref: w, model: t.value, rules: c.rules, size: "default" }, { default: l(() => [a(L, { column: 2, border: "", class: "margin-top", "label-width": "110" }, { default: l(() => [a(r, { span: 2, label: "*文件名称", "label-class-name": "modify-content" }, { label: l(() => e[14] || (e[14] = [m("span", { style: { color: "red", "margin-right": "5px", "font-size": "14px" } }, "*", -1), m("span", null, "文件名称", -1)])), default: l(() => [a(C, { modelValue: t.value.fileName, "onUpdate:modelValue": e[2] || (e[2] = (n) => t.value.fileName = n), modelModifiers: { trim: true }, autosize: { minRows: 1, maxRows: 3 }, maxlength: 50, class: "input-border-none", clearable: "", placeholder: "名称", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }), a(r, { span: 2, label: "*文件", "label-class-name": "modify-content" }, { label: l(() => e[15] || (e[15] = [m("span", { style: { color: "red", "margin-right": "5px", "font-size": "14px" } }, "*", -1), m("span", null, "文件", -1)])), default: l(() => [m("div", _e, [m("div", xe, [t.value.file ? (u(), v("span", { key: 0, style: { cursor: "pointer", color: "#409eff", "word-break": "break-all" }, onDblclick: e[3] || (e[3] = (n) => q(t.value)) }, i(t.value.file), 33)) : t.value.attachmentDTO ? (u(), v("span", { key: 1, style: { cursor: "pointer", color: "#409eff", "word-break": "break-all" }, onDblclick: e[4] || (e[4] = (n) => S(t.value.attachmentDTO)) }, i(t.value.attachmentDTO.name), 33)) : P("", true)]), m("div", he, [a(s(be), { ref_key: "uploadRef", ref: k, files: t.value.attachmentFiles, "onUpdate:files": e[5] || (e[5] = (n) => t.value.attachmentFiles = n), accept: ".pdf", btnName: "变更文件", "file-classify": s(pe).PLAN_ATT.V, limit: 1, "show-file-list": false, btnType: "warning", onChange: G }, null, 8, ["files", "file-classify"])])])]), _: 1 }), a(r, { label: "文件类型" }, { default: l(() => [d(i(s(B).VL[o.currentRow.processType]), 1)]), _: 1 }), a(r, { label: "文件属性" }, { default: l(() => [d(i(s($).VL[o.currentRow.boolSingleProject]), 1)]), _: 1 }), a(r, { span: 2, label: "所属项目" }, { default: l(() => [a(E, null, { default: l(() => [s(A)(o.currentRow.projectList && o.currentRow.boolSingleProject) ? (u(true), v(V, { key: 0 }, I(o.currentRow.projectList, (n) => (u(), y(j, { key: n.id, span: 12 }, { default: l(() => [d(i(s(U)(n)), 1)]), _: 2 }, 1024))), 128)) : (u(), v(V, { key: 1 }, [d("-")], 64))]), _: 1 })]), _: 1 }), a(r, { label: "上传人" }, { default: l(() => [d(i(o.currentRow.userName), 1)]), _: 1 }), a(r, { label: "上传日期" }, { default: l(() => [d(i(o.currentRow.uploadTime ? s(J)(o.currentRow.uploadTime, "{y}-{m}-{d} {h}:{i}:{s}") : "-"), 1)]), _: 1 }), a(r, { label: "备注", "label-class-name": "modify-content" }, { default: l(() => [a(C, { modelValue: t.value.remark, "onUpdate:modelValue": e[6] || (e[6] = (n) => t.value.remark = n), modelModifiers: { trim: true }, autosize: { minRows: 1, maxRows: 3 }, maxlength: 200, class: "input-border-none", placeholder: "备注", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e[16] || (e[16] = m("div", { style: { color: "#e6a23c", "margin-top": "10px", "font-size": "13px" } }, "* 1. 深色框内的信息可进行修改，其它信息不可变更", -1)), e[17] || (e[17] = m("div", { style: { color: "#e6a23c", "font-size": "13px", "margin-top": "3px" } }, "* 2. 更换工艺文件会生成新的修订版本", -1))]), _: 1, __: [16, 17] }, 8, ["model", "rules"]), a(s(ke), { modelValue: h.value, "onUpdate:modelValue": e[7] || (e[7] = (n) => h.value = n), currentRow: o.currentRow }, null, 8, ["modelValue", "currentRow"]), R.value ? (u(), y(ve, { key: 0, id: N.value, isVisible: R.value, showType: "attachment", onClose: e[8] || (e[8] = (n) => R.value = false) }, null, 8, ["id", "isVisible"])) : P("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Oe = ce(Ne, [["__scopeId", "data-v-8880933c"]]);
export {
  Oe as default
};
