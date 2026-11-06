import { ref as p } from "vue";
import C from "moment";
import { resolveComponent as V } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as D } from "vue";
import { createVNode as c } from "vue";
import { withCtx as s } from "vue";
import { unref as e } from "vue";
import { createTextVNode as _ } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as a } from "vue";
import { createCommentVNode as l } from "vue";
import { ElDatePicker as P } from "element-plus";
import { ElTag as B } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { vLoading as T } from "element-plus";
import { x as L, o as S, L as Q, E as R, ba as z } from "../../../shared/runtime.js";
const H = { class: "app-container" }, O = { class: "head-container" }, F = { __name: "index", setup(U) {
  const u = p(C().valueOf()), b = { add: false, edit: false, del: false, download: false }, m = p(), { crud: i, columns: o } = L({ title: "下料人工分析", sort: [], optShow: { ...b }, hasPagination: true }, m);
  function f(d) {
    return d > /* @__PURE__ */ new Date();
  }
  const { maxHeight: g } = S({ extraBox: [".head-container"], paginate: true });
  function y(d) {
    return z(d, { props: [""], toThousandFields: [""] });
  }
  return (d, r) => {
    const h = P, v = B, n = E, k = V("common-table"), x = T;
    return t(), A("div", H, [D("div", O, [c(e(R), null, { optLeft: s(() => [c(h, { modelValue: u.value, "onUpdate:modelValue": r[0] || (r[0] = (w) => u.value = w), type: "year", size: "default", style: { width: "100px" }, placeholder: "选择年", class: "filter-item", "value-format": "x", clearable: "", "disabled-date": f, onChange: e(i).toQuery }, null, 8, ["modelValue", "onChange"])]), viewLeft: s(() => [c(Q, { class: "filter-item" }, { default: s(() => r[1] || (r[1] = [_(" 下料人工分析清单 ")])), _: 1, __: [1] }), c(v, { size: "large", style: { "align-self": "center" } }, { default: s(() => r[2] || (r[2] = [_("单位：元/吨")])), _: 1, __: [2] })]), _: 1 })]), N((t(), a(k, { ref_key: "tableRef", ref: m, data: e(i).data, "empty-text": e(i).emptyText, "max-height": e(g), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": y }, { default: s(() => [e(o).visible("month") ? (t(), a(n, { key: 0, label: "月份", prop: "month", align: "center" })) : l("", true), e(o).visible("personNumber") ? (t(), a(n, { key: 1, label: "人员数量", prop: "personNumber", align: "center" })) : l("", true), e(o).visible("Attendance") ? (t(), a(n, { key: 2, label: "出勤（工日）", prop: "Attendance", align: "center" })) : l("", true), e(o).visible("workQuantity") ? (t(), a(n, { key: 3, label: "工程量（t）", prop: "workQuantity", align: "center" })) : l("", true), e(o).visible("perCapitaProduction") ? (t(), a(n, { key: 4, label: "人均产量（吨/工日）", prop: "perCapitaProduction", align: "center" })) : l("", true), e(o).visible("totalAmount") ? (t(), a(n, { key: 5, label: "应付工程款总额（元）", prop: "totalAmount", align: "center" })) : l("", true), e(o).visible("unloadingAveragePrice") ? (t(), a(n, { key: 6, label: "下料均价（元/吨）", prop: "unloadingAveragePrice", align: "center" })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[x, e(i).loading]])]);
  };
} };
export {
  F as default
};
