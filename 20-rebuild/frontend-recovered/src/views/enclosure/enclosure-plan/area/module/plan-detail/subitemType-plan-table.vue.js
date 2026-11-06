import { ref as E } from "vue";
import { inject as A } from "vue";
import { resolveComponent as b } from "vue";
import { withDirectives as K } from "vue";
import { openBlock as a } from "vue";
import { createBlock as y } from "vue";
import { withCtx as d } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as i } from "vue";
import { createElementBlock as r } from "vue";
import { createCommentVNode as x } from "vue";
import { unref as p } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { ElInput as F } from "element-plus";
import { ElDatePicker as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { _ as O, kQ as h, mw as C, aw as X, c7 as j, p as D } from "../../../../../../shared/runtime.js";
const Y = { class: "flex-rbc" }, Z = { key: 0 }, w = { key: 0 }, ee = { key: 1 }, te = { key: 0 }, ae = { key: 1 }, le = { key: 0 }, ne = { key: 0 }, oe = { key: 0 }, de = { key: 0 }, re = { key: 1 }, ie = { key: 0 }, se = { __name: "subitemType-plan-table", props: { monomerList: { type: Array, default: () => [] }, maxHeight: { type: Number }, fetchMonomerLoading: { type: Boolean, default: false } }, emits: ["to-edit-monomer", "area-row-watch", "del-row", "virtual-del-row", "undelete"], setup(V, { expose: M, emit: ue }) {
  const T = E([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), k = A("projectInfo"), U = E([]), L = { name: [{ required: true, message: "请填写区段名称", trigger: "blur" }], projectPlanProductCategory: [{ required: true, message: "请选择分项分类", trigger: "change" }], budgetVolume: [{ required: true, message: "请输入预算量", trigger: "blur" }], deliveryDate: [{ required: true, message: "请选择日期", trigger: "change" }], productionWay: [{ required: true, message: "请选择自制或外协", trigger: "change" }] }, { tableValidate: S, wrongCellMask: I } = X({ rules: L });
  function q({ row: t, column: l, rowIndex: o, columnIndex: c }) {
    if (t.operateType === "del") return { color: "#ccc", background: "#f2f2f2", cursor: "not-allowed" };
  }
  function N(t, l) {
    t ? (l.deliveryStartDate = t[0], l.deliveryEndDate = t[1], l.deliveryDuration = j(t[0], t[1])) : (l.deliveryStartDate = void 0, l.deliveryEndDate = void 0, l.deliveryDuration = void 0);
  }
  function W(t) {
    var l;
    if (((l = t.areaList) == null ? void 0 : l.length) > 0) {
      const o = [], c = [];
      t.areaList.forEach((f) => {
        f.deliveryStartDate && o.push(f.deliveryStartDate), f.deliveryEndDate && c.push(f.deliveryEndDate);
      });
      const g = o.length > 0 ? Math.min(...o) : "", _ = c.length > 0 ? Math.max(...c) : "";
      return g && _ ? (t.deliveryDuration = j(g, _), t.deliveryStartDate = g, t.deliveryEndDate = _, D(g, "{y}-{m}-{d}") + " ~ " + D(_, "{y}-{m}-{d}")) : (t.deliveryDuration = "", "-");
    } else return t.deliveryStartDate && t.deliveryEndDate ? D(t.deliveryStartDate, "{y}-{m}-{d}") + " ~ " + D(t.deliveryEndDate, "{y}-{m}-{d}") : "-";
  }
  function z(t) {
    return t < /* @__PURE__ */ new Date(k.value.startDate + " 00:00:00") || t > /* @__PURE__ */ new Date(k.value.endDate + " 00:00:00");
  }
  return M({ tableValidate: S }), (t, l) => {
    const o = Q, c = F, g = b("common-select"), _ = b("common-input-number"), f = b("common-radio-button"), B = G, R = b("common-table"), H = J;
    return K((a(), y(R, { ref: "tableRef", "cell-class-name": p(I), "cell-style": q, data: V.monomerList, "empty-text": "暂无数据", "expand-row-keys": U.value, "max-height": V.maxHeight, "show-empty-symbol": false, stripe: false, "tree-props": { children: "areaList" }, class: "subitemType-plan-table-wrapper table-input-border-none", "default-expand-all": "", "return-source-data": "", "row-key": "uid", style: { width: "100%" } }, { default: d(() => [s(o, { align: "center", label: "序号", prop: "idx", width: "55" }, { default: d(({ row: e }) => [u("span", null, i(e.idx), 1)]), _: 1 }), s(o, { "show-overflow-tooltip": true, "min-width": "130px", prop: "name" }, { header: d(() => l[0] || (l[0] = [u("span", { style: { color: "#ff4949", "margin-right": "4px" } }, "*", -1), u("span", null, "单体/区段", -1)])), default: d(({ row: e, $index: n }) => [u("div", Y, [e.isMonomer || !e.isEdit ? (a(), r("span", Z, i(e.name), 1)) : (a(), y(c, { key: 1, modelValue: e.name, "onUpdate:modelValue": (m) => e.name = m, maxlength: 64, class: "input-border-none", clearable: "", placeholder: "区段", size: "default", style: { flex: "1" } }, null, 8, ["modelValue", "onUpdate:modelValue"]))])]), _: 1 }), s(o, { key: "projectPlanProductCategory", align: "center", label: "", prop: "projectPlanProductCategory", width: "150px" }, { header: d(() => l[1] || (l[1] = [u("span", { style: { color: "#ff4949", "margin-right": "4px" } }, "*", -1), u("span", null, "类别", -1)])), default: d(({ row: e }) => [e.isMonomer ? (a(), r("span", w)) : x("", true), !e.isMonomer && !e.isEdit ? (a(), r("span", ee, i(parseInt(e.projectPlanProductCategory) ? p(h).VL[e.projectPlanProductCategory] : e.projectPlanProductCategory), 1)) : x("", true), !e.isMonomer && e.isEdit ? (a(), y(g, { key: 2, modelValue: e.projectPlanProductCategory, "onUpdate:modelValue": (n) => e.projectPlanProductCategory = n, disabled: e.haveDetailedList === 1, options: p(h).ENUM, class: "input-border-none", clearable: "", placeholder: "类别", size: "default", style: { width: "100%" }, type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options"])) : x("", true)]), _: 1 }), s(o, { align: "center", label: "单位", prop: "unit", width: "90px" }, { default: d(({ row: e }) => {
      var n, m;
      return [e.projectPlanProductCategory ? (a(), r("span", te, i(((m = (n = p(h).V) == null ? void 0 : n[e.projectPlanProductCategory]) == null ? void 0 : m.unit) || "-"), 1)) : (a(), r("span", ae))];
    }), _: 1 }), s(o, { key: "budgetVolume", align: "center", label: "预算量", prop: "budgetVolume", width: "130px" }, { header: d(() => l[2] || (l[2] = [u("span", { style: { color: "#ff4949", "margin-right": "4px" } }, "*", -1), u("span", null, "预算量", -1)])), default: d(({ row: e }) => {
      var n, m, v, P;
      return [e.isMonomer || !e.isEdit ? (a(), r("span", le, i(e.budgetVolume) + i((m = (n = p(h).V) == null ? void 0 : n[e.projectPlanProductCategory]) == null ? void 0 : m.unit), 1)) : (a(), y(_, { key: 1, modelValue: e.budgetVolume, "onUpdate:modelValue": ($) => e.budgetVolume = $, controls: false, min: 0, placeholder: `单位：${((P = (v = p(h).V) == null ? void 0 : v[e.projectPlanProductCategory]) == null ? void 0 : P.unit) || "-"}`, precision: 2, step: 1, class: "input-border-none", clearable: "", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"]))];
    }), _: 1 }), s(o, { key: "productionWay", align: "center", label: "自制或外协", prop: "productionWay", width: "150px" }, { default: d(({ row: e }) => [e.isMonomer || !e.isEdit ? (a(), r("span", ne, i(p(C).VL[e.productionWay]), 1)) : (a(), y(f, { key: 1, modelValue: e.productionWay, "onUpdate:modelValue": (n) => e.productionWay = n, options: p(C).ENUM, size: "default", style: { width: "100%" }, type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"]))]), _: 1 }), s(o, { key: "deliveryDate", align: "center", label: "交货期", prop: "deliveryDate", width: "260px" }, { default: d(({ row: e }) => [e.isMonomer || !e.isEdit ? (a(), r("span", oe, i(W(e)), 1)) : (a(), y(B, { key: 1, modelValue: e.deliveryDate, "onUpdate:modelValue": (n) => e.deliveryDate = n, "default-time": T.value, "disabled-date": z, class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", "start-placeholder": "开始日期", style: { width: "230px" }, type: "daterange", "value-format": "x", onChange: (n) => N(n, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "default-time", "onChange"]))]), _: 1 }), s(o, { key: "deliveryDuration", align: "center", label: "工期", prop: "deliveryDuration", width: "150px" }, { default: d(({ row: e }) => [e.deliveryDuration ? (a(), r("span", de, i(e.deliveryDuration) + " 天 ", 1)) : (a(), r("span", re, "-"))]), _: 1 }), s(o, { "show-overflow-tooltip": true, label: "备注", "min-width": "160px", prop: "remark" }, { default: d(({ row: e }) => [e.isMonomer || !e.isEdit ? (a(), r("span", ie, i(e.remark), 1)) : (a(), y(c, { key: 1, modelValue: e.remark, "onUpdate:modelValue": (n) => e.remark = n, maxlength: 200, class: "input-border-none", clearable: "", placeholder: "备注", "show-word-limit": "", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]))]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "expand-row-keys", "max-height"])), [[H, V.fetchMonomerLoading]]);
  };
} }, me = O(se, [["__scopeId", "data-v-7ba42997"]]);
export {
  me as default
};
