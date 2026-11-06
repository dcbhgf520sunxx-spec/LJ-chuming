import { useStore as _ } from "vuex";
import { ref as m } from "vue";
import { openBlock as L } from "vue";
import { createBlock as f } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as s } from "vue";
import { unref as h } from "vue";
import { createCommentVNode } from "vue";
import { Plus as b } from "@element-plus/icons-vue";
import { ElIcon as w } from "element-plus";
import { ElUpload as v } from "element-plus";
import { ElCard as y } from "element-plus";
import { eU as P, eV as A, e2 as n, eW as x, eL as configPermission, G as hasPermission } from "../../../../../shared/runtime.js";
const E = { class: "" }, S = { __name: "print-logo", setup(B) {
  const c = _(), a = m([]);
  async function l() {
    if (!hasPermission(configPermission.logo.get)) return;
    try {
      const { content: o } = await P();
      a.value = o.map((e) => ({ ...e, url: e.path })), await c.dispatch("user/setLabelLogo", o[0].path);
    } catch (o) {
      console.log(o, "getProductLabelLogoApi");
    }
  }
  l();
  async function i(o) {
    if (!hasPermission(configPermission.logo.edit)) return;
    a.value = [o];
    try {
      const e = new FormData();
      e.append("file", o.raw), await A(e), n("success", "上传成功"), await l();
    } catch (e) {
      console.log(e, "postProductLabelLogoApi");
    }
  }
  async function u() {
    if (!hasPermission(configPermission.logo.edit)) return;
    try {
      const o = a.value[0].id;
      await x(o), n("success", "删除成功"), a.value = [], await c.dispatch("user/setLabelLogo", "");
    } catch (o) {
      console.log(o, "deleteProductLabelLogoApi");
    }
  }
  return (o, e) => {
    const p = w, d = v, g = y;
    return hasPermission(configPermission.logo.get) ? (L(), f(g, { class: "box-card", shadow: "hover" }, { header: t(() => e[0] || (e[0] = [r("span", { class: "title" }, "标签打印logo配置", -1)])), default: t(() => [r("div", E, [s(d, { "auto-upload": false, disabled: !hasPermission(configPermission.logo.edit), "file-list": a.value, "on-change": i, "on-remove": u, accept: "", "list-type": "picture-card" }, { default: t(() => [hasPermission(configPermission.logo.edit) ? s(p, null, { default: t(() => [s(h(b))]), _: 1 }) : createCommentVNode("", true)]), _: 1 }, 8, ["disabled", "file-list"])])]), _: 1 })) : createCommentVNode("", true);
  };
} };
export {
  S as default
};
