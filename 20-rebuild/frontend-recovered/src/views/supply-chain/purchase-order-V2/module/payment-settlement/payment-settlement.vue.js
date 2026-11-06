import { _ as J, kc as Q, dp as W, j0 as g, b as X, e2 as h, uT as Y } from "../../../../../shared/runtime.js";
import { ref as a } from "vue";
import { provide as w } from "vue";
import { computed as A } from "vue";
import { useStore as Z } from "vuex";
import { onMounted as ee } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as te } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { createBlock as E } from "vue";
import { createTextVNode as r } from "vue";
import { createCommentVNode as ae } from "vue";
import { createElementVNode as oe } from "vue";
import { resolveDynamicComponent as se } from "vue";
import { unref as le } from "vue";
import { defineAsyncComponent as V } from "vue";
import { nextTick as k } from "vue";
import { ElTag as ne } from "element-plus";
import { ElButton as ie } from "element-plus";
import { ElRadio as re } from "element-plus";
import { ElRadioGroup as ue } from "element-plus";
import { ElDrawer as pe } from "element-plus";
import { p as z, e as B, d as C } from "../../../../../modules/payment-settlement-a7865af1.js";
import de from "./oa-approval/index.vue.js";
import "../../../../../modules/index-70e7196a.js";
const ce = { class: "drawer-container" }, me = { class: "radio-container" }, _e = { __name: "payment-settlement", emits: ["component-mounted"], setup(ve, { expose: L, emit: D }) {
  const i = a(0), u = a(false), v = a(false), p = a(null), P = a([]);
  w("saveList", P);
  const f = a("50%");
  w("size", f), w("common", { orderId: a(void 0), projectId: a(void 0), settleForm: a(void 0), contractSignBodyId: a(void 0), contractSignBodyName: a(void 0), dataId: A(() => o.value) });
  const R = [{ name: V(() => g(() => import("./payment/index.vue.js"), ["static/js/index-2bb9379b.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-a0d8f6e2.js", "static/js/data-33e35578.js", "static/js/payment-settlement-a7865af1.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/hook-467b8301.js", "static/js/second-table-c8ff6193.js", "static/js/useTableTotal-3d22365a.js", "static/js/storage-detail-54216f73.js", "static/css/storage-detail-edd8d65c.css", "static/css/second-table-27f3750c.css", "static/js/payment-info-ced7371b.js", "static/css/index-7e42fcdd.css"])), api: z }, { name: V(() => g(() => import("./pre-settlement/index.vue.js"), ["static/js/index-bca7b909.js", "static/js/header-29320316.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/data-33e35578.js", "static/js/payment-settlement-a7865af1.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/hook-467b8301.js", "static/js/pre-settlement-info-d265599f.js", "static/css/index-059172f3.css"])), api: B }, { name: V(() => g(() => import("./settlement/index.vue.js"), ["static/js/index-86d9e4e8.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-8f20fa54.js", "static/js/data-33e35578.js", "static/js/payment-settlement-a7865af1.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/hook-467b8301.js", "static/js/second-table-151567cd.js", "static/js/useTableTotal-3d22365a.js", "static/js/contract-info-0a1a581c.js", "static/css/index-740d17e0.css"])), api: C }], U = A(() => R[i.value].name);
  function y() {
    h("success", "操作成功"), u.value = false;
  }
  async function j(e) {
    try {
      if (e.supplierPayment.length > 0 && e.supplierPayment.splice(0), e.tableList.forEach((l) => {
        e.supplierPayment.push({ moneyAmount: l.moneyAmount, supplierPaymentId: l.supplierPaymentId });
      }), e.tableList.some((l) => X(l.moneyAmount))) h("error", "本次付款不能为空");
      else {
        const l = await z(e);
        o.value = l.data, await S(), y(), await c.dispatch("approval_list/fetchApprovalNum"), await k(() => {
          o != null && o.value && (m.value = true);
        });
      }
    } catch (t) {
      console.log("付款申请失败", t);
    }
  }
  async function F(e) {
    try {
      const t = await C(e);
      o.value = t.data, await S(), y(), await c.dispatch("approval_list/fetchApprovalNum"), await k(() => {
        o != null && o.value && (m.value = true);
      });
    } catch {
      console.log("结算申请失败");
    }
  }
  const c = Z();
  async function T() {
    let e = "";
    i.value === 0 ? e = "材料合同款项支付审批流程（初鸣）" : (i.value === 1 || i.value === 2) && (e = "材料合同结算资料盖章申请流程（初鸣）"), await Y({ requestName: e, sqr: c.getters.user.oaUserId });
  }
  async function O(e) {
    try {
      await B(e), y(), await c.dispatch("approval_list/fetchApprovalNum");
    } catch {
      console.log("预结算申请失败");
    }
  }
  const o = a(), m = a(false), q = () => {
    try {
      v.value = true, Promise.all(P.value.map((e) => e())).then(() => {
        o.value = null, k(async () => {
          const e = p.value.formData;
          e.tableList ? (await T(), await j(e)) : e.boolSettlement ? (await T(), await F(e)) : e.boolPreSettlement && await O(e);
        });
      }).catch((e) => {
        console.log("校验失败" + e);
      });
    } catch (e) {
      console.log("发起审批失败;" + e);
    } finally {
      v.value = false;
    }
  }, M = D;
  ee(() => {
    M("component-mounted", true);
  });
  const G = A(() => {
    var e, t;
    return !((t = (e = p == null ? void 0 : p.value) == null ? void 0 : e.formData) != null && t.supplierId);
  }), I = a(0);
  function S() {
    I.value = Math.random();
  }
  const { crud: H } = Q(), x = () => {
    u.value = false, f.value = "50%";
  };
  return L({ visible: u }), (e, t) => {
    const l = ne, N = ie, b = re, K = ue, $ = pe;
    return _(), te("div", ce, [n($, { modelValue: u.value, "onUpdate:modelValue": t[1] || (t[1] = (d) => u.value = d), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, size: f.value, "destroy-on-close": "", onClose: x }, { header: s(() => [n(W, { "type-one": false, "header-title": "付款与结算" }, { subTitle: s(() => [G.value ? (_(), E(l, { key: 0, size: "default", type: "danger" }, { default: s(() => t[3] || (t[3] = [r("请先选择供应商!")])), _: 1, __: [3] })) : ae("", true)]), _: 1 }), n(N, { loading: v.value, size: "default", type: "primary", onClick: q }, { default: s(() => t[4] || (t[4] = [r("预览")])), _: 1, __: [4] }, 8, ["loading"]), n(N, { size: "default", onClick: x }, { default: s(() => t[5] || (t[5] = [r("关闭")])), _: 1, __: [5] })]), default: s(() => [oe("div", me, [n(K, { modelValue: i.value, "onUpdate:modelValue": t[0] || (t[0] = (d) => i.value = d), size: "default", "text-color": "#409EFF" }, { default: s(() => [n(b, { value: 0 }, { default: s(() => t[6] || (t[6] = [r("付款申请")])), _: 1, __: [6] }), n(b, { value: 1 }, { default: s(() => t[7] || (t[7] = [r("预结算")])), _: 1, __: [7] }), n(b, { value: 2 }, { default: s(() => t[8] || (t[8] = [r("结算申请")])), _: 1, __: [8] })]), _: 1 }, 8, ["modelValue"])]), (_(), E(se(U.value), { ref_key: "currentComponentRef", ref: p, class: "animate__animated animate__fadeIn" }, null, 512))]), _: 1 }, 8, ["modelValue", "size"]), (_(), E(de, { key: I.value, visible: m.value, "onUpdate:visible": t[2] || (t[2] = (d) => m.value = d), crud: le(H), "radio-type": i.value }, null, 8, ["visible", "crud", "radio-type"]))]);
  };
} }, Ee = J(_e, [["__scopeId", "data-v-9b000b98"]]);
export {
  Ee as default
};
