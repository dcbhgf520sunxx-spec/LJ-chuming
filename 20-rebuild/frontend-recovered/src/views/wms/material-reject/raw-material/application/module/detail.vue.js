import { _ as V, t as H, jX as S, bD as U, D as n, gt as P, o as $, G as I, jZ as Y, cO as x, jl as y, i as v, AH as O, xn as F, aR as K, AI as M, jG as q, k5 as z, jH as G, vb as X, k6 as Z, ba as J, jN as Q } from "../../../../../../shared/runtime.js";
import { inject as W } from "vue";
import { computed as l } from "vue";
import { ref as g } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as p } from "vue";
import { createBlock as T } from "vue";
import { withCtx as d } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as ae } from "vue";
import { createElementBlock as k } from "vue";
import { createCommentVNode as h } from "vue";
import { Fragment as se } from "vue";
const te = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px" } }, ie = { __name: "detail", setup(oe) {
  const { decimalPrecision: b } = H(), w = W("permission"), j = l(() => [...S, ["invoiceType", ["parse-enum", U, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", b.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", b.value.wms]], ["amount", ["to-thousand", n.YUAN]], ["amountExcludingVAT", ["to-thousand", n.YUAN]], ["inputVAT", ["to-thousand", n.YUAN]]]), D = g(), _ = g([]), { CRUD: N, crud: r, detail: s } = P(), { maxHeight: R } = $({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => l(() => !r.detailLoading)), E = l(() => I(w.showAmount)), c = l(() => s.purchaseOrder || {}), L = l(() => {
    var o;
    return ((o = c.value) == null ? void 0 : o.supplyType) === Y.PARTY_A.V;
  }), B = l(() => r.detailLoading ? "入库单" : `入库单：${s.serialNumber}（ ${c.value.supplier ? c.value.supplier.name : ""} ）`);
  N.HOOK.beforeDetailLoaded = async (o, i) => {
    await x(i.list), i.list = await y(i.list, { toSmallest: false, toNum: false });
    const u = [], f = [];
    i.list.forEach((m) => {
      v(m.rejectList) && (f.push(m.id), m.rejectList.forEach((t) => {
        u.push(t.material);
      }));
    }), await x(u), await y(u);
  };
  function C(o) {
    return J(o, { props: ["quantity", ["mete", Q.weight.precision], ["amount", n.YUAN], ["amountExcludingVAT", n.YUAN], ["inputVAT", n.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT"] });
  }
  return (o, i) => {
    const u = A("common-table"), f = A("common-drawer"), m = ee("permission");
    return p(), T(f, { ref_key: "drawerRef", ref: D, visible: e(r).detailVisible, "content-loading": e(r).detailLoading, "before-close": e(r).cancelDetail, title: B.value, "show-close": true, size: "100%", "custom-class": "raw-mat-inbound-application-record-detail" }, { titleAfter: d(() => [a(O, { order: c.value, detail: e(s) }, null, 8, ["order", "detail"])]), titleRight: d(() => [ae(a(F, { "purchase-id": c.value.id, size: "default" }, null, 8, ["purchase-id"]), [[m, e(w).purchaseOrderDetail]])]), content: d(() => [a(u, { data: e(s).list, "data-format": j.value, "max-height": e(R), "show-summary": "", "summary-method": C, "expand-row-keys": _.value, "row-key": "id" }, { default: d(() => [a(K, { data: e(s).list, "expand-row-keys": _.value, "onUpdate:expandRowKeys": i[0] || (i[0] = (t) => _.value = t), "row-key": "id", fixed: "left" }, { default: d(({ row: { sourceRow: t } }) => [e(v)(t.rejectList) ? (p(), k("div", te, [a(M, { stripe: false, material: t, "basic-class": t.basicClass, list: t.rejectList, style: { width: "1600px" }, operable: "" }, null, 8, ["material", "basic-class", "list"])])) : h("", true)]), _: 1 }, 8, ["data", "expand-row-keys"]), a(q, { "basic-class": e(s).basicClass, "show-reject-status": "" }, null, 8, ["basic-class"]), a(z, { "basic-class": e(s).basicClass }, null, 8, ["basic-class"]), a(G, { "basic-class": e(s).basicClass }, null, 8, ["basic-class"]), E.value ? (p(), k(se, { key: 0 }, [L.value ? h("", true) : (p(), T(X, { key: 0 }))], 64)) : h("", true), a(Z, { "show-project": "", "show-monomer": false, "show-area": false })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, re = V(ie, [["__scopeId", "data-v-6bbc0a0f"]]);
export {
  re as default
};
