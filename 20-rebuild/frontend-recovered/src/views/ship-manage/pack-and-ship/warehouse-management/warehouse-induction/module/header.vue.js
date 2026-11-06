import { resolveComponent as p } from "vue";
import { openBlock as j } from "vue";
import { createElementBlock as C } from "vue";
import { withDirectives as v } from "vue";
import { vShow as w } from "vue";
import { unref as e } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as a } from "vue";
import { withCtx as r } from "vue";
import { withKeys as s } from "vue";
import { createTextVNode as c } from "vue";
import { Fragment as K } from "vue";
import { ElInput as N } from "element-plus";
import { ElBadge as _ } from "element-plus";
import { B as Q, bZ as U, C as z, E as B } from "../../../../../../shared/runtime.js";
const k = { __name: "header", props: { operationNumber: { type: Number, default: 0 } }, emits: ["add", "operation"], setup(i, { emit: y }) {
  const f = {}, m = y, { crud: n, query: o } = Q(f);
  function b() {
    m("add");
  }
  function V() {
    m("operation");
  }
  return (D, t) => {
    const I = p("project-radio-button"), d = N, u = p("common-button"), g = _;
    return j(), C(K, null, [v(x("div", null, [a(I, { modelValue: e(o).projectId, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(o).projectId = l), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), a(e(U), { monomerId: e(o).monomerId, "onUpdate:monomerId": t[1] || (t[1] = (l) => e(o).monomerId = l), areaId: e(o).areaId, "onUpdate:areaId": t[2] || (t[2] = (l) => e(o).areaId = l), productType: e(o).productType, needConvert: "", clearable: "", "project-id": e(o).projectId, monomerDisabled: !e(o).projectId, areaDisabled: !e(o).projectId, onChange: e(n).toQuery }, null, 8, ["monomerId", "areaId", "productType", "project-id", "monomerDisabled", "areaDisabled", "onChange"])], 512), [[w, e(n).searchToggle]]), a(e(B), null, { optLeft: r(() => [a(d, { modelValue: e(o).name, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(o).name = l), size: "small", placeholder: "输入名称搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: s(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(d, { modelValue: e(o).serialNumber, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(o).serialNumber = l), size: "small", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: s(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(d, { modelValue: e(o).specification, "onUpdate:modelValue": t[5] || (t[5] = (l) => e(o).specification = l), size: "small", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: s(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(d, { modelValue: e(o).material, "onUpdate:modelValue": t[6] || (t[6] = (l) => e(o).material = l), size: "small", placeholder: "输入材质搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: s(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(z))]), viewLeft: r(() => [a(u, { class: "filter-item", type: "primary", onClick: b, disabled: !e(n).selections.length }, { default: r(() => t[7] || (t[7] = [c(" 添加 ")])), _: 1, __: [7] }, 8, ["disabled"]), a(g, { value: i.operationNumber, hidden: !i.operationNumber, style: { "z-index": "1" } }, { default: r(() => [a(u, { class: "filter-item", type: "success", onClick: V }, { default: r(() => t[8] || (t[8] = [c(" 汇总 ")])), _: 1, __: [8] })]), _: 1 }, 8, ["value", "hidden"])]), _: 1 })], 64);
  };
} };
export {
  k as default
};
