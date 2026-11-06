import { ref as f } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as j } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { withKeys as u } from "vue";
import { withCtx as N } from "vue";
import { normalizeClass as B } from "vue";
import { toDisplayString as h } from "vue";
import { ElInput as w } from "element-plus";
import { ElBadge as E } from "element-plus";
import { _ as Q, p as k, p6 as c, B as K, fv as U, q as S, C as R } from "../../../../../../shared/runtime.js";
const T = { class: "flx-btw" }, M = { class: "content" }, $ = { __name: "header", props: { addQuantity: { type: [Number, String], default: 0 }, totalBadge: { type: [Number, String], default: 0 } }, emits: ["toCollect"], setup(s, { emit: y }) {
  const V = y, g = f(), p = f(), _ = { year: k(/* @__PURE__ */ new Date(), "{y}"), processId: void 0, typeEnum: c.ARTIFACT.V, monomerName: void 0, specification: void 0, serialNumber: void 0, material: void 0, projectId: void 0, monomerId: void 0 };
  function b(n, e) {
    console.log(n, e, "789456");
  }
  function C(n) {
    var e, i;
    n && (t.monomerName = (i = (e = p.value) == null ? void 0 : e.getOption(n)) == null ? void 0 : i.name), r.toQuery();
  }
  const { crud: r, query: t } = K(_);
  return (n, e) => {
    const i = I("common-radio-button"), m = w, v = E;
    return j(), x("div", null, [d("div", null, [a(o(U), { ref_key: "projectSelectRef", ref: g, modelValue: o(t).projectId, "onUpdate:modelValue": e[0] || (e[0] = (l) => o(t).projectId = l), class: "filter-item", style: { width: "300px" }, "default-id": n.projectId, clearable: "", placeholder: "选择项目", onChange: b }, null, 8, ["modelValue", "default-id"]), a(o(S), { ref_key: "monomerRef", ref: p, modelValue: o(t).monomerId, "onUpdate:modelValue": e[1] || (e[1] = (l) => o(t).monomerId = l), clearable: "", "project-id": o(t).projectId, placeholder: "选择单体", default: false, onChange: C }, null, 8, ["modelValue", "project-id"]), a(i, { modelValue: o(t).typeEnum, "onUpdate:modelValue": e[2] || (e[2] = (l) => o(t).typeEnum = l), options: o(c).ENUM, type: "enum", class: "filter-item", onChange: o(r).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), d("div", T, [d("div", null, [a(m, { modelValue: o(t).serialNumber, "onUpdate:modelValue": e[3] || (e[3] = (l) => o(t).serialNumber = l), modelModifiers: { trim: true }, clearable: "", placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, onKeyup: u(o(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(m, { modelValue: o(t).specification, "onUpdate:modelValue": e[4] || (e[4] = (l) => o(t).specification = l), modelModifiers: { trim: true }, clearable: "", placeholder: "规格搜索", class: "filter-item", style: { width: "200px" }, onKeyup: u(o(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(m, { modelValue: o(t).material, "onUpdate:modelValue": e[5] || (e[5] = (l) => o(t).material = l), modelModifiers: { trim: true }, clearable: "", placeholder: "材质搜索", class: "filter-item", style: { width: "200px" }, onKeyup: u(o(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(o(R))]), a(v, { value: s.totalBadge, max: 99, hidden: s.totalBadge < 1 }, { default: N(() => [d("div", { class: B([s.totalBadge ? "" : "disabled", "sink-total"]), onClick: e[6] || (e[6] = (l) => V("toCollect")) }, [e[7] || (e[7] = d("span", { class: "label" }, "汇总", -1)), d("span", M, h(s.addQuantity) + " 件", 1)], 2)]), _: 1 }, 8, ["value", "hidden"])])]);
  };
} }, D = Q($, [["__scopeId", "data-v-dc858450"]]);
export {
  D as default
};
