import { resolveComponent as c } from "vue";
import { withDirectives as v } from "vue";
import { vShow as w } from "vue";
import { unref as t } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as s } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as o } from "vue";
import { createTextVNode as i } from "vue";
import { toDisplayString as d } from "vue";
import { renderSlot as _ } from "vue";
import { createBlock as E } from "vue";
import { createCommentVNode as Q } from "vue";
import { withKeys as g } from "vue";
import { withModifiers as S } from "vue";
import { ElTag as z } from "element-plus";
import { ElCard as N } from "element-plus";
import { ElInput as T } from "element-plus";
import { _ as U, qx as q, B, qz as D, rd as K } from "../../../../../../shared/runtime.js";
const j = { style: { "margin-top": "20px", display: "flex", "justify-content": "space-between" } }, H = { style: { display: "flex" } }, O = { __name: "header", props: { labelInfo: { type: Object, default: () => {
} } }, setup(r) {
  const b = { cutSendStatus: q.NOT_ISSUED.V, cuttingStatus: void 0 };
  function V() {
    a.toQuery();
  }
  function k() {
    n.thickness = void 0, n.material = void 0, n.cuttingStatus = void 0, a.toQuery();
  }
  const { crud: a, query: n } = B(b);
  return (p, e) => {
    const x = z, m = c("common-button"), I = N, h = c("common-radio-button"), f = T;
    return v((y(), C("div", null, [s(I, null, { default: u(() => [o("span", null, [e[5] || (e[5] = o("span", { style: { "margin-left": "10px" } }, "套料明细 ", -1)), s(x, { type: "primary" }, { default: u(() => {
      var l;
      return [i("工单号：" + d((l = r.labelInfo) == null ? void 0 : l.label), 1)];
    }), _: 1 }), s(m, { type: "primary", round: "", size: "default", style: { "margin-left": "10px" } }, { default: u(() => [o("span", null, " 零件总数：" + d(r.labelInfo.amount || 0) + "件", 1), e[3] || (e[3] = i("  |   ")), o("span", null, "已套总数：" + d(r.labelInfo.nestingQuantity || 0) + "件", 1), e[4] || (e[4] = i("  |   ")), o("span", null, "已报总数：" + d(r.labelInfo.cutQuantity || 0) + "件", 1)]), _: 1, __: [3, 4] })]), _(p.$slots, "header", {}, void 0, true)]), _: 3 }), o("div", j, [o("div", H, [t(a).query.cutSendStatus === t(D).HAS_ISSUED.V ? (y(), E(h, { key: 0, modelValue: t(n).cuttingStatus, "onUpdate:modelValue": e[0] || (e[0] = (l) => t(n).cuttingStatus = l), type: "enum", options: t(K).ENUM, showOptionAll: "", class: "filter-item", size: "default", onChange: t(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : Q("", true), s(f, { modelValue: t(n).thickness, "onUpdate:modelValue": e[1] || (e[1] = (l) => t(n).thickness = l), placeholder: "厚度搜索", class: "filter-item", style: { width: "160px" }, size: "default", clearable: "", onKeyup: g(t(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(f, { modelValue: t(n).material, "onUpdate:modelValue": e[2] || (e[2] = (l) => t(n).material = l), placeholder: "材质搜索", class: "filter-item", style: { width: "160px" }, size: "default", clearable: "", onKeyup: g(t(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(m, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: S(V, ["stop"]) }, { default: u(() => e[6] || (e[6] = [i(" 搜索 ")])), _: 1, __: [6] }), s(m, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: S(k, ["stop"]) }, { default: u(() => e[7] || (e[7] = [i(" 重置 ")])), _: 1, __: [7] })]), _(p.$slots, "right", {}, void 0, true)])], 512)), [[w, t(a).searchToggle]]);
  };
} }, $ = U(O, [["__scopeId", "data-v-cc82f1d0"]]);
export {
  $ as default
};
