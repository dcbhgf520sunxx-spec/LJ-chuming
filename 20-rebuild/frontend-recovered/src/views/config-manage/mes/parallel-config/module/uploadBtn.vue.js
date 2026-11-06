import { S as z, X as _, ak as x } from "../../../../../shared/runtime.js";
import { ref as o } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as k } from "vue";
import { createBlock as C } from "vue";
import { withCtx as f } from "vue";
import { createVNode as N } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as B } from "vue";
import { unref as M } from "vue";
import { ElUpload as T } from "element-plus";
import { ElMessage as i } from "element-plus";
const R = { __name: "uploadBtn", props: { data: { type: Object, default: () => {
} }, fileClassify: { type: Number, default: z.NORMAL.V }, action: { type: String, default: "" }, icon: { type: String, default: "" }, limit: { type: Number, default: 1 }, multiple: { type: Boolean, default: false }, accept: { type: String, default: ".xls,.xlsx" }, uploadFun: { type: Function, default: void 0 }, btnName: { type: String, default: "点击上传" }, btnType: { type: String, default: "primary" }, btnSize: { type: String, default: "default" }, disabled: { type: Boolean, default: false }, sizeLimit: { type: Number, default: void 0 }, successMsg: { type: String, default: "" }, beforeUploadHook: { type: Function } }, emits: ["success", "update:files"], setup(d, { emit: p }) {
  const u = p, e = d, n = o(), m = o({ Authorization: _() }), s = o(false), y = o([]);
  function g(t, a) {
    i.warning(`当前限制选择 ${e.limit} 个文件`);
  }
  async function b(t) {
    try {
      s.value = true;
      const a = t.file, l = new FormData();
      l.append("file", a), l.append("dataType", 2);
      const c = await e.uploadFun(l);
      i.success("上传成功"), u("change", c, e.data), u("success", true);
    } catch (a) {
      console.log(a);
    } finally {
      s.value = false, r();
    }
  }
  function h(t) {
    if (e.accept && !(e.accept.split(",").indexOf(`.${x(t.name).toLowerCase()}`) > -1)) return i.error(`上传文件后缀需为${e.accept}格式`), false;
    if (typeof e.beforeUploadHook == "function" && !e.beforeUploadHook(t)) return false;
    const a = t.size / 1024 / 1024;
    return !e.sizeLimit || e.sizeLimit && a < e.sizeLimit ? true : (i.error(`上传文件大小大小不能超过 ${e.sizeLimit}MB!`), false);
  }
  function r() {
    n.value && n.value.uploadRef && (n.value.uploadRef.fileList.length = 0);
  }
  function L(t) {
    if (e.uploadFun) return false;
    r(), s.value = false, t && t.code === 2e4 ? (i.success({ title: "上传成功", type: "success", message: e.successMsg || void 0, duration: 2500 }), u("success", true)) : i.error(t && t.message ? t.message : "上传失败");
  }
  function S() {
    if (e.uploadFun) return false;
    r(), s.value = false, i.error("上传失败");
  }
  function v() {
    s.value = true;
  }
  return (t, a) => {
    const l = F("common-button");
    return k(), C(M(T), { ref_key: "upload", ref: n, data: { ...e.data, fileType: e.fileClassify }, action: e.action, headers: m.value, "http-request": b, "before-upload": h, "on-success": L, "on-progress": v, "on-error": S, limit: e.limit, multiple: e.multiple, "on-exceed": g, "file-list": y.value, "show-file-list": false, accept: e.accept, disabled: e.disabled }, { default: f(() => [N(l, { loading: s.value, disabled: e.disabled, icon: e.icon, size: e.btnSize, type: e.btnType }, { default: f(() => [w(B(e.btnName), 1)]), _: 1 }, 8, ["loading", "disabled", "icon", "size", "type"])]), _: 1 }, 8, ["data", "action", "headers", "limit", "multiple", "file-list", "accept", "disabled"]);
  };
} };
export {
  R as default
};
