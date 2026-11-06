import { ref as x } from "vue";
import { computed as w } from "vue";
import { watch as K } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as H } from "vue";
import { createVNode as r } from "vue";
import { unref as i } from "vue";
import { withDirectives as W } from "vue";
import { createBlock as o } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as s } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as _ } from "vue";
import { createTextVNode as S } from "vue";
import { ElTableColumn as G } from "element-plus";
import { vLoading as X } from "element-plus";
import { g as Q, a as z } from "../../../../../modules/inbound-9bad80c1.js";
import { _ as J, t as Z, jX as ee, bD as ie, D as p, jY as te, x as ne, BY as j, o as ae, G as oe, sQ as se, cO as U, jl as D, bl as le, j_ as ue, x_ as ce, aR as re, k4 as pe, yB as me, j$ as T, k5 as de, jH as be, jI as he, k6 as fe, ux as O, P as we, jN as ve, ba as ge } from "../../../../../shared/runtime.js";
import Re from "./module/header.vue.js";
import { M as _e } from "../../../../../modules/index-a46d8bb8.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/reset-query-5216307c.js";
import "../../../../../modules/closing-time-date-query-82715fa2.js";
const Ne = { class: "report-material-inbound-details app-container" }, ye = { __name: "index", setup(xe) {
  const { decimalPrecision: v } = Z(), F = { add: false, edit: false, del: false, download: false }, N = x([]), E = x(), M = w(() => [...ee, ["invoiceType", ["parse-enum", ie, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", v.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", v.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", v.value.wms]], ["unitPriceNoFreight", ["to-thousand", v.value.wms]], ["amount", ["to-thousand", p.YUAN]], ["amountExcludingVAT", ["to-thousand", p.YUAN]], ["amountNoFreight", ["to-thousand", p.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", p.YUAN]], ["inputVAT", ["to-thousand", p.YUAN]], ["inputVATNoFreight", ["to-thousand", p.YUAN]], ["inboundReceipt.inboundTime", "parse-time"], ["inboundReceipt.reviewTime", "parse-time"], ["inboundReceipt.createTime", "parse-time"], ["realTime", "parse-time"]]), { reportCfg: C } = te(), { CRUD: B, crud: m, columns: n } = ne({ title: "入库明细", sort: ["id.desc"], invisibleColumns: ["inboundReceipt.applicantName", "inboundReceipt.editorName", "inboundReceipt.reviewerName", "inboundReceipt.createTime", "inboundReceipt.reviewTime", "inboundReceipt.licensePlate", "inboundReceipt.shipmentNumber", "invoiceType", "taxRate", "inboundReceipt.purchaseOrder", "warehouse", "inboundReceipt.purchaseOrder", "inboundReceipt.inboundTime"], permission: { ...j }, optShow: { ...F }, crudApi: { get: Q } }, E), { maxHeight: I } = ae({ paginate: true }), L = w(() => !!C.value.amountShow), Y = w(() => !!C.value.amountExcludingTAXShow), $ = w(() => oe(j.showAmount)), d = w(() => m.query ? m.query.basicClass : void 0), { baseUnit: k } = se(d.value);
  function A(h) {
    return h.replace(/[\(\)]/g, function(l) {
      return l === "(" ? "（" : "）";
    });
  }
  const y = x();
  B.HOOK.handleRefresh = async (h, { data: l }) => {
    await U(l.content), l.content = await D(l.content, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), l.content.forEach((e) => {
      if (e.specification && e.specMerge.indexOf(e.specification) > -1 && (e.specification = A(e.specification), e.specMerge = A(e.specMerge), e.specMerge = e.specMerge.replace(new RegExp(`\\${e.specification}`, "g"), "")), e.basicClass === le.SECTION_STEEL.V) {
        const u = e.specification.split("*");
        for (let t = 0; t < u.length; t++) u[t] = u[t].trim();
        const g = [];
        for (const t in e.specKV) if (t.indexOf("standard") < 0) {
          g.push(e.specKV[t]);
          const b = u.findIndex((R) => R === e.specKV[t]);
          b > -1 && u.splice(b, 1);
        }
        e.specification = g.join("*"), e.standard = u.join("*");
      }
      e.inboundReceipt || (e.inboundReceipt = {});
    }), console.log(l.content);
    const f = [];
    l.content.forEach((e) => {
      Array.isArray(e.rejectList) && e.rejectList.forEach((u) => {
        f.push(u.material);
      });
    }), await U(f), await D(f, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  }, K(() => m.query, async () => {
    y.value = await z(m.query), d.value & ue.STEEL.V && await ce(y.value, { unit: k.value[d.value].weight.unit, precision: k.value[d.value].weight.precision, fields: ["meteCount"], toSmallest: false, toNum: true });
  }, { deep: true, immutable: true });
  function q(h) {
    const l = ["mete", ve.weight.precision];
    return ge(h, { props: ["quantity", l, ["amount", p.YUAN], ["amountExcludingVAT", p.YUAN], ["amountNoFreight", p.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "amountNoFreight"] });
  }
  return (h, l) => {
    const f = P("table-cell-tag"), e = G, u = P("common-table"), g = X;
    return a(), H("div", Ne, [r(i(Re), { DetailsCount: y.value }, null, 8, ["DetailsCount"]), W((a(), o(u, { ref_key: "tableRef", ref: E, data: i(m).data, "data-format": M.value, "default-expand-all": false, "expand-row-keys": N.value, "max-height": i(I), "summary-method": q, "highlight-current-row": "", "row-key": "id", "show-summary": "", onSortChange: i(m).handleSortChange }, { default: c(() => [r(re, { "expand-row-keys": N.value, "onUpdate:expandRowKeys": l[0] || (l[0] = (t) => N.value = t), data: i(m).data, "row-key": "id" }, { default: c(({ row: t }) => [d.value ? s("", true) : (a(), o(pe, { key: 0, "basic-class": t.basicClass, row: t, showRemark: "" }, null, 8, ["basic-class", "row"]))]), _: 1 }, 8, ["expand-row-keys", "data"]), r(_e, { "basic-class": d.value, columns: i(n), "spec-merge": false, "classify-name-alias": "名称", "reject-detail-viewable": "", "show-classification": "", "show-reject-status": "", sortable: "", "spec-only": "" }, { afterIndex: c(() => [r(me, { columns: i(n), label: "实际入库时间" }, null, 8, ["columns"]), i(n).visible("inboundReceipt.inboundTime") ? (a(), o(e, { key: "inboundReceipt.inboundTime", "show-overflow-tooltip": true, prop: "inboundReceipt.inboundTime", label: "系统入库时间", align: "center", sortable: "custom", width: "125" }, { default: c(({ row: t }) => {
      var b, R;
      return [t.inboundWay === i(T).OPENING_RECEIPT.V ? (a(), o(f, { key: 0, name: i(T).VL[t.inboundWay], color: (b = i(T).V[t.inboundWay]) == null ? void 0 : b.COLOR }, null, 8, ["name", "color"])) : s("", true), V("span", null, _((R = t.inboundReceipt) == null ? void 0 : R.inboundTime), 1)];
    }), _: 1 })) : s("", true)]), afterMaterialSn: c(() => [i(n).visible("materialSnNew") ? (a(), o(e, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })) : s("", true)]), _: 1 }, 8, ["basic-class", "columns"]), r(de, { "basic-class": d.value, columns: i(n) }, null, 8, ["basic-class", "columns"]), r(be, { "basic-class": d.value, columns: i(n) }, null, 8, ["basic-class", "columns"]), $.value ? (a(), o(he, { key: 0, columns: i(n), "show-amount": L.value, "show-amount-excluding-v-a-t": Y.value, "show-invoice-type": "", "show-tax-rate": "", "show-unit-price-e": "" }, null, 8, ["columns", "show-amount", "show-amount-excluding-v-a-t"])) : s("", true), i(n).visible("project.serialNumber") ? (a(), o(e, { key: "project.serialNumber", "show-overflow-tooltip": false, align: "center", label: "项目编号", "min-width": "150px", prop: "project.serialNumber" }, { default: c(({ row: { sourceRow: t } }) => {
      var b;
      return [V("span", null, _(((b = t.project) == null ? void 0 : b.serialNumber) || "-"), 1)];
    }), _: 1 })) : s("", true), r(fe, { columns: i(n), "show-project": "" }, null, 8, ["columns"]), i(n).visible("inboundReceipt.purchaseOrder") ? (a(), o(e, { key: "inboundReceipt.purchaseOrder", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "155", prop: "inboundReceipt.purchaseOrder" }, { default: c(({ row: t }) => [t.inboundReceipt ? (a(), o(i(O), { key: 0, receipt: t.inboundReceipt.purchaseOrder, "receipt-types": ["PURCHASE"] }, null, 8, ["receipt"])) : s("", true)]), _: 1 })) : s("", true), i(n).visible("inboundReceipt.serialNumber") ? (a(), o(e, { key: "inboundReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "入库单号", "min-width": "155", prop: "inboundReceipt.serialNumber" }, { default: c(({ row: t }) => [r(i(O), { receipt: t.inboundReceipt, "receipt-types": ["INBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : s("", true), i(n).visible("inboundReceipt.licensePlate") ? (a(), o(e, { key: "inboundReceipt.licensePlate", "show-overflow-tooltip": true, align: "left", label: "车牌/船牌号", prop: "inboundReceipt.licensePlate", width: "100" })) : s("", true), i(n).visible("inboundReceipt.shipmentNumber") ? (a(), o(e, { key: "inboundReceipt.shipmentNumber", align: "left", label: "物流单号", "min-width": "150", prop: "inboundReceipt.shipmentNumber", "show-overflow-tooltip": "" })) : s("", true), i(n).visible("inboundReceipt.supplier.name") ? (a(), o(e, { key: "inboundReceipt.supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "200", prop: "inboundReceipt.supplier.name" })) : s("", true), i(n).visible("inboundReceipt.applicantName") ? (a(), o(e, { key: "inboundReceipt.applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "inboundReceipt.applicantName" })) : s("", true), i(n).visible("inboundReceipt.editorName") ? (a(), o(e, { key: "inboundReceipt.editorName", "show-overflow-tooltip": true, align: "center", label: "编辑人", "min-width": "100", prop: "inboundReceipt.editorName" })) : s("", true), i(n).visible("inboundReceipt.reviewerName") ? (a(), o(e, { key: "inboundReceipt.reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "inboundReceipt.reviewerName" })) : s("", true), i(n).visible("inboundReceipt.createTime") ? (a(), o(e, { key: "inboundReceipt.createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "inboundReceipt.createTime", width: "125" }, { default: c(({ row: t }) => [S(_(t.inboundReceipt.createTime), 1)]), _: 1 })) : s("", true), i(n).visible("inboundReceipt.reviewTime") ? (a(), o(e, { key: "inboundReceipt.reviewTime", "show-overflow-tooltip": true, prop: "inboundReceipt.reviewTime", label: "审核时间", align: "center", width: "125" }, { default: c(({ row: t }) => [S(_(t.inboundReceipt.reviewTime), 1)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[g, i(m).loading]]), r(i(we))]);
  };
} }, je = J(ye, [["__scopeId", "data-v-82cc4f2f"]]);
export {
  je as default
};
