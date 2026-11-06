import { ref as V } from "vue";
import { inject as z } from "vue";
import { onMounted as x } from "vue";
import { computed as E } from "vue";
import { watch as D } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as L } from "vue";
import { withDirectives as U } from "vue";
import { vShow as W } from "vue";
import { unref as e } from "vue";
import { createElementVNode as A } from "vue";
import { createVNode as o } from "vue";
import { createBlock as S } from "vue";
import { createCommentVNode as C } from "vue";
import { withKeys as c } from "vue";
import { withCtx as q } from "vue";
import { ElMessage as G } from "element-plus";
import { ElInput as H } from "element-plus";
import { B as X, m as F, G as N, K as h, i as T, bi as s, bQ as w, od as B, bw as k, C as Y, E as $, b as _ } from "../../../../../shared/runtime.js";
const J = { class: "head-container" }, ae = { __name: "header", setup(Z) {
  const r = V(), u = V(), i = V([]), O = { serialNumber: void 0, licensePlate: void 0, userName: void 0, actualUserName: void 0, projectId: { value: void 0, resetAble: false }, productType: { value: void 0, resetAble: false } }, { crud: n, query: a } = X(O), { globalProject: g } = F(["globalProject"]), d = z("permission");
  x(() => {
    N(d.print) && (n.query.projectType === h.BRIDGE.V ? i.value.push("mesBridgeShipmentAudit") : i.value.push("mesShipmentAudit")), N(d.detailPrint) && (n.query.projectType === h.BRIDGE.V ? i.value.push("mesBridgeShipmentAuditOverWeight") : i.value.push("mesShipmentAuditOverWeight"));
  });
  const y = E(() => {
    if (u.value === "mesShipmentAudit" || u.value === "mesBridgeShipmentAudit") return { ...a };
    if (u.value === "mesShipmentAuditOverWeight" && T(n.selections) || u.value === "mesBridgeShipmentAuditOverWeight" && T(n.selections)) return n.selections.map((f) => f.id);
  });
  function R() {
    if (u.value === "mesShipmentAuditOverWeight" && _(y.value) || u.value === "mesBridgeShipmentAuditOverWeight" && _(y.value)) return G.warning("至少选择一条需要打印的过磅信息"), false;
  }
  D(() => g.value, (f) => {
    var t;
    a.productType = void 0, r.value = void 0, r.value = (t = g.value) == null ? void 0 : t.productCategory;
  }, { immediate: true });
  const K = E(() => {
    switch (r.value) {
      case s.STRUCTURE.V:
        return [s.ENCLOSURE.V];
      case s.ENCLOSURE.V:
        return [s.STRUCTURE.V, s.MACHINE_PART.V];
      case s.STRUCTURE.V + s.ENCLOSURE.V:
        return [];
      default:
        return [];
    }
  });
  return (f, t) => {
    const j = m("project-radio-button"), I = m("common-radio-button"), b = m("component-radio-button"), p = H, P = m("print-table"), Q = M("permission");
    return v(), L("div", J, [U(A("div", null, [o(j, { size: "default", modelValue: e(a).projectId, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).projectId = l), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), o(I, { modelValue: e(a).checkStatus, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).checkStatus = l), options: e(w).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r.value !== e(B).BOX.V ? (v(), S(b, { key: 0, modelValue: e(a).productType, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(a).productType = l), options: e(s).ENUM, unshowVal: e(a).projectId ? K.value : [], showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"])) : C("", true), r.value === e(B).BOX.V ? (v(), S(b, { key: 1, modelValue: e(a).productType, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(a).productType = l), options: e(k).ENUM, disabledVal: [e(k).AUXILIARY_MATERIAL.V], showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "disabledVal", "onChange"])) : C("", true), A("div", null, [o(p, { modelValue: e(a).serialNumber, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(a).serialNumber = l), placeholder: "可输入车次/船次搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: c(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(p, { modelValue: e(a).licensePlate, "onUpdate:modelValue": t[5] || (t[5] = (l) => e(a).licensePlate = l), placeholder: "可输入车牌/船牌搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: c(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(p, { modelValue: e(a).userName, "onUpdate:modelValue": t[6] || (t[6] = (l) => e(a).userName = l), placeholder: "可输入装车人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: c(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(p, { modelValue: e(a).actualUserName, "onUpdate:modelValue": t[7] || (t[7] = (l) => e(a).actualUserName = l), placeholder: "可输入过磅人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: c(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(Y))])], 512), [[W, e(n).searchToggle]]), o(e($), null, { optLeft: q(() => [U(o(P, { "current-key": u.value, "onUpdate:currentKey": t[8] || (t[8] = (l) => u.value = l), "api-key": e(a).checkStatus === e(w).UNCHECKED.V ? i.value : e(n).query.projectType === e(h).BRIDGE.V ? "mesBridgeShipmentAudit" : "mesShipmentAudit", params: y.value, "before-print": R, size: "default", type: "warning", class: "filter-item" }, null, 8, ["current-key", "api-key", "params"]), [[Q, [...e(d).print, ...e(d).detailPrint]]])]), _: 1 })]);
  };
} };
export {
  ae as default
};
