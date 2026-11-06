import { inject as V } from "vue";
import { useStore as N } from "vuex";
import { computed as v } from "vue";
import { ref as f } from "vue";
import { watch as j } from "vue";
import { onMounted as B } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as z } from "vue";
import { createElementBlock as F } from "vue";
import { createVNode as s } from "vue";
import { withCtx as d } from "vue";
import { unref as o } from "vue";
import { ElDatePicker as M } from "element-plus";
import { p as q, a as G } from "../../../../../../../modules/data-e72242cc.js";
import { uD as H, e3 as J, cy as K, e2 as g, b as L, ec as Q } from "../../../../../../../shared/runtime.js";
import { b as R, d as W, g as X } from "../../../../../../../modules/index-dfff0f60.js";
import { g as Y } from "../../../../../../../modules/subcontract-payment-attribute-37f9bab7.js";
const Z = { class: "header-container" }, oe = { __name: "header", props: { projectList: { type: Array, default: () => [] } }, setup(w) {
  const _ = V("size"), U = N(), C = v(() => U.getters.user.id), D = V("payment_data"), { formData: e, projectInfo: I, paymentTypelist: u } = D, m = f([]), p = f([]), h = f([]), k = v(() => H(J(G, I)));
  j(() => C.value, (t) => {
    e.applicantId = t;
  }, { immediate: true });
  const A = async () => {
    try {
      const t = await R({ projectId: e.projectId });
      if (!t || Object.keys(t).length === 0) {
        m.value = [], g("warning", "暂无供应商");
        return;
      }
      m.value = Object.entries(t).map(([r, n]) => ({ id: Number(r), value: n, name: n }));
    } catch (t) {
      console.log("获取供应商失败:", t);
    }
  }, S = async () => {
    try {
      const { content: t } = await Y();
      if (!t || Object.keys(t).length === 0) {
        m.value = [], g("warning", "暂无付款属性");
        return;
      }
      h.value = t || [];
    } catch (t) {
      console.log("获取付款属性", t);
    }
  }, x = async () => {
    try {
      const t = await W({ supplierId: e.supplierId, projectId: e.projectId });
      if (!t || Object.keys(t).length === 0) {
        g("warning", "该分包商下暂无合同号"), p.value = [];
        return;
      }
      p.value = Object.entries(t).map(([r, n]) => ({ id: Number(r), name: n })).sort((r, n) => n.id - r.id);
    } catch (t) {
      console.error("获取采购合同列表失败:", t);
    }
  }, O = async () => {
    var t;
    try {
      const { invoiceDto: r, projectName: n, paymentDto: b } = await X({ orderIds: e.orderIds });
      Object.assign(I, r[0], { projectName: n }), (t = u == null ? void 0 : u.value) != null && t.length && (u.value = []), u.value = b, e.paymentBank = null, e.paymentBankAccount = null, Q(r).forEach((c) => {
        c.moneyAmount = "", c.supplierPaymentId = c.orderId, e.tableList.some((l) => l.orderId === c.orderId) || (e.tableList = [], e.tableList.push(c));
      });
    } catch (r) {
      console.log(r);
    }
  };
  j(() => e.tableList.length, (t) => {
    t > 0 ? _.value = "60%" : _.value = "50%";
  }), B(() => {
    S();
  });
  const P = async () => {
    p.value = [], e.tableList = [], e.orderIds = null, L(e.supplierId) || await x();
  }, E = async (t) => {
    e.tableList = [], L(e.orderIds) || await O();
  };
  return (t, r) => {
    const n = y("table-header"), b = M, i = y("common-select-v2"), c = y("descriptions-list");
    return z(), F("div", Z, [s(n, { "header-title": "基本信息" }), s(c, { column: 2, "form-data": o(e), "form-rules": o(q), "table-list": k.value }, { applyDate: d(({ item: a }) => [s(b, { modelValue: o(e)[a], "onUpdate:modelValue": (l) => o(e)[a] = l, clearable: "", placeholder: "请选择创建日期", type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), applicantId: d(({ item: a }) => [s(K, { modelValue: o(e)[a], "onUpdate:modelValue": (l) => o(e)[a] = l, placeholder: "选择创建人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), projectId: d(({ item: a }) => [s(i, { modelValue: o(e)[a], "onUpdate:modelValue": (l) => o(e)[a] = l, options: w.projectList, clearable: "", filterable: "", placeholder: "请选择项目", type: "other", onChange: A }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), supplierId: d(({ item: a }) => [s(i, { modelValue: o(e)[a], "onUpdate:modelValue": (l) => o(e)[a] = l, options: m.value, clearable: "", filterable: "", placeholder: "请输入或选择分包商", type: "other", onChange: P }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), orderIds: d(({ item: a }) => [s(i, { modelValue: o(e)[a], "onUpdate:modelValue": (l) => o(e)[a] = l, disabled: !p.value.length, options: p.value, clearable: "", filterable: "", placeholder: "请输入或选择分包合同号", type: "other", onChange: E }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options"])]), paymentAttributeId: d(({ item: a }) => [s(i, { modelValue: o(e)[a], "onUpdate:modelValue": (l) => o(e)[a] = l, disabled: !h.value.length, options: h.value, clearable: "", filterable: "", placeholder: "请输入或选择付款属性", type: "other" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  oe as default
};
