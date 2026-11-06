import { ref as c } from "vue";
import { computed as x } from "vue";
import { watch as G } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as u } from "vue";
import { createBlock as F } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as t } from "vue";
import { unref as n } from "vue";
import { toDisplayString as D } from "vue";
import { createElementBlock as E } from "vue";
import { createCommentVNode as T } from "vue";
import { resolveDynamicComponent as H } from "vue";
import { isRef as $ } from "vue";
import { ElCol as z } from "element-plus";
import { ElRow as U } from "element-plus";
import { ElDivider as q } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { _ as K, t as Q, u as W, c1 as V, G as X } from "../../../../shared/runtime.js";
import { A as Y } from "../../../../modules/contract-9b18cc88.js";
import Z from "./module/main-material-fee.vue.js";
import ee from "./module/labor-fee.vue.js";
import te from "./module/auxiliary-material-fee.vue.js";
import oe from "./module/water-electric-fee.vue.js";
import ae from "./module/depreciation-fee.vue.js";
import ne from "./module/management-fee.vue.js";
import le from "./module/shipping-fee.vue.js";
import ie from "./module/testing-fee.vue.js";
import re from "./module/subcontracting-fee.vue.js";
import { P as w } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/detail-fee-ef8adaab.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const se = { style: { display: "flex" } }, ce = { style: { width: "36%" } }, me = { style: { width: "62%" } }, de = { key: 0, class: "my-code" }, ue = { key: 1 }, pe = { __name: "index", props: { visible: { type: Boolean, default: false }, detailRow: { type: Object, default: () => {
} }, settlementStatus: { type: Number } }, emits: ["update:visible"], setup(r, { emit: A }) {
  const { decimalPrecision: d } = Q(), _ = Y.cost, s = c({}), P = c(), O = c(), S = c(), k = c([{ key: "mainMaterialFee", name: "主材费", components: Z }, { key: "laborFee", name: "人工费", components: ee }, { key: "auxiliaryMaterialFee", name: "辅材费", components: te }, { key: "transportationFee", name: "运输费", components: le }, { key: "testingFee", name: "检测费", components: ie }, { key: "subFee", name: "分包费", components: re }]), R = c([{ key: "waterElectricityGasFee", name: "水电费", components: oe }, { key: "depreciationFee", name: "折旧费", components: ae }, { key: "managementFee", name: "管理费", components: ne }]), B = A, o = r, b = x(() => [["rate", ["to-fixed", 2]], ["amount", ["to-thousand", d.value.contract]]]);
  G(() => o.detailRow.id, (f) => {
    k.value.map((e) => (e.amount = o.detailRow.compositeCostDTO && o.detailRow.compositeCostDTO[e.key] ? o.detailRow.compositeCostDTO[e.key] : 0, e.rate = e.amount && o.detailRow.costAmount ? e.amount / o.detailRow.costAmount * 100 : 0, e.projectId = o.detailRow.id, e)), R.value.map((e) => (e.amount = o.detailRow.compositeCostDTO && o.detailRow.compositeCostDTO[e.key] ? o.detailRow.compositeCostDTO[e.key] : 0, e.rate = e.amount && o.detailRow.costAmount ? e.amount / o.detailRow.costAmount * 100 : 0, e.projectId = o.detailRow.id, e));
  }, { immediate: true });
  const M = x(() => s.value.components), { visible: p, handleClose: N } = W({ emit: B, props: o, field: "visible", showHook: j });
  function j() {
    s.value = {};
  }
  function g(f) {
    if (!X(_.detail)) return false;
    s.value = f;
  }
  return (f, e) => {
    const y = z, I = U, v = q, l = J, h = C("common-table"), L = C("common-drawer");
    return u(), F(L, { ref: "drawerRef", title: `${r.detailRow.serialNumber} ${r.detailRow.name} 成本明细`, modelValue: n(p), "onUpdate:modelValue": e[0] || (e[0] = (m) => $(p) ? p.value = m : null), direction: "rtl", "before-close": n(N), size: "100%" }, { content: a(() => [i("div", se, [i("div", ce, [t(I, { gutter: 20, class: "panel-group" }, { default: a(() => [t(y, { span: 8, class: "card-panel-col" }, { default: a(() => [t(n(w), { name: o.settlementStatus === n(V).SETTLED.V ? "结算额" : "合同额", "text-color": "#626262", "num-color": "#1890ff", "end-val": o.settlementStatus === n(V).SETTLED.V ? r.detailRow.settlementAmount : r.detailRow.contractAmount, precision: n(d).contract }, null, 8, ["name", "end-val", "precision"])]), _: 1 }), t(y, { span: 8, class: "card-panel-col" }, { default: a(() => [t(n(w), { name: "综合成本", "text-color": "#626262", "num-color": "#F56C6C", "end-val": r.detailRow.costAmount || 0, precision: n(d).contract }, null, 8, ["end-val", "precision"])]), _: 1 }), t(y, { span: 8, class: "card-panel-col" }, { default: a(() => [t(n(w), { name: "毛利润", "text-color": "#626262", "num-color": "#1890ff", "end-val": r.detailRow.grossProfit || 0, precision: n(d).contract }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 }), t(v, null, { default: a(() => e[1] || (e[1] = [i("span", { class: "title" }, "直接费用", -1)])), _: 1, __: [1] }), t(h, { ref_key: "directRef", ref: O, "highlight-current-row": "", data: k.value, style: { width: "100%" }, "row-key": "id", "data-format": b.value, onRowClick: g }, { default: a(() => [t(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(l, { prop: "name", key: "name", label: "项目", align: "center" }), t(l, { prop: "amount", key: "amount", label: "金额（元）", align: "center" }), t(l, { prop: "rate", key: "rate", label: "占比", align: "center" }, { default: a((m) => [i("span", null, D(m.row.rate) + "%", 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format"]), t(v, null, { default: a(() => e[2] || (e[2] = [i("span", { class: "title" }, "间接费用", -1)])), _: 1, __: [2] }), t(h, { ref_key: "indirectRef", ref: S, "highlight-current-row": "", data: R.value, style: { width: "100%" }, "row-key": "id", "data-format": b.value, onRowClick: g }, { default: a(() => [t(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(l, { prop: "name", key: "name", label: "项目", align: "center" }), t(l, { prop: "amount", key: "amount", label: "金额（元）", align: "center" }), t(l, { prop: "rate", key: "rate", label: "占比", align: "center" }, { default: a((m) => [i("span", null, D(m.row.rate) + "%", 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format"])]), e[3] || (e[3] = i("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 180px)" } }, null, -1)), i("div", me, [s.value.key ? T("", true) : (u(), E("div", de, "*点击左侧表格行查看详情")), s.value.key ? (u(), E("div", ue, [(u(), F(H(M.value), { ref_key: "detailRef", ref: P, "cost-type-data": s.value, permission: n(_) }, null, 8, ["cost-type-data", "permission"]))])) : T("", true)])])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Te = K(pe, [["__scopeId", "data-v-8c832cf5"]]);
export {
  Te as default
};
