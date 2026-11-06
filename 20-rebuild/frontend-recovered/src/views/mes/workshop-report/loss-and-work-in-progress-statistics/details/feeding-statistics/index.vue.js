import { ref as O } from "vue";
import { computed as S } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as t } from "vue";
import { createBlock as a } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as w } from "vue";
import { unref as o } from "vue";
import { withDirectives as x } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as u } from "vue";
import { isRef as j } from "vue";
import { ElTableColumn as E } from "element-plus";
import { vLoading as N } from "element-plus";
import { c as B } from "../../../../../../modules/loss-and-work-in-progress-statistics-3ddf318f.js";
import { u as $, x as q, si as A } from "../../../../../../shared/runtime.js";
import P from "./module/header.vue.js";
const U = { class: "head-container" }, I = { __name: "index", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, minQuery: { type: Object, default: () => {
} }, datailCurrentRow: { type: Object, default: () => {
} }, currentWastageCostSummaryValueDTO: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(b, { emit: M }) {
  const v = M, c = b, { visible: p, handleClose: _ } = $({ emit: v, props: c, showHook: T, closeHook: C }), m = O(), g = { batchAdd: false, add: false, edit: false, del: false, download: false }, { crud: d, columns: s, CRUD: H } = q({ title: "损耗统计-投料统计表", optShow: { ...g }, sort: [], crudApi: { ...B }, queryOnPresenterCreated: false, hasPagination: true }, m), k = S(() => c.minQuery.projectOrWorkShopEnum === A.PROJECT.V ? `项目：${c.currentRow.serialNumber} - ${c.currentRow.shortName}` : `车间：${c.currentRow.name}`);
  function T() {
  }
  function C() {
  }
  return (y, f) => {
    const l = E, R = h("common-table"), V = h("common-drawer"), D = N;
    return t(), a(V, { ref: "drawerRef", "append-to-body": "", modelValue: o(p), "onUpdate:modelValue": f[0] || (f[0] = (e) => j(p) ? p.value = e : null), title: k.value, "before-close": o(_), "close-on-click-modal": false, size: "100%", "custom-class": "material-requisition-statistics-detail" }, { content: r(() => [n("div", U, [w(o(P))]), x((t(), a(R, { ref_key: "tableRef", ref: m, data: o(d).data, "data-format": y.columnsDataFormat, showEmptySymbol: false, stripe: false, "summary-method": y.getSummaries }, { default: r(() => [w(l, { prop: "index", key: "index", label: "序号", align: "center", fixed: "left" }), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "材料类型", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "领用车间", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "领用人", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "物料种类", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "规格", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "材质/型号", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "数量", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "计量单位", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "核算量", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "核算单位", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "关联零件编号", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "出库日期", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true), o(s).visible("createTime") ? (t(), a(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "出库单号", align: "center" }, { default: r((e) => [n("span", null, i(e.row.yearMonth || "-"), 1)]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "data-format", "summary-method"])), [[D, o(d).loading]])]), _: 1 }, 8, ["modelValue", "title", "before-close"]);
  };
} };
export {
  I as default
};
