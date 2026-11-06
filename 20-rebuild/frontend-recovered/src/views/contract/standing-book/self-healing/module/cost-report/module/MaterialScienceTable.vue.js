import { _ as C, lp as u, o as E, D as a, j0 as I } from "../../../../../../../shared/runtime.js";
import { ref as l } from "vue";
import { inject as d } from "vue";
import { watchEffect as _ } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as R } from "vue";
import { createElementBlock as Y } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as t } from "vue";
import { withCtx as b } from "vue";
import { toDisplayString as j } from "vue";
import { unref as c } from "vue";
import { Fragment as k } from "vue";
import { defineAsyncComponent as B } from "vue";
import { ElTableColumn as M } from "element-plus";
import { u as V } from "../../../../../../../modules/useTableTotal-3d22365a.js";
import { g as F } from "../../../../../../../modules/index-d4be09aa.js";
const H = { class: "managementFee-table animate__fadeIn" }, L = ["onClick"], O = { __name: "MaterialScienceTable", emits: ["updateSum"], setup(K, { emit: g }) {
  const m = l([]), i = l(false), p = l(), h = B(() => I(() => import("./PaymentRecord.vue.js"), ["static/js/PaymentRecord-83af4ae3.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/index-d4be09aa.js", "static/css/PaymentRecord-fafe786e.css"])), v = g, { projectInfo: y } = d("tableItem"), { radioType: r } = d("common"), A = l(), x = async () => {
    var o, n;
    try {
      const { content: e } = await F({ costTypeEnum: u[r.value].V, projectId: (n = (o = y.value) == null ? void 0 : o.project) == null ? void 0 : n.id });
      m.value = e;
    } catch (e) {
      console.log(e);
    }
  };
  _(async () => {
    r.value && r.value !== u.PERIOD_COST.K && await x();
  });
  const { getSummaries: T, _sums: w } = V(false, { defineData: ["contractAmount", "settlementAmount", "totalPaid", "unpaid", "cost", "preSettlementAmount"] }), { maxHeight: S } = E({ wrapperBox: [".drawer-right-container"], extraBox: [".header-container"], extraHeight: 60, paginate: false });
  _(() => {
    v("updateSum", w.value[6]);
  });
  const N = (o) => {
    p.value = o, i.value = true;
  }, D = l([["signingDate", ["parse-time", "{y}-{m}-{d}"]], ["contractAmount", ["to-thousand", a.YUAN]], ["settlementAmount", ["to-thousand", a.YUAN]], ["totalPaid", ["to-thousand", a.YUAN]], ["unpaid", ["to-thousand", a.YUAN]], ["cost", ["to-thousand", a.YUAN]], ["preSettlementAmount", ["to-thousand", a.YUAN]]]);
  return (o, n) => {
    const e = M, P = U("common-table");
    return R(), Y(k, null, [f("div", H, [t(P, { ref_key: "tableRef", ref: A, data: m.value, "data-format": D.value, "max-height": c(S), "summary-method": c(T), "show-summary": "", stripe: "" }, { default: b(() => [t(e, { align: "center", label: "序号", type: "index", width: "60" }), t(e, { align: "center", label: "签订日期", prop: "signingDate", width: "120" }), t(e, { align: "center", label: "供应商", "min-width": "120", prop: "supplierName" }), t(e, { align: "center", label: "合同编号", "min-width": "100", prop: "serialNumber", "show-overflow-tooltip": "" }), t(e, { align: "center", label: "合同额", prop: "contractAmount" }), t(e, { align: "center", label: "成本", prop: "cost" }), t(e, { align: "center", label: "累计预结算额", prop: "preSettlementAmount" }), t(e, { align: "center", label: "结算额", prop: "settlementAmount" }), t(e, { align: "center", label: "累计支付", prop: "totalPaid" }, { default: b(({ row: s }) => [f("span", { class: "specialText", onClick: ($) => N(s) }, j(s.totalPaid), 9, L)]), _: 1 }), t(e, { align: "center", label: "未支付", prop: "unpaid" })]), _: 1 }, 8, ["data", "data-format", "max-height", "summary-method"])]), t(c(h), { visible: i.value, "onUpdate:visible": n[0] || (n[0] = (s) => i.value = s), "item-info": p.value }, null, 8, ["visible", "item-info"])], 64);
  };
} }, Q = C(O, [["__scopeId", "data-v-b3a11f62"]]);
export {
  Q as default
};
