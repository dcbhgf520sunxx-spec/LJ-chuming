import { ref as b } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as l } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as f } from "vue";
import { Fragment as A } from "vue";
import { renderList as F } from "vue";
import { normalizeStyle as S } from "vue";
import { withModifiers as H } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElTag as M } from "element-plus";
import { vLoading as q } from "element-plus";
import { c as I, d as $ } from "../../../../modules/ship-list-822ce00f.js";
import { x as O, ol as R, o as J, bx as V, z as K, bA as W, aN as Q, bv as X, bi as y, c as h, G as Y, P as Z } from "../../../../shared/runtime.js";
import ee from "./module/header.vue.js";
import te from "../components/common-detail/index.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../components/common-detail/module/structure.vue.js";
import "../components/common-detail/module/part.vue.js";
import "../components/common-detail/module/auxiliary-material.vue.js";
const ae = { class: "app-container" }, oe = { class: "project-name" }, ie = { style: { width: "150px", height: "53px", overflow: "hidden", position: "absolute", top: "-18px", left: "-20px" } }, we = { __name: "index", setup(le) {
  const j = { add: false, edit: false, del: false, download: false }, _ = b(), { crud: d, columns: n } = O({ title: "发运记录", sort: ["auditTime.desc"], permission: { ...R }, crudApi: { ...I }, optShow: { ...j } }, _), { maxHeight: P } = J({ paginate: true }), g = b(false), p = b({});
  function E(k) {
    p.value = k, g.value = true;
  }
  return (k, N) => {
    const i = L, T = v("table-cell-tag"), m = M, U = v("common-button"), D = v("common-table"), z = G("parse-time"), B = q;
    return a(), x("div", ae, [c(e(ee)), C((a(), l(D, { ref_key: "tableRef", ref: _, data: e(d).data, style: { width: "100%" }, "max-height": e(P), onSortChange: e(d).handleSortChange, onSelectionChange: e(d).selectionChangeHandler }, { default: o(() => [c(i, { type: "selection", width: "55", align: "center" }), c(i, { label: "序号", type: "index", align: "center", width: "60" }), e(n).visible("serialNumber") ? (a(), l(i, { key: "serialNumber", prop: "serialNumber", sortable: "custom", label: "车次/船次", align: "center", "min-width": "140px" }, { default: o((t) => [c(T, { show: t.row.deliveryStatus === e(V).RETURN.V, name: "已取消", color: "#f56c6c" }, null, 8, ["show"]), u("span", null, s(t.row.serialNumber), 1)]), _: 1 })) : r("", true), e(n).visible("auditTime") ? (a(), l(i, { key: "auditTime", prop: "auditTime", sortable: "custom", label: "发运日期", width: "120" }, { default: o((t) => [C(u("span", null, null, 512), [[z, { val: t.row.auditTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : r("", true), e(n).visible("project.shortName") && !e(d).query.projectId ? (a(), l(i, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "250" }, { default: o((t) => [u("span", oe, s(e(K)(t.row.project)), 1)]), _: 1 })) : r("", true), e(n).visible("manufactureType") ? (a(), l(i, { key: "manufactureType", prop: "manufactureType", "show-overflow-tooltip": true, label: "制造类型", align: "center", "min-width": "80" }, { default: o((t) => [c(m, { type: e(W).V[t.row.manufactureType].T, effect: "plain", "disable-transitions": "" }, { default: o(() => [f(s(e(W).VL[t.row.manufactureType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : r("", true), e(n).visible("productType") ? (a(), l(i, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: o((t) => [(a(true), x(A, null, F(e(Q)(e(X).getBits(e(y), t.row.productType, "V")), (w) => (a(), l(m, { style: { "margin-right": "5px" }, key: w, type: e(y).V[w].T, effect: "light", "disable-transitions": "" }, { default: o(() => [f(s(e(y).VL[w]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : r("", true), e(n).visible("licensePlate") ? (a(), l(i, { key: "licensePlate", prop: "licensePlate", sortable: "custom", "show-overflow-tooltip": true, label: "车牌/船牌号", align: "center", "min-width": "100" })) : r("", true), e(n).visible("driverName") ? (a(), l(i, { key: "driverName", prop: "driverName", sortable: "custom", "show-overflow-tooltip": true, label: "司机姓名", align: "center", "min-width": "100" })) : r("", true), e(n).visible("driverPhone") ? (a(), l(i, { key: "driverPhone", prop: "driverPhone", "show-overflow-tooltip": true, label: "司机电话", align: "center", "min-width": "120" })) : r("", true), e(n).visible("auditUserName") ? (a(), l(i, { key: "auditUserName", prop: "auditUserName", sortable: "custom", "show-overflow-tooltip": true, label: "办理人", align: "center", "min-width": "100" })) : r("", true), e(n).visible("actualGrossWeight") ? (a(), l(i, { key: "actualGrossWeight", prop: "actualGrossWeight", "show-overflow-tooltip": true, label: "毛重（t）", align: "center", "min-width": "120" }, { default: o((t) => [u("span", null, s(e(h)(t.row.actualGrossWeight, "kg", "t", 2)), 1)]), _: 1 })) : r("", true), e(n).visible("emptyCars") ? (a(), l(i, { key: "emptyCars", prop: "emptyCars", "show-overflow-tooltip": true, label: "皮重（t）", align: "center", "min-width": "120" }, { default: o((t) => [u("span", null, s(e(h)(t.row.emptyCars, "kg", "t", 2)), 1)]), _: 1 })) : r("", true), e(n).visible("actualWeight") ? (a(), l(i, { key: "actualWeight", prop: "actualWeight", "show-overflow-tooltip": true, label: "净重（t）", align: "center", "min-width": "120" }, { default: o((t) => [u("span", null, s(e(h)(t.row.actualWeight, "kg", "t", 2)), 1)]), _: 1 })) : r("", true), e(n).visible("totalNetWeight") ? (a(), l(i, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "理论重量（t）", align: "center", "min-width": "120" }, { default: o((t) => [u("span", null, s(e(h)(t.row.totalNetWeight, "kg", "t", 2)), 1)]), _: 1 })) : r("", true), e(n).visible("difference") ? (a(), l(i, { key: "difference", prop: "difference", "show-overflow-tooltip": true, label: "差值（t）", align: "center", "min-width": "100" }, { default: o((t) => [u("span", { style: S({ color: t.row.acceptDifference ? "#13ce66" : "#ff4949" }) }, s(e(h)(t.row.difference, "kg", "t", 2)), 5)]), _: 1 })) : r("", true), e(n).visible("differenceRate") ? (a(), l(i, { key: "differenceRate", prop: "differenceRate", "show-overflow-tooltip": true, label: "差值率", align: "center", "min-width": "100" }, { default: o((t) => [u("span", { style: S({ color: t.row.acceptDifference ? "#13ce66" : "#ff4949" }) }, s(t.row.differenceRate), 5)]), _: 1 })) : r("", true), e(Y)([...e(R).detail]) ? (a(), l(i, { key: 15, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: o((t) => [c(U, { type: "primary", icon: "el-icon-view", size: "default", onClick: H((w) => E(t.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "max-height", "onSortChange", "onSelectionChange"])), [[B, e(d).loading]]), c(e(Z)), c(e(te), { visible: g.value, "onUpdate:visible": N[0] || (N[0] = (t) => g.value = t), "detail-info": p.value, title: "装车详情", detailFunc: e($) }, { tip: o(() => [u("div", ie, [c(T, { show: p.value.deliveryStatus === e(V).RETURN.V, name: "已取消", color: "#f56c6c" }, null, 8, ["show"])]), c(m, { effect: "plain", size: "large", type: "danger" }, { default: o(() => [f("车次/船次：" + s(p.value.serialNumber), 1)]), _: 1 }), c(m, { effect: "plain", size: "large" }, { default: o(() => [f("项目：" + s(p.value.project && p.value.project.shortName), 1)]), _: 1 }), c(m, { effect: "plain", size: "large", type: "success" }, { default: o(() => [f("办理人：" + s(p.value.auditUserName), 1)]), _: 1 })]), _: 1 }, 8, ["visible", "detail-info", "detailFunc"])]);
  };
} };
export {
  we as default
};
