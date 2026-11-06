import { inject as A } from "vue";
import { ref as v } from "vue";
import { computed as B } from "vue";
import { onMounted as F } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as d } from "vue";
import { withCtx as n } from "vue";
import { unref as o } from "vue";
import { Fragment as I } from "vue";
import { renderList as L } from "vue";
import { createBlock as k } from "vue";
import { createTextVNode as i } from "vue";
import { ElDatePicker as M } from "element-plus";
import { ElCascader as Q } from "element-plus";
import { ElOption as R } from "element-plus";
import { ElSelect as T } from "element-plus";
import { p as q, a as z } from "../../../../../../../modules/data-50c44b01.js";
import { u as G } from "../../../../../../../modules/useSelect-654af12a.js";
import { a as H, b as J, g as K } from "../../../../../../../modules/payment-settlement-a7865af1.js";
import { uD as W, e3 as X, e2 as f, b as w, ec as Y, e6 as Z } from "../../../../../../../shared/runtime.js";
const $ = { class: "header-container" }, re = { __name: "header", setup(ee) {
  const C = A("payment_data"), { formData: e, projectInfo: b } = C, { projectLeaderList: U } = G(), m = v([]), p = v([]), j = B(() => W(X(z, b))), D = async () => {
    try {
      const l = await H();
      if (Object.keys(l).length) {
        const t = Object.entries(l).map(([r, c]) => ({ id: Number(r), value: c }));
        m.value = t;
      } else f("warning", "该暂无供应商"), m.value = [];
    } catch (l) {
      console.log(l);
    }
  }, E = async () => {
    try {
      const l = await J({ supplierId: e.supplierId });
      if (Object.keys(l).length) {
        const t = Object.entries(l).map(([r, c]) => ({ id: r, name: c }));
        p.value = t;
      } else f("warning", "该供应商下暂无合同号"), p.value = [];
    } catch {
      p.value = [], f("warning", "该供应商下暂无合同号");
    }
  }, P = async () => {
    try {
      const l = await K({ orderIds: e.orderIds });
      e.tableList.splice(0);
      const t = Y(l);
      e.tableList.push(...t), e.tableList.forEach((r) => {
        r.moneyAmount = "", r.supplierPaymentId = r.orderId;
      });
    } catch (l) {
      console.log(l);
    }
  };
  F(() => {
    D();
  });
  const h = () => {
    Z(b), e.tableList.splice(0, e.tableList.length);
  }, S = async () => {
    h(), e.orderIds.splice(0), w(e.supplierId) || await E();
  }, x = async () => {
    h(), w(e.orderIds) || await P();
  };
  return (l, t) => {
    const r = V("table-header"), c = M, N = Q, g = R, y = T, O = V("descriptions-list");
    return u(), _("div", $, [d(r, { "header-title": "基本信息" }), d(O, { column: 2, "table-list": j.value, "form-rules": o(q), "form-data": o(e) }, { applyDate: n(({ item: s }) => [d(c, { modelValue: o(e)[s], "onUpdate:modelValue": (a) => o(e)[s] = a, type: "date", "value-format": "x", placeholder: "请选择创建日期", clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), applicantId: n(({ item: s }) => [d(N, { modelValue: o(e)[s], "onUpdate:modelValue": (a) => o(e)[s] = a, clearable: "", placeholder: "选择创建人", options: o(U), "show-all-levels": false, filterable: "", props: { value: "id", emitPath: false } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), supplierId: n(({ item: s }) => [d(y, { modelValue: o(e)[s], "onUpdate:modelValue": (a) => o(e)[s] = a, placeholder: "请选择供应商", clearable: "", onChange: S }, { default: n(() => [(u(true), _(I, null, L(m.value, (a) => (u(), k(g, { key: a.id, label: a.value, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), orderIds: n(({ item: s }) => [d(y, { onChange: x, modelValue: o(e)[s], "onUpdate:modelValue": (a) => o(e)[s] = a, placeholder: "请选择采购合同号", clearable: "", multiple: "", disabled: !o(e).supplierId }, { default: n(() => [(u(true), _(I, null, L(p.value, (a) => (u(), k(g, { key: a.id, label: a.name, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), default: n(() => [t[0] || (t[0] = i(" // 创建日期 ")), t[1] || (t[1] = i(" // 创建人 ")), t[2] || (t[2] = i(" // 供应商 ")), t[3] || (t[3] = i(" // 采购合同号 "))]), _: 1, __: [0, 1, 2, 3] }, 8, ["table-list", "form-rules", "form-data"])]);
  };
} };
export {
  re as default
};
