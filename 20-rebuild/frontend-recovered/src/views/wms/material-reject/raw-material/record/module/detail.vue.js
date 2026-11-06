import { inject as S } from "vue";
import { ref as g } from "vue";
import { computed as o } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as i } from "vue";
import { createBlock as u } from "vue";
import { withCtx as n } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as m } from "vue";
import { createElementBlock as Y } from "vue";
import { Fragment as H } from "vue";
import { createElementVNode as _ } from "vue";
import { withDirectives as L } from "vue";
import { ElTag as R } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { _ as $, t as I, jX as M, bD as O, D as t, gt as K, o as q, G, jZ as X, jV as Z, cO as J, jl as Q, AH as W, AK as ee, bV as ae, xn as te, zr as se, jG as oe, k5 as ie, jH as ne, jI as re, k6 as le, yB as ce, ba as ue, jN as me } from "../../../../../../shared/runtime.js";
const de = { class: "remark" }, pe = { __name: "detail", setup(_e) {
  const { decimalPrecision: p } = I(), A = S("permission"), x = g(), N = g([]), T = o(() => [...M, ["invoiceType", ["parse-enum", O, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", p.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", p.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", p.value.wms]], ["unitPriceNoFreight", ["to-thousand", p.value.wms]], ["amount", ["to-thousand", t.YUAN]], ["amountExcludingVAT", ["to-thousand", t.YUAN]], ["amountNoFreight", ["to-thousand", t.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", t.YUAN]], ["inputVAT", ["to-thousand", t.YUAN]], ["inputVATNoFreight", ["to-thousand", t.YUAN]], ["realTime", "parse-time"]]), { CRUD: v, crud: d, detail: a } = K(), { maxHeight: V } = q({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header", ".unfreeze-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => o(() => !d.detailLoading)), r = o(() => a.purchaseOrder || {}), h = o(() => G(A.showAmount)), k = o(() => {
    var l;
    return ((l = r.value) == null ? void 0 : l.supplyType) === X.PARTY_A.V;
  }), E = o(() => r.value.logisticsPayerType === Z.DEMAND.V), F = o(() => d.detailLoading ? "退货单" : `退货单：${a.serialNumber}（ ${r.value.supplier ? r.value.supplier.name : ""} ）`);
  v.HOOK.beforeDetailLoaded = async (l, c) => {
    await J(c.list), c.list = await Q(c.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  };
  function D(l) {
    return ue(l, { props: ["quantity", ["mete", me.weight.precision], ["amount", t.YUAN], ["amountExcludingVAT", t.YUAN], ["inputVAT", t.YUAN], ["amountNoFreight", t.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight"] });
  }
  return (l, c) => {
    const f = R, P = z, j = w("common-table"), U = w("common-drawer"), C = B("empty-text");
    return i(), u(U, { ref_key: "drawerRef", ref: x, "before-close": e(d).cancelDetail, "content-loading": e(d).detailLoading, "show-close": true, title: F.value, visible: e(d).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: n(() => [s(W, { detail: e(a), order: r.value }, null, 8, ["detail", "order"]), e(a).rejectFreightType ? (i(), u(f, { key: 0 }, { default: n(() => [y(b(e(ee).VL[e(a).rejectFreightType]), 1)]), _: 1 })) : m("", true), e(a).freight ? (i(), u(f, { key: 1, type: "warning" }, { default: n(() => [y("退运费金额:" + b(e(ae)(e(a).freight, e(t).YUAN)), 1)]), _: 1 })) : m("", true)]), titleRight: n(() => [h.value ? (i(), u(te, { key: 0, "purchase-id": r.value.id, size: "default" }, null, 8, ["purchase-id"])) : m("", true)]), content: n(() => [e(a).boolHasUnfreeze ? (i(), u(se, { key: 0, "basic-class": e(a).basicClass, list: e(a).unfreezeList, class: "unfreeze-info" }, null, 8, ["basic-class", "list"])) : m("", true), s(j, { data: e(a).list, "data-format": T.value, "expand-row-keys": N.value, "max-height": e(V), "summary-method": D, "row-key": "id", "show-summary": "" }, { default: n(() => [s(oe, { "basic-class": e(a).basicClass }, { afterMaterialSn: n(() => [s(P, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), s(ie, { "basic-class": e(a).basicClass }, null, 8, ["basic-class"]), s(ne, { "basic-class": e(a).basicClass }, null, 8, ["basic-class"]), h.value ? (i(), Y(H, { key: 0 }, [k.value ? m("", true) : (i(), u(re, { key: 0, showFreight: E.value }, null, 8, ["showFreight"]))], 64)) : m("", true), s(le, { "show-project": "", "show-monomer": false, "show-area": false }), s(ce, { label: "实际退货时间" })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"]), _("p", de, [c[0] || (c[0] = _("span", { class: "label-after" }, "备注", -1)), L(_("span", null, null, 512), [[C, e(a).remark]])])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, ge = $(pe, [["__scopeId", "data-v-8da6396b"]]);
export {
  ge as default
};
