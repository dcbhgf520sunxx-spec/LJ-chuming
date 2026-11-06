import { ref as y } from "vue";
import { computed as N } from "vue";
import { watch as G } from "vue";
import { inject as K } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as s } from "vue";
import { createBlock as c } from "vue";
import { withCtx as n } from "vue";
import { unref as t } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as g } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as E } from "vue";
import { withDirectives as X } from "vue";
import { createElementBlock as D } from "vue";
import { isRef as Z } from "vue";
import { ElTag as $ } from "element-plus";
import { ElTableColumn as ee } from "element-plus";
import { ElPagination as te } from "element-plus";
import { a as oe } from "../../../../../modules/logistics-record-ledger-a6792d58.js";
import { t as ae, u as le, J as ne, jE as d, bz as I, o as ie } from "../../../../../shared/runtime.js";
const re = { class: "print-wrap" }, se = { key: 0 }, pe = { key: 1 }, me = { __name: "record-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, type: { type: [String, Number], default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(h, { emit: z }) {
  const { decimalPrecision: R } = ae(), B = z, o = h, _ = y(void 0), { visible: b, handleClose: S } = le({ emit: B, props: o }), { handleSizeChange: T, handleCurrentChange: M, total: A, setTotalPage: H, queryPage: v } = ne({ fetchHook: w }), V = N(() => {
    var i;
    return { id: o.detailInfo.id || o.detailInfo.supplierId, type: o.type, boolPersonalEnum: (i = o.detailInfo) == null ? void 0 : i.boolPersonalEnum, branchCompanyId: o.detailInfo.branchCompanyId, changeFreight: _.value, startDate: p == null ? void 0 : p.startDate, endDate: p == null ? void 0 : p.endDate };
  });
  G(b, (i) => {
    i && (_.value = void 0, w());
  });
  const x = y([]), P = y(), k = y(false), p = K("query"), O = N(() => [["shipDate", ["parse-time", "{y}-{m}-{d}"]], ["type", ["parse-enum", d]], ["loadingWeight", ["to-fixed", 2]], ["freight", ["to-thousand", R.value.supplyChain]], ["changeFreight", ["parse-enum", I, { f: "SL" }]]]), { maxHeight: j } = ie({ mainBox: ".logistics-record-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", extraHeight: "5vh", minHeight: 300, navbar: false, clientHRepMainH: true }, P);
  async function w() {
    console.log(p, "789456");
    let i = [];
    k.value = true;
    try {
      const { content: r = [], totalElements: u } = await oe({ ...V.value, ...v });
      i = r, H(u);
    } catch (r) {
      console.log("获取物流记录失败", r);
    } finally {
      x.value = i, k.value = false;
    }
  }
  return (i, r) => {
    const u = $, L = m("common-radio-button"), F = m("print-table"), a = ee, U = m("table-cell-tag"), Y = m("common-table"), W = te, q = m("common-drawer"), J = Q("permission");
    return s(), c(q, { ref_key: "dialogRef", ref: P, title: "物流记录", "close-on-click-modal": false, modelValue: t(b), "onUpdate:modelValue": r[1] || (r[1] = (l) => Z(b) ? b.value = l : null), direction: "rtl", "before-close": t(S), "custom-class": "invoice-record", size: "80%" }, { titleAfter: n(() => [o.type === t(d).PRODUCT.V ? (s(), c(u, { key: 0, effect: "plain" }, { default: n(() => [C(f(h.detailInfo.projectName), 1)]), _: 1 })) : g("", true), o.type === t(d).MATERIAL.V ? (s(), c(u, { key: 1, effect: "plain" }, { default: n(() => [C(f(h.detailInfo.serialNumber), 1)]), _: 1 })) : g("", true), o.type === t(d).COMPANY.V ? (s(), c(u, { key: 2, effect: "plain" }, { default: n(() => [C(f(h.detailInfo.supplierName), 1)]), _: 1 })) : g("", true), e(L, { modelValue: _.value, "onUpdate:modelValue": r[0] || (r[0] = (l) => _.value = l), options: t(I).ENUM, showOptionAll: "", type: "enumSL", size: "default", class: "filter-item", onChange: w }, null, 8, ["modelValue", "options"])]), titleRight: n(() => {
      var l;
      return [E("div", re, [X(e(F, { "api-key": "purchaseLogisticsRecord", params: { ...V.value }, size: "default", type: "warning" }, null, 8, ["params"]), [[J, (l = o.permission) == null ? void 0 : l.print]])])];
    }), content: n(() => [e(Y, { data: x.value, "data-format": O.value, "max-height": t(j) }, { default: n(() => [e(a, { label: "序号", type: "index", align: "center", width: "60" }), e(a, { prop: "shipDate", label: "运输日期", align: "center", "show-overflow-tooltip": "" }), o.type === t(d).COMPANY.V ? (s(), c(a, { key: 0, prop: "name", label: "所属项目或采购合同", align: "center", "show-overflow-tooltip": "" })) : g("", true), o.type !== t(d).COMPANY.V ? (s(), c(a, { key: 1, prop: "supplierName", label: "物流公司", align: "center", "show-overflow-tooltip": "" }, { default: n(({ row: l }) => [l.boolPersonalEnum ? (s(), D("span", se, "-")) : (s(), D("span", pe, f(l.supplierName), 1))]), _: 1 })) : g("", true), e(a, { prop: "type", label: "运输属性", align: "center", "show-overflow-tooltip": "" }), e(a, { prop: "licensePlate", label: "车牌/船牌号", align: "center", "show-overflow-tooltip": "" }, { default: n(({ row: l }) => [e(U, { show: !!l.boolPersonalEnum, name: "个人", offset: 15 }, null, 8, ["show"]), E("span", null, f(l.licensePlate), 1)]), _: 1 }), e(a, { prop: "loadingWeight", label: "装载重量(kg)", align: "center", "show-overflow-tooltip": "" }), e(a, { prop: "carModel", label: "车型", align: "center", "show-overflow-tooltip": "" }), e(a, { prop: "driverName", label: "司机姓名", align: "center", "show-overflow-tooltip": "" }), e(a, { prop: "driverPhone", label: "电话", align: "center", "show-overflow-tooltip": "" }), e(a, { prop: "freight", label: "运费额", align: "center", "show-overflow-tooltip": "" }), e(a, { prop: "changeFreight", label: "状态", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"]), e(W, { total: t(A), "current-page": t(v).pageNumber, "page-size": t(v).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(T), onCurrentChange: t(M) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  me as default
};
