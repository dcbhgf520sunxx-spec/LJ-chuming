import { ref as p } from "vue";
import { watch as j } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as n } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as v } from "vue";
import { createCommentVNode as w } from "vue";
import { normalizeClass as G } from "vue";
import { unref as E } from "vue";
import { ElUpload as H } from "element-plus";
import { Fragment as X } from "vue";
import { ElMessage as h } from "element-plus";
import { ElMessageBox as L } from "element-plus";
import { Plus as Y } from "@element-plus/icons-vue";
import { ElIcon as Z } from "element-plus";
import { ElImage as q } from "element-plus";
import { ZoomIn as J } from "@element-plus/icons-vue";
import { Download as K } from "@element-plus/icons-vue";
import { Delete as Q } from "@element-plus/icons-vue";
import { ElDialog as W } from "element-plus";
import { S as ee, m as le, X as te, Y as se, Z as ae } from "../shared/runtime.js";
const oe = { class: "el-upload-list__item-actions" }, ne = ["onClick"], ie = ["onClick"], ce = ["onClick"], de = { key: 1, class: "el-upload-list__move" }, ue = ["onClick"], fe = ["onClick"], re = ["src"], me = { __name: "PicUpload", props: { data: { type: Object, default: () => {
} }, files: { type: Array, default: () => [] }, fileClassify: { type: Number, default: ee.NORMAL.V }, listType: { type: String, default: "picture-card" }, limit: { type: Number, default: void 0 }, hasBeforeConfirm: { type: Boolean, default: false }, beforeMessage: { type: String, default: "确认上传吗？" }, successMessage: { type: String, default: "上传成功" }, showFileList: { type: Boolean, default: true }, accept: { type: String, default: "image/*" }, disabled: { type: Boolean, default: false }, showMoveBtn: { type: Boolean, default: false }, showDownloadBtn: { type: Boolean, default: false } }, emits: ["update:files", "change"], setup(i, { expose: M, emit: U }) {
  const u = U, l = i, { fileUploadApi: V } = le("fileUploadApi"), r = p(), N = p({ Authorization: te() }), g = p(false), b = p(false), k = p("");
  j(() => l.files, (e) => {
    (!e || (e == null ? void 0 : e.length) === 0) && x();
  }, { deep: true });
  function S(e, a, t) {
    if (g.value = false, e && e.code === 2e4) {
      const s = e.data, c = [...l.files || []];
      c.push(Object.assign(s, { uid: a.uid, url: a.url })), u("update:files", c), u("change"), h.success(l.successMessage);
    } else h.error(e && e.message ? e.message : "上传失败");
  }
  function $() {
    g.value = false, h.error("上传失败");
  }
  function C(e, a) {
    for (const t in l.files) if (l.files[t].uid === e.uid || l.files[t].id === e.id) {
      const s = [...l.files];
      s.splice(t, 1), u("update:files", s), u("change");
      break;
    }
  }
  async function A(e) {
    try {
      await se(ae, { id: e == null ? void 0 : e.id }), h.success("下载成功");
    } catch (a) {
      console.log(a);
    }
  }
  function B(e, a) {
    for (let t = 0; t < l.files.length; t++) if (l.files[t].uid === e.uid || l.files[t].id === e.id) {
      const s = [...l.files];
      if (a === "next") {
        const c = s.splice(t, 1)[0], f = t !== l.files.length - 1 ? t + 1 : 0;
        console.log(t, f, s), s.splice(f, 0, c);
      }
      if (a === "prev") {
        const c = s.splice(t, 1)[0], f = t !== 0 ? t - 1 : l.files.length - 1;
        s.splice(f, 0, c);
      }
      u("update:files", s), u("change");
      break;
    }
  }
  function D(e) {
    k.value = e.imageUrl || e.fullPath, b.value = true;
  }
  function F(e, a) {
    h.warning(`当前限制选择 ${l.limit} 个文件`);
  }
  function I() {
    return l.hasBeforeConfirm ? L.confirm(l.beforeMessage) : true;
  }
  function P(e, a) {
    if (e && e.status === "success") return L.confirm(`确定移除 ${e.name}？`);
  }
  function x() {
    var e;
    (e = r.value) == null || e.clearFiles(), r.value && r.value.uploadRef && (r.value.uploadRef.fileList.length = 0);
  }
  function R() {
    g.value = true;
  }
  return M({ clearFiles: x }), (e, a) => {
    const t = Y, s = Z, c = q, f = J, z = K, T = Q, O = W;
    return _(), m(X, null, [n(E(H), { class: G({ hide: i.files.length >= i.limit }), ref_key: "upload", ref: r, data: { ...l.data, fileType: l.fileClassify }, action: E(V), headers: N.value, "on-success": S, "on-error": $, "on-progress": R, "on-remove": C, "before-upload": I, "before-remove": P, limit: l.limit, "show-file-list": l.showFileList, "on-exceed": F, disabled: l.disabled || g.value, accept: l.accept, "file-list": l.files, multiple: "", "list-type": l.listType }, { file: d(({ file: o }) => [n(c, { class: "el-upload-list__item-thumbnail", src: o.tinyImageUrl || o.url, fit: "scale-down" }, null, 8, ["src"]), v("span", oe, [v("span", { class: "el-upload-list__item-preview", onClick: (y) => D(o) }, [n(s, null, { default: d(() => [n(f)]), _: 1 })], 8, ne), i.showDownloadBtn ? (_(), m("span", { key: 0, class: "el-upload-list__item-download", onClick: (y) => A(o) }, [n(s, null, { default: d(() => [n(z)]), _: 1 })], 8, ie)) : w("", true), v("span", { class: "el-upload-list__item-delete", onClick: (y) => C(o) }, [n(s, null, { default: d(() => [n(T)]), _: 1 })], 8, ce), i.showMoveBtn && i.files.length > 1 ? (_(), m("span", de, [o.id !== i.files[0].id ? (_(), m("span", { key: 0, onClick: (y) => B(o, "prev") }, "前移", 8, ue)) : w("", true), o.id !== i.files[i.files.length - 1].id ? (_(), m("span", { key: 1, onClick: (y) => B(o, "next") }, "后移", 8, fe)) : w("", true)])) : w("", true)])]), default: d(() => [n(s, null, { default: d(() => [n(t)]), _: 1 })]), _: 1 }, 8, ["class", "data", "action", "headers", "limit", "show-file-list", "disabled", "accept", "file-list", "list-type"]), n(O, { modelValue: b.value, "onUpdate:modelValue": a[0] || (a[0] = (o) => b.value = o), "append-to-body": "" }, { default: d(() => [v("img", { style: { width: "100%" }, src: k.value, alt: "加载失败" }, null, 8, re)]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  me as _
};
