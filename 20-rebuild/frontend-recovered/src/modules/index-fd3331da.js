import { ref as b } from "vue";
import { computed as h } from "vue";
import { watch as C } from "vue";
import { nextTick as k } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as o } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as p } from "vue";
import { createBlock as D } from "vue";
import { createTextVNode as d } from "vue";
import { createCommentVNode as S } from "vue";
import { toDisplayString as N } from "vue";
import { WarningFilled as z } from "@element-plus/icons-vue";
import { ElIcon as I } from "element-plus";
import { ElDialog as q } from "element-plus";
import { _ as F } from "../shared/runtime.js";
const T = { class: "del-confirm" }, j = { class: "tip" }, L = { class: "dialog-footer" }, U = { __name: "index", props: { modelValue: { type: Boolean, require: true }, fn: { type: Function, require: true }, showExit: { type: Boolean, default: false }, width: { type: String, default: "400px" }, top: { type: String, default: "33vh" }, tip: { type: String, default: "此操作将删除该记录, 是否继续?" } }, emits: ["success", "error", "exit", "cancel", "update:modelValue"], setup(c, { emit: _ }) {
  const a = _, n = c, l = b(false), r = h(() => n.modelValue);
  C(r, (i) => {
    i || k(() => {
      l.value = false;
    });
  });
  async function m() {
    if (!l.value) {
      l.value = true;
      try {
        await n.fn(), s(), a("success");
      } catch (i) {
        console.log("error", i);
      }
    }
  }
  function g() {
    a("cancel"), s();
  }
  function y() {
    a("exit"), s();
  }
  function s() {
    a("update:modelValue", false);
  }
  return (i, e) => {
    const x = z, v = I, u = E("common-button"), w = q;
    return f(), B("div", T, [o(w, { title: "提示", modelValue: r.value, "onUpdate:modelValue": e[0] || (e[0] = (V) => r.value = V), width: n.width, "before-close": s, "show-close": false, top: c.top }, { footer: t(() => [p("span", L, [c.showExit ? (f(), D(u, { key: 0, type: "danger", size: "default", onClick: y }, { default: t(() => e[1] || (e[1] = [d("退 出")])), _: 1, __: [1] })) : S("", true), o(u, { size: "default", onClick: g }, { default: t(() => e[2] || (e[2] = [d("取 消")])), _: 1, __: [2] }), o(u, { loading: l.value, type: "primary", size: "default", onClick: m }, { default: t(() => e[3] || (e[3] = [d("确 定")])), _: 1, __: [3] }, 8, ["loading"])])]), default: t(() => [p("span", j, [o(v, null, { default: t(() => [o(x)]), _: 1 }), d(N(n.tip), 1)])]), _: 1 }, 8, ["modelValue", "width", "top"])]);
  };
} }, G = F(U, [["__scopeId", "data-v-fb62b34f"]]);
export {
  G as D
};
