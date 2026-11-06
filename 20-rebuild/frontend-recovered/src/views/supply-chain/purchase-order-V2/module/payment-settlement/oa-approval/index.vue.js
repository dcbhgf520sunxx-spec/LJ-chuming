import { u as x, x as M, p as R, e2 as y, j0 as _ } from "../../../../../../shared/runtime.js";
import { p as k, a as B, b as J, c as L } from "../../../../../../modules/index-70e7196a.js";
import { inject as U } from "vue";
import { ref as c } from "vue";
import { computed as z } from "vue";
import { provide as F } from "vue";
import { useStore as K } from "vuex";
import { resolveComponent as T } from "vue";
import { openBlock as O } from "vue";
import { createBlock as P } from "vue";
import { withCtx as g } from "vue";
import { createVNode as Q } from "vue";
import { createTextVNode as Z } from "vue";
import { resolveDynamicComponent as G } from "vue";
import { unref as A } from "vue";
import { isRef as H } from "vue";
import { defineAsyncComponent as b } from "vue";
import W from "lodash";
const ee = { __name: "index", props: { projectManagerOptions: { type: Array }, visible: { type: Boolean }, radioType: { type: [String, Number] }, crud: { type: Object } }, emits: ["update:visible"], setup(w, { emit: I }) {
  const n = w, q = I, { dataId: l } = U("common"), { visible: p, handleClose: u } = x({ emit: q, props: n, field: "visible" }), s = c(false), h = c(), D = { 0: b(() => _(() => import("./contract-payment.vue.js"), ["static/js/contract-payment-1e712819.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-70e7196a.js", "static/js/UploadList-ad01af55.js", "static/css/UploadList-d7d36eff.css", "static/css/contract-payment-4e590a72.css"])), 1: b(() => _(() => import("./settle/index.vue.js"), ["static/js/index-f2450724.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/js/index-70e7196a.js"])), 2: b(() => _(() => import("./settle/index.vue.js"), ["static/js/index-f2450724.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/js/index-70e7196a.js"])) }, N = z(() => D[n.radioType]), { crud: m } = M({ title: "OA审批" }), d = c();
  F("settleSubmitType", d);
  const f = K(), V = async () => {
    m.ref.form.validate(async (a) => {
      if (a) {
        const e = W.cloneDeep(m.form), r = n.radioType === 0 ? "xgfj" : "htfj", i = e[r];
        Object.keys(e).forEach((o) => {
          e[o] = m.form[o] + "";
        }), i != null && i.length ? e[r] = i.map((o) => ({ fileName: o.name, filePath: o.relativePath })) : delete e[r], e.sqrq = R(e.sqrq, "{y}-{m}-{d}"), n.radioType === 0 ? (s.value = true, await j(e), await v({ businessType: 2, modeOperation: 1, id: l.value, requestName: "材料合同款项支付审批流程（初鸣）", requestId: t.value + "", applicationId: f.getters.user.id, applicationTime: (/* @__PURE__ */ new Date()).getTime() })) : (s.value = true, d.value === 1 ? (await E(e), await v({ businessType: 3, modeOperation: 1, id: l.value, requestName: "外委加工合同审批/结算流程（初鸣）", requestId: t.value, applicationId: f.getters.user.id, applicationTime: (/* @__PURE__ */ new Date()).getTime() })) : d.value === 2 && (await C(e), await v({ businessType: 3, id: l.value, requestName: "材料合同结算资料盖章申请流程（初鸣）", modeOperation: 1, requestId: t.value, applicationId: f.getters.user.id, applicationTime: (/* @__PURE__ */ new Date()).getTime() })));
      }
    });
  }, t = c();
  async function j(a) {
    try {
      const e = await k({ ...a, oaSupplierPaymentDTO: h.value.oaSupplierPaymentDTO });
      t.value = JSON.parse(e).requestid, y("success", "审批发起成功"), u();
    } catch (e) {
      console.log("原材料审批报错:fetchMaterialsPostApproval", e);
    } finally {
      s.value = false;
    }
  }
  async function C(a) {
    try {
      const e = await B(a);
      t.value = JSON.parse(e).requestid, y("success", "审批发起成功"), u();
    } catch (e) {
      console.log("制成品审批报错:fetchFinishedPostApproval", e);
    } finally {
      s.value = false;
    }
  }
  async function E(a) {
    try {
      const e = await J(a);
      t.value = JSON.parse(e).requestid, y("success", "审批发起成功"), u();
    } catch (e) {
      console.log("原材料审批失败", e);
    } finally {
      s.value = false;
    }
  }
  async function v(a) {
    try {
      if (!(t.value && l.value)) return;
      await L(a), l.value = null, t.value = null, await n.crud.toQuery();
    } catch (e) {
      console.log("关联失败", e);
    }
  }
  function S(a) {
    h.value = a;
  }
  return (a, e) => {
    const r = T("common-button"), i = T("common-dialog");
    return O(), P(i, { modelValue: A(p), "onUpdate:modelValue": e[0] || (e[0] = (o) => H(p) ? p.value = o : null), "before-close": A(u), closeOnClickModal: false, closeOnPressEscape: false, title: "OA审批", top: "1vh", width: "900px" }, { titleRight: g(() => [Q(r, { loading: s.value, size: "mini", type: "primary", onClick: V }, { default: g(() => e[1] || (e[1] = [Z("提交")])), _: 1, __: [1] }, 8, ["loading"])]), default: g(() => [(O(), P(G(N.value), { onPurchaseInfo: S }, null, 32))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ee as default
};
