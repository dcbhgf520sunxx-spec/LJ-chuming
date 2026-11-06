import { computed as N } from "vue";
import { ref as V } from "vue";
import { resolveComponent as d } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as T } from "vue";
import { withDirectives as p } from "vue";
import { vShow as v } from "vue";
import { unref as e } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as n } from "vue";
import { withCtx as f } from "vue";
import { createBlock as k } from "vue";
import { createTextVNode as h } from "vue";
import { createCommentVNode as Y } from "vue";
import { ElDatePicker as R } from "element-plus";
import { ElBadge as j } from "element-plus";
import { ElInput as D } from "element-plus";
import { d as z, g as L } from "./import-dialog.vue.js";
import { B as M, gD as O, bN as P, iG as y, iH as $, C as H, b as I, L as K } from "../../../../shared/runtime.js";
import { l as F } from "../../../../modules/contract-9b18cc88.js";
import q from "./not-archived-list-drawer.vue.js";
const G = { style: { float: "right" } }, oe = { __name: "header", setup(W) {
  const _ = {}, b = { TRUE: { L: "已归档", K: "TRUE", V: 1 }, FALSE: { L: "未归档", K: "FALSE", V: 0 } }, C = N(() => {
    var t;
    const s = {};
    return (t = a.selections) == null || t.forEach((i) => {
      s[i.id] = i.projectIds;
    }), s;
  }), { crud: a, CRUD: E, query: l } = M(_), r = V(0), u = V(false);
  async function A() {
    const s = await L();
    r.value = s;
  }
  return E.HOOK.beforeToQuery = () => {
    A();
  }, (s, t) => {
    const i = R, U = d("common-radio-button"), w = d("common-button"), B = j, m = d("common-select"), x = D, S = Q("permission");
    return g(), T("div", null, [p(c("div", null, [n(i, { modelValue: e(l).year, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(l).year = o), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(U, { modelValue: e(l).isArchive, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(l).isArchive = o), options: b, showOptionAll: "", type: "enum", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(B, { style: { float: "right", "margin-right": "8px" }, class: "filter-item", value: r.value, max: 99, hidden: !r.value }, { default: f(() => [r.value ? p((g(), k(w, { key: 0, type: "danger", plain: "", onClick: t[2] || (t[2] = (o) => u.value = true) }, { default: f(() => t[9] || (t[9] = [h("合同归档提示")])), _: 1, __: [9] })), [[S, e(F).detail]]) : Y("", true)]), _: 1 }, 8, ["value", "hidden"])], 512), [[v, e(a).searchToggle]]), p(c("div", null, [n(m, { modelValue: e(l).projectAttribute, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(l).projectAttribute = o), options: e(O).ENUM, type: "enum", size: "small", clearable: "", class: "filter-item", placeholder: "经营方式", style: { width: "200px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(m, { modelValue: e(l).businessType, "onUpdate:modelValue": t[4] || (t[4] = (o) => e(l).businessType = o), options: e(P).ENUM, type: "enum", size: "small", clearable: "", placeholder: "订单类型", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(m, { type: "enum", size: "small", modelValue: e(l).structureStatus, "onUpdate:modelValue": t[5] || (t[5] = (o) => e(l).structureStatus = o), options: [e(y).WORKSHOP, e(y).FRAME, e(y).SPACE], class: "filter-item", placeholder: "结构类型", clearable: "", style: { width: "200px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n($, { modelValue: e(l).contractSignBodyId, "onUpdate:modelValue": t[6] || (t[6] = (o) => e(l).contractSignBodyId = o), class: "filter-item", placeholder: "合同签订主体", style: { width: "200px" }, clearable: "", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(x, { modelValue: e(l).name, "onUpdate:modelValue": t[7] || (t[7] = (o) => e(l).name = o), modelModifiers: { trim: true }, size: "small", placeholder: "输入合同编号或项目名称", style: { width: "200px" }, class: "filter-item", clearable: "", onBlur: e(a).toQuery }, null, 8, ["modelValue", "onBlur"]), n(e(H)), c("div", G, [n(K, { fn: e(z), params: C.value, class: "filter-item", disabled: e(I)(e(a).selections) }, { default: f(() => t[10] || (t[10] = [h(" 附件批量下载 ")])), _: 1, __: [10] }, 8, ["fn", "params", "disabled"])])], 512), [[v, e(a).searchToggle]]), n(e(q), { modelValue: u.value, "onUpdate:modelValue": t[8] || (t[8] = (o) => u.value = o), onSuccess: e(a).toQuery }, null, 8, ["modelValue", "onSuccess"])]);
  };
} };
export {
  oe as default
};
