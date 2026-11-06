import { resolveComponent as u } from "vue";
import { withDirectives as f } from "vue";
import { vShow as h } from "vue";
import { unref as e } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as a } from "vue";
import { withKeys as b } from "vue";
import { ElInput as g } from "element-plus";
import { m as _, aS as m, B as w, a3 as s, C } from "../../../../../../shared/runtime.js";
import { _ as U } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import { _ as I } from "../../../../../../modules/mes-bridge-enum-radio-5a510e87.js";
const k = { style: { display: "flex", "align-items": "center" } }, K = { __name: "header", props: { workshopList: Array }, setup(d) {
  const { user: i } = _(["user"]), p = { factoryId: void 0, name: void 0, boolEnabledEnum: m.TRUE.V, productType: void 0, mesProductEnum: i.value.mesProductEnum[0] }, { crud: t, query: o } = w(p);
  return (v, l) => {
    const c = u("common-radio-button"), r = u("common-select"), y = g;
    return f((E(), V("div", k, [a(e(I), { modelValue: e(o).mesProductEnum, "onUpdate:modelValue": l[0] || (l[0] = (n) => e(o).mesProductEnum = n), onChange: e(t).toQuery, ref: "mesBridgeEnumRadioRef" }, null, 8, ["modelValue", "onChange"]), a(c, { modelValue: e(o).boolEnabledEnum, "onUpdate:modelValue": l[1] || (l[1] = (n) => e(o).boolEnabledEnum = n), options: e(m).ENUM, type: "enum", showOptionAll: "", class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(U, { modelValue: e(o).factoryId, "onUpdate:modelValue": l[2] || (l[2] = (n) => e(o).factoryId = n), placeholder: "选择工厂搜索", class: "filter-item", style: { width: "200px" }, clearable: "", onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), a(r, { modelValue: e(o).workshopId, "onUpdate:modelValue": l[3] || (l[3] = (n) => e(o).workshopId = n), options: d.workshopList, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "选择车间搜索", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(r, { dataStructure: { key: "K", label: "L", value: "V" }, modelValue: e(o).productType, "onUpdate:modelValue": l[4] || (l[4] = (n) => e(o).productType = n), options: e(s).ENUM, unshowOptions: [e(s).AUXILIARY_MATERIAL.K, e(s).ENCLOSURE.K], placeholder: "请选择产品类型", style: { width: "190px" }, class: "filter-item", clearable: "", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "unshowOptions", "onChange"]), a(y, { modelValue: e(o).name, "onUpdate:modelValue": l[5] || (l[5] = (n) => e(o).name = n), modelModifiers: { trim: true }, placeholder: "输入生产线名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: b(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(C))], 512)), [[h, e(t).searchToggle]]);
  };
} };
export {
  K as default
};
