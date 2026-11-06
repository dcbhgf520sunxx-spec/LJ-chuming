import { ref as _ } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as h } from "vue";
import { createBlock as r } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as g } from "vue";
import { Fragment as $ } from "vue";
import { renderList as H } from "vue";
import { normalizeClass as O } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElTag as G } from "element-plus";
import { vLoading as Q } from "element-plus";
import { c as J } from "../../../../modules/logistics-list-3b33cbe0.js";
import { l as v } from "../../../../modules/bridge-86f96a4f.js";
import { _ as K, t as X, x as Y, o as Z, bx as L, bz as j, z as ee, c as te, D as ae, bA as F, aN as oe, bv as le, bi as T, bB as k, bs as A, P as re } from "../../../../shared/runtime.js";
import ie from "./module/header.vue.js";
import ne from "./module/form.vue.js";
import "./module/logistics-fee-setting/index.vue.js";
import "../../../../modules/base-6bc46ddf.js";
import "./module/logistics-fee-setting/module/header.vue.js";
import "./module/logistics-fee-setting/module/form.vue.js";
import "./module/logistics-fee-setting/module/price-all-detail.vue.js";
const se = { class: "app-container" }, pe = { class: "project-name" }, ue = { __name: "index", setup(ce) {
  const { decimalPrecision: x } = X(), B = { add: false, edit: false, del: false, download: false }, C = _(), b = _(false), N = _({}), V = _(), { crud: d, columns: n } = Y({ title: "物流记录", sort: ["auditTime.desc"], permission: { ...v }, crudApi: { ...J }, optShow: { ...B }, invisibleColumns: ["manufactureType", "productType", "serialNumber"] }, C), { maxHeight: M } = Z({ paginate: true });
  function P(m, f) {
    V.value = f, N.value = m == null ? void 0 : m.sourceRow, b.value = true;
  }
  return (m, f) => {
    const z = y("table-cell-tag"), l = q, w = G, E = y("common-button"), I = y("common-table"), U = R("parse-time"), S = R("permission"), W = Q;
    return a(), D("div", se, [p(e(ie)), h((a(), r(I, { ref_key: "tableRef", ref: C, data: e(d).data, style: { width: "100%" }, "max-height": e(M), onSortChange: e(d).handleSortChange }, { default: o(() => [p(l, { label: "序号", align: "center", width: "55" }, { default: o((t) => [u("span", null, s(t.$index + 1), 1), p(z, { show: t.row.deliveryStatus === e(L).RETURN.V && t.row.changeFreight === e(j).CANCEL.V, name: "已作废", color: "#f56c6c" }, null, 8, ["show"])]), _: 1 }), e(n).visible("supplier.name") ? (a(), r(l, { key: "supplier.name", prop: "supplier.name", "show-overflow-tooltip": true, label: "物流公司", "min-width": "140" }, { default: o((t) => [u("span", null, s(t.row.supplier && t.row.supplier.name), 1)]), _: 1 })) : i("", true), e(n).visible("project.shortName") ? (a(), r(l, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "承运项目", "min-width": "250" }, { default: o((t) => [u("span", pe, s(e(ee)(t.row.project)), 1)]), _: 1 })) : i("", true), e(n).visible("carModel") ? (a(), r(l, { key: 2, "show-overflow-tooltip": true, prop: "carModel", label: "车型", align: "center" }, { default: o((t) => [u("span", null, s(t.row.carModel), 1)]), _: 1 })) : i("", true), e(n).visible("licensePlate") ? (a(), r(l, { key: "licensePlate", prop: "licensePlate", sortable: "custom", "show-overflow-tooltip": true, label: "车牌/船牌号", align: "center" })) : i("", true), e(n).visible("driverName") ? (a(), r(l, { key: "driverName", prop: "driverName", sortable: "custom", "show-overflow-tooltip": true, label: "司机姓名", align: "center", width: "100" })) : i("", true), e(n).visible("driverPhone") ? (a(), r(l, { key: "driverPhone", prop: "driverPhone", "show-overflow-tooltip": true, label: "司机电话", align: "center", "min-width": "120" })) : i("", true), e(n).visible("actualWeight") ? (a(), r(l, { key: 6, "show-overflow-tooltip": true, prop: "actualWeight", label: "装载重量(t)", align: "center" }, { default: o((t) => [u("span", null, s(e(te)(t.row.actualWeight, "kg", "t", e(ae).COM_WT__T)), 1)]), _: 1 })) : i("", true), e(n).visible("manufactureType") ? (a(), r(l, { key: "manufactureType", prop: "manufactureType", "show-overflow-tooltip": true, label: "制造类型", align: "center", "min-width": "80" }, { default: o((t) => [p(w, { type: e(F).V[t.row.manufactureType].T, effect: "plain", "disable-transitions": "" }, { default: o(() => [g(s(e(F).VL[t.row.manufactureType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : i("", true), e(n).visible("productType") ? (a(), r(l, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: o((t) => [(a(true), D($, null, H(e(oe)(e(le).getBits(e(T), t.row.productType, "V")), (c) => (a(), r(w, { style: { "margin-right": "5px" }, key: c, type: e(T).V[c].T, effect: "light", "disable-transitions": "" }, { default: o(() => [g(s(e(T).VL[c]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : i("", true), e(n).visible("serialNumber") ? (a(), r(l, { key: "serialNumber", prop: "serialNumber", sortable: "custom", label: "车次/船次", align: "center", "min-width": "140px" }, { default: o((t) => [p(w, { effect: "light", "disable-transitions": "", style: { width: "100%", "max-width": "130px" } }, { default: o(() => [g(s(t.row.serialNumber), 1)]), _: 2 }, 1024)]), _: 1 })) : i("", true), p(l, { prop: "priceType", label: "计价方式", align: "center" }, { default: o((t) => [u("span", null, s(e(k).VL[t.row.priceType]), 1)]), _: 1 }), e(n).visible("supplier.price") ? (a(), r(l, { key: 10, "show-overflow-tooltip": true, prop: "supplier.price", label: "运输单价", align: "right", "min-width": "120" }, { default: o((t) => [u("span", null, s(t.row.supplier && e(A)(t.row.supplier.price, e(x).bridge)), 1), u("span", { class: O(t.row.priceType === e(k).WEIGHT.V ? "blue" : "orange"), style: { "margin-left": "3px" } }, s(e(k).V[t.row.priceType].unit), 3)]), _: 1 })) : i("", true), e(n).visible("totalPrice") ? (a(), r(l, { key: 11, "show-overflow-tooltip": true, prop: "totalPrice", label: "运输费(元)", align: "right", "min-width": "120" }, { default: o((t) => [u("span", null, s(e(A)(t.row.totalPrice, e(x).bridge)), 1)]), _: 1 })) : i("", true), e(n).visible("auditTime") ? (a(), r(l, { key: "auditTime", prop: "auditTime", sortable: "custom", label: "承运日期", width: "120" }, { default: o((t) => [h(u("span", null, null, 512), [[U, { val: t.row.auditTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : i("", true), p(l, { label: "操作", width: "140px", align: "center", fixed: "right" }, { default: o((t) => [t.row.deliveryStatus === e(L).RETURN.V && t.row.changeFreight === e(j).CANCEL.V ? i("", true) : h((a(), r(E, { key: 0, size: "default", icon: "el-icon-edit", type: "primary", onClick: (c) => P(t.row, "edit") }, null, 8, ["onClick"])), [[S, e(v).edit]]), h(p(E, { size: "default", icon: "el-icon-view", type: "primary", onClick: (c) => P(t.row, "detail") }, null, 8, ["onClick"]), [[S, e(v).get]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "onSortChange"])), [[W, e(d).loading]]), p(e(re)), p(e(ne), { modelValue: b.value, "onUpdate:modelValue": f[0] || (f[0] = (t) => b.value = t), detailInfo: N.value, showType: V.value, onSuccess: e(d).toQuery }, null, 8, ["modelValue", "detailInfo", "showType", "onSuccess"])]);
  };
} }, ke = K(ue, [["__scopeId", "data-v-908e13d2"]]);
export {
  ke as default
};
