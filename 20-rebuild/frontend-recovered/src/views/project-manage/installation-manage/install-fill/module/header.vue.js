import { watch as j } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as v } from "vue";
import { withDirectives as h } from "vue";
import { vShow as g } from "vue";
import { unref as e } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as n } from "vue";
import { withKeys as i } from "vue";
import { renderSlot as E } from "vue";
import { ElInput as _ } from "element-plus";
import { m as A, K as p, tQ as w, F as c, B, C } from "../../../../../shared/runtime.js";
import { _ as Q } from "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
const K = { class: "head-container" }, M = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, setup(s) {
  const { deliveryInstallEnumArr: y } = A("deliveryInstallEnumArr"), d = s, f = { projectId: { value: void 0, resetAble: false }, productType: d.globalProject.projectType === p.STEEL.V ? w.ARTIFACT.V : c.BOX.V, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, name: void 0, serialNumber: void 0 }, { crud: r, query: t } = B(f);
  j(() => d.projectId, (l) => {
    l && (r.query.projectId = d.projectId, r.toQuery());
  }, { immediate: true, deep: true });
  function b({ monomerId: l, areaId: o }) {
    t.monomerId = l, t.areaId = o, r.toQuery();
  }
  return (l, o) => {
    const T = I("common-radio-button"), u = _;
    return V(), v("div", K, [h(m("div", null, [n(T, { modelValue: e(t).productType, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).productType = a), options: s.globalProject.projectType === e(p).STEEL.V ? e(y) : [e(c).BOX], type: "enum", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), m("div", null, [n(e(Q), { "project-id": e(t).projectId, class: "filter-item", mainProductType: e(t).productType, default: "", style: { width: "100%" }, onChange: b }, null, 8, ["project-id", "mainProductType"]), n(u, { modelValue: e(t).serialNumber, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).serialNumber = a), modelModifiers: { trim: true }, placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: i(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(u, { modelValue: e(t).name, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).name = a), modelModifiers: { trim: true }, placeholder: "名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: i(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(C)), E(l.$slots, "summaryBtn")])], 512), [[g, e(r).searchToggle]])]);
  };
} };
export {
  M as default
};
