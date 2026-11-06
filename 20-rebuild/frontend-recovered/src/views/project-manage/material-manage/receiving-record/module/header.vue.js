import n from "moment";
import { watch as I } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as E } from "vue";
import { withDirectives as w } from "vue";
import { vShow as S } from "vue";
import { unref as e } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as r } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as h } from "vue";
import { withKeys as T } from "vue";
import { ElDatePicker as R } from "element-plus";
import { ElInput as k } from "element-plus";
import { tR as s, B as N, I as j, tS as V, C as Q, G as x } from "../../../../../shared/runtime.js";
import { s as K } from "../../../../../modules/index-8edb1b61.js";
const z = { class: "head-container" }, B = { style: { float: "right" } }, D = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, setup(u) {
  const g = { projectId: { value: void 0, resetAble: false }, date: [n().valueOf() - 2592e6, n().valueOf()], startTime: n().valueOf() - 2592e6, endTime: n().valueOf(), sourceType: s.SELF_SOURCE.V, name: void 0, serialNumber: void 0 }, { crud: l, query: t } = N(g), p = u;
  I(() => p.projectId, (m) => {
    m && (l.query.projectId = p.projectId, l.toQuery());
  }, { immediate: true, deep: true });
  function O() {
    t.date && t.date.length > 1 ? (t.startTime = n(t.date[0]).valueOf(), t.endTime = n(t.date[1]).valueOf()) : (t.startTime = n().valueOf() - 3600 * 1e3 * 24 * 30, t.endTime = n().valueOf()), l.toQuery();
  }
  function _() {
    t.productType = void 0, t.name = void 0, t.serialNumber = void 0, l.toQuery();
  }
  return (m, o) => {
    const b = R, v = d("common-radio-button"), C = d("common-select"), c = k, U = d("print-table");
    return i(), E("div", z, [w(f("div", null, [r(b, { modelValue: e(t).date, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).date = a), type: "daterange", "range-separator": ":", size: "default", clearable: false, shortcuts: e(j), class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", style: { width: "240px" }, onChange: O }, null, 8, ["modelValue", "shortcuts"]), r(v, { type: "enum", modelValue: e(t).sourceType, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).sourceType = a), options: e(s).ENUM, clearable: "", class: "filter-item", onChange: _ }, null, 8, ["modelValue", "options"]), r(C, { modelValue: e(t).productType, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).productType = a), options: e(V).ENUM, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "产品类别", style: { width: "160px" }, unshowOptions: e(t).sourceType === e(s).OUT_SOURCE.V ? [] : [e(V).RAW_MATERIAL.K], onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "unshowOptions", "onChange"]), e(t).sourceType === e(s).OUT_SOURCE.V ? (i(), y(K, { key: 0, modelValue: e(t).supplierId, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).supplierId = a), class: "filter-item", clearable: "", filterable: "", style: { width: "300px" }, projectId: u.projectId, onChange: e(l).toQuery }, null, 8, ["modelValue", "projectId", "onChange"])) : h("", true), r(c, { modelValue: e(t).name, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(t).name = a), modelModifiers: { trim: true }, placeholder: "名称", class: "filter-item", style: { width: "160px" }, size: "default", clearable: "", onKeyup: T(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(c, { modelValue: e(t).serialNumber, "onUpdate:modelValue": o[5] || (o[5] = (a) => e(t).serialNumber = a), modelModifiers: { trim: true }, placeholder: "编号", class: "filter-item", style: { width: "160px" }, size: "default", clearable: "", onKeyup: T(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(Q))], 512), [[S, e(l).searchToggle]]), f("div", B, [e(x)(u.permission.print) ? (i(), y(U, { key: 0, "api-key": e(t).sourceType === e(s).OUT_SOURCE.V ? "outReceivingRecord" : "receivingRecord", params: { ...e(l).query }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"])) : h("", true)])]);
  };
} };
export {
  D as default
};
