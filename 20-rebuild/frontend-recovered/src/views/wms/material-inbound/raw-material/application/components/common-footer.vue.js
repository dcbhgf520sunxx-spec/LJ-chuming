import { _ as g, tC as S } from "../../../../../../shared/runtime.js";
import { useStore as v } from "vuex";
import { resolveComponent as T } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as s } from "vue";
import { createElementVNode as e } from "vue";
import { Fragment as l } from "vue";
import { toDisplayString as a } from "vue";
import { createCommentVNode as i } from "vue";
import { renderSlot as N } from "vue";
import { createVNode as h } from "vue";
import { withCtx as w } from "vue";
import { createTextVNode as C } from "vue";
import { unref as c } from "vue";
const V = { class: "inbound-application-footer" }, k = { class: "total-box" }, x = { class: "total-item" }, B = { class: "total-item" }, $ = { class: "total-name" }, A = { class: "total-item" }, U = { class: "total-item" }, F = { __name: "common-footer", props: { permission: { type: Array, default: void 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "确认并提交" }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, contractUnit: { type: String, default: "" }, contractValue: { type: [Number, String], default: 0 }, showContractTotal: { type: Boolean, default: false }, inboundUnit: { type: String, default: "" }, inboundValue: { type: [Number, String], default: 0 }, showInboundTotal: { type: Boolean, default: false }, showTotal: { type: Boolean, default: true }, showTotalAmount: { type: Boolean, default: false }, totalAmount: { type: [Number, String], default: 0 }, isSubmit: { type: Boolean, default: false } }, emits: ["submit"], setup(d, { emit: f }) {
  const p = v(), m = f, t = d, { cu: u, FORM: _ } = S();
  async function b() {
    if (t.isSubmit) try {
      u.form.clickTime = p.state.config.getTreeClickTime, await u.submit(), m("submit");
    } catch (r) {
      console.log("入库表单提交", r);
    }
    else m("submit");
  }
  return (r, o) => {
    const y = T("common-button");
    return n(), s("div", V, [e("div", k, [t.showContractTotal ? (n(), s(l, { key: 0 }, [o[0] || (o[0] = e("div", { class: "total-name" }, "合同量", -1)), e("div", x, a(`${t.contractValue || 0} ${t.contractUnit || ""}`), 1)], 64)) : i("", true), t.showInboundTotal ? (n(), s(l, { key: 1 }, [o[1] || (o[1] = e("div", { class: "total-name" }, "已入库量", -1)), e("div", B, a(`${t.inboundValue || 0} ${t.inboundUnit || ""}`), 1)], 64)) : i("", true), t.showTotal ? (n(), s(l, { key: 2 }, [e("div", $, a(t.totalName), 1), e("div", A, a(`${t.totalValue || 0} ${t.unit || ""}`), 1)], 64)) : i("", true), t.showTotalAmount ? (n(), s(l, { key: 3 }, [o[2] || (o[2] = e("div", { class: "total-name" }, "金额合计", -1)), e("div", U, a(`${t.totalAmount || 0} 元`), 1)], 64)) : i("", true)]), e("div", null, [N(r.$slots, "calculator", {}, void 0, true), h(y, { loading: c(u).status.edit === c(_).STATUS.PROCESSING, size: "default", style: { "margin-left": "10px" }, type: "primary", onClick: b }, { default: w(() => [C(a(d.btnName), 1)]), _: 1 }, 8, ["loading"])])]);
  };
} }, D = g(F, [["__scopeId", "data-v-47bb56ae"]]);
export {
  D as default
};
