import { ref as _ } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as h } from "vue";
import { createBlock as i } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as v } from "vue";
import { Fragment as $ } from "vue";
import { renderList as H } from "vue";
import { normalizeClass as O } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElTag as G } from "element-plus";
import { vLoading as Q } from "element-plus";
import { c as J } from "../../../../modules/logistics-list-3bbba372.js";
import { _ as K, t as X, x as Y, ob as g, o as Z, bx as j, bz as F, z as ee, c as te, D as ae, bA as L, aN as le, bv as oe, bi as T, bB as k, bs as A, P as ie } from "../../../../shared/runtime.js";
import re from "./module/header.vue.js";
import ne from "./module/form.vue.js";
import "./module/logistics-fee-setting/index.vue.js";
import "../../../../modules/base-6bc46ddf.js";
import "./module/logistics-fee-setting/module/header.vue.js";
import "./module/logistics-fee-setting/module/form.vue.js";
import "./module/logistics-fee-setting/module/price-all-detail.vue.js";
const se = { class: "app-container" }, pe = { class: "project-name" }, ue = { __name: "index", setup(ce) {
  const { decimalPrecision: x } = X(), B = { add: false, edit: false, del: false, download: false }, C = _(), w = _(false), N = _({}), V = _(), { crud: d, columns: n } = Y({ title: "物流记录", sort: ["auditTime.desc"], permission: { ...g }, crudApi: { ...J }, optShow: { ...B }, invisibleColumns: ["manufactureType", "productType", "serialNumber"] }, C), { maxHeight: M } = Z({ paginate: true });
  function P(m, f) {
    V.value = f, N.value = m == null ? void 0 : m.sourceRow, w.value = true;
  }
  return (m, f) => {
    const z = y("table-cell-tag"), o = q, b = G, E = y("common-button"), I = y("common-table"), U = R("parse-time"), S = R("permission"), W = Q;
    return a(), D("div", se, [p(e(re)), h((a(), i(I, { ref_key: "tableRef", ref: C, data: e(d).data, style: { width: "100%" }, "max-height": e(M), onSortChange: e(d).handleSortChange }, { default: l(() => [p(o, { label: "序号", align: "center", width: "55" }, { default: l((t) => [u("span", null, s(t.$index + 1), 1), p(z, { show: t.row.deliveryStatus === e(j).RETURN.V && t.row.changeFreight === e(F).CANCEL.V, name: "已作废", color: "#f56c6c" }, null, 8, ["show"])]), _: 1 }), e(n).visible("supplier.name") ? (a(), i(o, { key: "supplier.name", prop: "supplier.name", "show-overflow-tooltip": true, label: "物流公司", "min-width": "140" }, { default: l((t) => [u("span", null, s(t.row.supplier && t.row.supplier.name), 1)]), _: 1 })) : r("", true), e(n).visible("project.shortName") ? (a(), i(o, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "承运项目", "min-width": "250" }, { default: l((t) => [u("span", pe, s(e(ee)(t.row.project)), 1)]), _: 1 })) : r("", true), e(n).visible("carModel") ? (a(), i(o, { key: 2, "show-overflow-tooltip": true, prop: "carModel", label: "车型", align: "center" }, { default: l((t) => [u("span", null, s(t.row.carModel), 1)]), _: 1 })) : r("", true), e(n).visible("licensePlate") ? (a(), i(o, { key: "licensePlate", prop: "licensePlate", sortable: "custom", "show-overflow-tooltip": true, label: "车牌/船牌号", align: "center" })) : r("", true), e(n).visible("driverName") ? (a(), i(o, { key: "driverName", prop: "driverName", sortable: "custom", "show-overflow-tooltip": true, label: "司机姓名", align: "center", width: "100" })) : r("", true), e(n).visible("driverPhone") ? (a(), i(o, { key: "driverPhone", prop: "driverPhone", "show-overflow-tooltip": true, label: "司机电话", align: "center", "min-width": "120" })) : r("", true), e(n).visible("actualWeight") ? (a(), i(o, { key: 6, "show-overflow-tooltip": true, prop: "actualWeight", label: "装载重量(t)", align: "center" }, { default: l((t) => [u("span", null, s(e(te)(t.row.actualWeight, "kg", "t", e(ae).COM_WT__T)), 1)]), _: 1 })) : r("", true), e(n).visible("manufactureType") ? (a(), i(o, { key: "manufactureType", prop: "manufactureType", "show-overflow-tooltip": true, label: "制造类型", align: "center", "min-width": "80" }, { default: l((t) => [p(b, { type: e(L).V[t.row.manufactureType].T, effect: "plain", "disable-transitions": "" }, { default: l(() => [v(s(e(L).VL[t.row.manufactureType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : r("", true), e(n).visible("productType") ? (a(), i(o, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: l((t) => [(a(true), D($, null, H(e(le)(e(oe).getBits(e(T), t.row.productType, "V")), (c) => (a(), i(b, { style: { "margin-right": "5px" }, key: c, type: e(T).V[c].T, effect: "light", "disable-transitions": "" }, { default: l(() => [v(s(e(T).VL[c]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : r("", true), e(n).visible("serialNumber") ? (a(), i(o, { key: "serialNumber", prop: "serialNumber", sortable: "custom", label: "车次/船次", align: "center", "min-width": "140px" }, { default: l((t) => [p(b, { effect: "light", "disable-transitions": "", style: { width: "100%", "max-width": "130px" } }, { default: l(() => [v(s(t.row.serialNumber), 1)]), _: 2 }, 1024)]), _: 1 })) : r("", true), p(o, { prop: "priceType", label: "计价方式", align: "center" }, { default: l((t) => [u("span", null, s(e(k).VL[t.row.priceType]), 1)]), _: 1 }), e(n).visible("supplier.price") ? (a(), i(o, { key: 10, "show-overflow-tooltip": true, prop: "supplier.price", label: "运输单价", align: "right", "min-width": "120" }, { default: l((t) => [u("span", null, s(t.row.supplier && e(A)(t.row.supplier.price, e(x).mes)), 1), u("span", { class: O(t.row.priceType === e(k).WEIGHT.V ? "blue" : "orange"), style: { "margin-left": "3px" } }, s(e(k).V[t.row.priceType].unit), 3)]), _: 1 })) : r("", true), e(n).visible("totalPrice") ? (a(), i(o, { key: 11, "show-overflow-tooltip": true, prop: "totalPrice", label: "运输费(元)", align: "right", "min-width": "120" }, { default: l((t) => [u("span", null, s(e(A)(t.row.totalPrice, e(x).mes)), 1)]), _: 1 })) : r("", true), e(n).visible("auditTime") ? (a(), i(o, { key: "auditTime", prop: "auditTime", sortable: "custom", label: "承运日期", width: "120" }, { default: l((t) => [h(u("span", null, null, 512), [[U, { val: t.row.auditTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : r("", true), p(o, { label: "操作", width: "140px", align: "center", fixed: "right" }, { default: l((t) => [t.row.deliveryStatus === e(j).RETURN.V && t.row.changeFreight === e(F).CANCEL.V ? r("", true) : h((a(), i(E, { key: 0, size: "default", icon: "el-icon-edit", type: "primary", onClick: (c) => P(t.row, "edit") }, null, 8, ["onClick"])), [[S, e(g).edit]]), h(p(E, { size: "default", icon: "el-icon-view", type: "primary", onClick: (c) => P(t.row, "detail") }, null, 8, ["onClick"]), [[S, e(g).get]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "onSortChange"])), [[W, e(d).loading]]), p(e(ie)), p(e(ne), { modelValue: w.value, "onUpdate:modelValue": f[0] || (f[0] = (t) => w.value = t), detailInfo: N.value, showType: V.value, onSuccess: e(d).toQuery }, null, 8, ["modelValue", "detailInfo", "showType", "onSuccess"])]);
  };
} }, Te = K(ue, [["__scopeId", "data-v-2ee694a3"]]);
export {
  Te as default
};
