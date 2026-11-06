import { computed as v } from "vue";
import { watch as O } from "vue";
import { ref as _ } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as d } from "vue";
import { createBlock as h } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as V } from "vue";
import { createElementVNode as $ } from "vue";
import { withDirectives as T } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { isRef as G } from "vue";
import { ElTag as J } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElPagination as K } from "element-plus";
import { vLoading as Q } from "element-plus";
import { i as W } from "../../../../../modules/payment-ledger-cb1d373c.js";
import { t as X, u as Z, J as ee, D as ae, o as te, cO as oe, jl as ne, jG as ie, jH as le, jI as se, ba as re } from "../../../../../shared/runtime.js";
const ue = { class: "print-wrap" }, de = { __name: "inbound-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(r, { emit: F }) {
  const { decimalPrecision: e } = X(), I = F, i = r, { visible: u, handleClose: A } = Z({ emit: I, props: i }), { handleSizeChange: P, handleCurrentChange: z, total: E, setTotalPage: S, queryPage: g } = ee({ fetchHook: N }), w = v(() => i.detailInfo.id ? { orderId: i.detailInfo.id } : { supplierId: i.detailInfo.supplierId });
  O(u, (o) => {
    o && N();
  });
  const B = v(() => false), y = _([]), C = _(), f = _(false), k = v(() => [["unitPrice", ["to-thousand", e.value.supplyChain]], ["amount", ["to-thousand", e.value.supplyChain]], ["unitPriceExcludingVAT", ["to-thousand", e.value.supplyChain]], ["unitPriceNoFreight", ["to-thousand", e.value.supplyChain]], ["amountExcludingVAT", ["to-thousand", e.value.supplyChain]], ["amountNoFreight", ["to-thousand", ae.YUAN]], ["inputVAT", ["to-thousand", e.value.supplyChain]], ["inputVATNoFreight", ["to-thousand", e.value.supplyChain]], ["inboundTime", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: R } = te({ mainBox: ".inbound-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, C);
  function j(o) {
    return re(o, { props: [["amount", e.value.supplyChain], ["amountExcludingVAT", e.value.supplyChain], ["amountNoFreight", e.value.supplyChain], ["inputVAT", e.value.supplyChain], ["inputVATNoFreight", e.value.supplyChain], ["mete", 5]], toThousandFields: ["amount", "amountNoFreight", "amountExcludingVAT", "amountExcludingVATNoFreight", "inputVAT", "inputVATNoFreight", "mete"] });
  }
  async function N() {
    let o = [];
    f.value = true;
    try {
      const { content: l = [], totalElements: c } = await W({ ...w.value, ...g, purchaseSn: i.detailInfo.serialNumber });
      let n = l;
      n.length > 0 && (await oe(n), n = await ne(n, { toSmallest: false, toNum: true }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] })), o = n, S(c);
    } catch (l) {
      console.log("获取入库记录失败", l);
    } finally {
      y.value = o, f.value = false;
    }
  }
  return (o, l) => {
    const c = J, n = b("print-table"), p = Y, H = b("common-table"), D = K, L = b("common-drawer"), q = U("permission"), M = Q;
    return d(), h(L, { ref_key: "drawerRef", ref: C, modelValue: t(u), "onUpdate:modelValue": l[0] || (l[0] = (m) => G(u) ? u.value = m : null), "before-close": t(A), "close-on-click-modal": false, "custom-class": "inbound-record", direction: "rtl", size: "100%", title: "入库记录" }, { titleAfter: s(() => [r.detailInfo.serialNumber ? (d(), h(c, { key: 0, effect: "plain", size: "large", type: "success" }, { default: s(() => [x(" 采购合同编号：" + V(r.detailInfo.serialNumber), 1)]), _: 1 })) : (d(), h(c, { key: 1, effect: "plain", size: "large", type: "warning" }, { default: s(() => [x("供应商：" + V(r.detailInfo.supplierName), 1)]), _: 1 }))]), titleRight: s(() => {
      var m;
      return [$("div", ue, [T(a(n, { params: { ...w.value }, "api-key": "purchaseInboundRecord", size: "default", type: "warning" }, null, 8, ["params"]), [[q, (m = i.permission) == null ? void 0 : m.print]])])];
    }), content: s(() => [T((d(), h(H, { data: y.value, "data-format": k.value, "max-height": t(R), "summary-method": j, "show-summary": "" }, { default: s(() => [a(ie, { columns: {}, "spec-merge": "" }), a(le, { columns: {} }), a(se, { columns: {}, "show-tax-rate": true, showFreight: B.value }, null, 8, ["showFreight"]), a(p, { align: "center", label: "入库时间", prop: "inboundTime", "show-overflow-tooltip": "", width: "90" }), a(p, { align: "center", label: "入库单号", "min-width": "110", prop: "inboundSerialNumber", "show-overflow-tooltip": "" }), a(p, { align: "center", label: "入库人", prop: "applicantName", "show-overflow-tooltip": "", width: "90" }), a(p, { align: "center", label: "审核人", prop: "reviewerName", "show-overflow-tooltip": "", width: "90" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[M, f.value]]), a(D, { "current-page": t(g).pageNumber, "page-size": t(g).pageSize, total: t(E), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: t(P), onCurrentChange: t(z) }, null, 8, ["current-page", "page-size", "total", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  de as default
};
