import { ref as o } from "vue";
import { watchEffect as W } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as s } from "vue";
import { withCtx as r } from "vue";
import { renderSlot as Y } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as v } from "vue";
import { createCommentVNode as p } from "vue";
import { vShow as Z } from "vue";
import { toDisplayString as ee } from "vue";
import { unref as T } from "vue";
import { ElUpload as ae } from "element-plus";
import { ElMessage as b } from "element-plus";
import { ElMessageBox as E } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { _ as le, S as ne, m as ie, X as oe, L as se, iy as de } from "../../../../shared/runtime.js";
const ue = { class: "upload-container" }, fe = { class: "attachment-content" }, ce = { key: 0 }, re = { __name: "UploadList", props: { data: { type: Object, default: void 0 }, files: { type: Array, default: () => [] }, fileClassify: { type: Number, default: ne.NORMAL.V }, downloadFn: { type: Function, default: void 0 }, downloadPerm: { type: Array, default: void 0 }, accept: { type: String, default: "" }, downloadParams: { type: Object, default: () => ({}) }, showDownload: { type: Boolean, default: false }, showView: { type: Boolean, default: false }, uploadable: { type: Boolean, default: true }, limit: { type: Number, default: void 0 }, emptyText: { type: String, default: "暂未上传文件" }, hasBeforeConfirm: { type: Boolean, default: false }, beforeMessage: { type: String, default: "确认上传吗？" }, successMessage: { type: String, default: "上传成功" }, showFileList: { type: Boolean, default: false }, size: { type: String, default: "default" }, icon: { type: String, default: "el-icon-upload-filled" }, btnName: { type: String, default: "" }, btnType: { type: String, default: "primary" }, disabled: { type: Boolean, default: false }, maxHeight: { type: [String, Number] }, delDisabled: { type: Boolean, default: false }, isSingle: { type: Boolean, default: false } }, emits: ["update:files", "change", "success"], setup(d, { emit: R }) {
  const u = R, e = d, { fileUploadApi: U } = ie("fileUploadApi"), m = o(), z = o({ Authorization: oe() }), h = o(false), g = o([]), l = o(), y = o(false), w = o();
  W(() => {
    l.value = e.files || [];
  });
  function F(a) {
    (a.name.indexOf(".pdf") > -1 || a.name.indexOf(".png") > -1 || a.name.indexOf(".jpg") > -1 || a.name.indexOf(".jpeg") > -1) && (w.value = a.id, y.value = true);
  }
  function $(a, t) {
    const n = t >= 0 && t <= l.value.length - 1 ? l.value[t].id : void 0;
    return { ...e.downloadParams, id: n };
  }
  function j(a) {
    const t = [...l.value];
    t.splice(a, 1), u("update:files", t);
  }
  function A(a) {
    if (_(), h.value = false, a && a.code === 2e4) {
      const t = [a.data];
      e.isSingle ? (l.value = [], l.value.push(a.data), u("update:files", l.value)) : (u("update:files", l.value.concat(a.data)), g.value = g.value.concat(t.map((n) => n.id))), u("success"), b.success("上传成功");
    } else b.error(a && a.message ? a.message : "上传失败");
  }
  function _() {
    m.value && m.value.uploadRef && (m.value.uploadRef.fileList.length = 0);
  }
  function M() {
    _(), h.value = false, b.error("上传失败");
  }
  function P() {
    h.value = true;
  }
  function H(a, t) {
    for (const n in l.value) if (a.uid === l.value[n].uid) {
      const f = [...l.value];
      f.splice(n, 1), u("update:files", f), u("change");
      break;
    }
  }
  function I(a, t) {
    b.warning(`当前限制选择 ${e.limit} 个文件`);
  }
  function q() {
    return e.hasBeforeConfirm ? E.confirm(e.beforeMessage) : true;
  }
  function G(a, t) {
    if (a && a.status === "success") return E.confirm(`确定移除 ${a.name}？`);
  }
  return (a, t) => {
    const n = te, f = D("common-button"), X = D("common-table"), J = L("parse-time"), K = L("permission");
    return c(), O("div", ue, [V("div", fe, [s(X, { data: l.value, "empty-text": d.emptyText, style: { width: "100%" }, "max-height": e.maxHeight }, { default: r(() => [s(n, { label: "序号", type: "index", align: "center", width: "60" }), s(n, { prop: "name", label: "名称", "show-overflow-tooltip": true, "min-width": "150" }), Y(a.$slots, "applicant", {}, void 0, true), s(n, { prop: "createTime", label: "上传时间", "show-overflow-tooltip": true, width: "100", align: "center" }, { default: r(({ row: i }) => [N(V("span", null, null, 512), [[J, { val: i.createTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), s(n, { label: "操作", width: d.uploadable && e.showDownload && e.showView ? 190 : d.uploadable && e.showDownload || e.showDownload && e.showView ? 117 : 67, align: "left" }, { default: r(({ row: i, $index: x }) => {
      var S, C, k, B;
      return [d.uploadable ? (c(), v(f, { key: 0, disabled: e.delDisabled, type: "danger", icon: "el-icon-delete", size: "default", onClick: (Q) => j(x) }, null, 8, ["disabled", "onClick"])) : p("", true), N(s(se, { params: $(i, x), fn: e.downloadFn }, null, 8, ["params", "fn"]), [[Z, e.showDownload], [K, e.downloadPerm]]), e.showView && (((S = i.name) == null ? void 0 : S.indexOf(".pdf")) > -1 || ((C = i.name) == null ? void 0 : C.indexOf(".png")) > -1 || ((k = i.name) == null ? void 0 : k.indexOf(".jpg")) > -1 || ((B = i.name) == null ? void 0 : B.indexOf(".jpeg")) > -1) ? (c(), v(f, { key: 1, icon: "el-icon-view", size: "default", onClick: (Q) => F(i) }, null, 8, ["onClick"])) : p("", true)];
    }), _: 1 }, 8, ["width"])]), _: 3 }, 8, ["data", "empty-text", "max-height"]), y.value ? (c(), v(de, { key: 0, isVisible: y.value, showType: "attachment", id: w.value, onClose: t[0] || (t[0] = (i) => y.value = false) }, null, 8, ["isVisible", "id"])) : p("", true), d.uploadable ? (c(), v(T(ae), { key: 1, ref_key: "uploadRef", ref: m, class: "upload-box", data: { ...e.data, fileType: e.fileClassify }, action: T(U), headers: z.value, "on-success": A, "on-error": M, "on-remove": H, "on-progress": P, "before-upload": q, "before-remove": G, limit: e.limit, "show-file-list": e.showFileList, "on-exceed": I, disabled: e.disabled, accept: e.accept, multiple: "" }, { default: r(() => [s(f, { loading: h.value, size: e.size, icon: e.icon, disabled: e.disabled, type: e.btnType }, { default: r(() => [e.btnName ? (c(), O("span", ce, ee(e.btnName), 1)) : p("", true)]), _: 1 }, 8, ["loading", "size", "icon", "disabled", "type"])]), _: 1 }, 8, ["data", "action", "headers", "limit", "show-file-list", "disabled", "accept"])) : p("", true)])]);
  };
} }, he = le(re, [["__scopeId", "data-v-0acebb83"]]);
export {
  he as default
};
