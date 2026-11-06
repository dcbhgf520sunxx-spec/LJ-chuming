import { resolveComponent as w } from "vue";
import { withDirectives as C } from "vue";
import { vShow as E } from "vue";
import { unref as l } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as a } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as s } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as d } from "vue";
import { renderSlot as _ } from "vue";
import { withKeys as g } from "vue";
import { Fragment as I } from "vue";
import { renderList as z } from "vue";
import { createBlock as B } from "vue";
import { withModifiers as b } from "vue";
import { ElTag as K } from "element-plus";
import { ElCard as N } from "element-plus";
import { ElInput as T } from "element-plus";
import { ElOption as U } from "element-plus";
import { ElSelect as j } from "element-plus";
import { _ as q, B as D, qx as H } from "../../../../../../shared/runtime.js";
const L = { style: { "margin-top": "20px", display: "flex", "justify-content": "space-between" } }, M = { style: { display: "flex" } }, O = { __name: "header", props: { labelInfo: { type: Object, default: () => {
} } }, setup(i) {
  const V = {};
  function x() {
    o.toQuery();
  }
  function v() {
    n.thickness = void 0, n.material = void 0, n.cutSendStatus = void 0, o.toQuery();
  }
  const { crud: o, query: n } = D(V);
  return (m, e) => {
    const S = K, p = w("common-button"), h = N, c = T, k = U, Q = j;
    return C((f(), y("div", null, [a(h, null, { default: u(() => [s("span", null, [e[5] || (e[5] = s("span", { style: { "margin-left": "10px" } }, "套料明细 ", -1)), a(S, { type: "primary" }, { default: u(() => {
      var t;
      return [r("工单号：" + d((t = i.labelInfo) == null ? void 0 : t.label), 1)];
    }), _: 1 }), a(p, { type: "primary", round: "", size: "default", style: { "margin-left": "10px" } }, { default: u(() => [s("span", null, " 零件总数：" + d(i.labelInfo.amount || 0) + "件", 1), e[3] || (e[3] = r("  |   ")), s("span", null, "已套总数：" + d(i.labelInfo.nestingQuantity || 0) + "件", 1), e[4] || (e[4] = r("  |   ")), s("span", null, "已报总数：" + d(i.labelInfo.cutQuantity || 0) + "件", 1)]), _: 1, __: [3, 4] })]), _(m.$slots, "header", {}, void 0, true)]), _: 3 }), s("div", L, [s("div", M, [a(c, { modelValue: l(n).thickness, "onUpdate:modelValue": e[0] || (e[0] = (t) => l(n).thickness = t), placeholder: "厚度搜索", class: "filter-item", style: { width: "160px" }, size: "default", clearable: "", onKeyup: g(l(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(c, { modelValue: l(n).material, "onUpdate:modelValue": e[1] || (e[1] = (t) => l(n).material = t), placeholder: "材质搜索", class: "filter-item", style: { width: "160px" }, size: "default", clearable: "", onKeyup: g(l(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(Q, { modelValue: l(n).cutSendStatus, "onUpdate:modelValue": e[2] || (e[2] = (t) => l(n).cutSendStatus = t), style: { width: "160px" }, placeholder: "请选择下发状态", onChange: l(o).toQuery, class: "filter-item", size: "default", clearable: "" }, { default: u(() => [(f(true), y(I, null, z(l(H).ENUM, (t) => (f(), B(k, { key: t.V, label: t.L, value: +t.V }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "onChange"]), a(p, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: b(x, ["stop"]) }, { default: u(() => e[6] || (e[6] = [r("搜索")])), _: 1, __: [6] }), a(p, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: b(v, ["stop"]) }, { default: u(() => e[7] || (e[7] = [r(" 重置 ")])), _: 1, __: [7] })]), _(m.$slots, "right", {}, void 0, true)])], 512)), [[E, l(o).searchToggle]]);
  };
} }, R = q(O, [["__scopeId", "data-v-96152079"]]);
export {
  R as default
};
