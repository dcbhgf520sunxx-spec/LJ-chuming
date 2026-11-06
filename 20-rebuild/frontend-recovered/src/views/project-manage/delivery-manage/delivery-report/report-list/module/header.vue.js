import { ref as j } from "vue";
import { watch as z } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as V } from "vue";
import { withDirectives as q } from "vue";
import { vShow as M } from "vue";
import { unref as e } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as r } from "vue";
import { createBlock as T } from "vue";
import { createCommentVNode as c } from "vue";
import { Fragment as R } from "vue";
import { withKeys as I } from "vue";
import N from "moment";
import { ElDatePicker as _ } from "element-plus";
import { ElInput as B } from "element-plus";
import { a as F } from "../../../../../../modules/area-ca564e60.js";
import { m as G, tR as p, K as k, kM as u, F as X, B as Y, tS as w, q as H, T as U, mw as $, C as J, G as W } from "../../../../../../shared/runtime.js";
import { s as Z } from "../../../../../../modules/index-8edb1b61.js";
const ee = { class: "head-container" }, te = { key: 0, style: { display: "inline-block" } }, oe = { style: { float: "right" } }, de = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, setup(g) {
  const { installTypeEnumArr: O } = G("installTypeEnumArr"), s = g, A = { projectId: { value: void 0, resetAble: false }, date: void 0, startDate: void 0, endDate: void 0, sourceType: p.SELF_SOURCE.V, category: void 0, productType: s.globalProject.projectType === k.STEEL.V ? u.ARTIFACT.V : X.BOX.V, monomerId: void 0, areaId: void 0, name: void 0, serialNumber: void 0, supplierName: void 0, areaType: void 0 }, { crud: l, query: t } = Y(A), b = { key: "id", label: "name", value: "id" }, i = j([]), m = j([]);
  z(() => s.projectId, (n) => {
    n && (l.query.projectId = s.projectId, m.value = [], l.query.productType === u.ENCLOSURE.V && v(), l.toQuery());
  }, { immediate: true, deep: true });
  function L() {
    t.date && t.date.length > 1 ? (t.startDate = N(t.date[0]).valueOf(), t.endDate = N(t.date[1]).valueOf()) : (t.startDate = void 0, t.endDate = void 0), l.toQuery();
  }
  function Q(n) {
    i.value = n || [];
  }
  function x(n) {
    t.areaId = void 0, n === u.ENCLOSURE.V && v(), l.toQuery();
  }
  function D(n) {
    var o;
    i.value = ((o = m.value) == null ? void 0 : o.filter((y) => y.category === n)) || [], l.toQuery();
  }
  async function v() {
    var n;
    if (l.query.monomerId = void 0, i.value = [], s.projectId) try {
      const o = await F(s.projectId) || [];
      m.value = o || [], l.query.category ? i.value = (n = m.value) == null ? void 0 : n.filter((y) => y.category === l.query.category) : i.value = m.value;
    } catch (o) {
      console.log("获取项目所有围护计划", o);
    }
  }
  function P() {
    t.productType = w.STRUCTURE.V, t.monomerId = void 0, t.areaId = void 0, t.supplierName = void 0, t.name = void 0, t.serialNumber = void 0, t.areaType = void 0, l.toQuery();
  }
  return (n, o) => {
    const y = _, S = C("common-radio-button"), f = C("common-select"), E = B, K = C("print-table");
    return d(), V("div", ee, [q(h("div", null, [r(y, { modelValue: e(t).date, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).date = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", style: { width: "240px" }, onChange: L }, null, 8, ["modelValue"]), r(S, { type: "enum", modelValue: e(t).sourceType, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).sourceType = a), options: e(p).ENUM, clearable: "", class: "filter-item", onChange: P }, null, 8, ["modelValue", "options"]), r(S, { modelValue: e(t).productType, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).productType = a), options: e(t).sourceType === e(p).OUT_SOURCE.V ? e(w).ENUM : e(O), type: "enum", class: "filter-item", onChange: x }, null, 8, ["modelValue", "options"]), e(t).sourceType === e(p).SELF_SOURCE.V ? (d(), V("div", te, [e(t).productType !== e(u).ENCLOSURE.V ? (d(), T(e(H), { key: 0, ref: "monomerSelectRef", modelValue: e(t).monomerId, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).monomerId = a), "project-id": e(t).projectId, "main-product-type": g.globalProject.projectType === e(k).STEEL.V && e(t).productType !== e(u).AUXILIARY.V ? e(t).productType : "", default: false, clearable: "", class: "filter-item", onChange: e(l).toQuery, onGetAreaInfo: Q }, null, 8, ["modelValue", "project-id", "main-product-type", "onChange"])) : c("", true), e(t).productType !== e(u).AUXILIARY.V && e(t).productType !== e(u).ENCLOSURE.V ? (d(), T(f, { key: 1, modelValue: e(t).areaId, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(t).areaId = a), options: i.value, type: "other", dataStructure: b, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : c("", true), e(t).productType === e(u).ENCLOSURE.V ? (d(), V(R, { key: 2 }, [r(f, { modelValue: e(t).category, "onUpdate:modelValue": o[5] || (o[5] = (a) => e(t).category = a), options: e(U).ENUM, "unshow-options": [e(U).STRUCTURE.K, e(U).BRIDGE.K], type: "enum", size: "default", clearable: "", placeholder: "请选择围护类型", class: "filter-item", style: { width: "200px" }, onChange: D }, null, 8, ["modelValue", "options", "unshow-options"]), r(f, { modelValue: e(t).areaId, "onUpdate:modelValue": o[6] || (o[6] = (a) => e(t).areaId = a), options: i.value, type: "other", dataStructure: b, size: "default", clearable: "", placeholder: "请选择批次", class: "filter-item", style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 64)) : c("", true)])) : c("", true), h("div", null, [e(t).sourceType === e(p).SELF_SOURCE.V ? (d(), V(R, { key: 0 }, [r(f, { modelValue: e(t).areaType, "onUpdate:modelValue": o[7] || (o[7] = (a) => e(t).areaType = a), options: e($).ENUM, type: "enum", size: "default", clearable: "", placeholder: "自制或外协", class: "filter-item", style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(E, { modelValue: e(t).supplierName, "onUpdate:modelValue": o[8] || (o[8] = (a) => e(t).supplierName = a), modelModifiers: { trim: true }, placeholder: "供应商搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: I(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"])], 64)) : (d(), T(Z, { key: 1, modelValue: e(t).supplierId, "onUpdate:modelValue": o[9] || (o[9] = (a) => e(t).supplierId = a), class: "filter-item", clearable: "", filterable: "", style: { width: "300px" }, projectId: g.projectId, onChange: e(l).toQuery }, null, 8, ["modelValue", "projectId", "onChange"])), r(E, { modelValue: e(t).serialNumber, "onUpdate:modelValue": o[10] || (o[10] = (a) => e(t).serialNumber = a), modelModifiers: { trim: true }, placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: I(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(E, { modelValue: e(t).name, "onUpdate:modelValue": o[11] || (o[11] = (a) => e(t).name = a), modelModifiers: { trim: true }, placeholder: "名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: I(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(J))])], 512), [[M, e(l).searchToggle]]), h("div", oe, [e(W)(e(l).permission.print) ? (d(), T(K, { key: 0, "api-key": e(t).sourceType === e(p).OUT_SOURCE.V ? "deliveryOutReportList" : "deliveryReportList", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"])) : c("", true)])]);
  };
} };
export {
  de as default
};
