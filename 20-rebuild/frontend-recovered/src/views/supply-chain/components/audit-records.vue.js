import { ref as d } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as l } from "vue";
import { withModifiers as i } from "vue";
import { toDisplayString as n } from "vue";
import { createVNode as b } from "vue";
import { Fragment as A } from "vue";
import { _ as L, t3 as T, t6 as r } from "../../../shared/runtime.js";
const _ = { class: "flex-rcc mr-10 app-list" }, N = { __name: "audit-records", props: { APPtotal: { type: Number, default: void 0 }, subTotal: { type: Number, default: void 0 }, rejTotal: { type: Number, default: void 0 }, moduleType: { type: Number, default: void 0 }, componentNameList: { type: String, default: void 0 } }, emits: ["openAPLists", "handleSuccess"], setup(p, { emit: f }) {
  const v = f, a = p, o = d(false), t = d({});
  function u(m) {
    const e = m;
    t.value.moduleType = a.moduleType, t.value.componentNameList = [a.componentNameList], e === 1 ? (t.value.reviewStatus = r.WITHDRAW.V, t.value.waitMeCheck = true, t.value.meLaunch = false) : e === 2 ? (t.value.reviewStatus = r.WITHDRAW.V, t.value.waitMeCheck = false, t.value.meLaunch = true) : e === 3 && (t.value.reviewStatus = r.REJECT.V, t.value.waitMeCheck = false, t.value.meLaunch = false), o.value = true;
  }
  return (m, e) => (c(), y(A, null, [l("div", _, [e[5] || (e[5] = l("div", { class: "title" }, " 审核记录 ", -1)), l("div", { class: "mr-20-imp filter-item a-sub", style: { color: "#e6a23c", "margin-left": "10px !important" }, onClick: e[0] || (e[0] = i((s) => u(1), ["stop"])) }, " 需要我审核的：" + n(a.APPtotal), 1), l("div", { class: "mr-20-imp filter-item a-sub", onClick: e[1] || (e[1] = i((s) => u(2), ["stop"])) }, " 我提交的：" + n(a.subTotal), 1), l("div", { class: "mr-10 filter-item a-sub", style: { color: "#f56c6c" }, onClick: e[2] || (e[2] = i((s) => u(3), ["stop"])) }, " 被驳回的：" + n(a.rejTotal), 1)]), b(T, { modelValue: o.value, "onUpdate:modelValue": e[3] || (e[3] = (s) => o.value = s), form: t.value, onSuccess: e[4] || (e[4] = (s) => v("handleSuccess")) }, null, 8, ["modelValue", "form"])], 64));
} }, k = L(N, [["__scopeId", "data-v-a88f886f"]]);
export {
  k as default
};
