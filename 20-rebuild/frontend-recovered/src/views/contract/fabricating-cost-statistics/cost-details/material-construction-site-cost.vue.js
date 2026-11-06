import { ref as l } from "vue";
import { inject as M } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as N } from "vue";
import { createBlock as k } from "vue";
import { withCtx as i } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as p } from "vue";
import { createElementVNode as C } from "vue";
import { unref as u } from "vue";
import { withDirectives as q } from "vue";
import { isRef as z } from "vue";
import { ElTag as F } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { vLoading as $ } from "element-plus";
import { n as G } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as J, u as K, o as Q, D as e, bV as W, ba as X } from "../../../../shared/runtime.js";
import Z from "./material-construction-site-cost-payment.vue.js";
const tt = { class: "content-header" }, et = ["onClick"], ot = { __name: "material-construction-site-cost", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(m, { emit: D }) {
  const S = D, w = m, v = l(), U = l(), y = l(), d = l(false);
  M("query");
  const f = l(0), A = l({}), h = l(false), { visible: g, handleClose: V } = K({ emit: S, props: w, showHook: P, closeHook: R }), { maxHeight: Y } = Q({ mainBox: ".material-construction-site-cost", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, v), I = l([["signingDate", ["parse-time", "{y}-{m}-{d}"]], ["contractAmount", ["to-thousand", e.YUAN]], ["cost", ["to-thousand", e.YUAN]], ["preSettlementAmount", ["to-thousand", e.YUAN]], ["settlementAmount", ["to-thousand", e.YUAN]], ["totalPaid", ["to-thousand", e.YUAN]], ["unpaid", ["to-thousand", e.YUAN]]]);
  async function j() {
    var n;
    d.value = true, f.value = 0;
    try {
      const a = { projectId: (n = w.currentData) == null ? void 0 : n.projectId }, c = await G(a);
      c.forEach((_) => {
        f.value += _.totalPaid || 0;
      }), y.value = c;
    } catch (a) {
      console.log(a);
    } finally {
      d.value = false;
    }
  }
  function H(n) {
    A.value = n, h.value = true;
  }
  function P() {
    j();
  }
  function R() {
  }
  function B(n) {
    return X(n, { props: [["contractAmount", e.YUAN], ["cost", e.YUAN], ["preSettlementAmount", e.YUAN], ["settlementAmount", e.YUAN], ["totalPaid", e.YUAN], ["unpaid", e.YUAN]], toThousandFields: ["contractAmount", "cost", "preSettlementAmount", "settlementAmount", "totalPaid", "unpaid"] });
  }
  return (n, a) => {
    const c = F, _ = b("print-table"), o = O, T = b("common-table"), E = b("common-drawer"), L = $;
    return N(), k(E, { ref_key: "drawerRef", ref: v, title: "原材直发工地成本", "close-on-click-modal": false, modelValue: u(g), "onUpdate:modelValue": a[1] || (a[1] = (r) => z(g) ? g.value = r : null), direction: "rtl", "before-close": u(V), "wrapper-closable": false, "custom-class": "material-construction-site-cost", size: "80%" }, { titleAfter: i(() => [t(c, null, { default: i(() => {
      var r, s;
      return [x("项目：" + p(((r = m.currentData) == null ? void 0 : r.serialNumber) || "-") + " " + p(((s = m.currentData) == null ? void 0 : s.projectName) || "-"), 1)];
    }), _: 1 })]), content: i(() => {
      var r;
      return [C("div", tt, [t(c, null, { default: i(() => [x("累计支付：" + p(u(W)(f.value, u(e).YUAN)), 1)]), _: 1 }), t(_, { "api-key": "materialConstructionSiteCostReport", params: { projectId: (r = m.currentData) == null ? void 0 : r.projectId }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), q((N(), k(T, { ref_key: "tableRef", ref: U, data: y.value, "max-height": u(Y), "data-format": I.value, "summary-method": B, "show-summary": "", showEmptySymbol: "" }, { default: i(() => [t(o, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), t(o, { "show-overflow-tooltip": "", prop: "signingDate", key: "signingDate", label: "签订日期", align: "center", width: "120" }), t(o, { "show-overflow-tooltip": "", prop: "supplierName", key: "supplierName", label: "供应商", align: "center", "min-width": "130" }), t(o, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "合同编号", align: "center", "min-width": "150" }), t(o, { "show-overflow-tooltip": "", prop: "contractAmount", key: "contractAmount", label: "合同额（元）", align: "right" }), t(o, { "show-overflow-tooltip": "", prop: "cost", key: "cost", label: "成本", align: "right" }), t(o, { "show-overflow-tooltip": "", prop: "preSettlementAmount", key: "preSettlementAmount", label: "累计预结算额", align: "right" }), t(o, { "show-overflow-tooltip": "", prop: "settlementAmount", key: "settlementAmount", label: "结算额（元）", align: "right" }), t(o, { "show-overflow-tooltip": "", prop: "totalPaid", key: "totalPaid", label: "累计支付（元）", align: "right" }, { default: i(({ row: s }) => [C("span", { onClick: (at) => H(s), style: { cursor: "pointer", color: "#409eff" } }, p(s.totalPaid), 9, et)]), _: 1 }), t(o, { "show-overflow-tooltip": "", prop: "unpaid", key: "unpaid", label: "未支付（元）", align: "right" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[L, d.value]]), t(Z, { modelValue: h.value, "onUpdate:modelValue": a[0] || (a[0] = (s) => h.value = s), detailInfo: A.value }, null, 8, ["modelValue", "detailInfo"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, it = J(ot, [["__scopeId", "data-v-52e898c6"]]);
export {
  it as default
};
