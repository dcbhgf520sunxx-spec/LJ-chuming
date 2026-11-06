import { ref as l } from "vue";
import { reactive as S } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as s } from "vue";
import { withCtx as n } from "vue";
import { unref as a } from "vue";
import { createElementVNode as m } from "vue";
import { createBlock as _ } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as L } from "vue";
import { createCommentVNode as g } from "vue";
import { withModifiers as P } from "vue";
import { ElMessageBox as j } from "element-plus";
import { ElMessage as z } from "element-plus";
import { ElCol as Q } from "element-plus";
import { ElTag as G } from "element-plus";
import { ElCard as O } from "element-plus";
import { ElRow as U } from "element-plus";
import { d as W } from "../../../modules/flow-config-2bf9a9d0.js";
import { _ as q, G as v, dW as d } from "../../../shared/runtime.js";
import A from "./flow-list/index.vue.js";
import H from "./flow-preview/index.vue.js";
import J from "./module/form.vue.js";
import "./flow-list/module/header.vue.js";
const K = { class: "app-container" }, X = { __name: "index", setup(Y) {
  const y = l(""), f = l(false), x = l({}), u = l(), i = l();
  let o = S({});
  const w = l({}), h = l({});
  function C(e) {
    v(d.detail) && (e ? (o = Object.assign(o, e), h.value = e) : o = {});
  }
  async function k() {
    var e, t;
    await j.confirm("确认删除当前选中流程数据吗?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
    try {
      await W({ id: (e = h.value) == null ? void 0 : e.id }), z.success("删除成功"), await ((t = u.value) == null ? void 0 : t.toQuery());
    } catch (r) {
      console.log(r, "删除失败");
    }
  }
  function T(e) {
    console.log(e, "del"), w.value = e;
  }
  function D(e) {
    console.log(e, "val"), x.value = e || {};
  }
  function E() {
    y.value = "edit", f.value = true;
  }
  async function B() {
    var e, t;
    await ((e = u.value) == null ? void 0 : e.toQuery()), await ((t = i.value) == null ? void 0 : t.fecthDetail());
  }
  return (e, t) => {
    const r = Q, R = G, b = F("common-button"), V = O, M = U;
    return c(), I("div", K, [s(M, { gutter: 10 }, { default: n(() => [s(r, { xs: 24, sm: 24, md: 24, lg: 10, xl: 10, style: { "margin-bottom": "10px" } }, { default: n(() => [s(a(A), { onClickLine: C, ref_key: "dicRef", ref: u }, null, 512)]), _: 1 }), s(r, { xs: 24, sm: 24, md: 24, lg: 14, xl: 14 }, { default: n(() => [s(V, { class: "box-card team-card" }, { header: n(() => [m("div", null, [t[1] || (t[1] = m("span", { style: { "line-height": "33px", "margin-right": "5px", "font-size": "18px", "font-weight": "bold" } }, " 流程预览 ", -1)), a(o).name ? (c(), _(R, { key: 0, size: "large" }, { default: n(() => [p(L(a(o).name), 1)]), _: 1 })) : g("", true)]), m("div", null, [a(v)(a(d).del) ? (c(), _(b, { key: 0, class: "filter-item", style: { float: "right", "margin-left": "6px" }, type: "danger", disabled: !a(o).name || !i.value, onClick: P(k, ["stop"]) }, { default: n(() => t[2] || (t[2] = [p(" 删除 ")])), _: 1, __: [2] }, 8, ["disabled"])) : g("", true), a(v)(a(d).edit) ? (c(), _(b, { key: 1, style: { float: "right" }, type: "primary", class: "filter-item", disabled: !a(o).name || !i.value, onClick: E }, { default: n(() => t[3] || (t[3] = [p(" 编辑 ")])), _: 1, __: [3] }, 8, ["disabled"])) : g("", true)])]), default: n(() => [s(a(H), { ref_key: "dictDetailRef", ref: i, line: a(o), onDelChange: T, onTreeChange: D }, null, 8, ["line"])]), _: 1 }), s(J, { visible: f.value, "onUpdate:visible": t[0] || (t[0] = (N) => f.value = N), "tree-info": x.value, showType: y.value, permission: a(d), onSuccess: B }, null, 8, ["visible", "tree-info", "showType", "permission"])]), _: 1 })]), _: 1 })]);
  };
} }, le = q(X, [["__scopeId", "data-v-aba63f98"]]);
export {
  le as default
};
