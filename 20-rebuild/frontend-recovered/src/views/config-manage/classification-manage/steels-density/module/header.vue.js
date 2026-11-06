import { openBlock as m } from "vue";
import { createElementBlock as f } from "vue";
import { withDirectives as y } from "vue";
import { vShow as _ } from "vue";
import { unref as e } from "vue";
import { createElementVNode as t } from "vue";
import { createVNode as s } from "vue";
import { withKeys as i } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as n } from "vue";
import { ElInput as V } from "element-plus";
import { ElTooltip as b } from "element-plus";
import { _ as v, B as g, cP as h, ap as B, C as w, E as x } from "../../../../../shared/runtime.js";
const E = { class: "head-container" }, C = { __name: "header", setup(I) {
  const p = { classifyId: void 0, createBy: void 0, updateBy: void 0 }, { crud: r, query: a } = g(p);
  return (K, l) => {
    const u = V, c = b;
    return m(), f("div", E, [y(t("div", null, [s(B, { modelValue: e(a).classifyId, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(a).classifyId = o), "basic-class": e(h).STEEL_PLATE.V, "check-strictly": "", class: "filter-item", clearable: "", multiple: "", placeholder: "可选择/输入科目、编号搜索", separator: " > ", "show-all-levels": "", size: "small", style: { width: "300px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "basic-class", "onChange"]), s(u, { modelValue: e(a).createBy, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(a).createBy = o), class: "filter-item", clearable: "", placeholder: "可输入创建人搜索", size: "small", style: { width: "200px" }, onKeyup: i(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(u, { modelValue: e(a).updateBy, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(a).updateBy = o), class: "filter-item", clearable: "", placeholder: "可输入编辑人搜索", size: "small", style: { width: "200px" }, onKeyup: i(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(w))], 512), [[_, e(r).searchToggle]]), s(e(x), null, { optRight: d(() => l[3] || (l[3] = [t("span", { style: { color: "#e5a355" } }, "* 默认钢板密度为7.85；不锈钢密度为7.93", -1)])), viewLeft: d(() => [s(c, { effect: "light", placement: "bottom", trigger: "click" }, { content: d(() => l[4] || (l[4] = [n(" 1、可选择任意层级科目设置密度："), t("br", null, null, -1), n(" ①父级和子级同时设置密度，优先原则为：子级 > 父级"), t("br", null, null, -1), n(" ②仅父级设置密度：对应子级科目自动沿用父级的密度进行计算。"), t("br", null, null, -1), n(" ③仅末级设置密度：只对自身生效，不影响其他科目。"), t("br", null, null, -1), n(" 2、密度设置完成即对相关涉及到密度计算的新创建的业务场景生效。 ")])), default: d(() => [l[5] || (l[5] = t("div", { class: "function-description" }, null, -1))]), _: 1, __: [5] })]), _: 1 })]);
  };
} }, Q = v(C, [["__scopeId", "data-v-773ffd18"]]);
export {
  Q as default
};
