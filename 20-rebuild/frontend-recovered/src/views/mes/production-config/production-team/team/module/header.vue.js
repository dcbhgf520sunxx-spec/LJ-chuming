import { resolveComponent as s } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as E } from "vue";
import { vShow as h } from "vue";
import { unref as e } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as l } from "vue";
import { withKeys as T } from "vue";
import { Fragment as b } from "vue";
import { ElInput as U } from "element-plus";
import { ElCheckbox as k } from "element-plus";
import { m as w, aS as m, aY as r, B as _, a3 as Q, p6 as N, C as x, E as S } from "../../../../../../shared/runtime.js";
import { _ as v } from "../../../../../../modules/process-select-b35dffc0.js";
import { _ as A } from "../../../../../../modules/mes-bridge-enum-radio-5a510e87.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
const q = { __name: "header", props: { workshopList: Array }, setup(d) {
  const { user: p } = w(["user"]), i = { processId: void 0, leaderName: void 0, teamStatus: m.TRUE.V, organizationType: r.IN_STAFF.V, taskTypeEnum: void 0, mesProductEnum: p.value.mesProductEnum[0] }, { crud: a, query: o } = _(i);
  return (I, n) => {
    const y = s("common-select"), c = U, V = k, u = s("common-radio-button");
    return f(), g(b, null, [E(C("div", null, [l(e(A), { modelValue: e(o).mesProductEnum, "onUpdate:modelValue": n[0] || (n[0] = (t) => e(o).mesProductEnum = t), onChange: e(a).toQuery, ref: "mesBridgeEnumRadioRef" }, null, 8, ["modelValue", "onChange"]), l(y, { modelValue: e(o).workshopId, "onUpdate:modelValue": n[1] || (n[1] = (t) => e(o).workshopId = t), options: d.workshopList, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "车间筛选", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(e(v), { class: "filter-item", multiple: false, clearable: "", modelValue: e(o).processId, "onUpdate:modelValue": n[2] || (n[2] = (t) => e(o).processId = t), productionLineTypeEnum: e(a).query.productionLineTypeEnum, style: { width: "200px" }, onChange: e(a).toQuery, placeholder: "工序筛选", disabledProductType: [e(Q).ENCLOSURE.V] }, null, 8, ["modelValue", "productionLineTypeEnum", "onChange", "disabledProductType"]), l(c, { modelValue: e(o).teamUserName, "onUpdate:modelValue": n[3] || (n[3] = (t) => e(o).teamUserName = t), placeholder: "输入组长、组员姓名搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: T(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(V, { modelValue: e(o).boolAccurateQuery, "onUpdate:modelValue": n[4] || (n[4] = (t) => e(o).boolAccurateQuery = t), label: "精确査询", onChange: e(a).toQuery, style: { "margin-right": "10px" } }, null, 8, ["modelValue", "onChange"]), l(u, { modelValue: e(o).taskTypeEnum, "onUpdate:modelValue": n[5] || (n[5] = (t) => e(o).taskTypeEnum = t), options: e(N).ENUM, showOptionAll: "", type: "enum", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(u, { modelValue: e(o).organizationType, "onUpdate:modelValue": n[6] || (n[6] = (t) => e(o).organizationType = t), options: e(r).ENUM, type: "enum", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(u, { modelValue: e(o).teamStatus, "onUpdate:modelValue": n[7] || (n[7] = (t) => e(o).teamStatus = t), options: e(m).ENUM, type: "enum", showOptionAll: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(e(x))], 512), [[h, e(a).searchToggle]]), l(e(S))], 64);
  };
} };
export {
  q as default
};
