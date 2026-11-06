import { ref as p } from "vue";
import { useRoute as R } from "vue-router";
import { computed as c } from "vue";
import { inject as T } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as x } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as y } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as M } from "vue";
import { withKeys as V } from "vue";
import { createCommentVNode as E } from "vue";
import { withCtx as N } from "vue";
import { withDirectives as U } from "vue";
import { ElDatePicker as Q } from "element-plus";
import { ElInput as P } from "element-plus";
import { jZ as b, B as D, bl as S, I as j, fv as K, y3 as w, C as z, E as B } from "../../../../../../shared/runtime.js";
import { _ as C } from "../../../../../../modules/workshop-select-210dd661.js";
const O = { class: "head-container" }, $ = { key: 0 }, Z = { __name: "header", setup(q) {
  const g = p([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), n = R(), I = c(() => n.meta.boolPartyA === b.PARTY_A.V), k = { startAndEndTime: [], basicClass: void 0, projectId: void 0, sourceWorkshopIds: [], sourceWarehouseIds: void 0, directionWorkshopIds: [], directionWarehouseIds: void 0, serialNumber: void 0, operatorName: void 0, boolPartyA: I.value }, _ = T("permission"), { crud: a, query: l } = D(k), i = p(), d = c(() => {
    var o;
    const u = a.selections.map((r) => r.id);
    return ((o = i.value) == null ? void 0 : o.templateId) === "wmsRmMoveMaterialDetails" ? { idsStr: u.join(",") } : a.selections.map((r) => r.id);
  });
  return (u, o) => {
    const r = h("common-radio-button"), v = Q, m = P, W = h("print-table"), A = x("permission");
    return f(), y("div", O, [e(a).searchToggle ? (f(), y("div", $, [s(r, { modelValue: e(l).basicClass, "onUpdate:modelValue": o[0] || (o[0] = (t) => e(l).basicClass = t), options: e(S).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(v, { modelValue: e(l).startAndEndTime, "onUpdate:modelValue": o[1] || (o[1] = (t) => e(l).startAndEndTime = t), "default-time": g.value, shortcuts: e(j), class: "filter-item", "end-placeholder": "申请结束日期", "range-separator": ":", size: "default", "start-placeholder": "申请开始日期", style: { width: "270px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(a).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o[9] || (o[9] = M("br", null, null, -1)), s(e(K), { modelValue: e(l).projectIds, "onUpdate:modelValue": o[2] || (o[2] = (t) => e(l).projectIds = t), class: "filter-item", clearable: "", multiple: "", placeholder: "关联项目", style: { width: "300px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), s(C, { modelValue: e(l).sourceWorkshopIds, "onUpdate:modelValue": o[3] || (o[3] = (t) => e(l).sourceWorkshopIds = t), class: "filter-item", clearable: "", multiple: "", placeholder: "原仓库", style: { width: "240px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), s(w, { modelValue: e(l).sourceWarehouseIds, "onUpdate:modelValue": o[4] || (o[4] = (t) => e(l).sourceWarehouseIds = t), "workshop-id": e(l).sourceWorkshopIds, class: "filter-item", clearable: "", multiple: "", placeholder: "原存储位置", showAll: "", style: { width: "240px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "workshop-id", "onChange"]), s(C, { modelValue: e(l).directionWorkshopIds, "onUpdate:modelValue": o[5] || (o[5] = (t) => e(l).directionWorkshopIds = t), class: "filter-item", clearable: "", multiple: "", placeholder: "目标仓库", style: { width: "240px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), s(w, { modelValue: e(l).directionWarehouseIds, "onUpdate:modelValue": o[6] || (o[6] = (t) => e(l).directionWarehouseIds = t), "workshop-id": e(l).directionWorkshopIds, class: "filter-item", clearable: "", multiple: "", placeholder: "目标存储位置", showAll: "", style: { width: "240px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "workshop-id", "onChange"]), s(m, { modelValue: e(l).serialNumber, "onUpdate:modelValue": o[7] || (o[7] = (t) => e(l).serialNumber = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按移库单号搜索", size: "default", style: { width: "200px" }, onKeyup: V(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(m, { modelValue: e(l).operatorName, "onUpdate:modelValue": o[8] || (o[8] = (t) => e(l).operatorName = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/审核人", size: "default", style: { width: "200px" }, onKeyup: V(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(z))])) : E("", true), s(e(B), null, { optLeft: N(() => {
      var t;
      return [U(s(W, { ref_key: "printTableRef", ref: i, "api-key": ((t = e(n).meta) == null ? void 0 : t.boolPartyA) !== e(b).PARTY_A.V ? ["wmsRmMoveMaterialReceipt", "wmsRmMoveMaterialDetails"] : ["wmsRmMoveMaterialReceipt"], disabled: d.value.length === 0, params: d.value, class: "filter-item", size: "default", type: "warning", onSuccess: e(a).selectAllChange }, null, 8, ["api-key", "disabled", "params", "onSuccess"]), [[A, e(_).get]])];
    }), _: 1 })]);
  };
} };
export {
  Z as default
};
