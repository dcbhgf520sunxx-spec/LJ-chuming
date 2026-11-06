import { _ as f, tC as y } from "../../../../../../shared/runtime.js";
import { useStore as b } from "vuex";
import { resolveComponent as g } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as l } from "vue";
import { createElementVNode as e } from "vue";
import { Fragment as S } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as N } from "vue";
import { renderSlot as h } from "vue";
import { createVNode as v } from "vue";
import { withCtx as x } from "vue";
import { createTextVNode as C } from "vue";
import { unref as c } from "vue";
const T = { class: "requisitions-application-footer" }, k = { class: "total-box" }, V = { class: "total-name" }, B = { class: "total-item" }, w = { __name: "common-footer", props: { permission: { type: Array, default: void 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "确认并提交" }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, showTotal: { type: Boolean, default: true }, isSubmit: { type: Boolean, default: false } }, emits: ["submit"], setup(n, { emit: m }) {
  const i = m, t = n, { cu: o, FORM: u } = y(), d = b();
  async function _() {
    if (t.isSubmit) try {
      o.form.clickTime = d.state.config.getTreeClickTime, await o.submit(), i("submit");
    } catch (a) {
      console.log("入库表单提交", a);
    }
    else i("submit");
  }
  return (a, F) => {
    const p = g("common-button");
    return r(), l("div", T, [e("div", k, [t.showTotal ? (r(), l(S, { key: 0 }, [e("div", V, s(t.totalName), 1), e("div", B, s(`${t.totalValue || 0} ${t.unit || ""}`), 1)], 64)) : N("", true)]), e("div", null, [h(a.$slots, "calculator", {}, void 0, true), v(p, { loading: c(o).status.edit === c(u).STATUS.PROCESSING, size: "default", style: { "margin-left": "10px" }, type: "primary", onClick: _ }, { default: x(() => [C(s(n.btnName), 1)]), _: 1 }, 8, ["loading"])])]);
  };
} }, A = f(w, [["__scopeId", "data-v-e9053740"]]);
export {
  A as default
};
