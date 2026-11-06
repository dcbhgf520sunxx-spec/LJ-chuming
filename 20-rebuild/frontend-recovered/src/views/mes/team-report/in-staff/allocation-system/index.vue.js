import { ref as _ } from "vue";
import { provide as S } from "vue";
import { computed as T } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as $ } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as u } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as h } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as L } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as P, _ as R } from "./module/detail.vue.js";
import { x as V, o as B, pr as Q, ps as U, G as A } from "../../../../../shared/runtime.js";
import { _ as O } from "../../../../../modules/index-3b2628f3.js";
import j from "./module/header.vue.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
const E = { class: "app-container" }, W = { class: "head-container" }, z = ["innerHTML"], te = { __name: "index", setup(G) {
  const w = { get: [""], edit: [""], add: [""], del: [""] }, g = { add: false, edit: false, del: false, download: false }, y = _(), { crud: i, columns: r, CRUD: x } = V({ title: "编内-分配制", permission: { ...w }, optShow: { ...g }, crudApi: { ...P }, hasPagination: false }, y), { maxHeight: k } = B({ paginate: false });
  S("query", i.query);
  const p = T(() => Q({ productType: i.query.productType }));
  x.HOOK.handleRefresh = (f, a) => {
    a.data.content = a.data.content.map((e) => (e.processSequence = e.processList.map((m) => `<span>【${m.processName} │ <span style="color: #67C23A;">${m.price}</span>】</span>`), e.completeMete = U({ productType: f.query.productType, length: { num: e.completeLength, to: p.value.unit, dp: p.value.dp }, weight: { num: e.completeNetWeight, to: p.value.unit, dp: p.value.dp } }), e));
  };
  const b = _(false), C = _({});
  function I(f) {
  }
  return (f, a) => {
    const e = N, m = v("common-button"), q = v("common-table"), M = H;
    return n(), $("div", E, [c("div", W, [u(t(j))]), D((n(), l(q, { ref_key: "tableRef", ref: y, data: t(i).data, "empty-text": t(i).emptyText, "max-height": t(k), "row-key": "id", style: { width: "100%" } }, { default: s(() => [u(e, { label: "序号", type: "index", align: "center", width: "60" }), u(t(O), { columns: t(r), showWorkshop: "", showProductionLine: "" }, null, 8, ["columns"]), t(r).visible("completeQuantity") ? (n(), l(e, { key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "生产数量", align: "center", width: "100px" }, { default: s((o) => [c("span", null, h(o.row.completeQuantity), 1)]), _: 1 })) : d("", true), t(r).visible("completeMete") ? (n(), l(e, { key: "completeMete", prop: "completeMete", "show-overflow-tooltip": true, label: `生产量(${p.value.unit})`, align: "center", width: "100px" }, { default: s((o) => [c("span", null, h(o.row.completeMete), 1)]), _: 1 }, 8, ["label"])) : d("", true), t(r).visible("price") ? (n(), l(e, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "工资总额(元)", align: "center", width: "100px" }, { default: s((o) => [c("span", null, h(o.row.price), 1)]), _: 1 })) : d("", true), t(r).visible("processSequence") ? (n(), l(e, { key: "processSequence", prop: "processSequence", "show-overflow-tooltip": true, label: "【工序 │ 总额】", "min-width": "260px" }, { default: s((o) => [c("span", { innerHTML: o.row.processSequence }, null, 8, z)]), _: 1 })) : d("", true), t(A)([...w.get]) ? (n(), l(e, { key: 4, label: "操作", width: "100px", align: "center" }, { default: s((o) => [u(m, { type: "primary", size: "default", onClick: (K) => (o.row, void 0) }, { default: s(() => a[1] || (a[1] = [L("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[M, t(i).loading]]), u(t(R), { visible: b.value, "onUpdate:visible": a[0] || (a[0] = (o) => b.value = o), info: C.value }, null, 8, ["visible", "info"])]);
  };
} };
export {
  te as default
};
