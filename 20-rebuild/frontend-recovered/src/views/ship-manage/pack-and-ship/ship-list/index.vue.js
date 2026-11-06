import { ref as h } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as d } from "vue";
import { unref as e } from "vue";
import { withDirectives as z } from "vue";
import { createBlock as r } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as n } from "vue";
import { createCommentVNode as i } from "vue";
import { Fragment as C } from "vue";
import { renderList as j } from "vue";
import { createTextVNode as y } from "vue";
import { normalizeStyle as W } from "vue";
import { withModifiers as F } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as A } from "element-plus";
import { vLoading as K } from "element-plus";
import { b as $ } from "../../../../modules/ship-list-822ce00f.js";
import { j as V } from "../../../../modules/ship-manage-3066b2ed.js";
import { _ as J, m as X, x as Y, o as Z, z as ee, K as S, aN as E, bv as G, bi as v, bw as _, c as m, ul as P, G as te, P as ae, bx as re } from "../../../../shared/runtime.js";
import oe from "./module/header.vue.js";
import ie from "./module/detail.vue.js";
import "../../../../modules/receipt-status-4b335dc2.js";
import "./module/cancel-form.vue.js";
const le = { class: "app-container" }, se = { class: "project-name" }, ne = { __name: "index", setup(ue) {
  const R = { add: false, edit: false, del: false, download: false }, { currentProjectType: D } = X(["currentProjectType"]), k = h(), { crud: u, CRUD: U, columns: l } = Y({ title: "发运记录", sort: ["auditTime.desc"], permission: { ...V }, crudApi: { get: $ }, optShow: { ...R }, invisibleColumns: ["totalGrossWeight"] }, k), B = h([["auditTime", ["parse-time", "{y}-{m}-{d}"]]]);
  U.HOOK.beforeToQuery = () => {
    u.query.projectType = D.value;
  };
  const { maxHeight: q } = Z({ paginate: true }), w = h(false), T = h({});
  function L(f) {
    T.value = f, w.value = true;
  }
  function Q({ row: f }) {
    return f.deliveryStatus === re.RETURN.V ? "row-return" : "";
  }
  return (f, N) => {
    const o = M, g = A, H = x("common-button"), I = x("common-table"), O = K;
    return a(), b("div", le, [d(e(oe)), z((a(), r(I, { ref_key: "tableRef", ref: k, data: e(u).data, style: { width: "100%" }, "max-height": e(q), "data-format": B.value, "row-class-name": Q, onSortChange: e(u).handleSortChange, onSelectionChange: e(u).selectionChangeHandler }, { default: s(() => [d(o, { type: "selection", width: "55", align: "center" }), d(o, { label: "序号", type: "index", align: "center", width: "60" }), e(l).visible("serialNumber") ? (a(), r(o, { key: "serialNumber", prop: "serialNumber", sortable: "custom", label: "车次/船次", align: "center", "min-width": "140px" }, { default: s((t) => [p("span", null, n(t.row.serialNumber), 1)]), _: 1 })) : i("", true), e(l).visible("emissionQuantity") ? (a(), r(o, { key: "emissionQuantity", prop: "emissionQuantity", label: "车次/船次数", align: "center", "min-width": "140px" }, { default: s((t) => [p("span", null, n(t.row.emissionQuantity), 1)]), _: 1 })) : i("", true), e(l).visible("auditTime") ? (a(), r(o, { key: "auditTime", prop: "auditTime", label: "发运日期", width: "120" })) : i("", true), e(l).visible("project.shortName") && !e(u).query.projectId ? (a(), r(o, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "250" }, { default: s((t) => [p("span", se, n(e(ee)(t.row.project)), 1)]), _: 1 })) : i("", true), e(l).visible("productType") && e(u).query.projectType === e(S).STEEL.V ? (a(), r(o, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: s((t) => [(a(true), b(C, null, j(e(E)(e(G).getBits(e(v), t.row.productType, "V")), (c) => (a(), r(g, { style: { "margin-right": "5px" }, key: c, type: e(v).V[c].T, effect: "light", "disable-transitions": "" }, { default: s(() => [y(n(e(v).VL[c]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : i("", true), e(l).visible("productType") && e(u).query.projectType === e(S).BRIDGE.V ? (a(), r(o, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: s((t) => [(a(true), b(C, null, j(e(E)(e(G).getBits(e(_), t.row.productType, "V")), (c) => (a(), r(g, { style: { "margin-right": "5px" }, key: c, type: e(_).V[c].T, effect: "light", "disable-transitions": "" }, { default: s(() => [y(n(e(_).VL[c]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : i("", true), e(l).visible("licensePlate") ? (a(), r(o, { key: "licensePlate", prop: "licensePlate", sortable: "custom", "show-overflow-tooltip": true, label: "车牌/船牌号", align: "center", "min-width": "100" })) : i("", true), e(l).visible("driverName") ? (a(), r(o, { key: "driverName", prop: "driverName", sortable: "custom", "show-overflow-tooltip": true, label: "司机姓名", align: "center", "min-width": "100" })) : i("", true), e(l).visible("driverPhone") ? (a(), r(o, { key: "driverPhone", prop: "driverPhone", "show-overflow-tooltip": true, label: "司机电话", align: "center", "min-width": "120" })) : i("", true), e(l).visible("auditUserName") ? (a(), r(o, { key: "auditUserName", prop: "auditUserName", sortable: "custom", "show-overflow-tooltip": true, label: "办理人", align: "center", "min-width": "100" })) : i("", true), e(l).visible("actualGrossWeight") ? (a(), r(o, { key: "actualGrossWeight", prop: "actualGrossWeight", "show-overflow-tooltip": true, label: "毛重（t）", align: "center", "min-width": "120" }, { default: s((t) => [p("span", null, n(e(m)(t.row.actualGrossWeight, "kg", "t", 3)), 1)]), _: 1 })) : i("", true), e(l).visible("emptyCars") ? (a(), r(o, { key: "emptyCars", prop: "emptyCars", "show-overflow-tooltip": true, label: "皮重（t）", align: "center", "min-width": "120" }, { default: s((t) => [p("span", null, n(e(m)(t.row.emptyCars, "kg", "t", 3)), 1)]), _: 1 })) : i("", true), e(l).visible("actualWeight") ? (a(), r(o, { key: "actualWeight", prop: "actualWeight", "show-overflow-tooltip": true, label: "净重（t）", align: "center", "min-width": "120" }, { default: s((t) => [p("span", null, n(e(m)(t.row.actualWeight, "kg", "t", 3)), 1)]), _: 1 })) : i("", true), e(l).visible("totalNetWeight") ? (a(), r(o, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "理论重量（t）", align: "center", "min-width": "120" }, { default: s((t) => [p("span", null, n(e(m)(t.row.totalNetWeight, "kg", "t", 3)), 1)]), _: 1 })) : i("", true), e(l).visible("difference") ? (a(), r(o, { key: "difference", prop: "difference", "show-overflow-tooltip": true, label: "差值（t）", align: "center", "min-width": "100" }, { default: s((t) => [p("span", { style: W({ color: t.row.acceptDifference ? "#13ce66" : "#ff4949" }) }, n(e(m)(t.row.difference, "kg", "t", 3)), 5)]), _: 1 })) : i("", true), e(l).visible("differenceRate") ? (a(), r(o, { key: "differenceRate", prop: "differenceRate", "show-overflow-tooltip": true, label: "差值率", align: "center", "min-width": "100" }, { default: s((t) => [p("span", { style: W({ color: t.row.acceptDifference ? "#13ce66" : "#ff4949" }) }, n(t.row.differenceRate), 5)]), _: 1 })) : i("", true), e(l).visible("totalGrossWeight") ? (a(), r(o, { label: "构件毛重", align: "center", prop: "totalGrossWeight", key: "totalGrossWeight", "show-overflow-tooltip": true }, { default: s((t) => [p("span", null, n(t.row.totalGrossWeight ? e(m)(t.row.totalGrossWeight, "kg", "t", 3) : "-"), 1)]), _: 1 })) : i("", true), e(l).visible("status") ? (a(), r(o, { key: "status", prop: "status", label: "状态", align: "center", width: "100px" }, { default: s((t) => [t.row.status ? (a(), r(g, { key: 0, type: e(P).V[t.row.status].T, effect: "plain" }, { default: s(() => [y(n(e(P).V[t.row.status].OL), 1)]), _: 2 }, 1032, ["type"])) : i("", true)]), _: 1 })) : i("", true), e(l).visible("remark") ? (a(), r(o, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", align: "center", "min-width": "100" }, { default: s((t) => [y(n(t.row.remark ? t.row.remark : "-"), 1)]), _: 1 })) : i("", true), e(te)([...e(V).detail]) ? (a(), r(o, { key: 19, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: s((t) => [d(H, { type: "primary", icon: "el-icon-view", size: "default", onClick: F((c) => L(t.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "max-height", "data-format", "onSortChange", "onSelectionChange"])), [[O, e(u).loading]]), d(e(ae)), d(e(ie), { visible: w.value, "onUpdate:visible": N[0] || (N[0] = (t) => w.value = t), "detail-info": T.value, projectType: e(u).query.projectType, onRefresh: e(u).toQuery }, null, 8, ["visible", "detail-info", "projectType", "onRefresh"])]);
  };
} }, ge = J(ne, [["__scopeId", "data-v-8ae8cd4e"]]);
export {
  ge as default
};
