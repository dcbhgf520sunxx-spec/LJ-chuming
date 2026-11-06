import { S as N, g as k, X as M } from "../../../../../shared/runtime.js";
import { computed as A } from "vue";
import { ref as d } from "vue";
import { watch as R } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as p } from "vue";
import { createBlock as U } from "vue";
import { withCtx as f } from "vue";
import { createElementBlock as F } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as T } from "vue";
import { createVNode as V } from "vue";
import { createTextVNode as j } from "vue";
import { unref as O } from "vue";
import { ElUpload as D } from "element-plus";
import { ElMessage as u } from "element-plus";
import { ElMessageBox as g } from "element-plus";
const $ = { key: 0, class: "el-upload__tip" }, X = { __name: "UploadBtn", props: { data: { type: Object, default: () => {
} }, files: { type: Array, default: () => [] }, fileClassify: { type: Number, default: N.NORMAL.V }, limit: { type: Number, default: void 0 }, hasBeforeConfirm: { type: Boolean, default: false }, beforeMessage: { type: String, default: "确认上传吗？" }, successMessage: { type: String, default: "上传成功" }, showFileList: { type: Boolean, default: true }, size: { type: String, default: "default" }, accept: { type: String, default: "" }, icon: { type: String, default: "" }, btnName: { type: String, default: "点击上传" }, btnType: { type: String, default: "primary" }, tip: { type: String, default: "" }, disabled: { type: Boolean, default: false }, uploadApi: { type: String, default: void 0 } }, emits: ["update:files", "change"], setup(y, { expose: b, emit: h }) {
  const s = h, e = y, _ = A(() => k() + e.uploadApi), n = d(), v = d({ Authorization: M() }), a = d(false);
  R(() => e.files, (t) => {
    (!t || t.length === 0) && r();
  }, { deep: true });
  function S(t, i, l) {
    if (a.value = false, console.log(t), t && t.code === 2e4) {
      const o = t.data, c = [...e.files || []];
      c.push(Object.assign(o, { uid: i.uid })), s("update:files", c), s("change"), s("uploadSuccess", o), u.success(e.successMessage);
    } else u.error(t && t.message ? t.message : "上传失败");
  }
  function B(t) {
    a.value = false, u.error("上传失败");
  }
  function w(t, i) {
    for (const l in e.files) if (t.uid === e.files[l].uid) {
      const o = [...e.files];
      o.splice(l, 1), s("update:files", o), s("change");
      break;
    }
  }
  function x(t, i) {
    u.warning(`当前限制选择 ${e.limit} 个文件`);
  }
  function L() {
    return e.hasBeforeConfirm ? g.confirm(e.beforeMessage) : true;
  }
  function C(t, i) {
    if (t && t.status === "success") return g.confirm(`确定移除 ${t.name}？`);
  }
  function r() {
    n.value && n.value.uploadRef && (n.value.uploadRef.fileList.length = 0);
  }
  function E() {
    a.value = true;
  }
  return b({ clearFiles: r }), (t, i) => {
    const l = z("common-button");
    return p(), U(O(D), { ref_key: "upload", ref: n, class: "upload-box", data: { ...e.data }, action: _.value, headers: v.value, "on-success": S, "on-error": B, "on-progress": E, "on-remove": w, "before-upload": L, "before-remove": C, limit: e.limit, "show-file-list": e.showFileList, "on-exceed": x, disabled: e.disabled || a.value, accept: e.accept, multiple: "" }, { tip: f(() => [e.tip ? (p(), F("div", $, m(e.tip), 1)) : T("", true)]), default: f(() => [V(l, { loading: a.value, size: e.size, icon: e.icon, disabled: e.disabled || a.value, type: e.btnType }, { default: f(() => [j(m(e.btnName), 1)]), _: 1 }, 8, ["loading", "size", "icon", "disabled", "type"])]), _: 1 }, 8, ["data", "action", "headers", "limit", "show-file-list", "disabled", "accept"]);
  };
} };
export {
  X as default
};
