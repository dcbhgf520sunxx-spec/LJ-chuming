import { _ as te, nw as R, S as ae, X as le, aa as ne, to as ie, tp as oe, qX as se, ak as V } from "../../../../../../shared/runtime.js";
import { ref as s } from "vue";
import { computed as E } from "vue";
import { resolveComponent as Z } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as v } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as N } from "vue";
import { toDisplayString as h } from "vue";
import { unref as ue } from "vue";
import { ElUpload as de } from "element-plus";
import { createElementVNode as w } from "vue";
import { createCommentVNode as P } from "vue";
import { Fragment as U } from "vue";
import { renderList as O } from "vue";
import { ElMessageBox as ce } from "element-plus";
import { h as re } from "vue";
import { ElNotification as j } from "element-plus";
import { ElMessage as S } from "element-plus";
import pe from "jszip";
import { i as fe } from "../../../../../../modules/index-ce9deea8.js";
const me = { style: { display: "inline-block" } }, ge = { key: 0, class: "red-tip", style: { display: "inline-block", "margin-bottom": "10px" } }, ye = { class: "zip-box" }, ve = { key: 0, class: "zip-list" }, he = { style: { color: "red" } }, _e = { class: "zip-list" }, be = { style: { color: "green" } }, we = { class: "dialog-footer" }, Fe = { __name: "drawing-upload-btn", props: { data: { type: Object, default: () => {
} }, uploadFun: { type: Function, default: R }, uploadFunFile: { type: Function }, fileClassify: { type: Number, default: ae.NORMAL.V }, icon: { type: String, default: "" }, limit: { type: Number, default: 1 }, btnType: { type: String, default: "success" }, btnSize: { type: String, default: "default" }, btnName: { type: String, default: "文件导入" }, sizeLimit: { type: Number, default: void 0 }, disabled: { type: Boolean, default: false }, successMsg: { type: String, default: "" }, dataType: { type: Number, default: void 0 }, materialType: { type: Number, default: void 0 }, tip: { type: String, default: void 0 } }, emits: ["success"], setup(L, { emit: q }) {
  const D = q, e = L, G = s({ Authorization: le() }), F = s(false), X = s([]), T = s([]), g = s([]), C = s(false), k = s(false), $ = s(), c = s(), _ = s([{ id: 1, format: ".pdf", name: "生产图纸(PDF)" }, { id: 2, format: ".pdf", name: "焊缝地图(PDF)" }, { id: 3, format: ".mark", name: "焊缝(MARK)" }]), b = s(_.value[0].id), B = E(() => {
    var t;
    return (t = _.value.find((a) => a.id === b.value)) == null ? void 0 : t.format;
  }), x = E(() => `.zip,${B.value}`);
  function I() {
    b.value = _.value[0].id, e.data.productType === ne.MACHINE_PART.V ? c.value.$el.querySelector("input[type=file]").click() : ce({ title: "请选择要上传的文件类型", message: re(ie, { modelValue: b.value, options: _.value, onChange: (t) => {
      b.value = t;
    } }), showCancelButton: true, confirmButtonText: "确认", cancelButtonText: "取消" }).then(() => {
      c.value.$el.querySelector("input[type=file]").click();
    });
  }
  async function A(t) {
    var u, n;
    F.value = true;
    const a = t.file, l = new FormData();
    l.append("file", a), l.append("fileName", (a == null ? void 0 : a.name) || "");
    for (const i in e.data) e.data[i] && l.append(i, e.data[i]);
    try {
      const r = await (b.value === ((n = (u = _.value) == null ? void 0 : u[1]) == null ? void 0 : n.id) ? oe : R)(l);
      j({ title: "上传成功", type: "success", message: e.successMsg || `${a.name} 上传成功`, duration: 2500 }), D("success", r);
    } catch (i) {
      if (console.log(i), e.uploadFunFile instanceof Function) {
        const r = await e.uploadFunFile(l);
        if (j({ title: "上传失败", type: "error", message: `${a.name} 上传失败`, duration: 2500 }), se(r)) {
          const o = window.URL.createObjectURL(new Blob([r.data])), d = document.createElement("a");
          d.href = o, d.setAttribute("download", `${a.name} 错误信息表.xlsx`), document.body.appendChild(d), d.click(), d.remove();
        }
      }
      D("success", false);
    } finally {
      F.value = false, J();
    }
  }
  function J() {
    var t;
    c.value && c.value.uploadRef && (c.value.uploadRef.fileList.length = 0), (t = c.value) == null || t.clearFiles();
  }
  function K(t) {
    const a = `.${V(t.name)}`.toLowerCase(), l = t.size / 1024 / 1024, u = !e.sizeLimit || e.sizeLimit && l < e.sizeLimit;
    if (x.value && !(x.value.split(",").indexOf(a) > -1)) return S({ message: `上传文件后缀需为${x.value}格式`, type: "error" }), false;
    if (!u) return S({ message: `上传文件大小不能超过 ${e.sizeLimit}MB!`, type: "error" }), false;
    if (a === ".zip") return $.value = t, W(t), false;
  }
  async function W(t) {
    const a = new pe(), l = [], u = [], n = e.tip && e.tip.length > 0 ? e.tip.split(",") : [];
    (await a.loadAsync(t, { decodeFileName: function(r) {
      return fe.decode(r, "gbk");
    } })).forEach((r, y) => {
      const o = `.${V(y.name)}`.toLowerCase();
      if (y.name.substring(y.name.length - 1) !== "/" && y.name.indexOf(".") > -1) {
        const d = { name: y.name, ".PDF": o === ".pdf", ".MARK": o === ".mark", ".JPG": o === ".jpg", ".PNG": o === ".png", ".JPEG": o === ".jpeg", ".DWG": o === ".dwg", ".DXF": o === ".dxf", ".NC1": o === ".nc1", ".XML": o === ".xml" };
        if (e.tip && e.tip.length > 0) {
          const M = [];
          n.forEach((ee) => {
            M.push(d[ee.toUpperCase()]);
          }), M.indexOf(true) < 0 ? u.push(d) : l.push(d);
        }
      }
    }), T.value = l, g.value = u, Y();
  }
  async function H() {
    C.value = true;
    try {
      const t = { file: $.value };
      await A(t);
    } catch (t) {
      console.log(t);
    } finally {
      C.value = false, z();
    }
  }
  function Q(t, a) {
    S({ message: `当前限制选择 ${this.limit} 个文件，本次选择了 ${t.length} 个文件，共选择了 ${t.length + a.length} 个文件`, type: "warning" });
  }
  function Y() {
    k.value = true;
  }
  function z() {
    k.value = false;
  }
  return (t, a) => {
    const l = Z("common-button"), u = Z("common-dialog");
    return p(), f("div", me, [v(l, { disabled: e.disabled, icon: e.icon, loading: F.value, size: e.btnSize, type: e.btnType, onClick: I }, { default: m(() => [N(h(L.btnName), 1)]), _: 1 }, 8, ["disabled", "icon", "loading", "size", "type"]), v(ue(de), { ref_key: "uploadRef", ref: c, accept: x.value, "before-upload": K, "file-list": X.value, headers: G.value, "http-request": A, limit: e.limit, multiple: false, "on-exceed": Q, "show-file-list": false, action: "", style: { height: "0" } }, { default: m(() => [v(l, { disabled: e.disabled, icon: e.icon, loading: F.value, size: e.btnSize, type: e.btnType }, { default: m(() => [N(h(L.btnName), 1)]), _: 1 }, 8, ["disabled", "icon", "loading", "size", "type"])]), _: 1 }, 8, ["accept", "file-list", "headers", "limit"]), v(u, { modelValue: k.value, "onUpdate:modelValue": a[0] || (a[0] = (n) => k.value = n), "before-close": z, title: "压缩包内容", top: "10vh", width: "50%" }, { footer: m(() => [w("span", we, [v(l, { onClick: z }, { default: m(() => a[1] || (a[1] = [N("取 消")])), _: 1, __: [1] }), v(l, { disabled: !!g.value.length, loading: C.value, type: "primary", onClick: H }, { default: m(() => a[2] || (a[2] = [N("上传")])), _: 1, __: [2] }, 8, ["disabled", "loading"])])]), default: m(() => [g.value.length ? (p(), f("span", ge, " 含 " + h(g.value.length) + " 个文件后缀不为“ " + h(B.value) + " ”的文件,请重新打包上传 ", 1)) : P("", true), w("div", ye, [g.value.length ? (p(), f("ul", ve, [(p(true), f(U, null, O(g.value, (n, i) => (p(), f("li", { key: i }, [w("span", he, h(n.name), 1)]))), 128))])) : P("", true), w("ul", _e, [(p(true), f(U, null, O(T.value, (n, i) => (p(), f("li", { key: i }, [w("span", be, h(n.name), 1)]))), 128))])])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Le = te(Fe, [["__scopeId", "data-v-0ce2cb80"]]);
export {
  Le as default
};
