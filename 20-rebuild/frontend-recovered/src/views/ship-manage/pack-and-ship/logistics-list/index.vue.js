import { ref as w } from "vue";
import { provide as q } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as h } from "vue";
import { createBlock as a } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as n } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as _ } from "vue";
import { Fragment as G } from "vue";
import { renderList as Q } from "vue";
import { normalizeClass as K } from "vue";
import { ElTableColumn as J } from "element-plus";
import { ElTag as X } from "element-plus";
import { vLoading as Y } from "element-plus";
import { g as Z } from "../../../../modules/logistics-list-4584a3aa.js";
import { _ as ee, t as te, x as re, m as ae, o as oe, mx as le, bx as U, bz as F, z as ie, c as se, D as ne, bA as L, aN as pe, bv as ue, bi as g, bB as T, bs as B, P as ce } from "../../../../shared/runtime.js";
import { l as k } from "../../../../modules/ship-manage-3066b2ed.js";
import me from "./module/header.vue.js";
import de from "./module/form.vue.js";
import "./module/logistics-fee-setting/index.vue.js";
import "../../../../modules/base-6bc46ddf.js";
import "./module/logistics-fee-setting/module/header.vue.js";
import "./module/logistics-fee-setting/module/form.vue.js";
import "./module/logistics-fee-setting/module/price-all-detail.vue.js";
const fe = { class: "app-container" }, we = { class: "project-name" }, he = { __name: "index", setup(_e) {
  const { decimalPrecision: x } = te(), M = { add: false, edit: false, del: false, download: false }, N = w(), y = w(false), C = w({}), P = w(), { crud: c, CRUD: z, columns: s } = re({ title: "物流记录", sort: ["auditTime.desc"], permission: { ...k }, crudApi: { get: Z }, optShow: { ...M }, invisibleColumns: ["manufactureType", "productType", "serialNumber"] }, N), { currentProjectType: A } = ae(["currentProjectType"]), { maxHeight: I } = oe({ paginate: true }), { projects: W } = le();
  q("projects", W);
  function V(d, f) {
    P.value = f, C.value = d == null ? void 0 : d.sourceRow, y.value = true;
  }
  return z.HOOK.beforeToQuery = () => {
    c.query.projectType = A.value;
  }, (d, f) => {
    const j = v("table-cell-tag"), l = J, b = X, E = v("common-button"), H = v("common-table"), O = R("parse-time"), S = R("permission"), $ = Y;
    return r(), D("div", fe, [u(e(me)), h((r(), a(H, { ref_key: "tableRef", ref: N, data: e(c).data, style: { width: "100%" }, "max-height": e(I), onSortChange: e(c).handleSortChange }, { default: o(() => [u(l, { label: "序号", align: "center", width: "55" }, { default: o((t) => [p("span", null, n(t.$index + 1), 1), u(j, { show: t.row.deliveryStatus === e(U).RETURN.V && t.row.changeFreight === e(F).CANCEL.V, name: "已作废", color: "#f56c6c" }, null, 8, ["show"])]), _: 1 }), e(s).visible("supplier.name") ? (r(), a(l, { key: "supplier.name", prop: "supplier.name", "show-overflow-tooltip": true, label: "物流公司", "min-width": "140" }, { default: o((t) => [p("span", null, n(t.row.supplier && t.row.supplier.name), 1)]), _: 1 })) : i("", true), e(s).visible("project.shortName") ? (r(), a(l, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "承运项目", "min-width": "250" }, { default: o((t) => [p("span", we, n(e(ie)(t.row.project)), 1)]), _: 1 })) : i("", true), e(s).visible("carModel") ? (r(), a(l, { key: 2, "show-overflow-tooltip": true, prop: "carModel", label: "车型", align: "center" }, { default: o((t) => [p("span", null, n(t.row.carModel), 1)]), _: 1 })) : i("", true), e(s).visible("licensePlate") ? (r(), a(l, { key: "licensePlate", prop: "licensePlate", sortable: "custom", "show-overflow-tooltip": true, label: "车牌/船牌号", align: "center", width: "120" }, { default: o((t) => [t.row.shipmentStatus === "取消送货" ? (r(), a(j, { key: 0, name: "取消送货", color: "#e64242", offset: 15 })) : i("", true), p("span", null, n(t.row.licensePlate), 1)]), _: 1 })) : i("", true), e(s).visible("driverName") ? (r(), a(l, { key: "driverName", prop: "driverName", sortable: "custom", "show-overflow-tooltip": true, label: "司机姓名", align: "center", width: "100" })) : i("", true), e(s).visible("driverPhone") ? (r(), a(l, { key: "driverPhone", prop: "driverPhone", "show-overflow-tooltip": true, label: "司机电话", align: "center", "min-width": "120" })) : i("", true), e(s).visible("actualWeight") ? (r(), a(l, { key: 6, "show-overflow-tooltip": true, prop: "actualWeight", label: "装载重量(t)", align: "center", width: "120" }, { default: o((t) => [p("span", null, n(e(se)(t.row.actualWeight, "kg", "t", e(ne).COM_WT__T)), 1)]), _: 1 })) : i("", true), e(s).visible("manufactureType") ? (r(), a(l, { key: "manufactureType", prop: "manufactureType", "show-overflow-tooltip": true, label: "制造类型", align: "center", "min-width": "80" }, { default: o((t) => [u(b, { type: e(L).V[t.row.manufactureType].T, effect: "plain", "disable-transitions": "" }, { default: o(() => [_(n(e(L).VL[t.row.manufactureType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : i("", true), e(s).visible("productType") ? (r(), a(l, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: o((t) => [(r(true), D(G, null, Q(e(pe)(e(ue).getBits(e(g), t.row.productType, "V")), (m) => (r(), a(b, { style: { "margin-right": "5px" }, key: m, type: e(g).V[m].T, effect: "light", "disable-transitions": "" }, { default: o(() => [_(n(e(g).VL[m]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : i("", true), e(s).visible("serialNumber") ? (r(), a(l, { key: "serialNumber", prop: "serialNumber", sortable: "custom", label: "车次/船次", align: "center", "min-width": "140px" }, { default: o((t) => [u(b, { effect: "light", "disable-transitions": "", style: { width: "100%", "max-width": "130px" } }, { default: o(() => [_(n(t.row.serialNumber), 1)]), _: 2 }, 1024)]), _: 1 })) : i("", true), u(l, { prop: "priceType", label: "计价方式", align: "center" }, { default: o((t) => [p("span", null, n(e(T).VL[t.row.priceType]), 1)]), _: 1 }), e(s).visible("supplier.price") ? (r(), a(l, { key: 10, "show-overflow-tooltip": true, prop: "supplier.price", label: "运输单价", align: "right", "min-width": "120" }, { default: o((t) => [p("span", null, n(t.row.supplier && e(B)(t.row.supplier.price, e(x).shipment)), 1), p("span", { class: K(t.row.priceType === e(T).WEIGHT.V ? "blue" : "orange"), style: { "margin-left": "3px" } }, n(e(T).V[t.row.priceType].unit), 3)]), _: 1 })) : i("", true), e(s).visible("totalPrice") ? (r(), a(l, { key: 11, "show-overflow-tooltip": true, prop: "totalPrice", label: "运输费(元)", align: "right", "min-width": "120" }, { default: o((t) => [p("span", null, n(e(B)(t.row.totalPrice, e(x).shipment)), 1)]), _: 1 })) : i("", true), e(s).visible("actualUserName") ? (r(), a(l, { key: 12, "show-overflow-tooltip": true, prop: "actualUserName", label: "发货人", align: "center", width: "120" })) : i("", true), e(s).visible("auditTime") ? (r(), a(l, { key: "auditTime", prop: "auditTime", sortable: "custom", label: "承运日期", width: "120" }, { default: o((t) => [h(p("span", null, null, 512), [[O, { val: t.row.auditTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : i("", true), e(s).visible("remark") ? (r(), a(l, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", align: "center", "min-width": "100" }, { default: o((t) => [_(n(t.row.remark ? t.row.remark : "-"), 1)]), _: 1 })) : i("", true), u(l, { label: "操作", width: "140px", align: "center", fixed: "right" }, { default: o((t) => [t.row.deliveryStatus === e(U).RETURN.V && t.row.changeFreight === e(F).CANCEL.V ? i("", true) : h((r(), a(E, { key: 0, size: "default", icon: "el-icon-edit", type: "primary", onClick: (m) => V(t.row, "edit") }, null, 8, ["onClick"])), [[S, e(k).edit]]), h(u(E, { size: "default", icon: "el-icon-view", type: "primary", onClick: (m) => V(t.row, "detail") }, null, 8, ["onClick"]), [[S, e(k).get]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "onSortChange"])), [[$, e(c).loading]]), u(e(ce)), u(e(de), { modelValue: y.value, "onUpdate:modelValue": f[0] || (f[0] = (t) => y.value = t), detailInfo: C.value, showType: P.value, projectType: e(c).query.projectType, onSuccess: e(c).toQuery }, null, 8, ["modelValue", "detailInfo", "showType", "projectType", "onSuccess"])]);
  };
} }, je = ee(he, [["__scopeId", "data-v-a6222281"]]);
export {
  je as default
};
