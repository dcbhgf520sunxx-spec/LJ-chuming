import { provide as D } from "vue";
import { ref as f } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as k } from "vue";
import { unref as t } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as l } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as u } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as L } from "element-plus";
import { c as $ } from "../../../../modules/report-1b32adbc.js";
import { n as K, x as R, o7 as g, o as q, o8 as G, G as C } from "../../../../shared/runtime.js";
import P from "./module/header.vue.js";
import H from "./module/detail/index.vue.js";
import "../../../../modules/factory-select-b8d0a4ac.js";
import "./module/detail/structure.vue.js";
import "./module/detail/enclosure.vue.js";
const A = { class: "app-container" }, z = { class: "head-container" }, W = ["onClick"], j = ["onClick"], F = ["onClick"], J = ["onClick"], le = { __name: "index", setup(Q) {
  const d = { BEGIN: { L: "期初库存", K: "BEGIN", V: 1 }, INBOUND: { L: "入库", K: "INBOUND", V: 2 }, OUTBOUND: { L: "出库", K: "OUTBOUND", V: 3 }, END: { L: "期末库存", K: "END", V: 4 } };
  K(d), D("reportTypeEnum", d);
  const x = { add: false, edit: false, del: false, download: false }, M = f(), { crud: c, columns: i, CRUD: B } = R({ title: "入发存报表", permission: { ...g }, optShow: { ...x }, crudApi: { ...$ }, hasPagination: false, dataPath: "" }, M);
  D("query", c.query);
  const { maxHeight: T } = q({ paginate: false });
  B.HOOK.handleRefresh = (m, p) => {
    p.data = p.data.map((a, _) => (a.rowId = _ + "" + Math.random(), a));
  };
  const v = f(false), b = f(), h = f({}), y = f(false);
  function w(m, p) {
    C(g.detail) && (v.value = true, b.value = p, h.value = m, y.value = false);
  }
  function V(m) {
    C(g.detail) && (v.value = true, b.value = m, h.value = {}, y.value = true);
  }
  return (m, p) => {
    const a = S, _ = E("common-table"), U = L;
    return r(), O("div", A, [o("div", z, [k(t(P), { onShowDetail: V })]), I((r(), l(_, { ref_key: "tableRef", ref: M, data: t(c).data, "empty-text": t(c).emptyText, "max-height": t(T), "row-key": "rowId", style: { width: "100%" } }, { default: n(() => [k(a, { label: "序号", type: "index", align: "center", width: "60" }), t(i).visible("serialNumber") ? (r(), l(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "合同编号", "min-width": "120" }, { default: n((e) => [o("span", null, s(e.row.serialNumber), 1)]), _: 1 })) : u("", true), t(i).visible("shortName") ? (r(), l(a, { key: "shortName", prop: "shortName", "show-overflow-tooltip": true, label: "项目名称", "min-width": "120" }, { default: n((e) => [o("span", null, s(e.row.shortName), 1)]), _: 1 })) : u("", true), t(i).visible("factoryName") && t(c).query.factoryId ? (r(), l(a, { key: "factoryName", prop: "factoryName", "show-overflow-tooltip": true, label: "工厂" }, { default: n((e) => [o("span", null, s(e.row.factoryName), 1)]), _: 1 })) : u("", true), t(i).visible("productType") ? (r(), l(a, { key: "productType", prop: "productType", "show-overflow-tooltip": true, align: "center", label: "类型", width: "100" }, { default: n((e) => [o("span", null, s(t(G).VL[e.row.productType]), 1)]), _: 1 })) : u("", true), t(i).visible("unit") ? (r(), l(a, { key: "unit", prop: "unit", "show-overflow-tooltip": true, label: "单位", align: "center", width: "100" }, { default: n((e) => [o("span", null, s(e.row.unit), 1)]), _: 1 })) : u("", true), t(i).visible("beginMete") ? (r(), l(a, { key: "beginMete", prop: "beginMete", "show-overflow-tooltip": true, label: "期初库存", align: "center" }, { default: n((e) => [o("div", { style: { cursor: "pointer" }, onClick: (N) => w(e.row, d.BEGIN.V) }, [o("span", null, s(e.row.beginMete), 1)], 8, W)]), _: 1 })) : u("", true), t(i).visible("inboundMete") ? (r(), l(a, { key: "inboundMete", prop: "inboundMete", "show-overflow-tooltip": true, label: "入库量", align: "center" }, { default: n((e) => [o("div", { style: { cursor: "pointer" }, onClick: (N) => w(e.row, d.INBOUND.V) }, [o("span", null, s(e.row.inboundMete), 1)], 8, j)]), _: 1 })) : u("", true), t(i).visible("outboundMete") ? (r(), l(a, { key: "outboundMete", prop: "outboundMete", "show-overflow-tooltip": true, label: "出库量", align: "center" }, { default: n((e) => [o("div", { style: { cursor: "pointer" }, onClick: (N) => w(e.row, d.OUTBOUND.V) }, [o("span", null, s(e.row.outboundMete), 1)], 8, F)]), _: 1 })) : u("", true), t(i).visible("endMete") ? (r(), l(a, { key: "endMete", prop: "endMete", "show-overflow-tooltip": true, label: "期末库存", align: "center" }, { default: n((e) => [o("div", { style: { cursor: "pointer" }, onClick: (N) => w(e.row, d.END.V) }, [o("span", null, s(e.row.endMete), 1)], 8, J)]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[U, t(c).loading]]), k(t(H), { visible: v.value, "onUpdate:visible": p[0] || (p[0] = (e) => v.value = e), "report-type": b.value, "item-info": h.value, "is-summary": y.value }, null, 8, ["visible", "report-type", "item-info", "is-summary"])]);
  };
} };
export {
  le as default
};
