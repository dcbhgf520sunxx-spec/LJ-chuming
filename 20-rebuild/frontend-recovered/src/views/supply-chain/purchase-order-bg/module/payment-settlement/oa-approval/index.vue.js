import {requireOaRequestId} from '../../../../../../runtime/settlement-result.js';
import { u as E, x as R, p as B, j0 as b, e2 as y, G as hasPermission, vf as bgPermissions, uT as checkOaPermission } from "../../../../../../shared/runtime.js";
import { p as J, a as L, b as U, c as z } from "../../../../../../modules/index-70e7196a.js";
import { inject as F } from "vue";
import { ref as l } from "vue";
import { computed as H } from "vue";
import { provide as K } from "vue";
import { useStore as Q } from "vuex";
import { resolveComponent as T } from "vue";
import { openBlock as O } from "vue";
import { createBlock as P } from "vue";
import { withCtx as g } from "vue";
import { createVNode as Z } from "vue";
import { createTextVNode as G } from "vue";
import { resolveDynamicComponent as W } from "vue";
import { unref as w } from "vue";
import { isRef as X } from "vue";
import { defineAsyncComponent as A } from "vue";
import Y from "lodash";
const te = { __name: "index", props: { projectManagerOptions: { type: Array }, visible: { type: Boolean }, radioType: { type: [String, Number] }, crud: { type: Object } }, emits: ["update:visible", "submitted"], setup(q, { emit: I }) {
  const i = q, D = I, { dataId: u } = F("common"), { visible: p, handleClose: c } = E({ emit: D, props: i, field: "visible", showHook: j }), s = l(false), _ = l(), h = l();
  function N(a) {
    console.log(a), h.value = a;
  }
  function j() {
    _.value = Math.random();
    if (String(lastLedgerId.value) !== String(u.value)) o.value = undefined;
    lastLedgerId.value = u.value;
  }
  const C = { 0: A(() => b(() => import("./contract-payment.vue.js"), ["static/js/contract-payment-c8302d7e.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-70e7196a.js", "static/js/UploadList-ad01af55.js", "static/css/UploadList-d7d36eff.css", "static/css/contract-payment-45986b41.css"])), 1: A(() => b(() => import("./settle/index.vue.js"), ["static/js/index-b3307313.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/js/index-70e7196a.js"])) }, S = H(() => C[i.radioType]), { crud: m } = R({ title: "OA审批" }), d = l();
  K("settleSubmitType", d);
  const f = Q(), o = l(), lastLedgerId = l();
  async function V(a) {
    return requireOaRequestId(await J({ ...a, oaSupplierPaymentDTO: h.value.oaSupplierPaymentDTO }));
  }
  async function k(a) { return requireOaRequestId(await L(a)); }
  async function x(a) { return requireOaRequestId(await U(a)); }
  const M = async () => {
    if (s.value) return;
    try {
      if (!hasPermission(bgPermissions.pay_application)) throw new Error("没有当前申请操作权限");
      if (!await m.ref.form.validate()) return;
      const e = Y.cloneDeep(m.form), attachmentField = i.radioType === 0 ? "xgfj" : "htfj", attachments = e[attachmentField];
      Object.keys(e).forEach(key => e[key] = m.form[key] + "");
      e.sqrq = B(e.sqrq, "{y}-{m}-{d}");
      if (attachments?.length) e[attachmentField] = attachments.map(file => ({ fileName: file.name, filePath: file.relativePath }));
      else delete e[attachmentField];
      let requestName, submit, businessType;
      if (i.radioType === 0) {
        requestName = "材料合同款项支付审批流程（初鸣）"; submit = V; businessType = 2;
      } else if (d.value === 1) {
        requestName = "外委加工合同审批/结算流程（初鸣）"; submit = x; businessType = 3;
      } else if (d.value === 2) {
        requestName = "材料合同结算资料盖章申请流程（初鸣）"; submit = k; businessType = 3;
      } else throw new Error("结算审批预览尚未加载完成");
      s.value = true;
      if (!o.value) {
        if (await checkOaPermission({ requestName, sqr: f.getters.user.oaUserId }) !== "响应成功") throw new Error("OA审批权限校验未通过");
        o.value = await submit(e);
      }
      // Retain an actual OA id on a local-link failure so retry never creates a duplicate flow.
      const linked = await z({ businessType, modeOperation: 2, id: u.value, requestName, requestId: String(o.value), applicationId: f.getters.user.id, applicationTime: Date.now() });
      if (linked !== "响应成功") throw new Error("OA已创建，审批关联未成功，请重试关联");
      y("success", "审批已提交");
      D("submitted", { ledgerId: u.value, requestId: o.value });
      c();
      try { await i.crud.toQuery(); } catch { y("warning", "审批已提交，列表刷新失败，请刷新页面"); }
    } catch (error) {
      y("error", o.value ? "OA已创建，审批关联未完成，请重试关联：" + (error.message || "关联失败") : (error.message || "审批未提交，请重试"));
    } finally { s.value = false; }
  };
  return (a, e) => {
    const r = T("common-button"), n = T("common-dialog");
    return O(), P(n, { modelValue: w(p), "onUpdate:modelValue": e[0] || (e[0] = (t) => X(p) ? p.value = t : null), "before-close": w(c), closeOnClickModal: false, closeOnPressEscape: false, title: "OA审批", top: "1vh", width: "900px" }, { titleRight: g(() => [Z(r, { loading: s.value, size: "mini", type: "primary", onClick: M }, { default: g(() => e[1] || (e[1] = [G("提交")])), _: 1, __: [1] }, 8, ["loading"])]), default: g(() => [(O(), P(W(S.value), { key: _.value, onPurchaseInfo: N }, null, 32))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  te as default
};
