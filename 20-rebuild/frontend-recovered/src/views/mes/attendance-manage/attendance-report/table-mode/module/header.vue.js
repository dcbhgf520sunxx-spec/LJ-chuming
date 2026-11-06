import s from "moment";
import { inject as w } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withKeys as x } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as p } from "vue";
import { withModifiers as m } from "vue";
import { renderSlot as D } from "vue";
import { ElDatePicker as Q } from "element-plus";
import { ElInput as v } from "element-plus";
import { g8 as U, B as z, n5 as E } from "../../../../../../shared/runtime.js";
const I = { __name: "header", setup(O) {
  const c = U(["work_type"]), f = { date: [s().subtract(30, "days").valueOf(), s().valueOf()], startDate: s().subtract(30, "days").valueOf(), endDate: s().valueOf() }, { crud: o, query: e } = z(f), y = w("deptList");
  function V() {
    e.name = void 0, o.toQuery();
  }
  function h() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), o.toQuery();
  }
  return (g, a) => {
    const d = i("common-select"), k = Q, _ = v, r = i("common-button");
    return C(), b("div", null, [n(d, { modelValue: t(e).deptId, "onUpdate:modelValue": a[0] || (a[0] = (l) => t(e).deptId = l), options: t(y), type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", filterable: "", style: { width: "200px" }, placeholder: "选择部门", onChange: t(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(k, { modelValue: t(e).date, "onUpdate:modelValue": a[1] || (a[1] = (l) => t(e).date = l), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", class: "filter-item", style: { width: "270px" }, onChange: h }, null, 8, ["modelValue"]), n(d, { modelValue: t(e).workType, "onUpdate:modelValue": a[2] || (a[2] = (l) => t(e).workType = l), options: t(c).work_type, clearable: "", filterable: "", type: "dict", size: "small", style: { width: "200px" }, class: "filter-item", placeholder: "工种筛选", onChange: t(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(d, { placeholder: "考勤类型筛选", class: "filter-item", type: "enum", clearable: "", options: t(E).ENUM, modelValue: t(e).isStand, "onUpdate:modelValue": a[3] || (a[3] = (l) => t(e).isStand = l), onChange: t(o).toQuery, style: { width: "200px" } }, null, 8, ["options", "modelValue", "onChange"]), n(_, { modelValue: t(e).name, "onUpdate:modelValue": a[4] || (a[4] = (l) => t(e).name = l), placeholder: "名字搜索", class: "filter-item", style: { width: "150px" }, size: "default", clearable: "", onKeyup: x(t(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(r, { class: "filter-item", size: "mini", type: "success", icon: "el-icon-search", onClick: m(t(o).toQuery, ["stop"]) }, { default: u(() => a[5] || (a[5] = [p("搜索")])), _: 1, __: [5] }, 8, ["onClick"]), n(r, { class: "filter-item", size: "mini", type: "warning", icon: "el-icon-refresh-left", onClick: m(V, ["stop"]) }, { default: u(() => a[6] || (a[6] = [p(" 重置 ")])), _: 1, __: [6] }), D(g.$slots, "extra")]);
  };
} };
export {
  I as default
};
