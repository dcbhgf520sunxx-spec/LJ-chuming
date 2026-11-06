import { useStore as E } from "vuex";
import { ref as c } from "vue";
import { watch as S } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as T } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as u } from "vue";
import { createVNode as s } from "vue";
import { unref as _ } from "vue";
import { createTextVNode as F } from "vue";
import { isRef as H } from "vue";
import { ElNotification as O } from "element-plus";
import { ElInput as z } from "element-plus";
import { ElForm as q } from "element-plus";
import { r as G } from "../../../../../../modules/application-f2aa112e.js";
import { jX as K, u as P, o as D, a$ as L, V as g, cS as I, bs as N, b as X, jG as J, k5 as Q, jH as W, k6 as Y, yB as Z, i as ee, jl as ae } from "../../../../../../shared/runtime.js";
import te from "./preview-confirm.vue.js";
const ne = { __name: "preview", props: { visible: { type: Boolean, default: false }, basicClass: { type: Number }, inboundId: { type: Number, required: false }, rejectInfo: { type: Object, default: () => ({}) }, detailInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:visible"], setup(n, { emit: h }) {
  const k = E(), j = h, r = n, B = c([...K, ["realTime", "parse-time"]]), i = c(false), d = c([]), m = c(false), f = c({ remark: void 0 }), { visible: p, handleClose: V } = P({ emit: j, props: r, field: "visible" }), { maxHeight: U } = D({ mainBox: ".reject-application-preview", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, p);
  S([() => r.visible, () => r.rejectInfo], ([t, e]) => {
    t && A(e);
  }, { immediate: true, deep: true });
  function A(t) {
    const e = [];
    for (const b in t) {
      const l = t[b];
      if (l && l.KV && l.material) {
        const o = l.material, w = L(l.KV).map((a) => {
          const v = g(a);
          return v.inboundMaterialId = b, o.measureUnit && (v.quantity = o.rejectUnitType === I.MEASURE.V ? a.rejectNumber : N(a.rejectNumber * o.accountingUnitNet, o.measurePrecision)), v.mete = o.rejectUnitType === I.ACCOUNTING.V ? a.rejectNumber : N(a.rejectNumber * o.unitNet, o.accountingPrecision), v;
        });
        e.push.apply(e, w);
      }
    }
    d.value = e;
  }
  function M() {
    var t;
    ee((t = r.detailInfo) == null ? void 0 : t.logisticsOrder) ? (m.value = true, i.value = true) : x({});
  }
  async function x(t) {
    try {
      i.value = true;
      const e = { remark: f.value.remark, inboundId: r.inboundId, list: g(d.value), ...t };
      e.list = await ae(e.list, { toSmallest: true, toNum: true }), await G(e), await k.dispatch("approval_list/fetchApprovalNum"), m.value = false, V(), j("success"), O({ title: "提交成功", type: "success" });
    } catch (e) {
      console.log("退货", e);
    } finally {
      i.value = false;
    }
  }
  function R() {
    m.value = false, i.value = false;
  }
  return (t, e) => {
    const b = y("common-button"), l = y("common-table"), o = z, C = q, w = y("common-drawer");
    return T(), $(w, { ref: "drawerRef", modelValue: _(p), "onUpdate:modelValue": e[2] || (e[2] = (a) => H(p) ? p.value = a : null), "before-close": _(V), "close-on-click-modal": false, "custom-class": "reject-application-preview", direction: "rtl", size: "90%", title: "退货预览" }, { titleRight: u(() => [s(b, { loading: i.value, disabled: _(X)(d.value), type: "primary", size: "default", onClick: M }, { default: u(() => e[3] || (e[3] = [F("提 交")])), _: 1, __: [3] }, 8, ["loading", "disabled"])]), content: u(() => [s(C, { disabled: i.value, model: f.value }, { default: u(() => [s(l, { data: d.value, "data-format": B.value, "max-height": _(U), "empty-text": "未做改动", "row-key": "id" }, { default: u(() => [s(J, { "basic-class": n.basicClass }, null, 8, ["basic-class"]), s(Q, { "basic-class": n.basicClass }, null, 8, ["basic-class"]), s(W, { "basic-class": n.basicClass, "reject-type-mode": "" }, null, 8, ["basic-class"]), s(Y, { "show-project": "", "show-monomer": false, "show-area": false }), s(Z, { label: "实际退货时间" })]), _: 1 }, 8, ["data", "data-format", "max-height"]), s(o, { modelValue: f.value.remark, "onUpdate:modelValue": e[0] || (e[0] = (a) => f.value.remark = a), autosize: { minRows: 2, maxRows: 2 }, rows: 2, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { "margin-top": "10px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }, 8, ["disabled", "model"]), s(te, { modelValue: m.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => m.value = a), detailInfo: n.detailInfo, onConfirmClose: R, onConfirmSubmit: x }, null, 8, ["modelValue", "detailInfo"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ne as default
};
