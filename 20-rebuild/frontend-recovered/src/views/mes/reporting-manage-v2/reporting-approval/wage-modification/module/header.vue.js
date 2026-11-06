import { ref as f } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { withKeys as u } from "vue";
import { withCtx as x } from "vue";
import { normalizeClass as h } from "vue";
import { toDisplayString as B } from "vue";
import { ElInput as w } from "element-plus";
import { ElBadge as E } from "element-plus";
import { _ as Q, p as k, p6 as c, B as K, q as S, C as U } from "../../../../../../shared/runtime.js";
import { _ as R } from "../../../../../../modules/project-select-94bb5bbd.js";
const T = { class: "flx-btw" }, M = { class: "content" }, $ = { __name: "header", props: { addQuantity: { type: [Number, String], default: 0 }, totalBadge: { type: [Number, String], default: 0 } }, emits: ["toCollect"], setup(m, { emit: y }) {
  const V = y, b = f(), p = f(), g = { year: k(/* @__PURE__ */ new Date(), "{y}"), processId: void 0, typeEnum: c.ARTIFACT.V, monomerName: void 0, specification: void 0, serialNumber: void 0, material: void 0, projectId: void 0, monomerId: void 0 };
  function _(n) {
    const { serialNumber: e, shortName: d } = n;
    o.projectSerialNumber = e || void 0, o.projectName = d || void 0;
  }
  function C(n) {
    var e, d;
    n && (o.monomerName = (d = (e = p.value) == null ? void 0 : e.getOption(n)) == null ? void 0 : d.name), i.toQuery();
  }
  const { crud: i, query: o } = K(g);
  return (n, e) => {
    const d = j("common-radio-button"), s = w, N = E;
    return v(), I("div", null, [r("div", null, [a(t(R), { ref_key: "projectSelectRef", ref: b, modelValue: t(o).projectId, "onUpdate:modelValue": e[0] || (e[0] = (l) => t(o).projectId = l), class: "filter-item", style: { width: "300px" }, "default-id": n.projectId, clearable: "", placeholder: "选择项目", onProjectChange: _ }, null, 8, ["modelValue", "default-id"]), a(t(S), { ref_key: "monomerRef", ref: p, modelValue: t(o).monomerId, "onUpdate:modelValue": e[1] || (e[1] = (l) => t(o).monomerId = l), clearable: "", class: "filter-item", "project-id": t(o).projectId, placeholder: "选择单体", default: false, onChange: C }, null, 8, ["modelValue", "project-id"]), a(d, { modelValue: t(o).typeEnum, "onUpdate:modelValue": e[2] || (e[2] = (l) => t(o).typeEnum = l), options: t(c).ENUM, type: "enum", class: "filter-item", onChange: t(i).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), r("div", T, [r("div", null, [a(s, { modelValue: t(o).serialNumber, "onUpdate:modelValue": e[3] || (e[3] = (l) => t(o).serialNumber = l), modelModifiers: { trim: true }, clearable: "", placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, onKeyup: u(t(i).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(s, { modelValue: t(o).specification, "onUpdate:modelValue": e[4] || (e[4] = (l) => t(o).specification = l), modelModifiers: { trim: true }, clearable: "", placeholder: "规格搜索", class: "filter-item", style: { width: "200px" }, onKeyup: u(t(i).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(s, { modelValue: t(o).material, "onUpdate:modelValue": e[5] || (e[5] = (l) => t(o).material = l), modelModifiers: { trim: true }, clearable: "", placeholder: "材质搜索", class: "filter-item", style: { width: "200px" }, onKeyup: u(t(i).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(t(U))]), a(N, { value: m.totalBadge, max: 99, hidden: m.totalBadge < 1 }, { default: x(() => [r("div", { class: h([m.totalBadge ? "" : "disabled", "sink-total"]), onClick: e[6] || (e[6] = (l) => V("toCollect")) }, [e[7] || (e[7] = r("span", { class: "label" }, "汇总", -1)), r("span", M, B(m.addQuantity) + " 件", 1)], 2)]), _: 1 }, 8, ["value", "hidden"])])]);
  };
} }, H = Q($, [["__scopeId", "data-v-1a2fa304"]]);
export {
  H as default
};
