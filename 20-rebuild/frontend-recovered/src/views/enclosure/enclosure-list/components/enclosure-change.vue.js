import { ref as p } from "vue";
import { watch as U } from "vue";
import { nextTick as W } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as z } from "vue";
import { createVNode as l } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as v } from "vue";
import { unref as b } from "vue";
import { createBlock as D } from "vue";
import { createElementVNode as O } from "vue";
import { createCommentVNode as j } from "vue";
import { isRef as J } from "vue";
import { Fragment as M } from "vue";
import { ElCheckbox as T } from "element-plus";
import { ElFormItem as L } from "element-plus";
import { ElInputNumber as $ } from "element-plus";
import { ElInput as A } from "element-plus";
import { ElForm as G } from "element-plus";
import { ElNotification as H } from "element-plus";
import { l as K, _ as P, u as Q, bC as X } from "../../../../shared/runtime.js";
import { _ as Y } from "../../../../modules/change-reason-select-73e53277.js";
function Z(s) {
  return K({ url: "/api/enclosure/change", method: "post", data: s });
}
const ee = { __name: "enclosure-change", props: { visible: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(s, { emit: I }) {
  const i = s, y = I, u = p(), f = p(false), r = p(false), t = p(JSON.parse(JSON.stringify({ quantity: void 0, reasonId: void 0, changeRemark: void 0 })));
  U(() => i.visible, (c) => {
    c && x();
  }, { deep: true, immediate: true });
  const { visible: _, handleClose: V } = Q({ emit: y, props: i, field: "visible" });
  X(u, t);
  function x() {
    u.value && u.value.resetFields(), f.value = false, t.value.quantity = i.detailInfo.quantity, t.value.netWeight = i.detailInfo.netWeight, t.value.grossWeight = i.detailInfo.grossWeight, u.value && W(() => {
      u.value.clearValidate();
    });
  }
  const k = (c, e, d) => {
    r.value || e ? d() : d(new Error("变更后数量必须大于0"));
  };
  function w() {
    H({ title: "更改成功", type: "success" }), y("success"), V();
  }
  const q = { quantity: [{ validator: k, trigger: "change" }], reasonId: [{ required: true, message: "请选择变更原因", trigger: "change" }], changeRemark: [{ required: true, max: 200, message: "不能超过 200 个字符", trigger: "blur" }] };
  async function C(c) {
    try {
      await u.value.validate(), f.value = true, t.value.id = i.detailInfo.id, r.value && (t.value.quantity = 0), await Z(t.value), w();
    } catch (e) {
      console.log("修改构件信息", e);
    } finally {
      f.value = false;
    }
  }
  return (c, e) => {
    const d = T, N = g("common-button"), n = L, R = $, E = A, F = G, B = g("common-dialog"), S = g("router-view");
    return h(), z(M, null, [l(B, { title: "围护变更", width: "650px", modelValue: b(_), "onUpdate:modelValue": e[4] || (e[4] = (o) => J(_) ? _.value = o : null), "before-close": b(V) }, { titleRight: a(() => [l(d, { label: "强制删除", size: "default", class: "filter-item force-del", modelValue: r.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => r.value = o), border: "", style: { "border-color": "#f56c6c" } }, null, 8, ["modelValue"]), l(N, { type: "primary", size: "default", loading: f.value, onClick: C }, { default: a(() => e[5] || (e[5] = [m("确认")])), _: 1, __: [5] }, 8, ["loading"])]), default: a(() => [l(F, { ref_key: "formRef", ref: u, "label-width": "130px", size: "default", model: t.value, rules: q }, { default: a(() => [l(n, { label: "名称：" }, { default: a(() => [m(v(s.detailInfo.name), 1)]), _: 1 }), l(n, { label: "编号：" }, { default: a(() => [m(v(s.detailInfo.serialNumber), 1)]), _: 1 }), l(n, { label: "版型：" }, { default: a(() => [m(v(s.detailInfo.plate), 1)]), _: 1 }), l(n, { label: "单长(mm)：" }, { default: a(() => [m(v(s.detailInfo.length), 1)]), _: 1 }), l(n, { label: "数量：", prop: "quantity" }, { default: a(() => [l(R, { modelValue: t.value.quantity, "onUpdate:modelValue": e[1] || (e[1] = (o) => t.value.quantity = o), modelModifiers: { number: true }, "controls-position": "right", style: { width: "200px" }, min: 0, max: 999999, step: 1, "step-strictly": "" }, null, 8, ["modelValue"])]), _: 1 }), l(n, { label: "原因类型：", prop: "reasonId" }, { default: a(() => [l(b(Y), { modelValue: t.value.reasonId, "onUpdate:modelValue": e[2] || (e[2] = (o) => t.value.reasonId = o), clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), l(n, { label: "原因说明：", prop: "changeRemark" }, { default: a(() => [l(E, { modelValue: t.value.changeRemark, "onUpdate:modelValue": e[3] || (e[3] = (o) => t.value.changeRemark = o), modelModifiers: { trim: true }, type: "textarea", maxlength: 200, placeholder: "请填写原因描述", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 }), r.value ? (h(), D(n, { key: 0 }, { default: a(() => e[6] || (e[6] = [O("span", { class: "form-item-tip", style: { color: "red" } }, "* 提示：强制删除，未发运的构件皆可删除！请谨慎操作！", -1)])), _: 1, __: [6] })) : j("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]), l(S)], 64);
  };
} }, ne = P(ee, [["__scopeId", "data-v-589b45e6"]]);
export {
  ne as default
};
