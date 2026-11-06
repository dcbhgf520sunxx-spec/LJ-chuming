import { inject as B } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as c } from "vue";
import { withDirectives as m } from "vue";
import { unref as e } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as k } from "vue";
import { ElRadioGroup as Q } from "element-plus";
import { createTextVNode as v } from "vue";
import { Fragment as g } from "vue";
import { renderList as T } from "vue";
import { toDisplayString as j } from "vue";
import { createCommentVNode as I } from "vue";
import { vShow as L } from "vue";
import { ElCol as R } from "element-plus";
import { ElRow as S } from "element-plus";
import { ElDatePicker as U } from "element-plus";
import { ElRadioButton as q } from "element-plus";
import { ElInput as z } from "element-plus";
import { vLoading as O } from "element-plus";
import { _ as P, p as H, B as M, c1 as V, C as F, E as G } from "../../../../shared/runtime.js";
import { P as i } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const $ = { __name: "header", setup(A) {
  const r = B("projectInfo"), b = { noOrName: void 0, year: H(/* @__PURE__ */ new Date(), "{y}") }, { crud: o, query: s } = M(b);
  function w(p) {
    return p > /* @__PURE__ */ new Date();
  }
  return (p, n) => {
    const d = R, E = S, h = U, _ = q, C = z, D = N("print-table"), x = O, f = Y("permission");
    return u(), c("div", null, [m((u(), y(E, { gutter: 20, class: "panel-group" }, { default: l(() => [a(d, { span: 6, class: "card-panel-col" }, { default: l(() => [a(e(i), { name: "全部项目", "num-color": "#1890ff", "end-val": e(r).summary.quantity || 0 }, null, 8, ["end-val"])]), _: 1 }), a(d, { span: 6, class: "card-panel-col" }, { default: l(() => [a(e(i), { name: "进行中", "num-color": "#1890ff", "end-val": e(r).summary.processingQuantity || 0 }, null, 8, ["end-val"])]), _: 1 }), a(d, { span: 6, class: "card-panel-col" }, { default: l(() => [a(e(i), { name: "完工", "num-color": "#1890ff", "end-val": e(r).summary.completedQuantity || 0 }, null, 8, ["end-val"])]), _: 1 }), a(d, { span: 6, class: "card-panel-col" }, { default: l(() => [a(e(i), { name: "本月新增", "num-color": "#1890ff", "end-val": e(r).summary.newItemsThisMonthQuantity || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[x, e(r).loading], [f, e(o).permission.statistics]]), a(e(G), null, { optRight: l(() => [m(k("div", null, [a(h, { modelValue: e(s).year, "onUpdate:modelValue": n[0] || (n[0] = (t) => e(s).year = t), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", "value-format": "YYYY", class: "filter-item", format: "YYYY", "disabled-date": w, onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), a(e(Q), { modelValue: e(s).status, "onUpdate:modelValue": n[1] || (n[1] = (t) => e(s).status = t), size: "default", class: "filter-item", onChange: e(o).toQuery }, { default: l(() => [a(_, { label: void 0 }, { default: l(() => n[3] || (n[3] = [v("全部")])), _: 1, __: [3] }), (u(true), c(g, null, T(e(V).ENUM, (t) => (u(), c(g, null, [t.V != e(V).SETTLED.V ? (u(), y(_, { key: t.V, label: t.V }, { default: l(() => [v(j(t.L), 1)]), _: 2 }, 1032, ["label"])) : I("", true)], 64))), 256))]), _: 1 }, 8, ["modelValue", "onChange"]), a(C, { modelValue: e(s).noOrName, "onUpdate:modelValue": n[2] || (n[2] = (t) => e(s).noOrName = t), size: "default", placeholder: "输入合同编号或项目简称", style: { width: "200px" }, class: "filter-item", clearable: "", onBlur: e(o).toQuery }, null, 8, ["modelValue", "onBlur"]), a(e(F))], 512), [[L, e(o).searchToggle]])]), viewLeft: l(() => [m(a(D, { "api-key": "myProject", params: { year: e(o).query.year, status: e(o).query.status, noName: e(o).query.noOrName }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[f, e(o).permission.print]])]), _: 1 })]);
  };
} }, Z = P($, [["__scopeId", "data-v-d7a58617"]]);
export {
  Z as default
};
