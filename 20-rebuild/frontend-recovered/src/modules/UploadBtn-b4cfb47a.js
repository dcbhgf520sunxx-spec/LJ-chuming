import { S as N, m as k, X as E } from "../shared/runtime.js";
import { ref as r } from "vue";
import { watch as A } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as p } from "vue";
import { createBlock as R } from "vue";
import { withCtx as u } from "vue";
import { createElementBlock as T } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as U } from "vue";
import { createVNode as V } from "vue";
import { createTextVNode as j } from "vue";
import { unref as g } from "vue";
import { ElUpload as O } from "element-plus";
import { ElMessage as o } from "element-plus";
import { ElMessageBox as y } from "element-plus";
const $ = { key: 0, class: "el-upload__tip" }, P = { __name: "UploadBtn", props: { data: { type: Object, default: () => {
} }, files: { type: Array, default: () => [] }, fileClassify: { type: Number, default: N.NORMAL.V }, limit: { type: Number, default: void 0 }, hasBeforeConfirm: { type: Boolean, default: false }, beforeMessage: { type: String, default: "确认上传吗？" }, successMessage: { type: String, default: "上传成功" }, showFileList: { type: Boolean, default: true }, size: { type: String, default: "default" }, accept: { type: String, default: "" }, icon: { type: String, default: "" }, btnName: { type: String, default: "点击上传" }, btnType: { type: String, default: "primary" }, tip: { type: String, default: "" }, disabled: { type: Boolean, default: false }, sizeLimit: { type: Number, default: void 0 } }, emits: ["update:files", "change"], setup(b, { expose: h, emit: _ }) {
  const n = _, e = b, { fileUploadApi: v } = k("fileUploadApi"), l = r(), L = r({ Authorization: E() }), a = r(false);
  A(() => e.files, (t) => {
    (!t || t.length === 0) && d();
  }, { deep: true });
  function z(t, i, s) {
    if (a.value = false, t && t.code === 2e4) {
      const f = t.data, c = [...e.files || []];
      c.push(Object.assign(f, { uid: i.uid })), n("update:files", c), n("change"), o.success(e.successMessage);
    } else o.error(t && t.message ? t.message : "上传失败");
  }
  function B() {
    a.value = false, o.error("上传失败");
  }
  function S(t, i) {
    for (const s in e.files) if (t.uid === e.files[s].uid) {
      const f = [...e.files];
      f.splice(s, 1), n("update:files", f), n("change");
      break;
    }
  }
  function w(t, i) {
    o.warning(`当前限制选择 ${e.limit} 个文件`);
  }
  function x(t) {
    const i = t.size / 1024 / 1024;
    return !e.sizeLimit || e.sizeLimit && i < e.sizeLimit ? e.hasBeforeConfirm ? y.confirm(e.beforeMessage) : true : (o.error(`上传文件大小不能超过 ${e.sizeLimit}MB!`), false);
  }
  function C(t, i) {
    if (t && t.status === "success") return y.confirm(`确定移除 ${t.name}？`);
  }
  function d() {
    var t;
    (t = l.value) == null || t.clearFiles(), l.value && l.value.uploadRef && (l.value.uploadRef.fileList.length = 0);
  }
  function M() {
    a.value = true;
  }
  return h({ clearFiles: d }), (t, i) => {
    const s = F("common-button");
    return p(), R(g(O), { ref_key: "upload", ref: l, class: "upload-box", data: { ...e.data, fileType: e.fileClassify }, action: g(v), headers: L.value, "on-success": z, "on-error": B, "on-progress": M, "on-remove": S, "before-upload": x, "before-remove": C, limit: e.limit, "show-file-list": e.showFileList, "on-exceed": w, disabled: e.disabled || a.value, accept: e.accept, multiple: "" }, { tip: u(() => [e.tip ? (p(), T("div", $, m(e.tip), 1)) : U("", true)]), default: u(() => [V(s, { loading: a.value, size: e.size, icon: e.icon, disabled: e.disabled || a.value, type: e.btnType }, { default: u(() => [j(m(e.btnName), 1)]), _: 1 }, 8, ["loading", "size", "icon", "disabled", "type"])]), _: 1 }, 8, ["data", "action", "headers", "limit", "show-file-list", "disabled", "accept"]);
  };
} };
export {
  P as _
};
