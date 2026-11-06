import { ref as _ } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as l } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as f } from "vue";
import { Fragment as F } from "vue";
import { renderList as H } from "vue";
import { normalizeStyle as P } from "vue";
import { withModifiers as L } from "vue";
import { ElTableColumn as O } from "element-plus";
import { ElTag as q } from "element-plus";
import { vLoading as I } from "element-plus";
import { c as $, m as G, d as J } from "./module/header.vue.js";
import { t as R } from "../../../../modules/bridge-86f96a4f.js";
import { x as K, o as Q, bx as V, z as X, bA as W, aN as Y, bv as Z, bw as v, c as g, D as y, G as ee, P as te } from "../../../../shared/runtime.js";
import ae from "../components/common-detail/index.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../components/common-detail/module/structure.vue.js";
import "../components/common-detail/module/enclosure.vue.js";
import "../components/common-detail/module/auxiliary-material.vue.js";
const ie = { class: "app-container" }, oe = { class: "project-name" }, le = { style: { width: "150px", height: "53px", overflow: "hidden", position: "absolute", top: "-18px", left: "-20px" } }, _e = { __name: "index", setup(re) {
  const j = { add: false, edit: false, del: false, download: false }, T = _(), { crud: d, columns: n } = K({ title: "发运记录", sort: ["auditTime.desc"], permission: { ...R }, crudApi: { ...$ }, optShow: { ...j } }, T), { maxHeight: D } = Q({ paginate: true }), w = _(false), p = _({});
  function E(N) {
    p.value = N, w.value = true;
  }
  return (N, k) => {
    const o = O, x = b("table-cell-tag"), m = q, U = b("common-button"), z = b("common-table"), M = A("parse-time"), B = I;
    return a(), C("div", ie, [s(e(G)), S((a(), l(z, { ref_key: "tableRef", ref: T, data: e(d).data, style: { width: "100%" }, "max-height": e(D), onSortChange: e(d).handleSortChange, onSelectionChange: e(d).selectionChangeHandler }, { default: i(() => [s(o, { type: "selection", width: "55", align: "center" }), s(o, { label: "序号", type: "index", align: "center", width: "60" }), e(n).visible("serialNumber") ? (a(), l(o, { key: "serialNumber", prop: "serialNumber", sortable: "custom", label: "车次/船次", align: "center", "min-width": "140px" }, { default: i((t) => [s(x, { show: t.row.deliveryStatus === e(V).RETURN.V, name: "已取消", color: "#f56c6c" }, null, 8, ["show"]), u("span", null, c(t.row.serialNumber), 1)]), _: 1 })) : r("", true), e(n).visible("auditTime") ? (a(), l(o, { key: "auditTime", prop: "auditTime", sortable: "custom", label: "发运日期", width: "120" }, { default: i((t) => [S(u("span", null, null, 512), [[M, { val: t.row.auditTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : r("", true), e(n).visible("project.shortName") && !e(d).query.projectId ? (a(), l(o, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "250" }, { default: i((t) => [u("span", oe, c(e(X)(t.row.project)), 1)]), _: 1 })) : r("", true), e(n).visible("manufactureType") ? (a(), l(o, { key: "manufactureType", prop: "manufactureType", "show-overflow-tooltip": true, label: "制造类型", align: "center", "min-width": "80" }, { default: i((t) => [s(m, { type: e(W).V[t.row.manufactureType].T, effect: "plain", "disable-transitions": "" }, { default: i(() => [f(c(e(W).VL[t.row.manufactureType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : r("", true), e(n).visible("productType") ? (a(), l(o, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: i((t) => [(a(true), C(F, null, H(e(Y)(e(Z).getBits(e(v), t.row.productType, "V")), (h) => (a(), l(m, { style: { "margin-right": "5px" }, key: h, type: e(v).V[h].T, effect: "light", "disable-transitions": "" }, { default: i(() => [f(c(e(v).VL[h]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : r("", true), e(n).visible("licensePlate") ? (a(), l(o, { key: "licensePlate", prop: "licensePlate", sortable: "custom", "show-overflow-tooltip": true, label: "车牌/船牌号", align: "center", "min-width": "100" })) : r("", true), e(n).visible("driverName") ? (a(), l(o, { key: "driverName", prop: "driverName", sortable: "custom", "show-overflow-tooltip": true, label: "司机姓名", align: "center", "min-width": "100" })) : r("", true), e(n).visible("driverPhone") ? (a(), l(o, { key: "driverPhone", prop: "driverPhone", "show-overflow-tooltip": true, label: "司机电话", align: "center", "min-width": "120" })) : r("", true), e(n).visible("auditUserName") ? (a(), l(o, { key: "auditUserName", prop: "auditUserName", sortable: "custom", "show-overflow-tooltip": true, label: "办理人", align: "center", "min-width": "100" })) : r("", true), e(n).visible("totalNetWeight") ? (a(), l(o, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "理论重量（t）", align: "center", "min-width": "120" }, { default: i((t) => [u("span", null, c(e(g)(t.row.totalNetWeight, "kg", "t", e(y).COM_WT__T)), 1)]), _: 1 })) : r("", true), e(n).visible("actualWeight") ? (a(), l(o, { key: "actualWeight", prop: "actualWeight", "show-overflow-tooltip": true, label: "过磅重量（t）", align: "center", "min-width": "120" }, { default: i((t) => [u("span", null, c(e(g)(t.row.actualWeight, "kg", "t", e(y).COM_WT__T)), 1)]), _: 1 })) : r("", true), e(n).visible("difference") ? (a(), l(o, { key: "difference", prop: "difference", "show-overflow-tooltip": true, label: "差值（t）", align: "center", "min-width": "100" }, { default: i((t) => [u("span", { style: P({ color: t.row.acceptDifference ? "#13ce66" : "#ff4949" }) }, c(e(g)(t.row.difference, "kg", "t", e(y).COM_WT__T)), 5)]), _: 1 })) : r("", true), e(n).visible("differenceRate") ? (a(), l(o, { key: "differenceRate", prop: "differenceRate", "show-overflow-tooltip": true, label: "差值率", align: "center", "min-width": "100" }, { default: i((t) => [u("span", { style: P({ color: t.row.acceptDifference ? "#13ce66" : "#ff4949" }) }, c(t.row.differenceRate), 5)]), _: 1 })) : r("", true), e(ee)([...e(R).detail]) ? (a(), l(o, { key: 13, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: i((t) => [s(U, { type: "primary", icon: "el-icon-view", size: "default", onClick: L((h) => E(t.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "max-height", "onSortChange", "onSelectionChange"])), [[B, e(d).loading]]), s(e(te)), s(e(ae), { visible: w.value, "onUpdate:visible": k[0] || (k[0] = (t) => w.value = t), "detail-info": p.value, title: "装车详情", detailFunc: e(J) }, { tip: i(() => [u("div", le, [s(x, { show: p.value.deliveryStatus === e(V).RETURN.V, name: "已取消", color: "#f56c6c" }, null, 8, ["show"])]), s(m, { effect: "plain", size: "large", type: "danger" }, { default: i(() => [f("车次/船次：" + c(p.value.serialNumber), 1)]), _: 1 }), s(m, { effect: "plain", size: "large" }, { default: i(() => [f("项目：" + c(p.value.project && p.value.project.shortName), 1)]), _: 1 }), s(m, { effect: "plain", size: "large", type: "success" }, { default: i(() => [f("办理人：" + c(p.value.auditUserName), 1)]), _: 1 })]), _: 1 }, 8, ["visible", "detail-info", "detailFunc"])]);
  };
} };
export {
  _e as default
};
