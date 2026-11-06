import { ref as c } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as V } from "vue";
import { createBlock as x } from "vue";
import { withCtx as l } from "vue";
import { createVNode as s } from "vue";
import { withModifiers as I } from "vue";
import { createTextVNode as B } from "vue";
import { unref as p } from "vue";
import { isRef as C } from "vue";
import { ElNotification as E } from "element-plus";
import { ElInput as j } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElForm as F } from "element-plus";
import { u as M, i as T } from "../../../../../shared/runtime.js";
import { i as U } from "../../../../../modules/cloud-cutting-assistant-43dc84e4.js";
const O = { __name: "create-order-form", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(_, { emit: b }) {
  const d = b, i = c(), r = c(false), a = _, { visible: n, handleClose: m } = M({ emit: d, props: a, field: "visible", showHook: v }), t = c({ cloudcutName: void 0 });
  async function v() {
    var o;
    t.value = {}, await ((o = i.value) == null ? void 0 : o.clearValidate());
  }
  const w = { cloudcutName: [{ required: true, message: "请填写作业名称且不多于20个字符", max: 20, trigger: "blur" }] };
  async function g() {
    try {
      if (await i.value.validate()) {
        r.value = true;
        const e = await U({ cloudcutName: t.value.cloudcutName, parentId: a.currentRow.id, workshopId: a.currentRow.workshopId });
        console.log(e, "data"), T(e) && (d("refresh", a.currentRow), E({ title: "新增成功", type: "success" }), m());
      }
    } catch (o) {
      console.log("新增失败", o);
    } finally {
      r.value = false;
    }
  }
  return (o, e) => {
    const y = f("common-button"), N = j, h = z, k = F, R = f("common-dialog");
    return V(), x(R, { "append-to-body": "", "close-on-click-modal": false, "before-close": p(m), visible: p(n), "onUpdate:visible": e[1] || (e[1] = (u) => C(n) ? n.value = u : null), title: "创建工单", width: "500px" }, { titleRight: l(() => [s(y, { loading: r.value, type: "primary", size: "default", onClick: I(g, ["stop"]) }, { default: l(() => e[2] || (e[2] = [B("保存")])), _: 1, __: [2] }, 8, ["loading"])]), default: l(() => [s(k, { ref_key: "formRef", ref: i, model: t.value, rules: w, size: "default", "label-width": "70px" }, { default: l(() => [s(h, { label: "作业名", prop: "cloudcutName" }, { default: l(() => [s(N, { modelValue: t.value.cloudcutName, "onUpdate:modelValue": e[0] || (e[0] = (u) => t.value.cloudcutName = u), modelModifiers: { trim: true }, placeholder: "填写作业名", style: { width: "100%" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} };
export {
  O as default
};
