import { _ as v, X as x, ak as z } from "../../../../../../shared/runtime.js";
import { ref as l } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as L } from "vue";
import { createElementBlock as F } from "vue";
import { createVNode as u } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as N } from "vue";
import { unref as $ } from "vue";
import { ElUpload as k } from "element-plus";
import { ElNotification as B } from "element-plus";
import { ElMessage as c } from "element-plus";
const C = { __name: "index", props: { data: { type: Object, default: () => {
} }, uploadFun: { type: Function, default: void 0 }, icon: { type: String, default: "" }, limit: { type: Number, default: 1 }, accept: { type: String, default: void 0 }, btnType: { type: String, default: "primary" }, btnSize: { type: String, default: "default" }, btnName: { type: String, default: "文件上传" }, sizeLimit: { type: Number, default: void 0 }, disabled: { type: Boolean, default: false }, successMsg: { type: String, default: "" }, tip: { type: String, default: void 0 } }, emits: ["success"], setup(d, { emit: p }) {
  const r = p, e = d, m = l({ Authorization: x() }), o = l(false), y = l([]), s = l();
  async function g(a) {
    try {
      o.value = true;
      const t = a.file, i = new FormData();
      e.data.id ? i.append("multipartFile", t) : i.append("file", t);
      for (const n in e.data) e.data[n] && i.append(n, e.data[n]);
      await e.uploadFun(i), B({ title: "上传成功", type: "success", message: e.successMsg || `${t.name} 上传成功`, duration: 2500 }), r("success", true);
    } catch (t) {
      console.log(t);
    } finally {
      o.value = false, _();
    }
  }
  function _() {
    s.value && s.value.uploadRef && (s.value.uploadRef.fileList.length = 0);
  }
  function b(a) {
    const t = `.${z(a.name)}`.toLowerCase(), i = a.size / 1024 / 1024, n = !e.sizeLimit || e.sizeLimit && i < e.sizeLimit;
    if (e.accept && !(e.accept.split(",").indexOf(t) > -1)) return c({ message: `上传文件后缀需为${e.accept}格式`, type: "error" }), false;
    if (!n) return c({ message: `上传文件大小不能超过 ${e.sizeLimit}MB!`, type: "error" }), false;
  }
  function h(a, t) {
    c({ message: `当前限制选择 ${this.limit} 个文件，本次选择了 ${a.length} 个文件，共选择了 ${a.length + t.length} 个文件`, type: "warning" });
  }
  return (a, t) => {
    const i = S("common-button");
    return L(), F("div", null, [u($(k), { ref_key: "uploadRef", ref: s, action: "", headers: m.value, "http-request": g, "before-upload": b, limit: e.limit, multiple: false, "on-exceed": h, "file-list": y.value, "show-file-list": false, accept: e.accept }, { default: f(() => [u(i, { loading: o.value, icon: e.icon, size: e.btnSize, type: e.btnType, disabled: e.disabled }, { default: f(() => [w(N(d.btnName), 1)]), _: 1 }, 8, ["loading", "icon", "size", "type", "disabled"])]), _: 1 }, 8, ["headers", "limit", "file-list", "accept"])]);
  };
} }, T = v(C, [["__scopeId", "data-v-275720f7"]]);
export {
  T as default
};
