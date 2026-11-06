import { ref as d } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { createElementVNode as g } from "vue";
import { withDirectives as b } from "vue";
import { createBlock as o } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as a } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as y } from "vue";
import { ElTableColumn as W } from "element-plus";
import { ElTag as q } from "element-plus";
import { vLoading as A } from "element-plus";
import { c as H } from "../../../../../modules/list-valuation-9a754659.js";
import { _ as G, jm as F, kP as K, kO as z, x as J, o as X, kQ as m, kD as R, G as Y, P as Z, V as S } from "../../../../../shared/runtime.js";
import { S as _ } from "../../../../../modules/contract-9b18cc88.js";
import ee from "./module/list-detail.vue.js";
import te from "./module/list-edit.vue.js";
import ie from "./module/view-left.vue.js";
import ne from "./module/header.vue.js";
import "./components/list-detail-table/structure.vue.js";
import "./components/list-detail-table/enclosure.vue.js";
import "./components/list-detail-table/auxiliary-material.vue.js";
import "./components/list-create-table/structure.vue.js";
import "./components/list-create-table/enclosure.vue.js";
import "./components/list-create-table/auxiliary-material.vue.js";
import "./module/list-drawer.vue.js";
import "./components/list-drawer-table/structure.vue.js";
import "./components/list-drawer-table/enclosure.vue.js";
import "./components/list-drawer-table/auxiliary-material.vue.js";
import "./module/list-create.vue.js";
const oe = { class: "app-container wrap" }, ae = { class: "wrap-right" }, re = { class: "head-container" }, le = { key: 0 }, pe = { __name: "index", setup(se) {
  const U = { add: false, edit: false, del: false, download: false }, j = d([["pricingMannerEnum", ["parse-enum", F, { f: "L" }]], ["pricingUnitTypeEnum", ["parse-enum", K, { f: "L" }]], ["pricingWeightTypeEnum", ["parse-enum", z, { f: "L" }]], ["project", "parse-project"]]), v = d(false), h = d(false), f = d({}), w = d(), { crud: s, columns: r, CRUD: M } = J({ title: "清单计价", sort: [], permission: { ..._ }, optShow: { ...U }, crudApi: { ...H } }, w), { maxHeight: k } = X({ paginate: true });
  M.HOOK.handleRefresh = (u, l) => {
    l.data.content = l.data.content.map((i) => (i.productType === m.STRUCTURE.V ? i.unit = "件" : i.productType === m.ENCLOSURE.V ? i.unit = "张" : i.unit = "个", i));
  };
  function L(u) {
    s.query.projectId = u, s.toQuery();
  }
  function D(u) {
    f.value = S(u), v.value = true;
  }
  function N(u) {
    f.value = S(u), h.value = true;
  }
  return (u, l) => {
    const i = W, T = q, E = x("common-button"), Q = x("common-table"), I = C("thousand"), $ = C("permission"), B = A;
    return n(), P("div", oe, [p(e(ie), { "max-height": e(k), onProjectChange: L }, null, 8, ["max-height"]), g("div", ae, [g("div", re, [p(e(ne))]), b((n(), o(Q, { ref_key: "tableRef", ref: w, data: e(s).data, "empty-text": e(s).emptyText, "max-height": e(k), "data-format": j.value, style: { width: "100%" } }, { default: c(() => [p(i, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("project") && !e(s).query.projectId ? (n(), o(i, { key: "project", align: "center", label: "所属项目", prop: "project", "show-overflow-tooltip": "", "min-width": "140" })) : a("", true), e(r).visible("productType") ? (n(), o(i, { key: "productType", prop: "productType", "show-overflow-tooltip": "", label: "产品类型", align: "center", width: "120" }, { default: c(({ row: t }) => [p(T, { type: e(m).V[t.productType].T, effect: "plain" }, { default: c(() => [V(y(e(m).VL[t.productType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : a("", true), e(r).visible("pricingName") ? (n(), o(i, { key: "pricingName", prop: "pricingName", "show-overflow-tooltip": "", label: "名称", align: "center", "min-width": "140" })) : a("", true), e(r).visible("pricingMannerEnum") ? (n(), o(i, { key: "pricingMannerEnum", prop: "pricingMannerEnum", "show-overflow-tooltip": "", label: "计价方式", align: "center", "min-width": "140" }, { default: c(({ row: t }) => [g("span", null, y(t.pricingMannerEnum), 1), t.productType === e(m).STRUCTURE.V && t.pricingWeightTypeEnum ? (n(), P("span", le, "【" + y(t.pricingWeightTypeEnum) + "】", 1)) : a("", true)]), _: 1 })) : a("", true), e(r).visible("unit") ? (n(), o(i, { key: 4, prop: "unit", "show-overflow-tooltip": true, label: "计量单位", align: "center", width: "80" })) : a("", true), e(r).visible("totalQuantity") ? (n(), o(i, { key: "totalQuantity", prop: "totalQuantity", label: "数量", align: "center", "min-width": "80", "show-overflow-tooltip": "" })) : a("", true), e(r).visible("pricingUnitTypeEnum") ? (n(), o(i, { key: 6, prop: "pricingUnitTypeEnum", "show-overflow-tooltip": true, label: "核算单位", align: "center", width: "80" })) : a("", true), e(r).visible("pricingMete") ? (n(), o(i, { key: "pricingMete", prop: "pricingMete", align: "center", "min-width": "120", label: "核算量" })) : a("", true), e(r).visible("unitPrice") ? (n(), o(i, { key: "unitPrice", prop: "unitPrice", align: "right", "min-width": "120", label: "单价（元）" })) : a("", true), e(r).visible("totalPrice") ? (n(), o(i, { key: "totalPrice", prop: "totalPrice", align: "right", "min-width": "120", label: "金额（元）" }, { default: c(({ row: t }) => [b(g("span", null, null, 512), [[I, { val: t.totalPrice || 0 }]])]), _: 1 })) : a("", true), e(r).visible("auditStatus") ? (n(), o(i, { key: 10, label: "状态", width: "100px", align: "center", fixed: "right", prop: "auditStatus" }, { default: c(({ row: t }) => [p(T, { type: e(R).V[t.auditStatus].TAG }, { default: c(() => [V(y(e(R).VL[t.auditStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : a("", true), e(Y)([...e(_).get, ...e(_).edit]) ? (n(), o(i, { key: 11, label: "操作", width: "120px", align: "center", fixed: "right" }, { default: c(({ row: { sourceRow: t } }) => [b(p(E, { icon: "el-icon-edit", type: "info", onClick: (O) => N(t) }, null, 8, ["onClick"]), [[$, e(_).edit]]), p(E, { icon: "el-icon-view", type: "primary", onClick: (O) => D(t) }, null, 8, ["onClick"])]), _: 1 })) : a("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[B, e(s).loading]]), p(e(Z)), p(e(ee), { visible: v.value, "onUpdate:visible": l[0] || (l[0] = (t) => v.value = t), "detail-info": f.value, onRefresh: l[1] || (l[1] = (t) => e(s).toQuery()) }, null, 8, ["visible", "detail-info"]), p(e(te), { visible: h.value, "onUpdate:visible": l[2] || (l[2] = (t) => h.value = t), detailInfo: f.value, onSuccess: l[3] || (l[3] = (t) => e(s).toQuery()) }, null, 8, ["visible", "detailInfo"])])]);
  };
} }, Se = G(pe, [["__scopeId", "data-v-482781ce"]]);
export {
  Se as default
};
