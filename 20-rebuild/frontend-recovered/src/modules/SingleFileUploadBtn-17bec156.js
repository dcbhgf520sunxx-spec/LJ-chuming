import { S as L, X as _, ak as z } from "../shared/runtime.js";
import { ref as o } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as k } from "vue";
import { createBlock as C } from "vue";
import { withCtx as c } from "vue";
import { createVNode as N } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as B } from "vue";
import { unref as M } from "vue";
import { ElUpload as T } from "element-plus";
import { ElMessage as s } from "element-plus";
const O = { __name: "SingleFileUploadBtn", props: { data: { type: Object, default: () => {
} }, fileClassify: { type: Number, default: L.NORMAL.V }, action: { type: String, default: "" }, icon: { type: String, default: "" }, limit: { type: Number, default: 1 }, multiple: { type: Boolean, default: false }, accept: { type: String, default: ".xls,.xlsx" }, uploadFun: { type: Function, default: void 0 }, btnName: { type: String, default: "点击上传" }, btnType: { type: String, default: "primary" }, btnSize: { type: String, default: "default" }, disabled: { type: Boolean, default: false }, sizeLimit: { type: Number, default: void 0 }, successMsg: { type: String, default: "" }, beforeUploadHook: { type: Function } }, emits: ["success"], setup(d, { emit: p }) {
  const f = p, e = d, n = o(), m = o({ Authorization: _() }), l = o(false), y = o([]);
  function g(t, a) {
    s.warning(`当前限制选择 ${e.limit} 个文件`);
  }
  async function b(t) {
    try {
      l.value = true;
      const a = t.file, i = new FormData();
      i.append("file", a), i.append("fileType", e.fileClassify);
      for (const r in e.data) i.append(r, e.data[r]);
      await e.uploadFun(i), f("success", true);
    } catch (a) {
      console.log(a);
    } finally {
      l.value = false, u();
    }
  }
  function h(t) {
    if (e.accept && !(e.accept.split(",").indexOf(`.${z(t.name).toLowerCase()}`) > -1)) return s.error(`上传文件后缀需为${e.accept}格式`), false;
    if (typeof e.beforeUploadHook == "function" && !e.beforeUploadHook(t)) return false;
    const a = t.size / 1024 / 1024;
    return !e.sizeLimit || e.sizeLimit && a < e.sizeLimit ? true : (s.error(`上传文件大小大小不能超过 ${e.sizeLimit}MB!`), false);
  }
  function u() {
    var t;
    (t = n.value) == null || t.clearFiles(), n.value && n.value.uploadRef && (n.value.uploadRef.fileList.length = 0);
  }
  function S(t) {
    if (e.uploadFun) return false;
    u(), l.value = false, t && t.code === 2e4 ? (s.success({ title: "上传成功", type: "success", message: e.successMsg || void 0, duration: 2500 }), f("success", true)) : s.error(t && t.message ? t.message : "上传失败");
  }
  function v() {
    if (e.uploadFun) return false;
    u(), l.value = false, s.error("上传失败");
  }
  function F() {
    l.value = true;
  }
  return (t, a) => {
    const i = x("common-button");
    return k(), C(M(T), { ref_key: "upload", ref: n, data: { ...e.data, fileType: e.fileClassify }, action: e.action, headers: m.value, "http-request": b, "before-upload": h, "on-success": S, "on-progress": F, "on-error": v, limit: e.limit, multiple: e.multiple, "on-exceed": g, "file-list": y.value, "show-file-list": false, accept: e.accept, disabled: e.disabled }, { default: c(() => [N(i, { loading: l.value, disabled: e.disabled, icon: e.icon, size: e.btnSize, type: e.btnType }, { default: c(() => [w(B(e.btnName), 1)]), _: 1 }, 8, ["loading", "disabled", "icon", "size", "type"])]), _: 1 }, 8, ["data", "action", "headers", "limit", "multiple", "file-list", "accept", "disabled"]);
  };
} };
export {
  O as _
};
