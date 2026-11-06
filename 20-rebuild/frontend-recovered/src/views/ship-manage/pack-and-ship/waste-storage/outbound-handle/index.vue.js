import { ref as m } from "vue";
import { watch as H } from "vue";
import { computed as y } from "vue";
import { provide as I } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as a } from "vue";
import { withCtx as u } from "vue";
import { unref as i } from "vue";
import { createTextVNode as x } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as o } from "vue";
import { createCommentVNode as n } from "vue";
import { toDisplayString as S } from "vue";
import { ElBadge as W } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as G, s as O } from "./module/summary-list.vue.js";
import { o as Q, x as X, kG as b, bV as Y, P as z, V as J } from "../../../../../shared/runtime.js";
import { u as K } from "../../../../../modules/ship-manage-3066b2ed.js";
import Z from "./module/header.vue.js";
import "../../../../../modules/scrap-sell-e306ced6.js";
import "../../../../../modules/enclosure-6f8adfb8.js";
import "../../../../../modules/project-select-94bb5bbd.js";
const $ = { class: "app-container" }, ee = { class: "head-container" }, ce = { __name: "index", setup(te) {
  const { maxHeight: C } = Q(), A = { add: false, edit: false, del: false, download: false }, h = m(), L = m(), w = m(false), r = m([]), { crud: l } = X({ title: "出库办理", optShow: { ...A }, permission: { ...K }, sort: [], invisibleColumns: [], crudApi: { ...G } }, h);
  H([() => l.query.type], () => {
    r.value = [];
  });
  const c = y(() => l.query.type === b.AUXILIARY_MATERIAL.V), d = y(() => l.query.type === b.ENCLOSURE.V), f = y(() => l.query.type === b.STRUCTURE.V), q = m([["createTime", ["parse-time"]]]);
  function T(v) {
    return r.value.findIndex((s) => s.id === v.id) === -1;
  }
  function D() {
    r.value = r.value.concat(J(l.selections)), h.value.clearSelection();
  }
  function R() {
    w.value = true;
  }
  function U(v) {
    r.value.splice(v, 1);
  }
  function V() {
    r.value = [], l.toQuery();
  }
  return I("query", l.query), (v, s) => {
    const _ = k("common-button"), E = W, e = j, N = k("common-table"), B = F;
    return t(), M("div", $, [g("div", ee, [a(i(Z), null, { viewLeft: u(() => [a(_, { class: "filter-item", type: "success", onClick: D, disabled: !i(l).data.length }, { default: u(() => s[1] || (s[1] = [x(" 添加 ")])), _: 1, __: [1] }, 8, ["disabled"]), a(E, { value: r.value.length, max: 99, hidden: r.value.length < 1 }, { default: u(() => [a(_, { class: "filter-item", type: "primary", onClick: R, disabled: !r.value.length }, { default: u(() => s[2] || (s[2] = [x(" 办理出库 ")])), _: 1, __: [2] }, 8, ["disabled"])]), _: 1 }, 8, ["value", "hidden"])]), _: 1 })]), P((t(), o(N, { ref_key: "tableRef", ref: h, data: i(l).data, "empty-text": i(l).emptyText, "max-height": i(C), style: { width: "100%" }, "data-format": q.value, onSelectionChange: i(l).selectionChangeHandler }, { default: u(() => [a(e, { key: "selection", type: "selection", width: "55", align: "center", selectable: T }), a(e, { label: "序号", type: "index", align: "center", width: "60" }), a(e, { "show-overflow-tooltip": "", prop: "productName", key: "productName", label: "名称", align: "center" }), c.value ? n("", true) : (t(), o(e, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" })), d.value ? (t(), o(e, { "show-overflow-tooltip": "", prop: "plate", key: "plate", label: "板型", align: "center" })) : n("", true), a(e, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "规格", align: "center" }), f.value ? (t(), o(e, { "show-overflow-tooltip": "", prop: "material", key: "material", label: "材质", align: "center" })) : n("", true), c.value ? (t(), o(e, { "show-overflow-tooltip": "", prop: "mete", key: "mete", label: "核算量", align: "center" })) : n("", true), c.value ? (t(), o(e, { "show-overflow-tooltip": "", prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" })) : n("", true), f.value || c.value ? (t(), o(e, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量", align: "center" })) : n("", true), d.value ? (t(), o(e, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量（张）", align: "center" })) : n("", true), c.value ? (t(), o(e, { "show-overflow-tooltip": "", prop: "measureUnit", key: "measureUnit", label: "单位", align: "center" })) : n("", true), f.value ? (t(), o(e, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "长度（m）", align: "center" })) : n("", true), d.value ? (t(), o(e, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "单长度（m）", align: "center" })) : n("", true), d.value ? (t(), o(e, { "show-overflow-tooltip": "", prop: "surfaceArea", key: "surfaceArea", label: "单面积（m²）", align: "center" }, { default: u((p) => [g("span", null, S(p.row.surfaceArea || "-"), 1)]), _: 1 })) : n("", true), f.value ? (t(), o(e, { "show-overflow-tooltip": "", prop: "netWeight", key: "netWeight", label: "单重（t）", align: "center" })) : n("", true), a(e, { "show-overflow-tooltip": "", prop: "totalAmount", key: "totalAmount", label: "金额（元）", align: "center" }, { default: u((p) => [g("span", null, S(i(Y)(p.row.totalAmount, 3) || "-"), 1)]), _: 1 }), a(e, { "show-overflow-tooltip": "", prop: "createTime", key: "createTime", label: "退货日期", align: "center", width: "140px" }), a(e, { "show-overflow-tooltip": "", prop: "warehouse.name", key: "warehouse.name", label: "存放位置", align: "center" })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format", "onSelectionChange"])), [[B, i(l).loading]]), a(i(z)), a(i(O), { ref_key: "sunmmaryListRef", ref: L, visible: w.value, "onUpdate:visible": s[0] || (s[0] = (p) => w.value = p), auditDataList: r.value, onDelete: U, onSuccess: V }, null, 8, ["visible", "auditDataList"])]);
  };
} };
export {
  ce as default
};
