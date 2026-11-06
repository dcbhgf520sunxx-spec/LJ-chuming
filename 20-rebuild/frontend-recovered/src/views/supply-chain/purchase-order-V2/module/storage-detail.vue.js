import { ref as w } from "vue";
import { computed as q } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as Y } from "vue";
import { withCtx as s } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as z } from "vue";
import { toDisplayString as D } from "vue";
import { createElementVNode as f } from "vue";
import { unref as r } from "vue";
import { createElementBlock as N } from "vue";
import { Fragment as R } from "vue";
import { ElTag as L } from "element-plus";
import { ElDatePicker as O } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElTooltip as G } from "element-plus";
import { _ as J, u as K, kc as Q, D as m, o as W, jP as p, uU as X, cO as Z, jR as ee, jl as ae } from "../../../../shared/runtime.js";
import { u as te } from "../../../../modules/useTableTotal-3d22365a.js";
const le = { class: "head-container" }, oe = { class: "table-container" }, ne = { class: "pointer" }, re = { __name: "storage-detail", props: { modelValue: { type: Boolean, required: true }, currentRow: { type: Object, default: () => {
} }, titleFields: { type: Array, default: () => [{ key: "serialNumber", label: "采购合同号" }, { key: "branchCompany.name", label: "签订主体" }] }, apiParamField: { type: String, default: "id" } }, emits: ["update:modelValue"], setup(V, { emit: E }) {
  const t = V, U = E, d = w([]), l = w({ createTime: [], startDate: void 0, endDate: void 0 }), k = q(() => t.titleFields.map((c) => {
    const i = c.key.split(".");
    let o = t.currentRow;
    for (const n of i) if (o = o == null ? void 0 : o[n], o === void 0) break;
    return `${c.label}：${o || "-"}`;
  }).join(" | ")), y = async () => {
    var c, i, o;
    try {
      ((c = l.value.createTime) == null ? void 0 : c.length) > 0 ? (l.value.startDate = l.value.createTime[0], l.value.endDate = l.value.createTime[1]) : (l.value.startDate = void 0, l.value.endDate = void 0);
      const { content: n } = await X({ id: t.currentRow[t.apiParamField], ...l.value });
      n == null || n.forEach((a) => {
        a.basicClass = a.basicClassEnum;
      });
      const g = await Z(n, { multipleSpec: true });
      t.currentRow.materialType & p.MANUFACTURED.V || ((o = (i = t.currentRow) == null ? void 0 : i.sourceRow) == null ? void 0 : o.materialType) & p.MANUFACTURED.V ? d.value = await ee(g, { toNum: true }, { mete: ["mete"], amount: ["price", "priceExcludingVat"] }) : d.value = await ae(g, { toSmallest: false, toNum: true }, { mete: ["mete", "actualReceivedMete"], amount: ["price", "priceExcludingVat"] });
    } catch (n) {
      console.log(n);
    }
  }, C = async () => {
    l.value.createTime = [], y();
  }, { visible: F, handleClose: B } = K({ emit: U, props: t, showHook: C });
  Q();
  const M = w([["amount", ["to-thousand", m.YUAN]], ["realityInboundAmount", ["to-thousand", m.YUAN]], ["amountExcludingVat", ["to-thousand", m.YUAN]], ["rejectAmount", ["to-thousand", m.YUAN]], ["differentAmount", ["to-thousand", m.YUAN]], ["applicantDate", ["parse-time", "{y}-{m}-{d}"]], ["reviewerDate", ["parse-time", "{y}-{m}-{d}"]]]), { getSummaries: S } = te(false, { defineData: ["amount", "rejectAmount", "differentAmount", "amountExcludingVat", "realityInboundAmount", "quantity", "mete"] }), { maxHeight: j } = W({ mainBox: ".storage-detail", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".table-container"], paginate: false, navbar: false, minHeight: 300, extraHeight: 40, clientHRepMainH: true }, d.value);
  return (c, i) => {
    const o = L, n = O, g = h("print-table"), a = $, P = G, H = h("common-table"), I = h("common-drawer");
    return _(), Y(I, { appendToBody: true, "before-close": r(B), visible: r(F), "custom-class": "storage-detail", size: "100%", title: "入库明细" }, { titleAfter: s(() => [e(o, null, { default: s(() => [z(D(k.value), 1)]), _: 1 })]), content: s(() => {
      var v, A, T;
      return [f("div", le, [f("div", null, [e(n, { modelValue: l.value.createTime, "onUpdate:modelValue": i[0] || (i[0] = (b) => l.value.createTime = b), type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, onChange: y }, null, 8, ["modelValue"])]), e(g, { params: { id: (v = t.currentRow) == null ? void 0 : v[t.apiParamField], isPurchase: true }, "api-key": t.currentRow.materialType & r(p).MANUFACTURED.V || ((T = (A = t.currentRow) == null ? void 0 : A.sourceRow) == null ? void 0 : T.materialType) & r(p).MANUFACTURED.V ? "newManufacturedStorageDetails" : "newStorageDetails", size: "default", type: "warning" }, null, 8, ["params", "api-key"])]), f("div", oe, [e(H, { ref: "tableRef", data: d.value, "data-format": M.value, "max-height": r(j), "summary-method": r(S), "show-summary": "", stripe: "" }, { default: s(() => {
        var b, x;
        return [e(a, { align: "center", label: "序号", type: "index", width: "60" }), t.currentRow.materialType & r(p).MANUFACTURED.V || ((x = (b = t.currentRow) == null ? void 0 : b.sourceRow) == null ? void 0 : x.materialType) & r(p).MANUFACTURED.V ? (_(), N(R, { key: 0 }, [e(a, { align: "center", label: "名称", prop: "manufacturedName", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "规格", prop: "specification", "min-width": "120", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "入库数量", prop: "quantity" }), e(a, { align: "center", label: "核算单位", prop: "accountingUnit" }), e(a, { align: "center", label: "核算量", prop: "mete" }), e(a, { align: "center", label: "不含税单价", prop: "priceExcludingVat" }), e(a, { align: "center", label: "含税单价", prop: "price" }), e(a, { align: "center", label: "不含税金额", prop: "amountExcludingVat", width: "120" }), e(a, { align: "center", label: "含税金额", prop: "amount", width: "120" }), e(a, { align: "center", label: "退货金额", prop: "rejectAmount", width: "120" }), e(a, { align: "center", label: "实际入库含税金额", prop: "realityInboundAmount", width: "120" })], 64)) : (_(), N(R, { key: 1 }, [e(a, { align: "left", label: "物料名称", prop: "classifyName", "show-overflow-tooltip": "" }, { default: s(({ row: u }) => [e(P, { content: u.classifyFullName === u.classifyName ? u.classification : u.classifyFullName, placement: "top" }, { default: s(() => [f("span", ne, D(u.classifyName), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), e(a, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "计量单位", prop: "measureUnit" }), e(a, { align: "center", label: "入库数量", prop: "quantity" }), e(a, { align: "center", label: "核算单位", prop: "accountingUnit" }), e(a, { align: "center", label: "核算量", prop: "mete" }), e(a, { align: "center", label: "实收量", prop: "actualReceivedMete" }), e(a, { align: "center", label: "不含税单价", prop: "priceExcludingVat" }), e(a, { align: "center", label: "含税单价", prop: "price" }), e(a, { align: "center", label: "不含税金额", prop: "amountExcludingVat", width: "120" }), e(a, { align: "center", label: "含税金额", prop: "amount", width: "120" }), e(a, { align: "center", label: "退货金额", prop: "rejectAmount", width: "120" }), e(a, { align: "center", label: "调整金额", prop: "differentAmount", width: "120" }), e(a, { align: "center", label: "实际入库含税金额", prop: "realityInboundAmount", width: "120" })], 64)), e(a, { align: "center", label: "办理人", prop: "applicant.name" }), e(a, { align: "center", label: "办理日期", prop: "applicantDate", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "审核人", prop: "reviewer.name" }), e(a, { align: "center", label: "审核日期", prop: "reviewerDate", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "入库单号", prop: "inboundSerialNumber", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "项目", prop: "project.shortName", "show-overflow-tooltip": "" })];
      }), _: 1 }, 8, ["data", "data-format", "max-height", "summary-method"])])];
    }), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, pe = J(re, [["__scopeId", "data-v-1b2a0942"]]);
export {
  pe as default
};
