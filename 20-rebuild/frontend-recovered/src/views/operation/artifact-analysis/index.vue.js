import { ref as m } from "vue";
import v from "moment";
import { resolveComponent as k } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as P } from "vue";
import { createVNode as p } from "vue";
import { withCtx as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as V } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as o } from "vue";
import { createCommentVNode as l } from "vue";
import { ElDatePicker as D } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { vLoading as N } from "element-plus";
import { x as B, o as E, L as S, E as T, ba as U } from "../../../shared/runtime.js";
const H = { class: "app-container" }, R = { class: "head-container" }, z = { __name: "index", setup(O) {
  const c = m(v().valueOf()), h = { add: false, edit: false, del: false, download: false }, u = m(), { crud: r, columns: i } = B({ title: "构件分析", sort: [], optShow: { ...h }, hasPagination: true }, u);
  function b(s) {
    return s > /* @__PURE__ */ new Date();
  }
  const { maxHeight: f } = E({ extraBox: [".head-container"], paginate: true });
  function x(s) {
    return U(s, { props: [""], toThousandFields: [""] });
  }
  return (s, d) => {
    const _ = D, a = L, g = k("common-table"), y = N;
    return t(), C("div", H, [P("div", R, [p(e(T), null, { optLeft: n(() => [p(_, { modelValue: c.value, "onUpdate:modelValue": d[0] || (d[0] = (w) => c.value = w), type: "year", size: "default", style: { width: "100px" }, placeholder: "选择年", class: "filter-item", "value-format": "x", clearable: "", "disabled-date": b, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"])]), viewLeft: n(() => [p(S, { class: "filter-item" }, { default: n(() => d[1] || (d[1] = [V(" 构件分析清单 ")])), _: 1, __: [1] })]), _: 1 })]), A((t(), o(g, { ref_key: "tableRef", ref: u, data: e(r).data, "empty-text": e(r).emptyText, "max-height": e(f), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": x }, { default: n(() => [e(i).visible("month") ? (t(), o(a, { key: 0, label: "月份", prop: "month", align: "center", width: "60px", fixed: "left" })) : l("", true), e(i).visible("monthProduction") ? (t(), o(a, { key: 1, label: "月产（吨）", prop: "monthProduction", align: "center", width: "100px", fixed: "left" })) : l("", true), e(i).visible("personNumber") ? (t(), o(a, { key: 2, label: "人员数量", prop: "personNumber", align: "center", width: "100px", fixed: "left" })) : l("", true), e(i).visible("Attendance") ? (t(), o(a, { key: 3, label: "出勤（工日）", prop: "Attendance", align: "center", width: "100px", fixed: "left" })) : l("", true), e(i).visible("productionAmount") ? (t(), o(a, { key: 4, label: "生产量（吨）", prop: "productionAmount", align: "center", "min-width": "200px" }, { default: n(() => [e(i).visible("productionAmount") ? (t(), o(a, { key: 0, label: "焊接H型钢", prop: "productionAmount", align: "center", width: "300px" })) : l("", true), e(i).visible("other") ? (t(), o(a, { key: 1, label: "其它", prop: "other", align: "center", width: "300px" })) : l("", true), e(i).visible("subtotal") ? (t(), o(a, { key: 2, label: "小计", prop: "subtotal", align: "center", width: "300px" })) : l("", true)]), _: 1 })) : l("", true), p(a, { "min-width": "1px" }), e(i).visible("perCapitaProduction") ? (t(), o(a, { key: 5, label: "人均产量（吨/月）", prop: "perCapitaProduction", align: "center", width: "140px", fixed: "right" })) : l("", true), e(i).visible("totalLaborCost") ? (t(), o(a, { key: 6, label: "人工费总额（元）", prop: "totalLaborCost", align: "center", width: "140px", fixed: "right" })) : l("", true), e(i).visible("processUnitPrice") ? (t(), o(a, { key: 7, label: "工序单价（元/吨）", prop: "processUnitPrice", align: "center", width: "140px", fixed: "right" })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[y, e(r).loading]])]);
  };
} };
export {
  z as default
};
