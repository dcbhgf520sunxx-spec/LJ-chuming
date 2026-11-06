import { ref as s } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as g } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as L } from "vue";
import { toDisplayString as y } from "vue";
import { unref as T } from "vue";
import { ElUpload as W } from "element-plus";
import { createElementVNode as v } from "vue";
import { createBlock as Z } from "vue";
import { createCommentVNode as B } from "vue";
import { Fragment as $ } from "vue";
import { renderList as P } from "vue";
import { ElNotification as H } from "element-plus";
import { ElMessage as w } from "element-plus";
import K from "jszip";
import { ElPopconfirm as Q } from "element-plus";
import { _ as Y, S as ee, X as te, ms as ae, ak as j } from "../../../../../shared/runtime.js";
import { i as ie } from "../../../../../modules/index-ce9deea8.js";
const le = { key: 0, class: "red-tip", style: { display: "inline-block", "margin-bottom": "10px" } }, ne = { class: "zip-box" }, se = { key: 0, class: "zip-list" }, oe = { style: { color: "red" } }, de = { class: "zip-list" }, ue = { style: { color: "green" } }, ce = { class: "dialog-footer" }, re = { __name: "index", props: { data: { type: Object, default: () => {
} }, uploadFun: { type: Function, default: void 0 }, fileClassify: { type: Number, default: ee.NORMAL.V }, icon: { type: String, default: "" }, limit: { type: Number, default: 1 }, accept: { type: String, default: void 0 }, btnType: { type: String, default: "primary" }, btnSize: { type: String, default: "default" }, btnName: { type: String, default: "文件上传" }, sizeLimit: { type: Number, default: void 0 }, disabled: { type: Boolean, default: false }, successMsg: { type: String, default: "" }, dataType: { type: Number, default: void 0 }, materialType: { type: Number, default: void 0 }, tip: { type: String, default: void 0 } }, emits: ["success"], setup(f, { emit: M }) {
  const O = M, e = f, R = s({ Authorization: te() }), k = s(false), A = s([]), C = s([]), l = s([]), _ = s(false), h = s(false), F = s(), b = s();
  async function S(a) {
    try {
      k.value = true;
      const t = a.file, i = new FormData();
      e.data.id ? i.append("multipartFile", t) : i.append("file", t);
      for (const n in e.data) e.data[n] && i.append(n, e.data[n]);
      await e.uploadFun(i), H({ title: "上传成功", type: "success", message: e.successMsg || `${t.name} 上传成功`, duration: 2500 }), O("success", true);
    } catch (t) {
      console.log(t);
    } finally {
      k.value = false, G();
    }
  }
  function G() {
    b.value && b.value.uploadRef && (b.value.uploadRef.fileList.length = 0);
  }
  function U(a) {
    const t = `.${j(a.name)}`.toLowerCase(), i = a.size / 1024 / 1024, n = !e.sizeLimit || e.sizeLimit && i < e.sizeLimit;
    if (e.accept && !(e.accept.split(",").indexOf(t) > -1)) return w({ message: `上传文件后缀需为${e.accept}格式`, type: "error" }), false;
    if (!n) return w({ message: `上传文件大小不能超过 ${e.sizeLimit}MB!`, type: "error" }), false;
    if (console.log(a), t === ".zip") return F.value = a, J(a), false;
  }
  async function J(a) {
    const t = new K(), i = [], n = [], x = e.tip && e.tip.length > 0 ? e.tip.split(",") : [];
    (await t.loadAsync(a, { decodeFileName: function(r) {
      return ie.decode(r, "gbk");
    } })).forEach((r, m) => {
      const p = `.${j(m.name)}`.toLowerCase();
      if (m.name.substring(m.name.length - 1) !== "/" && m.name.indexOf(".") > -1) {
        const z = { name: m.name, ".PDF": p === ".pdf", ".JPG": p === ".jpg", ".PNG": p === ".png", ".JPEG": p === ".jpeg", ".DWG": p === ".dwg", ".DXF": p === ".dxf" };
        if (e.tip && e.tip.length > 0) {
          const E = [];
          x.forEach((I) => {
            E.push(z[I.toUpperCase()]);
          }), E.indexOf(true) < 0 ? n.push(z) : i.push(z);
        }
      }
    }), C.value = i, l.value = n, X();
  }
  async function D() {
    _.value = true;
    try {
      const a = { file: F.value };
      await S(a);
    } catch (a) {
      console.log(a);
    } finally {
      _.value = false, N();
    }
  }
  function q(a, t) {
    w({ message: `当前限制选择 ${this.limit} 个文件，本次选择了 ${a.length} 个文件，共选择了 ${a.length + t.length} 个文件`, type: "warning" });
  }
  function X() {
    h.value = true;
  }
  function N() {
    h.value = false;
  }
  return (a, t) => {
    const i = V("common-button"), n = Q, x = V("common-dialog");
    return o(), u("div", null, [g(T(W), { ref_key: "uploadRef", ref: b, action: "", headers: R.value, "http-request": S, "before-upload": U, limit: e.limit, multiple: false, "on-exceed": q, "file-list": A.value, "show-file-list": false, accept: e.accept }, { default: d(() => [g(i, { loading: k.value, icon: e.icon, size: e.btnSize, type: e.btnType, disabled: e.disabled }, { default: d(() => [L(y(f.btnName), 1)]), _: 1 }, 8, ["loading", "icon", "size", "type", "disabled"])]), _: 1 }, 8, ["headers", "limit", "file-list", "accept"]), g(x, { title: "压缩包内容", modelValue: h.value, "onUpdate:modelValue": t[0] || (t[0] = (c) => h.value = c), width: "50%", top: "10vh", "before-close": N }, { footer: d(() => [v("span", ce, [g(i, { onClick: N }, { default: d(() => t[1] || (t[1] = [L("取 消")])), _: 1, __: [1] }), f.dataType === T(ae).DEEPEN.V ? (o(), Z(i, { key: 0, loading: _.value, type: "primary", disabled: l.value && l.value.length > 0, onClick: D }, { default: d(() => t[2] || (t[2] = [L("上传")])), _: 1, __: [2] }, 8, ["loading", "disabled"])) : (o(), Z(n, { key: 1, title: f.dataType ? "保存后无法删除,确定上传?" : "确定上传?", onConfirm: D }, { reference: d(() => [g(i, { loading: _.value, type: "primary", disabled: l.value && l.value.length > 0 }, { default: d(() => t[3] || (t[3] = [L("上传")])), _: 1, __: [3] }, 8, ["loading", "disabled"])]), _: 1 }, 8, ["title"]))])]), default: d(() => [l.value && l.value.length > 0 ? (o(), u("span", le, "含 " + y(l.value.length) + " 个文件后缀不为“ " + y(f.tip) + " ”的文件,请重新打包上传", 1)) : B("", true), v("div", ne, [l.value && l.value.length > 0 ? (o(), u("ul", se, [(o(true), u($, null, P(l.value, (c, r) => (o(), u("li", { key: r }, [v("span", oe, y(c.name), 1)]))), 128))])) : B("", true), v("ul", de, [(o(true), u($, null, P(C.value, (c, r) => (o(), u("li", { key: r }, [v("span", ue, y(c.name), 1)]))), 128))])])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, ge = Y(re, [["__scopeId", "data-v-9d7d08cc"]]);
export {
  ge as default
};
