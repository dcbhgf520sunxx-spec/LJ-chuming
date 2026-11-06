import { inject as R } from "vue";
import { computed as o } from "vue";
import { ref as y } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as l } from "vue";
import { createBlock as c } from "vue";
import { withCtx as m } from "vue";
import { createVNode as r } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as h } from "vue";
import { createElementVNode as A } from "vue";
import { createTextVNode as Y } from "vue";
import { toDisplayString as B } from "vue";
import { createElementBlock as $ } from "vue";
import { Fragment as I } from "vue";
import { ElTableColumn as L } from "element-plus";
import { _ as H, t as M, jX as O, bD as W, D as n, gt as q, jY as G, o as K, ib as z, jV as X, gS as Z, G as J, jZ as Q, j_ as ee, j$ as ae, cO as te, jl as se, Ae as oe, xn as ne, aR as ie, k4 as le, jG as re, jH as ue, k5 as ce, jI as me, k6 as de, ba as pe, jN as he } from "../../../../../../../shared/runtime.js";
const _e = { __name: "detail", setup(fe) {
  const { decimalPrecision: d } = M(), N = R("permission"), T = o(() => [...O, ["invoiceType", ["parse-enum", W, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", d.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", d.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", d.value.wms]], ["unitPriceNoFreight", ["to-thousand", d.value.wms]], ["amount", ["to-thousand", n.YUAN]], ["amountExcludingVAT", ["to-thousand", n.YUAN]], ["amountNoFreight", ["to-thousand", n.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", n.YUAN]], ["inputVAT", ["to-thousand", n.YUAN]], ["inputVATNoFreight", ["to-thousand", n.YUAN]], ["remark", "empty-text"], ["monomerName", "empty-text"], ["areaName", "empty-text"]]), E = y(), _ = y([]), { CRUD: V, crud: u, detail: e } = q(), { inboundFillWayCfg: w } = G(), { maxHeight: k } = K({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => o(() => !u.detailLoading)), t = o(() => e.purchaseOrder || {}), P = o(() => e.reviewStatus === z.PASS.V && t.value.logisticsPayerType === X.DEMAND.V), C = o(() => w.value ? w.value.amountFillWay === Z.APPLICATION.V : false), f = o(() => J(N.showAmount) && C.value), g = o(() => {
    var i;
    return ((i = t.value) == null ? void 0 : i.supplyType) === Q.PARTY_A.V;
  }), F = o(() => e.basicClass & ee.MANUFACTURED.V), S = o(() => e.inboundWay === ae.OPENING_RECEIPT.V ? u.detailLoading ? "入库单" : `入库单：${e.serialNumber}` : u.detailLoading ? "入库单" : `入库单：${e.serialNumber}（ ${t.value.supplier ? t.value.supplier.name : "无供应商"} ）`), b = o(() => {
    const i = f.value && !g.value && t.value.projects && t.value.requisitionsSN, s = f.value && g.value && t.value.projects && t.value.requisitionsSN;
    return !(i || s);
  });
  V.HOOK.beforeDetailLoaded = async (i, s) => {
    await te(s.list), s.list = await se(s.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  };
  function j(i) {
    return pe(i, { props: ["quantity", ["mete", he.weight.precision], ["amount", n.YUAN], ["amountExcludingVAT", n.YUAN], ["inputVAT", n.YUAN], ["amountNoFreight", n.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight"] });
  }
  return (i, s) => {
    const v = L, U = x("common-table"), D = x("common-drawer");
    return l(), c(D, { ref_key: "drawerRef", ref: E, "before-close": a(u).cancelDetail, "content-loading": a(u).detailLoading, "show-close": true, title: S.value, visible: a(u).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: m(() => [r(oe, { detail: a(e), order: t.value }, null, 8, ["detail", "order"])]), titleRight: m(() => [r(ne, { "purchase-id": t.value.id, size: "default" }, null, 8, ["purchase-id"])]), content: m(() => [r(U, { data: a(e).list, "data-format": T.value, "expand-row-keys": _.value, "max-height": a(k), "summary-method": j, "row-key": "id", "show-summary": "" }, { default: m(() => [r(ie, { "expand-row-keys": _.value, "onUpdate:expandRowKeys": s[0] || (s[0] = (p) => _.value = p), data: a(e).list, fixed: "left", "row-key": "id" }, { default: m(({ row: p }) => [b.value ? h("", true) : (l(), c(le, { key: 0, "basic-class": a(e).basicClass, row: p, "show-brand": "" }, null, 8, ["basic-class", "row"])), A("p", null, [s[1] || (s[1] = Y(" 备注：")), A("span", null, B(p.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), r(re, { "basic-class": a(e).basicClass, fixed: "left" }, null, 8, ["basic-class"]), r(ue, { "basic-class": a(e).basicClass }, null, 8, ["basic-class"]), b.value ? (l(), c(ce, { key: 0, "basic-class": a(e).basicClass }, null, 8, ["basic-class"])) : h("", true), f.value ? (l(), $(I, { key: 1 }, [g.value ? h("", true) : (l(), c(me, { key: 0, showFreight: P.value }, null, 8, ["showFreight"]))], 64)) : h("", true), r(v, { align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" }), F.value ? (l(), c(v, { key: 3, align: "left", label: "仓库", "min-width": "120px", prop: "workshop.name", "show-overflow-tooltip": "" })) : (l(), c(de, { key: 2 }))]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, be = H(_e, [["__scopeId", "data-v-6aba5b29"]]);
export {
  be as default
};
