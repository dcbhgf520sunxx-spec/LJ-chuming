import { ref as S } from "vue";
import { computed as T } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as t } from "vue";
import { withCtx as x } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as g } from "element-plus";
import { vLoading as k } from "element-plus";
import { c as C } from "../../../../../modules/order-tracking-9be524cd.js";
import { _ as D, t as P, x as R, o as E, iw as H, c1 as M, P as j } from "../../../../../shared/runtime.js";
import { M as A } from "../../../../../modules/contract-9b18cc88.js";
import B from "./module/header.vue.js";
const q = { __name: "index", setup(I) {
  const { decimalPrecision: p } = P(), d = { add: false, edit: false, del: false, download: false }, l = S(), { crud: i, columns: a, CRUD: u } = R({ title: "配套制品-发运跟踪", sort: [], permission: { ...A }, crudApi: { ...C }, requiredQuery: ["orderId"], optShow: { ...d } }, l), { maxHeight: n } = E({ paginate: true, extraHeight: 100 }), m = T(() => [["project", "parse-project"], ["orderSourceType", ["parse-enum", H]], ["status", ["parse-enum", M]], ["contractAmount", ["to-thousand", p.value.contract]]]);
  return u.HOOK.handleRefresh = (y, { data: _ }) => {
  }, (y, _) => {
    const r = g, f = b("common-table"), h = k;
    return o(), v("div", null, [c(e(B)), w((o(), t(f, { ref_key: "tableRef", ref: l, "data-format": m.value, data: e(i).data, style: { width: "100%" }, "max-height": e(n) }, { default: x(() => [c(r, { label: "序号", type: "index", align: "center", width: "55" }), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "名称" })) : s("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "规格", "min-width": "80" })) : s("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "单位" })) : s("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "数量" })) : s("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "综合单价(元)" })) : s("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "单价(元)" })) : s("", true), e(a).visible("orderSourceType") ? (o(), t(r, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "发运日期", "min-width": "80" })) : s("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[h, e(i).loading]]), c(e(j))]);
  };
} }, K = D(q, [["__scopeId", "data-v-053ba19d"]]);
export {
  K as default
};
