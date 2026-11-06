import { ref as _ } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as T } from "vue";
import { createBlock as F } from "vue";
import { withCtx as e } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as O } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as f } from "vue";
import { unref as n } from "vue";
import { createCommentVNode as S } from "vue";
import { isRef as Y } from "vue";
import { ElDivider as z } from "element-plus";
import { ElFormItem as P } from "element-plus";
import { ElCol as q } from "element-plus";
import { ElRow as K } from "element-plus";
import { ElForm as M } from "element-plus";
import { AK as b, u as G, bV as I, D as g, p as H } from "../../../../../../shared/runtime.js";
const W = { __name: "preview-confirm", props: { visible: { type: Boolean, default: false }, detailInfo: { type: Object, default: () => ({}) } }, emits: ["confirmSubmit", "update:visible", "confirmClose"], setup(N, { emit: j }) {
  const p = j, s = N, C = _(false), v = _(), i = _({ rejectFreightType: b.RETAIN.V, freight: void 0 }), { visible: c, handleClose: J } = G({ emit: p, props: s, field: "visible" }), E = { freight: [{ required: true, message: "请输入退运费金额", trigger: "change" }] };
  async function R() {
    await v.value.validate() && p("confirmSubmit", i.value);
  }
  function U() {
    p("confirmClose");
  }
  return (w, o) => {
    const x = d("common-button"), y = z, m = P, u = q, V = K, A = d("common-radio"), k = d("common-input-number"), B = M, D = d("common-dialog");
    return T(), F(D, { "custom-class": "reject-application-freight", title: "运费确认", "append-to-body": "", modelValue: n(c), "onUpdate:modelValue": o[2] || (o[2] = (t) => Y(c) ? c.value = t : null), width: "880px", "before-close": U, top: "12vh" }, { titleRight: e(() => [l(x, { type: "primary", size: "default", onClick: R }, { default: e(() => o[3] || (o[3] = [O("提 交")])), _: 1, __: [3] })]), default: e(() => [l(B, { ref_key: "formRef", ref: v, model: i.value, rules: E, disabled: C.value }, { default: e(() => [l(y, null, { default: e(() => o[4] || (o[4] = [r("span", { class: "title" }, "运费信息", -1)])), _: 1, __: [4] }), l(V, null, { default: e(() => [l(u, { span: 12 }, { default: e(() => [l(m, { class: "el-form-item-2", label: "本入库单运费" }, { default: e(() => {
      var t, a, h;
      return [r("span", null, f(n(I)((a = (t = s.detailInfo) == null ? void 0 : t.logisticsOrder) == null ? void 0 : a.freight, n(g).YUAN)) + "元", 1), r("div", null, " 【可操作运费：" + f(n(I)((h = s.detailInfo) == null ? void 0 : h.surplusFreight, n(g).YUAN)) + "元】 ", 1)];
    }), _: 1 })]), _: 1 }), l(u, { span: 6 }, { default: e(() => [l(m, { class: "el-form-item-2", label: "车牌/船牌" }, { default: e(() => {
      var t, a;
      return [r("span", null, f((a = (t = s.detailInfo) == null ? void 0 : t.logisticsOrder) == null ? void 0 : a.licensePlate), 1)];
    }), _: 1 })]), _: 1 }), l(u, { span: 6 }, { default: e(() => [l(m, { class: "el-form-item-2", label: "入库日期" }, { default: e(() => {
      var t, a;
      return [r("span", null, f((t = s.detailInfo) != null && t.createTime ? n(H)((a = s.detailInfo) == null ? void 0 : a.createTime, "{y}-{m}-{d}") : "-"), 1)];
    }), _: 1 })]), _: 1 })]), _: 1 }), l(y, null, { default: e(() => o[5] || (o[5] = [r("span", { class: "title" }, "运费变更", -1)])), _: 1, __: [5] }), l(V, null, { default: e(() => [l(u, { span: 8 }, { default: e(() => [l(m, { class: "el-form-item-2", label: "运费变更", prop: "rejectFreightType" }, { default: e(() => [l(A, { modelValue: i.value.rejectFreightType, "onUpdate:modelValue": o[0] || (o[0] = (t) => i.value.rejectFreightType = t), options: n(b).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), l(u, { span: 8 }, { default: e(() => [i.value.rejectFreightType === n(b).RETURN.V ? (T(), F(m, { key: 0, class: "el-form-item-2", label: "", prop: "freight" }, { default: e(() => {
      var t;
      return [l(k, { modelValue: i.value.freight, "onUpdate:modelValue": o[1] || (o[1] = (a) => i.value.freight = a), controls: false, min: 0, max: ((t = s.detailInfo) == null ? void 0 : t.surplusFreight) || 999999999999, step: 1, precision: n(g).YUAN, class: "input-underline", autocomplete: "off", placeholder: "退运费金额", style: { width: "100%" } }, null, 8, ["modelValue", "max", "precision"])];
    }), _: 1 })) : S("", true)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])]), _: 1 }, 8, ["modelValue"]);
  };
} };
export {
  W as default
};
