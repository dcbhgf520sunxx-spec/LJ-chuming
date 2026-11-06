import { t as q } from "../../../../../modules/cloud-cutting-assistant-43dc84e4.js";
import { _ as H, S as J, X as P, ak as X } from "../../../../../shared/runtime.js";
import { ref as i } from "vue";
import { watch as G } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as r } from "vue";
import { createVNode as f } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as v } from "vue";
import { unref as K } from "vue";
import { ElUpload as Q } from "element-plus";
import { createElementVNode as _ } from "vue";
import { createCommentVNode as B } from "vue";
import { Fragment as W } from "vue";
import { renderList as Y } from "vue";
import { ElNotification as ee } from "element-plus";
import { ElMessage as p } from "element-plus";
import te from "jszip";
import { i as ae } from "../../../../../modules/index-ce9deea8.js";
const se = { key: 0, class: "warning-tip", style: { "margin-bottom": "10px" } }, le = { key: 1, class: "red-tip", style: { "margin-bottom": "10px" } }, ie = { class: "zip-box" }, ne = { class: "zip-list" }, oe = { style: { color: "green" } }, ue = { class: "dialog-footer" }, de = { __name: "drawing-upload-btn", props: { data: { type: Object, default: () => {
} }, files: { type: Array, default: () => [] }, uploadFun: { type: Function, default: void 0 }, fileClassify: { type: Number, default: J.NORMAL.V }, icon: { type: String, default: "" }, limit: { type: Number, default: 1 }, accept: { type: String, default: void 0 }, btnType: { type: String, default: "primary" }, btnSize: { type: String, default: "small" }, btnName: { type: String, default: "文件上传" }, sizeLimit: { type: Number, default: void 0 }, disabled: { type: Boolean, default: false }, autoUpload: { type: Boolean, default: false }, successMsg: { type: String, default: "" }, dataType: { type: Number, default: void 0 }, materialType: { type: Number, default: void 0 }, tip: { type: String, default: void 0 } }, emits: ["update:files", "success"], setup(L, { expose: D, emit: R }) {
  const m = R, t = L, Z = i({ Authorization: P() }), g = i(false), I = i([]), N = i([]), h = i(false), y = i(false), S = i(), d = i(), b = i(""), z = i(false), w = i("");
  G(() => t.files, (e) => {
    (!e || e.length === 0) && C();
  }, { deep: true });
  async function k(e) {
    try {
      g.value = true;
      const a = e.file, l = new FormData();
      t.data.cloudcutId ? l.append("multipartFile", a) : l.append("file", a);
      for (const s in t.data) t.data[s] && l.append(s, t.data[s]);
      await t.uploadFun(l), ee({ title: "上传成功", type: "success", message: t.successMsg || `${a.name} 上传成功`, duration: 2500 }), m("success", true);
    } catch (a) {
      console.log(a);
    } finally {
      g.value = false, C();
    }
  }
  function M(e, a, l) {
    if (g.value = false, e && e.code === 2e4) {
      const s = e.data, n = [...t.files || []];
      n.push(Object.assign(s, { uid: a.uid })), m("update:files", n), m("change"), p.success(t.successMessage);
    } else p.error(e && e.message ? e.message : "上传失败");
  }
  function C() {
    d.value && d.value.uploadRef && (d.value.uploadRef.fileList.length = 0);
  }
  function O(e) {
    const a = `.${X(e.name)}`.toLowerCase(), l = e.size / 1024 / 1024, s = !t.sizeLimit || t.sizeLimit && l < t.sizeLimit;
    if (t.accept && !(t.accept.split(",").indexOf(a) > -1)) return p({ message: `上传文件后缀需为${t.accept}格式`, type: "error" }), false;
    if (!s) return p({ message: `上传文件大小不能超过 ${t.sizeLimit}MB!`, type: "error" }), false;
    if (console.log(e), a === ".zip") return S.value = e, m("update:files", [{ name: e.name }]), $(e), j(e), false;
  }
  async function $(e) {
    const a = new te(), l = [];
    (await a.loadAsync(e, { decodeFileName: function(n) {
      return ae.decode(n, "gbk");
    } })).forEach((n, o) => {
      if (o.name.substring(o.name.length - 1) !== "/" && o.name.indexOf(".") > -1) {
        const E = { name: o.name };
        l.push(E);
      }
    }), N.value = l, A();
  }
  async function j(e) {
    const a = e, l = new FormData();
    try {
      t.data.cloudcutId ? (l.append("multipartFile", a), l.append("cloudcutId", t.data.cloudcutId)) : l.append("file", a);
      const s = await q(l);
      b.value = (s == null ? void 0 : s.repeatFileName) || "", z.value = s == null ? void 0 : s.sendResult, w.value = (s == null ? void 0 : s.sendFileName) || "";
    } catch (s) {
      console.log(s);
    }
  }
  async function T() {
    h.value = true;
    try {
      const e = { file: S.value };
      await k(e);
    } catch (e) {
      console.log(e);
    } finally {
      h.value = false, F();
    }
  }
  function U(e, a) {
    p({ message: `当前限制选择 ${this.limit} 个文件，本次选择了 ${e.length} 个文件，共选择了 ${e.length + a.length} 个文件`, type: "warning" });
  }
  function A() {
    y.value = true;
  }
  function F() {
    y.value = false;
  }
  return D({ uploadRef: d }), (e, a) => {
    const l = V("common-button"), s = V("common-dialog");
    return c(), r("div", null, [f(K(Q), { ref_key: "uploadRef", ref: d, action: "", headers: Z.value, "http-request": k, "before-upload": O, limit: t.limit, multiple: false, "on-success": M, "on-exceed": U, "file-list": I.value, "show-file-list": true, "auto-upload": t.autoUpload, accept: t.accept }, { default: u(() => [f(l, { loading: g.value, icon: t.icon, size: t.btnSize, type: t.btnType, disabled: t.disabled }, { default: u(() => [x(v(L.btnName), 1)]), _: 1 }, 8, ["loading", "icon", "size", "type", "disabled"])]), _: 1 }, 8, ["headers", "limit", "file-list", "auto-upload", "accept"]), f(s, { title: "压缩包内容", modelValue: y.value, "onUpdate:modelValue": a[0] || (a[0] = (n) => y.value = n), width: "50%", top: "10vh", "before-close": F }, { footer: u(() => [_("span", ue, [f(l, { onClick: F }, { default: u(() => a[1] || (a[1] = [x("取 消")])), _: 1, __: [1] }), f(l, { loading: h.value, type: "primary", disabled: z.value, onClick: T }, { default: u(() => a[2] || (a[2] = [x(" 上传 ")])), _: 1, __: [2] }, 8, ["loading", "disabled"])])]), default: u(() => [b.value ? (c(), r("div", se, v(b.value) + ", 确认上传将会覆盖原有文件！", 1)) : B("", true), w.value ? (c(), r("div", le, v(w.value) + ", 请重新打包进行上传！", 1)) : B("", true), _("div", ie, [_("ul", ne, [(c(true), r(W, null, Y(N.value, (n, o) => (c(), r("li", { key: o }, [_("span", oe, v(n.name), 1)]))), 128))])])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, me = H(de, [["__scopeId", "data-v-974a3f11"]]);
export {
  me as default
};
