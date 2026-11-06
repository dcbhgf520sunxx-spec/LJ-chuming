import { ref as x } from "vue";
import { computed as v } from "vue";
import { watch as Y } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as o } from "vue";
import { withCtx as r } from "vue";
import { createCommentVNode as l } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as m } from "vue";
import { Fragment as H } from "vue";
import { createTextVNode as R } from "vue";
import { ElTableColumn as K } from "element-plus";
import { vLoading as X } from "element-plus";
import { g as G, a as J } from "../../../../../modules/reject-03b2f373.js";
import { _ as Q, t as W, jX as z, bD as Z, D as g, jY as ee, x as te, C2 as V, o as ae, G as ie, sQ as se, cO as D, jl as P, bl as ne, j_ as oe, x_ as le, k5 as re, jH as ce, k6 as ue, ux as y, P as pe, ba as me, jN as de } from "../../../../../shared/runtime.js";
import fe from "./module/header.vue.js";
import { M as he } from "../../../../../modules/index-a46d8bb8.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/reset-query-5216307c.js";
const be = { class: "report-material-inbound-details app-container" }, we = { __name: "index", setup(ve) {
  const { decimalPrecision: N } = W(), S = { add: false, edit: false, del: false, download: false }, B = x([]), T = x(), O = v(() => [...z, ["invoiceType", ["parse-enum", Z, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", N.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", N.value.wms]], ["amount", ["to-thousand", g.YUAN]], ["amountExcludingVAT", ["to-thousand", g.YUAN]], ["inputVAT", ["to-thousand", g.YUAN]], ["inboundReceipt.inboundTime", "parse-time"], ["inboundReceipt.reviewTime", "parse-time"], ["createTime", "parse-time"], ["rejectTime", "parse-time"]]), { reportCfg: A } = ee(), { CRUD: U, crud: f, columns: i } = te({ title: "退货明细", sort: ["id.desc"], invisibleColumns: ["applicantName", "inboundReceipt.editorName", "inboundReceipt.reviewerName", "createTime", "inboundReceipt.reviewTime", "invoiceType", "taxRate", "warehouse", "monomerName", "areaName", "remark"], permission: { ...V }, optShow: { ...S }, crudApi: { get: G } }, T), { maxHeight: M } = ae({ paginate: true });
  v(() => !!A.value.amountShow), v(() => !!A.value.amountExcludingTAXShow);
  const L = v(() => ie(V.showAmount)), h = v(() => f.query ? f.query.basicClass : void 0), { baseUnit: E } = se(h.value);
  function k(w) {
    return w.replace(/[\(\)]/g, function(d) {
      return d === "(" ? "（" : "）";
    });
  }
  const _ = x();
  U.HOOK.handleRefresh = async (w, { data: d }) => {
    await D(d.content), d.content = await P(d.content), d.content.forEach((a) => {
      if (a.specification && a.specMerge.indexOf(a.specification) > -1 && (a.specification = k(a.specification), a.specMerge = k(a.specMerge), a.specMerge = a.specMerge.replace(new RegExp(`\\${a.specification}`, "g"), "")), a.basicClass === ne.SECTION_STEEL.V) {
        const u = a.specification.split("*");
        for (let c = 0; c < u.length; c++) u[c] = u[c].trim();
        const t = [];
        for (const c in a.specKV) if (c.indexOf("standard") < 0) {
          t.push(a.specKV[c]);
          const C = u.findIndex((q) => q === a.specKV[c]);
          C > -1 && u.splice(C, 1);
        }
        a.specification = t.join("*"), a.standard = u.join("*");
      }
      a.inboundReceipt || (a.inboundReceipt = {});
    });
    const s = [];
    d.content.forEach((a) => {
      Array.isArray(a.rejectList) && a.rejectList.forEach((u) => {
        s.push(u.material);
      });
    }), await D(s), await P(s);
  }, Y(() => f.query, async () => {
    _.value = await J(f.query), h.value & oe.STEEL.V && await le(_.value, { unit: E.value[h.value].weight.unit, precision: E.value[h.value].weight.precision, fields: ["meteCount"], toSmallest: false, toNum: true });
  }, { deep: true, immediate: true });
  function I(w) {
    return me(w, { props: ["quantity", ["mete", de.weight.precision], ["amount", g.YUAN], ["amountExcludingVAT", g.YUAN]], toThousandFields: ["amount", "amountExcludingVAT"] });
  }
  return (w, d) => {
    const s = K, a = $("common-table"), u = X;
    return n(), j("div", be, [p(e(fe), { DetailsCount: _.value }, null, 8, ["DetailsCount"]), F((n(), o(a, { ref_key: "tableRef", ref: T, data: e(f).data, "data-format": O.value, "default-expand-all": false, "expand-row-keys": B.value, "max-height": e(M), "summary-method": I, "highlight-current-row": "", "row-key": "id", "show-summary": "", onSortChange: e(f).handleSortChange }, { default: r(() => [p(he, { "basic-class": h.value, columns: e(i), "spec-merge": false, "classify-name-alias": "名称", "reject-detail-viewable": "", "show-classification": "", "show-reject-status": "", sortable: "", "spec-only": "" }, { afterIndex: r(() => [e(i).visible("rejectTime") ? (n(), o(s, { key: "rejectTime", "show-overflow-tooltip": true, align: "center", label: "退货时间", prop: "rejectTime", width: "125" })) : l("", true)]), _: 1 }, 8, ["basic-class", "columns"]), p(re, { "basic-class": h.value, columns: e(i) }, null, 8, ["basic-class", "columns"]), p(ce, { "basic-class": h.value, columns: e(i) }, null, 8, ["basic-class", "columns"]), e(i).visible("heatNoAndBatchNo") ? (n(), o(s, { key: "heatNoAndBatchNo", "show-overflow-tooltip": false, align: "center", label: "炉批号/卷号", "min-width": "150px", prop: "heatNoAndBatchNo" }, { default: r(({ row: { sourceRow: t } }) => [b("span", null, m(t.heatNoAndBatchNo || "-"), 1)]), _: 1 })) : l("", true), L.value ? (n(), j(H, { key: 1 }, [e(i).visible("unitPrice") ? (n(), o(s, { key: "unitPrice", "show-overflow-tooltip": false, align: "center", label: "含税单价", "min-width": "150px", prop: "unitPrice" }, { default: r(({ row: t }) => [b("span", null, m(t.unitPrice || "-"), 1)]), _: 1 })) : l("", true), e(i).visible("unitPriceExcludingVAT") ? (n(), o(s, { key: "unitPriceExcludingVAT", "show-overflow-tooltip": false, align: "center", label: "不含税单价", "min-width": "150px", prop: "unitPriceExcludingVAT" }, { default: r(({ row: t }) => [b("span", null, m(t.unitPriceExcludingVAT || "-"), 1)]), _: 1 })) : l("", true), e(i).visible("amount") ? (n(), o(s, { key: "amount", "show-overflow-tooltip": false, align: "center", label: "含税金额", "min-width": "150px", prop: "amount" }, { default: r(({ row: t }) => [b("span", null, m(t.amount || "-"), 1)]), _: 1 })) : l("", true), e(i).visible("amountExcludingVAT") ? (n(), o(s, { key: "amountExcludingVAT", "show-overflow-tooltip": false, align: "center", label: "不含税金额", "min-width": "150px", prop: "amountExcludingVAT" }, { default: r(({ row: t }) => [b("span", null, m(t.amountExcludingVAT || "-"), 1)]), _: 1 })) : l("", true), e(i).visible("inputVAT") ? (n(), o(s, { key: "inputVAT", "show-overflow-tooltip": false, align: "center", label: "进税项", "min-width": "150px", prop: "inputVAT" }, { default: r(({ row: t }) => [b("span", null, m(t.inputVAT || "-"), 1)]), _: 1 })) : l("", true)], 64)) : l("", true), e(i).visible("project.serialNumber") ? (n(), o(s, { key: "project.serialNumber", "show-overflow-tooltip": false, align: "center", label: "项目编号", "min-width": "150px", prop: "project.serialNumber" }, { default: r(({ row: { sourceRow: t } }) => {
      var c;
      return [b("span", null, m(((c = t.project) == null ? void 0 : c.serialNumber) || "-"), 1)];
    }), _: 1 })) : l("", true), p(ue, { columns: e(i), "show-area": "", "show-monomer": "", "show-project": "" }, null, 8, ["columns"]), e(i).visible("rejectDO.serialNumber") ? (n(), o(s, { key: "rejectDO.serialNumber", "show-overflow-tooltip": true, align: "left", label: "退货单号", "min-width": "155", prop: "rejectDO.serialNumber" }, { default: r(({ row: t }) => [p(e(y), { receipt: t.rejectDO, "receipt-types": ["REJECTED"] }, null, 8, ["receipt"])]), _: 1 })) : l("", true), e(i).visible("inboundReceipt.serialNumber") ? (n(), o(s, { key: "inboundReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "入库单号", "min-width": "155", prop: "inboundReceipt.serialNumber" }, { default: r(({ row: t }) => [p(e(y), { receipt: t.inboundReceipt, "receipt-types": ["INBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : l("", true), e(i).visible("purchaseOrder.serialNumber") ? (n(), o(s, { key: "purchaseOrder.serialNumber", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "155", prop: "purchaseOrder.serialNumber" }, { default: r(({ row: t }) => [p(e(y), { receipt: t.purchaseOrder, "receipt-types": ["PURCHASE"] }, null, 8, ["receipt"])]), _: 1 })) : l("", true), e(i).visible("supplier.name") ? (n(), o(s, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "200", prop: "supplier.name" })) : l("", true), e(i).visible("applicantName") ? (n(), o(s, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : l("", true), e(i).visible("createTime") ? (n(), o(s, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", width: "125" }, { default: r(({ row: t }) => [R(m(t.createTime), 1)]), _: 1 })) : l("", true), e(i).visible("remark") ? (n(), o(s, { key: "remark", "show-overflow-tooltip": true, label: "备注", prop: "remark", width: "125" }, { default: r(({ row: t }) => [R(m(t.remark || "-"), 1)]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[u, e(f).loading]]), p(e(pe))]);
  };
} }, Ee = Q(we, [["__scopeId", "data-v-ac3063dc"]]);
export {
  Ee as default
};
