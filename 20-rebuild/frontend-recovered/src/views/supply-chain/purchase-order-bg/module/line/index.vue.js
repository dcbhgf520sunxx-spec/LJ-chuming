import {Fragment as PreviewFragment, nextTick} from 'vue';
import OaPreview from '../payment-settlement/oa-approval/index.vue.js';
import {requireDraftLedgerId, requireBooleanOperation, settlementDraftFingerprint} from '../../../../../runtime/settlement-result.js';
import { u as S, j0 as i, e2 as z, kc as useCrud, G as hasPermission, vf as bgPermissions } from "../../../../../shared/runtime.js";
import { ref as a } from "vue";
import { computed as f } from "vue";
import { provide as d } from "vue";
import { useStore as B } from "vuex";
import { resolveComponent as O } from "vue";
import { openBlock as v } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { createVNode as T } from "vue";
import { createTextVNode as j } from "vue";
import { resolveDynamicComponent as N } from "vue";
import { unref as w } from "vue";
import { isRef as U } from "vue";
import { defineAsyncComponent as c } from "vue";
import { ElButton as q } from "element-plus";
import { p as F, e as G } from "../../../../../modules/payment-settlement-e8e799d8.js";
import { p as H } from "../../../../../modules/invoice-entry-97d1bf05.js";
const W = { __name: "index", props: { visible: { type: Boolean, default: false }, item_data: { type: Object, default: () => {
} }, current_key: { type: String }, title: { type: String } }, emits: ["update:visible"], setup(b, { emit: g }) {
  const o = b, u = g, { visible: s, handleClose: h } = S({ emit: u, props: o, field: "visible" }), A = a(false), p = a("50%"), V = { payment: c(() => i(() => import("./payment/index.vue.js"), ["static/js/index-e9d288cb.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-acd158ff.js", "static/js/data-5413af16.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/payment-settlement-e8e799d8.js", "static/js/info-429dcef2.js", "static/css/header-bba2b049.css", "static/js/second-table-954eff8e.js", "static/js/data-499610b6.js", "static/js/grant-managment-2c540b60.js", "static/js/upload-file-download-812f558c.js", "static/css/second-table-b919b85e.css", "static/css/el-upload-3a61110e.css", "static/css/el-progress-d6a46dc4.css", "static/css/index-57d10799.css"])), settle: c(() => i(() => import("./settle/index.vue.js"), ["static/js/index-3b88a885.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-eb7fee0f.js", "static/js/data-5413af16.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/payment-settlement-e8e799d8.js", "static/js/info-429dcef2.js", "static/js/second-table-fdc0157e.js", "static/js/useTableTotal-3d22365a.js", "static/js/contract-info-783aece8.js", "static/css/index-d3a03ef1.css"])), invoice: c(() => i(() => import("./invoice/index.vue.js"), ["static/js/index-36d7ed93.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-2f4d307a.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/invoice-entry-494c5781.js", "static/js/invoice-entry-97d1bf05.js", "static/js/info-429dcef2.js", "static/js/payment-settlement-e8e799d8.js", "static/js/second-table-e8502489.js", "static/js/useTableTotal-3d22365a.js", "static/css/second-table-7f008bfa.css", "static/js/invoice-info-e2d87b6a.js", "static/css/index-a2eec35e.css"])) }, k = f(() => V[o.current_key]), m = a(), _ = a([]);
  d("saveList", _);
  const r = a(false), E = B(), draftLedgerId = a(), draftOrderId = a(), draftPayload = a(), previewVisible = a(false), { crud: previewCrud } = useCrud();
  async function openSettlementPreview() {
    u("update:visible", false);
    await nextTick();
    previewVisible.value = true;
  }
  async function n(message) {
    z("success", message), u("update:visible", false), await E.dispatch("approval_list/fetchApprovalNum");
  }
  async function I(e) {
    try {
      requireBooleanOperation(await F(e));
      await n("付款申请已提交");
    } catch (t) {
      z("error", t.message || "申请未成功，请重试");
    }
  }
  async function P(e) {
    try {
      draftLedgerId.value = requireDraftLedgerId(await G(e));
      draftOrderId.value = e.orderId;
      draftPayload.value = settlementDraftFingerprint(e);
      z("info", "结算草稿已生成，请核对并提交审批");
      await openSettlementPreview();
    } catch (t) {
      z("error", t.message || "申请未成功，请重试");
    }
  }
  async function D(e) {
    try {
      requireBooleanOperation(await H(e));
      await n("发票登记已提交");
    } catch (t) {
      z("error", t.message || "申请未成功，请重试");
    }
  }
  const C = async () => {
    if (r.value) return;
    try {
      const permission = o.current_key === "invoice" ? bgPermissions.invoice_entry : bgPermissions.pay_application;
      if (!hasPermission(permission)) throw new Error("没有当前申请操作权限");
      r.value = true, await Promise.all(_.value.map((t) => t()));
      const e = m.value.formData;
      if (o.current_key === "settle" && draftLedgerId.value && draftPayload.value === settlementDraftFingerprint(e)) {
        z("info", "已有待确认结算草稿，请核对并提交审批");
        await openSettlementPreview();
        return;
      }
      switch (o.current_key) {
        case "payment":
          return await I(e);
        case "settle":
          return await P(e);
        case "invoice":
          return await D(e);
      }
    } catch (e) {
      z("error", e.message || "申请未成功，请重试");
    } finally {
      r.value = false;
    }
  };
  return d("common", { size: p, item_data: f(() => o.item_data), dataId: draftLedgerId }), (e, t) => {
    const x = q, L = O("common-drawer");
    return v(), T(PreviewFragment, null, [y(L, { ref_key: "drawer_ref", ref: A, modelValue: w(s), "onUpdate:modelValue": t[0] || (t[0] = (R) => U(s) ? s.value = R : null), "append-to-body": true, "before-close": w(h), "destroy-on-close": true, size: p.value, title: o.title }, { titleRight: l(() => [T(x, { loading: r.value, size: "default", type: "success", onClick: C }, { default: l(() => t[1] || (t[1] = [j("发起审批")])), _: 1, __: [1] }, 8, ["loading"])]), content: l(() => [(v(), y(N(k.value), { ref_key: "current_com_ref", ref: m }, null, 512))]), _: 1 }, 8, ["modelValue", "before-close", "size", "title"]), T(OaPreview, { visible: previewVisible.value, "onUpdate:visible": value => previewVisible.value = value, radioType: 1, crud: previewCrud, onSubmitted: () => { draftLedgerId.value = undefined; draftOrderId.value = undefined; draftPayload.value = undefined; E.dispatch("approval_list/fetchApprovalNum"); } }, null, 8, ["visible", "crud"])]);
  };
} };
export {
  W as default
};
