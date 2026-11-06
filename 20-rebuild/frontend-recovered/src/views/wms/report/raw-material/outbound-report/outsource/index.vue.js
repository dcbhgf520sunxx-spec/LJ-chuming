import { ref as y } from "vue";
import { computed as b } from "vue";
import { watch as $ } from "vue";
import { resolveComponent as q } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as i } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as s } from "vue";
import { toDisplayString as H } from "vue";
import { ElTableColumn as M } from "element-plus";
import { vLoading as K } from "element-plus";
import { g as G, a as Q } from "../../../../../../modules/outbound-13fff63c.js";
import { _ as X, t as W, jX as z, bD as J, D as p, jY as Z, x as ee, Ca as k, o as te, G as oe, sQ as ae, cO as A, jl as E, j_ as ie, x_ as se, aR as ne, k4 as ue, jG as re, k5 as le, jH as ce, vb as me, k6 as pe, ux as de, P as he, ba as be, jN as we } from "../../../../../../shared/runtime.js";
import fe from "./module/header.vue.js";
import ve from "./module/project-list.vue.js";
import "../../../../../../modules/reset-query-5216307c.js";
const _e = { class: "wrap" }, ge = { class: "wrap-left" }, ye = { class: "wrap-right" }, Ne = { class: "report-material-outbound-details app-container" }, xe = { __name: "index", setup(Re) {
  const { decimalPrecision: f } = W(), P = { add: false, edit: false, del: false, download: false }, v = y([]), N = y(), j = b(() => [...z, ["invoiceType", ["parse-enum", J, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", f.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", f.value.wms]], ["unitPriceNoFreight", ["to-thousand", f.value.wms]], ["amount", ["to-thousand", p.YUAN]], ["amountExcludingVAT", ["to-thousand", p.YUAN]], ["amountNoFreight", ["to-thousand", p.YUAN]], ["inputVAT", ["to-thousand", p.YUAN]], ["outboundReceipt.outboundTime", "parse-time"], ["outboundReceipt.reviewTime", "parse-time"], ["outboundReceipt.createTime", "parse-time"]]), { reportCfg: x } = Z(), { CRUD: D, crud: n, columns: t } = ee({ title: "出库明细", sort: ["id.desc"], invisibleColumns: ["outboundReceipt.applicantName", "outboundReceipt.reviewerName", "outboundReceipt.createTime", "recipientName", "invoiceType", "taxRate"], permission: { ...k }, optShow: { ...P }, crudApi: { get: G } }, N), { maxHeight: S } = te({ paginate: true }), U = b(() => !!x.value.amountShow), V = b(() => !!x.value.amountExcludingTAXShow), F = b(() => oe(k.showAmount)), l = b(() => n.query ? n.query.basicClass : void 0), { baseUnit: R } = ae(l.value), _ = y();
  function B(h) {
    n.query.projectId = h, n.toQuery();
  }
  D.HOOK.handleRefresh = async (h, { data: c }) => {
    await A(c.content), c.content = await E(c.content, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), c.content.forEach((m) => {
      m.outboundReceipt || (m.outboundReceipt = {});
    });
    const o = [];
    c.content.forEach((m) => {
      Array.isArray(m.rejectList) && m.rejectList.forEach((g) => {
        o.push(g.material);
      });
    }), await A(o), await E(o, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  }, $(() => n.query, async () => {
    _.value = await Q(n.query), l.value & ie.STEEL.V && await se(_.value, { unit: R.value[l.value].weight.unit, precision: R.value[l.value].weight.precision, fields: ["meteCount"], toSmallest: false, toNum: true });
  }, { deep: true, immutable: true });
  function L(h) {
    return be(h, { props: ["quantity", ["mete", we.weight.precision], ["amount", p.YUAN], ["amountExcludingVAT", p.YUAN], ["amountNoFreight", p.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "amountNoFreight"] });
  }
  return (h, c) => {
    const o = M, m = q("common-table"), g = I("parse-time"), Y = K;
    return a(), O("div", _e, [w("div", ge, [r(e(ve), { onProjectChange: B })]), w("div", ye, [w("div", Ne, [r(e(fe), { DetailsCount: _.value }, null, 8, ["DetailsCount"]), C((a(), i(m, { ref_key: "tableRef", ref: N, data: e(n).data, "data-format": j.value, "default-expand-all": false, "expand-row-keys": v.value, "max-height": e(S), "summary-method": L, "highlight-current-row": "", "row-key": "id", "show-summary": "", style: { width: "100%" }, onSortChange: e(n).handleSortChange }, { default: d(() => [r(ne, { "expand-row-keys": v.value, "onUpdate:expandRowKeys": c[0] || (c[0] = (u) => v.value = u), data: e(n).data, fixed: "left", "row-key": "id" }, { default: d(({ row: u }) => [l.value ? s("", true) : (a(), i(ue, { key: 0, "basic-class": u.basicClass, row: u }, null, 8, ["basic-class", "row"]))]), _: 1 }, 8, ["expand-row-keys", "data"]), r(re, { "basic-class": l.value, columns: e(t), "classify-name-alias": "名称", "show-classification": "", "show-outbound-mode": "", "spec-merge": "" }, { afterIndex: d(() => [e(t).visible("outboundReceipt.outboundTime") ? (a(), i(o, { key: "outboundReceipt.outboundTime", "show-overflow-tooltip": true, align: "center", label: "出库时间", prop: "outboundReceipt.outboundTime", sortable: "custom", width: "125" }, { default: d(({ row: u }) => [C(w("span", null, null, 512), [[g, u.outboundReceipt.outboundTime]])]), _: 1 })) : s("", true), e(t).visible("outboundReceipt.reviewTime") ? (a(), i(o, { key: "outboundReceipt.reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "outboundReceipt.reviewTime", width: "125" })) : s("", true)]), _: 1 }, 8, ["basic-class", "columns"]), r(le, { "basic-class": l.value, columns: e(t) }, null, 8, ["basic-class", "columns"]), r(ce, { "basic-class": l.value, columns: e(t) }, null, 8, ["basic-class", "columns"]), F.value ? (a(), i(me, { key: 0, columns: e(t), "show-amount": U.value, "show-amount-excluding-v-a-t": V.value, "show-invoice-type": "", "show-unit-price-e": "" }, null, 8, ["columns", "show-amount", "show-amount-excluding-v-a-t"])) : s("", true), e(t).visible("project.serialNumber") ? (a(), i(o, { key: "project.serialNumber", "show-overflow-tooltip": false, align: "center", label: "项目编号", "min-width": "150px", prop: "project.serialNumber" }, { default: d(({ row: { sourceRow: u } }) => {
      var T;
      return [w("span", null, H(((T = u.project) == null ? void 0 : T.serialNumber) || "-"), 1)];
    }), _: 1 })) : s("", true), r(pe, { columns: e(t), "show-area": false, "show-monomer": false, "show-project": "", "show-workshop": "" }, null, 8, ["columns"]), e(t).visible("outboundReceipt.serialNumber") ? (a(), i(o, { key: "outboundReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "出库单号", "min-width": "155", prop: "outboundReceipt.serialNumber" }, { default: d(({ row: u }) => [r(e(de), { receipt: u.outboundReceipt, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : s("", true), e(t).visible("outboundReceipt.applicantName") ? (a(), i(o, { key: "outboundReceipt.applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "outboundReceipt.applicantName" })) : s("", true), e(t).visible("recipientName") ? (a(), i(o, { key: "recipientName", "show-overflow-tooltip": true, align: "center", label: "领料人", "min-width": "100", prop: "recipientName" })) : s("", true), e(t).visible("outboundReceipt.reviewerName") ? (a(), i(o, { key: "outboundReceipt.reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "outboundReceipt.reviewerName" })) : s("", true), e(t).visible("outboundReceipt.createTime") ? (a(), i(o, { key: "outboundReceipt.createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "outboundReceipt.createTime", width: "125" })) : s("", true), e(t).visible("remark") ? (a(), i(o, { key: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "150px", prop: "remark" })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[Y, e(n).loading]]), r(e(he))])])]);
  };
} }, je = X(xe, [["__scopeId", "data-v-0260941c"]]);
export {
  je as default
};
