import { u as q, kc as F, j0 as m, uT as K, e2 as M } from "../../../../../shared/runtime.js";
import { ref as o } from "vue";
import { computed as d } from "vue";
import { provide as h } from "vue";
import { useStore as $ } from "vuex";
import { resolveComponent as G } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as H } from "vue";
import { createVNode as I } from "vue";
import { withCtx as _ } from "vue";
import { createTextVNode as J } from "vue";
import { toDisplayString as Q } from "vue";
import { createBlock as E } from "vue";
import { resolveDynamicComponent as W } from "vue";
import { unref as y } from "vue";
import { isRef as X } from "vue";
import { Fragment as Y } from "vue";
import { defineAsyncComponent as f } from "vue";
import { nextTick as Z } from "vue";
import { ElButton as ee } from "element-plus";
import { p as te, d as ae } from "../../../../../modules/payment-settlement-a7865af1.js";
import { p as oe } from "../../../../../modules/invoice-entry-d5222a89.js";
import se from "../payment-settlement/oa-approval/index.vue.js";
import "../../../../../modules/index-70e7196a.js";
const pe = { __name: "index", props: { visible: { type: Boolean, default: false }, item_data: { type: Object, default: () => {
} }, current_key: { type: String }, title: { type: String } }, emits: ["update:visible"], setup(P, { emit: V }) {
  const a = P, b = V, { visible: n, handleClose: D } = q({ emit: b, props: a, field: "visible" }), x = o(false), w = o("50%"), C = { payment: f(() => m(() => import("./payment/index.vue.js"), ["static/js/index-97b4c270.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-3e441c92.js", "static/js/data-e85015ff.js", "static/js/payment-settlement-a7865af1.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/info-bbbe1651.js", "static/js/payment-settlement-e8e799d8.js", "static/js/second-table-254a6575.js", "static/js/useTableTotal-3d22365a.js", "static/css/second-table-65d5f40d.css", "static/js/payment-info-c9dd48b2.js", "static/js/data-33e35578.js", "static/css/index-3a8c3a95.css"])), settle: f(() => m(() => import("./settle/index.vue.js"), ["static/js/index-b9ffc87c.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-1bb0a2b6.js", "static/js/data-e85015ff.js", "static/js/payment-settlement-a7865af1.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/info-bbbe1651.js", "static/js/payment-settlement-e8e799d8.js", "static/js/second-table-5783fa95.js", "static/js/useTableTotal-3d22365a.js", "static/js/contract-info-cf37c38d.js", "static/css/index-1349ee42.css"])), invoice: f(() => m(() => import("./invoice/index.vue.js"), ["static/js/index-8cb652b0.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-c65512b3.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/invoice-entry-fec44303.js", "static/js/payment-settlement-a7865af1.js", "static/js/info-bbbe1651.js", "static/js/payment-settlement-e8e799d8.js", "static/js/second-table-57e18b97.js", "static/js/useTableTotal-3d22365a.js", "static/css/second-table-7c20d455.css", "static/js/invoice-info-686325e3.js", "static/css/index-809f9025.css"])) }, N = d(() => C[a.current_key]), k = o(), g = o([]);
  h("saveList", g);
  const i = o(false);
  function l() {
    M("success", "发起审批成功"), b("update:visible", false);
  }
  const r = $();
  async function S(t) {
    t.orderIds = [t.orderId], t.supplierPayment = [], t.tableList.forEach((e) => {
      t.supplierPayment.push({ moneyAmount: e.moneyAmount, supplierPaymentId: e.supplierPaymentId });
    });
    try {
      const e = await te(t);
      s.value = e.data, l(), await r.dispatch("approval_list/fetchApprovalNum");
    } catch (e) {
      console.log(e);
    }
  }
  async function L(t) {
    try {
      const e = await ae(t);
      s.value = e.data, l(), await r.dispatch("approval_list/fetchApprovalNum");
    } catch (e) {
      console.log(e);
    }
  }
  async function R(t) {
    try {
      await oe(t), l(), await r.dispatch("approval_list/fetchApprovalNum");
    } catch (e) {
      console.log(e);
    }
  }
  async function T(t) {
    let e = "";
    a.current_key === "payment" ? e = "材料合同款项支付审批流程（初鸣）" : a.current_key === "settle" && (e = "外委加工合同审批/结算流程（初鸣）"), await K({ requestName: e, sqr: r.getters.user.oaUserId });
  }
  const c = o(false), A = o();
  function B() {
    A.value = Math.random();
  }
  const u = o(), { crud: z } = F(), s = o(), O = async () => {
    try {
      i.value = true, await Promise.all(g.value.map((e) => e()));
      const t = k.value.formData;
      switch (s.value = null, a.current_key) {
        case "payment":
          u.value = 0, await S(t);
          break;
        case "settle":
          u.value = 1, await L(t);
          break;
        case "invoice":
          await R(t);
      }
      a.current_key !== "invoice" && s.value && (await T(), await B(), await Z(() => {
        s != null && s.value && (c.value = true);
      }));
    } catch (t) {
      console.log("发起审批失败", t);
    } finally {
      i.value = false;
    }
  };
  return h("common", { size: w, item_data: d(() => a.item_data), dataId: d(() => s.value) }), (t, e) => {
    const j = ee, U = G("common-drawer");
    return v(), H(Y, null, [I(U, { ref_key: "drawer_ref", ref: x, modelValue: y(n), "onUpdate:modelValue": e[0] || (e[0] = (p) => X(n) ? n.value = p : null), "append-to-body": true, "before-close": y(D), "destroy-on-close": true, size: w.value, title: a.title }, { titleRight: _(() => [I(j, { loading: i.value, type: a.current_key !== "invoice" ? "primary" : "success", size: "default", onClick: O }, { default: _(() => [J(Q(a.current_key !== "invoice" ? "预 览" : "发起审批"), 1)]), _: 1 }, 8, ["loading", "type"])]), content: _(() => [(v(), E(W(N.value), { ref_key: "current_com_ref", ref: k }, null, 512))]), _: 1 }, 8, ["modelValue", "before-close", "size", "title"]), (v(), E(se, { key: A.value, visible: c.value, "onUpdate:visible": e[1] || (e[1] = (p) => c.value = p), crud: y(z), "radio-type": u.value }, null, 8, ["visible", "crud", "radio-type"]))], 64);
  };
} };
export {
  pe as default
};
