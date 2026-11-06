import { ref as b } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as c } from "vue";
import { unref as t } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as i } from "vue";
import { withCtx as S } from "vue";
import { createCommentVNode as a } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as Q } from "element-plus";
import { c as A, _ as B } from "./module/operation-drawer.vue.js";
import { t as H } from "../../../../../modules/ship-manage-3066b2ed.js";
import { x as I, o as P, P as V } from "../../../../../shared/runtime.js";
import M from "./module/header.vue.js";
import "../../../../../modules/one-code-number-list-af2f89eb.js";
import "../../../../../modules/index-c07af747.js";
import "../../../../../modules/manuf-warehouse-select-bae65ecc.js";
const O = { class: "app-container" }, U = { class: "head-container" }, J = { __name: "index", setup(W) {
  const g = { add: false, edit: false, del: false, download: false }, m = b(), { crud: s, columns: n, CRUD: v } = I({ title: "库位归纳", sort: [], permission: { ...H }, optShow: { ...g }, crudApi: { ...A }, hasPagination: true }, m), { maxHeight: y } = P({ paginate: true }), l = b([]), d = b(false);
  function _(p) {
    return l.value.findIndex((r) => r.productId === p.productId) === -1;
  }
  function k() {
    l.value = l.value.concat(s.selections), m.value.clearSelection();
  }
  function x(p) {
    l.value.splice(p, 1);
  }
  function N() {
    l.value = [], s.toQuery();
  }
  return v.HOOK.handleRefresh = (p, r) => {
    r.data.content = r.data.content.map((e) => {
      var u;
      return e.originQuantity = e.quantity, e.originNumberList = ((u = e.numberList) == null ? void 0 : u.map((h) => ({ number: h }))) || [], e;
    });
  }, (p, r) => {
    var w;
    const e = D, u = C("common-table"), h = Q;
    return o(), R("div", O, [j("div", U, [c(t(M), { operationNumber: (w = l.value) == null ? void 0 : w.length, onAdd: k, onOperation: r[0] || (r[0] = (f) => d.value = true) }, null, 8, ["operationNumber"])]), L((o(), i(u, { ref_key: "tableRef", ref: m, data: t(s).data, "empty-text": t(s).emptyText, "max-height": t(y), style: { width: "100%" }, onSelectionChange: t(s).selectionChangeHandler }, { default: S(() => [c(e, { type: "selection", align: "center", width: "45", class: "selection", selectable: _ }), c(e, { label: "序号", type: "index", align: "center", width: "60" }), t(n).visible("workshop.name") ? (o(), i(e, { key: "workshop.name", prop: "workshop.name", align: "center", "show-overflow-tooltip": true, label: "车间", "min-width": "100" })) : a("", true), t(n).visible("project.serialNumber") ? (o(), i(e, { key: "project.serialNumber", prop: "project.serialNumber", align: "center", "show-overflow-tooltip": true, label: "项目编号", "min-width": "100" })) : a("", true), t(n).visible("project.name") ? (o(), i(e, { key: "project.name", prop: "project.name", align: "center", "show-overflow-tooltip": true, label: "项目", "min-width": "140" })) : a("", true), t(n).visible("monomer.name") ? (o(), i(e, { key: "monomer.name", prop: "monomer.name", align: "center", "show-overflow-tooltip": true, label: "单体", "min-width": "100" })) : a("", true), t(n).visible("area.name") ? (o(), i(e, { key: "area.name", prop: "area.name", align: "center", "show-overflow-tooltip": true, label: "区域", "min-width": "100" })) : a("", true), t(n).visible("name") ? (o(), i(e, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "名称", "min-width": "100" })) : a("", true), t(n).visible("serialNumber") ? (o(), i(e, { key: "serialNumber", prop: "serialNumber", align: "center", "show-overflow-tooltip": true, label: "编号", "min-width": "100" })) : a("", true), t(n).visible("specification") ? (o(), i(e, { key: "specification", prop: "specification", align: "center", "show-overflow-tooltip": true, label: "规格", "min-width": "120" })) : a("", true), t(n).visible("length") ? (o(), i(e, { key: "length", prop: "length", align: "center", "show-overflow-tooltip": true, label: "长度", width: "100" })) : a("", true), t(n).visible("originQuantity") ? (o(), i(e, { key: "originQuantity", prop: "originQuantity", align: "center", "show-overflow-tooltip": true, label: "入库数", width: "100" })) : a("", true), t(n).visible("netWeight") ? (o(), i(e, { key: "netWeight", prop: "netWeight", align: "center", "show-overflow-tooltip": true, label: "单重", width: "100" })) : a("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[h, t(s).loading]]), c(t(V)), c(t(B), { visible: d.value, "onUpdate:visible": r[1] || (r[1] = (f) => d.value = f), operationList: l.value, onDeleteRow: x, onRefresh: N }, null, 8, ["visible", "operationList"])]);
  };
} };
export {
  J as default
};
