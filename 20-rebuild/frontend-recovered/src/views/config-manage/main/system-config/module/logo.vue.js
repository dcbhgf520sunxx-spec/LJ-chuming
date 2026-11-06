import { useStore as H } from "vuex";
import { ref as r } from "vue";
import { resolveComponent as O } from "vue";
import { unref as s } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as E } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as d } from "vue";
import { withDirectives as R } from "vue";
import { createElementBlock as y } from "vue";
import { ElUpload as X } from "element-plus";
import { createCommentVNode as g } from "vue";
import { ElMessage as u } from "element-plus";
import { InfoFilled as Z } from "@element-plus/icons-vue";
import { ElIcon as J } from "element-plus";
import { ElTooltip as K } from "element-plus";
import { Plus as Q } from "@element-plus/icons-vue";
import { ElImage as W } from "element-plus";
import { ZoomIn as Y } from "@element-plus/icons-vue";
import { Check as ee } from "@element-plus/icons-vue";
import { Delete as oe } from "@element-plus/icons-vue";
import { ElDialog as te } from "element-plus";
import { ElCard as le } from "element-plus";
import { vLoading as ae } from "element-plus";
import { _ as ne, m as se, X as ie, G as m, eN as ce, eL as de, eO as ue, eP as re } from "../../../../../shared/runtime.js";
const _e = { style: { display: "inline-block", cursor: "pointer" } }, fe = { style: { display: "flex", "align-items": "center" } }, pe = { class: "el-upload-list__item-actions" }, ge = ["onClick"], me = ["onClick"], he = ["onClick"], ve = ["src"], ye = { __name: "logo", setup(Ce) {
  const { fileUploadCompanyLogoApi: D } = se("fileUploadCompanyLogoApi"), f = de.logo, I = H(), w = r({ Authorization: ie() }), h = r(false), v = r(false), C = r(""), a = r([]);
  k();
  async function k() {
    if (m(f.get)) {
      h.value = true;
      try {
        const { content: e = [] } = await ce() || {};
        a.value = e.map((o) => ({ id: o.id, isDefault: o.isDefault, path: o.path }));
      } catch (e) {
        console.log("上传公司logo", e);
      } finally {
        h.value = false;
      }
    }
  }
  function p(e = {}) {
    I.dispatch("config/setCompany", e);
  }
  async function x(e) {
    try {
      if (await ue(e.id)) {
        const o = a.value.findIndex((i) => i.id === e.id);
        let n = "";
        o !== -1 && (u.success("已删除"), a.value.splice(o, 1), a.value.length && e.isDefault && (a.value[0].isDefault = true, n = a.value[0].path)), p({ logo: n });
      }
    } catch (o) {
      console.log("删除公司logo", o);
    }
  }
  function B(e) {
    C.value = e.path, v.value = true;
  }
  async function L(e) {
    e.isDefault || (await re(e.id), a.value.forEach((o) => {
      o.isDefault = o.id === e.id, o.isDefault && p({ logo: o.path });
    }));
  }
  function V(e, o, n) {
    n.splice(n.length - 1, 1), e.code === 2e4 ? (a.value.length || (e.isDefault = true, p({ logo: e.path })), u.success("上传成功"), k()) : u.error(e.message);
  }
  function P(e, o, n) {
    u.error(e.message);
  }
  function M() {
    u.error("最多只能上传10张logo");
  }
  function N(e) {
    return e.size > 10 * 1024 * 1024 ? (u.error("上传logo大小不能超过10MB!", 2e3), false) : true;
  }
  return (e, o) => {
    const n = Z, i = J, U = K, $ = Q, z = W, A = Y, j = ee, F = oe, G = O("table-cell-tag"), S = te, T = le, q = ae;
    return s(m)(s(f).get) ? (_(), E(T, { key: 0, class: "box-card", shadow: "hover" }, { header: l(() => [t(U, { class: "item", effect: "light", content: `logo使用说明：

            1.请上传jpg、jpeg、png格式的图片。

            2.单张图片大小不能超过10MB。

            3.最多上传10张图片。

            4.部分打印会使用到默认logo。`, placement: "top" }, { default: l(() => [d("div", _e, [d("div", fe, [o[1] || (o[1] = d("span", { class: "title" }, "公司logo配置", -1)), t(i, { color: "#909399" }, { default: l(() => [t(n)]), _: 1 })])])]), _: 1 })]), default: l(() => [R((_(), y("div", null, [t(s(X), { action: s(D), accept: "image/*", limit: 10, headers: w.value, "list-type": "picture-card", "file-list": a.value, "before-upload": N, "on-success": V, "on-error": P, "on-exceed": M }, { file: l(({ file: c }) => [t(z, { class: "el-upload-list__item-thumbnail", src: c.path, alt: "logo", fit: "scale-down" }, { error: l(() => [d("span", { class: "local-attachment-unavailable" }, "本地附件不可用，请补齐原文件或重新上传。")]), _: 1 }, 8, ["src"]), d("span", pe, [d("span", { class: "el-upload-list__item-preview", onClick: (b) => B(c) }, [t(i, null, { default: l(() => [t(A)]), _: 1 })], 8, ge), s(m)(s(f).edit) ? (_(), y("span", { key: 0, class: "el-upload-list__item-delete", onClick: (b) => L(c) }, [t(i, null, { default: l(() => [t(j)]), _: 1 })], 8, me)) : g("", true), s(m)(s(f).edit) ? (_(), y("span", { key: 1, class: "el-upload-list__item-delete", onClick: (b) => x(c) }, [t(i, null, { default: l(() => [t(F)]), _: 1 })], 8, he)) : g("", true)]), c.isDefault ? (_(), E(G, { key: 0, name: "默认", color: "#1890ff" })) : g("", true)]), default: l(() => [t(i, null, { default: l(() => [t($)]), _: 1 })]), _: 1 }, 8, ["action", "headers", "file-list"]), t(S, { modelValue: v.value, "onUpdate:modelValue": o[0] || (o[0] = (c) => v.value = c) }, { default: l(() => [d("img", { style: { width: "100%" }, src: C.value, alt: "logo" }, null, 8, ve)]), _: 1 }, 8, ["modelValue"])])), [[q, h.value]])]), _: 1 })) : g("", true);
  };
} }, Ee = ne(ye, [["__scopeId", "data-v-bdb67f5c"]]);
export {
  Ee as default
};
