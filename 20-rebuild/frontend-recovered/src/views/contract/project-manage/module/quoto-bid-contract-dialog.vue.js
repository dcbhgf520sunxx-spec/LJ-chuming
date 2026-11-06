import { ref as o } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as j } from "vue";
import { createBlock as L } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as i } from "vue";
import { withModifiers as z } from "vue";
import { createTextVNode as E } from "vue";
import { unref as v } from "vue";
import { isRef as F } from "vue";
import { ElNotification as I } from "element-plus";
import { ElFormItem as M } from "element-plus";
import { ElForm as q } from "element-plus";
import { u as D } from "../../../../shared/runtime.js";
import { g as P, a as U } from "../../../../modules/win-bid-list-285b5b2e.js";
const H = { style: { float: "right" } }, S = { class: "form" }, J = { __name: "quoto-bid-contract-dialog", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible", "refresh"], setup(b, { emit: g }) {
  const d = g, l = o(), m = o(false), u = o([]), f = o({}), y = b, { visible: n, handleClose: p } = D({ emit: d, props: y, field: "visible", showHook: h }), s = o({ id: void 0 });
  async function h() {
    var t, e;
    await ((t = l.value) == null ? void 0 : t.resetFields()), await ((e = l.value) == null ? void 0 : e.clearValidate()), await V();
  }
  const w = { id: [{ required: true, message: "请选择名称类型", trigger: "change" }] };
  async function V() {
    try {
      const t = await P();
      u.value = t || [];
    } catch (t) {
      console.log(t, "获取CRM中标项目可选列表");
    }
  }
  async function C() {
    if (await l.value.validate()) try {
      m.value = true;
      const e = await U({ ...s.value });
      f.value = e || {}, I({ title: "引入中标项目成功", type: "success" }), p(), d("refresh", f.value);
    } catch (e) {
      console.log("获取当前中标项目详情失败失败", e);
    } finally {
      m.value = false;
    }
  }
  return (t, e) => {
    const k = c("common-button"), B = c("common-select-v2"), x = M, R = q, N = c("common-dialog");
    return j(), L(N, { "append-to-body": "", "close-on-click-modal": false, "before-close": v(p), modelValue: v(n), "onUpdate:modelValue": e[1] || (e[1] = (r) => F(n) ? n.value = r : null), title: "引入中标合同", width: "600px", top: "10vh" }, { titleRight: a(() => [_("span", H, [i(k, { type: "primary", size: "default", onClick: z(C, ["stop"]) }, { default: a(() => e[2] || (e[2] = [E("确定")])), _: 1, __: [2] })])]), default: a(() => [_("div", S, [i(R, { ref_key: "formRef", ref: l, model: s.value, rules: w, size: "default", "label-width": "130px", class: "demo-form" }, { default: a(() => [i(x, { label: "CRM中标项目", prop: "id" }, { default: a(() => [i(B, { modelValue: s.value.id, "onUpdate:modelValue": e[0] || (e[0] = (r) => s.value.id = r), options: u.value, dataStructure: { value: "id", label: "projectName", key: "id" }, clearable: "", filterable: "", type: "other", placeholder: "选择中标项目", style: { width: "85%" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} };
export {
  J as default
};
