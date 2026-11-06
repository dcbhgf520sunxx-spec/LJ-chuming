import {requireDraftLedgerId, requireBooleanOperation, settlementDraftFingerprint} from '../../../../../runtime/settlement-result.js';
import { _ as F, kc as M, dp as q, e2 as O, j0 as V, G as hasPermission, vf as bgPermissions } from "../../../../../shared/runtime.js";
import { ref as a } from "vue";
import { provide as x } from "vue";
import { computed as _ } from "vue";
import { watch as G } from "vue";
import { useStore as H } from "vuex";
import { onMounted as K } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as J } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { createSlots as Q } from "vue";
import { createTextVNode as d } from "vue";
import { createElementVNode as W } from "vue";
import { createBlock as A } from "vue";
import { resolveDynamicComponent as X } from "vue";
import { unref as Y } from "vue";
import { defineAsyncComponent as T } from "vue";
import { nextTick as Z } from "vue";
import { ElTag as h } from "element-plus";
import { ElButton as ee } from "element-plus";
import { ElRadio as ae } from "element-plus";
import { ElRadioGroup as te } from "element-plus";
import { ElDrawer as oe } from "element-plus";
import { p as se, e as ne } from "../../../../../modules/payment-settlement-e8e799d8.js";
import le from "./oa-approval/index.vue.js";
import "../../../../../modules/index-70e7196a.js";
const re = { class: "drawer-container" }, ie = { class: "radio-container" }, de = { __name: "payment-settlement", emits: ["component-mounted", "close"], setup(ue, { expose: D, emit: S }) {
  const o = a(0), r = a(false), i = a(null), u = a("60%"), v = a([]);
  x("saveList", v), x("common", { orderId: a(void 0), projectId: a(void 0), settleForm: a(void 0), contractSignBodyId: a(void 0), contractSignBodyName: a(void 0), dataId: _(() => w.value) });
  const y = [{ name: T(() => V(() => import("./payment/index.vue.js"), ["static/js/index-d8f17b8c.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-47bcd1ac.js", "static/js/data-499610b6.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/payment-settlement-e8e799d8.js", "static/js/hook-75706e02.js", "static/css/header-4fc5c3ec.css", "static/js/second-table-37ff377c.js", "static/js/grant-managment-2c540b60.js", "static/js/upload-file-download-812f558c.js", "static/css/second-table-c789a38f.css", "static/css/el-upload-3a61110e.css", "static/css/el-progress-d6a46dc4.css", "static/css/index-657aefac.css"])), api: se }, { name: T(() => V(() => import("./settlement/index.vue.js"), ["static/js/index-a46f3a73.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-81eccbf7.js", "static/js/data-499610b6.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/payment-settlement-e8e799d8.js", "static/js/hook-75706e02.js", "static/js/second-table-5860afcf.js", "static/js/useTableTotal-3d22365a.js", "static/js/contract-info-fb93baa9.js", "static/css/index-b4fe6353.css"])), api: ne }], z = _(() => y[o.value].name);
  G(() => o.value, (t) => {
    t === 0 ? u.value = "60%" : t === 1 && (u.value = "50%");
  });
  const g = H();
  const w = a(), m = a(false), p = a(false), draftOrderId = a(), draftPayload = a(), C = async () => {
    if (p.value) return;
    try {
      if (!hasPermission(bgPermissions.pay_application)) throw new Error("没有当前申请操作权限");
      p.value = true, await Promise.all(v.value.map((c) => c()));
      const t = i.value.formData;
      if (o.value === 1 && w.value && draftPayload.value === settlementDraftFingerprint(t)) {
        r.value = false;
        await Z(() => m.value = true);
        return;
      }
      const e = await y[o.value].api(t);
      if (o.value === 0) {
        requireBooleanOperation(e);
        O("success", "付款申请已提交");
        r.value = false;
        await g.dispatch("approval_list/fetchApprovalNum");
      } else {
        w.value = requireDraftLedgerId(e);
        draftOrderId.value = t.orderId;
        draftPayload.value = settlementDraftFingerprint(t);
        O("info", "结算草稿已生成，请核对并提交审批");
        r.value = false;
        await j();
        await Z(() => m.value = true);
      }
    } catch (t) {
      O("error", t.message || "申请未成功，请重试");
    } finally {
      p.value = false;
    }
  }, E = S;
  K(() => {
    E("component-mounted", true);
  });
  const N = () => {
    E("close");
  }, P = _(() => {
    var t, e;
    return !((e = (t = i == null ? void 0 : i.value) == null ? void 0 : t.formData) != null && e.projectManagerId);
  }), I = a();
  function j() {
    I.value = Math.random();
  }
  const { crud: L } = M();
  function onOaSubmitted() { w.value = undefined; draftOrderId.value = undefined; draftPayload.value = undefined; }
  return D({ visible: r }), (t, e) => {
    const c = h, b = ee, k = ae, R = te, U = oe;
    return f(), J("div", re, [n(U, { modelValue: r.value, "onUpdate:modelValue": e[2] || (e[2] = (l) => r.value = l), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, size: u.value, "destroy-on-close": "", onClosed: N }, { header: s(() => [n(q, { "type-one": false, "header-title": "付款与结算 -【 内包&合营 】" }, Q({ _: 2 }, [P.value ? { name: "subTitle", fn: s(() => [n(c, { size: "default", type: "danger" }, { default: s(() => e[4] || (e[4] = [d(" 请先选择项目经理!")])), _: 1, __: [4] })]), key: "0" } : void 0]), 1024), n(b, { size: "default", type: "primary", onClick: C, loading: p.value }, { default: s(() => e[5] || (e[5] = [d("预览")])), _: 1, __: [5] }, 8, ["loading"]), n(b, { size: "default", onClick: e[0] || (e[0] = (l) => r.value = false) }, { default: s(() => e[6] || (e[6] = [d("关闭")])), _: 1, __: [6] })]), default: s(() => [W("div", ie, [n(R, { modelValue: o.value, "onUpdate:modelValue": e[1] || (e[1] = (l) => o.value = l), size: "default", "text-color": "#409EFF" }, { default: s(() => [n(k, { value: 0 }, { default: s(() => e[7] || (e[7] = [d("付款申请")])), _: 1, __: [7] }), n(k, { value: 1 }, { default: s(() => e[8] || (e[8] = [d("结算申请")])), _: 1, __: [8] })]), _: 1 }, 8, ["modelValue"])]), (f(), A(X(z.value), { ref_key: "currentComponentRef", ref: i, class: "animate__animated animate__fadeIn animate__fast" }, null, 512))]), _: 1 }, 8, ["modelValue", "size"]), (f(), A(le, { key: I.value, visible: m.value, "onUpdate:visible": e[3] || (e[3] = (l) => m.value = l), "radio-type": o.value, crud: Y(L), onSubmitted: onOaSubmitted }, null, 8, ["visible", "radio-type", "crud"]))]);
  };
} }, ye = F(de, [["__scopeId", "data-v-63dfc625"]]);
export {
  ye as default
};
