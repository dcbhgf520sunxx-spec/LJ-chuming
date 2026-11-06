import { resolveComponent as d } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as N } from "vue";
import { withDirectives as c } from "vue";
import { vShow as y } from "vue";
import { unref as e } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as l } from "vue";
import { withKeys as I } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as T } from "vue";
import { withModifiers as b } from "vue";
import { ElInput as _ } from "element-plus";
import { a3 as V, B as Q, cm as k, aV as v, bZ as U, E as x } from "../../../../../shared/runtime.js";
const S = { class: "head-container" }, R = { __name: "header", props: { orderIds: { type: Array, default: () => [] } }, setup(C) {
  const u = C, a = { ARTIFACT: V.ARTIFACT, ASSEMBLE: V.ASSEMBLE }, g = { productType: a.ARTIFACT.V, serialNumber: void 0 }, { crud: t, query: o } = Q(g);
  function h() {
    t.toQuery();
  }
  function w() {
    o.printType = void 0, o.productType = a.ARTIFACT.V, o.workshopId = void 0, o.orderNumber = void 0, o.serialNumber = void 0, o.monomerIds = void 0, o.areaIds = void 0, o.serialNumber = void 0, t.toQuery();
  }
  return (B, n) => {
    const i = d("common-radio-button"), p = _, m = d("common-button"), A = d("print-table");
    return E(), N("div", S, [c(f("div", null, [l(i, { modelValue: e(o).printType, "onUpdate:modelValue": n[0] || (n[0] = (r) => e(o).printType = r), options: e(k).ENUM, type: "enum", "show-option-all": "", class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(i, { modelValue: e(o).productType, "onUpdate:modelValue": n[1] || (n[1] = (r) => e(o).productType = r), options: a, "show-option-all": "", type: "enum", class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"])], 512), [[y, e(t).searchToggle]]), c(f("div", null, [l(e(v), { modelValue: e(o).workshopId, "onUpdate:modelValue": n[2] || (n[2] = (r) => e(o).workshopId = r), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), l(e(U), { monomerId: e(o).monomerIds, "onUpdate:monomerId": n[3] || (n[3] = (r) => e(o).monomerIds = r), areaId: e(o).areaIds, "onUpdate:areaId": n[4] || (n[4] = (r) => e(o).areaIds = r), needConvert: "", clearable: "", "project-id": e(o).projectIds[0], onChange: e(t).toQuery }, null, 8, ["monomerId", "areaId", "project-id", "onChange"]), l(p, { modelValue: e(o).orderNumber, "onUpdate:modelValue": n[5] || (n[5] = (r) => e(o).orderNumber = r), placeholder: "输入任务单号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: I(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(p, { modelValue: e(o).serialNumber, "onUpdate:modelValue": n[6] || (n[6] = (r) => e(o).serialNumber = r), modelModifiers: { trim: true }, placeholder: "输入编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: I(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(m, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: b(h, ["stop"]) }, { default: s(() => n[7] || (n[7] = [T("搜索")])), _: 1, __: [7] }), l(m, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: b(w, ["stop"]) }, { default: s(() => n[8] || (n[8] = [T(" 重置 ")])), _: 1, __: [8] })], 512), [[y, e(t).searchToggle]]), l(e(x), null, { optRight: s(() => [l(A, { params: { orderIds: u.orderIds, productType: e(o).productType, productionLineTypeEnum: 1 }, "api-key": "mesProductionTaskOrders", disabled: u.orderIds.length === 0 }, null, 8, ["params", "disabled"])]), _: 1 })]);
  };
} };
export {
  R as default
};
