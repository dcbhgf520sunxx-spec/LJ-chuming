import { provide as n } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as o } from "vue";
import { withCtx as i } from "vue";
import { unref as e } from "vue";
import { createBlock as s } from "vue";
import { createCommentVNode as a } from "vue";
import { ElCol as d } from "element-plus";
import { ElRow as l } from "element-plus";
import { _ as p, gM as t, G as c } from "../../../../shared/runtime.js";
import u from "./module/basic-inbound-v2.vue.js";
import y from "./module/basic-purchase.vue.js";
import k from "./module/basic-outbound-v2.vue.js";
import G from "./module/report-center.vue.js";
import $ from "./module/party-a-borrow-return.vue.js";
import g from "./module/material-weighting.vue.js";
import b from "./module/basic-return.vue.js";
import x from "./module/transfer.vue.js";
import v from "./module/scrap-price-entry-config.vue.js";
import C from "./module/inventory-loss.vue.js";
import h from "./module/display-basic-configuration.vue.js";
import B from "./module/inventory-type.vue.js";
import P from "./module/coil-plate-convert.vue.js";
import w from "./module/outbound-list-edit.vue.js";
import E from "./module/basic-price-config.vue.js";
import R from "./module/crm-oa.vue.js";
import "../../../../modules/use-refresh-store-3f8d2c0c.js";
import "../../../../modules/judgeSameValue-9683bdce.js";
const A = { class: "app-container" }, I = { __name: "index", setup(L) {
  return n("permission", t), (M, N) => {
    const m = d, _ = l;
    return r(), f("div", A, [o(_, { gutter: 20 }, { default: i(() => [o(m, { lg: 8, md: 12, sm: 24, xs: 24 }, { default: i(() => [e(c)(e(t).basicInboundGet) ? (r(), s(u, { key: 0, class: "card" })) : a("", true), e(c)(e(t).basicPriceConfigGet) ? (r(), s(E, { key: 1, class: "card" })) : a("", true), e(c)(e(t).basicPurchaseGet) ? (r(), s(y, { key: 2, class: "card" })) : a("", true)]), _: 1 }), o(m, { lg: 8, md: 12, sm: 24, xs: 24 }, { default: i(() => [e(c)(e(t).basicOutboundGet) ? (r(), s(k, { key: 0, class: "card" })) : a("", true), e(c)(e(t).outboundListEditAbleGet) ? (r(), s(w, { key: 1, class: "card" })) : a("", true), e(c)(e(t).materialWeightingGet) ? (r(), s(g, { key: 2, class: "card" })) : a("", true), e(c)(e(t).inventoryLossGet) ? (r(), s(C, { key: 3, class: "card" })) : a("", true), e(c)(e(t).displayBasicConfigurationGet) ? (r(), s(h, { key: 4, class: "card" })) : a("", true), e(c)(e(t).coilPlateConvertGet) ? (r(), s(e(P), { key: 5, class: "card" })) : a("", true)]), _: 1 }), o(m, { lg: 8, md: 12, sm: 24, xs: 24 }, { default: i(() => [e(c)(e(t).partyABorrowReturnGet) ? (r(), s($, { key: 0, class: "card" })) : a("", true), e(c)(e(t).reportCenterGet) ? (r(), s(G, { key: 1, class: "card" })) : a("", true), e(c)(e(t).basicReturnGet) ? (r(), s(b, { key: 2, class: "card" })) : a("", true), e(c)(e(t).transferGet) ? (r(), s(e(x), { key: 3, class: "card" })) : a("", true), e(c)(e(t).scrapPriceGet) ? (r(), s(v, { key: 4, class: "card" })) : a("", true), e(c)(e(t).inventoryGainTypeGet) ? (r(), s(B, { key: 5, class: "card" })) : a("", true), e(c)(e(t).crmOaConfigGet) ? (r(), s(R, { key: 6, class: "card" })) : a("", true)]), _: 1 })]), _: 1 })]);
  };
} }, se = p(I, [["__scopeId", "data-v-efc856e8"]]);
export {
  se as default
};
