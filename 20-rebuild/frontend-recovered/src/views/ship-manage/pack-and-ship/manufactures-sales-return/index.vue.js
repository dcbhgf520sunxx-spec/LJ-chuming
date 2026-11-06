import { ref as n } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as P } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as H } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as c } from "vue";
import { createBlock as u } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as b } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElTag as q } from "element-plus";
import { vLoading as z } from "element-plus";
import { c as B } from "../../../../modules/manufactures-sales-return-578c5329.js";
import { _ as j, x as G, o as K, kC as Q, kG as $, kL as F, bV as I, kK as g, G as J, P as O } from "../../../../shared/runtime.js";
import { m as p } from "../../../../modules/ship-manage-3066b2ed.js";
import W from "./module/header.vue.js";
import X from "./create/index.vue.js";
import Y from "./module/audit.vue.js";
import "./create/module/summary-list.vue.js";
import "../../../../modules/manuf-warehouse-select-bae65ecc.js";
import "./create/module/header.vue.js";
import "../../../../modules/enclosure-6f8adfb8.js";
import "../../../../modules/project-select-94bb5bbd.js";
const Z = { class: "app-container" }, ee = { class: "head-container" }, te = { class: "operation-list" }, ae = { __name: "index", setup(oe) {
  const k = n(), f = n(false), _ = n(false), T = n(), x = n(), { crud: r } = G({ title: "制成品退货", permission: { ...p }, sort: [], crudApi: { ...B }, hasPagination: true }, k), V = n([["createTime", ["parse-time"]], ["auditTime", ["parse-time"]]]), { maxHeight: D } = K({ paginate: false, extraHeight: 50 });
  function E() {
    f.value = true;
  }
  function C(S, l) {
    _.value = true, T.value = l, x.value = S;
  }
  return (S, l) => {
    const y = w("common-button"), R = w("print-table"), o = L, N = q, U = w("common-table"), v = P("permission"), A = z;
    return s(), H("div", Z, [h("div", ee, [a(e(W)), h("div", te, [c((s(), u(y, { class: "filter-item", size: "default", type: "success", icon: "el-icon-plus", onClick: E }, { default: i(() => l[2] || (l[2] = [m(" 创建 ")])), _: 1, __: [2] })), [[v, e(p).create]]), c(a(R, { "api-key": "manufacturesSalesReturnReport", params: e(r).query, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[v, e(p).print]])])]), c((s(), u(U, { ref_key: "tableRef", ref: k, data: e(r).data, "data-format": V.value, "empty-text": e(r).emptyText, "max-height": e(D), style: { width: "100%" }, onSelectionChange: e(r).selectionChangeHandler }, { default: i(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "projectName", key: "projectName", label: "项目", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "productType", key: "productType", label: "制成品类型", align: "center" }, { default: i((t) => [t.row.productType ? (s(), u(N, { key: 0, effect: "plain" }, { default: i(() => [m(d(t.row.relationType ? e(Q).VL[t.row.relationType] : e($).VL[t.row.productType]), 1)]), _: 2 }, 1024)) : b("", true)]), _: 1 }), a(o, { "show-overflow-tooltip": "", prop: "handleMethod", key: "handleMethod", label: "处理方式", align: "center" }, { default: i((t) => [m(d(e(F).VL[t.row.handleMethod]), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "totalAmount", key: "totalAmount", label: "费用（元）", align: "center" }, { default: i((t) => [h("span", null, d(e(I)(t.row.totalAmount, 3)), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": "", prop: "createUserName", key: "createUserName", label: "创建人", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "createTime", key: "createTime", label: "创建日期", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "auditUserName", key: "auditUserName", label: "审核人", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "auditTime", key: "auditTime", label: "审核日期", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "auditStatus", key: "auditStatus", label: "审核状态", align: "center" }, { default: i((t) => [t.row.auditStatus ? (s(), u(N, { key: 0, type: e(g).V[t.row.auditStatus].T, effect: "plain" }, { default: i(() => [m(d(e(g).VL[t.row.auditStatus]), 1)]), _: 2 }, 1032, ["type"])) : b("", true)]), _: 1 }), a(o, { "show-overflow-tooltip": "", prop: "name", key: "nmae", label: "操作", align: "center" }, { default: i((t) => [c(a(y, { type: "primary", size: "default", icon: "el-icon-view", onClick: (M) => C(t.row, "view") }, null, 8, ["onClick"]), [[v, e(p).detail]]), t.row.auditStatus === e(g).UNCHECKED.V && e(J)(e(p).audit) ? (s(), u(y, { key: 0, type: "success", size: "default", icon: "el-icon-stamp", onClick: (M) => C(t.row, "audit") }, null, 8, ["onClick"])) : b("", true)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "onSelectionChange"])), [[A, e(r).loading]]), a(e(O)), a(e(X), { visible: f.value, "onUpdate:visible": l[0] || (l[0] = (t) => f.value = t), onSuccess: e(r).toQuery }, null, 8, ["visible", "onSuccess"]), a(e(Y), { visible: _.value, "onUpdate:visible": l[1] || (l[1] = (t) => _.value = t), auditType: T.value, rowData: x.value, onSuccess: e(r).toQuery }, null, 8, ["visible", "auditType", "rowData", "onSuccess"])]);
  };
} }, we = j(ae, [["__scopeId", "data-v-33fd3f61"]]);
export {
  we as default
};
