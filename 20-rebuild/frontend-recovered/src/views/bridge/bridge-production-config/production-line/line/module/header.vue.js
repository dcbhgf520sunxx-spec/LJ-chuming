import { resolveComponent as r } from "vue";
import { withDirectives as d } from "vue";
import { vShow as s } from "vue";
import { unref as e } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as V } from "vue";
import { withKeys as b } from "vue";
import { ElInput as h } from "element-plus";
import { aS as u, B as _, aV as g, aD as E, C as w, E as C } from "../../../../../../shared/runtime.js";
import { _ as U } from "../../../../../../modules/factory-select-b8d0a4ac.js";
const k = { __name: "header", setup(v) {
  const m = { factoryId: void 0, name: void 0, boolEnabledEnum: u.TRUE.V, productType: void 0 }, { crud: n, query: o } = _(m);
  return (I, l) => {
    const i = r("common-radio-button"), p = r("common-select"), c = h;
    return d((f(), y("div", null, [t(i, { modelValue: e(o).boolEnabledEnum, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(o).boolEnabledEnum = a), options: e(u).ENUM, type: "enum", showOptionAll: "", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(U, { modelValue: e(o).factoryId, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(o).factoryId = a), placeholder: "选择工厂搜索", class: "filter-item", style: { width: "200px" }, clearable: "", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), t(e(g), { modelValue: e(o).workshopId, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(o).workshopId = a), "factory-id": e(o).factoryId, placeholder: "选择车间搜索", class: "filter-item", style: { width: "200px" }, clearable: "", onChange: e(n).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"]), t(p, { dataStructure: { key: "K", label: "L", value: "V" }, modelValue: e(o).productType, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(o).productType = a), options: e(E).ENUM, placeholder: "请选择产品类型", style: { width: "190px" }, class: "filter-item", clearable: "", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), d(V("div", null, [t(c, { modelValue: e(o).name, "onUpdate:modelValue": l[4] || (l[4] = (a) => e(o).name = a), modelModifiers: { trim: true }, placeholder: "输入生产线名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: b(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e(w)), t(e(C))], 512), [[s, e(n).searchToggle]])], 512)), [[s, e(n).searchToggle]]);
  };
} };
export {
  k as default
};
