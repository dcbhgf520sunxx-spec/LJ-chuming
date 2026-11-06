import { ref as c } from "vue";
import { resolveComponent as r } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as C } from "vue";
import { vShow as _ } from "vue";
import { unref as l } from "vue";
import { createVNode as a } from "vue";
import { withCtx as f } from "vue";
import { createBlock as k } from "vue";
import { createTextVNode as M } from "vue";
import { Fragment as j } from "vue";
import { ElInput as I } from "element-plus";
import { s as z } from "../../../../../../modules/process-611d795f.js";
import { B, tt as Q, ts as R, C as D, E as O, t3 as W, t5 as H, t0 as q, t6 as V } from "../../../../../../shared/runtime.js";
import $ from "../../../../../supply-chain/components/audit-records.vue.js";
const X = { __name: "header", props: ["APPtotal", "subTotal", "rejTotal"], emits: ["structureClassChange"], setup(g, { emit: w }) {
  const T = { boolSingleProject: void 0, fileName: void 0, material: void 0, name: void 0, processType: void 0, serialNumber: void 0, specification: void 0, structureClassId: void 0 }, v = g, A = w, { crud: n, query: o } = B(T), d = c(false), s = c({}), p = c([]);
  N();
  async function N() {
    let u = [];
    try {
      const { content: e = [] } = await z();
      u = e;
    } catch (e) {
      console.log("系统构件类型", e);
    } finally {
      p.value = u, A("structureClassChange", p.value);
    }
  }
  function P(u) {
    const e = u;
    s.value.moduleType = H.PLAN_MANAGEMENT.V, s.value.componentNameList = [q.PLAN_PROCESS_DOCUMENT.V], e === 1 ? (s.value.reviewStatus = V.WITHDRAW.V, s.value.waitMeCheck = true, s.value.meLaunch = false) : e === 2 ? (s.value.reviewStatus = V.WITHDRAW.V, s.value.waitMeCheck = false, s.value.meLaunch = true) : e === 3 && (s.value.reviewStatus = V.REJECT.V, s.value.waitMeCheck = false, s.value.meLaunch = false), d.value = true;
  }
  return (u, e) => {
    const h = r("project-radio-button"), y = r("common-radio-button"), i = I, E = r("common-select"), x = r("common-button"), L = U("permission");
    return b(), S(j, null, [m("div", null, [C(m("div", null, [m("div", null, [a(h, { modelValue: l(o).projectId, "onUpdate:modelValue": e[0] || (e[0] = (t) => l(o).projectId = t), type: "all", class: "filter-item", size: "default", onChange: l(n).toQuery }, null, 8, ["modelValue", "onChange"]), a(y, { modelValue: l(o).boolSingleProject, "onUpdate:modelValue": e[1] || (e[1] = (t) => l(o).boolSingleProject = t), options: l(Q).ENUM, class: "filter-item", "show-option-all": "", style: { "margin-bottom": "10px" }, type: "enum", onChange: l(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(y, { modelValue: l(o).processType, "onUpdate:modelValue": e[2] || (e[2] = (t) => l(o).processType = t), options: l(R).ENUM, class: "filter-item", "show-option-all": "", style: { "margin-bottom": "10px" }, type: "enum", onChange: l(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(i, { modelValue: l(o).fileName, "onUpdate:modelValue": e[3] || (e[3] = (t) => l(o).fileName = t), class: "filter-item", clearable: "", placeholder: "文件名搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"])]), m("div", null, [a(E, { modelValue: l(o).structureClassId, "onUpdate:modelValue": e[4] || (e[4] = (t) => l(o).structureClassId = t), "data-structure": { key: "id", label: "name", value: "id" }, options: p.value, class: "filter-item", clearable: "", placeholder: "构件类型", style: { width: "200px" }, type: "other", onChange: l(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(i, { modelValue: l(o).name, "onUpdate:modelValue": e[5] || (e[5] = (t) => l(o).name = t), class: "filter-item", clearable: "", placeholder: "构件名称搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), a(i, { modelValue: l(o).serialNumber, "onUpdate:modelValue": e[6] || (e[6] = (t) => l(o).serialNumber = t), class: "filter-item", clearable: "", placeholder: "构件编号", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), a(i, { modelValue: l(o).specification, "onUpdate:modelValue": e[7] || (e[7] = (t) => l(o).specification = t), class: "filter-item", clearable: "", placeholder: "构件规格", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), a(i, { modelValue: l(o).material, "onUpdate:modelValue": e[8] || (e[8] = (t) => l(o).material = t), class: "filter-item", clearable: "", placeholder: "构件材质", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), a(l(D))])], 512), [[_, l(n).searchToggle]]), a(l(O), { permission: l(n).permission }, { optLeft: f(() => [C((b(), k(x, { class: "filter-item", size: "default", type: "primary", onClick: l(n).toAdd }, { default: f(() => e[11] || (e[11] = [M(" 上传工艺文件 ")])), _: 1, __: [11] }, 8, ["onClick"])), [[L, l(n).permission.add]])]), viewLeft: f(() => [a($, { "module-type": l(H).PLAN_MANAGEMENT.V, "component-name-list": l(q).PLAN_PROCESS_DOCUMENT.V, APPtotal: v.APPtotal, rejTotal: v.rejTotal, subTotal: v.subTotal, style: { "margin-left": "10px", "padding-right": "10px" }, onHandleSuccess: () => l(n).toQuery() }, null, 8, ["module-type", "component-name-list", "APPtotal", "rejTotal", "subTotal"])]), _: 1 }, 8, ["permission"])]), a(W, { modelValue: d.value, "onUpdate:modelValue": e[9] || (e[9] = (t) => d.value = t), form: s.value, onSuccess: e[10] || (e[10] = (t) => l(n).toQuery()) }, null, 8, ["modelValue", "form"])], 64);
  };
} };
export {
  X as default
};
