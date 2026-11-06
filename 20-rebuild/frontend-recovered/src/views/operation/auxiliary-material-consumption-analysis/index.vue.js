import { ref as _ } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as c } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as w } from "vue";
import { unref as e } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as l } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as B } from "vue";
import { renderList as C } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as L } from "element-plus";
import { x as T, o as V, L as j, E as A, ba as D } from "../../../shared/runtime.js";
const E = { class: "app-container" }, R = { class: "head-container" }, q = { __name: "index", setup(F) {
  const m = _([]);
  for (let o = 1; o <= 12; o++) m.value.push(o);
  const h = { add: false, edit: false, del: false, download: false }, d = _(), { crud: i, columns: n } = T({ title: "管理费", sort: [], optShow: { ...h }, hasPagination: true }, d);
  function b(o) {
    return D(o, { props: [""], toThousandFields: [""] });
  }
  const { maxHeight: g } = V({ extraBox: [".head-container"], paginate: true });
  return (o, u) => {
    const t = S, x = v("common-table"), y = L;
    return a(), f("div", E, [k("div", R, [c(e(A), null, { viewLeft: s(() => [c(j, { class: "filter-item" }, { default: s(() => u[0] || (u[0] = [w(" 辅材消耗分析清单 ")])), _: 1, __: [0] })]), _: 1 })]), N((a(), l(x, { ref_key: "tableRef", ref: d, data: e(i).data, "empty-text": e(i).emptyText, "max-height": e(g), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": b }, { default: s(() => [c(t, { type: "index", label: "序号", prop: "index", align: "center", width: "60px" }), e(n).visible("projectName") ? (a(), l(t, { key: 0, label: "项目", prop: "projectName", align: "center" })) : r("", true), e(n).visible("classify") ? (a(), l(t, { key: 1, label: "分类", prop: "classify", align: "center" })) : r("", true), e(n).visible("unit") ? (a(), l(t, { key: 2, label: "单位", prop: "unit", align: "center" })) : r("", true), e(n).visible("month") ? (a(), l(t, { key: 3, label: "月份", prop: "month", align: "center" }, { default: s(() => [(a(true), f(B, null, C(m.value, (p) => (a(), l(t, { label: p, align: "center", key: p }, null, 8, ["label"]))), 128))]), _: 1 })) : r("", true), e(n).visible("allYearAverage") ? (a(), l(t, { key: 4, label: "全年平均", prop: "allYearAverage", align: "center" })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[y, e(i).loading]])]);
  };
} };
export {
  q as default
};
