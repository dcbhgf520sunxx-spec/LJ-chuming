import { inject as U } from "vue";
import { ref as N } from "vue";
import { computed as n } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as p } from "vue";
import { createBlock as w } from "vue";
import { withCtx as u } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as Y } from "vue";
import { createCommentVNode as _ } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as I } from "vue";
import { ElTableColumn as $ } from "element-plus";
import { _ as H, t as M, gt as O, jX as q, bD as K, D as i, o as z, G, jV as X, jZ as Z, cO as V, jl as P, V as J, k0 as y, xm as Q, xn as W, aR as ee, i as ae, AI as te, jG as se, k5 as ie, jH as oe, jI as ne, k6 as re, yB as le, ba as ce, jN as ue } from "../../../../../../shared/runtime.js";
import me from "../../../../material-inbound/raw-material/components/inspection-return-info.vue.js";
const de = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px" } }, pe = { __name: "detail", setup(he) {
  const { decimalPrecision: h } = M(), A = U("permission"), L = N(), f = N([]), { CRUD: k, crud: m, detail: t } = O(), F = n(() => [...q, ["invoiceType", ["parse-enum", K, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", h.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", h.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", h.value.wms]], ["unitPriceNoFreight", ["to-thousand", h.value.wms]], ["amount", ["to-thousand", i.YUAN]], ["amountExcludingVAT", ["to-thousand", i.YUAN]], ["amountNoFreight", ["to-thousand", i.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", i.YUAN]], ["inputVAT", ["to-thousand", i.YUAN]], ["inputVATNoFreight", ["to-thousand", i.YUAN]], ["realTime", "parse-time"]]), { maxHeight: S } = z({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header", ".inspection-return-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => n(() => !m.detailLoading)), r = n(() => t.purchaseOrder || {}), b = n(() => G(A.showAmount)), j = n(() => r.value.logisticsPayerType === X.DEMAND.V), x = n(() => {
    var l;
    return ((l = r.value) == null ? void 0 : l.supplyType) === Z.PARTY_A.V;
  }), D = n(() => m.detailLoading ? "入库单" : `入库单：${t.serialNumber}（ ${r.value.supplier ? r.value.supplier.name : "无供应商"} ）`);
  k.HOOK.beforeDetailLoaded = async (l, a) => {
    await V(a.list), await P(a.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
    const d = [];
    a.list.forEach((o) => {
      Array.isArray(o.rejectList) && o.rejectList.forEach((g) => {
        d.push(g.material);
      });
    }), await V(d), await P(d, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), a.originList = J(a.list), a.list = a.originList.filter((o) => o.qualityTestingEnum & (y.ALL_PASS.V | y.NO.V)), a.returnList = a.originList.filter((o) => o.qualityTestingEnum & y.ALL_REFUSE.V);
  };
  function C(l) {
    return ce(l, { props: ["quantity", ["mete", ue.weight.precision], ["amount", i.YUAN], ["amountExcludingVAT", i.YUAN], ["inputVAT", i.YUAN], ["amountNoFreight", i.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight"] });
  }
  return (l, a) => {
    const d = $, o = T("common-table"), g = T("common-drawer"), R = B("permission");
    return p(), w(g, { ref_key: "drawerRef", ref: L, "before-close": e(m).cancelDetail, "content-loading": e(m).detailLoading, "show-close": true, title: D.value, visible: e(m).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: u(() => [s(Q, { detail: e(t), order: r.value }, null, 8, ["detail", "order"])]), titleRight: u(() => [Y(s(W, { "purchase-id": r.value.id, size: "default" }, null, 8, ["purchase-id"]), [[R, e(A).purchaseOrderDetail]])]), content: u(() => {
      var v;
      return [(v = e(t).returnList) != null && v.length ? (p(), w(me, { key: 0, "basic-class": e(t).basicClass, boolPartyA: x.value, list: e(t).returnList, showAmount: b.value, showTableColumnSecondary: true, class: "inspection-return-info" }, null, 8, ["basic-class", "boolPartyA", "list", "showAmount"])) : _("", true), s(o, { data: e(t).list, "data-format": F.value, "expand-row-keys": f.value, "max-height": e(S), "summary-method": C, "row-key": "id", "show-summary": "" }, { default: u(() => [s(ee, { "expand-row-keys": f.value, "onUpdate:expandRowKeys": a[0] || (a[0] = (c) => f.value = c), data: e(t).list, fixed: "left", "row-key": "id" }, { default: u(({ row: c }) => [e(ae)(c.rejectList) ? (p(), E("div", de, [s(te, { "basic-class": c.basicClass, list: c.rejectList, material: c, stripe: false, operable: "", style: { width: "1600px" } }, null, 8, ["basic-class", "list", "material"])])) : _("", true)]), _: 1 }, 8, ["expand-row-keys", "data"]), s(se, { "basic-class": e(t).basicClass, "show-reject-status": "" }, { afterMaterialSn: u(() => [s(d, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), s(ie, { "basic-class": e(t).basicClass }, null, 8, ["basic-class"]), s(oe, { "basic-class": e(t).basicClass }, null, 8, ["basic-class"]), b.value ? (p(), E(I, { key: 0 }, [x.value ? _("", true) : (p(), w(ne, { key: 0, showFreight: j.value, "show-unit-price-e": "" }, null, 8, ["showFreight"]))], 64)) : _("", true), s(re, { "show-project": "", "show-monomer": false, "show-area": false }), s(le, { label: "实际入库时间" })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])];
    }), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, we = H(pe, [["__scopeId", "data-v-d6c1a759"]]);
export {
  we as default
};
