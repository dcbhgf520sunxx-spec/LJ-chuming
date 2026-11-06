import { S as C, X as N, aj as B, ak as E } from "../../../../../shared/runtime.js";
import { ref as c } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as T } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as g } from "vue";
import { createVNode as k } from "vue";
import { createTextVNode as M } from "vue";
import { toDisplayString as j } from "vue";
import { unref as O } from "vue";
import { ElUpload as V } from "element-plus";
import { ElMessage as l } from "element-plus";
const U = { __name: "ExcelUploadBtnV2", props: { data: { type: Object, default: () => {
} }, fileClassify: { type: Number, default: C.NORMAL.V }, action: { type: String, default: "" }, icon: { type: String, default: "" }, limit: { type: Number, default: 1 }, multiple: { type: Boolean, default: false }, accept: { type: String, default: ".xls,.xlsx" }, uploadFun: { type: Function, default: void 0 }, btnName: { type: String, default: "点击上传" }, btnType: { type: String, default: "primary" }, btnSize: { type: String, default: "default" }, disabled: { type: Boolean, default: false }, sizeLimit: { type: Number, default: void 0 }, successMsg: { type: String, default: "" } }, emits: ["success"], setup(b, { expose: h, emit: v }) {
  const d = v, e = b, r = c(), x = c({ Authorization: N() }), n = c(false), L = c([]);
  function S(t, a) {
    l.warning(`当前限制选择 ${e.limit} 个文件`);
  }
  async function y(t) {
    try {
      n.value = true;
      const a = t.file, s = new FormData();
      s.append("file", a), s.append("fileType", e.fileClassify);
      for (const i in e.data) s.append(i, e.data[i]);
      const o = await e.uploadFun(s), p = o.headers.result && decodeURIComponent(o.headers.result).split(";");
      if (p) {
        const i = p[0].split("=")[1], m = p[1].split("=")[1], u = i === "20000";
        l({ title: `上传${u ? "成功" : "失败"}`, message: u && e.successMsg || `${a.name} ${m}`, type: u ? "success" : "error", duration: 3500 }), u ? d("success", true) : await B(o);
      } else if (o.headers["content-type"] === "application/json") {
        const i = new FileReader();
        i.addEventListener("loadend", function() {
          const m = JSON.parse(i.result);
          d("success", { res: m, formData: s });
        }), i.readAsText(o.data, "utf-8");
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
  function F(t) {
    if (e.accept && !(e.accept.split(",").indexOf(`.${E(t.name).toLowerCase()}`) > -1)) return l.error(`上传文件后缀需为${e.accept}格式`, 2e3), false;
    const a = t.size / 1024 / 1024;
    return !e.sizeLimit || e.sizeLimit && a < e.sizeLimit ? true : (l.error(`上传文件大小大小不能超过 ${e.sizeLimit}MB!`, 2e3), false);
  }
  function z(t) {
    if (e.uploadFun) return false;
    f(), n.value = false, t && t.code === 2e4 ? (d("success", true), l.success("上传成功")) : l.error(t && t.message ? t.message : "上传失败");
  }
  function _() {
    if (e.uploadFun) return false;
    f(), n.value = false, l.error("上传失败");
  }
  function w() {
    n.value = true;
  }
  return h({ handleRequest: y, props: e }), (t, a) => {
    const s = R("common-button");
    return T(), $(O(V), { ref_key: "upload", ref: r, accept: e.accept, action: e.action, "before-upload": F, data: { ...e.data, fileType: e.fileClassify }, disabled: e.disabled, "file-list": L.value, headers: x.value, "http-request": y, limit: e.limit, multiple: e.multiple, "on-error": _, "on-exceed": S, "on-progress": w, "on-success": z, "show-file-list": false }, { default: g(() => [k(s, { disabled: e.disabled, icon: e.icon, loading: n.value, size: e.btnSize, type: e.btnType }, { default: g(() => [M(j(e.btnName), 1)]), _: 1 }, 8, ["disabled", "icon", "loading", "size", "type"])]), _: 1 }, 8, ["accept", "action", "data", "disabled", "file-list", "headers", "limit", "multiple"]);
  };
} };
export {
  U as default
};
