import { _ as U, t as Y, gt as j, jX as C, bD as H, D as a, o as S, G as $, jV as L, jZ as I, cO as M, jl as O, AH as q, xn as z, jG as G, k5 as K, jH as X, jI as Z, k6 as J, yB as Q, ba as W, jN as ee } from "../../../../../../shared/runtime.js";
import { inject as ae } from "vue";
import { ref as _ } from "vue";
import { computed as o } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as g } from "vue";
import { openBlock as m } from "vue";
import { createBlock as f } from "vue";
import { withCtx as u } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as w } from "vue";
import { createElementBlock as te } from "vue";
import { Fragment as se } from "vue";
import { createCommentVNode as b } from "vue";
import { createElementVNode as d } from "vue";
const oe = { class: "remark" }, ie = { __name: "detail", setup(ne) {
  const { decimalPrecision: c } = Y(), p = ae("permission"), A = _(), v = _([]), { CRUD: x, crud: l, detail: t } = j(), y = o(() => [...C, ["invoiceType", ["parse-enum", H, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", c.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", c.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", c.value.wms]], ["unitPriceNoFreight", ["to-thousand", c.value.wms]], ["amount", ["to-thousand", a.YUAN]], ["amountExcludingVAT", ["to-thousand", a.YUAN]], ["amountNoFreight", ["to-thousand", a.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", a.YUAN]], ["inputVAT", ["to-thousand", a.YUAN]], ["inputVATNoFreight", ["to-thousand", a.YUAN]], ["outboundReceipt.outboundTime", "parse-time"], ["outboundReceipt.reviewTime", "parse-time"], ["outboundReceipt.createTime", "parse-time"], ["realTime", "parse-time"]]), { maxHeight: N } = S({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => o(() => !l.detailLoading)), i = o(() => t.purchaseOrder || {}), T = o(() => $(p.showAmount)), V = o(() => i.value.logisticsPayerType === L.DEMAND.V), D = o(() => {
    var n;
    return ((n = i.value) == null ? void 0 : n.supplyType) === I.PARTY_A.V;
  }), E = o(() => l.detailLoading ? "退货单" : `退货单：${t.serialNumber}（ ${i.value.supplier ? i.value.supplier.name : ""} ）`);
  x.HOOK.beforeDetailLoaded = async (n, r) => {
    await M(r.list), r.list = await O(r.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  };
  function F(n) {
    return W(n, { props: ["quantity", ["mete", ee.weight.precision], ["amount", a.YUAN], ["amountExcludingVAT", a.YUAN], ["inputVAT", a.YUAN], ["amountNoFreight", a.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight"] });
  }
  return (n, r) => {
    const P = h("common-table"), k = h("common-drawer"), B = g("permission"), R = g("empty-text");
    return m(), f(k, { ref_key: "drawerRef", ref: A, visible: e(l).detailVisible, "content-loading": e(l).detailLoading, "before-close": e(l).cancelDetail, title: E.value, "show-close": true, size: "100%", "custom-class": "raw-mat-inbound-application-record-detail" }, { titleAfter: u(() => [s(q, { order: i.value, detail: e(t) }, null, 8, ["order", "detail"])]), titleRight: u(() => [w(s(z, { "purchase-id": i.value.id, size: "default" }, null, 8, ["purchase-id"]), [[B, e(p).purchaseOrderDetail]])]), content: u(() => [s(P, { data: e(t).list, "data-format": y.value, "max-height": e(N), "show-summary": "", "summary-method": F, "expand-row-keys": v.value, "row-key": "id" }, { default: u(() => [s(G, { "basic-class": e(t).basicClass }, null, 8, ["basic-class"]), s(K, { "basic-class": e(t).basicClass }, null, 8, ["basic-class"]), s(X, { "basic-class": e(t).basicClass }, null, 8, ["basic-class"]), T.value ? (m(), te(se, { key: 0 }, [D.value ? b("", true) : (m(), f(Z, { key: 0, "show-unit-price-e": "", showFreight: V.value }, null, 8, ["showFreight"]))], 64)) : b("", true), s(J, { "show-project": "", "show-monomer": false, "show-area": false }), s(Q, { label: "实际退货时间" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"]), d("p", oe, [r[0] || (r[0] = d("span", { class: "label-after" }, "备注", -1)), w(d("span", null, null, 512), [[R, e(t).remark]])])]), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, ce = U(ie, [["__scopeId", "data-v-68852816"]]);
export {
  ce as default
};
