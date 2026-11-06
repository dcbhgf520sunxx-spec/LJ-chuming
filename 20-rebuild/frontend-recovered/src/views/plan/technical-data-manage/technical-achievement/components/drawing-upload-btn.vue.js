import { _ as I, nw as K, S as W, X as H, qX as Q, ak as B } from "../../../../../shared/runtime.js";
import { ref as d } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as g } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as N } from "vue";
import { toDisplayString as y } from "vue";
import { unref as Y } from "vue";
import { ElUpload as ee } from "element-plus";
import { createElementVNode as _ } from "vue";
import { createCommentVNode as V } from "vue";
import { Fragment as Z } from "vue";
import { renderList as M } from "vue";
import { ElNotification as A } from "element-plus";
import { ElMessage as k } from "element-plus";
import te from "jszip";
import { i as ae } from "../../../../../modules/index-ce9deea8.js";
const ne = { style: { display: "inline-block" } }, se = { key: 0, class: "red-tip", style: { display: "inline-block", "margin-bottom": "10px" } }, le = { class: "zip-box" }, ie = { key: 0, class: "zip-list" }, oe = { style: { color: "red" } }, de = { class: "zip-list" }, ue = { style: { color: "green" } }, ce = { class: "dialog-footer" }, re = { __name: "drawing-upload-btn", props: { data: { type: Object, default: () => {
} }, uploadFun: { type: Function, default: K }, uploadFunFile: { type: Function }, fileClassify: { type: Number, default: W.NORMAL.V }, icon: { type: String, default: "" }, limit: { type: Number, default: 1 }, accept: { type: String, default: void 0 }, btnType: { type: String, default: "success" }, btnSize: { type: String, default: "default" }, btnName: { type: String, default: "文件导入" }, sizeLimit: { type: Number, default: void 0 }, disabled: { type: Boolean, default: false }, successMsg: { type: String, default: "" }, dataType: { type: Number, default: void 0 }, materialType: { type: Number, default: void 0 }, tip: { type: String, default: void 0 } }, emits: ["success"], setup(b, { emit: E }) {
  const C = E, e = b, T = d({ Authorization: H() }), w = d(false), U = d([]), z = d([]), r = d([]), F = d(false), h = d(false), S = d(), f = d();
  async function D(a) {
    w.value = true;
    const t = a.file, n = new FormData();
    n.append("file", t), n.append("fileName", (t == null ? void 0 : t.name) || "");
    for (const s in e.data) e.data[s] && n.append(s, e.data[s]);
    try {
      const s = await e.uploadFun(n);
      A({ title: "上传成功", type: "success", message: e.successMsg || `${t.name} 上传成功`, duration: 2500 }), C("success", s);
    } catch (s) {
      if (console.log(s), e.uploadFunFile instanceof Function) {
        const l = await e.uploadFunFile(n);
        if (A({ title: "上传失败", type: "error", message: `${t.name} 上传失败`, duration: 2500 }), Q(l)) {
          const v = window.URL.createObjectURL(new Blob([l.data])), i = document.createElement("a");
          i.href = v, i.setAttribute("download", `${t.name} 错误信息表.xlsx`), document.body.appendChild(i), i.click(), i.remove();
        }
      }
      C("success", false);
    } finally {
      w.value = false, j();
    }
  }
  function j() {
    var a;
    f.value && f.value.uploadRef && (f.value.uploadRef.fileList.length = 0), (a = f.value) == null || a.clearFiles();
  }
  function O(a) {
    const t = `.${B(a.name)}`.toLowerCase(), n = a.size / 1024 / 1024, s = !e.sizeLimit || e.sizeLimit && n < e.sizeLimit;
    if (e.accept && !(e.accept.split(",").indexOf(t) > -1)) return k({ message: `上传文件后缀需为${e.accept}格式`, type: "error" }), false;
    if (!s) return k({ message: `上传文件大小不能超过 ${e.sizeLimit}MB!`, type: "error" }), false;
    if (t === ".zip") return S.value = a, P(a), false;
  }
  async function P(a) {
    const t = new te(), n = [], s = [], l = e.tip && e.tip.length > 0 ? e.tip.split(",") : [];
    (await t.loadAsync(a, { decodeFileName: function(v) {
      return ae.decode(v, "gbk");
    } })).forEach((v, i) => {
      const o = `.${B(i.name)}`.toLowerCase();
      if (i.name.substring(i.name.length - 1) !== "/" && i.name.indexOf(".") > -1) {
        const x = { name: i.name, ".PDF": o === ".pdf", ".MARK": o === ".mark", ".JPG": o === ".jpg", ".PNG": o === ".png", ".JPEG": o === ".jpeg", ".DWG": o === ".dwg", ".DXF": o === ".dxf", ".NC1": o === ".nc1", ".XML": o === ".xml" };
        if (e.tip && e.tip.length > 0) {
          const $ = [];
          l.forEach((J) => {
            $.push(x[J.toUpperCase()]);
          }), $.indexOf(true) < 0 ? s.push(x) : n.push(x);
        }
      }
    }), z.value = n, r.value = s, q();
  }
  async function G() {
    F.value = true;
    try {
      const a = { file: S.value };
      await D(a);
    } catch (a) {
      console.log(a);
    } finally {
      F.value = false, L();
    }
  }
  function X(a, t) {
    k({ message: `当前限制选择 ${this.limit} 个文件，本次选择了 ${a.length} 个文件，共选择了 ${a.length + t.length} 个文件`, type: "warning" });
  }
  function q() {
    h.value = true;
  }
  function L() {
    h.value = false;
  }
  return (a, t) => {
    const n = R("common-button"), s = R("common-dialog");
    return u(), c("div", ne, [g(Y(ee), { ref_key: "uploadRef", ref: f, accept: e.accept, "before-upload": O, "file-list": U.value, headers: T.value, "http-request": D, limit: e.limit, multiple: false, "on-exceed": X, "show-file-list": false, action: "" }, { default: p(() => [g(n, { disabled: e.disabled, icon: e.icon, loading: w.value, size: e.btnSize, type: e.btnType }, { default: p(() => [N(y(b.btnName), 1)]), _: 1 }, 8, ["disabled", "icon", "loading", "size", "type"])]), _: 1 }, 8, ["accept", "file-list", "headers", "limit"]), g(s, { modelValue: h.value, "onUpdate:modelValue": t[0] || (t[0] = (l) => h.value = l), "before-close": L, title: "压缩包内容", top: "10vh", width: "50%" }, { footer: p(() => [_("span", ce, [g(n, { onClick: L }, { default: p(() => t[1] || (t[1] = [N("取 消")])), _: 1, __: [1] }), g(n, { disabled: !!r.value.length, loading: F.value, type: "primary", onClick: G }, { default: p(() => t[2] || (t[2] = [N("上传")])), _: 1, __: [2] }, 8, ["disabled", "loading"])])]), default: p(() => [r.value.length ? (u(), c("span", se, " 含 " + y(r.value.length) + " 个文件后缀不为“ " + y(b.tip) + " ”的文件,请重新打包上传 ", 1)) : V("", true), _("div", le, [r.value.length ? (u(), c("ul", ie, [(u(true), c(Z, null, M(r.value, (l, m) => (u(), c("li", { key: m }, [_("span", oe, y(l.name), 1)]))), 128))])) : V("", true), _("ul", de, [(u(true), c(Z, null, M(z.value, (l, m) => (u(), c("li", { key: m }, [_("span", ue, y(l.name), 1)]))), 128))])])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, ge = I(re, [["__scopeId", "data-v-3972c7c4"]]);
export {
  ge as default
};
