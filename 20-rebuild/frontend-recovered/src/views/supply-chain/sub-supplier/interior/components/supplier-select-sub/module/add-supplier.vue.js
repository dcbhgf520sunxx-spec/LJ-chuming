import { useStore as h } from "vuex";
import { ref as r } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as I } from "vue";
import { createBlock as S } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as w } from "vue";
import { createTextVNode as f } from "vue";
import { ElNotification as E } from "element-plus";
import { ElInput as z } from "element-plus";
import { ElFormItem as B } from "element-plus";
import { ElForm as N } from "element-plus";
import { bH as _, lk as L } from "../../../../../../../shared/runtime.js";
const T = { style: { "text-align": "right" } }, O = { __name: "add-supplier", emits: ["close"], setup(q, { emit: g }) {
  const v = g, C = h(), i = r(), t = r(false), u = { name: "", socialCode: "", supplierClass: _.LOGISTICS.V, supplierClassification: _.LOGISTICS.V }, l = r({ ...u }), b = { name: [{ required: true, message: "请输入供应商名称", trigger: "blur" }, { min: 2, max: 32, message: "长度在 2 到 32 个字符", trigger: "blur" }], supplierClass: [{ required: true, message: "请选择供应商分类", trigger: "blur" }] };
  function V() {
    l.value = { ...u };
  }
  async function x() {
    let s = false;
    i.value.validate((e) => {
      s = e;
    });
    try {
      s && (t.value = true, await L([{ ...l.value }]), m(), V(), E({ title: "新增成功", type: "success" }), C.dispatch("config/fetchSuppliers"));
    } catch (e) {
      console.log("新增供应商", e);
    } finally {
      t.value = false;
    }
  }
  function m() {
    v("close");
  }
  return (s, e) => {
    const d = z, p = B, c = k("common-button"), y = N;
    return I(), S(y, { ref_key: "formRef", ref: i, model: l.value, rules: b, size: "default", "label-width": "100px" }, { default: a(() => [o(p, { label: "物流单位", prop: "name" }, { default: a(() => [o(d, { modelValue: l.value.name, "onUpdate:modelValue": e[0] || (e[0] = (n) => l.value.name = n), maxlength: "32", "show-word-limit": "", placeholder: "请输入供应商名称" }, null, 8, ["modelValue"])]), _: 1 }), o(p, { label: "社会统一代码", prop: "socialCode" }, { default: a(() => [o(d, { modelValue: l.value.socialCode, "onUpdate:modelValue": e[1] || (e[1] = (n) => l.value.socialCode = n), placeholder: "请输入社会统一代码", maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 }), w("div", T, [o(c, { loading: t.value, type: "primary", size: "default", onClick: x }, { default: a(() => e[2] || (e[2] = [f("提 交")])), _: 1, __: [2] }, 8, ["loading"]), o(c, { size: "default", onClick: m }, { default: a(() => e[3] || (e[3] = [f("关闭")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model"]);
  };
} };
export {
  O as default
};
