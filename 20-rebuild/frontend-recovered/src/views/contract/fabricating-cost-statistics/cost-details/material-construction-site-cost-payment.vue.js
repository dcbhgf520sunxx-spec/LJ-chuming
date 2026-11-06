import { ref as i } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as b } from "vue";
import { createBlock as g } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as v } from "vue";
import { createElementVNode as R } from "vue";
import { withDirectives as Y } from "vue";
import { unref as u } from "vue";
import { isRef as z } from "vue";
import { ElTag as L } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { vLoading as P } from "element-plus";
import { m as T } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as U, u as j, o as E, iv as q, D as p, ba as O } from "../../../../shared/runtime.js";
const G = { class: "content-header" }, J = { __name: "material-construction-site-cost-payment", props: { modelValue: { type: Boolean, default: false }, detailInfo: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(l, { emit: x }) {
  const w = x, f = l, _ = i(), y = i(), c = i(false), { visible: m, handleClose: C } = j({ emit: w, props: f, showHook: A, closeHook: D }), { maxHeight: I } = E({ mainBox: ".material-construction-site-cost-payment", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, _), V = i([["paymentDate", ["parse-time", "{y}-{m}-{d}"]], ["type", ["parse-enum", q]], ["paymentAmount", ["to-thousand", p.YUAN]]]);
  async function k() {
    var o;
    c.value = true;
    try {
      const a = { orderId: (o = f.detailInfo) == null ? void 0 : o.id }, s = await T(a);
      y.value = s;
    } catch (a) {
      console.log(a);
    } finally {
      c.value = false;
    }
  }
  function A() {
    k();
  }
  function D() {
  }
  function H(o) {
    return O(o, { props: ["totalYield", "projectYield", ["amortizationAmount", p.YUAN], ["totalFee", p.YUAN]], toThousandFields: ["amortizationAmount", "totalFee"] });
  }
  return (o, a) => {
    const s = L, N = d("print-table"), r = M, B = d("common-table"), S = d("common-drawer"), F = P;
    return b(), g(S, { ref_key: "drawerRef", ref: _, title: "累计付款明细", "close-on-click-modal": false, modelValue: u(m), "onUpdate:modelValue": a[0] || (a[0] = (e) => z(m) ? m.value = e : null), direction: "rtl", "before-close": u(C), "wrapper-closable": false, "custom-class": "material-construction-site-cost-payment", size: "890px" }, { titleAfter: n(() => [t(s, null, { default: n(() => {
      var e;
      return [h("合同编号：" + v(((e = l.detailInfo) == null ? void 0 : e.serialNumber) || "-"), 1)];
    }), _: 1 }), t(s, { type: "warning" }, { default: n(() => {
      var e;
      return [h("供应商：" + v(((e = l.detailInfo) == null ? void 0 : e.supplierName) || "-"), 1)];
    }), _: 1 })]), content: n(() => {
      var e;
      return [R("div", G, [t(N, { "api-key": "materialConstructionSitePaymentRecord", params: { orderId: (e = l.detailInfo) == null ? void 0 : e.id }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), Y((b(), g(B, { data: y.value, "max-height": u(I), "summary-method": H, "data-format": V.value, border: "", "show-summary": "", stripe: "" }, { default: n(() => [t(r, { align: "center", label: "序号", type: "index" }), t(r, { align: "center", label: "付款日期", prop: "paymentDate", width: "100" }), t(r, { align: "center", label: "付款类型", prop: "type" }), t(r, { align: "center", label: "付款金额", prop: "paymentAmount" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[F, c.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, X = U(J, [["__scopeId", "data-v-09e76cb5"]]);
export {
  X as default
};
