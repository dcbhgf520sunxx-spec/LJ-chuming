import { ref as r } from "vue";
import { inject as L } from "vue";
import { computed as P } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as x } from "vue";
import { createBlock as I } from "vue";
import { withCtx as i } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as b } from "vue";
import { createElementVNode as h } from "vue";
import { withDirectives as k } from "vue";
import { unref as l } from "vue";
import { isRef as F } from "vue";
import { ElTag as G } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { vLoading as K } from "element-plus";
import { q as Q } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as W, u as X, o as Z, D as m, G as j, ba as $ } from "../../../../shared/runtime.js";
import { z as w } from "../../../../modules/contract-9b18cc88.js";
const ee = { class: "content-header" }, te = { __name: "no-main-business-income", props: { modelValue: { type: Boolean, default: false }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(c, { emit: B }) {
  const M = B, y = c, v = r(), D = r(), s = r(), p = r(false), g = L("query"), { visible: d, handleClose: A } = X({ emit: M, props: y, showHook: S, closeHook: V }), { maxHeight: N } = Z({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, v);
  P(() => {
    var a, e;
    return ((a = s.value) == null ? void 0 : a[0].yearMonth) + "~" + ((e = s.value) == null ? void 0 : e[s.value.length - 1].yearMonth);
  });
  const O = r([["wasteSale", ["to-thousand", m.YUAN]], ["amortizationAmount", ["to-thousand", m.YUAN]]]);
  async function R() {
    var a;
    if (!j(w.nonMainBusinessIncome)) return false;
    p.value = true;
    try {
      const e = { projectId: (a = y.currentData) == null ? void 0 : a.projectId, boolTaxIncluded: g.boolTaxIncluded }, f = await Q(e);
      s.value = f;
    } catch (e) {
      console.log(e);
    } finally {
      p.value = false;
    }
  }
  function S() {
    R();
  }
  function V() {
  }
  function z(a) {
    return $(a, { props: ["totalOutput", "projectOutput", ["wasteSale", m.YUAN], ["amortizationAmount", m.YUAN]], toThousandFields: ["wasteSale", "amortizationAmount"] });
  }
  return (a, e) => {
    const f = G, H = _("print-table"), o = J, T = _("common-table"), C = _("common-drawer"), U = Y("permission"), q = K;
    return x(), I(C, { ref_key: "drawerRef", ref: v, title: "非主营业务收入", "close-on-click-modal": false, modelValue: l(d), "onUpdate:modelValue": e[0] || (e[0] = (n) => F(d) ? d.value = n : null), direction: "rtl", "before-close": l(A), "wrapper-closable": false, "custom-class": "amount-detail", size: "70%" }, { titleAfter: i(() => [t(f, null, { default: i(() => {
      var n, u;
      return [E("项目：" + b(((n = c.currentData) == null ? void 0 : n.serialNumber) || "-") + " " + b(((u = c.currentData) == null ? void 0 : u.projectName) || "-"), 1)];
    }), _: 1 })]), content: i(() => {
      var n;
      return [h("div", ee, [e[1] || (e[1] = h("div", null, null, -1)), k(t(H, { "api-key": "nonMainBusinessIncome", params: { projectId: (n = c.currentData) == null ? void 0 : n.projectId, boolTaxIncluded: l(g).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"]), [[U, l(w).nonMainBusinessIncomePrint]])]), k((x(), I(T, { ref_key: "tableRef", ref: D, data: s.value, "max-height": l(N), "empty-text": l(j)(l(w).nonMainBusinessIncome) ? "暂无数据" : "暂无权限", "data-format": O.value, "summary-method": z, "show-summary": "" }, { default: i(() => [t(o, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), t(o, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }), t(o, { "show-overflow-tooltip": "", prop: "totalOutput", key: "totalOutput", label: "总产量（吨）", align: "center" }), t(o, { "show-overflow-tooltip": "", prop: "projectOutput", key: "projectOutput", label: "项目产量（吨）", align: "center" }), t(o, { "show-overflow-tooltip": "", prop: "projectOutputRatio", key: "projectOutputRatio", label: "占比", align: "center" }, { default: i((u) => [h("span", null, b(u.row.projectOutputRatio || "0") + "%", 1)]), _: 1 }), t(o, { "show-overflow-tooltip": "", prop: "wasteSale", key: "wasteSale", label: "废料出售（元）", align: "center" }), t(o, { "show-overflow-tooltip": "", prop: "amortizationAmount", key: "amortizationAmount", label: "摊销金额（元/吨）", align: "center" })]), _: 1 }, 8, ["data", "max-height", "empty-text", "data-format"])), [[q, p.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, se = W(te, [["__scopeId", "data-v-ca31adc4"]]);
export {
  se as default
};
