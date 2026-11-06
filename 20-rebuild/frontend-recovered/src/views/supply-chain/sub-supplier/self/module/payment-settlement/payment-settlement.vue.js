import { _ as B, dp as S, b as R, e2 as c, j0 as v } from "../../../../../../shared/runtime.js";
import { ref as s } from "vue";
import { provide as y } from "vue";
import { computed as h } from "vue";
import { useStore as O } from "vuex";
import { onMounted as F } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as l } from "vue";
import { withCtx as a } from "vue";
import { createBlock as V } from "vue";
import { createTextVNode as u } from "vue";
import { createCommentVNode as G } from "vue";
import { createElementVNode as H } from "vue";
import { resolveDynamicComponent as M } from "vue";
import { defineAsyncComponent as I } from "vue";
import { nextTick as Z } from "vue";
import $ from "lodash";
import { ElTag as q } from "element-plus";
import { ElButton as J } from "element-plus";
import { ElRadio as K } from "element-plus";
import { ElRadioGroup as Q } from "element-plus";
import { ElDrawer as W } from "element-plus";
import { p as X, f as Y, h as ee, a as te } from "../../../../../../modules/index-dfff0f60.js";
const ae = { class: "drawer-container" }, oe = { class: "radio-container" }, se = { __name: "payment-settlement", emits: ["component-mounted", "closed"], setup(le, { expose: k, emit: T }) {
  const i = s(0), r = s(false), w = s([]), _ = s(false), p = s(null);
  y("validateList", w);
  const L = s([]);
  y("saveList", L);
  const A = s("50%");
  y("size", A);
  const f = [{ name: I(() => v(() => import("./payment/index.vue.js"), ["static/js/index-6a916eca.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-8b59bada.js", "static/js/data-e72242cc.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-dfff0f60.js", "static/js/subcontract-payment-attribute-37f9bab7.js", "static/js/second-table-5ad870a2.js", "static/js/useTableTotal-3d22365a.js", "static/css/second-table-039652a6.css", "static/js/payment-info-65f2fda0.js", "static/js/data-33e35578.js", "static/css/index-24616f2f.css"])), api: X }, { name: I(() => v(() => import("./settlement/index.vue.js"), ["static/js/index-c6bfeb8c.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-b0db1056.js", "static/js/data-e72242cc.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-dfff0f60.js", "static/js/second-table-30388573.js", "static/js/useTableTotal-3d22365a.js", "static/js/contract-info-e39ed619.js", "static/css/index-7b730cac.css"])), api: Y }, { name: I(() => v(() => import("./pre-settlement/index.vue.js"), ["static/js/index-ab408542.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-bb6de9f0.js", "static/js/data-e72242cc.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-dfff0f60.js", "static/js/second-table-1ddae3e9.js", "static/js/useTableTotal-3d22365a.js", "static/js/contract-info-741cf360.js", "static/css/index-54f386d1.css"])), api: ee }], D = h(() => f[i.value].name), E = O(), x = () => {
    try {
      _.value = true, Promise.all(L.value.map((e) => e())).then(() => {
        Z(async () => {
          var t, m;
          const e = $.cloneDeep(p.value.formData);
          if (((t = e.attachmentId) == null ? void 0 : t.length) > 0 && (e.attachmentId = e.attachmentId.map((n) => n.id)), ((m = e.attachmentIds) == null ? void 0 : m.length) > 0 && (e.attachmentIds = e.attachmentIds.map((n) => n.id)), e.tableList) e.supplierPayment.length > 0 && e.supplierPayment.splice(0), e.tableList.forEach((o) => {
            e.supplierPayment.push({ moneyAmount: o.moneyAmount, supplierPaymentId: o.supplierPaymentId });
          }), e.tableList.some((o) => R(o.moneyAmount)) ? c("error", "本次付款不能为空") : (await f[i.value].api(e), c("success", "操作成功"), r.value = false, await E.dispatch("approval_list/fetchApprovalNum"));
          else if (e.settlementAmount) {
            if (Number(e.settlementAmount) === 0) return c("error", "预结算额不能为0");
            await f[i.value].api(e), c("success", "操作成功"), r.value = false, await E.dispatch("approval_list/fetchApprovalNum");
          }
        });
      }).catch((e) => {
        console.log("校验失败" + e);
      });
    } catch (e) {
      console.log("发起审批失败;" + e);
    } finally {
      _.value = false;
    }
  }, P = s([]);
  (async () => {
    try {
      P.value = await te();
    } catch (e) {
      console.log("获取项目失败", e);
    }
  })();
  const b = T;
  F(() => {
    b("component-mounted", true);
  });
  const j = h(() => {
    var e, t;
    return !((t = (e = p == null ? void 0 : p.value) == null ? void 0 : e.formData) != null && t.supplierId);
  });
  function z() {
    b("closed");
  }
  return k({ visible: r }), (e, t) => {
    const m = q, n = J, o = K, C = Q, N = W;
    return g(), U("div", ae, [l(N, { modelValue: r.value, "onUpdate:modelValue": t[2] || (t[2] = (d) => r.value = d), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, size: A.value, "destroy-on-close": "", onClosed: z }, { header: a(() => [l(S, { "type-one": false, "header-title": "付款与结算" }, { subTitle: a(() => [j.value ? (g(), V(m, { key: 0, size: "default", type: "danger" }, { default: a(() => t[3] || (t[3] = [u("请先选择项目、分包商!")])), _: 1, __: [3] })) : G("", true)]), _: 1 }), l(n, { loading: _.value, size: "default", type: "success", onClick: x }, { default: a(() => t[4] || (t[4] = [u("发起审批")])), _: 1, __: [4] }, 8, ["loading"]), l(n, { size: "default", onClick: t[0] || (t[0] = (d) => r.value = false) }, { default: a(() => t[5] || (t[5] = [u("关闭")])), _: 1, __: [5] })]), default: a(() => [H("div", oe, [l(C, { modelValue: i.value, "onUpdate:modelValue": t[1] || (t[1] = (d) => i.value = d), size: "default", "text-color": "#409EFF" }, { default: a(() => [l(o, { value: 0 }, { default: a(() => t[6] || (t[6] = [u("付款申请")])), _: 1, __: [6] }), l(o, { value: 1 }, { default: a(() => t[7] || (t[7] = [u("结算申请")])), _: 1, __: [7] }), l(o, { value: 2 }, { default: a(() => t[8] || (t[8] = [u("预结算申请")])), _: 1, __: [8] })]), _: 1 }, 8, ["modelValue"])]), (g(), V(M(D.value), { key: i.value, ref_key: "currentComponentRef", ref: p, limit: 1, projectList: P.value, class: "animate__animated animate__fadeIn" }, null, 8, ["projectList"]))]), _: 1 }, 8, ["modelValue", "size"])]);
  };
} }, me = B(se, [["__scopeId", "data-v-24ce0dab"]]);
export {
  me as default
};
