import { ref as w } from "vue";
import { computed as h } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as _ } from "vue";
import { createBlock as t } from "vue";
import { withCtx as k } from "vue";
import { createCommentVNode as p } from "vue";
import { ElTableColumn as g } from "element-plus";
import { vLoading as x } from "element-plus";
import { c as j } from "../../../../../modules/order-tracking-9be524cd.js";
import { _ as C, t as D, x as P, o as R, iw as E, c1 as H, P as A } from "../../../../../shared/runtime.js";
import { M as B } from "../../../../../modules/contract-9b18cc88.js";
import M from "./module/header.vue.js";
const q = { __name: "index", setup(I) {
  const { decimalPrecision: i } = D(), u = { add: false, edit: false, del: false, download: false }, l = w(), { crud: s, columns: a, CRUD: d } = P({ title: "围护-发运跟踪", sort: [], permission: { ...B }, crudApi: { ...j }, requiredQuery: ["orderId"], optShow: { ...u } }, l), { maxHeight: n } = R({ paginate: true, extraHeight: 100 }), m = h(() => [["project", "parse-project"], ["orderSourceType", ["parse-enum", E]], ["status", ["parse-enum", H]], ["contractAmount", ["to-thousand", i.value.contract]]]);
  return d.HOOK.handleRefresh = (y, { data: f }) => {
  }, (y, f) => {
    const r = g, S = b("common-table"), T = x;
    return o(), v("div", null, [c(e(M)), _((o(), t(S, { ref_key: "tableRef", ref: l, "data-format": m.value, data: e(s).data, style: { width: "100%" }, "max-height": e(n) }, { default: k(() => [c(r, { label: "序号", type: "index", align: "center", width: "55" }), e(a).visible("project") ? (o(), t(r, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "批次", "min-width": "80" })) : p("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "名称" })) : p("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "编号" })) : p("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "板型" })) : p("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "单长(mm)" })) : p("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "数量(张)" })) : p("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "总长度(mm)" })) : p("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "综合单价(元)" })) : p("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "单价(元)" })) : p("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "发运日期", "min-width": "80" })) : p("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[T, e(s).loading]]), c(e(A))]);
  };
} }, L = C(q, [["__scopeId", "data-v-25da5c1c"]]);
export {
  L as default
};
