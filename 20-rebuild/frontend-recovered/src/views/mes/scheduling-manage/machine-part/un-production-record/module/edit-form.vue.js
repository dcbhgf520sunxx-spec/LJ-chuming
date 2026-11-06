import { ref as _ } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as y } from "vue";
import { createBlock as b } from "vue";
import { withCtx as t } from "vue";
import { withDirectives as z } from "vue";
import { createTextVNode as v } from "vue";
import { createVNode as a } from "vue";
import { unref as d } from "vue";
import { createElementVNode as g } from "vue";
import { toDisplayString as V } from "vue";
import { isRef as E } from "vue";
import { ElMessage as F } from "element-plus";
import { ElNotification as Q } from "element-plus";
import { ElFormItem as U } from "element-plus";
import { ElForm as j } from "element-plus";
import { vLoading as D } from "element-plus";
import { u as I, r3 as R } from "../../../../../../shared/runtime.js";
const L = { __name: "edit-form", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => ({}) } }, emits: ["update:visible", "refresh"], setup(n, { emit: w }) {
  const c = w, l = n, o = _({}), i = _(false), { visible: s, handleClose: u } = I({ emit: c, props: l, field: "visible", showHook: q });
  function q() {
    o.value = { id: l.info.id, quantity: l.info.quantity, originQuantity: l.info.quantity };
  }
  async function C(x) {
    if (o.value.quantity === o.value.originQuantity) {
      F.warning("零件数量未修改");
      return;
    }
    try {
      i.value = true, await R(o.value), Q({ type: "success", title: "撤回成功" }), u(), c("refresh");
    } catch (e) {
      console.error(e);
    } finally {
      i.value = false;
    }
  }
  return (x, e) => {
    const p = f("common-button"), r = U, k = f("common-input-number"), N = j, B = f("common-dialog"), h = D;
    return y(), b(B, { title: "编辑零件数量", modelValue: d(s), "onUpdate:modelValue": e[1] || (e[1] = (m) => E(s) ? s.value = m : null), width: "400px", "show-close": false, "before-close": d(u) }, { titleRight: t(() => [z((y(), b(p, { onClick: C, size: "default", type: "primary" }, { default: t(() => e[2] || (e[2] = [v("通过")])), _: 1, __: [2] })), [[h, i.value]]), a(p, { onClick: d(u), size: "default" }, { default: t(() => e[3] || (e[3] = [v("取消")])), _: 1, __: [3] }, 8, ["onClick"])]), default: t(() => [a(N, null, { default: t(() => [a(r, { label: "零件编号" }, { default: t(() => [g("span", null, V(n.info.serialNumber), 1)]), _: 1 }), a(r, { label: "构件编号" }, { default: t(() => [g("span", null, V(n.info.artifactSerialNumber), 1)]), _: 1 }), a(r, { label: "零件数量", prop: "quantity" }, { default: t(() => [a(k, { modelValue: o.value.quantity, "onUpdate:modelValue": e[0] || (e[0] = (m) => o.value.quantity = m), step: 1, min: 0, max: o.value.originQuantity, precision: 0, size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "max"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  L as default
};
