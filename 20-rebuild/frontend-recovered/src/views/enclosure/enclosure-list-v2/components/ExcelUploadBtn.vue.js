import { S as w, X as C, aj as N, ak as B } from "../../../../shared/runtime.js";
import { ref as c } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as R } from "vue";
import { createBlock as T } from "vue";
import { withCtx as y } from "vue";
import { createVNode as $ } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as M } from "vue";
import { unref as j } from "vue";
import { ElUpload as O } from "element-plus";
import { ElMessage as l } from "element-plus";
const U = { __name: "ExcelUploadBtn", props: { data: { type: Object, default: () => {
} }, fileClassify: { type: Number, default: w.NORMAL.V }, action: { type: String, default: "" }, icon: { type: String, default: "" }, limit: { type: Number, default: 1 }, multiple: { type: Boolean, default: false }, accept: { type: String, default: ".xls,.xlsx" }, uploadFun: { type: Function, default: void 0 }, btnName: { type: String, default: "点击上传" }, btnType: { type: String, default: "primary" }, btnSize: { type: String, default: "default" }, disabled: { type: Boolean, default: false }, sizeLimit: { type: Number, default: void 0 }, successMsg: { type: String, default: "" } }, emits: ["success"], setup(g, { emit: b }) {
  const d = b, e = g, r = c(), h = c({ Authorization: C() }), n = c(false), v = c([]);
  function L(t, a) {
    l.warning(`当前限制选择 ${e.limit} 个文件`);
  }
  async function S(t) {
    try {
      n.value = true;
      const a = t.file, i = new FormData();
      i.append("file", a), i.append("fileType", e.fileClassify);
      for (const s in e.data) i.append(s, e.data[s]);
      const o = await e.uploadFun(i), p = o.headers.result && decodeURIComponent(o.headers.result).split(";");
      if (p) {
        const s = p[0].split("=")[1], m = p[1].split("=")[1], u = s === "20000";
        l({ title: `上传${u ? "成功" : "失败"}`, message: u && e.successMsg || `${a.name} ${m}`, type: u ? "success" : "error", duration: 3500 }), u ? d("success", true) : await N(o);
      } else if (o.headers["content-type"] === "application/json") {
        const s = new FileReader();
        s.addEventListener("loadend", function() {
          const m = JSON.parse(s.result);
          d("success", m);
        }), s.readAsText(o.data, "utf-8");
      } else l.error("上传失败");
    } catch (a) {
      console.log(a);
    } finally {
      n.value = false, f();
    }
  }
  function f() {
    var t;
    (t = r.value) == null || t.clearFiles(), r.value && r.value.uploadRef && (r.value.uploadRef.fileList.length = 0);
  }
  function x(t) {
    if (e.accept && !(e.accept.split(",").indexOf(`.${B(t.name).toLowerCase()}`) > -1)) return l.error(`上传文件后缀需为${e.accept}格式`, 2e3), false;
    const a = t.size / 1024 / 1024;
    return !e.sizeLimit || e.sizeLimit && a < e.sizeLimit ? true : (l.error(`上传文件大小大小不能超过 ${e.sizeLimit}MB!`, 2e3), false);
  }
  function F(t) {
    if (e.uploadFun) return false;
    f(), n.value = false, t && t.code === 2e4 ? (d("success", true), l.success("上传成功")) : l.error(t && t.message ? t.message : "上传失败");
  }
  function z() {
    if (e.uploadFun) return false;
    f(), n.value = false, l.error("上传失败");
  }
  function _() {
    n.value = true;
  }
  return (t, a) => {
    const i = E("common-button");
    return R(), T(j(O), { ref_key: "upload", ref: r, accept: e.accept, action: e.action, "before-upload": x, data: { ...e.data, fileType: e.fileClassify }, disabled: e.disabled, "file-list": v.value, headers: h.value, "http-request": S, limit: e.limit, multiple: e.multiple, "on-error": z, "on-exceed": L, "on-progress": _, "on-success": F, "show-file-list": false }, { default: y(() => [$(i, { disabled: e.disabled, icon: e.icon, loading: n.value, size: e.btnSize, type: e.btnType, class: "upload-btn" }, { default: y(() => [k(M(e.btnName), 1)]), _: 1 }, 8, ["disabled", "icon", "loading", "size", "type"])]), _: 1 }, 8, ["accept", "action", "data", "disabled", "file-list", "headers", "limit", "multiple"]);
  };
} };
export {
  U as default
};
