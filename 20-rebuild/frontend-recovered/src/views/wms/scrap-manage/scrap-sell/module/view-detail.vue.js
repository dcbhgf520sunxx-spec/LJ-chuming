import { ref as c } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as x } from "vue";
import { createBlock as D } from "vue";
import { withCtx as a } from "vue";
import { withDirectives as L } from "vue";
import { unref as p } from "vue";
import { createTextVNode as d } from "vue";
import { createVNode as t } from "vue";
import { toDisplayString as n } from "vue";
import { createElementVNode as o } from "vue";
import { isRef as T } from "vue";
import { ElDescriptionsItem as z } from "element-plus";
import { ElDescriptions as O } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElInput as F } from "element-plus";
import { u as J, L as M, Co as q } from "../../../../../shared/runtime.js";
import { e as H } from "../../../../../modules/scrap-sell-e306ced6.js";
const P = { style: { display: "flex", "flex-direction": "column", "align-items": "center" } }, W = { style: { "margin-top": "20px", display: "flex", "align-items": "center" } }, $ = { style: { "margin-top": "20px", display: "flex", "align-items": "center" } }, Q = { __name: "view-detail", props: { modelValue: { type: Boolean, default: false }, rowData: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(h, { emit: V }) {
  const s = h, N = V, { visible: f, handleClose: k } = J({ props: s, emit: N, showHook: S }), C = { branchCompanyName: void 0, contractWasteId: void 0, creatorRemark: void 0, id: void 0, plateNumber: void 0, saleDate: (/* @__PURE__ */ new Date()).getTime(), contractNumber: void 0, wasteSaleDetailList: [] }, i = c(JSON.parse(JSON.stringify(C))), _ = c([]), b = c(), w = c(), v = c(true);
  async function S() {
    _.value = [], i.value = s.rowData, w.value = s.rowData.creatorRemark, b.value = s.rowData.auditorRemark, console.log(s.rowData.wasteSaleDetailList), s.rowData.wasteSaleDetailList.forEach((m) => {
      m != null && m.id && _.value.push(m);
    });
  }
  return (m, l) => {
    const u = z, R = O, r = j, E = y("common-table"), g = F, B = y("common-drawer"), U = I("permission");
    return x(), D(B, { modelValue: p(f), "onUpdate:modelValue": l[2] || (l[2] = (e) => T(f) ? f.value = e : null), "before-close": p(k), size: "70%", title: "废料出售单详情" }, { titleRight: a(() => [L((x(), D(M, { fn: p(H), params: s.rowData.id }, { default: a(() => l[3] || (l[3] = [d("下载")])), _: 1, __: [3] }, 8, ["fn", "params"])), [[U, p(q).download]])]), content: a(() => [t(R, { column: 2, border: "", style: { "margin-bottom": "20px" } }, { default: a(() => [t(u, { label: "创建日期" }, { default: a(() => {
      var e;
      return [d(n((e = i.value) == null ? void 0 : e.createTime), 1)];
    }), _: 1 }), t(u, { label: "创建人" }, { default: a(() => [d(n(i.value.createUserName), 1)]), _: 1 }), t(u, { label: "出售单位" }, { default: a(() => [d(n(i.value.branchCompanyName), 1)]), _: 1 }), t(u, { label: "购买单位" }, { default: a(() => [d(n(i.value.purchaser), 1)]), _: 1 }), t(u, { label: "合同编号" }, { default: a(() => [d(n(i.value.serialNumber), 1)]), _: 1 }), t(u, { label: "车牌/船牌号" }, { default: a(() => [d(n(i.value.plateNumber), 1)]), _: 1 })]), _: 1 }), o("div", P, [t(E, { data: _.value, returnSourceData: "" }, { default: a(() => [t(r, { label: "序号", align: "center", width: "55", type: "index" }), t(r, { label: "类型", align: "center", width: "150" }, { default: a(({ row: e }) => [o("span", null, n(e.wasteClassificationName), 1)]), _: 1 }), t(r, { label: "核算单位", align: "center", width: "80" }, { default: a(({ row: e }) => [o("span", null, n(e.measureUnit), 1)]), _: 1 }), t(r, { label: "数量", align: "center", width: "100" }, { default: a(({ row: e }) => [o("span", null, n(e.saleMete), 1)]), _: 1 }), t(r, { label: "单价", align: "center", width: "125" }, { default: a(({ row: e }) => [o("span", null, n(e.price), 1)]), _: 1 }), t(r, { label: "金额", align: "center", width: "125" }, { default: a(({ row: e }) => [o("span", null, n(e.amount), 1)]), _: 1 }), t(r, { label: "备注", align: "center" }, { default: a(({ row: e }) => [o("span", null, n(e.remark), 1)]), _: 1 })]), _: 1 }, 8, ["data"])]), o("div", W, [l[4] || (l[4] = o("span", { style: { "font-size": "16px", "font-weight": "bold" } }, "创建备注：", -1)), t(g, { style: { width: "750px" }, type: "textarea", maxlength: "200", disabled: v.value, modelValue: w.value, "onUpdate:modelValue": l[0] || (l[0] = (e) => w.value = e) }, null, 8, ["disabled", "modelValue"])]), o("div", $, [l[5] || (l[5] = o("span", { style: { "font-size": "16px", "font-weight": "bold" } }, "审核备注：", -1)), t(g, { style: { width: "750px" }, type: "textarea", maxlength: "200", disabled: v.value, modelValue: b.value, "onUpdate:modelValue": l[1] || (l[1] = (e) => b.value = e) }, null, 8, ["disabled", "modelValue"])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Q as default
};
