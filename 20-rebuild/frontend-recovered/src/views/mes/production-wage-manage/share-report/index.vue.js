import { ref as _ } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as w } from "vue";
import { unref as i } from "vue";
import { createBlock as k } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as r } from "vue";
import { ElTableColumn as x } from "element-plus";
import { vLoading as j } from "element-plus";
import { l as C, _ as R, x as B, q1 as D, o as H } from "../../../../shared/runtime.js";
import L from "./module/header.vue.js";
function q(c) {
  return C({ url: "/api/mes/building/production-wage-manage/yield-confirm/apportion-report", method: "get", params: c });
}
const A = { get: q };
const E = { class: "app-container" }, M = { class: "head-container" }, N = { __name: "index", setup(c) {
  const u = _(), o = _([]), { crud: d, CRUD: b } = B({ title: "分摊报表", permission: { ...D }, crudApi: { ...A }, hasPagination: false }, u), { maxHeight: g } = H({ paginate: false });
  return b.HOOK.afterRefresh = async (s) => {
    o.value = [];
    for (const p in s.data[0]) o.value.push(p);
    console.log(o.value, " headerList.value");
  }, (s, p) => {
    const a = x, m = h("common-table"), y = j;
    return f(), v("div", E, [n("div", M, [e(L)]), w((f(), k(m, { ref_key: "tableRef", ref: u, data: i(d).data, "empty-text": i(d).emptyText, "max-height": i(g) }, { default: l(() => [e(a, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), e(a, { key: "type", prop: "type", align: "center", label: "类型", width: "100" }, { default: l((t) => [n("div", null, r(t.row.type || "-"), 1)]), _: 1 }), e(a, { key: "january", prop: "january", align: "center", label: "1月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.january || "-"), 1)]), _: 1 })]), _: 1 }), e(a, { key: "february", prop: "february", align: "center", label: "2月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.february || "-"), 1)]), _: 1 })]), _: 1 }), e(a, { key: "march", prop: "march", align: "center", label: "3月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.march || "-"), 1)]), _: 1 })]), _: 1 }), e(a, { key: "april", prop: "april", align: "center", label: "4月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.april || "-"), 1)]), _: 1 })]), _: 1 }), e(a, { key: "may", prop: "may", align: "center", label: "5月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.may || "-"), 1)]), _: 1 })]), _: 1 }), e(a, { key: "june", prop: "june", align: "center", label: "6月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.june || "-"), 1)]), _: 1 })]), _: 1 }), e(a, { key: "july", prop: "july", align: "center", label: "7月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.july || "-"), 1)]), _: 1 })]), _: 1 }), e(a, { key: "august", prop: "august", align: "center", label: "8月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.august || "-"), 1)]), _: 1 })]), _: 1 }), e(a, { key: "september", prop: "september", align: "center", label: "9月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.september || "-"), 1)]), _: 1 })]), _: 1 }), e(a, { key: "october", prop: "october", align: "center", label: "10月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.october || "-"), 1)]), _: 1 })]), _: 1 }), e(a, { key: "november", prop: "november", align: "center", label: "11月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.november || "-"), 1)]), _: 1 })]), _: 1 }), e(a, { key: "december", prop: "december", align: "center", label: "12月" }, { default: l(() => [e(a, { align: "center", label: "费用（元）/入库量（吨）", width: "200" }, { default: l((t) => [n("div", null, r(t.row.december || "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[y, i(d).loading]])]);
  };
} }, U = R(N, [["__scopeId", "data-v-dfc79558"]]);
export {
  U as default
};
